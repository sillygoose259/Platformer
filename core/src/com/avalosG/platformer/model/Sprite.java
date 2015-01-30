package com.avalosG.platformer.model;

import com.avalosG.platformer.controller.LevelController;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;

import java.util.HashMap;

public class Sprite {

    public Body physicsBody;
    public Vector2 position; // a point for x and y positioning
    public float width;
    public float height;
    public Spritesheet spriteSheet;
    public String currentAnimation;
    public String direction;

    protected float stateTime;
    protected HashMap<String, Animation> animations;
    public Sprite(Vector2 position, int width, int height, String sheetPath) {
        this.position = position; // initializing the position to the origin (0, 0)
        this.width = width * (LevelController.UNIT_SCALE);
        this.height = height * (LevelController.UNIT_SCALE);
        spriteSheet = new Spritesheet(sheetPath, width, height);
        animations = new HashMap<String, Animation>();
        stateTime = 0f;
        direction = "right";
    }
    public void draw(Batch spriteBatch) {    // the function doesn't return anything
        spriteBatch.draw(animations.get(currentAnimation).getKeyFrame(stateTime ,true), position.x, position.y,width , height);
    }


    public void update(float deltaTime) {
        stateTime += deltaTime;

    }
}
