class Solution {
    public List<String> fizzBuzz(int n) {
        List<String> arr = new ArrayList<>();
        
        arr.add("1");
        
        if(n==1) { return arr;}
        
        arr.add("2");
        if(n==2) {return arr;}
        
        for(int i=3; i<= n; i++) {
            if(i%3==0 && i%5==0) { arr.add("FizzBuzz");} 
            
            else if (i%3==0) {arr.add("Fizz");}
            else if(i%5==0) {arr.add("Buzz");}
            else {arr.add(String.valueOf(i));}
        }
        
        return arr;
    }
}