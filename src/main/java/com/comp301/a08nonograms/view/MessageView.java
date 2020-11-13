package com.comp301.a08nonograms.view;

import com.comp301.a08nonograms.controller.Controller;
import javafx.scene.Parent;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

public class MessageView implements FXComponent {
  private final Controller controller;

  public MessageView(Controller controller) {
    this.controller = controller;
  }

  @Override
  public Parent render() {
    HBox hbox = new HBox();
    Text finished = new Text("You finished the nonogram!");
    if (controller.isSolved()) {
      hbox.getChildren().add(finished);
    }
    return hbox;
  }
}
