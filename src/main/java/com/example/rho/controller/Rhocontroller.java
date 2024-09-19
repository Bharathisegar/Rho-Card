package com.example.rho.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.example.rho.model.Applypage;
import com.example.rho.model.RhoUsers;
import com.example.rho.service.Rhoservice;
import com.example.rho.service.applyuserservice;

@Controller
public class Rhocontroller {
	
	@Autowired
	Rhoservice objservice;
	
	@Autowired
	applyuserservice applyservice;
	
	@GetMapping("/signup")
	public ModelAndView saveuser(@RequestParam("name")String name,@RequestParam("email")String email,
			@RequestParam("password")String password)
	{
		objservice.usersave(name, email, password);
		System.out.println("Hi Everyone");
		
		ModelAndView objmv = new ModelAndView();
		objmv.setViewName("regsuccessfull");
				
		return objmv;
	}
	
	  @PostMapping("/login")
	    public ModelAndView login(@RequestParam("email") String email, 
	                              @RequestParam("password") String password) {
	        ModelAndView modelAndView = new ModelAndView();

	        if (objservice.validateUser(email, password)) {
	            modelAndView.setViewName("online banking"); // Redirect to main page if login is successful
	        } else {
	            modelAndView.setViewName("ErrorLogin"); // Redirect back to login page if authentication fails
	            modelAndView.addObject("error", "Invalid username or password");
	            System.out.println("Error occured");
	        }
	        return modelAndView;
	    }
	  
	  @PostMapping("/save")
	  public ModelAndView applysave(Applypage a)
	  {
		  applyservice.save(a);
		  
		  ModelAndView objmv=new ModelAndView();
		  objmv.setViewName("appsuccess");
		  
		
		  
		  objmv.addObject("user", a);
		  
		  return objmv;
		  
	  }
	  
		@GetMapping("/list/details")
		private ModelAndView GetView(@RequestParam("id") String id)
		{
			
			
			ModelAndView objmv = new ModelAndView();
			
			objmv.setViewName("Userview");
			
			Applypage objlogin = applyservice.getdata(id);
			
			objmv.addObject("data",objlogin);
			
			return objmv;
			
			
		}
	  
	  @GetMapping("/getalluser")
	  public ModelAndView GetEmployee()
		{
			ArrayList<Applypage> objlist = (ArrayList<Applypage>) applyservice.getallUser();
			
			ModelAndView objmv = new ModelAndView();
			
			objmv.setViewName("Fulldata");
			
			objmv.addObject("data",objlist);
			
			return objmv;
		}
		
	  @GetMapping("/list/users")
		public ModelAndView GetView1(@RequestParam("id") String id)
		{
			
			
			ModelAndView objmv = new ModelAndView();
			
			objmv.setViewName("loginuser");
			
			RhoUsers objlogin = objservice.getdata(id);
			
			objmv.addObject("card",objlogin);
			
			return objmv;			
		}
	  
	  @GetMapping("/getall")
	  public ModelAndView Get()
		{
			ArrayList<RhoUsers> objlist = (ArrayList<RhoUsers>) objservice.getallUsers();
			
			ModelAndView objmv = new ModelAndView();
			
			objmv.setViewName("loggedindetails");
			
			objmv.addObject("data",objlist);
			
			return objmv;
		}
		
		
	@GetMapping("/apply")
	public String applied()
	{
		return "applynow";
	}
	
	
	@GetMapping("/")
	public String signuppage()
	{
		return "sign up";
	}
	
	@GetMapping("/successfull")
	public String success()
	{
		return "regsuccessfull";
	}
	
	@GetMapping("/loginpage")
	public String login()
	{
		return "Login";
	}
	
	@GetMapping("/admorcus")
	public String aorc()
	{
		return "admorcus";
	}
	
	@GetMapping("/admin")
	public String adminpage()
	{
		return "adminlogin";
	}
	
	@GetMapping("/online")
	public String banking()
	{
		return "online banking";
	}
	
	@GetMapping("/cards")
	public String mycards()
	{
		return "cardtypes";
	}
	
	@GetMapping("/about")
	public String myabout()
	{
		return "Aboutus";
	}
	
	@GetMapping("/contact")
	public String contactme()
	{
		return "Contactus";
	}
	
	@GetMapping("/error")
	public String errorpage()
	{
		return "ErrorLogin";
	}
	
	@GetMapping("/view")
	public String users()
	{
		return "Userview";
	}
	
	@GetMapping("/alldata")
	public String datas()
	{
		return "Fulldata";
	}
	
	@GetMapping("/loguser")
	public String adminloguser()
	{
		return "logoruser";
	}
	
	@GetMapping("/loggedin")
	public String loginuser()
	{
		return "loginuser";
	}
	
	@GetMapping("/logindetails")
	public String detailsin()
	{
		return "loggedindetails";
	}
}
