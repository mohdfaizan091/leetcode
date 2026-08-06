class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int lighterPeople = 0;
        int heavierPeople = people.length-1;
        int noOfBoats = 0;
        while(lighterPeople <= heavierPeople) {
            if(people[lighterPeople] + people[heavierPeople] <= limit) {
                noOfBoats++;
                lighterPeople++;
                heavierPeople--;
            }
            else {
                noOfBoats++;
                heavierPeople--;
            }
        }
        return noOfBoats;
    }
}