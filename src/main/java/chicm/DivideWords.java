package chicm;

import java.util.HashSet;
import java.util.Set;

public class DivideWords {
  private final static Set<String> dict = new HashSet<String>();
  
  public static void main(String[] args) {
    String text = "thisisanexample";
    DivideWords d = new DivideWords();
    Set<String> rs = d.divide(text);
    
    System.out.println(rs);
    
  }
  
  public DivideWords() {
    buildDictionary();
  }
  
  private void buildDictionary() {
    dict.add("this");
    dict.add("is");
    dict.add("thisis");
    dict.add("an");
    dict.add("example");
  }
  
  public Set<String> divide(String text) {
    Set<String> result = new HashSet<String>();
    
    int n = text.length();
    if(n < 1) {
      return result;
    }
    
    for( int i = 1; i <= text.length(); i++) {
      String word = text.substring(0, i);
      if(dict.contains(word)) {
        result.add(word);
        result.addAll(divide(text.substring(i)));
      }
    }
    
    return result;
  }
  
}
