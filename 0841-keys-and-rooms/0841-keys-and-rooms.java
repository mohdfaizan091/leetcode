class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> list) {
        int n = list.size();
        boolean[] isVisited = new boolean[n];
        isVisited[0] = true;
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        while (q.size() > 0) {
            int temp = q.remove();
            List<Integer> li = list.get(temp);
            for(int i=0 ; i<li.size() ; i++) {
                int roomKey = li.get(i);
                if(!isVisited[roomKey]) {
                    isVisited[roomKey] = true;
                    q.add(roomKey);
                }
            }
        }
        for(int i=0 ; i<isVisited.length ; i++) {
            if(isVisited[i] == false) return false;
        }
        return true;
    }
}