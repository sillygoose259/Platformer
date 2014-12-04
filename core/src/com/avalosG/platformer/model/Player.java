package com.avalosG.platformer.model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

public class Player {
    public Vector2 position; // a point for x and y positioning
    public Texture spriteSheet; // storing our aliens.png here

    public TextureRegion[] spriteFrames;

    public Player() {
        position = new Vector2(0, 0); // initializing the position to the origin (0, 0)
        spriteSheet = new Texture(Gdx.files.internal("img/aliens.png")); //accessing the image

        TextureRegion[][] spriteSheetFrames = TextureRegion.split(spriteSheet, 70, 100); //splits our spriteSheet according to height and width of our region and puts them in a two-dimensional array

        int counter = 0; //
        for (int row = 0; row < spriteSheetFrames.length; row++) { // selecting the row that we are on and are able to select columns

            for (int column = 0; column < spriteSheetFrames[row].length; column++) { // selecting the column that we are on and are able to select individual players
                counter++; // adds one to the value of whatever is in counter

            }
        }

        spriteFrames = new TextureRegion[counter]; // created space so all the player actions can be stored

        counter = 0; // resetting counter
        for (TextureRegion[] row : spriteSheetFrames) { // store frames as an array
            for (TextureRegion sprite : row) { // lets us access our frames
                spriteFrames[counter++] = sprite; // storing sprite in our spriteFrames array
            }
        }
    }

    public void draw(Batch spriteBatch) {    // the function doesn't return anything
        spriteBatch.draw(spriteFrames[7], 0, 0, 70,100);
    }






    public void update(float deltatime) {

    }

}
