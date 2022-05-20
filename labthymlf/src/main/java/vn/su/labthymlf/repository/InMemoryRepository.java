package vn.su.labthymlf.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import lombok.Getter;
import vn.su.labthymlf.model.Country;
import vn.su.labthymlf.model.Product;

@Getter
@Repository
public class InMemoryRepository {
    private ArrayList<Product> products;
    private ArrayList<Country> countries;

    public InMemoryRepository() {
        products = new ArrayList<>(List.of(new Product("Sony WX", "Sony", 1237621),
                new Product("Nike Air", "Nike", 250000),
                new Product("Lenovo Legion 7", "Lenovo", 40000000),
                new Product("Macbook M1", "Apple", 4000000)));

        countries = new ArrayList<>(List.of(new Country("Vietnam", "vi"),
                new Country("China", "cn"),
                new Country("USA", "us"),
                new Country("France", "fr"),
                new Country("Singapore", "sg"),
                new Country("Japan", "jp")));
    }
}
