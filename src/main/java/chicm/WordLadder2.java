package chicm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class WordLadder2 {

  public static void main(String[] args) {
    Set<String> dict = new HashSet<>();
    //dict.addAll(Arrays.asList("ted","tex","red","tax","tad","den","rex","pee"));
    dict.addAll(Arrays.asList("kid","tag","pup","ail","tun","woo","erg","luz","brr","gay","sip","kay","per","val","mes","ohs","now","boa","cet","pal","bar","die","war","hay","eco","pub","lob","rue","fry","lit","rex","jan","cot","bid","ali","pay","col","gum","ger","row","won","dan","rum","fad","tut","sag","yip","sui","ark","has","zip","fez","own","ump","dis","ads","max","jaw","out","btu","ana","gap","cry","led","abe","box","ore","pig","fie","toy","fat","cal","lie","noh","sew","ono","tam","flu","mgm","ply","awe","pry","tit","tie","yet","too","tax","jim","san","pan","map","ski","ova","wed","non","wac","nut","why","bye","lye","oct","old","fin","feb","chi","sap","owl","log","tod","dot","bow","fob","for","joe","ivy","fan","age","fax","hip","jib","mel","hus","sob","ifs","tab","ara","dab","jag","jar","arm","lot","tom","sax","tex","yum","pei","wen","wry","ire","irk","far","mew","wit","doe","gas","rte","ian","pot","ask","wag","hag","amy","nag","ron","soy","gin","don","tug","fay","vic","boo","nam","ave","buy","sop","but","orb","fen","paw","his","sub","bob","yea","oft","inn","rod","yam","pew","web","hod","hun","gyp","wei","wis","rob","gad","pie","mon","dog","bib","rub","ere","dig","era","cat","fox","bee","mod","day","apr","vie","nev","jam","pam","new","aye","ani","and","ibm","yap","can","pyx","tar","kin","fog","hum","pip","cup","dye","lyx","jog","nun","par","wan","fey","bus","oak","bad","ats","set","qom","vat","eat","pus","rev","axe","ion","six","ila","lao","mom","mas","pro","few","opt","poe","art","ash","oar","cap","lop","may","shy","rid","bat","sum","rim","fee","bmw","sky","maj","hue","thy","ava","rap","den","fla","auk","cox","ibo","hey","saw","vim","sec","ltd","you","its","tat","dew","eva","tog","ram","let","see","zit","maw","nix","ate","gig","rep","owe","ind","hog","eve","sam","zoo","any","dow","cod","bed","vet","ham","sis","hex","via","fir","nod","mao","aug","mum","hoe","bah","hal","keg","hew","zed","tow","gog","ass","dem","who","bet","gos","son","ear","spy","kit","boy","due","sen","oaf","mix","hep","fur","ada","bin","nil","mia","ewe","hit","fix","sad","rib","eye","hop","haw","wax","mid","tad","ken","wad","rye","pap","bog","gut","ito","woe","our","ado","sin","mad","ray","hon","roy","dip","hen","iva","lug","asp","hui","yak","bay","poi","yep","bun","try","lad","elm","nat","wyo","gym","dug","toe","dee","wig","sly","rip","geo","cog","pas","zen","odd","nan","lay","pod","fit","hem","joy","bum","rio","yon","dec","leg","put","sue","dim","pet","yaw","nub","bit","bur","sid","sun","oil","red","doc","moe","caw","eel","dix","cub","end","gem","off","yew","hug","pop","tub","sgt","lid","pun","ton","sol","din","yup","jab","pea","bug","gag","mil","jig","hub","low","did","tin","get","gte","sox","lei","mig","fig","lon","use","ban","flo","nov","jut","bag","mir","sty","lap","two","ins","con","ant","net","tux","ode","stu","mug","cad","nap","gun","fop","tot","sow","sal","sic","ted","wot","del","imp","cob","way","ann","tan","mci","job","wet","ism","err","him","all","pad","hah","hie","aim","ike","jed","ego","mac","baa","min","com","ill","was","cab","ago","ina","big","ilk","gal","tap","duh","ola","ran","lab","top","gob","hot","ora","tia","kip","han","met","hut","she","sac","fed","goo","tee","ell","not","act","gil","rut","ala","ape","rig","cid","god","duo","lin","aid","gel","awl","lag","elf","liz","ref","aha","fib","oho","tho","her","nor","ace","adz","fun","ned","coo","win","tao","coy","van","man","pit","guy","foe","hid","mai","sup","jay","hob","mow","jot","are","pol","arc","lax","aft","alb","len","air","pug","pox","vow","got","meg","zoe","amp","ale","bud","gee","pin","dun","pat","ten","mob"));
    
    List<List<String>> res = findLadders("cet", "ism",  dict);
    
  }
  private static int successLevel = Integer.MAX_VALUE;
  
  static class Node {
      String value;
      int level = 1;
      List<String> ladder;
      public Node(String value, int level, List<String> ladder) {
          this.value = value;
          this.level = level;
          this.ladder = ladder;
      }
      @Override
      public String toString() {
        return "[" + value +":" +  level + "]";
      }
  }
  
  public static  List<List<String>> findLadders(String start, String end, Set<String> dict) {
      List<List<String>> res = new ArrayList<>();
      List<String> ladder = new ArrayList<>();
      dict.add(end);
      
      Queue<Node> q = new LinkedList<>();
      ladder.add(start);
      q.offer(new Node(start, 1, ladder));
      
      Set<String> levelWords = new HashSet<>();
      levelWords.add(start);
      int preLevel = 0;
      
      while(!q.isEmpty()) {
          System.out.println(q.size());
          Node n = q.poll();
          if(n.level > successLevel) {
              break;
          }
          
          if(n.level > preLevel) {
            dict.removeAll(levelWords);
            levelWords.clear();
            preLevel = n.level;
          }
          
          if(n.value.equals(end)) {
              List<String> tmp = new ArrayList<>(n.ladder);
              res.add(tmp);
              successLevel = n.level;
              System.out.println("successLevel:" + successLevel);
              continue;
          }
          for(String s: getAdj(n.value,dict, end, n.ladder)) {
              levelWords.add(s);
              List<String> newLadder = new ArrayList<>(n.ladder);
              newLadder.add(s);
              q.offer(new Node(s, n.level+1, newLadder));
          }
          
      }
      System.out.println("res:" + res.toString());
      return res;
  }

  private static List<String> getAdj(String word, Set<String> dict, String end, List<String> ladder) {
      List<String> res = new ArrayList<>();

      char[] cWord = word.toLowerCase().toCharArray();
      for(int i = 0; i < word.length(); i++) {
          for(char c = 'a'; c <= 'z'; c++) {
              if(c != cWord[i]) {
                  char tmp = cWord[i];
                  cWord[i] = c;
                  String s = new String(cWord);
                  if(dict.contains(s) && !ladder.contains(s)) {
                      res.add(s);
                  }
                  cWord[i] = tmp;
              }
          }
      }
      return res;
  }
}
