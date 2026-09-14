class Solution {
    private int countSubArr(int[] nums, int subArrSum){
        int cnt = 1, sum = 0;
        for(int num : nums){
            if(sum + num <= subArrSum) sum += num;
            else {
                cnt++;
                sum = num;
            }
        }
        return cnt;
    }
    public int splitArray(int[] nums, int k) {
        int low = Integer.MIN_VALUE;
        int high = 0;
        for(int num : nums){
            low = Math.max(low, num);
            high += num; 
        }
        while(low <= high){
            int mid = low + (high - low) / 2;
            if(countSubArr(nums, mid) > k) low = mid + 1;
            else high = mid - 1;
        }
        return low;
    }
}