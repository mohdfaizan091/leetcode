class Solution { 
    public class Interval implements Comparable<Interval> { 
        int start; 
        int end; 
        
        public Interval(int start, int end) { 
            this.start = start; 
            this.end = end; 
        } 
        
        @Override 
        public int compareTo(Interval other) { 
            return Integer.compare(this.start, other.start); 
        } 
    } 

    public int[][] insert(int[][] intervals, int[] newInterval) { 
        List<Interval> inter = new ArrayList<>(); 
        int row = intervals.length; 
        boolean isEncountered = false; 

        for(int i = 0; i < row; i++) { 
            int strt = intervals[i][0]; 
            int end = intervals[i][1]; 
            
            if(strt >= newInterval[0] && !isEncountered) { 
                inter.add(new Interval(newInterval[0], newInterval[1])); 
                inter.add(new Interval(strt, end)); 
                isEncountered = true; 
            } else { 
                inter.add(new Interval(strt, end)); 
            } 
        } 
        if(!isEncountered) {
            inter.add(new Interval(newInterval[0], newInterval[1]));
        }
        List<Interval> mergedList = mergeInterval(inter); 
        int[][] ans = new int[mergedList.size()][2];
        for (int i = 0; i < mergedList.size(); i++) {
            ans[i][0] = mergedList.get(i).start;
            ans[i][1] = mergedList.get(i).end;
        }
        return ans; 
    } 

    public List<Interval> mergeInterval(List<Interval> inter) { 
        List<Interval> inter2 = new ArrayList<>(); 
        if (inter.isEmpty()) return inter2;

        Interval current = inter.get(0);
        
        for (int i = 1; i < inter.size(); i++) {
            Interval next = inter.get(i);
            if (current.end >= next.start) { 
                current.end = Math.max(current.end, next.end); 
            } else { 
                inter2.add(current);
                current = next;
            } 
        }
        inter2.add(current);
        
        return inter2;
    } 
}
