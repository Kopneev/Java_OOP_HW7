package org.example.Note;

import java.util.List;

public interface Baseable {
    List<Note> getAllNote();

    void CreateNote(Note note);

    void UpdateNote(Note note, Fields field, String param);

    void deleteNote(List notes);
}