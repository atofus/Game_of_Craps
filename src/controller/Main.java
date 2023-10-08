package controller;

import model.CrapGame;
import view.CrapsView;

import javax.swing.*;
import java.awt.*;

public class Main {

    /**
     * Main method used to run the GUI.
     * @param theArgs args.
     */
    public static void main(String[] theArgs) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                CrapsView frame = new CrapsView();
                frame.setTitle("The Game of Craps");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setBounds(100, 100, 524, 500);
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }
}