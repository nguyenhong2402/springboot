1. Tại sao chúng ta dùng kiểu dữ liệu ConcurrentHashMap trong dự án này?
- Dùng để nhiều luồng có thể truy cập vào cùng 1 lúc mà không bị ảnh hưởng đến các mục
2. Để sinh một chuỗi ngẫu nhiên duy nhất thì dùng hàm nào?
- Dùng UUID.randomUUID()
3. Nếu không sử dụng khai báo public record BookRequest(String title, String author, int year) thì dùng cách gì thay thế?
- thì dùng public final class BookRequest
4. Ở phương thức getBooks() chúng ta có thể trả trực tiếp biến books kiểu ConcurrentHashMap về cho trình duyệt được không? Hãy thử nghiệm
-Không được