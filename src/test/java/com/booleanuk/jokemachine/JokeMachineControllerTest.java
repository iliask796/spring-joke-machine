package com.booleanuk.jokemachine;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class JokeMachineControllerTest {
    @Test
    void testGetJoke() {
        JokeMachineController machine = new JokeMachineController();
        machine.random.setSeed(100);
        String expected = "Why aren’t koalas actual bears? -The don’t meet the koalafications.";
        Assertions.assertEquals(expected, machine.getJoke());
        expected = "What sort of car does an egg drive? - A yolkswagen.";
        Assertions.assertEquals(expected, machine.getJoke());
        expected = "What is red and smells like blue paint? -Red paint.";
        Assertions.assertEquals(expected, machine.getJoke());
    }

    @Test
    void testNumberOfJokes() {
        JokeMachineController machine = new JokeMachineController();
        Assertions.assertEquals(4, machine.numberOfJokes());
    }

    @Test
    void testGetSpecificJoke() {
        JokeMachineController machine = new JokeMachineController();
        String expected = "What do you call bears with no ears? -B.";
        Assertions.assertEquals(expected, machine.getSpecificJoke(3));
    }

    @Test
    void testGetErrorWhenIndexOutOfBounds() {
        JokeMachineController machine = new JokeMachineController();
        String expected = "I'm sorry we don't know that many jokes. Please choose a smaller number.";
        Assertions.assertEquals(expected, machine.getSpecificJoke(1000));
    }
}
