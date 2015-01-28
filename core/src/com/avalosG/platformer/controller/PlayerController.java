package com.avalosG.platformer.controller;

import com.avalosG.platformer.model.Player;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;

public class PlayerController {

    public static Player player;

    private static final float VELOCITY = 1f;
    private static final float MAX_VELOCITY = 5f;
    public static String movementAction;
    public static String specialAction;

    public static void initializeController() {

        player =  new Player(new Vector2(7, 7), 70, 100, "img/aliens.png");
        movementAction = "";
        specialAction = "";

    }

    public static void update(float deltaTime) {
        handleInput();
        player.update(deltaTime); // updating our player using delta

    }

    public static void draw(Batch spriteBatch) {

        player.draw(spriteBatch);

    }

    private static void handleInput() {
        Vector2 velocity = player.physicsBody.getLinearVelocity();
        Vector2 position = player.physicsBody.getPosition();

        if(velocity.x > MAX_VELOCITY) {
            velocity.x = Math.signum(velocity.x) * MAX_VELOCITY;
            player.physicsBody.setLinearVelocity(velocity.x, velocity.y);
        }

        if(movementAction.equalsIgnoreCase("right")) {
            player.physicsBody.applyLinearImpulse(VELOCITY, 0f, position.x, position.y, true);
        }
        else if(movementAction.equalsIgnoreCase("left")) {
            player.physicsBody.applyLinearImpulse(-VELOCITY, 0f, position.x, position.y, true);
        }
    }
}