class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        ArrayList<int[]> ans = new ArrayList<>();
        for(int[] curr : intervals){
            if(ans.isEmpty() || ans.get(ans.size() - 1)[1] < curr[0]){
                ans.add(curr);
            } else {
                ans.get(ans.size() - 1)[1] = Math.max(ans.get(ans.size() - 1)[1], curr[1]);
            }
        }
        return ans.toArray(new int[ans.size()][]);
    }
}