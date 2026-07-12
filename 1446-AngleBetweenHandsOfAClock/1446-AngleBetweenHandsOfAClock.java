// Last updated: 7/13/2026, 12:11:58 AM
class Solution {
    public double angleClock(int hour, int minutes) {
       
        double angle = Math.abs(30 * hour - 5.5 * minutes);

       
        if (angle < 180) {
            return angle;
        }
        return 360 - angle;
    }
}
