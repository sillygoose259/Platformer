package com.avalosG.platformer.model;

import com.avalosG.platformer.controller.LevelController;
import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.objects.PolylineMapObject;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.ChainShape;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;

public class Bodies {
    public static void createBody(MapObject mapObject) {
        String bodyType = mapObject.getProperties().get("type").toString(); //storing the solid in bodyType and are going to check if the block is solid

        if(bodyType.equalsIgnoreCase("solid")) {
            RectangleMapObject rectangleObject = (RectangleMapObject)mapObject;
            BodyDef bodyDefinition = new BodyDef();
            bodyDefinition.type = BodyDef.BodyType.StaticBody;
            bodyDefinition.position.set(rectangleObject.getRectangle().x * LevelController.UNIT_SCALE, rectangleObject.getRectangle().y * LevelController.UNIT_SCALE);


            Body physicsBody = LevelController.gameWorld.createBody(bodyDefinition);

            PolygonShape rectangleShape = new PolygonShape();
            rectangleShape.setAsBox(rectangleObject.getRectangle().width * LevelController.UNIT_SCALE / 2,
            rectangleObject.getRectangle().height * LevelController.UNIT_SCALE / 2,
            new Vector2(rectangleObject.getRectangle().width * LevelController.UNIT_SCALE / 2,
                    rectangleObject.getRectangle().height * LevelController.UNIT_SCALE / 2), 0);

            FixtureDef fixtureDefinition = new FixtureDef();
            fixtureDefinition.shape = rectangleShape;
            fixtureDefinition.friction = 2f;

            physicsBody.createFixture(fixtureDefinition);
            rectangleShape.dispose();
        }

        else if(bodyType.equalsIgnoreCase("ground")) {
            PolylineMapObject polylineObject = (PolylineMapObject)mapObject;
            BodyDef bodyDefenition = new BodyDef();
            bodyDefenition.type = BodyDef.BodyType.StaticBody;
            bodyDefenition.position.set(polylineObject.getPolyline().getX() * LevelController.UNIT_SCALE, polylineObject.getPolyline().getY() * LevelController.UNIT_SCALE);

            Body physicsBody = LevelController.gameWorld.createBody(bodyDefenition);
            ChainShape chainShape = new ChainShape();

            float[] transformVertices= new float[polylineObject.getPolyline().getVertices().length];

            for(int index = 0; index < transformVertices.length; index++) {
                transformVertices[index] = polylineObject.getPolyline().getVertices()[index] * LevelController.UNIT_SCALE;
            }

            chainShape.createChain(transformVertices);

            FixtureDef fixtureDefinition = new FixtureDef();
            fixtureDefinition.shape = chainShape;
            fixtureDefinition.friction = 2f;

            physicsBody.createFixture(fixtureDefinition);
            chainShape.dispose();
        }
        
    }
}
