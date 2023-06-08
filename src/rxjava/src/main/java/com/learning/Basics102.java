package com.learning;

import java.util.ArrayList;
import java.util.List;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import reactor.core.publisher.Flux;

public class Basics102 {

    public static void main(String[] args) {

        /* 3. Operating on stream of data */
        Flux.just(1, 2, 3, 4, 5)
                .map(val -> val * 2) // 1. Mapping data in a stream
                .subscribe(System.out::print);

        List<Integer> elements = new ArrayList<>();
        Flux.just(1, 3, 5)
                .zipWith(Flux.just(2, 4, 6), (a, b) -> a + b) // 2. Zipping/combing two streams
                .subscribe(elements::add);
        System.out.println("\n" + elements);

        /* 4. Back-pressure example */
        // Back-pressure is the ability for the consumer to signal to the producer what
        // rate of emission it can handle, so it does not get overwhelmed.
        Flux.range(1, 5).subscribe(new Subscriber<Integer>() {
            Subscription sub;
            int counter;
            int limit = 2;

            @Override
            public void onSubscribe(Subscription sub) {
                System.out.println("Subscribed");
                this.sub = sub;
                System.out.println("Requesting " + limit + " elements");
                sub.request(limit);
            }

            @Override
            public void onNext(Integer data) {
                System.out.println("Received " + data);
                counter++;
                if (counter % limit == 0) {
                    System.out.println("Requesting " + limit + " elements");
                    sub.request(limit);
                }
            }

            @Override
            public void onComplete() {
                System.out.println("Completed");
            }

            @Override
            public void onError(Throwable err) {
                System.out.println("Error occurred");
            }
        });

    }

}
