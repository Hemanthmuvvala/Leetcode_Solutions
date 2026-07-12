// Last updated: 7/13/2026, 12:12:38 AM
class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int n = arr.length;
        int ans[] = new int[n];
        int dup[] = new int[n];
        int index = 0;

        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i : arr){
            dup[index++] = i;
        }
        Arrays.sort(dup);

        int rank = 1;
        for(int i = 0; i < n; i++){
            if(!map.containsKey(dup[i])){
                map.put(dup[i], rank++);
            }
        }
        for(int i = 0; i < n; i++){
            ans[i] = map.get(arr[i]);
        }

        return ans;
    }
}