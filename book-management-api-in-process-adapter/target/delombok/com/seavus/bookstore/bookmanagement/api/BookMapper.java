package com.seavus.bookstore.bookmanagement.api;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BookMapper {

    BookMapper INSTANCE = Mappers.getMapper(BookMapper.class);

    Book from(com.seavus.bookstore.bookmanagement.Book book);
}
