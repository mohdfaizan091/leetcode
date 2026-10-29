class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> ans = new ArrayList<>();
        int n = candies.length;
        int[] extra = new int[n];

        for(int i=0 ; i<n ; i++) {
            extra[i] = candies[i] + extraCandies;
        }

        for(int ele1 : extra) {
            boolean isGreatest = true;
            for(int ele2 : candies) {
                if(ele1 < ele2) {
                    isGreatest = false;
                }
            }
            if(isGreatest) {
                ans.add(true);
            } else {
                ans.add(false);
            }
        }

        return ans;
    }
}