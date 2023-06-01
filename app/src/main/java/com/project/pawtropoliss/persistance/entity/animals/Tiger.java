package com.project.pawtropoliss.persistance.entity.animals;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@ToString
@SuperBuilder
public class Tiger extends Animal {

	private Double tailLength;

}
