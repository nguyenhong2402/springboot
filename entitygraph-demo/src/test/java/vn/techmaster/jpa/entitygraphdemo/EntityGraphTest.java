package vn.techmaster.jpa.entitygraphdemo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import vn.techmaster.jpa.entitygraphdemo.model.Characteristic;
import vn.techmaster.jpa.entitygraphdemo.model.Item;
import vn.techmaster.jpa.entitygraphdemo.repository.CharacteristicsRepository;
import vn.techmaster.jpa.entitygraphdemo.repository.ItemRepository;

@DataJpaTest
@Sql(scripts = "/entitygraph-data.sql")
public class EntityGraphTest {
    @Autowired
    private ItemRepository itemRepo;
    
    @Autowired
    private CharacteristicsRepository characteristicsRepo;

    @Test
    public void test1() {
        Item tableItem = itemRepo.findByname("Table");
        System.out.println(tableItem);
        assertEquals(2, tableItem.getCharacteristics().size());
    }

    @Test
    public void test2() {
        Characteristic rigidCharacteristic = characteristicsRepo.findByType("Rigid");
        System.out.println(rigidCharacteristic);
        assertEquals(1l, rigidCharacteristic.getItem().getId());
    }

    @Test
    public void testWithJoinFetch() {
        Item tableItem = itemRepo.findByNameJoinFetch("Table");
        System.out.println(tableItem);
        assertEquals(2, tableItem.getCharacteristics().size());
    }
}
