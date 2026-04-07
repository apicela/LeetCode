import java.util.ArrayList;
import java.util.List;

class Solution {

    public static void main(String[] args) {
        Solution sol = new Solution();
        List<String> entry = new ArrayList<>(List.of("Hello", "World"));
        String decoded = sol.encode(entry);
        System.out.println(decoded);
        sol.decode(decoded);
    }

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(String s : strs){
            sb.append(s.length()).append("#").append(s);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> retorno = new ArrayList<String>();
        char[] caracteres = str.toCharArray();
        int endWord = 0;
        for(int i = endWord; i<str.length();i++){
            if(caracteres[i] != '#') continue;

            StringBuilder sb = new StringBuilder();
            for(int idx = endWord; idx < i;idx++){
                sb.append(caracteres[idx]);
            }
            int palavraSize = Integer.parseInt(sb.toString());
            int startIdx = i+1;
            endWord = startIdx+palavraSize;
            String word = str.substring(startIdx, endWord);
            i=endWord;
            retorno.add(word);
        }
        return retorno;
    }
}
