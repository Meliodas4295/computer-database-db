package com.excilys.training.web.controller;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/deleteComputer")
public class DeleteComputerController extends AbstractController{
	
	@RequestMapping(method = RequestMethod.GET)
	  public ModelAndView get() {
	    return new ModelAndView("dashboard");
	  }

	  @RequestMapping(method = RequestMethod.POST)
	  public ModelAndView post(@RequestParam(required=false, name="selection") String[] selection) throws NumberFormatException, SQLException {
	    List<String> items = Arrays.asList(selection);
	    System.out.println(items.get(0));
	    for (String item : items) {
	      getServiceFactory().getComputerService().deleteComputer(Integer.valueOf(item));
	    }
	    return new ModelAndView("redirect:dashboard");
	  }
}
