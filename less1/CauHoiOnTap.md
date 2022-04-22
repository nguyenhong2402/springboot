1. Trong quá trình tạo dự án Spring Boot chúng ta phải khai báo những tham số sau đây : groupID, artifactID. Ý nghĩa các tham số này là gì?
- groupID: tên miền đảo ngược,
reverse domain để phân biệt công ty, tổ chức sở hữu
- artifactID: tên package chính và cũng là tên thư mục dự án
2. Tại sao phải đảo ngược tên miền trong <groupId>vn.techmaster</groupId>?
- Để cho phép truy xuất và quản lý giữa địa chỉ IP và tên miền một cách linh động theo mong muốn của nhà cung cấp
3. SpringBoot có 2 cơ chế để quản lý thư viện. Hãy kể tên chúng?
- Maven và Gradle
4. File pom.xml có tác dụng gì?
-  File pom.xml là nơi khai báo tất cả những gì liên quan đến dự án được cấu hình qua maven, như khai báo các dependency, version của dự án, tên dự án, repository
5. Trong file pom.xml có các thẻ dependency. Ý nghĩa của chúng là gì?
<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter-web</artifactId>
</dependency>
- Để khai báo thư viện
6. Ý nghĩa của @Controllerlà gì?
 @Controller là một bean nơi tiếp nhận request và trả về response cho client
 7. Ý nghĩa của @RequestMapping là gì? Nó có những tham số gì ngoài value?
 - Để định cấu hình ánh xạ các web request
 - Nó có các tham số value,consumers,headers,method,name,params,path,produces
8. Ý nghĩa của @RequestBody khi đặt trong hàm hứng request để làm gì?
 -@RequestBody được dùng để ánh xạ dữ liệu JSON trong  HttpRequest body sang một Java Type object tương ứng
 9. Hãy trả lời khi nào thì dùng @PathVariable và khi nào nên dùng @RequestParam
 - Dùng @RequestParam khi cần truyền 1 cặp key, value còn @PathVariable chỉ cần truyền value
 10. Thứ tự các thành phần đường dẫn @PathVariable có thể hoán đổi được không?
 - Có
 11. @GetMapping khác gì so với @PostMapping?
 @GetMapping có nhiệm vụ đánh dấu hàm xử lý GET request trong Controller
 @PostMapping có nhiệm vụ đánh dấu hàm xử lý POST request trong Controller
 12. Trong các annotation @RequestMapping, @GetMapping, @PostMapping… có tham số produces = MediaType.XXXX ý nghĩa tham số này là gì?
 - Trả về cho client dữ liệu theo một kiểu nào đó
 13. Giải thích ý nghĩa của @RequestBody trong đoạn code dưới đây
@PostMapping(value = "/message", produces = MediaType.APPLICATION_JSON_VALUE)
@ResponseBody
public Message echoMessage(@RequestBody Message message){
    return message;
}
- Chuyển từ JavaObject sang JSON và chuyển vào httpreponse
14. Cổng mặc định ứng dụng SpringBoot là 8080. Hãy google cách để thay đổi cổng lắng nghe mặc định
- Thay đổi trong file application.properties là: server.port = XXXX

