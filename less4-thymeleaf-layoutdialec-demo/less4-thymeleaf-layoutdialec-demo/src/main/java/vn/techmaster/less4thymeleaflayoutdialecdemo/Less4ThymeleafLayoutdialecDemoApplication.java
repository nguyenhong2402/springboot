package vn.techmaster.less4thymeleaflayoutdialecdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
@Controller
public class Less4ThymeleafLayoutdialecDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(Less4ThymeleafLayoutdialecDemoApplication.class, args);
	}

	@RequestMapping("")
	public String home() {
		return "home";
	}
	@RequestMapping("contact")
	public String contact() {
		return "contact";
	}
	@RequestMapping("about")
	public String about() {
		return "about";
	}
}
