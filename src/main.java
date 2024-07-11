import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class main {
    private static stopwatch stopwatch = new stopwatch();
    private static JLabel label;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Stopwatch");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);

        JPanel panel = new JPanel();
        frame.add(panel);
        placeComponents(panel);

        frame.setVisible(true);
    }

    private static void placeComponents(JPanel panel) {
        panel.setLayout(null);

        JButton startButton = new JButton("Start");
        startButton.setBounds(50, 50, 80, 25);
        panel.add(startButton);

        JButton stopButton = new JButton("Stop");
        stopButton.setBounds(150, 50, 80, 25);
        panel.add(stopButton);

        label = new JLabel("Elapsed Time: 0 ms");
        label.setBounds(50, 100, 200, 25);
        panel.add(label);

        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                stopwatch.start();
                Timer timer = new Timer(100, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        label.setText("Elapsed Time: " + stopwatch.getElapsedTime() + " ms");
                    }
                });
                timer.start();
            }
        });

        stopButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                stopwatch.stop();
            }
        });
    }
}
