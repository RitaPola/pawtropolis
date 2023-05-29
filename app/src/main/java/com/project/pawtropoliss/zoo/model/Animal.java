package com.project.pawtropoliss.zoo.model;

import lombok.*;
import lombok.experimental.SuperBuilder;
import java.time.LocalDate;


@Getter
@Setter
@ToString
@SuperBuilder
public class Animal {
	private String name;
	private String favoriteFood;
	private LocalDate admissionDate;
	private Double weight;
	private Double height;

}
