package com.avalosG.platformer.view;

import com.avalosG.platformer.controller.CameraController;
import com.avalosG.platformer.controller.LevelController;
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




    public Player player;




    public GameScreen() {

        LevelController.initializeController();
        CameraController.initializeController();






        player =  new Player(70, 100);


    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0.22f, 0.63f, 0.84f, 1f); // sets our color with our chosen color variables
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT); // clearing the screen using the color from the previous line


        LevelController.update(delta);
        CameraController.update();


        player.update(delta); // updating our player using delta
        LevelController.draw();






    }

    @Override
    public void resize(int width, int height) {
        CameraController.resize(width, height);
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
