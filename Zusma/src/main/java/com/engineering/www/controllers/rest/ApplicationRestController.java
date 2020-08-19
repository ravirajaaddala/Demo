/**
 * 
 */
package com.engineering.www.controllers.rest;

import java.util.HashMap;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


/**
 * @author Raviraja Addala/raviraja.addala@gmail.com
 *
 */

@SuppressWarnings({ "rawtypes", "unchecked" })
public class ApplicationRestController {


    public String _getJsonresponseFromMap(HashMap<String, String> response) {
		/*
		 * Gson g = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
		 * String jsonString = g.toJson(response); return jsonString;
		 */
    	return null;
    }

    public String _getJsonresponse(Object o) {
    	Gson g = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
		String jsonString = g.toJson(o);
		return jsonString;
    }



	public HttpHeaders _getJsonHeader() {
		HttpHeaders resHeader = new HttpHeaders();
		resHeader.setContentType(MediaType.APPLICATION_JSON);
		return resHeader;
	}
	
	
	public ResponseEntity _getJsonresponse(Object res, boolean isSuccess) {
		ResponseEntity re = null;
		if (isSuccess) {
			re = new ResponseEntity(res, _getJsonHeader(), HttpStatus.OK);
		} else {
			re = new ResponseEntity(res, _getJsonHeader(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return re;

	}
	


}
