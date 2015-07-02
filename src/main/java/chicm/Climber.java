package chicm;

import java.util.Arrays;
import java.util.List;

public class Climber {

  public static void printM(Mountain[] m1) {
    for(Mountain m: m1) {
      System.out.print(m);
    }
  }
  
  public static void main(String[] args) {
    // TODO Implement Climber.main
    Mountain[] m1 = {new Mountain(1,3,2), new Mountain(1, 5, 10), new Mountain(6, 7, 5)};
    Mountain[] mountains = {new Mountain(1,3,2), new Mountain(2, 4, 4), new Mountain(6, 7, 5)};
    Arrays.sort(mountains);
    Arrays.sort(m1);
    printM(m1);
    
    int travelPoint = 0; int totalLen = 0;
    int lastHeight = 0; int lastEnd = 0;
    for(int i = 0; i < mountains.length; i++) {
      // move to start point of the current mountain for each loop
      if(mountains[i].getStart() > travelPoint ) {
        if(lastEnd < mountains[i].start) {
          totalLen += lastHeight; //move down
          totalLen += mountains[i].getStart() - travelPoint;  //move
          //totalLen += Math.abs(mountains[i].getHeight() - lastHeight);  //climb
          totalLen += mountains[i].height;
        } else if(lastEnd >= mountains[i].start) {
            totalLen += mountains[i].getStart() - travelPoint;  //move
            totalLen += Math.abs(mountains[i].getHeight() - lastHeight);
        }
      }
      travelPoint = mountains[i].start;
      lastHeight = mountains[i].height;
      lastEnd = mountains[i].end;
      
      if(i == mountains.length-1) {
        // move down
        totalLen += mountains[i].end - travelPoint;  //move
        totalLen += mountains[i].height;
      }
    }
    System.out.println(totalLen); 
  }

  static class Mountain implements Comparable<Mountain>{
    private int start;
    private int end;
    private int height;
    public Mountain(int start, int end, int height) {
        this.start = start;
        this.end = end;
        this.height = height;
    }
    public int getWidth() {
        return end - start;
    }
    public int getHeight() {
        return height;
    }
    public int getStart() {
        return start;
    }
    public String toString() {
        return String.format("[%d, %d, %d]", start, end, height);
    }
    public int compareTo(Mountain obj) {
        if( start > obj.getStart()) {
          return 1;
        } else if(start < obj.getStart()) {
          return -1;
        } else { // same start
          if(height < obj.getHeight()) {
            return 1;
          } else if(height > obj.getHeight()) {
            return -1;
          } else {
            return 0;
          }
        }
    }
}
}
