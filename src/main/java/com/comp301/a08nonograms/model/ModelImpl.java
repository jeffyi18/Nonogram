package com.comp301.a08nonograms.model;

import java.util.ArrayList;
import java.util.List;

public class ModelImpl implements Model {
  private List<ModelObserver> observers;
  private List<Clues> clues;
  private Clues currentClues;
  private int puzzleIndex;
  private Board puzzleBoard;

  public ModelImpl(List<Clues> clues) {
    observers = new ArrayList<>();
    this.clues = clues;
    puzzleIndex = 0;
    puzzleBoard = new BoardImpl(0, 0);
    setPuzzleIndex(0);
  }

  public Clues getClues() {
    return currentClues;
  }

  @Override
  public int getPuzzleCount() {
    return clues.size();
  }

  @Override
  public int getPuzzleIndex() {
    return puzzleIndex;
  }

  @Override
  public void setPuzzleIndex(int index) {
    puzzleIndex = index;
    currentClues = clues.get(puzzleIndex);
    puzzleBoard = new BoardImpl(currentClues.getWidth(), currentClues.getHeight());
    notifyObservers();
  }

  public void notifyObservers() {
    for (ModelObserver i : observers) {
      i.update(this);
    }
  }

  @Override
  public void addObserver(ModelObserver observer) {
    observers.add(observer);
  }

  @Override
  public void removeObserver(ModelObserver observer) {
    observers.remove(observer);
  }

  @Override
  public boolean isSolved() {
    for (int i = 0; i < getWidth(); i++) {
      int[] colClue = getColClues(i);
      int expectedTotalShaded = 0;
      for (int j = 0; j < colClue.length; j++) {
        expectedTotalShaded += colClue[j];
      }
      int totalShaded = 0;
      for (int j = 0; j < getHeight(); j++) {
        if (isShaded(j, i)) {
          totalShaded++;
        }
      }
      if (expectedTotalShaded != totalShaded) {
        return false;
      }
    }

    for (int i = 0; i < getHeight(); i++) {
      int[] rowClue = getRowClues(i);
      int expectedTotalShaded = 0;
      for (int j = 0; j < rowClue.length; j++) {
        expectedTotalShaded += rowClue[j];
      }
      int totalShaded = 0;
      for (int j = 0; j < getWidth(); j++) {
        if (isShaded(i, j)) {
          totalShaded++;
        }
      }
      if (expectedTotalShaded != totalShaded) {
        return false;
      }
    }

    return true;
  }

  @Override
  public boolean isShaded(int row, int col) {
    return puzzleBoard.isShaded(row, col);
  }

  @Override
  public boolean isEliminated(int row, int col) {
    return puzzleBoard.isEliminated(row, col);
  }

  @Override
  public boolean isSpace(int row, int col) {
    return puzzleBoard.isSpace(row, col);
  }

  @Override
  public void toggleCellShaded(int row, int col) {
    puzzleBoard.toggleCellShaded(row, col);
    notifyObservers();
  }

  @Override
  public void toggleCellEliminated(int row, int col) {
    puzzleBoard.toggleCellEliminated(row, col);
    notifyObservers();
  }

  @Override
  public void clear() {
    puzzleBoard.clear();
    notifyObservers();
  }

  @Override
  public int getWidth() {
    return currentClues.getWidth();
  }

  @Override
  public int getHeight() {
    return currentClues.getHeight();
  }

  @Override
  public int[] getRowClues(int index) {
    return currentClues.getRowClues(index);
  }

  @Override
  public int[] getColClues(int index) {
    return currentClues.getColClues(index);
  }

  @Override
  public int getRowCluesLength() {
    return currentClues.getRowCluesLength();
  }

  @Override
  public int getColCluesLength() {
    return currentClues.getColCluesLength();
  }
}
