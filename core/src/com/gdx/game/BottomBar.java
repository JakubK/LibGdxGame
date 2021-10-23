package com.gdx.game;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class BottomBar {

    ShapeRenderer renderer;
    BitmapFont font;

    int points = 0;

    public void create()
    {
        renderer = new ShapeRenderer();
        font = new BitmapFont();
    }

    public void addPoint() {
        points++;
    }

    public void render(SpriteBatch batch)
    {
        batch.begin();

        renderer.begin(ShapeRenderer.ShapeType.Filled);
        renderer.setColor(Color.WHITE);
        renderer.rect(0, 0, GameConstants.SCREEN_WIDTH, GameConstants.BOTTOMBAR_HEIGHT);
        renderer.end();

        batch.end();

        batch.begin();
        font.setColor(Color.BLACK);
        font.draw(batch,"Points: " + points, 30, 30);

        font.draw(batch, "Next element:", GameConstants.SCREEN_WIDTH - 200, 30);

        batch.end();
    }

    public void dispose()
    {
        renderer.dispose();
        font.dispose();
    }
}
