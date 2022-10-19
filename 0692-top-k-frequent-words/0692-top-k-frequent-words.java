class Solution {
    class Word {
        String w;;
        int freq;
        Word(String w, int freq){
            this.w = w;
            this.freq = freq;
        }
    }
    
    
    public List<String> topKFrequent(String[] words, int k) {
        PriorityQueue<Word> pq = new PriorityQueue<>((a,b)->b.freq-a.freq!=0 ? b.freq-a.freq : a.w.compareTo(b.w));
        HashMap<String, Integer> hm = new HashMap<>();
        for(String w: words) {
            hm.put(w, hm.getOrDefault(w,0)+1);
        }
        
        for(Map.Entry<String,Integer> e: hm.entrySet()) {
            String w = e.getKey();
            Integer f = e.getValue();
            pq.add(new Word(w, f));
        }
        ArrayList<String> res = new ArrayList<>();
        
        while(k>0) {
            Word w = pq.poll();
            res.add(w.w);    
            k--;
        }
        
        return res;
    }
}