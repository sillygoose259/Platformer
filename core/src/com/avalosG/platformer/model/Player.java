package com.avalosG.platformer.model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;

public class Player {
    public Vector2 position; // a point for x and y positioning
    public Texture spritesheet; // storing our aliens.png here

    public Player() {
        position =  new Vector2(0, 0); // initializing the position to the origin (0, 0)
        spritesheet = new Texture(Gdx.files.internal("img/aliens.png")); //accessing the image
    }

    public void draw(Batch spriteBatch) {    // the function doesn't return anything
        spriteBatch.draw(spritesheet, 0, 0, 70,100);
    }

    public void update(float deltatime) {

    }

}
