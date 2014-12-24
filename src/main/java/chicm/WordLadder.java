package chicm;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * Given two words (start and end), and a dictionary, find the length of shortest transformation sequence from start to end, such that:

Only one letter can be changed at a time
Each intermediate word must exist in the dictionary
For example,

Given:
start = "hit"
end = "cog"
dict = ["hot","dot","dog","lot","log"]
As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
return its length 5.

Note:
Return 0 if there is no such transformation sequence.
All words have the same length.
All words contain only lowercase alphabetic characters.
 */

public class WordLadder {

  public static void main(String[] args) {
    Set<String> dict = new HashSet<>();
    dict.addAll(Arrays.asList("hot", "dot", "dog", "lot", "log"));
    System.out.println(dict);
    WordLadder lad = new WordLadder();
    System.out.println(lad.ladderLength("hit", "cog", dict));
  }
  
  class Node {
    public String value;
    public int depth = 0;
    //public boolean visited = false;;
    
    Node(String value, boolean v, int dep) {
        this.value = value;
        //this.visited = v;
        this.depth = dep;
    }
  }
  
  private Set<Node> getNeighbous(Node node, Set<String> dict, int depth) {
      
      Set<Node> nei = new HashSet<Node>();
      if(node == null || dict == null || dict.isEmpty() 
        || node.value == null || node.value.length() < 1) {
          return nei;
      }
      char[] c = node.value.toCharArray();
      for(int i = 0; i < c.length; i++) {
          char oldChar = c[i];
          for( char ch = 'a'; ch <= 'z'; ch++) {
              if(ch != c[i]) {
                  c[i] = ch;
                  String tmp = new String(c);
                  if(dict.contains(tmp)) {
                      nei.add(new Node(tmp, false, depth));
                      dict.remove(tmp);
                      System.out.println(tmp);
                  }
              }
          }
          c[i] = oldChar;
      }
      return nei;
  }
  public int ladderLength(String start, String end, Set<String> dict) {
      Queue<Node> q = new LinkedList<Node>();
      if(start == null || start.length() <1 || end == null || end.length() < 1 || dict == null) {
          return 0;
      }
      dict.add(end);
      q.offer(new Node(start, false, 1));
      while(!q.isEmpty()) {
          Node curNode = q.poll();
          if(curNode.value.equals(end)) {
              return curNode.depth;
          }
          Set<Node> neighbours = getNeighbous(curNode, dict, curNode.depth+1);
          for(Node n: neighbours) {
              q.offer(n);
          }
      }
      return 0;
  }

}
