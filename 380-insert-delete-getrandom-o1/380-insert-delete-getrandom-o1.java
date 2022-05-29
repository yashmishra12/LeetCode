class RandomizedSet {
    Map<Integer, Integer> dict; //key: the number, value: its Index
    List<Integer> list;
    Random rand = new Random();
    
    public RandomizedSet() {
        dict = new HashMap<>();
        list = new ArrayList<>();
        
    }
    
    public boolean insert(int val) {
        if(dict.containsKey(val)) return false;
        else {
            dict.put(val, list.size()); //new number goes at the end, ∴ its index is list.size()
            list.add(list.size(), val); //list.add(INDEX, VALUE);
            return true;
        }   
    }
    
    
    public boolean remove(int val) {
        if(!dict.containsKey(val)) return false; //if dict doesn't contain val, return false
        else {
            int lastElement = list.get(list.size()-1);
            int index = dict.get(val);
            list.set(index, lastElement); //swapping last element with the num. to delete
            dict.put(lastElement, index); //updating the new index of the last element
            
            list.remove(list.size()-1); //remove from list
            dict.remove(val);
            return true;   
        }
    }
    
    public int getRandom() {
        return list.get(rand.nextInt(list.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */