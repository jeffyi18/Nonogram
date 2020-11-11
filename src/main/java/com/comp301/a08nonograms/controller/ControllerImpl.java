package com.comp301.a08nonograms.controller;

import java.util.Random;
import com.comp301.a08nonograms.model.Clues;
import com.comp301.a08nonograms.model.Model;

public class ControllerImpl implements Controller {

  private final Model currentModel;

  public ControllerImpl(Model model) {
    currentModel = model;
  }

  @Override
  public Clues getClues() {
    return currentModel.getClues();
  }

  @Override
  public boolean isSolved() {
    return currentModel.isSolved();
  }

  @Override
  public boolean isShaded(int row, int col) {
    return currentModel.isShaded(row, col);
  }

  @Override
  public boolean isEliminated(int row, int col) {
    return currentModel.isEliminated(row, col);
  }

  @Override
  public void toggleShaded(int row, int col) {
    currentModel.toggleCellShaded(row, col);
  }

  @Override
  public void toggleEliminated(int row, int col) {
    currentModel.toggleCellEliminated(row, col);
  }

  @Override
  public void nextPuzzle() {
    int index = currentModel.getPuzzleIndex();
    if (index == 4) {
      currentModel.setPuzzleIndex(0);
    } else {
      currentModel.setPuzzleIndex(index + 1);
    }
  }

  @Override
  public void prevPuzzle() {
    int index = currentModel.getPuzzleIndex();
    if (index == 0) {
      currentModel.setPuzzleIndex(4);
    } else {
      currentModel.setPuzzleIndex(index - 1);
    }
  }

  @Override
  public void randPuzzle() {
    Random rand = new Random();
    int upperbound = 5;
    int randomIndex = rand.nextInt(upperbound);
    currentModel.setPuzzleIndex(randomIndex);
  }

  @Override
  public void clearBoard() {
    currentModel.clear();
  }

  @Override
  public int getPuzzleIndex() {
    return currentModel.getPuzzleIndex();
  }

  @Override
  public int getPuzzleCount() {
    return currentModel.getPuzzleCount();
  }
}
