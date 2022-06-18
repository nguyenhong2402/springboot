# KIỂM TRA KIẾN THỨC KẾT NỐI CSDL-JPA
#### 1. Thuộc tính name trong annotation @Entity khác với thuộc tính name trong @Table như thế nào? Hãy giải thích rõ cần thì minh hoạ
    - name của @Entity dùng để chỉ tên của entity được Hibernate quản lý còn
    - name của @Table chỉ tên bảng trong database
#### 2. Để debug câu lệnh SQL mà Hibernate sẽ sinh ra trong quá trình thực thi, cần phải bổ sung lệnh nào vào file application.properties?
    Cách 1: Ta cần thêm spring.jpa.show-sql=true để hiện câu lệnh SQL
    Cách 2: logging.level.org.hibernate.SQL=DEBUG Để ghi các truy vấn SQL
            logging.level.org.hibernate.type.descriptor.sql.BasicBinder=TRACE để ghi các thâm số câu lệnh đã chuẩn bị
#### 3. Khi sử dụng H2, làm thế nào để xem được cơ sở dữ liệu và viết câu truy vấn?
    Ta có thể dùng spring.h2.console.enabled=true để hiện giao diện H2 qua đó xem  và viết câu truy vấn đối với cơ sở dữ liệu
#### 4. Khi viết mô tả một model, những thuộc tính chúng ta không muốn lưu xuống CSDL thì cần đánh dấu bằng annotation nào?
        @Transient và @Formula
#### 5. Annotation @Column dùng để bổ sung tính chất cho cột ứng với một thuộc tính. Tham số nào trong @Column sẽ đổi lại tên cột nếu muốn khác với tên thuộc tính, tham số nào chỉ định yêu cầu duy nhất, không được trùng lặp dữ liệu, tham số nào buộc trường không được null?
        Tham số sẽ đổi lại tên cột : name
        Tham số chỉ định yêu cầu duy nhất: unique
        Tham số buộc trường ko null: nullable
#### 6. Có 2 sự kiện mà JPA có thể bắt được, viết logic bổ sung 
        o Ngay trước khi đối tượng Entity lưu xuống CSDL (ngay trước lệnh INSERT)
        o Ngay trước khi đối tượng Entity cập nhật xuống CSDL (ngay trước lệnh UPDATE)
        Vậy 2 annotation này là gì?

        - @PrePersist để JPA bắt đc sự kiện trước khi Entity được lưu xuống CSDL
        - @PreUpdate Ngay trước khi đối tượng Entity cập nhật xuống CSDL
#### 7. Tổ hợp các trường thông tin địa chỉ: country, city, county, addressline thường luôn đi cùng nhau và sử dụng lại trong các Entity khác nhau. Nhóm 2 annotation nào dùng để tái sử dụng, nhúng một Entity vào một Entity khác?
        @Embeddable và @Embedded
#### 8. JpaRepository là một interface có sẵn trong thư viện JPA, nó cũng cấp các mẫu hàm thuận tiện cho thao tác dữ liệu. Cụ thể JpaRepository kế thừa từ interface nào?
        interface PagingAndSortingRepository
#### 9. Hãy viết khai báo một interface repository thao tác với một Entity tên là Post, kiểu dữ liệu trường Identity là long, tuân thủ interface JpaRepository.
        public interface PostRepository extends JpaRepository<Post, Long>{

        }
#### 10. Khi đã chọn một cột là Identity dùng @Id để đánh dấu, thì có cần phải dùng xác định unique dùng annotation @Column(unique=true) không?
Không cần
#### 11. Khác biệt giữa @Id với @NaturalId là gì?
        @Id dùng cho trường là primary key, không đổi
        @NaturalId dùng để tạo unique constrain lên một tường không phải primary key, có thể thay đổi
#### 12. Có những cột không phải primary key (@Id) hay @NaturalId, dữ liệu có thể trùng lặp (unique không đảm bảo true), nhưng cần đánh chỉ mục (index) để tìm kiếm nhanh hơn vậy phải dùng annotation gì? Hãy viết 1 ví dụ sử dụng annotation đó với index cho 1 column và 1 ví dụ với index cho tổ hợp nhiều column. Tham khảo tại (https://www.baeldung.com/jpaindexes)
        @Index
        - Ví dụ 1 column:
        --------------------------------    
        @Entity
        @Table(indexes = @Index(name="f_index", columnList = "firstName"))
        public class Student implements Serializable {
            @Id
            @GeneratedValue
            private Long id;
            private String firstName;
            private String lastName;

   
        }
        - Ví dụ multi column:
        @Entity
        @Table(indexes = @Index(name="fl_index", columnList = "firstName, lastName"))
        public class Student implements Serializable {
            @Id
            @GeneratedValue
            private Long id;
            private String firstName;
            private String lastName;

        }
#### 13. Annotation @GeneratedValue dùng để chọn cách tự sinh unique id cho primary key phải là trường kiểu int hoặc long. Nếu trường primary key có kiểu là String, chúng ta không thể dùng @GeneratedValue vậy hãy thử liệt kê các cách đảm bảo sinh ra chuỗi có tính duy nhất?

        - Sử dụng UUID.randomUUID().toString()
        - Sử dụng Custom ID generator
#### 14. Giả sử có 1 class Employee với các fields sau {id, emailAddress, firstName, lastName}. Hãy viết các method trong interface EmployeeRespository để :

        o Tìm tất cả các Employee theo emailAddress và lastName
        o Tìm tất cả các Employee khác nhau theo firstName hoặc lastName
        o Tìm tất cả các Employee theo lastName và sắp xếp thứ tự theo firstName tăng dần
        o Tìm tất cả các Employee theo fistName không phân biệt hoa thường
        ---------------------
        - Tìm tất cả các Employee theo emailAddress và lastName
        @Query("select e from Employee e where e.emailAddress = ?1 and e.lastName = ?2")
        List<Employee> findByEmailAddessAndLastName;
        - Tìm tất cả các Employee khác nhau theo firstName hoặc lastName:
        @Query("select DISTINCT e from Employee e where e.firstName and e.lastName")
        List<Employee> findByFirstnameAndLastName(String firstName, String lastName);
        - Tìm tất cả các Employee theo lastName và sắp xếp thứ tự theo firstName tăng dần
        @Query("select DISTINCT e from Employee e where e.lastName oder by e.firstName ASC")
        List<Employee> findByFirstnameAscAndLastName(String lastName);
        - Tìm tất cả các Employee theo fistName không phân biệt hoa thường
        findByFirstnameAllIgnoreCase(String firstName);
#### 15. Hãy nêu cách sử dụng của @NamedQuery và @Query. Cho ví dụ
        @NamedQuery sử dụng để cung cấp các câu query dùng chung và gắn liền với entity
        @Query sử dụng để tạo query jpql khi gọi đến phương thức
        Ví dụ @Query
        public interface UserRepository extends JpaRepository<User, Long> {

        @Query("select u from User u where u.emailAddress = ?1")
        User myCustomQuery(String emailAddress);

        @Query(value = "select * from User u where u.email_address = ?1", nativeQuery = true)
        User myCustomQuery2(String emailAddress);
        }
        Ví dụ @NamedQuery:
        @Entity(name ="oto") 
        @Table(name = "car") 
        @Data 
        @NamedQuery(name = "Car.findById", query = "SELECT c FROM oto c WHERE c.id=:id")
        public class Car {
        @Id private long id;
        private String model;
        private String maker;
        private int year;
        }
#### 16. Làm thế nào để có thể viết custom method implemetations cho Jpa Repository. Nêu ví dụ
        Cần tạo CustomRepository rồi cho CustomRepository implement nó
        public interface PersonRepository extends JpaRepository<Person, Long>, PersonRepositoryCustom {

        }
        public interface PersonRepositoryCustom {
            public void addPerson();
        }
        public class PersonRepositoryCustomImp {
            public void addPerson(){
                //TODO viết phương thức
            }
        }
#### 17. Hãy nêu 1 ví dụ sử dụng sorting và paging khi query đối tượng Employee ở trên
        public class Employee{
            @Id
            Long id;
            private String emailAddress;
            private String firstName;
            private String lastName;
        }
        public class EmployeeService{
            @Autowired
            EmployeeRepository em;
            public List<Employee> getAllByEmailAddressAsc(){
                return em.findAllByOderByEmailAdressSort(); /// Tìm kiếm Employee theo sorting
                        // Hoặc em.findAll(Sort.by("emailAddress"));
            }
            public Page<Employee> getAllByEmailAddressPaging{
                return em.findAll(PageRequest.of(1,10))
            }
        }
#### 18. Có 3 Entity Product.java và Category.java và Tag.java
        • Hãy bổ sung định nghĩa quan hệ One to Many giữa bảng Category (One) -- Product
        (Many). Chú ý khi một Category xoá, thì không được phép xoá Product, mà chỉ set
        thuộc tính Category của Product là null.
        • Hãy bổ sung định nghĩa quan hệ Many to Many giữa bảng Tag(Many) --
        Product(Many).
        @Entity(name="product")
        @Table(name="product")
        @Data
        public class Product {
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private long id;
        private String name;
        @ManyToOne(fetch = FetchType.LAZY)
        private Category category;
        @ManyToMany
        List<Tag> tags;
        }
        ------------------------------------
        @Entity(name="category")
        @Table(name="category")
        @Data
        public class Category {
         @Id
         @GeneratedValue(strategy = GenerationType.AUTO)
         private long id;
         private String name;
         @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "category")
         List<Product> products = new ArrayList<>();
        }
        --------------------------------------------
        @Entity(name="tag")
        @Table(name="tag")
        @Data
        public class Tag {
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private long id;
        private String name;
        @ManyToMany(mappedBy="tags")
            List<Product> products;
        }



 


