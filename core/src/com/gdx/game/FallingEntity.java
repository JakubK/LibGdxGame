package com.gdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class FallingEntity {
    BitmapFont font;
    Texture frame;

    Player player;
    Spawner spawner;

    public FallingEntity(Player p, Spawner s) {
        player = p;
        spawner = s;
    }

    public void load() {
        font = new BitmapFont();
        frame = new Texture("element.png");
    }

    public void render(SpriteBatch batch, int x, int y, String symbol, String targetSymbol) {
        //frame
        batch.begin();
        batch.draw(frame,x,y, GameConstants.ELEMENT_WIDTH, GameConstants.ELEMENT_HEIGHT);
        batch.end();

        //text
        batch.begin();
        font.setColor(Color.WHITE);
        font.draw(batch,symbol, x + (GameConstants.ELEMENT_WIDTH/2) - 10, y + (GameConstants.ELEMENT_HEIGHT/2) + 4);
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
                    spawner.end();
                }
            }
        }
    }

    public void dispose() {
        frame.dispose();
        font.dispose();
    }
}
