package com.example.a15squares;

import android.content.Context;
import android.graphics.Canvas;
import android.view.SurfaceView;

/* Ruth Shepard */
public class puzzleView extends SurfaceView {
    private puzzleModel model;
    String[] puzzle;
    boolean[] b;
    public puzzleView(Context context) {
        super(context);
        model = new puzzleModel();
        puzzle = model.puzzle;
    }
    @Override
    public void onDraw(Canvas canvas) {
    }
}