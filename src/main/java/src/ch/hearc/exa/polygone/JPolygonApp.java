package src.ch.hearc.exa.polygone;

import src.ch.hearc.exa.polygone.animation.dessin.JPolygone;
import src.ch.hearc.exa.polygone.animation.dessin.dessin.JPolygoneDessin;
import src.ch.hearc.exa.polygone.control.JControl;
import src.ch.hearc.exa.polygone.control.jcolor.JColor;
import src.ch.hearc.exa.polygone.control.option.JOption;
import src.ch.hearc.tools.animation.Animator_I;
import src.ch.hearc.tools.animation.FactoryAnimator;
import src.ch.hearc.tools.animation.JAnimator;
import src.ch.hearc.tools.decorator.JCenterH;
import src.ch.hearc.tools.decorator.JCenterV;
import src.ch.hearc.tools.decorator.JFrameBaseline;
import src.ch.hearc.tools.decorator.JMarge;

import javax.swing.*;
import java.awt.*;

import static src.ch.hearc.exa.polygone.control.Settings.BLOCK_WIDTH;
import static src.ch.hearc.exa.polygone.control.Settings.ESPACE;

public class JPolygonApp {
    public static void main(String[] args) {

        JPanel mainPanel = new JPanel();


        JPolygoneDessin jPolygoneDessin = new JPolygoneDessin(4);

        Animator_I animator = FactoryAnimator.create(jPolygoneDessin);
        JAnimator startStop = new JAnimator(animator);

        // section droite
        JPanel rightPanel = new JPolygone(jPolygoneDessin,startStop);
         //rightPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        JComponent rightSection = new JCenterH(rightPanel);
        rightSection = new JMarge(rightSection,ESPACE);
        rightSection.setPreferredSize(new Dimension(800,700));
        rightSection.setBorder(BorderFactory.createLineBorder(Color.BLACK));



        // section gauche

        JColor colorButtons  = new JColor(jPolygoneDessin);
        JOption options = new JOption(jPolygoneDessin);


        JPanel leftPanel = new JControl(colorButtons.getColorButtons(),options.getOptions()).getControlPanel();
        leftPanel = new JMarge(leftPanel,ESPACE);
        JComponent leftSection = new JCenterV(leftPanel);
        leftSection.setPreferredSize(new Dimension(BLOCK_WIDTH,700));

        leftSection.setBorder(BorderFactory.createLineBorder(Color.BLACK));


        BorderLayout b  = new BorderLayout();
        b.setHgap(50);
        mainPanel.setLayout(b);
        mainPanel.add(leftSection,BorderLayout.WEST);
        mainPanel.add(rightSection,BorderLayout.CENTER);

        JFrameBaseline jframe = new JFrameBaseline(new JMarge(mainPanel,ESPACE),"JPolygonApp");
    }
}
