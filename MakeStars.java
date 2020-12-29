import java.util.*;
import java.io.*;

public class MakeStars {
  public static String starify (String a) {
    int len = a.length();
    String str = "";
    for (int i = 0; i < len; i++) {
      str += "*";
    }
    return str;
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
        outputStuff += starify(word) + " ";
      }
      outputStuff += "\n";
    }
    System.out.println(outputStuff);
  }
}
