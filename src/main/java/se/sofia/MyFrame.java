package se.sofia;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyFrame implements ActionListener {
    JFrame window;
    JTextArea textArea;
    JScrollPane scrollPane;

    JMenuBar menuBar = new MenuBar().createMenuBar();

    public MyFrame() {
        createWindow();
        window.setJMenuBar(menuBar);
        createTextArea();
        window.setVisible(true);
    }

    public void createWindow() {
        window = new JFrame("Sofias Notepad");
        window.setSize(500, 600);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLocationRelativeTo(null);

        ImageIcon image = new ImageIcon("C:/Projekt/Sofias_Notepad/src/main/resources/PenAndPaper.png");
        window.setIconImage(image.getImage());
    }

    public void createTextArea() {
        textArea = new JTextArea();
        scrollPane = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());
        window.add(scrollPane);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
