package com.avalosG.platformer.model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Spritesheet {
    public Texture spriteSheet; // storing our aliens.png here
    public TextureRegion[] spriteFrames;
    public Animation animation;






    public Spritesheet(String pathToFile, int width, int height) {
        spriteSheet =  new Texture(Gdx.files.internal(pathToFile));

        TextureRegion[][] spriteSheetFrames = TextureRegion.split(spriteSheet, width, height); //splits our spriteSheet according to height and width of our region and puts them in a two-dimensional array

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

    public Animation createAnimation(int startFrame, int lastFrame, float animationSpeed) {
        // storing our animation frames into a new array
        int counter = (lastFrame + 1) - startFrame;
        TextureRegion[] animationFrames = new TextureRegion[counter];


        for(int index = lastFrame; index >= startFrame; index--) {
            animationFrames[--counter] = spriteFrames[index];
        }
        return new Animation(animationSpeed, animationFrames); //used our collected animation frames to make each animation last one second

    }
    public Animation flipAnimation(Animation origionalAnimation, boolean flipX, boolean flipY) {
        int frameCount = origionalAnimation.getKeyFrames().length;
        TextureRegion[] flippedFrames = new TextureRegion[frameCount];

        for(int index = 0; index <= frameCount - 1; index++) {
            flippedFrames[index] = new TextureRegion(origionalAnimation.getKeyFrames()[index]);
            flippedFrames[index].flip(flipX, flipY);

        }

        return new Animation(origionalAnimation.getFrameDuration(), flippedFrames);

    }
}
