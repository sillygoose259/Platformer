package com.avalosG.platformer.model;

import com.avalosG.platformer.controller.LevelController;
import com.avalosG.platformer.view.GameScreen;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;

import java.awt.Polygon;
import java.util.HashMap;

public class Player {
    public Vector2 position; // a point for x and y positioning
    public float width;
    public float height;
    public Spritesheet spriteSheet;
    public String currentAnimation;

    private float stateTime;
    private HashMap<String, Animation> animations;

    public Player(int width, int height) {
        position = new Vector2(7, 3); // initializing the position to the origin (0, 0)
        this.width = width * (LevelController.UNIT_SCALE);
        this.height = height * (LevelController.UNIT_SCALE);
        spriteSheet = new Spritesheet("img/aliens.png", width, height);
        animations = new HashMap<String, Animation>();

        BodyDef bodyDefinition = new BodyDef(); // creating the body
        bodyDefinition.type = BodyDef.BodyType.DynamicBody; // the type of the body dynamic
        bodyDefinition.position.set(position); // where the body will be created

        Body playerBody = LevelController.gameWorld.createBody(bodyDefinition); // attaching in the gameWorld
        playerBody.setUserData(this); // all our information will be attached to our body

        PolygonShape rectangleShape =  new PolygonShape();
        rectangleShape.setAsBox(this.width / 2f, this.height / 2f, new Vector2(this.width/ 2f, this.height /2f), 0f); // setting the height and width of the box

        FixtureDef fixtureDefinition = new FixtureDef(); // creating the properties of our fixture
        fixtureDefinition.shape = rectangleShape; // shapeing the fixture

        playerBody.createFixture(fixtureDefinition); // applying the fixture to our player body
        rectangleShape.dispose(); // removeing the origional rectangleShape


        //stand, climb, duck, jump, hurt, idle, swim, walk
        animations.put("walk", spriteSheet.createAnimation(9,10, 0.1f));
        animations.put("climb", spriteSheet.createAnimation(1, 2, 0.1f));
        animations.put("duck", spriteSheet.createAnimation(3, 3, 0.1f));
        animations.put("stand", spriteSheet.createAnimation(11, 11, 0.1f));
        animations.put("jump", spriteSheet.createAnimation(5, 5, 0.1f));
        animations.put("swim",spriteSheet.createAnimation(8, 8,0.1f));
        animations.put("hurt", spriteSheet.createAnimation(4, 4, 0.1f));
        animations.put("idle",spriteSheet.createAnimation(6, 6, 0.1f));


        animations.put("walkLeft", spriteSheet.flipAnimation(animations.get("walk"), true, false));
        animations.put("duckLeft", spriteSheet.flipAnimation(animations.get("duck"), true, false));
        animations.put("hurtLeft" ,spriteSheet.flipAnimation(animations.get("hurt"), true, false));
        animations.put("idleLeft", spriteSheet.flipAnimation(animations.get("idle"), true, false));
        animations.put("jumpLeft", spriteSheet.flipAnimation(animations.get("jump"), true, false));
        animations.put("swimLeft", spriteSheet.flipAnimation(animations.get("swim"), true, false));

        currentAnimation = "walkLeft";

        stateTime = 0f;
    }

    public void draw(Batch spriteBatch) {    // the function doesn't return anything
        spriteBatch.draw(animations.get(currentAnimation).getKeyFrame(stateTime ,true), position.x, position.y,width , height);
    }


    public void update(float deltaTime) {
        stateTime += deltaTime;

    }
}
