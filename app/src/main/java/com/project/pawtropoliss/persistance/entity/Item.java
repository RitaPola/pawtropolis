package com.project.pawtropoliss.persistance.entity;

import lombok.*;


@Builder
@Data
@Getter
public class Item {
    private String name;
    private String description;
    private int reqiuredSlots;
}
