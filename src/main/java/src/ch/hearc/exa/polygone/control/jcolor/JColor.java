package src.ch.hearc.exa.polygone.control.jcolor;

import src.ch.hearc.exa.polygone.animation.dessin.dessin.JPolygoneDessin;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import static src.ch.hearc.exa.polygone.control.Settings.BUTTON_WIDTH;
import static src.ch.hearc.exa.polygone.control.Settings.ESPACE;

public class JColor {
    JPanel colorButtons;
    ArrayList<JButton> jButtons = new ArrayList<JButton>();

    JPolygoneDessin polygone;
    public JColor(JPolygoneDessin polygon) {
        this.polygone = polygon;

        this.colorButtons = new JPanel();
        GridLayout grid = new GridLayout(-1, 1);
        grid.setVgap(ESPACE);
        this.colorButtons.setLayout(grid);
        ColorEnum[] colors = ColorEnum.values();
        for (ColorEnum color : colors) {
            JButton button = new JButton(color.name());
            button.setPreferredSize(new Dimension(BUTTON_WIDTH, button.getPreferredSize().height));
            button.addActionListener(buttonColorListener(this.polygone,button));
            jButtons.add(button);
            colorButtons.add(button);
        }
    }

    ActionListener buttonColorListener(JPolygoneDessin polygone, JButton button) {

        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switch (button.getText()) {
                    case "RED": {
                        polygone.setColor(Color.RED);
                        polygone.repaint();
                        break;
                    }
                    case "YELLOW": {
                        polygone.setColor(Color.YELLOW);
                        break;
                    }
                    case "BLUE": {
                        polygone.setColor(Color.BLUE);
                        break;
                    }
                    case "GREEN": {
                        polygone.setColor(Color.GREEN);
                        break;
                    }
                    default:
                        break;
                }

            }
        };
    }

    public JPanel getColorButtons() {
        return colorButtons;
    }
}
