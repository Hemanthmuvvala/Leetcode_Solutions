// Last updated: 7/14/2026, 10:18:34 AM
class Solution {
    boolean isprime(int n) {
        if (n <= 1) return false;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public boolean completePrime(int num) {

        if (num < 10) {
            return isprime(num);
        }
        String s = String.valueOf(num);
        StringBuffer prefix = new StringBuffer(s);
        while (prefix.length() > 0) {
            int pre = Integer.parseInt(prefix.toString());
            if (!isprime(pre)) {
                return false;
            }
            prefix.deleteCharAt(prefix.length() - 1);
        }

       
        StringBuffer suffix = new StringBuffer(s);
        while (suffix.length() > 0) {
            int suf = Integer.parseInt(suffix.toString());
            if (!isprime(suf)) {
                return false;
            }
            suffix.deleteCharAt(0);
        }

        return true;
    }
}