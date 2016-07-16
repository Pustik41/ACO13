package ClassWork.week8.swing;

import javax.swing.*;
import java.awt.*;

/**
 * Created by zhabenya on 16.07.16.
 */
public class _01Frame {

    public static void main(String[] args) throws InterruptedException {
        JFrame frame = new JFrame();

        frame.setTitle("My Frame");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //frame.setResizable(false);
        frame.setSize(600, 400);
        frame.setLocationRelativeTo(null);
        //frame.pack();
        frame.setVisible(true);
        Thread.sleep(1500);
        frame.setState(Frame.ICONIFIED);
        Thread.sleep(1500);
        frame.setExtendedState(Frame.MAXIMIZED_BOTH);
        Thread.sleep(1500);
        frame.setExtendedState(Frame.NORMAL);

    }
}
