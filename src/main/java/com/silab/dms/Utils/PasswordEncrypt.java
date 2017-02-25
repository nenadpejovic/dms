package com.silab.dms.Utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component("passEncrypt")
public class PasswordEncrypt {
	
	
	@Autowired
	BCryptPasswordEncoder passEncoder;
	
	
	
	public String encrypt(String password){
		
		String hashedPassword = passEncoder.encode(password);
		return hashedPassword;
	}
	
	

}
