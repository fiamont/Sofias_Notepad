package se.sofia;

import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;
import java.io.*;

public class FileFunctions {

    MyFrame frame;
    String fileName;
    String fileAddress;

    public FileFunctions(MyFrame frame) {
        this.frame = frame;
    }

    public void createNewFile() {
        frame.textPane.setText("");
        frame.setTitle("New notes");
        fileName = null;
        fileAddress = null;
        setDefaultStyles();
    }

    public void openFile() {
        JFileChooser fileChooser = new JFileChooser();
        int result = fileChooser.showOpenDialog(frame);

        if (result == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            fileName = file.getName();
            fileAddress = file.getAbsolutePath();
            frame.setTitle(fileName);

            try (FileReader fileReader = new FileReader(file);
                 BufferedReader br = new BufferedReader(fileReader)) {

                StyledDocument doc = frame.textPane.getStyledDocument();
                doc.remove(0, doc.getLength());  // Clear existing content

                // Read the font information from the first line
                String fontInfo = br.readLine();
                if (fontInfo != null && fontInfo.startsWith("Font:")) {
                    String[] parts = fontInfo.split("\\s");
                    if (parts.length >= 3) {
                        String fontFamily = parts[1];
                        int fontSize = Integer.parseInt(parts[2]);
                        changeFont(doc, fontFamily, fontSize);
                    }
                }

                String line;
                while ((line = br.readLine()) != null) {
                    doc.insertString(doc.getLength(), line + "\n", null);
                }

                // Reset styles
                setDefaultStyles();

            } catch (IOException | BadLocationException e) {
                e.printStackTrace();
                System.out.println("Error reading file.");
            }
        }
    }

    public void save() {
        if (fileName == null) {
            saveAs();
        } else {
            try {
                if (!fileName.endsWith(".txt")) {
                    fileName += ".txt";
                }

                FileWriter fileWriter = new FileWriter(fileAddress + fileName);
                // Save font information as the first line
                Font currentFont = frame.textPane.getFont();
                fileWriter.write(String.format("Font: %s %d\n", currentFont.getFamily(), currentFont.getSize()));
                fileWriter.write(getDocumentText());
                fileWriter.close();
                frame.setTitle(removeFileExtension(fileName));

            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("Error saving file.");
            }
        }
    }

    public void saveAs() {
        JFileChooser fileChooser = new JFileChooser();
        int result = fileChooser.showSaveDialog(frame);

        if (result == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            fileName = file.getName();
            if (!fileName.endsWith(".txt")) {
                fileName += ".txt";
            }
            fileAddress = file.getAbsolutePath();
            frame.setTitle(removeFileExtension(fileName));

            try (FileWriter fileWriter = new FileWriter(fileAddress + fileName)) {
                // Save font information as the first line
                Font currentFont = frame.textPane.getFont();
                fileWriter.write(String.format("Font: %s %d\n", currentFont.getFamily(), currentFont.getSize()));
                fileWriter.write(getDocumentText());
                fileWriter.close();

            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("Error saving file.");
            }
        }
    }

    public void exit() {
        System.exit(0);
    }

    private String removeFileExtension(String fileName) {
        int lastDotIndex = fileName.lastIndexOf('.');
        if (lastDotIndex != -1) {
            return fileName.substring(0, lastDotIndex);
        }
        return fileName;
    }

    private String getDocumentText() {
        try {
            return frame.textPane.getStyledDocument().getText(0, frame.textPane.getStyledDocument().getLength());
        } catch (BadLocationException e) {
            e.printStackTrace();
            return "";
        }
    }

    private void setDefaultStyles() {
        StyledDocument doc = frame.textPane.getStyledDocument();
        doc.setCharacterAttributes(0, doc.getLength(), frame.textPane.getStyle("default"), true);
    }

    private void changeFont(StyledDocument doc, String fontFamily, int fontSize) {
        MutableAttributeSet attrs = new SimpleAttributeSet();
        StyleConstants.setFontFamily(attrs, fontFamily);
        StyleConstants.setFontSize(attrs, fontSize);
        doc.setCharacterAttributes(0, doc.getLength(), attrs, false);
    }
}
