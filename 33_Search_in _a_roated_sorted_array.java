class Solution {
    public int search(int[] nums, int target) {
        int pivot=pivot(nums);
        if(pivot==-1) return binary_search(nums,target,0,nums.length-1);
        if(nums[pivot]==target){
            return pivot;
        }
        if(nums[0]<=target){
            return binary_search(nums,target,0,pivot-1);
        }
        return binary_search(nums,target,pivot+1,nums.length-1);
    }

    private int pivot(int[] nums){
        int n=nums.length;
        int left=0;
        int right=n-1;
        while(left<=right){
            int mid=left+(right-left)/2;
            if(mid < right && nums[mid] > nums[mid+1]) return mid;
            if(mid > left && nums[mid] < nums[mid-1]) return mid-1;
            else if(nums[mid] >= nums[left]) left=mid+1;
            else right=mid-1;
        }
        return -1;
    }
    public int binary_search(int[] nums, int target,int start,int end) {
        int n=nums.length;
        int left=start,right=end;
        while(left<=right){
            int mid=left+(right-left)/2;
            if(nums[mid]==target) return mid;
            else if(nums[mid]>target) right=mid-1;
            else left=mid+1;
        }
        return -1;
    }
}
