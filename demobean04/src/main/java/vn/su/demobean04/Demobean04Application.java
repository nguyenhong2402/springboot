package vn.su.demobean04;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Demobean04Application {

	public static void main(String[] args) {
		ApplicationContext context= SpringApplication.run(Demobean04Application.class, args);
		Dress dress = (Dress) context.getBean("dress");
		System.out.println(dress);
		System.out.println(dress.getSize());

		System.out.println("--------------------------------------");

		GirlFriend girlFriend = (GirlFriend) context.getBean("girlFriend");
		System.out.println(girlFriend);
		System.out.println(girlFriend.dress);
		System.out.println(girlFriend.dress.getSize());
	}

}
