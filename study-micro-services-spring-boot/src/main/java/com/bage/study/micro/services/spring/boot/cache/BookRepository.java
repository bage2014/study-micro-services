package com.bage.study.micro.services.spring.boot.cache;

public interface BookRepository {

    Book getByIsbn(String isbn);

}