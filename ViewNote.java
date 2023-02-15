package org.example.Note;

import java.util.Date;
import java.util.Scanner;


public class ViewNote {
    private final NoteController noteController;
    private final Loggerable loggerable;

    public ViewNote(NoteController noteController, Loggerable loggerable) {
        this.noteController = noteController;
        this.loggerable = loggerable;
    }

    public void run() {
        Commands com = Commands.NONE;
        showHelp();
        while (true) {
            try {
                String command = prompt("Введите команду: ");
                com = Commands.valueOf(command.toUpperCase());
                loggerable.save(com);
                if (com == Commands.EXIT)
                    return;
                switch (com) {
                    case CREATE:
                        create();
                        break;
                    case READ:
                        read();
                        break;
                    case DELETE:
                        delete();
                        break;
                    case UPDATE:
                        update();
                        break;
                    case LIST:
                        list();
                        break;
                    case WRITE:
                        write();
                        break;
                    case HELP:
                        showHelp();
                        break;
                }
            } catch (Exception ex) {
                System.out.println("Произошла ошибка " + ex);
            }
        }
    }

    private void write() {
        for (String item : loggerable.read()) {
            System.out.println(item);
        }
    }

    private void read() throws Exception {
        String id = prompt("Идентификатор пользователя: ");
        Note note_ = noteController.readNote(id);
        System.out.println(note_);
    }

    private void update() throws Exception {
        String id = prompt("Идентификатор пользователя: ");
        String field_name = prompt("Выбор поля (TITLE, TEXT): ").toUpperCase();
        String param = prompt("Введите новые данные. ");
        Note _note = noteController.readNote(id);
        noteController.updateNote(_note, Fields.valueOf(field_name.toUpperCase()), param);
    }

    private void delete() throws Exception {
        String id = prompt("Введите идентификатор пользователя для удаления: ");
        System.out.println(noteController.readNote(id));
        String yes = prompt("Подтвердите командой YES, а если передумали, то введите любой символ. ")
                .toUpperCase();
        if (id.equals("YES")) {
            noteController.deleteNote(id);
        } else {
            System.out.println("Удаление отменено.");
        }
    }

    private void list() {
        for (Note note : noteController.getNotes()) {
            System.out.println(note);
        }
    }

    private void create() {
        String title = prompt("Причина: ");
        String text = prompt("Текст: ");
        String date = new Date().toString();
        noteController.saveNote(new Note(title, text, date));
    }

    private void showHelp() {
        System.out.println("Список команд:");
        for (Commands c : Commands.values()) {
            System.out.println(c);
        }
    }

    public String prompt(String message) {
        Scanner in = new Scanner(System.in);
        System.out.print(message);
        return in.nextLine();
    }
}