package com.frappagames.tetris;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.frappagames.tetris.Screens.MenuScreen;
import com.frappagames.tetris.Tools.Settings;

public class Tetris extends Game {
	public SpriteBatch batch;
	public Color clearColor;
	public static int WIDTH = 720;
	public static int HEIGHT = 1280;
	public TextureAtlas atlas;

	public enum Direction {
		LEFT, RIGHT, UP, DOWN
	}

	public enum GameType {
		CLASSIC, TIME
	}

	public TextureAtlas getAtlas() {
		if (atlas == null) {
			atlas = new TextureAtlas(Gdx.files.internal("tetris.pack"));
		}

		return atlas;
	}

	@Override
	public void create () {
		batch 	   = new SpriteBatch();
		clearColor = Color.valueOf("#000000FF");
		atlas      = getAtlas();
		Settings.load();

		setScreen(new MenuScreen(this));
	}

	@Override
	public void render () {
		super.render();
	}

	@Override
	public void dispose() {
		batch.dispose();
		atlas.dispose();
	}
}
