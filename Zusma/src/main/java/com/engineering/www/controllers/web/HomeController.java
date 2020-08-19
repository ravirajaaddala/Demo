/**
 * 
 */
package com.engineering.www.controllers.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author Raviraja Addala/raviraja.addala@gmail.com
 *
 */
@Controller
@RequestMapping(value="/zcw")
public class HomeController extends ApplicationWebController {

	@GetMapping("/greetings")
	public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
		model.addAttribute("name", name);
		return "greeting";
	}
	
	@GetMapping("/jq")
	public String jq() {
		return "html/jqexample";
	}
	
	@GetMapping("/home")
	public String home() {
		return "html/ZusmaHome";
	}
	

	@GetMapping("/refer")
	public String refer() {
		return "html/Referral";
	}
	

	@GetMapping("/pickup")
	public String pickup() {
		return "html/Schedule";
	}
	
	@GetMapping("/dronagiri")
	public String dronagiri() {
		return "html/Dronagiri";
	}
	
	@GetMapping("/sanjeevani")
	public String sanjeevani() {
		return "html/Sanjeevani";
	}
	
	@GetMapping("/register")
	public String registration() {
		return "html/Registration";
	}
	
}
