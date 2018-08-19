public class NumberOfSubArraysWithBoundedMaximum {
    public static int numSubarrayBoundedMax(int[] A, int L, int R) {

        int total = 0;
        int n = A.length;

        int peopleBeforeMeNeedingHelp = 0,peopleBeforeMeWhoCanSaveThemselves=0;

        for(int i=0;i<n;i++) {
            if(A[i]>=L && A[i]<=R) {
                //i can save anyone needing help or who are already safe
                total+=1;//myself
                total+=peopleBeforeMeNeedingHelp;
                total+=peopleBeforeMeWhoCanSaveThemselves;
                peopleBeforeMeWhoCanSaveThemselves+=1;

            } else if(A[i]<L) {
                //i can be saved by people before me who can save themselves
                total+=peopleBeforeMeWhoCanSaveThemselves;
                peopleBeforeMeNeedingHelp+=1;
            } else {
                //reset everything for the devil is here
                peopleBeforeMeNeedingHelp=0;
                peopleBeforeMeWhoCanSaveThemselves=0;
            }
        }

        return total;

    }

    public static int numSubarrayBoundedMaxCorrect(int[] A, int L, int R) {
        int j=0,count=0,res=0;

        for(int i=0;i<A.length;i++){
            if(A[i]>=L && A[i]<=R){
                res+=i-j+1;count=i-j+1;
            }
            else if(A[i]<L){
                res+=count;
            }
            else{
                j=i+1;
                count=0;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int A[] = {73,55,36,5,55,14,9,7,72,52};
        System.out.println(numSubarrayBoundedMaxCorrect(A,32,69));
    }
}
