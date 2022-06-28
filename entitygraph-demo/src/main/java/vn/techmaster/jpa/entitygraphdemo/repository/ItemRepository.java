package vn.techmaster.jpa.entitygraphdemo.repository;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import vn.techmaster.jpa.entitygraphdemo.model.Item;

public interface ItemRepository extends JpaRepository<Item, Long> {
    @EntityGraph(value = "Item.characteristics")
    Item findByname(String name);

    @Query("Select i from Item i left join fetch i.characteristics where i.name=:name")
    Item findByNameJoinFetch(@Param("name") String name);
}
