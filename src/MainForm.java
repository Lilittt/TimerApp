import model.Timer;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainForm extends JFrame {
    private JTextField min;
    private JTextField sec;
    private JButton start;
    private JPanel MainPanel;

    public MainForm() {
        setTitle("model.Timer");
        setContentPane(MainPanel);
        setSize(300, 150);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

        start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Timer timer = new Timer(Integer.parseInt(min.getText()), Integer.parseInt(sec.getText()));
                int sum = timer.getMinutes() * 60 + timer.getSeconds();

                Thread thread = new Thread(() -> {
                    for (int j = 0; j < sum + 1; j++) {
                        if (j != 0) {
                            Timer timer1 = timer.decreaseOneSecondTimer();
                        }
                        min.setText(Integer.toString(timer.getMinutes()));
                        sec.setText(Integer.toString(timer.getSeconds()));
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException ex) {
                        }
                    }
                });
                thread.start();
            }
        });
    }

    public static void main(String[] args) {
        MainForm myForm = new MainForm();
    }
}
