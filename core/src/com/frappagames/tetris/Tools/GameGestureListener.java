package com.frappagames.tetris.Tools;

import com.badlogic.gdx.input.GestureDetector.GestureListener;
import com.badlogic.gdx.math.Vector2;
import com.frappagames.tetris.Screens.PlayScreen;
import com.frappagames.tetris.Tetris;

/**
 * Created by gfp on 28/06/16.
 */
public class GameGestureListener implements GestureListener {
    private PlayScreen playScreen;
    float startX, startY;

    public GameGestureListener(PlayScreen playScreen) {
        this.playScreen = playScreen;
    }

    @Override
    public boolean touchDown(float x, float y, int pointer, int button) {
        startX = x;
        startY = y;

        return false;
    }

    @Override
    public boolean tap(float x, float y, int count, int button) {

        return false;
    }

    @Override
    public boolean longPress(float x, float y) {

        return false;
    }

    @Override
    public boolean fling(float velocityX, float velocityY, int button) {

        return false;
    }

    @Override
    public boolean pan(float x, float y, float deltaX, float deltaY) {

        return false;
    }

    @Override
    public boolean panStop(float x, float y, int pointer, int button) {
        float moveX = x - startX;
        float moveY = y - startY;

        // Horizontal
        if (Math.abs(moveX) > Math.abs(moveY)) {
            if (moveX < 0) {
                playScreen.move(Tetris.Direction.LEFT);
            } else {
                playScreen.move(Tetris.Direction.RIGHT);
            }
        } else {
            if (moveY < 0) {
                playScreen.move(Tetris.Direction.UP);
            } else {
                playScreen.move(Tetris.Direction.DOWN);
            }
        }

        return false;
    }

    @Override
    public boolean zoom (float originalDistance, float currentDistance){

        return false;
    }

    @Override
    public boolean pinch(Vector2 initialPointer1, Vector2 initialPointer2, Vector2 pointer1, Vector2 pointer2) {
        return false;
    }

    @Override
    public void pinchStop() {

    }
}
