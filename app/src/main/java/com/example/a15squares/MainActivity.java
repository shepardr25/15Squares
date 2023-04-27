package com.example.a15squares;

import androidx.appcompat.app.AppCompatActivity;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import java.util.ArrayList;
import java.util.Random;

/* Ruth Shepard */

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    puzzleModel model;
    Button b1, b2, b3, b4, b5, b6, b7, b8, b9, b10, b11, b12, b13, b14, b15, b16, reset;

    String[] ifWin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // build background
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        model = new puzzleModel();
        setContentView(R.layout.activity_main);

        // determine winner
        ifWin = new String[15];

        for (int i = 0; i < 15; i++) {
            ifWin[i] = Integer.toString(i + 1);
        }

        // set up buttons with findID and onClickListener (register)

        // button 1
        b1  = findViewById(R.id.button);
        b1.setOnClickListener(this);

        // button 2
        b2 = findViewById(R.id.button2);
        b2.setOnClickListener(this);

        // button 3
        b3 = findViewById(R.id.button3);
        b3.setOnClickListener(this);

        // button 4
        b4 = findViewById(R.id.button4);
        b4.setOnClickListener(this);

        // button 5
        b5 = findViewById(R.id.button5);
        b5.setOnClickListener(this);

        // button 6
        b6 = findViewById(R.id.button6);
        b6.setOnClickListener(this);

        // button  7
        b7 = findViewById(R.id.button7);
        b7.setOnClickListener(this);

        // button 8
        b8 = findViewById(R.id.button8);
        b8.setOnClickListener(this);

        // button 9
        b9 = findViewById(R.id.button9);
        b9.setOnClickListener(this);

        // button 10
        b10 = findViewById(R.id.button10);
        b10.setOnClickListener(this);

        // button 11
        b11 = findViewById(R.id.button11);
        b11.setOnClickListener(this);

        // button 12
        b12 = findViewById(R.id.button12);
        b12.setOnClickListener(this);

        // button 13
        b13 = findViewById(R.id.button13);
        b13.setOnClickListener(this);

        // button 14
        b14 = findViewById(R.id.button14);
        b14.setOnClickListener(this);

        // button 15
        b15 = findViewById(R.id.button15);
        b15.setOnClickListener(this);

        // button 16
        b16 = findViewById(R.id.button16);
        b16.setOnClickListener(this);

        // button 17
        reset = findViewById(R.id.resetButton);
        reset.setOnClickListener(this);

        // initialize buttons with numbers
        // will appear randomly on the grid
        b1.setText(model.puzzle[0]);
        b2.setText(model.puzzle[1]);
        b3.setText(model.puzzle[2]);
        b4.setText(model.puzzle[3]);
        b5.setText(model.puzzle[4]);
        b6.setText(model.puzzle[5]);
        b7.setText(model.puzzle[6]);
        b8.setText(model.puzzle[7]);
        b9.setText(model.puzzle[8]);
        b10.setText(model.puzzle[9]);
        b11.setText(model.puzzle[10]);
        b12.setText(model.puzzle[11]);
        b13.setText(model.puzzle[12]);
        b14.setText(model.puzzle[13]);
        b15.setText(model.puzzle[14]);
        b16.setText(model.puzzle[15]);
        reset.setText("RESET");

        if (checkWinner()) {
            Log.d("win", "OHMYGOODNESS!!!!YOU ACTUALLY WON");
            changeBackground();
        }
    }
    @Override
    public void onClick(View view) {
        // crazy long if-statement that determines if button is pressed
        // then will update based on button click

        if (b1.equals(view)) {
            update(model.puzzle, 0);
        }
        else if (b2.equals(view)) {
            update(model.puzzle, 1);
        }
        else if (b3.equals(view)) {
            update(model.puzzle, 2);
        }
        else if (b4.equals(view)) {
            update(model.puzzle, 3);
        }
        else if (b5.equals(view)) {
            update(model.puzzle, 4);
        }
        else if (b6.equals(view)) {
            update(model.puzzle, 5);
        }
        else if (b7.equals(view)) {
            update(model.puzzle, 6);
        }
        else if (b8.equals(view)) {
            update(model.puzzle, 7);
        }
        else if (b9.equals(view)) {
            update(model.puzzle, 8);
        }
        else if (b10.equals(view)) {
            update(model.puzzle, 9);
        }
        else if (b11.equals(view)) {
            update(model.puzzle, 10);
        }
        else if (b12.equals(view)) {
            update(model.puzzle, 11);
        }
        else if (b13.equals(view)) {
            Log.d("here", Integer.toString(13));
            update(model.puzzle, 12);
        }
        else if (b14.equals(view)) {
            Log.d("here", Integer.toString(14));
            update(model.puzzle, 13);
        }
        else if (b15.equals(view)) {
            Log.d("here", Integer.toString(15));
            update(model.puzzle, 14);
        }
        else if (b16.equals(view)) {
            Log.d("here", Integer.toString(16));
            update(model.puzzle, 15);
        }
        else if (reset.equals(view)) {
            // if reset button clicked then board will redraw
            // the numbers will appear in a random order

            ArrayList<Integer> list = new ArrayList<Integer>(16);
            for(int i = 0; i <= 15; i++) {
                list.add(i);
            }

            Random rand = new Random();

            int x = 0;
            while(list.size() > 0) {
                int index = rand.nextInt(list.size());
                model.puzzle[x] = Integer.toString(list.remove(index));
                x++;
            }
            x = 0;


            for (int j = 0; j < 16; j++) {
                if (model.puzzle[j].equals(Integer.toString(0))) {
                    model.puzzle[j] = " ";
                }
            }

            update(model.puzzle,0);
        }

        if (checkWinner()) {
            Log.d("here", "Oh my goodness!!! You won!!!");
            changeBackground();
        }
    }
    public void update(String[] puzzle,int puzzlePiece) {
        if (checkWinner()) {
            Log.d("here", "Oh my gosh!!! you won!!!");
            changeBackground();
        }


        // if piece is empty, then below will swap
        if (puzzlePiece < 15 && model.puzzle[puzzlePiece + 1].equals(" ")) {
            model.puzzle[puzzlePiece + 1] = model.puzzle[puzzlePiece];
            model.puzzle[puzzlePiece] = " ";
        }
        // if piece empty, the program leaves it that way
        else if (puzzlePiece > 0 && model.puzzle[puzzlePiece - 1].equals(" ")) {
            model.puzzle[puzzlePiece - 1] = model.puzzle[puzzlePiece];
            model.puzzle[puzzlePiece] = " ";
        }
        // checks empty space below
        else if (puzzlePiece <= 11 && puzzle[puzzlePiece + 4].equals(" ")) {
            puzzle[puzzlePiece+4] = puzzle[puzzlePiece];
            puzzle[puzzlePiece] = " ";
        }
        // checks above empty space to swap
        else if (puzzlePiece >= 4 && puzzle[puzzlePiece - 4].equals(" ")) {
            puzzle[puzzlePiece - 4] = puzzle[puzzlePiece];
            puzzle[puzzlePiece] = " ";
        }

        // update buttons after if-statements

        // button 1
        b1.setText(model.puzzle[0]);
        b1.invalidate();

        // button  2
        b2.setText(model.puzzle[1]);
        b2.invalidate();

        // button  3
        b3.setText(model.puzzle[2]);
        b3.invalidate();

        // button 4
        b4.setText(model.puzzle[3]);
        b4.invalidate();

        // button5
        b5.setText(model.puzzle[4]);
        b5.invalidate();

        // button 6
        b6.setText(model.puzzle[5]);
        b6.invalidate();

        // button  7
        b7.setText(model.puzzle[6]);
        b7.invalidate();

        // button 8
        b8.setText(model.puzzle[7]);
        b8.invalidate();

        // button 9
        b9.setText(model.puzzle[8]);
        b9.invalidate();

        // button 10
        b10.setText(model.puzzle[9]);
        b10.invalidate();

        // button 11
        b11.setText(model.puzzle[10]);
        b11.invalidate();

        // button 12
        b12.setText(model.puzzle[11]);
        b12.invalidate();

        // button 13
        b13.setText(model.puzzle[12]);
        b13.invalidate();

        // button 14
        b14.setText(model.puzzle[13]);
        b14.invalidate();

        // button 15
        b15.setText(model.puzzle[14]);
        b15.invalidate();

        // button 16
        b16.setText(model.puzzle[15]);
        b16.invalidate();
    }
    public void changeBackground() {
        // changes background on win condition
        final TableLayout tableLayout;
        tableLayout = findViewById(R.id.background);
        tableLayout.setBackgroundColor(Color.GREEN);
    }
    public boolean checkWinner() {
        // checks if winning condition is on the board
        for (int i = 0; i < 15; i++) {
            if (!ifWin[i].equals(model.puzzle[i])) {
                return false;
            }
        }
        return true;
    }
}