package com.sam.demo;

import java.util.Map;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sam.demo.dto.Employee;
import com.sam.demo.dto.EmployeeListDo;
/** Controller for Creating the REST API 
 *  and use of @PathVariable annotation and 
 *  it use it also as collection ways
 * @author webwerks
 *
 */
@RestController
//@RequestMapping(value="/restService")
public class RESTController {

	//@ResponseBody
	public static final String EMP_PATH_MAPPING = "/getDetails";
	
	/** Method for Implementation of REST API
	 *  using Json base response and XML based response.
	 * @return
	 */
	@RequestMapping(value=EMP_PATH_MAPPING)
	public EmployeeListDo getEmpDetails1(){
		
		 EmployeeListDo employees = new EmployeeListDo();
         
	        Employee empOne = new Employee(1,"Lokesh","Gupta","howtodoinjava@gmail.com");
	        Employee empTwo = new Employee(2,"Amit","Singhal","asinghal@yahoo.com");
	        Employee empThree = new Employee(3,"Kirti","Mishra","kmishra@gmail.com");	         
	         
	        employees.getEmployees().add(empOne);
	        employees.getEmployees().add(empTwo);
	        employees.getEmployees().add(empThree);
		
		return employees;
	}
	
	/** @PathVariable annotation uses in http calling request
	 *  single or multiple request.
	 *  @PathVariable annotation is an optional to use in method
	 *  signature, it used when we need to retrieve the value of
	 *  variable in url request.
	 * @param empFName
	 * @param empLName
	 * @return
	 */
	@RequestMapping(value=EMP_PATH_MAPPING +"/{empFirstName}/{empLastName}")
	public EmployeeListDo getEmpDetails2(@PathVariable("empFirstName") String empFName,
			@PathVariable("empLastName")String empLName){				
		
		EmployeeListDo employees = new EmployeeListDo();
         
        Employee empOne = new Employee(1,"Lokesh","Gupta","howtodoinjava@gmail.com");
        empOne.setFirstName(empFName);
        empOne.setLastName(empLName);
        Employee empTwo = new Employee(2,"Amit","Singhal","asinghal@yahoo.com");
        Employee empThree = new Employee(3,"Kirti","Mishra","kmishra@gmail.com");         
         
        employees.getEmployees().add(empOne);
        employees.getEmployees().add(empTwo);
        employees.getEmployees().add(empThree);
	
		return employees;
	}
	
	/**@PathVariable annotation  using the map collection interface
	 * when we have multiple path variable in calling request.
	 * @param pathVars
	 * @return
	 */
	@RequestMapping(value="empPathVariable"+"/{empFirstName}/{empLastName}/{emailid}") 
	public EmployeeListDo getEmpDetails3(@PathVariable Map<String, String> pathVars){				
		
		EmployeeListDo employees = new EmployeeListDo();
         
        Employee empOne = new Employee(1,"Lokesh","Gupta","howtodoinjava@gmail.com");
        empOne.setFirstName(pathVars.get("empFirstName"));
        empOne.setLastName(pathVars.get("empLastName"));
        empOne.setEmail(pathVars.get("emailid"));
        Employee empTwo = new Employee(2,"Amit","Singhal","asinghal@yahoo.com");
        Employee empThree = new Employee(3,"Kirti","Mishra","kmishra@gmail.com");         
         
        employees.getEmployees().add(empOne);
        employees.getEmployees().add(empTwo);
        employees.getEmployees().add(empThree);
	
		return employees;
	}
	
	/** @RequestParam annotation uses in request
	 *  calling method, if we define the @RequestParameter
	 *  in calling method then calling request must have to 
	 *  define the same variable as define in method.
	 * @param fName
	 * @return
	 */
	@RequestMapping(value="/requestParam") 
	public EmployeeListDo getEmpDetails3(@RequestParam("firstname")String fName){				
		
		EmployeeListDo employees = new EmployeeListDo();
         
        Employee empOne = new Employee(1,"Lokesh","Gupta","howtodoinjava@gmail.com");
        empOne.setFirstName(fName);
        /*empOne.setLastName(lName);
        empOne.setEmail(pathVars.get("emailid"));*/
        Employee empTwo = new Employee(2,"Amit","Singhal","asinghal@yahoo.com");
        Employee empThree = new Employee(3,"Kirti","Mishra","kmishra@gmail.com");         
         
        employees.getEmployees().add(empOne);
        employees.getEmployees().add(empTwo);
        employees.getEmployees().add(empThree);
	
		return employees;
	}
	
	/**This method shows that how we can define the default
	 * value for the @RequestParam annotation parameter if
	 * it is null while calling, if we cannot define anything
	 * it will display the blank or null value.
	 * @param fName
	 * @param lName
	 * @return
	 */
	@RequestMapping(value="/requestParamWithNullParam") 
	public EmployeeListDo getEmpDetails3(@RequestParam("firstname")String fName,
			@RequestParam(value="lastname",defaultValue="Mr.ABCDE XYE") String lName){				
		
		EmployeeListDo employees = new EmployeeListDo();
         
        Employee empOne = new Employee(1,"Lokesh","Gupta","howtodoinjava@gmail.com");
        empOne.setFirstName(fName);
        empOne.setLastName(lName);
        /*empOne.setEmail(pathVars.get("emailid"));*/
        Employee empTwo = new Employee(2,"Amit","Singhal","asinghal@yahoo.com");
        Employee empThree = new Employee(3,"Kirti","Mishra","kmishra@gmail.com");         
         
        employees.getEmployees().add(empOne);
        employees.getEmployees().add(empTwo);
        employees.getEmployees().add(empThree);
	
		return employees;
	}
	
	/** This method state that if we have multiple
	 *  @RequestParam annotation parameter how we going to 
	 *  avoid multiple @RequestParam annotation, by defining
	 *  singleMap collection parameter instead of multiple
	 *  different @RequestParam annotation.
	 * @param requestPar
	 * @return
	 */
	@RequestMapping(value="/requestParamWithMap") 
	public EmployeeListDo getEmpDetails4(@RequestParam Map<String, String> requestPar){				
		
		EmployeeListDo employees = new EmployeeListDo();
         
        Employee empOne = new Employee(1,"Lokesh","Gupta","howtodoinjava@gmail.com");
        empOne.setFirstName(requestPar.get("fName"));
        empOne.setLastName(requestPar.get("lName"));
        empOne.setEmail(requestPar.get("emailid"));
        
        Employee empTwo = new Employee(2,"Amit","Singhal","asinghal@yahoo.com");
        Employee empThree = new Employee(3,"Kirti","Mishra","kmishra@gmail.com");         
         
        employees.getEmployees().add(empOne);
        employees.getEmployees().add(empTwo);
        employees.getEmployees().add(empThree);
	
		return employees;
	}
}
