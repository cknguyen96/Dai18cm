package com.Dai18cm;

import com.Dai18cm.controllers.PlayerController;
import com.Dai18cm.models.Player;

import javax.imageio.ImageIO;
import javax.sound.sampled.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * Created by Admin on 5/14/2016.
 */
public class Utils {
    public static void playSound(String audioUrl, boolean repeat) {

        File soundFile = new File(audioUrl);
        try {
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundFile);
            Clip clip = AudioSystem.getClip();
            clip.open(audioIn);
            clip.start();
            if(repeat) {
                clip.loop(Clip.LOOP_CONTINUOUSLY);
            }
            else {
                clip.loop(0);
            }
        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        }
    }

    public static Image loadImage(String url) {
        try {
            Image image = ImageIO.read(new File(url));
            return image;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
    //Ham ve Score and HP
    public static void displayBoard(Graphics backbufferGraphics){
        backbufferGraphics.setFont(new Font("TimesRoman", Font.PLAIN, 20));
        backbufferGraphics.drawString("Score: " + PlayerController.getInst().getScore() , 30 , 60);
        backbufferGraphics.drawString("HP: " + Player.getHP(), 330, 60);
    }
}
