package com.seavus.bookstore.recommendation.api;

import com.seavus.bookstore.recommendation.Product;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2017-03-13T15:58:43+0100",
    comments = "version: 1.0.0.Final, compiler: javac, environment: Java 1.8.0_73 (Oracle Corporation)"
)
public class ProductMapperImpl implements ProductMapper {

    @Override
    public com.seavus.bookstore.recommendation.api.Product from(Product product) {
        if ( product == null ) {
            return null;
        }

        com.seavus.bookstore.recommendation.api.Product product_ = new com.seavus.bookstore.recommendation.api.Product();

        product_.setUuid( product.getUuid() );

        return product_;
    }
}
