package com.avalosG.platformer.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;

public class GameScreen implements Screen{
    public TiledMap map;
    public OrthogonalTiledMapRenderer renderer;
    public OrthographicCamera camera;

    public GameScreen() {
        map = new TmxMapLoader().load("map/level01.tmx"); // loading the map
        renderer = new OrthogonalTiledMapRenderer(map, 1/70f);  // this states that the tiles are 70px large

        float width = Gdx.graphics.getWidth();
        float height = Gdx.graphics.getHeight();

        camera = new OrthographicCamera(14f, 14f * (height / width)); // we changed the camera angle and multiplied it by the height and width 
        camera.position.set(camera.viewportWidth / 2f, camera.viewportHeight / 2f, 0); // sets the camera position to center on the map


    }

    @Override
    public void render(float delta) {
        camera.update();  // updating the camera
        renderer.setView(camera);
        renderer.render(); // rendering the renderer

    }

    @Override
    public void resize(int width, int height) {

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
