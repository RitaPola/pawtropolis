package com.project.pawtropoliss.zoo.domain;

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
