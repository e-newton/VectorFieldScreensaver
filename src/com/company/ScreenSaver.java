package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;

public class ScreenSaver {

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }

        final JFrame screenSaverFrame = new JFrame();
        screenSaverFrame.setDefaultCloseOperation(
                WindowConstants.EXIT_ON_CLOSE);
//        screenSaverFrame.setUndecorated(false);
        screenSaverFrame.setResizable(true);
        screenSaverFrame.setLayout(new BorderLayout());
//        screenSaverFrame.add(new JLabel("This is a Java Screensaver!",
//                SwingConstants.CENTER), BorderLayout.CENTER);
        screenSaverFrame.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                System.exit(0);
            }

            @Override
            public void keyPressed(KeyEvent e) {
                System.exit(0);
            }

            @Override
            public void keyReleased(KeyEvent e) {
                System.exit(0);
            }
        });
        screenSaverFrame.addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {
//                System.exit(0);
            }

            @Override
            public void mouseMoved(MouseEvent e) {
//                System.exit(0);
            }
        });
        screenSaverFrame.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.exit(0);
            }

            @Override
            public void mousePressed(MouseEvent e) {
                System.exit(0);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                System.exit(0);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        });
        screenSaverFrame.addMouseWheelListener(e -> System.exit(0));
        Canvas canvas = new Canvas();
        screenSaverFrame.add(canvas, BorderLayout.CENTER);
        BufferedImage cursorImg = new BufferedImage(16, 16, BufferedImage.TYPE_INT_ARGB);
        Cursor blankCursor = Toolkit.getDefaultToolkit().createCustomCursor(
                cursorImg, new Point(0, 0), "blank cursor");
        screenSaverFrame.getContentPane().setCursor(blankCursor);
        screenSaverFrame.validate();
        screenSaverFrame.pack();
        screenSaverFrame.setVisible(true);
        screenSaverFrame.setSize(256, 256);
        GraphicsEnvironment.getLocalGraphicsEnvironment()
                .getDefaultScreenDevice()
                .setFullScreenWindow(screenSaverFrame);
        Timer timer = new Timer(16, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                screenSaverFrame.repaint();
            }
        });
        timer.start();
        System.out.println("end");

    }
}
