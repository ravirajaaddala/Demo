/**
 * 
 */
package com.engineering.www.managers.db;

import java.sql.Types;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.engineering.www.vo.DonorDetails;
import com.engineering.www.vo.Refer;
import com.engineering.www.vo.UserProfile;

/**
 * @author Raviraja Addala/raviraja.addala@gmail.com
 *
 */
@Component
public class JdbcTemplateManager {

	private final JdbcTemplate jdbcTemplate;
	
	public JdbcTemplateManager(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public List<String> getAllEntities(){
		return this.jdbcTemplate.queryForList("SELECT * FROM master_entity").stream()
				.map((m) -> m.values().toString())
				.collect(Collectors.toList());
	}
	
	public void addReferral(Refer r) {
        Object[] params = new Object[] {  r.getPhoneNumber(),r.getEmailId(), "p" };
         
        // define SQL types of the arguments
        int[] types = new int[] { Types.VARCHAR, Types.VARCHAR, Types.VARCHAR };
 
        
		jdbcTemplate.update( "INSERT INTO referral_data (phone_number, referred_by, status) VALUES (?, ?, ?)", params, types);
		System.out.println("referral added tp db");
		
	}
	
	public void addSanjeevani(DonorDetails r) {
        Object[] params = new Object[] {r.getCategory(),  r.getBloodgroup(),r.getUserId() };
         
        // define SQL types of the arguments
        int[] types = new int[] { Types.VARCHAR, Types.VARCHAR, Types.INTEGER };
 
        
		jdbcTemplate.update( "INSERT INTO donor_details (donation_category,blood_group, user_profile_id) VALUES (?, ?, ?)", params, types);
		System.out.println("s added to db");
		
	}
	
	public void addUser(UserProfile r) {
        Object[] params = new Object[] {r.getName(),
        		r.getGender(),
        		r.getBirthday(),
        		r.getEmailId(), 
        		r.getPhoneNumber(),
        		r.getPincode(),
        		r.getPlace(), 
        		"Active" ,
        		new Date()};
         
        // define SQL types of the arguments
        int[] types = new int[] { Types.VARCHAR, 
        		Types.VARCHAR, 
        		Types.DATE, 
        		Types.VARCHAR, 
        		Types.VARCHAR, 
        		Types.VARCHAR, 
        		Types.VARCHAR,
        		Types.VARCHAR,
        		Types.DATE};
 
        
		jdbcTemplate.update( "INSERT INTO user_profile (name,gender, birth_date, email_id,phone_number,pin_code,place, status, entered_date) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)", params, types);
		System.out.println("s added to db");
		
	}
}
