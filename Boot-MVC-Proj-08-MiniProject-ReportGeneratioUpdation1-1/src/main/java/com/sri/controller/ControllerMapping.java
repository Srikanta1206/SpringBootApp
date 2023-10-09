package com.sri.controller;

import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sri.entity.Employee;
import com.sri.service.IEmployeeServiceMgmt;
import com.sri.validator.ValdatorClass;

@Controller
public class ControllerMapping {

	@Autowired
	private IEmployeeServiceMgmt service;

	@Autowired
	private ValdatorClass validator;

	@GetMapping
	public String getMapping() {
		return "home";
	}

	/*
	 * @GetMapping("/emp_list") public String getFormMapping(Map<String, Object>
	 * map) { // Fetching all emp details List<Employee> List<Employee >emplist =
	 * service.fetchEmployeeList(); // add emp report in model Attribute
	 * map.put("emplist", emplist);
	 * 
	 * return "emp_report"; }
	 */

	@GetMapping("/emp_list")
	public String getFormMapping(@PageableDefault(size = 3, page = 0, sort = "sal", direction = Direction.ASC) Pageable pageable,
			Map<String, Object> map) {
		Page<Employee> pagedata = service.getPageDate(pageable); 
		// set in BindingAwareModelObj
		map.put("empdata", pagedata);
		return "emp_report";
	}

	@GetMapping(path = { "/add_employee", "/add_emp" })
	public String addEmpMappingDetail(Map<String, Object> map, @ModelAttribute Employee emp, BindingResult errors) {
		/*
		 * if(validator.supports(emp.getClass())) { validator.validate(emp, errors); }
		 * if(errors.hasErrors()) { return "add_emp_report"; }
		 */
		map.put("employee", emp);
		// return LVN
		return "add_emp_report";
	}

	@PostMapping("/addEmpRecord")
	public String addEmpRecord(@ModelAttribute Employee emp, BindingResult result) {
		if (validator.supports(emp.getClass())) {
			validator.validate(emp, result);
		}
		if (result.hasErrors()) {
			return "add_emp_report";
		}
		// connect to service layer
		service.addEntity(emp);
		return "redirect:emp_list";
	}

	// Edit Employee Details
	@GetMapping("/edit_employee")
	public String editEmpDetails(@RequestParam("eno") int no, @ModelAttribute Employee employee) {
		Employee emp = service.searchEmpById(no);

		// Copy model class properties
		BeanUtils.copyProperties(emp, employee);
		return "update_emp";
	}

	@PostMapping("/update_detail")
	public String updatedEmpRecord(RedirectAttributes attributes, @ModelAttribute("employee") Employee emp,
			BindingResult result) {
		if (validator.supports(emp.getClass())) {
			validator.validate(emp, result);
		}
		if (result.hasErrors()) {
			return "update_emp";
		}

		String res = service.updateEmpDetails(emp);
		// set in redirect Scope
		attributes.addFlashAttribute("ResultMsg", res);
		// redirect to request path emp_list
		return "redirect:emp_list";
	}

	@GetMapping("/delete_employee")
	public String deleteEmployeeRecord(@RequestParam("eno") int eno, RedirectAttributes attributes) {
		// contact to service layer
		String resultMsg = service.deleteEmpDetails(eno);
		attributes.addFlashAttribute("ResultMsg", resultMsg);
		System.out.println("redirect");
		// redirect to emp_report
		return "redirect:emp_list";
	}
}
