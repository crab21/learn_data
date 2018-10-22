package com.example.algorithm.prtscr;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class PrtScrLearn {
    public static void main(String[] args) {
        try {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Robot robot = new Robot();
            //根据指定的区域抓取屏幕的指定区域，1300是长度，800是宽度。
            BufferedImage bi = robot.createScreenCapture(new Rectangle(1300, 800));
            //把抓取到的内容写到一个jpg文件中
            ImageIO.write(bi, "jpg", new File("d:\\bootstrap栅格1.png"));

        } catch (AWTException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
