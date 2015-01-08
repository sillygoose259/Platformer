package com.avalosG.platformer.view;

import com.avalosG.platformer.model.Player;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;

public class GameScreen implements Screen{
    public TiledMap map;
    public OrthogonalTiledMapRenderer renderer;
    public OrthographicCamera camera;

    public Batch spriteBatch;
    public Player player;

    public static World gameWorld;
    private Box2DDebugRenderer debugRenderer;

    public GameScreen() {
        map = new TmxMapLoader().load("map/level01.tmx"); // loading the map
        renderer = new OrthogonalTiledMapRenderer(map, 1/70f);  // this states that the tiles are 70px large
        gameWorld = new World(new Vector2(0, -10), true); // the gravity for our player that makes it fall down based on earth's gravity
        debugRenderer = new Box2DDebugRenderer(); //

        float width = Gdx.graphics.getWidth(); // we are obtaining the height and width of the window where our game will pop up
        float height = Gdx.graphics.getHeight();

        camera = new OrthographicCamera(14f, 14f * (height / width)); // we changed the camera size and multiplied it by the height and width
        camera.position.set(camera.viewportWidth / 2f, camera.viewportHeight / 2f, 0); // sets the camera position to center on the map

        spriteBatch =  renderer.getSpriteBatch(); // accessing the sprite batch associated with our level map and storing them in our sprite batch variable
        player =  new Player(70, 100);


    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0.22f, 0.63f, 0.84f, 1f); // sets our color with our chosen color variables
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT); // clearing the screen using the color from the previous line

        camera.update();  // updating the camera
        renderer.setView(camera);
        renderer.render(); // rendering the renderer

        player.update(delta); // updating our player using delta

        gameWorld.step(1/60f, 1, 1);

        spriteBatch.begin();
        player.draw(spriteBatch);
        spriteBatch.end();

        debugRenderer.render(gameWorld, camera.combined); // display the shapes to the exact size it needs to be

    }

    @Override
    public void resize(int width, int height) {
        camera.viewportWidth = 14f; // resized our width but is the same
        camera.viewportHeight = 14f * height/ width; // the same size as our width but is being multiplied by height divided by width
        camera.update();
    }

    @Override
    public void show() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void dispose() {

    }
}
