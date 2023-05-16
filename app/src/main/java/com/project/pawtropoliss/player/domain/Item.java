package com.project.pawtropoliss.player.domain;

import lombok.*;
import org.springframework.stereotype.Component;
@Getter
@Setter
@AllArgsConstructor
@ToString
@Builder
@Component
@NoArgsConstructor
public class Item {
    private String name;
    private String description;
    private int occupiedSlots; /*slot occupati dall'oggetto nella borsa - rinominarlo in requiredSlots*/

}
