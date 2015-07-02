package chicm;

import java.util.Arrays;

public class WordSearch {
  
  public static void main(String[] args) {
    char[][] board = {{'a'}};  
    char[][] board2 = {"CAA".toCharArray(),"AAA".toCharArray(),"BCD".toCharArray()};  
    
    System.out.println(exist(board2, "AAB"));
  }
  
  public static boolean exist(char[][] board, String word) {
    if(board == null || word == null) {
        return false;
    }
    if(board.length == 0 || board[0].length == 0) {
        return false;
    }
    
    boolean[][] used = new boolean[board.length][board[0].length];
    for(boolean[] u:used) {
        Arrays.fill(u, false);
    }
    
    for(int i = 0; i < board.length; i++) {
        for(int j = 0; j < board[0].length; j++) {
            if(dfs(board, used, word, 0, i, j)) {
                return true;
            }
        }
    }
    return false;
  }
  // dfs search starting from index [i, j] of board
  private static boolean dfs(char[][] board, boolean[][] used, String word, int wordIndex, int i, int j) {
    if(word.length() < 1 || wordIndex >= word.length()) {
        return true;
    }
    if(word.charAt(wordIndex) != board[i][j] || used[i][j]) {
        return false;
    }else {
      used[i][j] = true;
      if(wordIndex + 1 >= word.length()) {
        return true;
      }
    }
    used[i][j] = true;
    int maxI = board.length - 1;
    int maxJ = board[0].length - 1;
    //up
    if(i-1 >= 0 && dfs(board, used, word, wordIndex+1, i-1, j)) {
        return true;
    }
    //down
    if(i+1 <= maxI && dfs(board, used, word, wordIndex+1, i+1, j)) {
        return true;
    }
    //left
    if(j-1>=0 && dfs(board, used, word, wordIndex+1, i, j-1)) {
        return true;
    }
    //right
    if(j+1<=maxJ && dfs(board, used, word, wordIndex+1, i, j+1)) {
        return true;
    }
    used[i][j] = false;
    return false;
  }
}
