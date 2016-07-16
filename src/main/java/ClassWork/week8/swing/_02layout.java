package ClassWork.week8.swing;

import javax.swing.*;
import java.awt.*;

/**
 * Created by zhabenya on 16.07.16.
 */
public class _02layout {

    public static void main(String[] args) {


        JFrame frame = new JFrame();

        frame.setTitle("My Frame");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.setSize(600, 400);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        JPanel panel = new JPanel();
        panel.setBackground(Color.CYAN);
        JPanel panel2 = new JPanel();
        panel2.setBackground(Color.yellow);
        JPanel panel3 = new JPanel();
        panel3.setBackground(Color.green);
        JPanel panel4 = new JPanel();
        panel4.setBackground(Color.blue);
        JPanel panel5 = new JPanel();
        panel5.setBackground(Color.black);

        frame.add(panel, BorderLayout.CENTER);
        frame.add(panel2, BorderLayout.EAST);
        frame.add(panel3, BorderLayout.WEST);
        frame.add(panel4, BorderLayout.SOUTH);
        frame.add(panel5, BorderLayout.NORTH);

    }

}
