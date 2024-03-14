package com.example.webflux.avanza;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

public class Principal {

    public static void main(String[] args) {
        ejemplo1();
    }

    public static void ejemplo1() {

        List<String> listMono = new ArrayList<>();
        List<String> listMono2 = new ArrayList<>();
        List<String> listFlux = new ArrayList<>();

        //Crear un mono
        Mono<String> mono = Mono.just("5");
        Mono<String> mono2 = Mono.fromSupplier(
                () -> {
                    throw new RuntimeException("Error ocurrido");
                }
        );
        Flux<String> flux = Flux.just("20", "6", "7");

        //suscribirse
        mono.subscribe(listMono::add);  //mono.subscribe(x -> listMono.add(x) );
        mono.subscribe(
                data -> System.out.println(data),   //onNext
                error -> System.out.println(error), //onError
                () -> System.out.println("Completado mono")  //onComplete
        );
        mono2.subscribe(
                data -> System.out.println(data),   //onNext
                error -> System.out.println(error), //onError
                () -> System.out.println("Completado mono error")  //onComplete
        );
        flux.subscribe(listFlux::add);  //mono.subscribe(x -> listMono.add(x) );
        flux.subscribe(
                data -> System.out.println(data),   //onNext
                error -> System.out.println(error), //onError
                () -> System.out.println("Completado flux")  //onComplete
        );

        //imprimir elementos del flujo
        System.out.println(listMono);
        System.out.println(listFlux);
    }
}
