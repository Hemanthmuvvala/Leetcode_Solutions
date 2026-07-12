// Last updated: 7/12/2026, 11:14:50 PM
class Solution {
    public int numberOfBeams(String[] bank) {
        

        int floorDevices=0;
       
        int res=0;
        int sum=0;

        for(String s:bank){
                 int count=0;
                for(char c:s.toCharArray()){
                    if(c=='1')
                    count++;
                   
                    }
                    if(count==0)
                    continue;
                   res=floorDevices*count;
                 sum=sum+res;
                 floorDevices=count;
                }
                 
                

           
        
     return sum;
    }
}