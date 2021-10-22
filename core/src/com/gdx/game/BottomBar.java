package com.gdx.game;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class BottomBar {

    ShapeRenderer renderer;
    BitmapFont font;

    public void create()
    {
        renderer = new ShapeRenderer();
        font = new BitmapFont();
    }

    public void render(SpriteBatch batch)
    {
        batch.begin();

        renderer.begin(ShapeRenderer.ShapeType.Filled);
        renderer.setColor(Color.WHITE);
        renderer.rect(0, 0, GameConstants.SCREEN_WIDTH, 50);
        renderer.end();


        batch.end();

        batch.begin();
        font.setColor(Color.BLACK);
        font.draw(batch,"Points: 0", 30, 30);

        font.draw(batch, "Next element:", GameConstants.SCREEN_WIDTH - 200, 30);

        batch.end();
    }

    public void dispose()
    {
        renderer.dispose();
        font.dispose();
    }
}
