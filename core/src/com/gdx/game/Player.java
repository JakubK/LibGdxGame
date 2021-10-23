package com.gdx.game;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Player {
    ShapeRenderer renderer;
    BottomBar bottomBar;
    int x = 0;

    public Player(BottomBar bar){
        this.bottomBar = bar;
    }

    public void create() {
        renderer = new ShapeRenderer();
    }

    void input() {
        if(Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            if(x - GameConstants.PLAYER_SPEED > 0)
                x -= GameConstants.PLAYER_SPEED;
            else
                x = 0;
        }
        else if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            if(x + GameConstants.PLAYER_SPEED < GameConstants.SCREEN_WIDTH - GameConstants.PLAYER_WIDTH)
                x += GameConstants.PLAYER_SPEED;
            else
                x = GameConstants.SCREEN_WIDTH - GameConstants.PLAYER_WIDTH;
        }
    }


    public void render(SpriteBatch batch) {

        input();

        batch.begin();
        renderer.begin(ShapeRenderer.ShapeType.Filled);
        renderer.setColor(Color.BLUE);
        renderer.rect(x,50,GameConstants.PLAYER_WIDTH,GameConstants.PLAYER_HEIGHT);
        renderer.end();
        batch.end();
    }

    public void dispose() {
        renderer.dispose();
    }
}
