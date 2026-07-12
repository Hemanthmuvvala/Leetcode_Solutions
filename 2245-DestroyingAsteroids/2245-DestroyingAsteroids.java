// Last updated: 7/12/2026, 11:14:42 PM
class Solution {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        int n=asteroids.length;
        Arrays.sort(asteroids);
        long planet=mass;
        for(int i=0;i<n;i++){
            
            if(planet>=asteroids[i]){
                planet+=asteroids[i];
            }else{
                return false;
            }
        }

        return true;
    }
}