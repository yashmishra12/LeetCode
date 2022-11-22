class FreqStack {
    Map<Integer, Integer> freq;
    Map<Integer, Stack<Integer>> group;
    int maxfreq;

    public FreqStack() {
        freq = new HashMap();
        group = new HashMap();
        maxfreq = 0;
    }

    public void push(int x) {
        int f = freq.getOrDefault(x, 0) + 1;
        freq.put(x, f); //1. update freq Map
        if (f > maxfreq){ //2. update maxFreq variable
            maxfreq = f;
        }

        group.computeIfAbsent(f, z-> new Stack()).push(x); //3. update group hashmap
    }

    public int pop() {
        int x = group.get(maxfreq).pop();   //1. remove from group hashmap
        freq.put(x, freq.get(x) - 1);       //2. update freq hashmap
        if (group.get(maxfreq).size() == 0) //3. Update maxFreq variable
        { maxfreq--; }
        
        return x;
    }
}