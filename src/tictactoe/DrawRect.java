package tictactoe;

import javax.swing.*;

public class DrawRect {
    public static void main(String[] a) {
        JLabel label = new JLabel("yeah");
        label.setText("");
        JFrame window = new JFrame("Le Toe Tic Tac");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setBounds(30, 30, 365, 480);
        window.getContentPane().add(new MyCanvas());
        window.setVisible(true);
    }
}