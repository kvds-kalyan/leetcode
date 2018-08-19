public class MedianOfSortedArrays {
    /*

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

    }

    public double findKthHighestElement(int[] nums1,int[] nums2,int k) {
        return helper(nums1,nums2,0,0,k);
    }

    public double helper(int[] nums1,int[] nums2,int i,int j,int k) {
        if(k==0) {
            if(nums1.length==0) {
                return nums2.length!=0?nums2[0]:-1;
            } else if(nums2.length==0) {
                return nums1.length!=0?nums1[0]:-1;
            } else {
                return nums1[0]<nums2[0]?nums1[0]:nums2[0];
            }
        }

        if(nums1.length==0) {
            return nums2.length<k?-1:nums2[k-1];
        } else if(nums2.length==0) {
            return nums1.length<k?-1:nums1[k-1];
        }

        int k_mid1 = i+k/2 < nums1.length? i+k/2:0;
        int k_mid2 = j+k/2 < nums2.length? j+k/2:0;

        if(nums1[k_mid1] >= nums2[k_mid2]) {
            return helper(nums1,nums2,k_mid1,k_mid2,k-k/2);
        } else {
            return helper(nums1,nums1,)
        }


    }

    /*
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    int total = nums1.length+nums2.length;
    if(total%2==0){
        return (findKth(total/2+1, nums1, nums2, 0, 0)+findKth(total/2, nums1, nums2, 0, 0))/2.0;
    }else{
        return findKth(total/2+1, nums1, nums2, 0, 0);
    }
}

public int findKth(int k, int[] nums1, int[] nums2, int s1, int s2){
    if(s1>=nums1.length)
        return nums2[s2+k-1];

    if(s2>=nums2.length)
        return nums1[s1+k-1];

    if(k==1)
        return Math.min(nums1[s1], nums2[s2]);

    int m1 = s1+k/2-1;
    int m2 = s2+k/2-1;

    int mid1 = m1<nums1.length?nums1[m1]:Integer.MAX_VALUE;
    int mid2 = m2<nums2.length?nums2[m2]:Integer.MAX_VALUE;

    if(mid1<mid2){
        return findKth(k-k/2, nums1, nums2, m1+1, s2);
    }else{
        return findKth(k-k/2, nums1, nums2, s1, m2+1);
    }
}
     */

}
