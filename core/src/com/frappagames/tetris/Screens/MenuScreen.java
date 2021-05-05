package com.frappagames.tetris.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.frappagames.tetris.Tetris;
import com.frappagames.tetris.Tools.GameScreen;

/**
 * Menu principal
 *
 * Created by Miridan on 30/06/16.
 */
public class MenuScreen extends GameScreen {
    private static final String WEBSITE_LINK = "http://frappagames.itch.io";
    private final BitmapFont font;
    private Image background;
    private Image menuBackground;

    public MenuScreen(final Tetris game) {
        super(game);

        Skin skin = new Skin();
        skin.addRegions(game.getAtlas());

        font = new BitmapFont(Gdx.files.internal("xolonium-48.fnt"), false);
        menuBackground = new Image(game.getAtlas().findRegion("menu-background"));

        Image titleImg = new Image(game.getAtlas().findRegion("logo"));

        TextButtonStyle bluedBtnSkin = new TextButtonStyle();
        bluedBtnSkin.font = font;
        bluedBtnSkin.up = skin.getDrawable("btn-blue-default");
        bluedBtnSkin.down = skin.getDrawable("btn-blue-clicked");
        bluedBtnSkin.over = skin.getDrawable("btn-blue-over");

        TextButtonStyle brownBtnSkin = new TextButtonStyle();
        brownBtnSkin.font = font;
        brownBtnSkin.up = skin.getDrawable("btn-orange-default");
        brownBtnSkin.down = skin.getDrawable("btn-orange-clicked");
        brownBtnSkin.over = skin.getDrawable("btn-orange-over");

        TextButton playBtn = new TextButton("PLAY", bluedBtnSkin);
        TextButton options = new TextButton("OPTIONS", bluedBtnSkin);
        TextButton scoreBtn = new TextButton("SCORES", bluedBtnSkin);
        TextButton healpBtn = new TextButton("HELP", bluedBtnSkin);
        TextButton aboutBtn = new TextButton("ABOUT", bluedBtnSkin);
        TextButton exitBtn = new TextButton("EXIT", brownBtnSkin);

        Image authorImg = new Image(game.getAtlas().findRegion("signature"));

        Table table = new Table();
        table.setFillParent(true);
        table.add(titleImg).pad(60, 0, 145, 0).row();
        table.add(playBtn).pad(15).row();
        table.add(options).pad(15).row();
        table.add(healpBtn).pad(15).row();
        table.add(aboutBtn).pad(15).row();
        table.add(exitBtn).pad(45, 15, 135, 15).row();
        table.add(authorImg).pad(15, 0, 0, 0).row();

        stage.addActor(table);
        Gdx.input.setInputProcessor(stage);

        playBtn.addListener(new ChangeListener() {
            public void changed(ChangeEvent event, Actor actor) {
                game.setScreen(new PlayScreen(game));
            }
        });

        options.addListener(new ChangeListener() {
            public void changed(ChangeEvent event, Actor actor) {
                game.setScreen(new OptionsScreen(game));
            }
        });

        scoreBtn.addListener(new ChangeListener() {
            public void changed(ChangeEvent event, Actor actor) {
                game.setScreen(new ScoreScreen(game));
            }
        });

        healpBtn.addListener(new ChangeListener() {
            public void changed(ChangeEvent event, Actor actor) {
                game.setScreen(new HowToPlayScreen(game));
            }
        });

        aboutBtn.addListener(new ChangeListener() {
            public void changed(ChangeEvent event, Actor actor) {
                game.setScreen(new AboutScreen(game));
            }
        });

        exitBtn.addListener(new ChangeListener() {
            public void changed(ChangeEvent event, Actor actor) {
                Gdx.app.exit();
            }
        });

        authorImg.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                Gdx.net.openURI(WEBSITE_LINK);
            }
        });
    }

    @Override
    public void update(float delta) {
        stage.act(delta);
    }

    @Override
    public void draw(float delta) {
        game.batch.begin();
        menuBackground.setPosition(95, 240);
        menuBackground.draw(game.batch, 1);
        game.batch.end();

        stage.draw();
    }

    @Override
    public void dispose() {
        super.dispose();
        font.dispose();
    }
}
