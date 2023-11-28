package com.thaseen.pro.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.thaseen.pro.Entity.Customer;
import com.thaseen.pro.Entity.Product;
import com.thaseen.pro.Service.CustService;

import jakarta.servlet.http.HttpSession;

@Controller
public class CustController {
	
	@Autowired
	private CustService custserv;
	
	@RequestMapping("/viewDetails")
    public ModelAndView viewDetails(){
        ModelAndView mv = new ModelAndView("viewDetails");
        List<Customer> custlist = custserv.getAllCustomers();
        mv.addObject("custlist", custlist);
        return mv;
	}
	
	@GetMapping("/showNewCustomerForm")
	public String showNewCustomerForm(Model model) {
		Customer customer = new Customer();
   	 	model.addAttribute("customer", customer);
        return "addCust";
	}
	
	@RequestMapping("/addUser")
	public String addUser(Model model) {
		
		Customer customer = new Customer();
		model.addAttribute("customer", customer);
        return "addCust";
	}
	
	@PostMapping("/saveUser")
	public String saveUser(@ModelAttribute("customer") Customer customer,HttpSession session) {
//		save cust to db
		custserv.saveCustomer(customer);
		return "redirect:/viewDetails";
		
	}
	
	

}
