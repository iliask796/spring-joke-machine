package com.booleanuk.jokemachine;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class JokeMachineControllerTest {
    @Test
    void testGetJoke() {
        JokeMachineController machine = new JokeMachineController();
        String expected = "What sort of car does an egg drive? - A yolkswagen!!!";
        Assertions.assertEquals(expected, machine.getJoke());
    }
}
