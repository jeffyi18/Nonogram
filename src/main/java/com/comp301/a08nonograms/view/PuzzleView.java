package com.comp301.a08nonograms.view;

import com.comp301.a08nonograms.controller.Controller;
import com.comp301.a08nonograms.model.Clues;
import javafx.scene.Parent;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

public class PuzzleView implements FXComponent {

  private final Controller controller;

  public PuzzleView(Controller controller) {
    this.controller = controller;
  }

  @Override
  public Parent render() {
    Clues clues = controller.getClues();

    // Setting up GridPane for rectangle grid
    GridPane layout = new GridPane();

    for (int i = 0; i < clues.getHeight(); i++) {
      for (int j = 0; j < clues.getWidth(); j++) {

        Rectangle cell = new Rectangle(30, 30, new Color(1, 1, 1, 1));

        // Add if statement to check shade/eliminated
        if (controller.isEliminated(i, j)) {
          cell = new Rectangle(40, 40, new Color(1, 0, 0, 1));
        } else if (controller.isShaded(i, j)) {
          cell = new Rectangle(40, 40, new Color(0, 0, 0, 1));
        } else {
          cell = new Rectangle(40, 40, new Color(1, 1, 1, 1));
        }

        int finalI = i;
        int finalJ = j;

        cell.setOnMousePressed((MouseEvent event) -> {
          if (event.getButton() == MouseButton.PRIMARY) {
            controller.toggleShaded(finalI, finalJ);
          } else if (event.getButton() == MouseButton.SECONDARY) {
            controller.toggleEliminated(finalI, finalJ);
          }
        });

        layout.add(cell, j, i);
      }
      String clueText = "";
      for (int j = 0; j < clues.getRowCluesLength(); j++) {
        clueText += clues.getRowClues(i)[j] +" ";
      }
      Text clue = new Text(clueText);
      layout.add(clue, clues.getWidth() + 1, i);
    }
    return layout;
  }
}
