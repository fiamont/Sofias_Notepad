package se.sofia;

import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

public class FileFunctions {

    MyFrame frame;
    String fileName;
    String fileAddress;

    public FileFunctions(MyFrame frame) {
        this.frame = frame;
    }

    public void createNewFile() {
        frame.textArea.setText("");
        frame.setTitle("New notes");
        fileName = null;
        fileAddress = null;
    }

    public void openFile() {
        FileDialog fileDialog = new FileDialog(frame, "Open", FileDialog.LOAD);
        fileDialog.setVisible(true);

        if(fileDialog.getFile()!=null){
            fileName = fileDialog.getFile();
            fileAddress = fileDialog.getDirectory();
            frame.setTitle(fileName);
        }

        try{
            BufferedReader br = new BufferedReader(new FileReader(fileAddress + fileName));
            frame.textArea.setText((""));

            String line;

            while ((line = br.readLine())!=null) {
                frame.textArea.append(line + "\n");
            }
            br.close();
        } catch (Exception e){
            System.out.println("File not open");
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
                fileWriter.write(frame.textArea.getText());
                frame.setTitle(removeFileExtension(fileName));
                fileWriter.close();
            } catch (Exception e) {
                System.out.println("Something went wrong");
            }
        }
    }

    public void saveAs() {
        FileDialog fileDialog = new FileDialog(frame, "Save", FileDialog.SAVE);
        fileDialog.setVisible(true);

        if (fileDialog.getFile() != null) {
            fileName = fileDialog.getFile();
            if (!fileName.endsWith(".txt")) {
                fileName += ".txt";
            }
            fileAddress = fileDialog.getDirectory();
            frame.setTitle(removeFileExtension(fileName));
        }

        try {
            FileWriter fileWriter = new FileWriter(fileAddress + fileName);
            fileWriter.write(frame.textArea.getText());
            fileWriter.close();
        } catch (Exception e) {
            System.out.println("Something went wrong");
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
}
