package com.excilys.training.web.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.excilys.training.core.Company;
import com.excilys.training.binding.dto.ComputerDTO;
import com.excilys.training.binding.dto.ComputerDTO.ComputerDTOBuilder;
import com.excilys.training.binding.mapper.ComputerMapper;

@Controller
@RequestMapping("/editComputer")
public class EditComputerController extends AbstractController{
	
	
	  @RequestMapping(method = RequestMethod.GET)
	  public ModelAndView doGet(@RequestParam(required=false,name="computerId") String id, @RequestParam(required=false,name="computerName") String name,
		      @RequestParam(required=false,name="computerIntroduced") String introduced, @RequestParam(required=false,name="computerDiscontinued") String discontinued,
		      @RequestParam(required=false,name="companyName") String companyName, Model model) throws SQLException {
		List<Company> companies = getServiceFactory().getCompanyService().displayAllCompany();
	    model.addAttribute("id", id);
	    model.addAttribute("name", name);
	    model.addAttribute("introduced", introduced);
	    model.addAttribute("discontinued", discontinued);
	    model.addAttribute("companyName", companyName);
	    model.addAttribute("companies", companies);
	    return new ModelAndView("editComputer");
		
	}
	  
	  @RequestMapping(method = RequestMethod.POST)
	  public ModelAndView post(@RequestParam(required=false,name="computerId") String id, @RequestParam(required=false,name="computerName") String name,
	      @RequestParam(required=false,name="introduced") String introduced,
	      @RequestParam(required=false,name="discontinued") String discontinued,
	      @RequestParam(required=false,name="companyId") String companyId, Model model) throws SQLException {

		
	    ComputerDTOBuilder computerDto = new ComputerDTO.ComputerDTOBuilder(name, introduced, discontinued, companyId ).id(Integer.valueOf(id));
	    ComputerMapper computerMapper = new ComputerMapper();
	    getServiceFactory().getComputerService().updateComputer(computerMapper.computerDtoToComputer(computerDto.build()));
	    
	    return new ModelAndView("redirect:dashboard");
	  }
}
