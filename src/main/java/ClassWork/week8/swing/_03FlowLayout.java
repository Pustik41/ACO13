package ClassWork.week8.swing;

import javax.swing.*;
import java.awt.*;

/**
 * Created by zhabenya on 16.07.16.
 */
public class _03FlowLayout {
    public static void main(String[] args) {


        JFrame frame = new JFrame();

        frame.setTitle("My Frame");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());
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

        /*frame.add(panel,  FlowLayout.CENTER);
        frame.add(panel2, FlowLayout.LEADING);
        frame.add(panel3, FlowLayout.LEFT);
        frame.add(panel4, FlowLayout.RIGHT);
        frame.add(panel5, FlowLayout.TRAILING);*/
    }
}
