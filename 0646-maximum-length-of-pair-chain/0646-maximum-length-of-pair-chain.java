class Solution {
    class intervals {
        int startInt;
        int endInt;
        intervals(int startInt , int endInt) {
            this.startInt = startInt;
            this.endInt = endInt;
        }
    }
    public int findLongestChain(int[][] pairs) {
        int n = pairs.length;
        if (n == 0) return 0;

        intervals[] result = new intervals[n];

        for(int i=0 ; i<n ; i++) {
            result[i] = new intervals(pairs[i][0] , pairs[i][1]);
        }

        Arrays.sort(result , (a1 , a2) -> Integer.compare(a1.endInt , a2.endInt));

        int count = 1;
        int i=0;
        for(int j=1 ; j<n ; j++) {
            if(result[j].startInt > result[i].endInt) {
                count++;
                i=j;
            }
        }
        return count;
    }
}