package se.sofia;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuBar implements ActionListener {
    MyFrame myFrame;
    JMenuBar menuBar;
    FileMenu fileMenu;
    FileFunctions file;
    EditMenu editMenu;
    FormatMenu formatMenu;
    ColorMenu colorMenu;

    public MenuBar(MyFrame myFrame, FileFunctions file) {
        this.myFrame = myFrame;
        this.file = file;
    }

    public JMenuBar createMenuBar() {
        menuBar = new JMenuBar();
        UIManager.put("MenuBar.background", new Color(9, 86, 141));

        fileMenu = new FileMenu(myFrame, this);
        editMenu = new EditMenu(myFrame, this);
        formatMenu = new FormatMenu(myFrame, this);
        colorMenu = new ColorMenu(myFrame, this);

        menuBar.add(fileMenu.createMenu());
        menuBar.add(editMenu.createMenu());
        menuBar.add(formatMenu.createMenu());
        menuBar.add(colorMenu.createMenu());

        return menuBar;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        switch (command) {
            case "New" -> file.createNewFile();
            case "Open" -> file.openFile();
            case "Save" -> file.save();
            case "SaveAs" -> file.saveAs();
            case "Exit" -> file.exit();
        }
    }
}