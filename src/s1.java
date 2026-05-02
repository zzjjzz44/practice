public class s1 {
    public int[] he(int[] n, int a) {
        int b, c ;
        int[] d = new int[2];
        for (b = 0; b < n.length; b++) {
            if (n[b] > a) {
                 break;
            }
        }
        b--;
        c = 0;
        while (b > c) {
            if (n[c] + n[b] == a) {
                d[0] = c;
                d[1] = b;
                break;
            } else if (n[c] + n[b] < a) {
                c++;
            } else if (n[c] + n[b] > a) {
                b--;
            }
            else {
                d[0] = -1;
                d[1] = -1;
            }
        }
        return d;
    }

}