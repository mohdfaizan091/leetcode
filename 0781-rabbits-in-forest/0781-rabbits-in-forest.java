class Solution {
    public int numRabbits(int[] answers) {
        // return noOfRabbitUsingSimpleApproach(answers)
        return noOfRabbitUsingHashMap(answers);
    }

    public int noOfRabbitUsingSimpleApproach(int[] answers) {
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


    public int noOfRabbitUsingHashMap(int[] answers) {
        HashMap<Integer, Integer> maps = new HashMap<>();

        for (int i = 0; i < answers.length; i++) {
            int groupSize = answers[i] + 1;

            if (maps.containsKey(groupSize)) {
                int freq = maps.get(groupSize);
                maps.put(groupSize, freq + 1);
            } else {
                maps.put(groupSize, 1);
            }
        }

        int ans = 0;

        for (int groupSize : maps.keySet()) {

            int freq = maps.get(groupSize);
            int groups = freq / groupSize;
            if (freq % groupSize != 0) {
                groups++;
            }
            ans += groups * groupSize;
        }
        
        return ans;
    }
}