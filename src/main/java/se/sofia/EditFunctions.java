package se.sofia;

public class EditFunctions {

    MyFrame frame;

    public EditFunctions (MyFrame frame) {
        this.frame = frame;
    }

    public void makeUndo() {
        System.out.println("UNDO");
    }

    public void makeRedo() {
        System.out.println("REDO");
    }
}
