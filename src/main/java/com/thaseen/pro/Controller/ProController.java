package com.thaseen.pro.Controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.List;

import javax.sql.rowset.serial.SerialException;

import org.apache.catalina.webresources.ClasspathURLStreamHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.thaseen.pro.Entity.Product;
import com.thaseen.pro.Service.ProService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class ProController {

	 @Autowired
     private ProService proService;

     @GetMapping("/index")
     @ResponseBody
     public String hello_world(){
         return "index";
     }

     // view All Products
     @GetMapping("/")
     public ModelAndView home(){
         ModelAndView mv = new ModelAndView("index");
         List<Product> prodlist = proService.viewAllProduct();
         mv.addObject("prodlist", prodlist);
         return mv;
     }

     // add image - get
     @GetMapping("/ShowaddProduct")
   
     public String addProduct (Model model){
    	 Product product = new Product();
    	 model.addAttribute("product", product);
         return "addprod";
     }

//     @ModelAttribute("employee") Employee employee,HttpSession session
     // add image - post
     @PostMapping("/saveProduct")
     public String addImagePost(@ModelAttribute Product product,
    		 @RequestParam("image") MultipartFile file)

     {
    		try {
    		 if(file.isEmpty()) {
    			 
    			 System.out.println("Image is not Uploaded");
    			 System.out.println("File Is Empty");
    		 }
    		 
    		 else {
    			 
    			product.setImage(file.getOriginalFilename());
  
				File Sfile =  new ClassPathResource("static/img").getFile();
					
				Path path =	Paths.get(Sfile.getAbsolutePath()+File.separator+file.getOriginalFilename());
					
				Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
					
				System.out.println("Image is Uploaded");
					
				}
    		}
    		
    		 catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}    		
    			 
    		proService.saveProduct(product);
    	      
            return "redirect:/";
    		 }
    		
     			
     }
	

