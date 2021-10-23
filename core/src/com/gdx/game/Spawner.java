package com.gdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import java.util.Random;

public class Spawner {
    ShapeRenderer renderer;
    BitmapFont font;
    Random r;
    int ypos;
    int xpos;

    Player player;
    BottomBar bottomBar;
    ElementStorage storage;

    Element targetElement;
    Element currentElement;

    public Spawner(Player player, BottomBar bottomBar, ElementStorage storage) {
        this.player = player;
        this.bottomBar = bottomBar;
        this.storage = storage;
    }

    public void create() {
        font = new BitmapFont();
        renderer = new ShapeRenderer();
        r = new Random();

        resetTarget();
        resetSpawner();
    }

    public void render(SpriteBatch batch) {
        batch.begin();

        renderer.begin(ShapeRenderer.ShapeType.Filled);
        renderer.setColor(Color.RED);
        renderer.rect(xpos, ypos, GameConstants.ELEMENT_WIDTH, GameConstants.ELEMENT_HEIGHT);

        renderer.end();

        ypos -= GameConstants.ELEMENT_SPEED;
        batch.end();

        batch.begin();
        font.setColor(Color.BLACK);
        font.draw(batch,currentElement.Symbol, xpos, ypos + GameConstants.ELEMENT_HEIGHT);
        batch.end();


        if(ypos <= GameConstants.BOTTOMBAR_HEIGHT + GameConstants.PLAYER_HEIGHT) {
            //Check for collision
            int playerX = player.getX();
            if (playerX < xpos + GameConstants.ELEMENT_WIDTH && playerX + GameConstants.PLAYER_WIDTH > xpos) {
                //Collision occured -> Check if target === current
                if(targetElement.Symbol.equals(currentElement.Symbol)) {
                    bottomBar.addPoint();
                    resetSpawner();
                } else {
                    Gdx.app.log("Game Over", "The end");
                }
            }
        }
        if(ypos < GameConstants.BOTTOMBAR_HEIGHT) //Element is under Bottombar
        {
            resetSpawner();
        }

    }

    public void resetSpawner() {
        xpos = Math.abs(r.nextInt()) % (GameConstants.SCREEN_WIDTH - GameConstants.ELEMENT_WIDTH);
        ypos = GameConstants.SCREEN_HEIGHT - GameConstants.ELEMENT_HEIGHT;
        currentElement = storage.getRandomElement();
    }

    public void resetTarget() {
        targetElement = storage.getRandomElement();
        bottomBar.setText(targetElement.Name);
    }

    public void dispose() {
        renderer.dispose();
        font.dispose();
    }
}
