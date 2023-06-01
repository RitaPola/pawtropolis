package com.project.pawtropoliss.persistance.entity.animals;

import lombok.*;
import javax.persistence.*;
import java.time.LocalDate;


@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
@Table(name = "animals")
public class Animal {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "name")
	private String name;
	@Column(name = "favoriteFood")
	private String favoriteFood;
	@Column(name = "admissionDate")
	private LocalDate admissionDate;
	@Column(name = "weight")
	private Double weight;
	@Column(name = "height")
	private Double height;

}
