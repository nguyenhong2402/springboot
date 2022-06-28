package vn.su.testsecurity;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BasicController {
    
    @GetMapping("/hello")
    public ResponseEntity<?> getGreeting() {
        return ResponseEntity.ok("Hello world");
    }
    
    @GetMapping("/profile")
    public ResponseEntity<?> getProfile() {
        return ResponseEntity.ok("Profile");
    }
}
