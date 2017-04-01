package com.seavus.bookstore.api;

import com.seavus.bookstore.recommendation.api.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BookMapper {

    BookMapper INSTANCE = Mappers.getMapper(BookMapper.class);

    @Mapping(source = "uuid", target = "id")
    Book from(com.seavus.bookstore.bookmanagement.api.Book book);

    @Mapping(source = "uuid", target = "id")
    Book from(Product product);
}
