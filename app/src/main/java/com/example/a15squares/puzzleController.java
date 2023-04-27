package com.example.a15squares;

/* Ruth Shepard */

public class puzzleController {
    private puzzleModel model;
    private puzzleView view;
    String[] puzzle;

    boolean ifWin;

    public puzzleController(puzzleView view) {
        this.view = view;
        model = new puzzleModel();
        puzzle  = model.puzzle;
    }
}