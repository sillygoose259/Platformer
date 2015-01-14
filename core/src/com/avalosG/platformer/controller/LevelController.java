package com.avalosG.platformer.controller;

import com.avalosG.platformer.model.Level;
import com.avalosG.platformer.model.Player;
import com.avalosG.platformer.model.Sprite;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.Array;


public class LevelController {
    public static final float UNIT_SCALE = 1/70f; // one unit is equal to 70 pixels

    public static Level level;
    public static OrthogonalTiledMapRenderer renderer;
    public static Batch spriteBatch;


    public static World gameWorld;
    private static Array<Body> worldBodies;
    private  static Box2DDebugRenderer debugRenderer;

    public static void initializeController() {
        level = new Level("map/level01.tmx");
        renderer = new OrthogonalTiledMapRenderer(level.map, UNIT_SCALE);  // this states that the tiles are 70px large

        gameWorld = new World(new Vector2(0, 0), true); // the gravity for our player that makes it fall down based on earth's gravity
        worldBodies = new Array<Body>();
        debugRenderer = new Box2DDebugRenderer();

        spriteBatch =  renderer.getSpriteBatch(); // accessing the sprite batch associated with our level map and storing them in our sprite batch variable

    }

    public static void draw() {
        spriteBatch.begin();
        PlayerController.draw(spriteBatch);
        spriteBatch.end();

        debugRenderer.render(gameWorld, CameraController.camera.combined); // display the shapes to the exact size it needs to be



    }

    public static void update(float deltaTime) {
        renderer.setView(CameraController.camera);
        renderer.render(); // rendering the renderer
        updateWorldBodies();
        gameWorld.step(1/60f, 1, 1); // how fast it updates our gameworld

    }

    private static void updateWorldBodies() {

        worldBodies.clear(); // clears everything from worldBodies
        gameWorld.getBodies(worldBodies); // obtaining the bodies and storing them in the array


       for(Body body : worldBodies) {
            Sprite spriteBody = (Player)body.getUserData(); // casting the Player from a different variable
           spriteBody.position = body.getPosition();
        }
    }



}
