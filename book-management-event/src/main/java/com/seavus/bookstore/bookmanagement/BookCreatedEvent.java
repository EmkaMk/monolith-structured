package com.seavus.bookstore.bookmanagement;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class BookCreatedEvent {

    String uuid;

    String title;

    String author;

    String genre;
}
