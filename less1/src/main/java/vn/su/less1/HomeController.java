package vn.su.less1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import vn.su.less1.model.Message;

@Controller
@RequestMapping("/")
public class HomeController {
  @GetMapping
  @ResponseBody
  public String helloWorld() {
    return "hello world";
  }
  
  @GetMapping("/add/{a}/{b}")
  @ResponseBody
  public double add(@PathVariable("a") double a, @PathVariable("b") double b) {
    return a + b;
  }

  @GetMapping("/name/{your_name}")
  @ResponseBody
  public String hi(@PathVariable("your_name") String yourName) {
    return "Hi " + yourName;
  }
  
  @GetMapping("/add")
  @ResponseBody
  public int add2(@RequestParam("a") int a, @RequestParam("b") int b) {
    return a + b;
  }
  
  @PostMapping("/hi")
  @ResponseBody
  public Message sayHi(@RequestBody Message message) {
    return message;
  }
}


