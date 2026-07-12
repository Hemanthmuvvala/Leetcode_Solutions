// Last updated: 7/12/2026, 11:11:35 PM
class Solution {
    public int[] rotateElements(int[] nums, int k) {
        int n=nums.length;
        
        ArrayList<Integer> list=new ArrayList<>();
        for(int i=0;i<n;i++){
            if(nums[i]>=0){
                list.add(nums[i]);
            }
        }
        List<Integer> list2=rotateArray(list,k);
        
        int arr[]=new int[n];
        int j=0;
        for(int i=0;i<n;i++){
            if(nums[i]>=0){
                nums[i]=list2.get(j);
                j++;
            }
        }
        return nums;
    }

    public static List<Integer> rotateArray(ArrayList<Integer> list,int k){
       ArrayList<Integer> arr=new ArrayList<>();
        int n=list.size();
        if(n==0 || n==1) return list;
        k=k%n;
        arr.addAll(list.subList(k,list.size()));
        arr.addAll(list.subList(0,k));

        return arr;
    }
}