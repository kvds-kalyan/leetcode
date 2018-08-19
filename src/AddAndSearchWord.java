import sun.text.normalizer.Trie;

import java.util.Arrays;

public class AddAndSearchWord {
    public static void main(String[] args) {
        WordDictionary obj = new WordDictionary();
        obj.addWord("baddy");
        obj.addWord("mad");
        obj.addWord("dad");
        boolean param_1 = obj.search("bad..");
        boolean param_2 = obj.search(".ad");

        System.out.println(param_1);

    }
}

class TrieNode {
    TrieNode[] children = new TrieNode[26];
    String item = "";
}

class WordDictionary {

    TrieNode root;


    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        char[] wordArr = word.toCharArray();
        TrieNode curr = root;

        for (int i = 0; i < wordArr.length; i++) {
            int idx = wordArr[i] - 'a';
            TrieNode targetNode = curr.children[idx];
            if (curr.children[idx] == null)
                curr.children[idx] = new TrieNode();
            curr = curr.children[idx];
        }

        curr.item = word;
    }


    public boolean search(String word) {
        return search(word, root, 0);
    }

    public boolean search(String word, TrieNode level, int index) {
        if (level == null)
            return false;

        int n = word.length();
        if(index==n) {
            return level.item==word;
        }

        char currChar = word.charAt(index);

        if (currChar == '.') {
            return wildCardMatch(word,level,index);
        } else {
            int idx = currChar - 'a';
            TrieNode childNode = level.children[idx];
            return search(word, childNode, index + 1);
        }
    }

    public boolean wildCardMatch(String word, TrieNode currLevel, int index) {
        for (int j = 0; j < 26; j++) {
            TrieNode currNode = currLevel.children[j];
            char wildCardChar = (char) ('a' + j);
            String wordToSearch = word.substring(0,index)+wildCardChar+word.substring(index+1);
            boolean currAns = search(wordToSearch, currLevel,index);
            if (currAns)
                return true;
        }
        return false;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
