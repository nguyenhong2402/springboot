package vn.techmater.less4thymeleaffragmentdemo;

import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
@Controller
public class Less4ThymeleafFragmentDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(Less4ThymeleafFragmentDemoApplication.class, args);
	}

	@GetMapping("/")
	public String home(Map<String, Object> model) {
		model.put("user", new User("Thinh", "Tran"));
		return "my-page";
	}
}
