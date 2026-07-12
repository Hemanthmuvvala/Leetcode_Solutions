// Last updated: 7/13/2026, 12:06:04 AM
1class Solution {
2    public int secondsBetweenTimes(String startTime, String endTime) {
3       
4        return convertToSeconds(endTime) - convertToSeconds(startTime);
5    }
6    
7    
8    private int convertToSeconds(String time) {
9       
10        String[] parts = time.split(":");
11        
12        int hours = Integer.parseInt(parts[0]);
13        int minutes = Integer.parseInt(parts[1]);
14        int seconds = Integer.parseInt(parts[2]);
15        
16        
17        return (hours * 3600) + (minutes * 60) + seconds;
18    }
19}