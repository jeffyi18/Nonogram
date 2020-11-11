package com.comp301.a08nonograms.model;

public class BoardImpl implements Board {

  private String[][] boardState;
  private int width;
  private int height;

  public BoardImpl (int width, int height) {
    this.width = width;
    this.height = height;
    boardState = new String[width][height];
    for (int i = 0; i < width; i++) {
      for (int j = 0; j < height; j++) {
        boardState[i][j] = "blank";
      }
    }
  }

  @Override
  public boolean isShaded(int row, int col) {
    if (row >= width || col >= height) {
      throw new RuntimeException();
    }
    return boardState[row][col].equals("shaded");
  }

  @Override
  public boolean isEliminated(int row, int col) {
    if (row >= width || col >= height) {
      throw new RuntimeException();
    }
    return boardState[row][col].equals("eliminated");
  }

  @Override
  public boolean isSpace(int row, int col) {
    if (row >= width || col >= height) {
      throw new RuntimeException();
    }
    return boardState[row][col].equals("blank");
  }

  @Override
  public void toggleCellShaded(int row, int col) {
    if (row >= width || col >= height) {
      throw new RuntimeException();
    }
    if (boardState[row][col].equals("shaded")) {
      boardState[row][col] = "blank";
    } else {
      boardState[row][col] = "shaded";
    }
  }

  @Override
  public void toggleCellEliminated(int row, int col) {
    if (row >= width || col >= height) {
      throw new RuntimeException();
    }
    if (boardState[row][col].equals("eliminated")) {
      boardState[row][col] = "blank";
    } else {
      boardState[row][col] = "eliminated";
    }
  }

  @Override
  public void clear() {
    for (int i = 0; i < boardState.length; i++) {
      for (int j = 0; j < boardState[0].length; j++) {
        boardState[i][j] = "blank";
      }
    }
  }
}
