class Solution {
    public boolean validUtf8(int[] data) {
        int remainingBytes = 0;
        
        for(int val: data) {
            if(remainingBytes==0) {
                if((val>>7)==0b0){remainingBytes = 0;} //1byte char
                else if((val>>5)==0b110){remainingBytes = 1;} //2 byte char
                else if((val>>4)==0b1110){remainingBytes = 2;} //3 byte char
                else if((val>>3)==0b11110){remainingBytes = 3;} //4 byte char
                else{
                    return false;
                }
            }
            else {
                if((val>>6)==0b10){
                    remainingBytes--;
                }
                else{
                    return false;
                }
            }
        }

        if(remainingBytes!=0) {return false;}
        return true;
    }
}