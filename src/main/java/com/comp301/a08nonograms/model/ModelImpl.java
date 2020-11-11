package com.comp301.a08nonograms.model;

import java.util.ArrayList;
import java.util.List;

public class ModelImpl implements Model {
  private List<ModelObserver> observers;
  private ArrayList<Clues> clues;
  private Clues currentClues;
  private int puzzleIndex;
  private Board puzzleBoard;

  public ModelImpl(ArrayList<Clues> clues) {
    observers = new ArrayList<>();
    this.clues = clues;
    puzzleIndex = 0;
    puzzleBoard = new BoardImpl(0,0);
    setPuzzleIndex(0);
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
    puzzleBoard = new BoardImpl(clues.get(index).getWidth(), clues.get(index).getHeight());
    currentClues = clues.get(index);
    notifyObservers();
  }

  public void notifyObservers() {
    for (ModelObserver i: observers) {
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
    return false;
  }

  @Override
  public boolean isShaded(int row, int col) {
    return puzzleBoard.isShaded(row,col);
  }

  @Override
  public boolean isEliminated(int row, int col) {
    return puzzleBoard.isEliminated(row,col);
  }

  @Override
  public boolean isSpace(int row, int col) {
    return puzzleBoard.isSpace(row,col);
  }

  @Override
  public void toggleCellShaded(int row, int col) {
    puzzleBoard.toggleCellShaded(row,col);
  }

  @Override
  public void toggleCellEliminated(int row, int col) {
    puzzleBoard.toggleCellEliminated(row,col);
  }

  @Override
  public void clear() {
    puzzleBoard.clear();
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
  public int getRowCluesLength() { return currentClues.getRowCluesLength();
  }

  @Override
  public int getColCluesLength() {
    return currentClues.getColCluesLength();
  }
}
