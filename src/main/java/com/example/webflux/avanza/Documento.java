package com.example.webflux.avanza;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.List;

public class Documento {

    public static void main(String[] args) {
        ejemplo2();
    }

    public static void ejemplo1() {
        //crear
        Flux<String> seq1 = Flux.just("foo", "bar", "foobar");
        Flux<Integer> numbersFromFiveToSeven = Flux.range(5, 3);

        List<String> iterable = Arrays.asList("foo", "bar", "foobar");
        Flux<String> seq2 = Flux.fromIterable(iterable);

        Mono<String> noData = Mono.empty();
        Mono<String> data = Mono.just("foo");
    }

    public static void ejemplo2() {
        //suscripcion 1
        Flux<Integer> ints = Flux.range(1, 3);
        ints.subscribe();

        //suscripcion 2
        Flux<Integer> ints2 = Flux.range(1, 3);
        ints2.subscribe(i -> System.out.println(i));

        //suscripcion 3
        Flux<Integer> ints3 = Flux.range(1, 4)
                .map(i -> {
                    if (i <= 3) return i;
                    throw new RuntimeException("Got to 4");
                });
        ints3.subscribe(i -> System.out.println(i),
                error -> System.err.println("Error: " + error));

        //suscripcion 4
        Flux<Integer> ints4 = Flux.range(1, 4).log();
        ints4.subscribe(i -> System.out.println(i),
                error -> System.err.println("Error " + error),
                () -> System.out.println("Done"));


    }

}
