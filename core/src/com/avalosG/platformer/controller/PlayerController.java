package com.avalosG.platformer.controller;

import com.avalosG.platformer.model.Player;
import com.badlogic.gdx.graphics.g2d.Batch;

public class PlayerController {

    public static Player player;

    public static void initializeController() {

        player =  new Player(70, 100);

    }

    public static void update(float deltaTime) {

        player.update(deltaTime); // updating our player using delta

    }

    public static void draw(Batch spriteBatch) {

        player.draw(spriteBatch);

    }
}
