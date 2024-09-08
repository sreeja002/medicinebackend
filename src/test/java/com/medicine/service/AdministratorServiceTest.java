package com.medicine.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.medicine.dao.AdministratorDao;
import com.medicine.dto.AdministratorDto;
import com.medicine.entity.Administrator;
@SpringBootTest
class AdministratorServiceTest {
	@Autowired
	AdministratorService administratorService;
//	@Test
//	void test() {
//	}
	
	@Test
	public void createUser() {
        AdministratorDto administratorDto = new AdministratorDto();
        administratorDto.setUsername("admin");
        administratorDto.setPassword("Password1@");

        String result = administratorService.createUser(administratorDto);

        assertEquals("Admin Added Successfully !", result);
    }
		

	@Test
	public void createUser_withInvalidPassword_returnsFailureMessage() {
        AdministratorDto administratorDto = new AdministratorDto();
        administratorDto.setPassword("password");

        String result = administratorService.createUser(administratorDto);

        assertEquals("BAD Password !", result);
    }
	@Test
	  public void testValidateAdminSuccess() {
	    String username = "testuser";
	    String password = "Testasdfghj123#";
	    Administrator user = new Administrator();
	    user.setUsername(username);
	    user.setPassword(password);
	    user.setAdmin(false);

	    boolean result = administratorService.validateAdmin("testuser", "Testasdfghj123#");
	    assertFalse(result);
	  }


	@Test
	 public void testCheckPasswordStrengthFailure() {
	    String password = "weakpassword";
	    boolean result = administratorService.checkPasswordStrength(password);
	    assertFalse(result);
	  }
	 @Test
	  public void testCheckPasswordStrengthSuccess() {
	    String password = "Test123#";
	    boolean result = administratorService.checkPasswordStrength(password);
	    assertTrue(result);
	  }

}
