
package com.hoaxify.ws;

import com.hoaxify.ws.user.User;
import com.hoaxify.ws.user.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;

//exclude ile SecurityAutoConfiguration sınıfımnı şimdilik hariç tuttuk
@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class WsApplication {

	public static void main(String[] args) {
		SpringApplication.run(WsApplication.class, args);
	}
	//Spring ayağı kalktıktan sonra bir işlev eklememiz gerekiyorsa kullanılır
	//bizim burada amacımız spring projesi calışır calışmaz db de en az bir user olduğundan emin olmak için biz burada  db ye user ekleyecegiz
	@Bean
	CommandLineRunner createInitUser(UserService userService){//user servisi bizim kullanacağımızı bildiğinden spring boot parametre olarak UserService ekleyebilir
    return new CommandLineRunner() {             			//Bizim bu sınıfa ihtiyacımız olduğunu belirtmemiz yeterli
		@Override
		public void run(String... args) throws Exception {
			User user=new User();
			user.setUserName("mustafabay");
			user.setDisplayName("mustafabay");
			user.setPassword("Mm.14531453");
			userService.cretaUser(user);
		}
	};
	}

}
