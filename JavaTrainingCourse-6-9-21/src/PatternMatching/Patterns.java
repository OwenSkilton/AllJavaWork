package PatternMatching;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Patterns {
    public static void main(String[] args) throws IOException {
//        String toSearch = "He boss can i have da pussy plz boss 6";
//        //Boss or pussy, Word starting with C ending with N, Any decimal
//        String[] toFind = {"(boss|pussy)", "c*n", "\\d"};
//        Pattern p;
//        Matcher m;
//        for (String find : toFind){
//            p = Pattern.compile(find);
//            m = p.matcher(toSearch);
//            if (m.find()){
//                System.out.println(m.start());
//            }
//        }

        //File input
        String toSearch2 = Files.readString(Path.of("src/text.txt"));
        String[] toFind2 = {"\\d"};
        Pattern p;
        Matcher m;
        System.out.println(toSearch2);
        for (String find : toFind2){
            p = Pattern.compile(find);
            m = p.matcher(toSearch2);
            if (m.find()){
                System.out.println(m.start());
            }
        }
    }
}
