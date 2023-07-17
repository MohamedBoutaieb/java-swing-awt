package src.ch.hearc.exa.polygone.control;

import javax.swing.*;

public class JControl {
    JPanel controlPanel;

    public JControl(JPanel... components) {
        this.controlPanel = new JPanel();
        controlPanel.setLayout(new BoxLayout(controlPanel, BoxLayout.Y_AXIS));
        int i = 0;
        for (JPanel component : components) {
            controlPanel.add(component);
            if (i != components.length - 1)
                controlPanel.add(Box.createVerticalGlue());
            i++;
        }
    }

    public JPanel getControlPanel() {
        return controlPanel;
    }
}
