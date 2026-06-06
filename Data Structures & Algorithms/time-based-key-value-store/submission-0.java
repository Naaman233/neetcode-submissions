class TimeMap {

Map<String,List<Schema>> database;
    public TimeMap() {
        this.database = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if (!database.containsKey(key)) {
            database.put(key, new ArrayList<Schema>());
        }
        database.get(key).add(new Schema(value,timestamp));
    }
    
    public String get(String key, int timestamp) {
        String res = "";

        List<Schema> storageBloc = database.getOrDefault(key, new ArrayList<>());
        if (storageBloc.size() == 0){
            return res;
        }

        int i = 0 , j = storageBloc.size() -1;
        while (i <= j) {
            int index = i + (j - i) / 2;
            if (storageBloc.get(index).timestamp <= timestamp) {
                res = storageBloc.get(index).value;
                i = index + 1;
            } else {
                j = index -1;
            }
           
        }

        return res;
    }
}

class Schema {
    String value;
    int timestamp;

    Schema(String value, int timestamp) {
        this.value = value;
        this.timestamp = timestamp;
    }
}
