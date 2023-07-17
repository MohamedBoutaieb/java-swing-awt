package src.ch.hearc.exa.polygone.animation.dessin.dessin;

import src.ch.hearc.tools.Threads;
import src.ch.hearc.tools.animation.Animable_I;
import src.ch.hearc.tools.animation.Animator_I;
import src.ch.hearc.tools.animation.FactoryAnimator;
import src.ch.hearc.tools.dessin.G2D_I;
import src.ch.hearc.tools.image.ImageLoader;
import src.ch.hearc.tools.image.jimage.JImage;
import src.ch.hearc.tools.image.jimage.TypeRendering;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;
import java.awt.geom.Line2D;

public class JPolygoneDessin extends JPanel implements G2D_I, PolygoneDessin_I, Animable_I {

    private int n; // Nombre de côtés du polygone
    private double rayon; // Rayon du polygone

    private final int fontSize = 48;
    double angle;

    private JImage jImage;

    double dAngle = 2 * Math.PI / 5000;
    double offsetAngle = 0;
    private Color color = Color.black;
    private boolean showNbOfFace = true;


    public JPolygoneDessin(int n) {
        this.n = 8; // Initialisation du nombre de côtés
        this.rayon = 0; // Initialisation du rayon (sera calculé plus tard)
        this.font = new Font("Serif", Font.BOLD, fontSize);
        this.angle = 2 * Math.PI / this.n;
        this.jImage = new JImage(ImageLoader.loadSynchrone("img.jpg").getImage(), TypeRendering.STRETCH);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g); // Clear the panel before repainting
        Graphics2D g2D = (Graphics2D) g;
        AffineTransform g2dBackup = g2D.getTransform();
        draw(g2D, 400, 400);

    }

    @Override
    public void draw(Graphics2D g2d, int w, int h) {
        // Calcul du rayon en fonction de w et h du JComponent
        rayon = rayon(w, h);
        this.add(jImage);
        jImage.paintComponent(g2d);
        jImage.setPreferredSize(new Dimension(getWidth(), getHeight()));

        g2d.setColor(this.color);
        g2d.setStroke(new BasicStroke(4.0f));

        double offsetX = this.getWidth() / 2;
        double offsetY = this.getHeight() / 2;
        // Dessin des côtés du polygone régulier
        for (int i = 0; i < this.n; i++) {
            double[] coords = coter(i, offsetX, offsetY);
            line2D(g2d, coords[0], coords[1], coords[2], coords[3]);
        }
        if (showNbOfFace) {
            drawNbOfSides(g2d, offsetX, offsetY);
        }
        g2d.dispose();
    }


    private double rayon(int w, int h) {
        return Math.min(w, h) / 2.0;
    }

    private void drawNbOfSides(Graphics2D g2D, double x, double y) {
        g2D.setFont(this.font);
        g2D.drawString(String.valueOf(n), (int) x - fontSize / 2, (int) y);
    }

    private double[] coter(int k, double offsetX, double offsetY) {
        double startX = rayon * Math.cos(k * angle + offsetAngle) + offsetX;
        double startY = rayon * Math.sin(k * angle + offsetAngle) + offsetY;
        double endX = rayon * Math.cos((k + 1) * angle + offsetAngle) + offsetX;
        double endY = rayon * Math.sin((k + 1) * angle + offsetAngle) + offsetY;
        return new double[]{startX, startY, endX, endY};
    }

    private void line2D(Graphics2D g2D, double x, double y, double x2, double y2) {
        g2D.draw(new Line2D.Float((float) x, (float) y, (float) x2, (float) y2));
    }

    Font font;

    @Override
    public void setColor(Color color) {
        this.color = color;
        this.repaint();
    }

    @Override
    public void setNbFaceStringEnable(boolean isEnable) {
        this.showNbOfFace = isEnable;
        this.repaint();
    }

    @Override
    public void animationStep() {
        this.offsetAngle += this.dAngle;
        this.repaint();
    }
}

