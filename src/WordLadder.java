import java.util.*;

public class WordLadder {

    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Map<String, Integer> dict = new HashMap<>();
        wordList.forEach(word -> dict.put(word, 1));
        return Math.min(minToTransform(beginWord, endWord, dict,0,new HashSet<>()),0);

    }

    public static int minToTransform(String word, String endWord, Map<String, Integer> dict,int index,Set<String> visited) {
        if(index>=word.length())
            return Integer.MAX_VALUE;

        if(word.equals(endWord))
            return 0;

        char charArray[] = word.toCharArray();
        int min = Integer.MAX_VALUE;

        //transform curr index
        for(char c='a';c<='z';c++) {
            charArray[index] = c;
            String tempWord = new String(charArray);
            if(tempWord.equals(endWord)) {
                return 1;
            } else if(dict.containsKey(tempWord) && !visited.contains(tempWord)) {
                visited.add(tempWord);
                int nextMin = minToTransform(tempWord,endWord,dict,0,visited);
                min = nextMin==Integer.MAX_VALUE?min:Math.min(min,nextMin)+1;
            }
        }

        //don't transform currenct
        int nextMin = minToTransform(word,endWord,dict,index+1,visited);

        //if it is not possible to transform,return Math.min
        return Math.min(min,nextMin);
    }

    public static void main(String[] args) {
        List<String> wordList = new ArrayList<>();
        wordList.add("hot");
        wordList.add("dot");
        wordList.add("dog");
        wordList.add("lot");
        wordList.add("log");
        wordList.add("cog");

        System.out.println(ladderLength("hit","cog",wordList));
    }

    /*
    public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
    wordList.add(endWord);
    Queue<String> queue = new LinkedList<String>();
    queue.add(beginWord);
    int level = 0;
    while(!queue.isEmpty()){
        int size = queue.size();
        for(int i = 0; i < size; i++){
            String cur = queue.remove();
            if(cur.equals(endWord)){ return level + 1;}
            for(int j = 0; j < cur.length(); j++){
                char[] word = cur.toCharArray();
                for(char ch = 'a'; ch < 'z'; ch++){
                    word[j] = ch;
                    String check = new String(word);
                    if(!check.equals(cur) && wordList.contains(check)){
                        queue.add(check);
                        wordList.remove(check);
                    }
                }
            }
        }
        level++;
    }
    return 0;
}
     */
}
