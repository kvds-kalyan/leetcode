public class MoveZeros {

    public void moveZeroes(int[] nums) {

        int n = nums.length;
        int swapIndex=-1;
        for(int i=0;i<n;i++) {
            if(nums[i]==0) {
                if(swapIndex==-1) {
                    swapIndex = i;
                }
            } else {
                if(swapIndex!=-1) {
                    swap(nums,i,swapIndex);
                    swapIndex++;
                }
            }
        }

    }

    public void swap(int arr[],int from,int to) {
        int tmp = arr[from];
        arr[from] = arr[to];
        arr[to] = tmp;
    }
}
