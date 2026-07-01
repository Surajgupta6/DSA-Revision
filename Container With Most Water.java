class Solution {
    public int maxArea(int[] height) {
        int length=height.length;
        int left=0;
        int right=length-1;
        int result=Integer.MIN_VALUE;
        while(left<=right){
            result=Math.max(result,(Math.min(height[left],height[right])*(right-left)));
            if(height[left]<height[right]) left++;
            else right--;
        }
        return result;
    }
}
