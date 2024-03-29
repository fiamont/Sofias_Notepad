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
    EditFunctions edit;
    FormatMenu formatMenu;
    FormatFunctions format;
    ColorMenu colorMenu;

    ColorFunctions color;

    public MenuBar(MyFrame myFrame, FileFunctions file, EditFunctions edit, FormatFunctions format, ColorFunctions color) {
        this.myFrame = myFrame;
        this.file = file;
        this.edit = edit;
        this.format = format;
        this.color = color;
    }

    public JMenuBar createMenuBar() {
        menuBar = new JMenuBar();
        UIManager.put("MenuBar.background", new Color(9, 86, 141));
        menuBar.setBorder(BorderFactory.createEmptyBorder());

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
            case "Undo" -> edit.makeUndo();
            case "Redo" -> edit.makeRedo();
            case "Arial", "Calibri", "Elephant", "Monospaced", "Times New Roman" -> format.changeFont(command);
            case "8" -> format.createFont(8);
            case "12" -> format.createFont(12);
            case "16" -> format.createFont(16);
            case "20" -> format.createFont(20);
            case "28" -> format.createFont(28);
            case "38" -> format.createFont(38);
            case "Black", "White", "Blue", "Red", "Custom" -> color.changeBackground(command);
            case "fBlack", "fWhite", "fBlue", "fRed", "fCustom" -> color.changeForeground(command);


        }
    }
}