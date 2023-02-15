package org.example.Note;

import java.util.List;

public interface Loggerable {
    void save(Commands com);

    List<String> read();
}
