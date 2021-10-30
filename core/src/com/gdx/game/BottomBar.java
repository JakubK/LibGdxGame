package com.gdx.game;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class BottomBar {
    Texture frame;
    BitmapFont font;

    int points = 0;

    String nextElementText = "";

    public void create()
    {
        frame = new Texture("frame.png");
        font = new BitmapFont();
    }

    public void setText(String text) {
        nextElementText = text;
    }

    public void addPoint() {
        points++;
    }


    int frameWidth = 250;
    public void render(SpriteBatch batch)
    {
        batch.begin();
        batch.draw(frame,GameConstants.SCREEN_WIDTH/2 - frameWidth/2,0,frameWidth,GameConstants.BOTTOMBAR_HEIGHT);
        batch.end();

        batch.begin();
        font.setColor(Color.WHITE);
        font.draw(batch,"Points: " + points, GameConstants.SCREEN_WIDTH/2 - frameWidth/6, 30);
        font.draw(batch, "Next element: " + nextElementText, GameConstants.SCREEN_WIDTH - 200, 30);
        batch.end();
    }

    public void dispose()
    {
        frame.dispose();
        font.dispose();
    }
}
