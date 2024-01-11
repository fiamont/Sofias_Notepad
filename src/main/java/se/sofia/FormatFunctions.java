package se.sofia;

import javax.swing.text.*;
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
        StyledDocument doc = frame.textPane.getStyledDocument();  // Change this line

        // Clear existing styles
        doc.setCharacterAttributes(0, doc.getLength(), frame.textPane.getStyle("default"), true);
        switch (selectedFont) {
            case "Arial" -> setFont(doc, arial);
            case "Calibri" -> setFont(doc, calibri);
            case "Elephant" -> setFont(doc, elephant);
            case "Monospaced" -> setFont(doc, monospaced);
            case "Times New Roman" -> setFont(doc, timesNewRoman);
        }
    }

    private void setFont(StyledDocument doc, Font font) {
        MutableAttributeSet attrs = new SimpleAttributeSet();
        StyleConstants.setFontFamily(attrs, font.getFamily());
        StyleConstants.setFontSize(attrs, font.getSize());

        doc.setCharacterAttributes(0, doc.getLength(), attrs, false);
    }



}
