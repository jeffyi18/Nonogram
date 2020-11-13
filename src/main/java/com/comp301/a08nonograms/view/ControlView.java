package com.comp301.a08nonograms.view;

import com.comp301.a08nonograms.controller.Controller;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

public class ControlView implements FXComponent {
  private final Controller controller;

  public ControlView(Controller controller) {
    this.controller = controller;
  }

  @Override
  public Parent render() {
    HBox hbox = new HBox();
    hbox.setPadding(new Insets(15, 12, 15, 12));
    hbox.setSpacing(10);

    Button randomButton = new Button("Random");
    randomButton.setOnAction(
        (ActionEvent event) -> {
          controller.randPuzzle();
      });

    Button resetButton = new Button("Reset");
    resetButton.setOnAction(
        (ActionEvent event) -> {
          controller.clearBoard();
      });

    Button previousButton = new Button("\u00AB");
    previousButton.setOnAction(
        (ActionEvent event) -> {
          controller.prevPuzzle();
      });

    Text puzzleNumber = new Text("Puzzle " + (controller.getPuzzleIndex() + 1) + "/5");

    Button nextButton = new Button("\u00BB");
    nextButton.setOnAction(
        (ActionEvent event) -> {
          controller.nextPuzzle();
      });

    hbox.getChildren().addAll(randomButton, resetButton, previousButton, puzzleNumber, nextButton);
    return hbox;
  }
}
