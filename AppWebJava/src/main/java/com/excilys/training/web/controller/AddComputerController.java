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
@RequestMapping("/addComputer")
public class AddComputerController extends AbstractController{
	
	@RequestMapping(method = RequestMethod.GET)
	  public String get(Model model) throws SQLException {
	    List<Company> companies = getServiceFactory().getCompanyService().displayAllCompany();
	    model.addAttribute("companies", companies);
	    return "addComputer";
	  }
	
	@RequestMapping(method = RequestMethod.POST)
	  public String post(@RequestParam("name") String name,
	      @RequestParam("introduced") String introduced,
	      @RequestParam("discontinued") String discontinued,
	      @RequestParam("companyId") String companyId, Model model) throws SQLException {

	    String jsp = "dashboard";
	    ComputerDTOBuilder computerDto = new ComputerDTO.ComputerDTOBuilder(name, introduced, discontinued, companyId );
	    ComputerMapper computerMapper = new ComputerMapper();
	    getServiceFactory().getComputerService().createNewComputer(computerMapper.computerDtoToComputer(computerDto.build()));

	    return jsp;
	  }
	
}
