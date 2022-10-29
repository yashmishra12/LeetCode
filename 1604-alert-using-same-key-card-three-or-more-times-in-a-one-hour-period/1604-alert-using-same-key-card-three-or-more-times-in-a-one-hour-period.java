class Solution {
    public List<String> alertNames(String[] keyName, String[] keyTime) {
        HashMap<String, TreeSet<Integer>> hm = new HashMap<>();
        
        for(int i = 0; i<keyTime.length; i++) {
            String name = keyName[i];
            String time = keyTime[i];
            String[] timeSplit = time.split(":");
            Integer hr = Integer.parseInt(timeSplit[0]);
            Integer min = Integer.parseInt(timeSplit[1]);
            
            Integer tmp = hr*60 + min;
            
            if(hm.containsKey(name)) {
                hm.get(name).add(tmp);
            }
            else {
                TreeSet<Integer> ts = new TreeSet<>();
                ts.add(tmp);
                hm.put(name, ts);
            }
        }
        
        List<String> res = new ArrayList<>();
        
        for(Map.Entry<String, TreeSet<Integer>> e: hm.entrySet()) {
            String potName = e.getKey();
            TreeSet<Integer> ts = e.getValue();
            int[] arr = new int[ts.size()];
            
            for(int i=0; i<arr.length; i++) {
                arr[i] = ts.pollFirst();
            }
            
            for(int i=0; i<arr.length-2;i++){
               int begin = arr[i];
                int end = arr[i+2];
                if(end-begin<=60){
                    res.add(potName);
                    break;
                }
            }
        }
        
        Collections.sort(res);
        return res;
    }
}