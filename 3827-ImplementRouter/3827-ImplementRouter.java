// Last updated: 7/12/2026, 11:12:30 PM
import java.util.*;

class Router {
    private int memoryLimit;
    private Deque<int[]> packets; 
    private Set<String> seen; 
    private Map<Integer, ArrayList<Integer>> destMap; 

    public Router(int memoryLimit) {
        this.memoryLimit = memoryLimit;
        this.packets = new ArrayDeque<>();
        this.seen = new HashSet<>();
        this.destMap = new HashMap<>();
    }

    private String makeKey(int s, int d, int t) {
        return s + "#" + d + "#" + t;
    }

    public boolean addPacket(int source, int destination, int timestamp) {
        String key = makeKey(source, destination, timestamp);

        // Check duplicate
        if (seen.contains(key)) return false;

        // If memory full, evict oldest
        if (packets.size() == memoryLimit) {
            int[] old = packets.pollFirst();
            String oldKey = makeKey(old[0], old[1], old[2]);
            seen.remove(oldKey);

            ArrayList<Integer> lst = destMap.get(old[1]);
            int idx = Collections.binarySearch(lst, old[2]);
            if (idx >= 0) lst.remove(idx);
        }

        // Add new packet
        packets.addLast(new int[]{source, destination, timestamp});
        seen.add(key);

        destMap.putIfAbsent(destination, new ArrayList<>());
        destMap.get(destination).add(timestamp); // timestamps are increasing

        return true;
    }

    public int[] forwardPacket() {
        if (packets.isEmpty()) return new int[]{};

        int[] pkt = packets.pollFirst();
        String key = makeKey(pkt[0], pkt[1], pkt[2]);
        seen.remove(key);

        ArrayList<Integer> lst = destMap.get(pkt[1]);
        int idx = Collections.binarySearch(lst, pkt[2]);
        if (idx >= 0) lst.remove(idx);

        return pkt;
    }

    public int getCount(int destination, int startTime, int endTime) {
        if (!destMap.containsKey(destination)) return 0;
        ArrayList<Integer> lst = destMap.get(destination);

        // binary search for range
        int left = lowerBound(lst, startTime);
        int right = upperBound(lst, endTime);

        return right - left;
    }

    // First index >= target
    private int lowerBound(ArrayList<Integer> arr, int target) {
        int l = 0, r = arr.size();
        while (l < r) {
            int m = (l + r) / 2;
            if (arr.get(m) >= target) r = m;
            else l = m + 1;
        }
        return l;
    }

    // First index > target
    private int upperBound(ArrayList<Integer> arr, int target) {
        int l = 0, r = arr.size();
        while (l < r) {
            int m = (l + r) / 2;
            if (arr.get(m) > target) r = m;
            else l = m + 1;
        }
        return l;
    }
}
