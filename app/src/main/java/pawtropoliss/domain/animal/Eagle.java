package pawtropoliss.domain.animal;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;


import java.time.LocalDate;

@Getter
@Setter
@ToString
@SuperBuilder
public class Eagle extends Animal {

	private Double wingsLength;


}
