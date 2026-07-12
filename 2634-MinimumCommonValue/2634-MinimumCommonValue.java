// Last updated: 7/12/2026, 11:13:46 PM
class Solution {
    public int getCommon(int[] nums1, int[] nums2) {
        int i=0,j=0,ans=-1;
        
        int n=nums1.length;
        int m=nums2.length;
        
        while(i < n && j< m){
            if(nums1[i]<=nums2[j]){
                if(nums1[i]==nums2[j]){
                    return nums1[i];
                }
               // ans=nums1[i];
                i++;
            }else{
                j++;
            }
        }
        
        return ans;
    }
}