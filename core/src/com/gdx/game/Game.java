package com.gdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.ScreenUtils;

public class Game extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
	BitmapFont font;
	ShapeRenderer shapeRenderer;

	BottomBar bottomBar;
	Player player;
	ElementStorage storage;
	Spawner spawner;

	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Texture("background.jpg");
		font = new BitmapFont();
		shapeRenderer = new ShapeRenderer();

		bottomBar = new BottomBar();
		bottomBar.create();

		player = new Player(bottomBar);
		player.create();

		storage = new ElementStorage();
		storage.create();

		spawner = new Spawner(player, bottomBar, storage);
		spawner.create();
	}

	@Override
	public void render () {
		ScreenUtils.clear(0.9f, 0.9f, 0.9f, 1);
		batch.begin();
		batch.draw(img,0,0);
		batch.end();
//		batch.begin();//image
//		batch.draw(img, 0, 0);
//		batch.end();
//
//		batch.begin();//rect
//		shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
//		shapeRenderer.setColor(Color.BLACK);
//		shapeRenderer.rect(0, 0, 50, 50);
//		shapeRenderer.end();
//		batch.end();
//
//		batch.begin();//text
//		font.draw(batch, "Hello LibGDX", 10,20);
//		batch.end();
		spawner.render(batch);
		bottomBar.render(batch);
		player.render(batch);
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
		font.dispose();
		shapeRenderer.dispose();

		bottomBar.dispose();
		player.dispose();
		spawner.dispose();
		storage.dispose();
	}
}
