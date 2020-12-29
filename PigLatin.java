import java.util.*;
import java.io.*;

public class PigLatin {

  public static String pigLatinSimple (String s) {
    if ((s.charAt(0) == 'a') || (s.charAt(0) == 'e') || (s.charAt(0) == 'i') || (s.charAt(0) == 'o') || (s.charAt(0) == 'u')) {
      return s + "hay";
    }
    return s.substring(1) + s.charAt(0) + "ay";
  }

  public static String pigLatin (String s) {
    s = s.toLowerCase();
    String [] Digraph = {"bl", "br", "ch", "ck", "cl", "cr", "dr", "fl", "fr", "gh", "gl", "gr", "ng", "ph", "pl", "pr", "qu", "sc", "sh", "sk", "sl", "sm", "sn", "sp", "st", "sw", "th", "tr", "tw", "wh", "wr"};
    for (int i = 0; i < Digraph.length; i++) {
      if (s.length() > 2 && s.substring(0, 2).equals(Digraph[i])) {
        return s.substring(2) + s.substring(0, 2) + "ay";
      }
    }
    return pigLatinSimple(s);
  }

  public static String pigLatinBest (String s) {
    String punct = "";
    if (!(s.charAt(0) < 'a') && !(s.charAt(0) > 'Z')) {
      return s;
    }
    if (!Character.isLetterOrDigit(s.charAt(s.length() - 1))) {
      punct += (s.charAt(s.length() - 1));
      s = s.substring(0, s.length() - 1);
    }
    s = pigLatin(s);
    s += punct;
    return s;
  }

  public static void main (String [] args) {
    Scanner n = new Scanner (System.in);
    String line = "";
    String word = "";
    String outputStuff = "";
    while (n.hasNextLine()) {
      line = n.nextLine();
      Scanner o = new Scanner (line);
      while (o.hasNext()) {
        word = o.next();
        outputStuff += pigLatinBest(word) + " ";
      }
      outputStuff += "\b\n";
    }
    System.out.print(outputStuff);
  }
}
