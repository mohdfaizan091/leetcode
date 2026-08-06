class Solution { 

    // same as fractional knapsack -- same intiution

    class items {

        int no_of_box;
        int per_unit_of_that_box;

        // constructor
        items(int no_of_box , int per_unit_of_that_box) {
            this.no_of_box = no_of_box;
            this.per_unit_of_that_box = per_unit_of_that_box;
        }
    }
    
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        int n = boxTypes.length;
        items[] item = new items[n];

        for(int i=0 ; i<n ; i++) {
            item[i] = new items(boxTypes[i][0] , boxTypes[i][1]);
        }

        Arrays.sort(item , (a1 , a2) -> Integer.compare(a2.per_unit_of_that_box , a1.per_unit_of_that_box));

        int remainingTruckSize = truckSize;
        int max = 0;

        for(items i1 : item) {
            if(remainingTruckSize >= i1.no_of_box) {
                remainingTruckSize -= i1.no_of_box;
                max += i1.no_of_box * i1.per_unit_of_that_box;
            } else {

                max += remainingTruckSize * i1.per_unit_of_that_box;
                break;
            }
        }

        return max;
    }
}