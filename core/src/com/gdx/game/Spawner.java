package com.gdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import java.util.Random;

public class Spawner {
    ShapeRenderer renderer;
    Random r;
    int ypos;
    int xpos;

    Player player;
    BottomBar bottomBar;
    public Spawner(Player player, BottomBar bottomBar) {
        this.player = player;
        this.bottomBar = bottomBar;
    }

    public void create() {
        renderer = new ShapeRenderer();
        r = new Random();

        xpos = Math.abs(r.nextInt()) % (GameConstants.SCREEN_WIDTH - GameConstants.ELEMENT_WIDTH);
        ypos = GameConstants.SCREEN_HEIGHT - GameConstants.ELEMENT_HEIGHT;
    }

    public void render(SpriteBatch batch) {
        batch.begin();
        renderer.begin(ShapeRenderer.ShapeType.Filled);
        renderer.setColor(Color.RED);
        for(int i = 0;i < 1;i++)
        {
            renderer.rect(xpos, ypos, GameConstants.ELEMENT_WIDTH, GameConstants.ELEMENT_HEIGHT);
        }
        renderer.end();

        ypos -= GameConstants.ELEMENT_SPEED;

        if(ypos <= GameConstants.BOTTOMBAR_HEIGHT + GameConstants.PLAYER_HEIGHT) {
            //Check for collision
            int playerX = player.getX();
            if (playerX < xpos + GameConstants.ELEMENT_WIDTH && playerX + GameConstants.PLAYER_WIDTH > xpos) {
                bottomBar.addPoint();
                resetSpawner();
            }
        }
        if(ypos < GameConstants.BOTTOMBAR_HEIGHT) //Element is under Bottombar
        {
            ypos = GameConstants.SCREEN_HEIGHT - GameConstants.ELEMENT_HEIGHT;
        }

        batch.end();
    }

    public void resetSpawner() {
        xpos = Math.abs(r.nextInt()) % (GameConstants.SCREEN_WIDTH - GameConstants.ELEMENT_WIDTH);
        ypos = GameConstants.SCREEN_HEIGHT - GameConstants.ELEMENT_HEIGHT;

    }

    public void dispose() {
        renderer.dispose();
    }
}
