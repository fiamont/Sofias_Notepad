package se.sofia;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class ColorMenu {
    MyFrame frame;
    ActionListener actionListener;

    Font headerFont = new Font("Arial Rounded MT Bold", Font.BOLD, 18);
    Font f = new Font("Arial Rounded MT Bold", Font.PLAIN, 16);
    Color fColor = Color.WHITE;
    Color bColor = new Color(9, 86, 141);
    Color subMenuColor = new Color(9, 138, 162);

    public ColorMenu(MyFrame frame, ActionListener actionListener) {
        this.frame = frame;
        this.actionListener = actionListener;
    }

    public JMenu createMenu() {
        JMenu colorMenu = new JMenu("Color");

        JMenu cBackground = createUnderMenu("Background", "Background");
        JMenuItem cBlack = createMenuItem("Black", "Black", actionListener);
        JMenuItem cWhite = createMenuItem("White", "White", actionListener);
        JMenuItem cBlue = createMenuItem("Blue", "Blue", actionListener);
        JMenuItem cRed = createMenuItem("Red", "Red", actionListener);
        JMenuItem cCustom = createMenuItem("Custom", "Custom", actionListener);
        cBackground.add(cBlack);
        cBackground.add(cWhite);
        cBackground.add(cBlue);
        cBackground.add(cRed);
        cBackground.add(cCustom);

        JMenu cFontColor = createUnderMenu("Font Color", "Font Color");
        JMenuItem fBlack = createMenuItem("Black", "fBlack", actionListener);
        JMenuItem fWhite = createMenuItem("White", "fWhite", actionListener);
        JMenuItem fBlue = createMenuItem("Blue", "fBlue", actionListener);
        JMenuItem fRed = createMenuItem("Red", "fRed", actionListener);
        JMenuItem fCustom = createMenuItem("Custom", "fCustom", actionListener);
        cFontColor.add(fBlack);
        cFontColor.add(fWhite);
        cFontColor.add(fBlue);
        cFontColor.add(fRed);
        cFontColor.add(fCustom);

        colorMenu.setForeground(fColor);
        colorMenu.setFont(headerFont);

        colorMenu.add(cBackground);
        colorMenu.add(cFontColor);

        return colorMenu;
    }

    private JMenu createUnderMenu(String label, String command) {
        JMenu menu = new JMenu(label);
        menu.setBackground(bColor);
        menu.setFont(f);
        menu.setActionCommand(command);
        return menu;
    }

    private JMenuItem createMenuItem(String label, String command, ActionListener actionListener) {
        JMenuItem item = new JMenuItem(label);
        item.setBackground(subMenuColor);
        item.setForeground(fColor);
        item.setFont(f);
        item.addActionListener(actionListener);
        item.setActionCommand(command);
        return item;
    }
}

