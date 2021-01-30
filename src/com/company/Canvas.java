package com.company;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Canvas extends JPanel {

    double z = 0;
    double zoom = 1000;
    int scale = 20;
    float pos = 0;
    OpenSimplexNoise noise;
    public Canvas() {
        super();
        setBackground(new Color(0,0,0));
        setVisible(true);
        noise = new OpenSimplexNoise();
    }

    public void update() {

    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

//        z+= 0.1;
        FastNoise fs = new FastNoise();
        z += Math.pow(Math.abs(fs.GetPerlin((float) z,pos)), 1.5) + 0.02;
        pos += 0.3;

        g2.setStroke(new BasicStroke(2, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
       for(int i = -10; i < (getWidth()/scale + 20); i ++) {
           for (int j = -10; j < (getHeight()/scale + 20); j++) {
               float valF = ((fs.GetPerlin(i * scale / (float) 5,j * scale / (float) 5, (float) z) + 1) / 2);
               float angle = (float) (valF * Math.PI * 2);
               int val = (int) Math.min((Math.min(Math.pow(valF, 2), 1.0) * 256), 255);
//               g.fillRect(i*scale,j*scale,scale,scale);
               int x2 = (int) (Math.cos(angle) * i * Math.pow(valF + 1, 2));
               int y2 = (int) (Math.sin(angle) * i * Math.pow(valF + 1, 2));
               g.setColor(new Color(val, val, val));
               g.drawLine(i*scale, j * scale, (i*scale) + x2,(j * scale) + y2);
           }
       }

    }
}
