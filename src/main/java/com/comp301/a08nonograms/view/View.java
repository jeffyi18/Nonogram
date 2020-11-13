package com.comp301.a08nonograms.view;

import com.comp301.a08nonograms.controller.Controller;
import javafx.scene.Parent;
import javafx.scene.layout.VBox;

public class View implements FXComponent {
  private final Controller controller;

  public View(Controller controller) {
    this.controller = controller;
  }

  @Override
  public Parent render() {
    VBox layout = new VBox();

    //Clues View
    CluesView cluesView = new CluesView(controller);
    layout.getChildren().add(cluesView.render());

    // Puzzle view
    PuzzleView puzzleView = new PuzzleView(controller);
    layout.getChildren().add(puzzleView.render());

    // Control view
    ControlView controlView = new ControlView(controller);
    layout.getChildren().add(controlView.render());

    // Message view
    MessageView messageView = new MessageView(controller);
    layout.getChildren().add(messageView.render());
    return layout;
  }
}
