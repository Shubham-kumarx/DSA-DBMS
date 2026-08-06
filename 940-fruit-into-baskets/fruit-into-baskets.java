class Solution {
    public int totalFruit(int[] fruits) {
        /* sliding window + hashMap approach

        HashMap<Integer, Integer> map = new HashMap<>();
    
        int left = 0, right = 0, count = 0;

        while(right < fruits.length){
            map.put(fruits[right], map.getOrDefault(fruits[right], 0) + 1);
            if(map.size() > 2){
                map.put(fruits[left], map.get(fruits[left]) - 1);
                if(map.get(fruits[left]) == 0) map.remove(fruits[left]);
                left++;
            }
            count = Math.max(count, right - left + 1);
            right++;
        }
        return count;

        */

        // sliding window + without hashMap

        int lastFruit = -1, secondLastFruit = -1;
        int lastFruitCount = 0, currMax = 0, ans = 0;
        for(int fruit : fruits){
            if(fruit == lastFruit || fruit == secondLastFruit) currMax++;
            else currMax = lastFruitCount + 1;
            if(fruit == lastFruit) lastFruitCount++;
            else {
                lastFruitCount = 1;
                secondLastFruit = lastFruit;
                lastFruit = fruit;
            }
            ans = Math.max(ans, currMax);
        }
        return ans;
    }
}