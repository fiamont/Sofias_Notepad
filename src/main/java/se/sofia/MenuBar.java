package se.sofia;

import javax.swing.*;
import java.awt.*;

public class MenuBar {

    JMenuBar menuBar;
    JMenu fileMenu, editMenu, formatMenu, colorMenu;

    public MenuBar(){
    }

    public JMenuBar createMenuBar() {
        menuBar = new JMenuBar();
        UIManager.put("MenuBar.background", new Color(9, 86, 141));

        Font f = new Font("Monospaced", Font.BOLD, 16);
        Color color = Color.WHITE;

        menuBar.add(Box.createHorizontalGlue());

        fileMenu = new JMenu("Fil");
        fileMenu.setFont(f);
        fileMenu.setForeground(color);
        menuBar.add(fileMenu);

        menuBar.add(Box.createHorizontalStrut(10)); // Adjust the width as needed

        editMenu = new JMenu("Redigera");
        editMenu.setFont(f);
        editMenu.setForeground(color);
        menuBar.add(editMenu);

        menuBar.add(Box.createHorizontalStrut(10)); // Adjust the width as needed

        formatMenu = new JMenu("Formatera");
        formatMenu.setFont(f);
        formatMenu.setForeground(color);
        menuBar.add(formatMenu);

        menuBar.add(Box.createHorizontalStrut(10)); // Adjust the width as needed

        colorMenu = new JMenu("Färg");
        colorMenu.setFont(f);
        colorMenu.setForeground(color);
        menuBar.add(colorMenu);

        menuBar.add(Box.createHorizontalGlue());

        return menuBar;
    }
}
