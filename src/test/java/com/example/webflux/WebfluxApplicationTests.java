package com.example.webflux;

import jogamp.common.Debug;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

//@SpringBootTest
class WebfluxApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    void test1() {
        List<Integer> elements = new ArrayList<>();

        Flux.just(1, 2, 3, 4)   //crea el flux
                .log()  //imprime todo el cliclo
                .subscribe(elements::add); //se suscribe y agrega elementos al array

        assertThat(elements).containsExactly(1, 2, 3, 4);
    }

    @Test
    void test2() {
        List<Integer> elements = new ArrayList<>();
        Flux.just(1, 2, 3, 4)
                .log()
                .map(i -> {
                    //LOGGER.debug("{}:{}", i, Thread.currentThread());
                    return i * 2;
                })
                .subscribe(x -> System.out.println(x));
    }

    @Test
    void test3() {
        List<Integer> elements = new ArrayList<>();

        Flux.just(1, 2, 3, 4)
                .log()
                .map(i -> i * 2)
                .zipWith(Flux.range(0, Integer.MAX_VALUE),
                        (one, two) -> String.format("First Flux: %d, Second Flux: %d", one, two))
                .subscribe(x -> System.out.println(x));

//        assertThat(elements).containsExactly(
//                "First Flux: 2, Second Flux: 0",
//                "First Flux: 4, Second Flux: 1",
//                "First Flux: 6, Second Flux: 2",
//                "First Flux: 8, Second Flux: 3");
    }

    @Test
    void mapExample() {
        Flux<String> fluxColors = Flux.just("red", "green", "blue");
        fluxColors.map(color -> color.charAt(0)).subscribe(System.out::println);
    }

    /**
     * operador zip, que comprime varias fuentes juntas (esperando a que todas las fuentes emitan un elemento y combinándolas en una tupla):
     */
    @Test
    void zipExample() {
        Flux<String> fluxFruits = Flux.just("apple", "pear", "plum");
        Flux<String> fluxColors = Flux.just("red", "green", "blue");
        Flux<Integer> fluxAmounts = Flux.just(10, 20, 30);
        Flux.zip(fluxFruits, fluxColors, fluxAmounts).subscribe(System.out::println);
    }

    @Test
    public void onErrorExample() {
        Flux<String> fluxCalc = Flux.just(-1, 0, 1)
                .map(i -> "10 / " + i + " = " + (10 / i));

        fluxCalc.subscribe(value -> System.out.println("Next: " + value),
                error -> System.err.println("Error: " + error));
    }

    @Test
    public void onErrorReturnExample() {
        Flux<String> fluxCalc = Flux.just(-1, 0, 1)
                .map(i -> "10 / " + i + " = " + (10 / i))
                .onErrorReturn(ArithmeticException.class, "Division by 0 not allowed");

        fluxCalc.subscribe(value -> System.out.println("Next: " + value),
                error -> System.err.println("Error: " + error));

    }

    @Test
    public void stepVerifierTest() {
        Flux<String> fluxCalc = Flux.just(-1, 0, 1)
                .map(i -> "10 / " + i + " = " + (10 / i));

        StepVerifier.create(fluxCalc)
                .expectNextCount(1)
                .expectError(ArithmeticException.class)
                .verify();
    }


}
