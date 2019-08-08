package com.excilys.training.web.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.excilys.training.model.Company;
import com.excilys.training.web.dto.ComputerDTO;
import com.excilys.training.web.dto.ComputerDTO.ComputerDTOBuilder;
import com.excilys.training.web.mapper.ComputerMapper;

@Controller
@RequestMapping("/editComputer")
public class EditComputerController extends AbstractController{
	
	
	  @RequestMapping(method = RequestMethod.GET)
	  public String doGet(@RequestParam("computerId") String id, @RequestParam("computerName") String name,
		      @RequestParam("computerIntroduced") String introduced, @RequestParam("computerDiscontinued") String discontinued,
		      @RequestParam("companyName") String companyName, Model model) throws SQLException {
		List<Company> companies = getServiceFactory().getCompanyService().displayAllCompany();
	    model.addAttribute("id", id);
	    model.addAttribute("name", name);
	    model.addAttribute("introduced", introduced);
	    model.addAttribute("discontinued", discontinued);
	    model.addAttribute("companyName", companyName);
	    model.addAttribute("companies", companies);
	    return "editComputer";
		
	}
	  
	  @RequestMapping(method = RequestMethod.POST)
	  public String post(@RequestParam("oldName") String oldName, @RequestParam("name") String name,
	      @RequestParam("introduced") String introduced,
	      @RequestParam("discontinued") String discontinued,
	      @RequestParam("companyId") String companyId, Model model) throws SQLException {

	    String jsp = "dashboard";
	    ComputerDTOBuilder computerDto = new ComputerDTO.ComputerDTOBuilder(name, introduced, discontinued, companyId );
	    ComputerMapper computerMapper = new ComputerMapper();
	    getServiceFactory().getComputerService().updateComputer(computerMapper.computerDtoToComputer(computerDto.build()));
	    
	    return jsp;
	  }
}
