package com.seavus.bookstore.bookmanagement;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {

    Book findByUuid(String uuid);
}
