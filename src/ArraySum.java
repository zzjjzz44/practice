import java.util.Scanner;

public class ArraySum {
    int[] arr1;
    int[] arr2;
    int[] num;
    int f;int s;
    int flag1;int flag2;
    int s1=0;int s2=0;

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
        if(m>0){
        while (j < m) {
            b[i++] = a[n++];
            j++;}
        }
        else{
            while(j<-m){
                b[i++]=a[n--];
                j++;}
        }
    }

    void screen(){
        int i=0;int j=num.length-1;

        while(i+f<=num.length && j>=s){
            if(i+f<= num.length){
                option(num,arr1,i++,f);
                if(s1<addarray(arr1)){
                flag1=i;
                s1=addarray(arr2);}
            }

            if(j>=s){
                option(num,arr2,j--,-s);
                if(s2<addarray(arr2)){
                    flag2=j;
                    s2=addarray(arr2);}
            }
        }

    }


}
