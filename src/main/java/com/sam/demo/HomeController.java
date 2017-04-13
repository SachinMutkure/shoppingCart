package com.sam.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sam.demo.dto.ProductDto;
import com.sam.demo.model.ProductEntity;
import com.sam.demo.model.UserRegistrationEntity;
import com.sam.demo.service.ShoppingCartService;
import com.sam.demo.utility.CandidateDetails;
import com.sam.demo.utility.ConstantUtil;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	private static final Logger LOG = LoggerFactory.getLogger(HomeController.class);
	private static final String PRODUCT_MAPPING = "/product";
	private static final String CATEGORY_MAPPING = "/category";

	/**
	 * Simply selects the home view to render by returning its name.
	 */

	@Autowired
	private ShoppingCartService shoppingCartService;
		
	@Autowired
	public HttpSession httpSession;
	
	@Autowired
	public ProductDto productDto;

	@RequestMapping(value = { "/", "/welcome" }, method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
			
		LOG.info("Welcome home! The client locale is {}.", locale);
		model.addAttribute("Categorylist", shoppingCartService.getCategoryList());
		productDto.setCategoryName("Set category name:Sachin");
		System.out.println(productDto.getCategoryName());
		UserRegistrationEntity auth = (UserRegistrationEntity) httpSession.getAttribute("userAuthentication");
		LOG.info("User Authentication:" + auth);
		
		if (auth != null) {
			model.addAttribute("username", auth.getEmailId());
			model.addAttribute("cartCount", shoppingCartService.getProductCartCount(auth.getId()));
		}
		model.addAttribute("user", auth);
		return "home";
	}

	/**
	 * Method to get Product by categoryId
	 * 
	 * @param categoryId
	 * @return
	 */
	@RequestMapping(value = "/getProductByCategory", method = RequestMethod.POST)
	public @ResponseBody List<ProductDto> getProductbyCategory(@RequestParam(value = "categoryId") Integer categoryId) {
		LOG.info("Inside the getProduct By category:");
		List<ProductDto> lst = shoppingCartService.getProductByCategory(categoryId);
		for (ProductDto obj : lst) {
			System.out.println("id :" + obj.getId() + " Product Name :" + obj.getProductName());
		}
		LOG.info("Product List :" + lst);
		return lst;
	}

	@RequestMapping(value = "/viewProducts", method = RequestMethod.GET)
	public String getAllProductwithCategory(Model model) {
		List<ProductDto> lst = shoppingCartService.getProductList();
		model.addAttribute("Categorylist", shoppingCartService.getCategoryList());
		model.addAttribute("productList", lst);		
		return "viewproduct";
	}

	@RequestMapping(value = "/updateProduct", method = RequestMethod.POST)
	public String updateProduct(@ModelAttribute ProductDto product,
			RedirectAttributes redirectAttributes) {
		LOG.info("Inside the updateProduct Method:");

		boolean status = shoppingCartService.updateProduct(product);
		if (status = true) {
			//redirectAttributes.addFlashAttribute("status", "Update Successffull");
			return "redirect:/viewProducts";
		} else {
			redirectAttributes.addFlashAttribute("status", "Update Unsuccessfull");			
			return "redirect:/viewProducts";
		}
	}

	@RequestMapping(value = "/addToCart", method = RequestMethod.GET)
	public String addToCart(@RequestParam(value = "id") Integer productId, Model model,
			RedirectAttributes redirectAttributes) {
		LOG.info("Inside the add to cart method:");
		UserRegistrationEntity auth = (UserRegistrationEntity) httpSession.getAttribute("userAuthentication");
		LOG.info("User Authentication:" + auth);

		if (auth != null) {
			
			if(shoppingCartService.isProductExist(auth.getId(), productId) == null){		
			
				Integer status = shoppingCartService.addToCart(productId, auth.getId());
				if (status == 0) {
					redirectAttributes.addFlashAttribute("cartMessage", "Failed added into cart...");
				} else {
					redirectAttributes.addFlashAttribute("cartMessage", "One product added into cart...");
				}
				return "redirect:/";
			}else{
				redirectAttributes.addFlashAttribute("cartMessage", "You have allready cart this product...");
				return "redirect:/";
			}
		} else {
			return "redirect:/login";
		}
	}

	@RequestMapping(value = "/showCart", method = RequestMethod.GET)
	public String showCartProduct(Model model) {
		LOG.info("Inside Show Cart Product List:");
		UserRegistrationEntity auth = (UserRegistrationEntity) httpSession.getAttribute("userAuthentication");
		model.addAttribute("productList", shoppingCartService.getCartProductList(auth.getId()));
		return "addCartProduct";
	}

	@RequestMapping(value="/removeCart",method=RequestMethod.GET)
	public String removeCart(@RequestParam(value="id") Integer cartId,RedirectAttributes redirectAttributes){
		LOG.info("Inside removeCart Method :");
		boolean status = shoppingCartService.removeCart(cartId);
		if(status == true){
			redirectAttributes.addFlashAttribute("message", "One record deleted...");
			return "redirect:/showCart";	
		}else{
			redirectAttributes.addFlashAttribute("message", "Delete not successfull...");
			return "redirect:/showCart";
		}		
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout() {
		httpSession.invalidate();
		return "redirect:/";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login(@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout) {

		ModelAndView model = new ModelAndView();
		if (error != null) {
			model.addObject("error", "Invalid username and password!");
		}

		if (logout != null) {
			model.addObject("msg", "You've been logged out successfully.");
		}
		model.setViewName("login");

		return model;
	}

	/** Method to register user details with its credentials */
	@RequestMapping(value = "/addUser", method = RequestMethod.POST)
	public String addUserRegistration(@ModelAttribute("register") UserRegistrationEntity obj,
			RedirectAttributes redirectAttributes) {
		Integer status = shoppingCartService.addUser(obj);
		if (status == 0) {
			redirectAttributes.addFlashAttribute("message", "Failed to register...");
		} else {
			redirectAttributes.addFlashAttribute("message", "Registration Successfull...");
		}
		return "redirect:/registration";
	}

	@RequestMapping(value = "/registration", method = RequestMethod.GET)
	public String registrationPage() {
		return "register";
	}

	/** Method to Display category Page */
	@RequestMapping(value = CATEGORY_MAPPING, method = RequestMethod.GET)
	public String category() {
		LOG.info("Inside the category() Method");
		return "addcategory";
	}

	/** Method for display call product page */
	@RequestMapping(value = PRODUCT_MAPPING, method = RequestMethod.GET)
	public String productHome(Model model) {
		LOG.info("Inside the productHome Method");
		model.addAttribute("Categorylist", shoppingCartService.getCategoryList());
		return "addproduct";
	}

	/** Method for add product into db */
	@RequestMapping(value = PRODUCT_MAPPING + "/add", method = RequestMethod.POST)
	public String addProduct(@ModelAttribute("product") ProductEntity obj, RedirectAttributes redirectAttributes) {

		LOG.info("Inside AddProduct Method:");
		Integer status = shoppingCartService.addProduct(obj);

		if (status == 0) {
			redirectAttributes.addFlashAttribute("message", "Failed to save...");
			return "redirect:" + PRODUCT_MAPPING;

		} else {
			redirectAttributes.addFlashAttribute("message", "Saved Successfull...");
			return "redirect:" + PRODUCT_MAPPING;
		}
	}

	/** Method to add category **/
	@RequestMapping(value = "/addCategory", method = RequestMethod.POST)
	public @ResponseBody String addCategory(@RequestParam("category") String category) {
		LOG.info("Inside the addCategory Method" + category);
		Integer i = shoppingCartService.addCategory(category);
		if (i == 0) {
			return "Failed...";
		} else {
			return "Success...";
		}
	}

	@RequestMapping(value = "/viewcategory", method = RequestMethod.GET)
	public String viewCategory(Model model) {
		LOG.info("Inside the viewCategory method:");
		model.addAttribute("Categorylist", shoppingCartService.getCategoryList());
		return "viewcategory";
	}

	@RequestMapping(value = "/updateCategory", method = RequestMethod.POST)
	public String updateCategory(@RequestParam(value = "id") Integer id,
			@RequestParam(value = "categoryName") String categoryName, RedirectAttributes redirectAttributes) {
		LOG.info("Inside updateCategory :");
		boolean status = shoppingCartService.updateCategory(id, categoryName);
		if (status = true) {
			//redirectAttributes.addFlashAttribute("status", "Update Sucessfull...");
			return "redirect:/viewcategory";
		} else {
			redirectAttributes.addFlashAttribute("status", "Update Unsucessfull...");
			return "redirect:/viewcategory";
		}
	}

	@RequestMapping(value = "/viewexcel", method = RequestMethod.GET)
	public String viewExcel(Model model) {
		LOG.info("Inside the viewExcel method:");		
		return "excelsheet";
	}

	
	@RequestMapping(value="/downloadexcel",method = RequestMethod.GET)
	public ModelAndView downloadExcelSheet(ModelMap map){
		 List<CandidateDetails> admissionEntranceStudentEntity =
		            new ArrayList<CandidateDetails>();
		 admissionEntranceStudentEntity.add(new CandidateDetails( "Male", "Vikki",
		    "Shridhar", "Shukla", "919898989898", "test@gmail.com"));

		    map.addAttribute("excelModel", admissionEntranceStudentEntity);
		    map.addAttribute("excelReportName", ConstantUtil.EXCEL_SAMPLE_DOWNLOAD);
		    map.addAttribute("headerInfo", ConstantUtil.EXCEL_SAMPLE_HEADER);
		    return new ModelAndView("excelView", "excelModel", admissionEntranceStudentEntity);		
	}
}
