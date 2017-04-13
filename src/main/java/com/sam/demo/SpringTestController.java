package com.sam.demo;

import java.sql.Date;
import java.text.SimpleDateFormat;

import javax.validation.Valid;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.sam.demo.dto.Student;
import com.sam.demo.dto.StudentNameEditor;

@Controller
public class SpringTestController {
	/** This method allow all the property to bind except below mentioned 
	 *  property in setDisallowedFiels() setter method of WebDataBinder
	 *  class.
	 * @param binder
	 */
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		//binder.setDisallowedFields(new String[] {"studentMobile"});
		
		//Edit the date of customize format
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		binder.registerCustomEditor(Date.class, "studentDOB", new CustomDateEditor(dateFormat, false));
		binder.registerCustomEditor(String.class, "studentName",new StudentNameEditor());
		
	}
	

	@RequestMapping(value="/welcomeAdmission", method=RequestMethod.GET)
	public ModelAndView getAdmissionForm(){
		ModelAndView modelAndView = new ModelAndView("/springtest/AdmissionForm");
		//modelAndView.addObject("headerMessage","Raisoni College of Engineering, India");
		return modelAndView;		
	}
	
	/** Here Below Method are state that how to use 
	 *  @ModelAttribute at method level, its make an object common
	 *  for all method where ever we used it.
	 *  Below Example having the headerMessage as an common object
	 *  for both the method, it can reduce to write the code separately.
	 *  
	 *  IMP NOTE:
	 *  This Method call first before the all method of this controller
	 *    
	 * @param model1
	 */
	
	@ModelAttribute
	public void addingCommonObject(Model model1){
		model1.addAttribute("headerMessage", "Raisoni College of Engineering, India");
	}
	
	/** Method Implementation of use of @ModelAttribute Annotation
	 *  using method arguments.
	 * @param student1
	 * @return
	 */
	@RequestMapping(value="/admissionForm", method = RequestMethod.POST)
	public ModelAndView submitAdmissionForm(@ModelAttribute("student1") Student student1){		
		ModelAndView modelAndView = new ModelAndView("/springtest/AdmissionSuccess");
		//modelAndView.addObject("headerMessage","Raisoni College of Engineering, India");
		return modelAndView;
	}
	
	
	
	@RequestMapping(value="/welcomeReg", method=RequestMethod.GET)
	public ModelAndView getAdmissionForm2(){
		ModelAndView modelAndView = new ModelAndView("/springtest/AdmissionForm2");
		//modelAndView.addObject("headerMessage","Raisoni College of Engineering, India");
		return modelAndView;		
	}
	
	/** we will learn how to use data binding with a user-defined type. 
	 * In addition to it, we will also go through the concept of 
	 * BindingResult provided by Spring MVC to handle all data binding 
	 * related errors.
	 */
	@RequestMapping(value="/registrationsubmit",method = RequestMethod.POST)
	public ModelAndView registrationform(@Valid @ModelAttribute("student1") Student student1,BindingResult result){
		
		if(result.hasErrors()){
			ModelAndView modelAndView = new ModelAndView("/springtest/AdmissionForm2");
			return modelAndView;
		}
		ModelAndView modelAndView = new ModelAndView("/springtest/AdmissionSuccess2");
		return modelAndView;
	}
}
