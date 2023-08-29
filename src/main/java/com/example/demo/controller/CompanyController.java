package com.example.demo.controller;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import com.example.demo.dao.CompanyInt;
import com.example.demo.model.Company;

	@Controller
	@SessionAttributes({ "compid" })
	public class CompanyController {
		@Autowired
		CompanyInt impl;
		
		@Autowired
		Company company ;

		@GetMapping("companylogin")
		public String compLogin() {
			return "companylogin";
		}

		@PostMapping("companyview")
		public ModelAndView compDetails(
					@RequestParam("compid") String compid,
					@RequestParam("compname") String compname,
					@RequestParam("compemail") String compemail,
					@ModelAttribute Company comp) 
		{
			ModelAndView mv = new ModelAndView();
			//sent data to next page
			mv.addObject("compid", comp.getCompid());
			mv.addObject("compname", comp.getCompname());
			mv.addObject("compemail", comp.getCompemail());
			mv.setViewName("CompanyView");
			
			
			//gettng data from dB and print it
			Integer compid1 = comp.getCompid();
			System.out.println("The id is :" + compid1);
			String compname1 =comp.getCompname();
			System.out.println("The name is :" + compname1);
			String compemail1 = comp.getCompemail();
			System.out.println("The email is :" + compemail1);
			//store data into DB
			impl.save(comp);
			//Optional<company>= optionProduct
			Optional<Company> optionalCompany;
			//searching by company ID
			optionalCompany=impl.findById(Integer.parseInt(compid));
			comp=optionalCompany.get();
			 mv.addObject("data",comp);
			//use collection list to fetch all data
			 List<Company> list= List.of(company);
			Iterable<Company> result=impl.saveAll(list);
			result.forEach(user->{System.out.println(user);});
					
					 
			
			System.out.println("this is the table DATA entered recent:"
			+comp.getCompid()+" "+comp.getCompname()+" "+comp.getCompemail());	
			 Iterable<Company> company = impl.findAll();
			 //console output,
			 // get or retrieve all products
			 company.forEach((p) -> {System.out.println(p.getCompid()+"	"+p.getCompname()+"	"+p.getCompemail());
		            impl.saveAll(company);
		            
		        });
			
			return mv;
			
		}

		@GetMapping("companysessionview")
		public String compSession() {

			return "CompanySessionView";
		}
	}


