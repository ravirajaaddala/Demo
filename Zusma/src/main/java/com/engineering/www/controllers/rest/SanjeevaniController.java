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
import com.engineering.www.vo.DonorDetails;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * @author Raviraja Addala/raviraja.addala@gmail.com
 *
 */
@RestController
@RequestMapping(value="/zcr/sanjeevani")
public class SanjeevaniController extends ApplicationRestController {

	@Autowired
	private JdbcTemplateManager jm ;
	
	@PostMapping("/register")
	public @ResponseBody String   add(@RequestBody DonorDetails s) {
		Map<String, String> resultVO = new HashMap<String, String>();
		resultVO.put("restcallstatus", "Thanks for your willingness. you are successfully registered");
		System.out.println("s = "+s.toString());
		try {
			jm.addSanjeevani(s);
		}catch(Exception e) {
			e.printStackTrace();
			resultVO.put("restcallstatus", "Thanks for your willingness. Failed to register. please contact customer support");
		}
		Gson g = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
		String jsonString = g.toJson(resultVO);
		return jsonString;
	}
}
