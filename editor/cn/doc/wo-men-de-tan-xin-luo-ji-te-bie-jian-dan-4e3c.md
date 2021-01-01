```
class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        for(int i=0;i<flowerbed.length;i++){
           if(i==0){ //第一个
               if(flowerbed.length>1){
                   if(flowerbed[0]+flowerbed[1]==0){
                       flowerbed[0] = 1;
                       n--;
                   }
               }else{
                   if(flowerbed[0]==0){
                       flowerbed[0] = 1;
                       n--;
                   }
               }
           }else if(i==flowerbed.length-1){ //最后一个
               if(flowerbed[i-1]+flowerbed[i] == 0){
                   flowerbed[i] = 1;
                   n--;
               }
           }else{ //中间的
               if(flowerbed[i-1]+flowerbed[i]+flowerbed[i+1] ==0){
                   flowerbed[i] = 1;
                   n--;
               }
           }
        }
        return n<=0;
    }
}
```
