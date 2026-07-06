class Solution {
    public int maxArea(int[] height) {
        int sum = 1;
        int i=0;
        int max = 0;
        int j = height.length-1;
        while(i<=j) {
            int dist = j-i;
            int min = Math.min(height[i], height[j]);
            int prod = dist * min;
            max = Math.max(prod, max);
            if(height[i] > height[j]) j--;
            else i++; 
        }
        return max;
    }
}