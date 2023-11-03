package se.sofia;

import javax.swing.*;

public class MyFrame extends JFrame {
    JTextArea textArea;
    JScrollPane scrollPane;

    FileFunctions fileFunctions = new FileFunctions(this);
    JMenuBar menuBar = new MenuBar(this, fileFunctions).createMenuBar();

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
        this.add(scrollPane);
    }
}
