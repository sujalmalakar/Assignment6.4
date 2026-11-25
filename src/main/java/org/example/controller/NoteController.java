
package org.example.controller;

import org.example.model.Note;
import org.example.model.Notebook;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class NoteController {

    @FXML
    private TextField titleField;

    @FXML
    private TextArea contentArea;

    @FXML
    private TextArea notesDisplay;

    private Notebook notebook;

    public NoteController() {
        notebook = new Notebook();
    }

    @FXML
    public void addNote() {
        String title = titleField.getText();
        String content = contentArea.getText();

        if (title.isEmpty() || content.isEmpty()) {
            notesDisplay.setText("Please enter a title and content.");
            return;
        }

        Note note = new Note(title, content);
        notebook.addNote(note);

        notesDisplay.appendText(title + "\n" + content + "\n\n");

        titleField.clear();
        contentArea.clear();
    }
}

