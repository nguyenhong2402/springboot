package vn.techmaster.less4thymeleafdemo2.repository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import lombok.Getter;
import vn.techmaster.less4thymeleafdemo2.model.Country;
import vn.techmaster.less4thymeleafdemo2.model.Person;
import vn.techmaster.less4thymeleafdemo2.model.Product;
import vn.techmaster.less4thymeleafdemo2.model.User;

@Getter
@Repository
public class InMemoryRepository {
    private ArrayList<Product> products;
    private ArrayList<Country> countries;
    private ArrayList<Person> people;
    private ArrayList<User> users;

    public InMemoryRepository(){
        products = new ArrayList<>(List.of(new Product("Sony WX", "Sony", 10000000),
                new Product("Nike Air", "Nile", 2500000),
                new Product("Lenovo Legion 7", "Lenovo", 40000000),
                new Product("Macbook M1", "Apple", 40000000)));

        countries = new ArrayList<>(List.of(
            new Country("Vietnam", "vi"),
            new Country("China", "cn"),
            new Country("USA", "us"),
            new Country("France", "fr"),
            new Country("Singapore", "sg"),
            new Country("Japan", "jp")
        ));
        SimpleDateFormat yMdFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            people = new ArrayList<>(List.of(
                new Person("Tom", "USA", yMdFormat.parse("1976-12-01"), "male"),
            new Person("Lara", "France", yMdFormat.parse("1976-12-01"), "female"),
            new Person("Zhiang", "China", yMdFormat.parse("1988-09-11"), "female"),
            new Person("Lien", "Vietnamese", yMdFormat.parse("1971-03-01"), "female")));
        } catch (ParseException e) {
            e.printStackTrace();
        }
       
        users = new ArrayList<>(List.of(
                new User("Tom", "admin"),
                new User("Lara", "user"),
                new User("Zhiang", "editor"),
                new User("Lien", "user")));
    }
}
