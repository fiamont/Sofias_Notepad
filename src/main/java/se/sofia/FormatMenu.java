package se.sofia;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class FormatMenu {
    MyFrame frame;
    ActionListener actionListener;

    Font headerFont = new Font("Arial Rounded MT Bold", Font.BOLD, 18);
    Font f = new Font("Arial Rounded MT Bold", Font.PLAIN, 16);
    Color fColor = Color.WHITE;
    Color bColor = new Color(9, 86, 141);
    Color subMenuColor = new Color(9, 138, 162);

    public FormatMenu(MyFrame frame, ActionListener actionListener) {
        this.frame = frame;
        this.actionListener = actionListener;
    }

    public JMenu createMenu() {
        JMenu formatMenu = new JMenu("Format");

        JMenu fFont = createUnderMenu("Font", "Font");
        JMenuItem fArial = createMenuItem("Arial", "Arial", actionListener);
        JMenuItem fCalibri = createMenuItem("Calibri", "Calibri", actionListener);
        JMenuItem fElephant = createMenuItem("Elephant", "Elephant", actionListener);
        JMenuItem fMonospaced = createMenuItem("Monospaced", "Monospaced", actionListener);
        JMenuItem fTimesNewRoman = createMenuItem("Times New Roman", "Times New Roman", actionListener);
        fFont.add(fArial);
        fFont.add(fCalibri);
        fFont.add(fElephant);
        fFont.add(fMonospaced);
        fFont.add(fTimesNewRoman);

        JMenu fFontSize = createUnderMenu("Font Size", "Font Size");
        JMenuItem f8 = createMenuItem("8", "8", actionListener);
        JMenuItem f12 = createMenuItem("12", "12", actionListener);
        JMenuItem f16 = createMenuItem("16", "16", actionListener);
        JMenuItem f20 = createMenuItem("20", "20", actionListener);
        JMenuItem f28 = createMenuItem("28", "28", actionListener);
        JMenuItem f38 = createMenuItem("38", "38", actionListener);
        fFontSize.add(f8);
        fFontSize.add(f12);
        fFontSize.add(f16);
        fFontSize.add(f20);
        fFontSize.add(f28);
        fFontSize.add(f38);

        formatMenu.setForeground(fColor);
        formatMenu.setFont(headerFont);

        formatMenu.add(fFont);
        formatMenu.add(fFontSize);

        return formatMenu;
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

