import java.util.*;

public class AlienDictionary {
    String getOrder(List<String> orderedDict) {
        Map<Character,Set<Character>> incoming = new HashMap<>();
        Map<Character,Set<Character>> outgoing = new HashMap<>();

        for(int i=0;i<orderedDict.size()-1;i++) {

            String one = orderedDict.get(i);
            String two = orderedDict.get(i+1);

            int j;
            for(j=0;j<one.length()&&j<two.length()&&one.charAt(j)==two.charAt(j);j++);

            if(j<one.length()&&j<two.length()) {
                Set<Character> outgoing_set_2 = outgoing.get(two.charAt(j));

                if(outgoing_set_2!=null && outgoing_set_2.contains(one.charAt(j))) {
                    return "INVALID";
                }

                Set<Character> incoming_set = incoming.get(two.charAt(j));
                Set<Character> outgoing_set_1 = outgoing.get(one.charAt(j));

                if(incoming_set==null) {
                    incoming_set = new HashSet<>();
                }
                incoming_set.add(one.charAt(j));

                if(outgoing_set_1==null) {
                    outgoing_set_1 = new HashSet<>();
                }
                outgoing_set_1.add(two.charAt(j));
            }
        }

        return "A";

    }
/*
    String topologicalSort(Map<Character,Set<Character>> incoming,Map<Character,Set<Character>> outgoing) {

    }
    */
}
