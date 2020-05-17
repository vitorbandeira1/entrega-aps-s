package br.pro.hashi.ensino.desagil.aps.view;

import br.pro.hashi.ensino.desagil.aps.model.Gate;
import br.pro.hashi.ensino.desagil.aps.model.Light;
import br.pro.hashi.ensino.desagil.aps.model.Switch;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.URL;

public class GateView extends FixedPanel implements ItemListener, MouseListener {
    private final Gate gate;
    private final JCheckBox entrada1;
    private final JCheckBox entrada2;

    //    private final JCheckBox saida;
    private final Image image;
    private final Light light;
    private final Switch entradaSwitch1;
    private final Switch entradaSwitch2;


    public GateView(Gate gate) {
        super(250, 250);
        this.gate = gate;

        entrada1 = new JCheckBox();
        entrada1.setMnemonic(KeyEvent.VK_G);
        entrada1.setSelected(false);

        entrada2 = new JCheckBox();
        entrada2.setMnemonic(KeyEvent.VK_G);
        entrada2.setSelected(false);


        entradaSwitch1 = new Switch();
        entradaSwitch2 = new Switch();

//        saida = new JCheckBox();
//        saida.setMnemonic(KeyEvent.VK_G);
//        saida.setSelected(false);

        light = new Light(255, 0, 0);


        if (gate.toString().equals("NOT")) {

            add(entrada1, 25, 102, 150, 25);
            add(entrada2, 85, 45, 150, 25);


        } else if (gate.toString().equals("OR")) {


            add(entrada1, 30, 67, 150, 25);
            add(entrada2, 30, 137, 150, 25);


        } else {


            add(entrada1, 30, 72, 150, 25);
            add(entrada2, 30, 132, 150, 25);


        }


        String name = gate.toString() + ".png";
        URL url = getClass().getClassLoader().getResource(name);
        image = getToolkit().getImage(url);

        if (gate.toString().equals("NOT")) {
            gate.connect(0, entradaSwitch1);
            entrada2.setEnabled(false);
            remove(entrada2);
        } else {
            gate.connect(0, entradaSwitch1);
            gate.connect(1, entradaSwitch2);
        }

        entrada1.addItemListener(this);
        entrada2.addItemListener(this);


        addMouseListener(this);

        update();
    }

    private void update() {
        boolean resposta1;
        boolean resposta2;

        resposta1 = entrada1.isSelected();
        resposta2 = entrada2.isSelected();

        if (resposta1 && resposta2) {
            entradaSwitch1.turnOn();
            entradaSwitch2.turnOn();
        } else if (resposta2) {
            entradaSwitch1.turnOff();
            entradaSwitch2.turnOn();
        } else if (resposta1) {
            entradaSwitch1.turnOn();
            entradaSwitch2.turnOff();
        } else {
            entradaSwitch1.turnOff();
            entradaSwitch2.turnOff();
        }


        light.connect(0, this.gate);
        repaint();
    }

    public void itemStateChanged(ItemEvent itemEvent) {
        update();
    }

    @Override
    public void mouseClicked(MouseEvent event) {


        int x = event.getX();
        int y = event.getY();

        if (gate.toString().equals("NOT")) {
            if (Math.pow(x - 210, 2) + Math.pow(y - 115, 2) <= 120) {

                Color color = JColorChooser.showDialog(this, null, light.getColor());
                light.setColor(color);


                repaint();
            }
        } else {

            if (Math.pow(x - 202, 2) + Math.pow(y - 115, 2) <= 120) {


                Color color = JColorChooser.showDialog(this, null, light.getColor());
                light.setColor(color);

                repaint();

            }
        }

    }

    @Override
    public void mousePressed(MouseEvent event) {

    }

    @Override
    public void mouseReleased(MouseEvent event) {

    }

    @Override
    public void mouseEntered(MouseEvent event) {

    }

    @Override
    public void mouseExited(MouseEvent event) {

    }


    @Override
    public void paintComponent(Graphics g) {

        super.paintComponent(g);


        g.drawImage(image, 50, 40, 150, 150, this);

        g.setColor(light.getColor());
        if (gate.toString().equals("NOT")) {
            g.fillOval(198, 105, 20, 20);
        } else {

            g.fillOval(190, 105, 20, 20);

        }


        getToolkit().sync();
    }

}


// REFERÊNCIAS DAS IMAGENS
//https://upload.wikimedia.org/wikipedia/commons/e/e6/NAND_ANSI_Labelled.svg
//https://en.wikibooks.org/wiki/A-level_Computing/WJEC_(Eduqas)/Component_1/Logical_operations#/media/File:AND_ANSI.svg
//http://www.clker.com/clipart-not-gate.html
//https://commons.wikimedia.org/wiki/File:XOR_ANSI.svg
//https://pt.wikipedia.org/wiki/Ficheiro:Or-gate-en.svg