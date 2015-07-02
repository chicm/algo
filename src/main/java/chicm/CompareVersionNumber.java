package chicm;

public class CompareVersionNumber {

  public static void main(String[] args) {
    System.out.println(compareVersion("111.1", "0.111"));

  }
  public static int compareVersion(String version1, String version2) {
    
    String[] s1 = version1.split("\\.");
    String[] s2 = version2.split("\\.");
    
    if(s1 == null || s2 == null) {
        throw new IllegalArgumentException("");
    }
    int minLen = Math.min(s1.length, s2.length);
    for(int i = 0; i < minLen; i++) {
        int n1 = Integer.parseInt(s1[i]);
        int n2 = Integer.parseInt(s2[i]);
        if(n1 > n2) {
            return 1;
        } else if(n1 < n2) {
            return -1;
        }
    }
    
    if(s1.length > minLen) {
        for(int j = minLen; j < s1.length; j++) {
            if(Integer.parseInt(s1[j]) > 0) {
                return 1;
            }
        }
    } else if(s2.length > minLen) {
        for(int j = minLen; j < s2.length; j++) {
            if(Integer.parseInt(s2[j]) > 0) {
                return -1;
            }
        }
    }
    return 0;
  }
}
