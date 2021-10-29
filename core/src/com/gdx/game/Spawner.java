package com.gdx.game;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import java.util.Random;

public class Spawner {
    ShapeRenderer renderer;
    BitmapFont font;
    Random r;
    int ypos;

    Player player;
    BottomBar bottomBar;
    ElementStorage storage;

    Element targetElement;
    FallingEntity[] entities;
    Element[] elements;

    public Spawner(Player player, BottomBar bottomBar, ElementStorage storage) {
        this.player = player;
        this.bottomBar = bottomBar;
        this.storage = storage;

        r = new Random();

        entities = new FallingEntity[GameConstants.ENTITY_COUNT];
        for(int i = 0;i < GameConstants.ENTITY_COUNT;i++) {
            entities[i] = new FallingEntity(player, this);
        }
    }

    public void create() {
        font = new BitmapFont();
        renderer = new ShapeRenderer();

        for(int i = 0;i < GameConstants.ENTITY_COUNT;i++) {
            entities[i].load();
        }

        resetTurn();
    }

    public void render(SpriteBatch batch) {
        for(int i = 0;i < GameConstants.ENTITY_COUNT;i++) {
            entities[i].render(batch,GameConstants.ENTITY_START_X + i * GameConstants.ENTITY_SPACING,ypos, elements[i].Symbol, targetElement.Symbol);
        }
        ypos -= GameConstants.ELEMENT_SPEED;
        if(ypos < GameConstants.BOTTOMBAR_HEIGHT) //Element is under Bottombar
        {
            resetTurn();
        }
    }

    public void addPoint() {
        bottomBar.addPoint();
        resetTurn();
    }

    public void resetTurn() {
        ypos = GameConstants.SCREEN_HEIGHT - GameConstants.ELEMENT_HEIGHT;
        elements = storage.getRandomElements();
        targetElement = elements[Math.abs(r.nextInt()) % elements.length];
        bottomBar.setText(targetElement.Name);
    }

    public void dispose() {
        renderer.dispose();
        font.dispose();
    }
}
