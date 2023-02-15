package org.example.Note;

import java.util.List;

public interface FileOperable {
    List<String> readAllLines();

    void saveAllLines(List<String> lines);
}

