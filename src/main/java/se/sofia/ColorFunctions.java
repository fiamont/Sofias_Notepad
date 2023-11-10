package se.sofia;

import javax.swing.*;
import java.awt.*;

public class ColorFunctions {

    MyFrame frame;

    public ColorFunctions(MyFrame frame) {
        this.frame = frame;
    }

    public void changeBackground(String color) {
        switch (color) {
            case "Black" -> frame.textArea.setBackground(Color.BLACK);
            case "White" -> frame.textArea.setBackground(Color.WHITE);
            case "Blue" -> frame.textArea.setBackground(Color.BLUE);
            case "Red" -> frame.textArea.setBackground(Color.RED);
            case "Custom" -> changeCustomBackgroundColor();
        }
    }

    public void changeForeground(String color) {
        switch (color) {
            case "fBlack" -> frame.textArea.setForeground(Color.BLACK);
            case "fWhite" -> frame.textArea.setForeground(Color.WHITE);
            case "fBlue" -> frame.textArea.setForeground(Color.BLUE);
            case "fRed" -> frame.textArea.setForeground(Color.RED);
            case "fCustom" -> changeCustomForegroundColor();
        }
    }

    private void changeCustomBackgroundColor() {
        Color chosenColor = chooseCustomColor();
        if (chosenColor != null) {
            frame.textArea.setBackground(chosenColor);
        }
    }

    private void changeCustomForegroundColor() {
        Color chosenColor = chooseCustomColor();
        if (chosenColor != null) {
            frame.textArea.setForeground(chosenColor);
        }
    }

    private Color chooseCustomColor() {
        Color initialColor = Color.BLACK; // Default initial color
        return JColorChooser.showDialog(frame, "Choose Custom Color", initialColor);
    }

}
