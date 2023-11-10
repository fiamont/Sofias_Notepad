package se.sofia;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class EditMenu {
    MyFrame frame;
    ActionListener actionListener;
    Font headerFont = new Font("Arial Rounded MT Bold", Font.BOLD, 18);
    Font f = new Font("Arial Rounded MT Bold", Font.PLAIN, 16);
    Color fColor = Color.WHITE;

    public EditMenu(MyFrame frame, ActionListener actionListener) {
        this.frame = frame;
        this.actionListener = actionListener;
    }

    public JMenu createMenu() {
        JMenu editMenu = new JMenu("Edit");
        JMenuItem iUndo = createMenuItem("Undo", "Undo", actionListener);
        JMenuItem iRedo = createMenuItem("Redo", "Redo", actionListener);


        editMenu.setForeground(fColor);
        editMenu.setFont(headerFont);

        editMenu.add(iUndo);
        editMenu.add(iRedo);

        return editMenu;
    }

    private JMenuItem createMenuItem(String label, String command, ActionListener actionListener) {
        JMenuItem item = new JMenuItem(label);
        item.setFont(f);
        item.addActionListener(actionListener);
        item.setActionCommand(command);
        return item;
    }
}
