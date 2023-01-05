class Solution {
    public int findMinArrowShots(int[][] points) {

        if(points[0][0] !=-2147483646) 
            Arrays.sort(points, (int[] a,int[] b)->(a[0]!=b[0] ? a[0]-b[0] : a[1]-b[1]));
        ArrayList<Integer[]> arr = new ArrayList<>();
        Integer[] x = new Integer[2];
        x[0] = points[0][0];
        x[1] = points[0][1];
        arr.add(x);
        
        for(int i=1; i<points.length; i++) {
            Integer[] curArr = new Integer[2];
            curArr[0] = points[i][0];
            curArr[1] = points[i][1];
            Integer[] lastArr = arr.get(arr.size()-1);
            
            if(lastArr[1]>=curArr[0]) { //common area hai
                Integer[] tmp = new Integer[2];
                tmp[0] = Math.max(curArr[0], lastArr[0]);
                tmp[1] = Math.min(curArr[1], lastArr[1]);
                arr.remove(arr.size()-1);
                arr.add(tmp);
            } else {
                arr.add(curArr);
            }
        }
        
        return arr.size();
        
    }
}