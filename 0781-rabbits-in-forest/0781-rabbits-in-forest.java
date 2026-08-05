class Solution {
    public int numRabbits(int[] answers) {
        int count=0;
        int samecolor = 0;
        Arrays.sort(answers);
        for(int i=0 ; i<answers.length ; i++) {
            if(i==0) {
                count += answers[i] + 1;
                samecolor = answers[i];
            }
            else if(answers[i] == 0){
                count++;
            } 
            else {
                if(answers[i-1] == answers[i] && samecolor != 0) {
                    samecolor--;
                } else {
                    count += answers[i] + 1;
                    samecolor = answers[i];
                }
            }
        }
        return count;
    }
}