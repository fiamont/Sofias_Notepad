package se.sofia;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class FileMenu {
    MyFrame frame;
    ActionListener actionListener;
    Font f = new Font("Arial Rounded MT Bold", Font.BOLD, 16);
    Color fColor = Color.WHITE;
    public FileMenu(MyFrame frame, ActionListener actionListener) {
        this.frame = frame;
        this.actionListener = actionListener;
    }

    public JMenu createMenu() {
        JMenu fileMenu = new JMenu("File");
        JMenuItem iNew = createMenuItem("New", "New", actionListener);
        JMenuItem iOpen = createMenuItem("Open", "Open", actionListener);
        JMenuItem iSave = createMenuItem("Save", "Save", actionListener);
        JMenuItem iSaveAs = createMenuItem("Save as", "SaveAs", actionListener);
        JMenuItem iExit = createMenuItem("Exit", "Exit", actionListener);

        fileMenu.setForeground(fColor);
        fileMenu.setFont(f);

        fileMenu.add(iNew);
        fileMenu.add(iOpen);
        fileMenu.add(iSave);
        fileMenu.add(iSaveAs);
        fileMenu.add(iExit);

        return fileMenu;
    }

    private JMenuItem createMenuItem(String label, String command, ActionListener actionListener) {
        JMenuItem item = new JMenuItem(label);
        item.setFont(f);
        item.addActionListener(actionListener);
        item.setActionCommand(command);
        return item;
    }
}
