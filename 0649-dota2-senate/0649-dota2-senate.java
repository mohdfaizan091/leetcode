class Solution {
    public String predictPartyVictory(String senate) {
        Deque<Integer> Radiant = new ArrayDeque<>();
        Deque<Integer> Dire = new ArrayDeque<>();
        
        for(int i=0 ; i<senate.length() ; i++) {
            char ch = senate.charAt(i);
            if(ch == 'R') {
                Radiant.add(i);
            } else {
                Dire.add(i);
            }
        }

        while(!Radiant.isEmpty() && !Dire.isEmpty()) {
            int ri = Radiant.poll();
            int di = Dire.poll();

            if(ri < di) {
                Radiant.add(ri + senate.length());
            } else {
                Dire.add(di + senate.length());
            }
        }
        return Radiant.isEmpty() ? "Dire" : "Radiant";
    }
}