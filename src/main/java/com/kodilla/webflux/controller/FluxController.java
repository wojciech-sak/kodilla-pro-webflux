package com.kodilla.webflux.controller;

import com.kodilla.webflux.Book;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.time.Duration;

@RestController
public class FluxController {

    @GetMapping(value = "/strings", produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
    public Flux<String> getStrings() {
        return Flux
                .just("a", "b", "c", "d", "e")
                .delayElements(Duration.ofSeconds(2))
                .log();
    }

    @GetMapping(value = "/books")
    public Flux<Book> getBooks() {
        return Flux
                .just(
                        new Book("Title1", "Author1", 2000),
                        new Book("Title2", "Author2", 2001),
                        new Book("Title3", "Author3", 2002),
                        new Book("Title4", "Author4", 2003),
                        new Book("Title5", "Author5", 2004)
                )
                .log();
    }
}
