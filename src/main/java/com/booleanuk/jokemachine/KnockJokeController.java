package com.booleanuk.jokemachine;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

@RestController
@RequestMapping("/knock")
public class KnockJokeController {
    private final ArrayList<String[]> knockJokes;
    Random random;

    public KnockJokeController() {
        this.knockJokes = new ArrayList<>(){
            {
                add(new String[]{"Knock, knock. ", "Who's there? ", "Boo. ", "Boo who? ", "Don't cry it's just a joke. "});
                add(new String[]{"Knock, knock. ", "Who’s there? ", "Amish. ", "Amish who? ", "Really? You don’t look like a shoe! "});
                add(new String[]{"Knock, knock. ", "Who’s there? ", "Atch. ", "Atch who? ", "Bless you! "});
            }
        };
        random = new Random();
    }

    @GetMapping
    public String placeholder(){
        return Arrays.toString(this.knockJokes.get(random.nextInt(this.knockJokes.size())));
    }

    @GetMapping("/{index}")
    public String startSpecificJoke(@PathVariable int index){
        if (index >= this.knockJokes.size()){
            return "We only have " + this.knockJokes.size() + ". So please select accordingly.";
        }
        return this.knockJokes.get(index)[0];
    }

    @GetMapping("/{index}/{line}")
    public String continueSpecificJoke(@PathVariable int index, @PathVariable int line){
        if (index >= this.knockJokes.size()){
            return "We only have " + this.knockJokes.size() + ". So please select accordingly.";
        }
        if (line < 2 || line > 5){
            return "To continue the joke you need a number between 2-5 in order";
        }
        StringBuilder joke = new StringBuilder();
        for (int i=0; i<line; i++){
            joke.append(this.knockJokes.get(index)[i]);
        }
        return String.valueOf(joke);
    }
}
