/**
 * 
 */
package com.engineering.www.controllers.rest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.engineering.www.managers.db.JdbcTemplateManager;

/**
 * @author Raviraja Addala/raviraja.addala@gmail.com
 *
 */
@RestController
@RequestMapping(value="/zcr")
public class EntityController extends ApplicationRestController{

	@Autowired
	private JdbcTemplateManager jm ;

	@GetMapping("/getTuples")
	public List<String> getTuples() {
		return jm.getAllEntities();
	}
	

	
	 @RequestMapping(value = "/ping", method = RequestMethod.GET)
     public @ResponseBody String ping() {
            System.out.println("successfully pinged ");
             return "successfully pinged";
     }
	 
	 @RequestMapping(value = "/gfetch", method = RequestMethod.GET)
     public @ResponseBody String gfetch() {
            System.out.println("successfully pinged fetch ");
            Map<String,String> fetchResponse = new HashMap<String, String>();
            
            fetchResponse.put("fid", "999");
            fetchResponse.put("fcontent", "hello world");
            fetchResponse.put("restcallstatus", "foudn data");
             return _getJsonresponse(fetchResponse);
     }

}
