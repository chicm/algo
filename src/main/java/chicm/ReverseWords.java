package chicm;

import java.util.StringTokenizer;

/**
 * Given an input string, reverse the string word by word.

For example,
Given s = "the sky is blue",
return "blue is sky the".

 * @author chicm
 *
 */

public class ReverseWords {
  public String reverseWords(String s) {
    if(s == null)
        return null;
    String str = s.trim();
    str = reverseString(str.toCharArray());
    StringTokenizer st = new StringTokenizer(str);
    StringBuilder sb = new StringBuilder();
    while( st.hasMoreElements() ){
          char[] c = st.nextToken().toCharArray();
          sb.append(reverseString(c) + " ");
    }
    return sb.toString().trim();
    }
    private String reverseString(char[] s) {
        if (s.length < 2)
            return new String(s);
        for( int i=0, j=s.length-1; i < j; i++, j--) {
            char tmp = s[i];
            s[i] = s[j];
            s[j] = tmp;
        }
        return new String(s);
    }
}
