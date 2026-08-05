class Solution {
    public int numRabbits(int[] answers) {
        int count=0;
        int samecolor = 0;
        Arrays.sort(answers);
        for(int i=0 ; i<answers.length ; i++) {
            // first should be count
            if(i==0) {
                count += answers[i] + 1;
                // to track how many have same color
                samecolor = answers[i];
            }
            // if rat say '0' then he is unique and should be count
            else if(answers[i] == 0){
                count++;
            } 
            else {
                // if same color meet again then dont count;
                if(answers[i-1] == answers[i] && samecolor != 0) {
                    samecolor--;
                } else {
                    // saw different color of rat and count it
                    count += answers[i] + 1;
                    // make track of that color
                    samecolor = answers[i];
                }
            }
        }
        return count;
    }
}