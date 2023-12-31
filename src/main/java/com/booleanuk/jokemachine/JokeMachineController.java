package com.booleanuk.jokemachine;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Random;

@RestController
@RequestMapping("/jokes")
public class JokeMachineController {
    private final ArrayList<String> jokes;
    Random random;

    public JokeMachineController(){
        jokes = new ArrayList<>(){
            {
                add("What sort of car does an egg drive? - A yolkswagen.");
                add("What is red and smells like blue paint? -Red paint.");
                add("Why aren’t koalas actual bears? -The don’t meet the koalafications.");
                add("What do you call bears with no ears? -B.");
            }
        };
        random = new Random();
    }

    @GetMapping
    public String getJoke(){
        return jokes.get(random.nextInt(0,4));
    }

    @GetMapping("/number")
    public int numberOfJokes() {
        return this.jokes.size();
    }

    @GetMapping("/number/{index}")
    public String getSpecificJoke(@PathVariable int index) {
        if (index >= numberOfJokes()) {
            return "I'm sorry we don't know that many jokes. Please choose a smaller number.";
        }
        return this.jokes.get(index);
    }
}
