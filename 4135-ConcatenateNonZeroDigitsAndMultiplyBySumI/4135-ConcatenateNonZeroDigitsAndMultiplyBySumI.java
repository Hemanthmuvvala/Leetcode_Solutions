// Last updated: 7/12/2026, 11:11:46 PM
class Solution {
    public long sumAndMultiply(int n) {
      StringBuilder s=new StringBuilder();
        char[] arr=String.valueOf(n).toCharArray();
        long sum=0;
        for(char c:arr){
            if(c!='0'){
                s.append(c);
            }
        }
        // s=s.toString
       String a= s.toString();
       long b = 0;
       for(int i=0;i<arr.length;i++){
            b+=(arr[i]-'0');
           
       }
        long num = 0;
        long rem;
        for(int i=0;i<a.length();i++){
           num=num*10+(a.charAt(i)-'0');
            
            
        }
      
        return b*num;       
    }
}