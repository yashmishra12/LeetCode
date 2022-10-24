class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
        HashMap<String, Integer> hm = new HashMap<>();
        
        for(String domain: cpdomains) {
            String[] tmp = domain.split(" ");
            int freq = Integer.parseInt(tmp[0]);
            StringBuilder sb = new StringBuilder();
            
            String[] subdomain = tmp[1].split("\\.");
            for(int i =subdomain.length-1; i>=0; i--) {
                if(i==subdomain.length-1) {
                    sb.insert(0,subdomain[i]);
                }else {
                    sb.insert(0, ".");
                    sb.insert(0, subdomain[i]);
                }
                
                hm.put(sb.toString(), hm.getOrDefault(sb.toString(),0)+freq);
            }
        }
        
        List<String> res = new ArrayList<>();
        
        for(Map.Entry<String,Integer> e: hm.entrySet()) {
            StringBuilder sb = new StringBuilder();
            String count = String.valueOf(e.getValue());
            String subdomain = e.getKey();
            sb.append(count);
            sb.append(" ");
            sb.append(subdomain);
            
            res.add(sb.toString());
        }
        
        return res;
        
    }
}