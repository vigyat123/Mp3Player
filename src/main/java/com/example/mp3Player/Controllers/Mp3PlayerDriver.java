package com.example.mp3Player.Controllers;
import com.example.mp3Player.Services.PausablePlayer;
import javazoom.jl.decoder.JavaLayerException;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

@RestController
@RequestMapping("/player")
public class Mp3PlayerDriver {

    FileInputStream file;
    PausablePlayer player;

    {
        try {
            file = new FileInputStream("C:\\Users\\vigya\\Projects\\mp3Player\\src\\main\\resources\\Bom Diggy Diggy  (VIDEO) _ Zack Knight _ Jasmin Walia _ Sonu Ke Titu Ki Sweety.mp3");
            player = new PausablePlayer(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (JavaLayerException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("/")
    public ModelAndView firstPage() {
        return new ModelAndView("Mp3Player");
    }
    @RequestMapping(
            value = "/playMusic",
            method = RequestMethod.GET,
            consumes = MediaType.ALL_VALUE,
            produces = MediaType.ALL_VALUE
    )
    public void playMusic(){
        try {
            player.play();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @RequestMapping(
            value = "/pauseMusic",
            method = RequestMethod.GET,
            consumes = MediaType.ALL_VALUE,
            produces = MediaType.ALL_VALUE
    )
    public void pauseMusic(){
        try {
            player.pause();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @RequestMapping(
            value = "/resumeMusic",
            method = RequestMethod.GET,
            consumes = MediaType.ALL_VALUE,
            produces = MediaType.ALL_VALUE
    )
    public void resumeMusic(){
        try {
            player.resume();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @RequestMapping(
            value = "/stopMusic",
            method = RequestMethod.GET,
            consumes = MediaType.ALL_VALUE,
            produces = MediaType.ALL_VALUE
    )
    public void stopMusic(){
        try {
            player.stop();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
