package se.sofia;

import javax.swing.*;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import java.awt.*;

public class ColorFunctions {

    MyFrame frame;

    public ColorFunctions(MyFrame frame) {
        this.frame = frame;
    }

    public void changeBackground(String color) {
        StyledDocument doc = frame.textPane.getStyledDocument();  // Change this line

        switch (color) {
            case "Black" -> setBackgroundColor(doc, Color.BLACK);
            case "White" -> setBackgroundColor(doc, Color.WHITE);
            case "Blue" -> setBackgroundColor(doc, Color.BLUE);
            case "Red" -> setBackgroundColor(doc, Color.RED);
            case "Custom" -> changeCustomBackgroundColor(doc);
        }
    }

    public void changeForeground(String color) {
        StyledDocument doc = frame.textPane.getStyledDocument();  // Change this line

        switch (color) {
            case "fBlack" -> setForegroundColor(doc, Color.BLACK);
            case "fWhite" -> setForegroundColor(doc, Color.WHITE);
            case "fBlue" -> setForegroundColor(doc, Color.BLUE);
            case "fRed" -> setForegroundColor(doc, Color.RED);
            case "fCustom" -> changeCustomForegroundColor(doc);
        }
    }

    private void setBackgroundColor(StyledDocument doc, Color color) {
        frame.textPane.setBackground(color);
        doc.putProperty(StyleConstants.Background, color);
    }

    private void setForegroundColor(StyledDocument doc, Color color) {
        Style style = doc.addStyle("foreground", null);
        StyleConstants.setForeground(style, color);
        doc.setCharacterAttributes(0, doc.getLength(), style, false);
    }


    private void changeCustomBackgroundColor(StyledDocument doc) {
        Color chosenColor = chooseCustomColor();
        if (chosenColor != null) {
            setBackgroundColor(doc, chosenColor);
        }
    }

    private void changeCustomForegroundColor(StyledDocument doc) {
        Color chosenColor = chooseCustomColor();
        if (chosenColor != null) {
            setForegroundColor(doc, chosenColor);
        }
    }


    private Color chooseCustomColor() {
        Color initialColor = Color.BLACK; // Default initial color
        return JColorChooser.showDialog(frame, "Choose Custom Color", initialColor);
    }
}
