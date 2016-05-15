package com.Dai18cm.views;

import com.Dai18cm.models.GameConfig;
import com.Dai18cm.models.GameObject;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Vector;

/**
 * Created by Administrator on 5/15/2016.
 */
public class AnimationDrawer extends GameDrawer {
    private Vector<Image> imageVector;
    private int imageIdx = 0;
    private int count = 0;
    //Load anh
    public AnimationDrawer(String[] imageUrls) {
        imageVector = new Vector<Image>();
        for(String imageUrl : imageUrls) {
            try {
                Image image = ImageIO.read(new File(imageUrl));
                imageVector.add(image);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    //Add vao vector
    public AnimationDrawer(Image[] images) {
        this.imageVector = new Vector<Image>();
        for(Image image : images) {
            this.imageVector.add(image);
        }
    }
    //set Vector
    public AnimationDrawer(Vector<Image> images) {
        this.imageVector = images;
    }

    @Override
    public void paint(GameObject gameObject, Graphics g) {
        Image image = imageVector.get(imageIdx);
        g.drawImage(image,
                gameObject.getX(), gameObject.getY(),
                gameObject.getWidth(), gameObject.getHeight(),
                null);
        count++;
        if (GameConfig.getInst().durationInMiliSeconds(count) >= 75) {
            count = 0;
            imageIdx++;
            if(imageIdx >= imageVector.size()) {
                onEndVector(gameObject);
            }
        }
    }

    protected void onEndVector(GameObject gameObject) {
        imageIdx = 0;
    }
}
