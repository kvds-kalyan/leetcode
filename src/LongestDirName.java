import java.util.ArrayList;
import java.util.List;

public class LongestDirName {

    public static String longestName(String dir) {
        return helper(dir,1);
    }

    public static  String helper(String currdir,int level) {
        if(!currdir.contains("\n\t")) {
            return currdir;
        }

        String maxSizeString = "";

        List<String> subTrees = splitMyWay(currdir,level);
        String init = subTrees.remove(0);
        for(String curr : subTrees) {
            String childMax = helper(curr,level+1);
            if(maxSizeString.length() < childMax.concat(init).length()) {
                maxSizeString = init.concat("/").concat(childMax);
            }
        }

        return maxSizeString;
    }

    public static List<String> splitMyWay(String dir,int level) {
        String delim = "\n";
        for(int i=0;i<level;i++) {
            delim = delim.concat("\t");
        }
        String[] arr = dir.split(delim);
        List<String> res = new ArrayList<>();
        for(int i=0;i<arr.length;i++) {
            if(arr[i].charAt(0)=='\t') {
                res.add(i-1,res.get(i-1).concat(delim).concat(arr[i]));
            } else {
                res.add(arr[i]);
            }
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(longestName("dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext"));

    }


}
