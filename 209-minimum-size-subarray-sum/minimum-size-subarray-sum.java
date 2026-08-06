class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int right = 0, left = 0, sum = 0, ans = Integer.MAX_VALUE;
        while(right < nums.length){
            sum += nums[right];
            while(sum >= target){
                ans = Math.min(ans, right - left + 1);
                sum -= nums[left];
                left++;
            }
            
            right++;
        }
        return (ans == Integer.MAX_VALUE) ? 0 : ans;
    }
}