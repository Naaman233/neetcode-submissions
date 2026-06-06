class TimeMap {
private Map<String,List<Bloc>> database;
    public TimeMap() {
        this.database = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if (!database.containsKey(key)) {
            database.put(key, new ArrayList<>());
        }
        database.get(key).add(new Bloc(value,timestamp));
    }
    
    public String get(String key, int timestamp) {
        
        String res = "";
        List<Bloc> dbmem = database.getOrDefault(key, new ArrayList<>());
        if (dbmem.isEmpty()) {
            return res;
        }

        int i = 0 , j = dbmem.size() -1;
        while (i <= j) {
            int iterator = i + (j - i) / 2;
            if (dbmem.get(iterator).timestamp <= timestamp) {
                res = dbmem.get(iterator).value;
                i = iterator + 1;
            }else{
                j = iterator -1;
            }
        }
        return res;
    }
}

class Bloc {
    String value;
    int timestamp;

    public Bloc (String value,int timestamp) {
        this.value = value;
        this.timestamp = timestamp;
    }
}
