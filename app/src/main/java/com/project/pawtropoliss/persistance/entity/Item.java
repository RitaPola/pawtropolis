package com.project.pawtropoliss.persistance.entity;
import lombok.*;
import javax.persistence.*;

@NoArgsConstructor
@Data
@Entity
@Table(name = "items")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;
    @Column(name = "occupied_slots")
    private Integer reqiuredSlots;
}
