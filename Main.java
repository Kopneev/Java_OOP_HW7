package org.example.Note;

public class Main {
    public static void main(String[] args) {
        FileOperable fileOperable = new FileOperator("notes.txt");
        Loggerable loggerable = new Logger("logs.txt");
        Baseable baseable = new Base(fileOperable);
        NoteController controller = new NoteController(baseable);
        ViewNote view = new ViewNote(controller, loggerable);
        view.run();
    }
}