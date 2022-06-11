class Logger {

    HashMap<String, Integer> hm;
    
    public Logger() {
        hm = new HashMap<>();    
    }
    
    public boolean shouldPrintMessage(int timestamp, String message) {
        if (!this.hm.containsKey(message)) {
            this.hm.put(message, timestamp);
            return true;
        }
        
        Integer lastTS = this.hm.get(message);
        if(timestamp - lastTS < 10) {
            return false;
        } else {
            this.hm.put(message, timestamp);
            return true;
        }
    }
}

/**
 * Your Logger object will be instantiated and called as such:
 * Logger obj = new Logger();
 * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */