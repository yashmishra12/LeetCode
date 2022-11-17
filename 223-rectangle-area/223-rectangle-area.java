class Solution {
    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        
        // if(ax1>bx1){
        //     swap(ax1,bx1);
        //     swap(ay1,by1);
        //     swap(ax2,bx2);
        //     swap(ay2,by2);
        // }
        int width1 = Math.abs(ax2-ax1);
        int height1 = Math.abs(ay2-ay1);
        int area1 = width1*height1;
        

        int width2 = Math.abs(bx2-bx1);
        int height2 = Math.abs(by2-by1);
        int area2 = width2*height2;
      
        int x_overlap_start = Math.max(ax1, bx1);
        int x_overlap_end = Math.min(ax2, bx2);
        
        int x_overlap = x_overlap_end - x_overlap_start;
        
        
        if(x_overlap<0){
            return area1+area2;
        }
        
        
        int y_overlap_top = Math.min(ay2, by2);
        int y_overlap_bottom = Math.max(ay1, by1);
        int y_overlap = y_overlap_top - y_overlap_bottom;
        
         if(y_overlap<0){
            return area1+area2;
        }
        
        
        int overlap_area = x_overlap*y_overlap;
        
        return (area1+area2)-overlap_area;
        
        
        
    }
}