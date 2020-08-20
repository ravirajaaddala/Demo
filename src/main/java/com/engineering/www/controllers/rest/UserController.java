/**
 * 
 */
package com.engineering.www.controllers.rest;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.engineering.www.managers.db.JdbcTemplateManager;
import com.engineering.www.vo.UserProfile;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * @author Raviraja Addala/raviraja.addala@gmail.com
 *
 */
@RestController
@RequestMapping(value="/zcr/user")
public class UserController extends ApplicationRestController {

	@Autowired
	private JdbcTemplateManager jm ;
	
	@PostMapping("/register")
	public @ResponseBody String   add(@RequestBody UserProfile s) {
		Map<String, String> resultVO = new HashMap<String, String>();
		System.out.println("user profile = "+s.toString());
		resultVO.put("restcallstatus", s.getName()+" has been successfully registered under phone number "+s.getPhoneNumber());
		try {
			jm.addUser(s);
		}catch(Exception e) {
			resultVO.put("restcallstatus", e.getLocalizedMessage());
		}
		Gson g = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
		String jsonString = g.toJson(resultVO);
		return jsonString;
	}
}
