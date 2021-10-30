package com.gdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Player {
    Texture img;
    BottomBar bottomBar;
    int x = 0;

    public int getX() {
        return x;
    }

    public Player(BottomBar bar){
        this.bottomBar = bar;
    }

    public void create() {
        img = new Texture("player.png");
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
        batch.draw(img,x,50,GameConstants.PLAYER_WIDTH,GameConstants.PLAYER_HEIGHT);
        batch.end();
    }

    public void dispose() {
        img.dispose();
    }
}
