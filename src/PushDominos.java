public class PushDominos {

    public static String pushDominoes(String dominoes) {
        if (dominoes.length() <= 1)
            return dominoes;

        char[] dominos_arr = dominoes.toCharArray();
        char[] ans = new char[dominoes.length()];

        int closest_left[] = new int[dominoes.length()];
        int closest_right[] = new int[dominoes.length()];

        closest_right[0] = dominos_arr[0]=='R'?0:Integer.MAX_VALUE;

        for (int i = 1; i < dominos_arr.length; i++) {
            if (dominos_arr[i] == 'R')
                closest_right[i] = 0;
            else if (dominos_arr[i] != 'L' && closest_right[i - 1] != Integer.MAX_VALUE)
                closest_right[i] = closest_right[i - 1] + 1;
            else {
                closest_right[i] = Integer.MAX_VALUE;
            }
        }

        closest_left[dominos_arr.length - 1] = dominos_arr[dominos_arr.length-1]=='L'?0:Integer.MAX_VALUE;

        for (int i = dominos_arr.length - 2; i >= 0; i--) {
            if (dominos_arr[i] == 'L')
                closest_left[i] = 0;
            else if (dominos_arr[i] != 'R' && closest_left[i + 1] != Integer.MAX_VALUE)
                closest_left[i] = closest_left[i + 1] + 1;
            else {
                closest_left[i] = Integer.MAX_VALUE;
            }
        }

        for (int i = 0; i < dominoes.length(); i++) {

            if (dominos_arr[i] == 'L' || closest_left[i] < closest_right[i])
                ans[i] = 'L';
            else if (dominos_arr[i] == 'R' || closest_right[i] < closest_left[i])
                ans[i] = 'R';
            else
                ans[i] = '.';
        }
        return new String(ans);
    }

    public static void main(String[] args) {
        System.out.println(pushDominoes("RR.L"));
    }
}

/*
class Solution(object):
    def pushDominoes(self, dominoes):
        """
        :type dominoes: str
        :rtype: str
        """
        while(True):
            new = dominoes.replace('R.L', 'S')
            new = new.replace('.L','LL').replace('R.','RR')
            if new == dominoes:
                break
            else:
                dominoes = new
        return dominoes.replace('S', 'R.L')
 */
