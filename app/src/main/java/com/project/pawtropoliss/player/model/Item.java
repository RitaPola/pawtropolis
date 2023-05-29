package com.project.pawtropoliss.player.model;

import lombok.*;


@Builder
@Data
@Getter
public class Item {
    private String name;
    private String description;
    private int reqiuredSlots;
}
