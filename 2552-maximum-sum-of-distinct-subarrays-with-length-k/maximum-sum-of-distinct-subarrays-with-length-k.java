class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        long sum = 0, ans = 0;
        int left = 0;
        for(int right = 0; right < nums.length; right++){
            sum += nums[right];
            map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);
            if(right - left + 1 > k){
                sum -= nums[left];
                map.put(nums[left], map.get(nums[left]) - 1);
                if(map.get(nums[left]) == 0) map.remove(nums[left]);
                left++;
            }
            if(right - left + 1 == k && map.size() == k) ans = Math.max(ans, sum);
        }
        return ans;
        /* ---- BRUTE FORCE ----------------------
        
        long max_sum = 0;
        for(int i = 0; i <= nums.length - k; i++){
            HashSet<Integer> set = new HashSet<>();
            int sum = 0;
            for(int j = i; j < i + k; j++){
                set.add(nums[j]);
                sum += nums[j];
            }
            if(set.size() == k) max_sum = Math.max(max_sum, sum);
        }
        return max_sum;
        */
    }
}