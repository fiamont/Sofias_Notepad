package se.sofia;

import javax.swing.*;
import java.awt.*;

public class MyFrame extends JFrame {
    JTextArea textArea;
    JScrollPane scrollPane;

    FileFunctions fileFunctions = new FileFunctions(this);
    EditFunctions editFunctions = new EditFunctions(this);
    FormatFunctions formatFunctions = new FormatFunctions(this);
    JMenuBar menuBar = new MenuBar(this, fileFunctions, editFunctions, formatFunctions).createMenuBar();

    public MyFrame() {
        createWindow();
        setJMenuBar(menuBar);
        createTextArea();
        setVisible(true);
    }

    public void createWindow() {
        this.setTitle("Sofias Notepad");
        this.setSize(500, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        ImageIcon image = new ImageIcon("C:/Projekt/Sofias_Notepad/src/main/resources/PenAndPaper.png");
        this.setIconImage(image.getImage());
    }

    public void createTextArea() {
        textArea = new JTextArea();
        scrollPane = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        formatFunctions.selectedFont = "Arial";
        formatFunctions.createFont(16);
        //textArea.setFont(new Font("Arial", Font.PLAIN, 16));

        this.add(scrollPane);
    }
}
