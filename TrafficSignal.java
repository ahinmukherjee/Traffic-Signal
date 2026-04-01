import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TrafficSignal {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new SignalFrame());
    }
}

class SignalFrame extends JFrame {

    public SignalFrame() {
        setTitle("Traffic Signal");
        setSize(300, 620);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        add(new SignalPanel());
        setVisible(true);
    }
}

class SignalPanel extends JPanel {

    private int currentLight = 0; // 0=Red, 1=Yellow, 2=Green
    private int countdown = 30;

    public SignalPanel() {
        setBackground(new Color(200, 220, 240));

        Timer timer = new Timer(1000, e -> {
            countdown--;

            if (countdown <= 0) {
                if (currentLight == 0) {
                    currentLight = 1;
                    countdown = 5;
                } 
                else if (currentLight == 1) {
                    currentLight = 2;
                    countdown = 25;
                } 
                else {
                    currentLight = 0;
                    countdown = 30;
                }
            }
            repaint();
        });

        timer.start();
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                            RenderingHints.VALUE_ANTIALIAS_ON);

        //draw signal body
        GradientPaint bodyGradient = new GradientPaint(
                80, 50, Color.DARK_GRAY,
                200, 400, Color.BLACK);
        g2.setPaint(bodyGradient);
        g2.fillRoundRect(80, 50, 140, 350, 30, 30);

        // draw pole
        g2.setColor(Color.GRAY);
        g2.fillRect(135, 400, 30, 120);

        // draw lights
        drawLight(g2, 115, 80, Color.RED, currentLight == 0);
        drawLight(g2, 115, 180, Color.YELLOW, currentLight == 1);
        drawLight(g2, 115, 280, Color.GREEN, currentLight == 2);

        // countdown display
        g2.setFont(new Font("Arial", Font.BOLD, 28));
        g2.setColor(Color.BLACK);
        g2.drawString("Time: " + countdown, 90, 560);
    }

    private void drawLight(Graphics2D g2, int x, int y, Color color, boolean active) {

        if (active) {
            GradientPaint glow = new GradientPaint(
                    x, y, color.brighter(),
                    x + 60, y + 60, color.darker());
            g2.setPaint(glow);
            } 
        else {
            g2.setColor(Color.GRAY);
            }

        g2.fillOval(x, y, 80, 80);

        // inner shine effect
        if (active) {
            g2.setColor(new Color(255, 255, 255, 120));
            g2.fillOval(x + 15, y + 15, 30, 30);
         }
    }
}