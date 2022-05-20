package vn.su.demo04;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Demo04Application {

	public static void main(String[] args) {
		// ApplicationContext chính là container, chứa toàn bộ các Bean
		ApplicationContext context = SpringApplication.run(Demo04Application.class, args);
		// Khi chạy xong, lúc này context sẽ chứa các Bean có đánh dấu @Component.

		// Lấy Bean ra bằng cách
		Outfit outfit = context.getBean(Outfit.class);

		System.out.println("Instance: " + outfit);
		outfit.wear();
	}

}
