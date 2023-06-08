package com.learning;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import reactor.core.publisher.Flux;

public class Basics101Test {

    @Test
    public void streamData() {
        // GIVEN: Stream of data
        List<Integer> elements = new ArrayList<>();
        Flux<Integer> flux = Flux.just(1, 2, 3, 4);

        // WHEN: Subscribe to stream, add data to list
        flux.subscribe(elements::add);

        // THEN: Verify the result
        assertEquals(elements, new ArrayList<>(List.of(1, 2, 3, 4)));
    }

}
