package src.ch.hearc.exa.polygone;

import java.awt.*;
import javax.swing.*;

public class Polygone extends JPanel {

    private int n;

    public Polygone(int n) {
        this.n = n;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        int centerX = getWidth() / 2;
        int centerY = getHeight() / 2;
        int radius = 100;

        int[] xPoints = new int[n];
        int[] yPoints = new int[n];

        for (int i = 0; i < n; i++) {
            double angle = 2 * Math.PI * i / n;
            xPoints[i] = (int) (centerX + radius * Math.cos(angle));
            yPoints[i] = (int) (centerY + radius * Math.sin(angle));
        }

        g.drawPolygon(xPoints, yPoints, n);
    }

    public static void main(String[] args) {
        int n = 11; // Spécifiez ici le nombre de côtés souhaité

        JFrame frame = new JFrame("Polygone");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);

        Polygone polygone = new Polygone(n);
        frame.add(polygone);

        frame.setVisible(true);
    }
}
