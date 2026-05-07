import java.util.Scanner;

public class ArraySum {
    int[] arr1;
    int[] arr2;
    int[] num;
    int f;int s;
    int flag1;int flag2;
    int s1=0;int s2=0;
    int maxSum=0;

    ArraySum(int f,int s){
        this.f=f;
        this.s=s;
        arr1=new int[f];
        arr2=new int[s];
        input();
    }

    void input(){
        Scanner in=new Scanner(System.in);
        System.out.println("请输入数组个数，再输入元素");
        int n=in.nextInt();
            num=new int[n];
        for(int i=0;i<n;i++){
            num[i]=in.nextInt();
        }
    }

    int addarray(int[] arr){
        int sum=0;
        for(int i=0;i<arr.length;i++){
        sum+=arr[i];
        }
        return sum;
    }

    void option(int[] a,int[] b,int n,int m) {
        int i = 0;
        int j=0;
        while (j < m) {
            b[i++] = a[n++];
            j++;}
        }


    void screen(){
//        int i=0;int j=num.length-1;
//        int[] a=new int[arr1.length];int[] b=new int[arr2.length];
//        Signal sa1=new Signal(0,f-1);
//        Signal sa2=new Signal(num.length-1, num.length-s);
//
//        while(i+f<=num.length && j>=s){
//            if(i+f<= num.length){
//                option(num,a,i,f);
//                sa1=new Signal(i,i+f-1);
//                int suma=addarray(a);
//                if(s1<suma&&duplicate(sa1,sa2)){
//                option(a,arr1,0,f);
//                flag1=i;
//                s1=addarray(arr1);
//                }
//                i++;
//            }
//
//            if(j>=s){
//                option(num,b,j,-s);
//                sa2=new Signal(j-s+1,j);
//                int sumb=addarray(b);
//                if(s2<sumb&&duplicate(sa1,sa2)){
//                    option(b,arr2,0,b.length);
//                    flag2=j;
//                    s2=addarray(arr2);
//                }
//                j--;
//            }
//        }
//        如果你想保持贪心思路但得到更好的结果，可以：
//        从左到右遍历第一个窗口的所有位置
//        对于每个位置，在不与第一个窗口重叠的区域内找到和最大的第二个窗口
//                从右到左再做一次对称的遍历

        int n = num.length;
        maxSum = Integer.MIN_VALUE;

        // 遍历所有可能的第一个子数组位置
        for(int i=0; i<=n-f; i++){
            // 复制第一个子数组
            option(num, arr1, i, f);
            int sum1 = addarray(arr1);

            // 在第一个子数组之后找第二个子数组
            for(int j=i+f; j<=n-s; j++){
                option(num, arr2, j, s);
                int sum2 = addarray(arr2);
                int total = sum1 + sum2;

                if(total > maxSum){
                    maxSum = total;
                    flag1 = i;
                    flag2 = j;
                    s1 = sum1;
                    s2 = sum2;
                }
            }

            // 在第一个子数组之前找第二个子数组
            for(int j=0; j<=i-s; j++){
                option(num, arr2, j, s);
                int sum2 = addarray(arr2);
                int total = sum1 + sum2;

                if(total > maxSum){
                    maxSum = total;
                    flag1 = i;
                    flag2 = j;
                    s1 = sum1;
                    s2 = sum2;
                }
            }
        }
        System.out.println("第一个子数组位置："+flag1+"-"+(flag1+f-1)+"，和为："+s1);
        System.out.println("第二个子数组位置："+flag2+"-"+(flag2+s-1)+"，和为："+s2);
        System.out.println("最大和为："+maxSum);
    }


    boolean duplicate(Signal a,Signal b){
        if(a.flag==b.flag || a.end==b.end){
            return false;
        } else if (b.flag>=a.flag && b.flag<=a.end) {
            return false;
        } else if (b.end>=a.flag && b.end<=a.end) {
            return false;
        } else if (a.flag>=b.flag && a.flag<=b.end) {
            return false;
        } else if (a.end>=b.flag && a.end<=b.end) {
            return false;
        } else {
            return true;
        }
    }



}
class Signal{
    int flag;
    int end;
    Signal(int flag,int end){
        this.flag=flag;
        this.end=end;
    }
}