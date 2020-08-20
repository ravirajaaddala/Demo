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
import com.engineering.www.vo.Refer;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * @author Raviraja Addala/raviraja.addala@gmail.com
 *
 */
@RestController
@RequestMapping(value="/zcr/refer")
public class ReferralController extends ApplicationRestController {

	@Autowired
	private JdbcTemplateManager jm ;
	
	@PostMapping("/add")
	public @ResponseBody String   add(@RequestBody Refer r) {
		Map<String, String> resultVO = new HashMap<String, String>();
		System.out.println("refer = "+r.toString());
		resultVO.put("restcallstatus", "The contact has been referred. Waiting for the person to register");
		jm.addReferral(r);
		Gson g = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
		String jsonString = g.toJson(resultVO);
		return jsonString;
	}
	
}
