package se.sofia;

public class EditFunctions {

    MyFrame frame;

    public EditFunctions (MyFrame frame) {
        this.frame = frame;
    }

    public void makeUndo() {
        frame.undoManager.undo();
    }

    public void makeRedo() {
        frame.undoManager.redo();
    }
}
