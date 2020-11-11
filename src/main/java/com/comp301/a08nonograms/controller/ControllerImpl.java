package com.comp301.a08nonograms.controller;

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
    return false;
  }

  @Override
  public boolean isShaded(int row, int col) {
    return false;
  }

  @Override
  public boolean isEliminated(int row, int col) {
    return false;
  }

  @Override
  public void toggleShaded(int row, int col) {

  }

  @Override
  public void toggleEliminated(int row, int col) {

  }

  @Override
  public void nextPuzzle() {

  }

  @Override
  public void prevPuzzle() {

  }

  @Override
  public void randPuzzle() {

  }

  @Override
  public void clearBoard() {

  }

  @Override
  public int getPuzzleIndex() {
    return 0;
  }

  @Override
  public int getPuzzleCount() {
    return 0;
  }
}
