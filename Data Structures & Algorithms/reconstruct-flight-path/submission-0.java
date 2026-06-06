class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        if (tickets == null) {
            return new ArrayList<>();
        }

        Map<String,List<String>> hashMap = new HashMap<>();
        for (List<String> ticket : tickets){
            String fromAirport = ticket.get(0);
            String toAirport = ticket.get(1);

            if (!hashMap.containsKey(fromAirport)){
                hashMap.put(fromAirport, new ArrayList<String>());
            }
            hashMap.get(fromAirport).add(toAirport);
        }

        String originAirport = "JFK";
        for (List<String> flights : hashMap.values()) {
            Collections.sort(flights, Collections.reverseOrder());
        }

        Stack<String> currentAirportLocation = new Stack();
        currentAirportLocation.push(originAirport);

        List<String> updatedItinerary = new ArrayList<>();

        while (!currentAirportLocation.isEmpty()){
            String currentAirport = currentAirportLocation.peek();
            if (hashMap.containsKey(currentAirport) && !hashMap.get(currentAirport).isEmpty()) {
                currentAirportLocation.push(hashMap.get(currentAirport).remove(hashMap.get(currentAirport).size()-1));
            }else{
                updatedItinerary.add(currentAirportLocation.pop());
            }
        }

        Collections.reverse(updatedItinerary);
        return updatedItinerary;

    }
}
