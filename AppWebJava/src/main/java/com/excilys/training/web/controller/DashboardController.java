package com.excilys.training.web.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.excilys.training.model.Computer;

@Controller
@RequestMapping("/dashboard")
public class DashboardController extends AbstractController{
	
	
	@RequestMapping(method = RequestMethod.GET)
	  public String doGet(Locale locale,@RequestParam(required=false,name="search") String searchReq, @RequestParam(required=false,name="page") String page, Model model) throws SQLException {
		
		Locale currentLocale = LocaleContextHolder.getLocale();
        model.addAttribute("locale", currentLocale);
		List<Computer> computers = new ArrayList<Computer>();
		boolean search = searchReq != null && searchReq != "" ? true : false;
	    int nbPc;
	    if (search) {
	    	int nombreValeurParPage = 1;
	    	int queryPage = page != null ? Integer.parseInt(page) : 1;
	        computers = getServiceFactory().getComputerService().searchComputerByName(searchReq, searchReq, nombreValeurParPage, (queryPage-1)*nombreValeurParPage);
	        nbPc = computers.size();
	    } else {
	    	int nombreValeurParPage = 50;
	    	int queryPage = page != null ? Integer.parseInt(page) : 1;
	    	System.out.print(getServiceFactory());
	    	computers = getServiceFactory().getComputerService().displayComputersPagination(nombreValeurParPage, (queryPage-1)*nombreValeurParPage);
	    	nbPc = getServiceFactory().getComputerService().countAllComputers();
	    	
	
	    }
	    model.addAttribute("list", computers);
	    int pageSize = computers.size();
	    int divider = pageSize != 0 ? pageSize : 1;
	    int nbPage = nbPc / divider;
	    model.addAttribute("size", nbPc);
	    model.addAttribute("nbPages", nbPage);
	    model.addAttribute("searchAttri", searchReq);

	    return "dashboard";
	   
	  }

}
