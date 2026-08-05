class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int maxi = 0;
        int ones_count = 0;
        for(int num : nums){
            if(num == 1) {
                ones_count++;
                maxi = Math.max(maxi,ones_count);
            }
            else {
                ones_count = 0;
            }
        }
       return maxi; 
    }
}