package leetcode.premium;

import java.util.*;

public class GeneticMutation {
    /*

    public int minMutation(String start, String end, String[] bank) {

        if(start==end) {
            return 0;
        }

        if(start.length()!=end.length()) {
            return -1;
        }

        Set<String> set = new HashSet<>(Arrays.asList(bank));

        int n = start.length();
        List<Integer> lst = new ArrayList<>();

        char[] startArr = start.toCharArray();
        char[] endArr = end.toCharArray();

        for(int i=0;i<n;i++) {
            if(startArr[i]!=endArr[i]) {
                lst.add(i);
            }
        }

        int min = Integer.MAX_VALUE;

        for(int i : lst) {
            //what will be min if we want to make change here
            startArr[i] = endArr[i];
            String s = new String(startArr);
            if(set.contains(s)) {
                min = Math.min(min,minMutation(s,end,bank)+1);
            } else {
                //find the min one on left
                String minLeft = s.substring(0,i);

                //find the min one on right
            }
        }

    }


}

/*
BFS.Beautifully done!!

public int minMutation(String start, String end, String[] bank) {
        if(start.equals(end)) return 0;

        Set<String> bankSet = new HashSet<>();
        for(String b: bank) bankSet.add(b);

        char[] charSet = new char[]{'A', 'C', 'G', 'T'};

        int level = 0;
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.offer(start);
        visited.add(start);

        while(!queue.isEmpty()) {
            int size = queue.size();
            while(size-- > 0) {
                String curr = queue.poll();
                if(curr.equals(end)) return level;

                char[] currArray = curr.toCharArray();
                for(int i = 0; i < currArray.length; i++) {
                    char old = currArray[i];
                    for(char c: charSet) {
                        currArray[i] = c;
                        String next = new String(currArray);
                        if(!visited.contains(next) && bankSet.contains(next)) {
                            visited.add(next);
                            queue.offer(next);
                        }
                    }
                    currArray[i] = old;
                }
            }
            level++;
        }
        return -1;
    }
 */
}
