class Solution {
    private boolean canShip(int[] weights, int days, int capacity){
        int reqDays = 1, currLoad = 0;
        for(int w : weights){
            if(currLoad + w > capacity){
                reqDays++;
                currLoad = w;
            } else {
                currLoad += w;
            }
        }
        return reqDays <= days;
    }
    public int shipWithinDays(int[] weights, int days) {
        int low = Integer.MIN_VALUE;
        int high = 0;
        for(int w : weights){
            low = Math.max(low, w);
            high += w; 
        }

        while(low <= high){
            int mid = low + (high - low) / 2;
            if(canShip(weights, days, mid)) high = mid - 1;
            else low = mid + 1;
        }
        return low;
    }
}