package se.sofia;

import java.awt.*;

public class FormatFunctions {

    MyFrame frame;
    Font arial, calibri, elephant, monospaced, timesNewRoman;
    String selectedFont;

    public FormatFunctions(MyFrame frame){
        this.frame = frame;
    }

    public void createFont(int fontSize) {
        arial = new Font("Arial", Font.PLAIN, fontSize);
        calibri = new Font("Calibri", Font.PLAIN, fontSize);
        elephant = new Font("Elephant", Font.PLAIN, fontSize);
        monospaced = new Font("Monospaced", Font.PLAIN, fontSize);
        timesNewRoman = new Font("Times New Roman", Font.PLAIN, fontSize);

        changeFont(selectedFont);
    }

    public void changeFont(String font) {
        selectedFont = font;
        switch (selectedFont) {
            case "Arial" -> frame.textArea.setFont(arial);
            case "Calibri" -> frame.textArea.setFont(calibri);
            case "Elephant" -> frame.textArea.setFont(elephant);
            case "Monospaced" -> frame.textArea.setFont(monospaced);
            case "Times New Roman" -> frame.textArea.setFont(timesNewRoman);

        }
    }


}
