import java.util.*;

public class LeetCode720 {
    public static void main(String[] args) {
        HashMap<String, ArrayList<String>> hashMap = new HashMap<>();
        String[] words = // {"m","mo","moc","moch","mocha","l","la","lat","latt","latte","c","ca","cat"};
                {"ts","e","x","pbhj","opto","xhigy","erikz","pbh","opt","erikzb","eri","erik","xlye","xhig","optoj","optoje","xly","pb","xhi","x","o"};
             //   {"b","br","bre","brea","break","breakf","breakfa","breakfas","breakfast","l","lu","lun","lunc","lunch","d","di","din","dinn","dinne","dinner"};
        String[] words1 = {"t","ti","tig","tige","tiger","e","en","eng","engl","engli","englis","english","h","hi","his","hist","histo","histor","history"};
        String[] words2 = { "d","do","dog","p","pe","pen","peng","pengu","pengui","penguin","e","el","ele","elep","eleph","elepha","elephan","elephant"};
        String[] words3 = {"k","lg","it","oidd","oid","oiddm","kfk","y","mw","kf","l","o","mwaqz","oi","ych","m","mwa"};
        String[] words4={"yo","ew","fc","zrc","yodn","fcm","qm","qmo","fcmz","z","ewq","yod","ewqz","y"}; // expected yodn
        /*
        Input
        words =
        ["m","mo","moc","moch","mocha","l","la","lat","latt","latte","c","ca","cat"]

        Output
        "mocha"
        Expected
        "latte"
         */
        var leet = new LeetCode720();
        System.out.println(leet.longestWord(words));
//        System.out.println(leet.longestWord(words1));
//        System.out.println(leet.longestWord(words2));
//        System.out.println(leet.longestWord(words3) + " expected: "  + "oiddm");
//        System.out.println(leet.longestWord(words4));

    }
    public String longestWord(String[] words) {
        Arrays.sort(words);
        Set<String> hashSet = new HashSet<>();
        String stringToReturn = "";
        int maxSize = 0;
        for(String s : words){
            int wordLength = s.length();
            if(wordLength == 1 && stringToReturn.isEmpty()){
                stringToReturn = s;
                maxSize = wordLength;
            }
            if(wordLength > maxSize && hashSet.contains(s.substring(0, wordLength - 1 ))){
                int stop = wordLength;
                while(stop != 0){
                    stop--;
                    if (!hashSet.contains(s.substring(0, stop))){
                        break;
                    }
                }
                if(stop == 0) {
                    stringToReturn = s;
                    maxSize = wordLength;
                }
            }
            hashSet.add(s);
        }
        return  stringToReturn;
    }
}
