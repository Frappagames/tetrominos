package com.frappagames.tetris.Tools;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.frappagames.tetris.Screens.PlayScreen;
import com.frappagames.tetris.Tetris;

/**
 * Created by gfp on 28/06/16.
 */
public class GameInputProcessor implements InputProcessor {
    private PlayScreen playScreen;

    public GameInputProcessor(PlayScreen playScreen) {
        this.playScreen = playScreen;
    }

    public boolean keyDown (int keycode) {
        return false;
    }

    public boolean keyUp (int keycode) {
        switch (keycode) {
            case Input.Keys.LEFT:
                playScreen.move(Tetris.Direction.LEFT);
                break;
            case Input.Keys.RIGHT:
                playScreen.move(Tetris.Direction.RIGHT);
                break;
            case Input.Keys.UP:
                playScreen.move(Tetris.Direction.UP);
                break;
            case Input.Keys.DOWN:
                playScreen.move(Tetris.Direction.DOWN);
                break;
        }

        return false;
    }

    public boolean keyTyped (char character) {
        return false;
    }

    public boolean touchDown (int x, int y, int pointer, int button) {
        return false;
    }

    public boolean touchUp (int x, int y, int pointer, int button) {
        return false;
    }

    public boolean touchDragged (int x, int y, int pointer) {
        return false;
    }

    public boolean mouseMoved (int x, int y) {
        return false;
    }

    public boolean scrolled (int amount) {
        return false;
    }
}
