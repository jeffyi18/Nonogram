package com.comp301.a08nonograms.model;

public final class BoardImpl implements Board {

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
}
