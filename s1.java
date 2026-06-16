public class s1 {
    public static void main(String[] args) {
        int[] n={1,2,5,7,8,10,11,15};
        int a=15;
        int b;int c=0 ;
        int[] d = new int[2];
        for (b = 0; b < n.length; b++) {
            if (n[b] > a) {
                break;
            }
        }
        b--;
        while (b > c) {
            if (n[c] + n[b] == a) {
                d[0] = n[c];
                d[1] = n[b];
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
        System.out.println(d[0]+" "+d[1]);}
}
