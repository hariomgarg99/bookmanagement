package com.stationary.bookmanagement.util;

import com.stationary.bookmanagement.dto.BookDto;


public class BookTest {

    public static BookDto getBook() {
        BookDto bookDto = new BookDto.BookDtoBuilder()
                .id(1L)
                .name("JAVA")
                .author("Hariom")
                .description("this book is for learn basic java concept")
                .isbn("134234")
                .price(105.00)
                .type("Tech").build();
        return bookDto;
    }
}
