package com.comp301.a08nonograms.model;

import java.util.ArrayList;
import java.util.List;

public class ModelImpl implements Model {

  private ArrayList<Clues> clues;

  public ModelImpl(ArrayList<Clues> clues) {
    this.clues = clues;
  }

  @Override
  public int getPuzzleCount() {
    return 0;
  }

  @Override
  public int getPuzzleIndex() {
    return 0;
  }

  @Override
  public void setPuzzleIndex(int index) {

  }

  @Override
  public void addObserver(ModelObserver observer) {

  }

  @Override
  public void removeObserver(ModelObserver observer) {

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
  public boolean isSpace(int row, int col) {
    return false;
  }

  @Override
  public void toggleCellShaded(int row, int col) {

  }

  @Override
  public void toggleCellEliminated(int row, int col) {

  }

  @Override
  public void clear() {

  }

  @Override
  public int getWidth() {
    return 0;
  }

  @Override
  public int getHeight() {
    return 0;
  }

  @Override
  public int[] getRowClues(int index) {
    return new int[0];
  }

  @Override
  public int[] getColClues(int index) {
    return new int[0];
  }

  @Override
  public int getRowCluesLength() {
    return 0;
  }

  @Override
  public int getColCluesLength() {
    return 0;
  }
}
