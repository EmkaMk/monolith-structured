package com.seavus.bookstore.rating;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProductRatedEvent {

    private String uuid;

    private Integer rating;
}
