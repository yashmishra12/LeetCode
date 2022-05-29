class RandomizedCollection {
    
    ArrayList<Integer> list;
    HashMap <Integer, HashSet<Integer>> dict;
    Random rand = new Random();
    
    public RandomizedCollection() {
        list = new ArrayList<Integer>();
        dict = new HashMap<>();
    }
    
    public boolean insert(int val) { // value will be added. If it's duplicate, return false
        boolean flag;
        HashSet<Integer> set;
        
        if(dict.containsKey(val)) {
           set = dict.get(val);
            flag = false;
        }
        else {
            set = new HashSet<>(); //if val was never present, new HashSet is needed
            flag = true;
        }
        
        set.add(list.size()); //HashSet gets the new index of val that is last
        list.add(val);
        dict.put(val, set);
        
        return flag;
  
    }
    
    public boolean remove(int val) {
        HashSet<Integer> set;
        
        if(dict.containsKey(val)) {
            set = dict.get(val);
        } else {
            return false;
        }
        
        int removeIndex = -1;
        
        for(int i: set) {
            removeIndex = i;
            break;
        }
        
        set.remove(removeIndex);
        dict.put(val, set);
        
        if(dict.get(val).size()==0) {dict.remove(val);}
        
        if(removeIndex == list.size()-1) {
            list.remove(list.size()-1); // no swapping required. 
        } 
        else {
            list.set(removeIndex, list.get(list.size()-1));
            list.remove(list.size()-1);
            
            int newVal = list.get(removeIndex);
            
            HashSet<Integer> temp = dict.get(newVal);
            temp.remove(list.size());
            temp.add(removeIndex);
            dict.put(newVal, temp);
        }
        return true;
        
        
//         if(!dict.containsKey(val) || dict.get(val).size() == 0) {return false;}
//         else  {
            
//         }
        
    }
    
    public int getRandom() {return list.get(rand.nextInt(list.size()));}
}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */