class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        boolean[] isvis = new boolean[n];
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        while(q.size() > 0) {
            int top = q.remove();
            isvis[top] = true;
            for(int ele : rooms.get(top)) {
                if(!isvis[ele]) {
                    q.add(ele);
                }
            }
        }
        for(int i=0 ; i<n ; i++) {
            if(!isvis[i]) return false;
        }
        return true;
    }
}