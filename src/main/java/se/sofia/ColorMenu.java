package se.sofia;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class ColorMenu {
    MyFrame frame;
    ActionListener actionListener;

    Font f = new Font("Arial Rounded MT Bold", Font.BOLD, 16);
    Color fColor = Color.WHITE;
    Color bColor = new Color(9, 86, 141);

    public ColorMenu(MyFrame frame, ActionListener actionListener) {
        this.frame = frame;
        this.actionListener = actionListener;
    }

    public JMenu createMenu() {
        JMenu colorMenu = new JMenu("Color");

        JMenu cBackground = createUnderMenu("Background", "Background", actionListener);
        JMenuItem cBlack = createMenuItem("Black", "Black", actionListener);
        JMenuItem cWhite = createMenuItem("White", "White", actionListener);
        JMenuItem cBlue = createMenuItem("Blue", "Blue", actionListener);
        JMenuItem cRed = createMenuItem("Red", "Red", actionListener);
        cBackground.add(cBlack);
        cBackground.add(cWhite);
        cBackground.add(cBlue);
        cBackground.add(cRed);

        JMenu cFontColor = createUnderMenu("Font Color", "Font Size", actionListener);
        JMenuItem ccBlack = createMenuItem("Black", "cBlack", actionListener);
        JMenuItem ccWhite = createMenuItem("White", "cWhite", actionListener);
        JMenuItem ccBlue = createMenuItem("Blue", "cBlue", actionListener);
        JMenuItem ccRed = createMenuItem("Red", "cRed", actionListener);
        cFontColor.add(ccBlack);
        cFontColor.add(ccWhite);
        cFontColor.add(ccBlue);
        cFontColor.add(ccRed);

        colorMenu.setForeground(fColor);
        colorMenu.setFont(f);

        colorMenu.add(cBackground);
        colorMenu.add(cFontColor);

        return colorMenu;
    }

    private JMenu createUnderMenu(String label, String command, ActionListener actionListener) {
        JMenu menu = new JMenu(label);
        menu.setBackground(bColor);
        menu.setFont(f);
        menu.addActionListener(actionListener);
        menu.setActionCommand(command);
        return menu;
    }

    private JMenuItem createMenuItem(String label, String command, ActionListener actionListener) {
        JMenuItem item = new JMenuItem(label);
        item.setBackground(bColor);
        item.setForeground(fColor);
        item.setFont(f);
        item.addActionListener(actionListener);
        item.setActionCommand(command);
        return item;
    }
}

