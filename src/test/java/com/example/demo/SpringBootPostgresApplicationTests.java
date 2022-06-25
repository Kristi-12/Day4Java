package com.example.demo;

import com.example.demo.Service.SpidS;
import com.example.demo.Service.UserS;
import com.example.demo.Entities.User;
import com.example.demo.Entities.Spid;
import com.example.demo.Entities.Type;
import com.example.demo.Entities.Status;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.Date;
@SpringBootTest(classes = {SpringBootPostgresApplicationTests.class})
class SpringBootPostgresApplicationTests {

	@Autowired
	private UserS userS;
	@Autowired
	private SpidS spidS;

	@Test
	void test() {
		try {
			System.out.println(userS.getUserById(1));
			User user = userS.updateUserById(1,"John", "Luke","johnluke@gmail.com");
			System.out.println(userS.getUserById(1));
			Spid spid = spidS.createSpid(new Spid(new Date(),"JohnKent",user ,1,Status.APPROVED,Type.LEVEL_1));
			System.out.println(spidS.findSpid(user));
		}

		catch(Exception e){
			System.out.println(e.getMessage());
		}
	}

}
