package com.comp301.a08nonograms.view;

import com.comp301.a08nonograms.controller.Controller;
import com.comp301.a08nonograms.model.Clues;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

public class CluesView implements FXComponent {

  private final Controller controller;

  public CluesView(Controller controller) {
    this.controller = controller;
  }

  @Override
  public Parent render() {
    Clues clues = controller.getClues();

    HBox hbox = new HBox();
    hbox.setPadding(new Insets(15, 12, 5, 12));
    Text buffer = new Text("");
    hbox.getChildren().add(buffer);

    hbox.setSpacing(32);
    for (int i = 0; i < clues.getWidth(); i++) {
      String clueText = "";
      for (int j = 0; j < clues.getColCluesLength(); j++) {
        clueText += clues.getColClues(i)[j] + "\n";
      }
      Text clue = new Text(clueText);
      hbox.getChildren().add(clue);
    }

    return hbox;
  }
}
