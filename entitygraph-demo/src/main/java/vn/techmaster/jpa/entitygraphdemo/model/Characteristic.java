package vn.techmaster.jpa.entitygraphdemo.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@ToString(exclude = "item")
public class Characteristic {
    @Id
    private Long id;
    private String type;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private Item item;

}
