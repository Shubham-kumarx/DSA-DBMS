class Solution {
    public boolean check(int[] nums) {
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
    }
}