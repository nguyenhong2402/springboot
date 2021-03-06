package vn.techmaster.shopingcart.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import lombok.extern.slf4j.Slf4j;
import vn.techmaster.shopingcart.model.Product;

@Repository
@Slf4j
public class ProductRepository {
  private ArrayList<Product> products;
  private long nextId = 1;
  public ProductRepository() {
    products = new ArrayList<>();
    nextId = 1;
    initData();
  }

  @Cacheable("products")
  public List<Product> getAll() {
    log.info("invoke method to get products");
    simulateSlowService();
    return products;
  }

  @Cacheable(value = "product", key="#id")
  public Optional<Product> findById(long id) {
    log.info("invoke method to get product by id");
    simulateSlowService();
    return products.stream().filter(p -> p.getId() == id).findFirst();
  }
  
  public long createProduct(Product product) {
    product.setId(nextId);
    nextId += 1;
    products.add(product);
    return nextId;
  }
  
  public void initData() {
    createProduct(new Product("Red Bikini", "Victoria Secret", 9000000, "redbikini.jpg"));
    createProduct(new Product("Sony WXMH-1000", "Sony", 4500000, "sonywxh100.jpeg"));
    createProduct(new Product("Aris Pro", "Vinsmart", 4000000, "arispro.jpg"));
    createProduct(new Product("Logitech MX Master 2S", "Logitech", 3000000, "mx-master-2s.jpg"));    
  }

  private void simulateSlowService() {
    try {
      long time = 3000L;
      Thread.sleep(time);
    } catch (InterruptedException e) {
      throw new IllegalStateException(e);
    }
  }
    
}
