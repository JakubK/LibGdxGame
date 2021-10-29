package com.gdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class FallingEntity {
    ShapeRenderer renderer;
    BitmapFont font;

    Player player;
    Spawner spawner;

    public FallingEntity(Player p, Spawner s) {
        player = p;
        spawner = s;
    }

    public void load() {
        renderer = new ShapeRenderer();
        font = new BitmapFont();
    }

    public void render(SpriteBatch batch, int x, int y, String symbol, String targetSymbol) {
        //frame
        batch.begin();
        renderer.begin(ShapeRenderer.ShapeType.Filled);
        renderer.setColor(Color.RED);
        renderer.rect(x, y, GameConstants.ELEMENT_WIDTH, GameConstants.ELEMENT_HEIGHT);
        renderer.end();
        batch.end();

        //text
        batch.begin();
        font.setColor(Color.BLACK);
        font.draw(batch,symbol, x, y + GameConstants.ELEMENT_HEIGHT);
        batch.end();

        //Check for collision
        if(y <= GameConstants.BOTTOMBAR_HEIGHT + GameConstants.PLAYER_HEIGHT) {
            //Check for collision
            int playerX = player.getX();
            if (playerX < x + GameConstants.ELEMENT_WIDTH && playerX + GameConstants.PLAYER_WIDTH > x) {
                //Collision occured -> Check if target === current
                if(targetSymbol.equals(symbol)) {
                    spawner.addPoint();
                } else {
                    Gdx.app.log("Game Over", "The end");
                }
            }
        }
    }

    public void dispose() {
        renderer.dispose();
        font.dispose();
    }
}
