package com.gdx.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.gdx.game.Game;
import com.gdx.game.GameConstants;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = GameConstants.SCREEN_WIDTH;
		config.height = GameConstants.SCREEN_HEIGHT;
		config.resizable = false;
		new LwjglApplication(new Game(), config);
	}
}
