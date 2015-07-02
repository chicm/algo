package chicm;

public class Anagram {

  public static void main(String[] args) {
    // TODO Implement Anagram.main
   
    System.out.println(anagram("hhpddlnnsjfoyxpciioigvjqzfbpllssuj"));
    System.out.println(anagram("xulkowreuowzxgnhmiqekxhzistdocbnyozmnqthhpievvlj"));
    System.out.println(anagram("dnqaurlplofnrtmh"));
    System.out.println(anagram("aujteqimwfkjoqodgqaxbrkrwykpmuimqtgulojjwtukjiqrasqejbvfbixnchzsahpnyayutsgecwvcqngzoehrmeeqlgknnb"));   
    System.out.println(anagram("lbafwuoawkxydlfcbjjtxpzpchzrvbtievqbpedlqbktorypcjkzzkodrpvosqzxmpad"));
    System.out.println(anagram("drngbjuuhmwqwxrinxccsqxkpwygwcdbtriwaesjsobrntzaqbe"));
    
  }
  private static int anagram(String s) {
    if(s.length() % 2 != 0) {
        return -1;
    }
    String s1 = s.substring(0, s.length()/2 );
    String s2 = s.substring(s.length()/2);
    char[] ch1 = s1.toCharArray();
    sort(ch1);
    char[] ch2 = s2.toCharArray();
    sort(ch2);
    int count = 0;
    for(int i = 0; i < ch1.length; i++) {
        if(ch1[i] != ch2[i]) {
            count++;
        }
    }
    return count;
}
private static void sort(char[] ch) {
    char[] tmp = new char[ch.length];
    int[] count = new int[26];
    for(int i = 0; i < ch.length; i++) {
        count[ch[i]-'a'] ++;
    }
    int l = 0;
    for(int j = 0; j < 26; j++) {
        for(int k = 0; k < count[j]; k++) {
            tmp[l++] = (char)('a'+(char)j);
        }
    }
    System.arraycopy(tmp, 0, ch, 0, ch.length);
}
}
