class Solution {
    public int maxArea(int[] height) {
        int n = height.length , maxArea = 0, left = 0, right = n - 1;
        while(left < right){
            int width = right - left;
            int h = Math.min(height[left], height[right]);
            maxArea = Math.max(maxArea, width * h);
            if(height[left] > height[right]) right--;
            else left++;
        }
        return maxArea;
    }
}