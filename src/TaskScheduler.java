import java.util.*;

public class TaskScheduler {

    public static int leastInterval(char[] tasks, int n) {

        LinkedList<Character> blocked = new LinkedList<>();
        LinkedList<Character> ready = new LinkedList<>();

        Map<Character,Integer> map = new HashMap<>();
        Set<Character> set = new HashSet<>();

        for(int i=0;i<tasks.length;i++) {
            int count = map.getOrDefault(tasks[i],0);
            map.put(tasks[i],count+1);
        }

        for(Character ch : map.keySet()) {
            ready.addFirst(ch);
        }

        int counter=0;

       while(!blocked.isEmpty() && !set.isEmpty()||!ready.isEmpty()) {
            if(!ready.isEmpty()) {
                //schedule the last
                Character ch = ready.removeLast();

                int curr = map.get(ch);
                System.out.print(ch+"\t");
                counter++;

                if(curr>1) {
                    blocked.addFirst(ch);
                    map.put(ch, curr - 1);
                    set.add(ch);
                } else {
                    blocked.addFirst('#');
                }


                if(blocked.size()>n) {
                    Character unblockedch = blocked.removeLast();
                    set.remove(unblockedch);

                    if(unblockedch!='#' && map.get(unblockedch)>0) {
                        ready.addFirst(unblockedch);
                    }
                }


            } else {
                blocked.addFirst('#');
                System.out.print('#'+"\t");
                counter++;

                if(blocked.size()>n) {
                    Character unblockedch = blocked.removeLast();
                    set.remove(unblockedch);

                    if(unblockedch!='#' && map.get(unblockedch)>0) {
                        ready.addFirst(unblockedch);
                    }
                }
            }
       }

       return counter;

    }

    public static void main(String[] args) {
        char arr[] = {'A','A','A','B','B','B'};
        System.out.println(leastInterval(arr,2));
    }
}


/*
public int leastInterval(char[] tasks, int n) {
        int[] count = new int[26];
        for (char task : tasks) {
            count[task - 'A']++;
        }

        Queue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());
        for (int i : count) {
            if (i > 0) {
                heap.offer(i);
            }
        }

        int intervals = 0;
        while (!heap.isEmpty()) {
            int i = 0;
            List<Integer> next = new ArrayList<>();

            while (i <= n) {
                if (!heap.isEmpty()) {
                    if (heap.peek() > 1) {
                        next.add(heap.poll() - 1);
                    } else {
                        heap.poll();
                    }
                }
                i++;
                intervals++;
                if (heap.isEmpty() && next.size() == 0) {
                    break;
                }
            }

            for (int task : next) {
                heap.offer(task);
            }
        }
        return intervals;
    }
 */