package com.avalosG.platformer.controller;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;

public class CameraController {

    public static OrthographicCamera camera;




    public static void initializeController() {

        float width = Gdx.graphics.getWidth(); // we are obtaining the height and width of the window where our game will pop up
        float height = Gdx.graphics.getHeight();

        camera = new OrthographicCamera(14f, 14f * (height / width)); // we changed the camera size and multiplied it by the height and width
        camera.position.set(camera.viewportWidth / 2f, camera.viewportHeight / 2f, 0); // sets the camera position to center on the map
    }

    public static void update() {

        camera.update();  // updating the camera

    }

    public static void resize(int width, int height) {
        camera.viewportWidth = 14f; // resized our width but is the same
        camera.viewportHeight = 14f * height/ width; // the same size as our width but is being multiplied by height divided by width
        camera.update();
    }
}
