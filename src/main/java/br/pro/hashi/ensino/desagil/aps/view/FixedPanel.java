package br.pro.hashi.ensino.desagil.aps.view;

import javax.swing.*;
import java.awt.*;

public class FixedPanel extends JPanel {
    protected FixedPanel() {
        setLayout(null);
        setPreferredSize(new Dimension(250, 250));
    }

    protected void add(Component comp, int x, int y) {
        super.add(comp);
        comp.setBounds(x, y, 20, 25);
    }
}

