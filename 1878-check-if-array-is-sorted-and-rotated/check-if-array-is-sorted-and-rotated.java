class Solution {
    public boolean check(int[] nums) {
        int n = nums.length;
        int count = 0;
        for(int i = 0; i < n; i++){
            if(nums[i] > nums[(i + 1) % n]) count++;
        }
        return count <= 1;
        
        /* ---------------------BRUTE FORCE------------------------
        int n = nums.length;
        for(int r = 0; r < n; r++){
            boolean sorted = true;
            for(int i = 0; i < n - 1; i++){
                int x = nums[(i + r) % n];
                int y = nums[(i + r + 1) % n];
                if(x > y){
                    sorted = false;
                    break;
                }
                
            }
            if (sorted) return true;
        }
        return false;
        */
    }
}