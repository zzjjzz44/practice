import java.util.Scanner;
public class str {
    String[] s1;
    String s2;
    int n;
    int[][] b;
    Scanner sr = new Scanner(System.in);

    void set() {
        System.out.println("请输入字符串数组的元素个数：");
        n = sr.nextInt();
        s1 = new String[n+1];
        System.out.println("请输入字符串数组的元素：");
        for (int i = 1; i < n+1; i++) {
            s1[i] = sr.next();}
        print(s1);
    }

    void print(String[] a){
        System.out.print("{");
        for(int i=1;i<a.length;i++){
            if(i==1)System.out.print("["+a[i]+"]" );
            else System.out.print(","+"["+a[i]+"]" );}
        System.out.println("}");
    }


     char[] px(String a){
        String f=new String(a);
        char[] s=f.toCharArray();
        char t;
        int k=a.length()-1;
        for(int i=0;i<k;i++){
            for(int j=0;j<k-i;j++){
                if(s[j+1] < s[j]){
                     t=s[j+1];
                    s[j+1]=s[j];
                    s[j]=t;
                }
            }
        }
        //System.out.println(s);
        return s;
    }

    int con(String a,String b){
        int k;int g=0;
        char[] x=px(a);
        char[] y=px(b);
        for(int i=0;i<a.length();i++) {
                if(x[i]==y[i]){
                    g++;}
                else return 0;
                if(g==a.length()) return 1;
                }
        return 0;
    }

     void cons(String[] a){
        b=new int[n+1][n+1];
        int l=1;
        for(int i=1;i<n+1;i++){
                b[i][0]=i;
            }
        for(int i=1;i<n+1;i++){
            for(int j=i+1;j<n+1;j++){
                if(con(a[i],a[j])==1){
                    b[i][l]=j;
                l++;}
            }
        }
    }

    void printb(){
        int k=0;
        System.out.print("{");
        for(int i=1;i<s1.length;i++){
            System.out.print("[");
            if(k!=i){
            for(int j=0;j<s1.length;j++){
                if(b[i][j]!=0){
                    System.out.print(s1[b[i][j]]+" , ");
                    k=b[i][j];}
            }
            }
            System.out.print("],");
        }
        System.out.print("}");
    }


}
