package com.avalosG.platformer.model;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;

public class Player {
    public Vector2 position; // a point for x and y positioning
    public Animation animation;
    public Spritesheet spriteSheet;
    private float stateTime;


    public Player() {
        position = new Vector2(07, 3); // initializing the position to the origin (0, 0)
        spriteSheet = new Spritesheet("img/aliens.png", 70, 100);
        animation = spriteSheet.createAnimation(9, 10, 0.1f);
        animation =  spriteSheet.flipAnimation(animation, true, false);
        stateTime = 0f;

    }

    public void draw(Batch spriteBatch) {    // the function doesn't return anything
        spriteBatch.draw(animation.getKeyFrame(stateTime, true), position.x, position.y, 70 * (1 / 70f), 100 * (1 / 70f));
    }


    public void update(float deltatime) {
        stateTime += deltatime;
        position.x -= deltatime; // limits how fast our player moves left or right

    }
}
