// Last updated: 7/13/2026, 12:12:28 AM
class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        int n=arr.length;
        Arrays.sort(arr);
        List<List<Integer>> list=new ArrayList<>();
        int min=Integer.MAX_VALUE;
        for(int i=1;i<n;i++){
            min=Math.min(min,arr[i]-arr[i-1]);
        }
        for(int i=1;i<n;i++){
            int absVal=Math.abs(arr[i]-arr[i-1]);
            if(absVal==min){
                list.add(Arrays.asList(arr[i - 1], arr[i]));
            }
        }
       return list;
    }
}