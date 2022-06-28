package vn.techmaster.jpa.entitygraphdemo.repository;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import vn.techmaster.jpa.entitygraphdemo.model.Characteristic;

public interface CharacteristicsRepository extends JpaRepository<Characteristic, Long> {
    @EntityGraph(attributePaths = {"item"})
    Characteristic findByType(String type);
}
