package com.frappagames.tetris.desktop;

import com.badlogic.gdx.Files;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.frappagames.tetris.Tetris;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "Tetris";
		config.width = Tetris.WIDTH / 2;
		config.height = Tetris.HEIGHT / 2;
		config.addIcon("icon-128.png", Files.FileType.Internal);
		config.addIcon("icon-32.png", Files.FileType.Internal);
		config.addIcon("icon-16.png", Files.FileType.Internal);
		new LwjglApplication(new Tetris(), config);
	}
}
