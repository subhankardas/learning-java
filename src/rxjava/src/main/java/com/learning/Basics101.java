package com.learning;

import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class Basics101 {

    /**
     * Reactive Stream Workflow:
     * PUBLISHER   <--- subscribe() ---  SUBSCRIBER           
     *             --- Subscription --->
     * 
     * PUBLISHER   <--- request(n) ---  SUBSCRIBER
     *              --- onNext(1) ---> 
     *              --- onNext(2) --->....
     *              --- onNext(n) --->
     * 
     * PUBLISHER   --- onComplete() / onError() --->  SUBSCRIBER
     */
    public static void main(String[] args) {

        /* 1. Producing stream of data */
        Flux<Integer> flux = Flux.just(1, 2, 3, 4); // 1. Flux is a stream that can emit 0...N elements.
        Mono<Integer> mono = Mono.just(1); // 2. Mono is a stream that can emit only 1 element.

        // Both Flux and Mono are implementations of Reactive Streams Publisher
        // interface.
        Publisher<String> fPublisher = Flux.just("Hello", " World! ", "of", " Reactive Java!");
        Publisher<String> mPublisher = Mono.just("Hi Reactive Java!");

        /* 2. Subscribing to stream of data */
        flux.subscribe(System.out::print);
        mono.subscribe(System.out::println);

        fPublisher.subscribe(new Subscriber<String>() {
            @Override
            public void onSubscribe(Subscription sub) {
                sub.request(2); // Request 2 elements from stream.
            }

            @Override
            public void onNext(String val) {
                System.out.print(val); // On receiving next value, print it.
            }

            @Override
            public void onComplete() {
            }

            @Override
            public void onError(Throwable err) {
            }
        });

    }

}
