package com.avalosG.platformer.controller;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;

public class LevelController {

    public  static TiledMap map;
    public static OrthogonalTiledMapRenderer renderer;
    public static Batch spriteBatch;


    public static World gameWorld;
    private  static Box2DDebugRenderer debugRenderer;

    public static void initializeController() {
        map = new TmxMapLoader().load("map/level01.tmx"); // loading the map
        renderer = new OrthogonalTiledMapRenderer(map, 1/70f);  // this states that the tiles are 70px large

        gameWorld = new World(new Vector2(0, -10), true); // the gravity for our player that makes it fall down based on earth's gravity
        debugRenderer = new Box2DDebugRenderer();

        spriteBatch =  renderer.getSpriteBatch(); // accessing the sprite batch associated with our level map and storing them in our sprite batch variable

    }

    public static void draw() {
        spriteBatch.begin();
        player.draw(spriteBatch);
        spriteBatch.end();

        debugRenderer.render(gameWorld, CameraController.camera.combined); // display the shapes to the exact size it needs to be



    }

    public static void update(float deltaTime) {
        renderer.setView(CameraController.camera);
        renderer.render(); // rendering the renderer

        gameWorld.step(1/60f, 1, 1); // how fast it updates our gameworld

    }

}
