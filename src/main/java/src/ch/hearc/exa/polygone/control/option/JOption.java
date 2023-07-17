package src.ch.hearc.exa.polygone.control.option;

import src.ch.hearc.exa.polygone.animation.dessin.dessin.JPolygoneDessin;
import src.ch.hearc.exa.polygone.animation.dessin.dessin.PolygoneDessin_I;
import src.ch.hearc.tools.decorator.JCenterH;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JOption {
    JPanel options;
    JCheckBox checkBox;

    JButton controlButton;

    PolygoneDessin_I polygone;

    public JOption(PolygoneDessin_I polygone) {
        this.options = new JPanel();
        this.polygone = polygone;
        options.setLayout(new BoxLayout(options, BoxLayout.Y_AXIS));

        this.checkBox = new JCheckBox("Show Center");
        this.checkBox.setSelected(true);
        checkBox.addActionListener(checkBoxListener(checkBox,this.polygone));
        this.options.add(new JCenterH(checkBox));
        this.options.add(Box.createVerticalGlue());
        controlButton = new JButton("EXIT");
        controlButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(1);
            }
        });
        this.options.add(new JCenterH(controlButton));
    }

    public JPanel getOptions() {
        return options;
    }

    ActionListener checkBoxListener(JCheckBox checkBox, PolygoneDessin_I polygone) {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                polygone.setNbFaceStringEnable(checkBox.isSelected());
            }
        };
    }

    public JCheckBox getCheckBox() {
        return checkBox;
    }
}
