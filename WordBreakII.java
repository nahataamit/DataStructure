package otherProblems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordBreakII {
    public List<String> findWords(char[][] board, String[] words) {
        Map<Character, List<String>> wordMap = new HashMap();

        Map<String,List<Character>> wordGraph = new HashMap();
        int row = board.length;
        int col = board[0].length;

        //create Word Map
        for(int i=0;i< board.length;i++){
            for(int j=0;j< board[0].length;j++){

                String p = i+"-"+j;
                if(wordMap.containsKey(board[i][j]))
                {
                    wordMap.get(board[i][j]).add(p);
                }else{
                    List<String> list = new ArrayList();
                    list.add(p);
                    wordMap.put(board[i][j],list);
                }
                wordGraph.put(p,createGraph(i,j,row, col,board));
            }
        }

        List<String> res = new ArrayList();

        for(String word : words){

            List<String> neibors = wordMap.get(word.charAt(0));
            for(String nei : neibors){
                int i = Character.getNumericValue(nei.charAt(0));
                int j = Character.getNumericValue(nei.charAt(2));

                if(dfs(i,j,1,wordMap,word,board,wordGraph)){
                    res.add(word);
                }
            }

        }

        return res;
    }

    public boolean dfs(int i, int j, int index, Map<Character, List<String>> wordMap, String word, char[][] board,
                       Map<String,List<Character>> wordGraph){

        if(index == word.length())
            return true;

        if(board[i][j] != word.charAt(index)){
            return false;
        }

        List<Character> chs = wordGraph.get(i+"-"+j);

        // List<String> chs = wordMap.get(c);

        boolean exist = false;

        for(char c : chs){

            List<String> neibors = wordMap.get(word.charAt(index));

            for(String nei : neibors){
                int x = Character.getNumericValue(nei.charAt(0));
                int y = Character.getNumericValue(nei.charAt(2));
                exist = dfs(x,y,index+1,wordMap,word,board,wordGraph);

            }
        }

        return exist;
    }

    public List<Character> createGraph(int i,int j,int row, int col,char[][] board){

        List<Character> adjList = new ArrayList();

        if(i-1>=0)
            adjList.add(board[i-1][j]);
        if(i+1< row)
            adjList.add(board[i+1][j]);
        if(j+1< col)
            adjList.add(board[i][j+1]);
        if(j-1>=0)
            adjList.add(board[i][j-1]);

        return adjList;
    }

    public static void main(String[] args){
        WordBreakII wordBreakII = new WordBreakII();
        wordBreakII.findWords(new char[][]{{'o','a','a','n'},{'e','t','a','e'},{'i','h','k','r'},{'i','f','l','v'}},
                new String[]{"eat","oath"});
    }

}
