class Solution {
    public int longestOnes(int[] nums, int k) {
        int left  = 0, ans = 0, zero = 0;
        for(int right = 0; right < nums.length; right++){
            if(nums[right] == 0) zero++;
            while(zero > k){
                if(nums[left] == 0) zero--;
                left++;
            }
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
        /* --- Brute Force ---
        int ans = 0; 
        for(int i = 0; i < nums.length; i++){
            int zero = 0;
            for(int j = i; j < nums.length; j++){
                if(nums[j] == 0 ) zero++;
                if(zero > k) break;
                ans = Math.max(ans, j - i + 1);
            }
        }
      return ans;  
      */
    }
}