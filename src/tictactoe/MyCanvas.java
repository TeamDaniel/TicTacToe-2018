package tictactoe;/*
This chunk of code below imports all the import pieces that are needed
as far as I know you cannot remove ANYTHING!! okay? so don't I don't want to try and fix it.
 */

import javax.swing.*;
import java.awt.*;

class MyCanvas extends JComponent {
    /*
    the chunk of code below is a setup for being able to draw X's quicker which
    I'll explain further when we get there.
     */

    public void x(Graphics g, int x1, int y1, int x2, int y2){
        g.drawLine(x1, y1, x2, y2);
        g.drawLine(x1, y2, x2, y1);
    }
/*
The Code below is used to display the rules and serve no real purpose besides the fact to explain the rules
 */
    public void paint(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(5));
        g.drawString("Greetings, and welcome to Le Toe Tic Tac.", 5,330);
        g2.drawString("A game quite similar to Tic Tac Toe,", 5, 350);
        g2.drawString("except it's on the computer LOL XD.", 5, 370);
        g2.drawString("click on a square and depending if you're player one or two,", 5, 390);
        g2.drawString("you will place an X or an O", 5, 400);
        g2.drawString("Get 3 in a row and You Win",5,420);

      //this piece of code will draw the box game board

        g.drawRect (10, 10, 300, 300);
        g.drawRect (10, 10, 300, 100);
        g.drawRect (10, 11, 300, 200);
        g.drawRect (10, 10, 200, 300);
        g.drawRect (10, 10, 100, 300);
        //This chunk of code draws a red circle
        g.setColor(Color.RED);
        g.drawOval(15,15,90,90);
        //This Chunk of code changes the Color back to black and draws an X
        g.setColor(Color.BLUE);
/*
this is the chunk of code used to create an X and this is all you need to write a new X
 */
        x(g, 20,20,100,100);
        x(g, 20,20,100,100);
    }
}

/*
Box one(AKA top left): for the X
x1 20, y1 20, x2 100, y2 100
x1 20, y1 100, x2 100, y2 20
Box two:
x1 120, y1 20, x2 200, y2 100
x1 120, y1 100, x2 200, y2 20
Box three:
x1 220, y1 20, x2 300, y2 100
x1 220, y1 100, x2 300, y2 20
Box four
x1 20, y1 120, x2 100, y2 200
x1 20, y1 120, x2 100, y2 120
Box five
x1 120, y1 120, x2 200, y2 120
x1 120, y1 120, x2 200, y2 120
Box six
x1 220, y1 120, x2 300, y2 200
x1 20, y1 100, x2 100, y2 20
Box seven
x1 20, y1 240, x2 100, y2 300
Just add 100 to the y for each of the other rows
 */
