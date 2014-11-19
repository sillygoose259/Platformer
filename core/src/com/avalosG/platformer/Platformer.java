package com.avalosG.platformer;
import com.avalosG.platformer.view.GameScreen;
import com.badlogic.gdx.Game;

public class Platformer extends Game {
    @Override
    public void create() {
        setScreen(new GameScreen());
    }
}
