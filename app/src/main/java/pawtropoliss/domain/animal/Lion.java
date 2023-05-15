package pawtropoliss.domain.animal;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;


import java.time.LocalDate;
@Getter
@Setter
@SuperBuilder
@ToString
public class Lion extends Animal {
	private Double tailLength;

}
