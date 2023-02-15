package org.example.Note;

import java.util.List;

public class NoteController {
    private final Baseable baseable;

    public NoteController(Baseable baseable) {
        this.baseable = baseable;
    }

    public void saveNote(Note note) {
        baseable.CreateNote(note);
    }

    public void updateNote(Note note, Fields field, String param) {
        baseable.UpdateNote(note, field, param);
    }

    public Note readNote(String noteId) throws Exception {
        List<Note> notes = baseable.getAllNote();
        for (Note note : notes) {
            if (note.getId().equals(noteId)) {
                return note;
            }
        }

        throw new Exception("Note not found");
    }

    public Note deleteNote(String noteId) throws Exception {
        List<Note> notes = baseable.getAllNote();
        for (Note note : notes) {
            if (note.getId().equals(noteId)) {
                notes.remove(note);
                baseable.deleteNote(notes);
                return note;
            }
        }

        throw new Exception("Note not found");
    }

    public List<Note> getNotes() {
        return baseable.getAllNote();
    }

}