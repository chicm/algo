package chicm;

public class PermutationSequence {

  public static void main(String[] args) {
    // TODO Implement PermutationSequence.main
    
    PermutationSequence p = new PermutationSequence();
    
    p.getPermutation(3, 6);
    System.out.println(new String(p.result));

  }
  
  
  char[] result = null;
  int counter = 1;
  
  public String getPermutation(int n, int k) {
      char[] a = new char[n];
      for(int i = 0; i<n; i++) {
        a[i] = (char) ((char)(i+1) + '0');
      }
      
      permutation(a, 0, a.length-1, 1, k);
      
      //return null;
      return new String(result);
  }
  
  private int permutation(char[] a, int start, int end, int k, int target) {
 
      
      if(start >= end) {
        System.out.println(counter);
        System.out.println(new String(a));
          counter++;
          if(counter== target) {
            result =a;
          }
          return counter;
      }
      
      int ret = k;
      System.out.println("start:" + start);
      for(int i = start; i <= end ; i++) {
          char tmp = a[i];
          a[i] = a[start];
          a[start] = tmp;
          
          ret = permutation(a, start+1, end, ret, target );
          
          tmp = a[i];
          a[i] = a[start];
          a[start] = tmp;
          
      }
      
      return ret;
  }
}
