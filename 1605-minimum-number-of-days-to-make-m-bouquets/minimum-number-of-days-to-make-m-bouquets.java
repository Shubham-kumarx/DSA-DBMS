class Solution {
    private boolean possible(int[] nums, int day, int m, int k){
        int cnt = 0, numOfB = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] <= day) cnt++;
            else {
                numOfB += (cnt / k);
                cnt = 0;
            }
        }
        numOfB += (cnt / k);
        return numOfB >= m;
    }
    public int minDays(int[] bloomDay, int m, int k) {
        long val = (long) m * k;
        int n = bloomDay.length;
        if(val > n) return -1;
        int mini = Integer.MAX_VALUE, maxi = Integer.MIN_VALUE;
        for(int day : bloomDay){
            mini = Math.min(mini, day);
            maxi = Math.max(maxi, day);
        }
        // for(int i = mini; i <= maxi; i++){
        //     if(possible(bloomDay, i, m, k)) return i;
        // }
        // return -1;
        int low = mini;
        int high = maxi;
        while(low <= high){
            int mid = low + (high - low) / 2;
            if(possible(bloomDay, mid, m, k)) high = mid - 1;
            else low = mid + 1;
        }
        return low;
    }
}