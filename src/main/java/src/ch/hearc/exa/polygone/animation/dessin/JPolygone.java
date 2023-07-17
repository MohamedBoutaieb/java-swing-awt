package src.ch.hearc.exa.polygone.animation.dessin;

import src.ch.hearc.tools.decorator.JCenterH;

import javax.swing.*;
import java.awt.*;

public class JPolygone extends JPanel {
    JPanel polygoneSection;
    JPanel animatorSection;

    public  JPolygone(JPanel polygoneSection, JPanel animatorSection){
        polygoneSection.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        animatorSection.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        this.polygoneSection = polygoneSection;
        this.animatorSection = animatorSection;
        this.setLayout(new BorderLayout());
        add(polygoneSection,BorderLayout.CENTER);
        add(animatorSection,BorderLayout.SOUTH);
    }
}
