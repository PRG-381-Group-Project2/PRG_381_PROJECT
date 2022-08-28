package net.javaguides.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import net.javaguides.springboot.model.Adminstrator;
import net.javaguides.springboot.service.AdminstratorService;

@Controller
public class AdminController {

	@Autowired
	private AdminService adminService;

	// display list of Adminstrators
	@GetMapping("/")
	public String viewHomePage(Model model) {
		return findPaginated(1, "AdminName", "asc", model);		
	}
	
	@GetMapping("/showNewAdministratorForm")
	public String showNewAdministratorForm(Model model) {
		// create model attribute to bind form data
		AdminCredentials admin = new AdminCredentials();
		model.addAttribute("Administrator", admin);
		return "new_administrator";
	}
	
	@PostMapping("/saveAdministrator")
	public String saveAdministrator(@ModelAttribute("Administrator") AdminCredentials admin) {
		// save Admin to database
		adminService.saveAdministrator(admin);
		return "redirect:/";
	}
	
	@GetMapping("/showFormForUpdate/{id}")
	public String showFormForUpdate(@PathVariable ( value = "id") long id, Model model) {
		
		// get Adminfrom the service
		Adminstrator Adminstrator = AdminstratorService.getAdminstratorById(id);
		
		// set Adminstrator as a model attribute to pre-populate the form
		model.addAttribute("Adminstrator", Adminstrator);
		return "update_Adminstrator";
	}
	
	@GetMapping("/deleteAdminstrator/{id}")
	public String deleteAdministrator(@PathVariable (value = "id") long id) {
		
		// call delete Adminstrator method 
		this.AdminstratorService.deleteAdminstratorById(id);
		return "redirect:/";
	}
	
	
	@GetMapping("/page/{pageNo}")
	public String findPaginated(@PathVariable (value = "pageNo") int pageNo, 
			@RequestParam("sortField") String sortField,
			@RequestParam("sortDir") String sortDir,
			Model model) {
		int pageSize = 5;
		
		Page<Adminstrator> page = adminService.findPaginated(pageNo, pageSize, sortField, sortDir);
		List<Adminstrator> listAdminstrators = page.getContent();
		
		model.addAttribute("currentPage", pageNo);
		model.addAttribute("totalPages", page.getTotalPages());
		model.addAttribute("totalItems", page.getTotalElements());
		
		model.addAttribute("sortField", sortField);
		model.addAttribute("sortDir", sortDir);
		model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");
		
		model.addAttribute("listAdminstrators", listAdminstrators);
		return "index";
	}
}
