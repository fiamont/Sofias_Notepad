package se.sofia;

import javax.swing.*;
import javax.swing.text.DefaultStyledDocument;

public class MyFrame extends JFrame {
    JTextPane textPane;
    JScrollPane scrollPane;

    FileFunctions fileFunctions = new FileFunctions(this);
    EditFunctions editFunctions = new EditFunctions(this);
    FormatFunctions formatFunctions = new FormatFunctions(this);
    ColorFunctions colorFunctions = new ColorFunctions(this);
    JMenuBar menuBar = new MenuBar(this, fileFunctions, editFunctions, formatFunctions, colorFunctions).createMenuBar();

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
        textPane = new JTextPane(new DefaultStyledDocument());  // Change this line
        scrollPane = new JScrollPane(textPane, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());
        textPane.setStyledDocument(new DefaultStyledDocument());  // Add this line
        formatFunctions.selectedFont = "Arial";
        formatFunctions.createFont(16);
        colorFunctions.changeBackground("White");
        colorFunctions.changeForeground("fBlack");

        this.add(scrollPane);
    }
}
