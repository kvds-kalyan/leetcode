import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InsertDeleteGetRandomO1DuplicatesAllowed {
    class RandomizedCollection {

        Map<Integer,List<Integer>> valToIndices;
        List<Integer> values;

        /** Initialize your data structure here. */
        public RandomizedCollection() {
            valToIndices = new HashMap<>();
            values = new ArrayList<>();
        }

        /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
        public boolean insert(int val) {
            boolean ans = !valToIndices.containsKey(val);
            int nextIdx = values.size();

            List<Integer> indices = valToIndices.getOrDefault(val,new ArrayList<>());
            indices.add(nextIdx);
            valToIndices.put(val,indices);

            values.add(val);
            return ans;

        }

        /** Removes a value from the collection. Returns true if the collection contained the specified element. */
        public boolean remove(int val) {
            boolean ans = valToIndices.containsKey(val);
            if(!ans) return ans;

            List<Integer> indices = valToIndices.get(val);
            int lastIdxOfVal = values.get(indices.size()-1);
            int lastIdxOfAllVals = values.size()-1;

            if(lastIdxOfVal!=lastIdxOfAllVals) {

            }

            values.remove(lastIdxOfAllVals);
            indices.remove(indices.size()-1);




        }

        /** Get a random element from the collection. */
        public int getRandom() {

        }
    }

}
