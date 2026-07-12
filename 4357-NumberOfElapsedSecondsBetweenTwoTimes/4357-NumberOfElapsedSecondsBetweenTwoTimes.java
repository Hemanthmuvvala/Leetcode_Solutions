// Last updated: 7/13/2026, 12:06:27 AM
class Solution {
    public int secondsBetweenTimes(String startTime, String endTime) {
       
        return convertToSeconds(endTime) - convertToSeconds(startTime);
    }
    
    
    private int convertToSeconds(String time) {
       
        String[] parts = time.split(":");
        
        int hours = Integer.parseInt(parts[0]);
        int minutes = Integer.parseInt(parts[1]);
        int seconds = Integer.parseInt(parts[2]);
        
        
        return (hours * 3600) + (minutes * 60) + seconds;
    }
}