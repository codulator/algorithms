package algos.arrays;

public class OneAway {

    private boolean isOneEditAway(String str1, String str2) {
        if (str1 == null || str2 == null)
            return false;

        int m = str1.length();
        int n = str2.length();

        int diff = 0;

        int i,j;
        for (i =0, j = 0; i < m && j < n;) {
            if (str1.charAt(i) != str2.charAt(j)){
                if (diff == 1)
                    return false;

                if (m > n) {
                    i++;
                } else if (n > m) {
                    j++;
                } else {
                    i++;
                    j++;
                }
                diff++;
            } else {
                i++;
                j++;
            }
        }
        if (i < m || j < n)
            diff++;
        return diff == 1;
    }

    public static void main(String[] args) {
        OneAway oneAway = new OneAway();
        System.out.println("Are strings one edit away ? " + oneAway.isOneEditAway("pale", "ple"));
        System.out.println("Are strings one edit away ? " + oneAway.isOneEditAway("bale", "pale"));
        System.out.println("Are strings one edit away ? " + oneAway.isOneEditAway("kale", "pade"));
    }
}
