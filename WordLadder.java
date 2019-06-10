package otherProblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class WordLadder {
    public class WordNode{
        WordNode pre;
        int len;
        List<WordNode> next = new ArrayList();
        String word;
        String key;
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashMap<String,List<String>> wordGraph = new HashMap();
        HashMap<String, Boolean> visited = new HashMap();
        HashMap<String,List<WordNode>> map = new HashMap();


        for(String word: wordList){

            for(int i=0;i<word.length();i++){

                StringBuilder sb = new StringBuilder(word);
                sb.setCharAt(i,'_');
                String s = sb.toString();

                if(wordGraph.containsKey(s)){
                    wordGraph.get(s).add(word);
                }else{
                    List<String> list = new ArrayList();
                    list.add(word);
                    wordGraph.put(s,list);
                }
            }
        }

        Queue<WordNode> queue = new LinkedList<WordNode>();
        // Start Node
        WordNode node = new WordNode();
        node.len = 0;
        node.word = beginWord;

        // Create Nodes for traversal
        createNodes(beginWord,queue,node,wordGraph);


        visited.put(beginWord,true);


        while(!queue.isEmpty()){
            WordNode lWord = queue.poll();
            if(wordGraph.containsKey(lWord.key)){
                for(String ss : wordGraph.get(lWord.key)){
                    if(!visited.containsKey(ss) && !ss.equals(endWord)){
                        // create Node
                        visited.put(ss,true);
                        createNodes(ss,queue,lWord,wordGraph);
                    }
                    else if(ss.equals(endWord)){
                        WordNode end =  new WordNode();
                        end.len = lWord.len+1;
                        end.word = endWord;
                        end.pre = lWord;
                        lWord.next.add(end);
                        if(map.containsKey(endWord)){
                            map.get(endWord).add(end);
                        }else{
                            List<WordNode> endNodes =  new ArrayList();
                            endNodes.add(end);
                            map.put(endWord,endNodes);
                        }
                    }
                }
            }

        }

        int min = Integer.MAX_VALUE;

        if(map.containsKey(endWord)){
            for(WordNode n : map.get(endWord) ){
                min = Math.min(min,n.len);
            }
        }

        return min!=Integer.MAX_VALUE ?min:0;
    }

    public void createNodes(String word,Queue<WordNode> queue,WordNode pre,HashMap<String,List<String>> wordGraph){

        for(int i=0;i<word.length();i++){
            StringBuilder s = new StringBuilder(word);
            s.setCharAt(i,'_');
            if(wordGraph.containsKey(s.toString())) {
                WordNode node = new WordNode();
                node.key = s.toString();
                node.word = word;
                node.pre = pre;
                node.len = pre.len + 1;
                pre.next.add(node);
                queue.add(node);
            }
        }
    }

    public static void main(String[] args){
        WordLadder wordLadder =  new WordLadder();
        int len = wordLadder.ladderLength("hit","cog", Arrays.asList(new String []{"hot","dot","dog","lot","log","cog"}));
        System.out.println("Length :: "+ len);
    }

}
