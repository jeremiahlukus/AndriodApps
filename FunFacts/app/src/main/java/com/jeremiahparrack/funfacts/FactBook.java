package com.jeremiahparrack.funfacts;

import java.util.Random;

/**
 * Created by jeremiahparrack on 9/4/17.
 */

class FactBook {

    private final String[] facts = new String[]{
            "Ants stretch when they wake up in the morning.",
            "Ostriches can run faster than horses.",
            "Olympic gold medals are actually made mostly of silver.",
            "You are born with 300 bones; by the time you are an adult you will have 206.",
            "It takes about 8 minutes for light from the Sun to reach Earth.",
            "Some bamboo plants can grow almost a meter in just one day.",
            "The state of Florida is bigger than England.",
            "Some penguins can leap 2-3 meters out of the water.",
            "On average, it takes 66 days to form a new habit.",
            "Mammoths still walked the earth when the Great Pyramid was being built."
    };

    String getFact() {
        // Update the tvFactView with a new Fact
        Random rand = new Random();
        int randNum = rand.nextInt(facts.length);
        return facts[randNum];
    }
}
