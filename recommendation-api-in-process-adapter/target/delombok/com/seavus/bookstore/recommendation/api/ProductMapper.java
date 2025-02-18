package com.seavus.bookstore.recommendation.api;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProductMapper {

    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    Product from(com.seavus.bookstore.recommendation.Product product);
}
