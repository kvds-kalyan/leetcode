public class RemoveElement {
    public int removeElement(int[] nums, int val) {

        if(nums.length==0)
            return 0;
        int n = nums.length;
        int swapIndex=-1;
        for(int i=0;i<n;i++) {
            if(nums[i]==val) {
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
        return swapIndex==-1?n:swapIndex;
    }

    public void swap(int arr[],int from,int to) {
        int tmp = arr[from];
        arr[from] = arr[to];
        arr[to] = tmp;
    }
}
