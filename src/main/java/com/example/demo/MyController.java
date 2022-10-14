package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MyController 
{
	@Autowired
	ProductService service;
	@RequestMapping("/")
  public String showhomepage(Model model)
  {
		System.out.println("***Display is called****");
		List<Product> list=service.displayData();
		for(Product p:list)
		{
			System.out.println(p.getId()+"  "+p.getName());
		}
		model.addAttribute("abc",list);
	return "index";
  }
	@RequestMapping("/addData")
	public String newData(Model model)
	{
		Product product=new Product();
		model.addAttribute("product",product);
		return "add_pro";
		
	}
	@RequestMapping(value="/save",method = RequestMethod.POST)
	public String saveAfter(@ModelAttribute("product") Product product)
	{
		service.saveProduct(product);
		return "redirect:/";
	}
	@RequestMapping("/edit/{id}")
	public ModelAndView editData(@PathVariable(name = "id")int id)
	{
		ModelAndView modelAndView=new ModelAndView("edit");
		Product product=service.getProd(id);
		modelAndView.addObject("product",product);
		return modelAndView;
	}
	@RequestMapping("/delete/{id}")
	public String deleteData(@PathVariable(name= "id") int id)
{
	service.delete(id);
	return "redirect:/";
	}
}
