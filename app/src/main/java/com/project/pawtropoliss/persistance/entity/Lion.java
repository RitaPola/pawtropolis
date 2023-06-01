package com.project.pawtropoliss.persistance.entity;

import com.project.pawtropoliss.persistance.entity.animals.Animal;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@ToString
public class Lion extends Animal {
	private Double tailLength;

}
