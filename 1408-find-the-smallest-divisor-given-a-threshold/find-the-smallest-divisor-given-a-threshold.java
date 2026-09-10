class Solution {
    private boolean possible(int[] nums, int divisor, int threshold){
        int cnt = 0;
        for(int i = 0; i < nums.length; i++){
            cnt += Math.ceil((double)nums[i] / (double) divisor);
        }
        return cnt <= threshold;
    }
    public int smallestDivisor(int[] nums, int threshold) {
        int low = 1;
        int high = Integer.MIN_VALUE;
        for(int num : nums){
            high = Math.max(high, num);
        }
        while(low <= high) {
            int mid = low + (high - low) / 2;
            if(possible(nums, mid, threshold)) high  = mid - 1;
            else low = mid + 1;
        }
        return low;
    }
}