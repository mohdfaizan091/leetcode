class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        // travers to all people of weight i 
        int left=0;
        int right=people.length-1;
        int count=0;
        while(left<=right) {
            int limits = limit;
            if(people[right] <= limits) {
                limits -= people[right];
                right--;
            }
            if(people[left] <= limits) {
                limits -= people[left];
                left++;
            }
            count++;
        }
        return count;
    }
}