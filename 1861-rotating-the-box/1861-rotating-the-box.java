class Solution {
    public char[][] rotateTheBox(char[][] box) {
        int row = box.length;
        int col = box[0].length;
        //move all the stones to right...rotate box
        for(int i=0; i<row; i++) {
            for(int j=col-1; j>=0; j--) {
                if(box[i][j] == '#') {
                    int empty = j+1;
                    
                    while(empty<col && box[i][empty] == '.') {
                        empty++;
                    }
                    
                    if(empty < col && box[i][empty] == '.') {
                        box[i][empty] = '#';
                        box[i][j] = '.';
                    } 
                    //empty fell out of range
                    else if( empty-1<col && box[i][empty-1]=='.'){ 
                        box[i][empty-1] = '#';
                        box[i][j] = '.';
                    }
                }
            } 
        }
        
        char[][] res = new char[col][row];
        
        int k = row-1;
        
        for(int i=0; i<row;i++) {
            for(int j=0; j<col; j++) {
                res[j][k] = box[i][j];
            }
            k--;
        }
        
        return res;
    }
}