package com.project.pawtropoliss.player.domain;

import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@ToString
@Builder
public class Item {

    private String name;
    private String description;
    private int occupiedSlots; /*slot occupati dall'oggetto nella borsa - rinominarlo in requiredSlots*/


}
