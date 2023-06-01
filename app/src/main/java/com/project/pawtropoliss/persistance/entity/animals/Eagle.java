package com.project.pawtropoliss.persistance.entity.animals;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@ToString
@SuperBuilder
public class Eagle extends Animal {
	private Double wingsLength;
}
