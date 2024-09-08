package com.medicine.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.medicine.dto.UserDto;
import com.medicine.entity.Medicine;
@SpringBootTest
public class UserServiceTest {
	@Autowired
	UserService userService;

	@Test
	void test() {
		
	}
	@Test
	public void testCreateUser() {
		UserDto userDto=new UserDto();
		userDto.setUsername("Peter");
		userDto.setPassword("akR#8900");
		
		String result = userService.createUser(userDto);
		assertEquals("User Added Successfully !", result);
		
	}
	@Test
	 public void testCheckPasswordStrengthFailure() {
	    String password = "weakpassword";
	    boolean result = userService.checkPasswordStrength(password);
	    assertFalse(result);
	  }
	 @Test
	  public void testCheckPasswordStrengthSuccess() {
	    String password = "Test123#";
	    boolean result = userService.checkPasswordStrength(password);
	    assertTrue(result);
	  }
	@Test
	public void testValidateUser() {
		String username ="John";
		String password="WrongPassword";
		
		boolean result = userService.validateUser(username, password);
		assertFalse(result);
	}
	@Test
	public void testGetAllMedicines() {
		List<Medicine> result =userService.getAllMedicines();
		assertEquals(0, result.size());
	}

}
