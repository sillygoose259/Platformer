package com.avalosG.platformer.controller;

import com.avalosG.platformer.model.Player;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;

public class PlayerController {

    public static Player player;

    public static void initializeController() {

        player =  new Player(new Vector2(7, 3), 70, 100);

    }

    public static void update(float deltaTime) {

        player.update(deltaTime); // updating our player using delta

    }

    public static void draw(Batch spriteBatch) {

        player.draw(spriteBatch);

    }
}
