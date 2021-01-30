package com.company;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Canvas extends JPanel {

    double z = 0;
    double zoom = 1000;
    int scale = 50;
    float pos = 1;
    Random random = new Random();
    OpenSimplexNoise noise;
    FastNoise fs;
    public Canvas() {
        super();
        setBackground(new Color(0,0,0));
        setVisible(true);
        noise = new OpenSimplexNoise();
        this.fs = new FastNoise(random.nextInt(5000));
    }

    public void update() {

    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

//        z+= 0.1;
        z += Math.pow(Math.abs(fs.GetPerlin((float) z,pos, pos)), 1.5) + 0.5 + random.nextFloat();
        z %= Double.MAX_VALUE - 100;
        pos += 1;
        pos %= Float.MAX_VALUE - 100;

        g2.setStroke(new BasicStroke(5, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
        for (int j = -10; j < (getHeight()/scale + 20); j++){
            for(int i = -10; i < (getWidth()/scale + 20); i ++){
               float valF = ((fs.GetPerlin(i * scale / (float) 5,j * scale / (float) 5, (float) z) + 1) / 2);
               float angle = (float) (valF * Math.PI * 2);
               int val = (int) Math.min((Math.min(Math.pow(valF, 2), 1.0) * 256), 255);
//               g.fillRect(i*scale,j*scale,scale,scale);
               int x2 = (int) (Math.cos(angle) * i * Math.pow(valF * 3, 2));
               int y2 = (int) (Math.sin(angle) * i * Math.pow(valF * 3, 2));
//               g.setColor(new Color(val, val, val));
               GradientPaint gradient = new GradientPaint(i*scale, j * scale, new Color(0,0,0,val), (i*scale) + x2, (j * scale) + y2, new Color(val, val, val, val));
               g2.setPaint(gradient);
               g.drawLine(i*scale, j * scale, (i*scale) + x2,(j * scale) + y2);
           }
       }

    }
}
