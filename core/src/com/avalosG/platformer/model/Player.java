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

public class Player extends Sprite{


    public Player(Vector2 position, int width, int height, String sheetPath) {
        super(position, width, height, sheetPath);

        BodyDef bodyDefinition = new BodyDef(); // creating the body
        bodyDefinition.type = BodyDef.BodyType.DynamicBody; // the type of the body dynamic can apply impulses
        bodyDefinition.position.set(position); // where the body will be created

        physicsBody = LevelController.gameWorld.createBody(bodyDefinition); // attaching in the gameWorld
        physicsBody.setUserData(this); // all our information will be attached to our body

        PolygonShape rectangleShape =  new PolygonShape();
        rectangleShape.setAsBox(this.width / 2f, this.height / 2f, new Vector2(this.width/ 2f, this.height /2f), 0f); // setting the height and width of the box

        PolygonShape sensorShape = new PolygonShape();
            sensorShape.setAsBox(this.width / 2.5f, this.height / 32, new Vector2(this.width / 2, 0), 0f);

        FixtureDef fixtureDefinition = new FixtureDef(); // creating the properties of our fixture
        fixtureDefinition.shape = rectangleShape; // shapeing the fixture

        FixtureDef fixtureDefinitionSensor = new FixtureDef();
        fixtureDefinitionSensor.shape = sensorShape;
        fixtureDefinitionSensor.isSensor = true;


        physicsBody.createFixture(fixtureDefinition); // applying the fixture to our player body
        physicsBody.createFixture(fixtureDefinitionSensor);
        rectangleShape.dispose(); // removeing the origional rectangleShape
        sensorShape.dispose();


        //stand, climb, duck, jump, hurt, idle, swim, walk
        animations.put("walkRight", spriteSheet.createAnimation(9,10, 0.1f));
        animations.put("climbRight", spriteSheet.createAnimation(1, 2, 0.1f));
        animations.put("duckRight", spriteSheet.createAnimation(3, 3, 0.1f));
        animations.put("standRight", spriteSheet.createAnimation(11, 11, 0.1f));
        animations.put("jumpRight", spriteSheet.createAnimation(5, 5, 0.1f));
        animations.put("swimRight",spriteSheet.createAnimation(8, 8,0.1f));
        animations.put("hurtRight", spriteSheet.createAnimation(4, 4, 0.1f));
        animations.put("idleRight",spriteSheet.createAnimation(6, 6, 0.1f));


        animations.put("walkLeft", spriteSheet.flipAnimation(animations.get("walkRight"), true, false));
        animations.put("duckLeft", spriteSheet.flipAnimation(animations.get("duckRight"), true, false));
        animations.put("hurtLeft" ,spriteSheet.flipAnimation(animations.get("hurtRight"), true, false));
        animations.put("idleLeft", spriteSheet.flipAnimation(animations.get("idleRight"), true, false));
        animations.put("jumpLeft", spriteSheet.flipAnimation(animations.get("jumpRight"), true, false));
        animations.put("swimLeft", spriteSheet.flipAnimation(animations.get("swimRight"), true, false));

        currentAnimation = "walkLeft";


    }

    public void draw(Batch spriteBatch) {    // the function doesn't return anything

        super.draw(spriteBatch);
    }


    public void update(float deltaTime) {
        super.update(deltaTime);
    }
}
