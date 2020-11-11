package com.comp301.a08nonograms.model;

public final class CluesImpl implements Clues {

  private final int[][] rowClues;
  private final int[][] colClues;
  private final int height;
  private final int width;

  public CluesImpl(int[][] rowClues, int[][] colClues) {
    this.rowClues = rowClues;
    this.colClues = colClues;
    this.width = rowClues.length;
    this.height = colClues.length;
  }

  @Override
  public int getWidth() { return width;
  }

  @Override
  public int getHeight() {
    return height;
  }

  @Override
  public int[] getRowClues(int index) {
    return rowClues[index];
  }

  @Override
  public int[] getColClues(int index) {
    return colClues[index];
  }

  @Override
  public int getRowCluesLength() {
    return rowClues[0].length;
  }

  @Override
  public int getColCluesLength() {
    return colClues[0].length;
  }
}
