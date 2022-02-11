package com.ltts.bookticket.controller;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.ltts.bookticket.model.MovieBooking;
import com.ltts.bookticket.model.User;
import com.ltts.bookticket.repo.Boookinrepo;
import com.ltts.bookticket.repo.UserRepository;


@RestController
public class TicketController {
	
	int seat=500;
	int result;
	
	@Autowired
	Boookinrepo repo;

	@Autowired
	UserRepository userRepo;
	
	@GetMapping("/")
	public ModelAndView m1() {
		return new ModelAndView("index");
		}
	

	
	@RequestMapping("/booking")
	public ModelAndView m2() {
		return new ModelAndView("booking");
	}
	
	

	
	
	
	@RequestMapping("/housefull")
	public ModelAndView m4() {
		return new ModelAndView("housefull");
	}
	
	
	
	@RequestMapping("/addbooking")
	public ModelAndView m5(MovieBooking m) {
		ModelAndView mv =new ModelAndView("bookticket");
		
		List<Integer> db=repo.nticketsfinder(m.getMname(),m.getShow_m(),m.getDob(),m.getType_m());
		result = seat;
		int cost;
		for(int i:db) {
			result = result-i;
		}
		mv.addObject("seats",result);
		System.out.println(db);
		if(m.getNtickets()<=result) {
		repo.save(m);
		ModelAndView mv1 =new ModelAndView("calculatecost");
		if(m.getType_m().equals("king")) cost= (150*m.getNtickets());
		else cost=(250*m.getNtickets());
		
		mv1.addObject("cost",cost);
		return mv1 ;
		}
		else if(result==0) {
			ModelAndView mv1 =new ModelAndView("housefull");
			mv1.addObject("mname",m.getMname());
			mv1.addObject("show_m",m.getShow_m());
			mv1.addObject("dob",m.getDob());
			return mv1;
		}
		else {
			ModelAndView mv1 =new ModelAndView("error");
			mv1.addObject("seats",result);
			mv1.addObject("o_seats",m.getNtickets());
		return mv1;}
	}
	
	@GetMapping("/calcultecost")
	public void m9() {
		
	}
	
	@RequestMapping("/calculate")
	public int m6(@RequestParam String type_m,int ntickets) {
		ModelAndView mv= new ModelAndView("calculatecost");
		if(type_m.equals("king"))return (150*ntickets);
		else return(250*ntickets);
	}
	
	
	@RequestMapping("/available")
	public ModelAndView m7() {
		return new ModelAndView("available");
		
	}
	
	@RequestMapping("/remseats")
	public ModelAndView m8(@RequestParam String mname,String show_m,Date dob,String type_m) {
		ModelAndView mv= new ModelAndView("remseats");
		result=seat;
		List<Integer> db=repo.nticketsfinder(mname,show_m,dob,type_m);
		for(int i:db) {
			result = result-i;
		}
		
		mv.addObject("result",result);
		return mv;
		
	}

}
