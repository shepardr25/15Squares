package com.example.a15squares;

import java.util.ArrayList;
import java.util.Random;

/* Ruth Shepard */
public class puzzleModel {
    String[] puzzle = new String[16];
    public puzzleModel() {
        // make array list with numbers from 0 to 15
        ArrayList<Integer> list = new ArrayList<Integer>(16);
        for(int i = 0; i <= 15; i++) {
            list.add(i);
        }
        Random rand = new Random();

        int i = 0;

        // randomly assigns numbers to random positions in puzzle board
        while(list.size() > 0) {
            int index = rand.nextInt(list.size());
            puzzle[i] = Integer.toString(list.remove(index));
            i++;
        }
        i = 0;
        // sets 0 to a blank space
        for (int j = 0; j < 16; j++) {
            if (puzzle[j].equals(Integer.toString(0))) {
                puzzle[j] = " ";
            }
        }
    }
}