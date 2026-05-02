import  java.util.Scanner;
public class xulie {
    int[] nums;
    int[] res;
    int k;
    int m;
    int nn=0;
    Scanner sr = new Scanner(System.in);
    void sr() {
        System.out.println("请输入整数的个数：");
        int n = sr.nextInt();
        nums = new int[n];
        System.out.println("请输入整数：");
        for (int i = 0; i < n; i++) {
            nums[i] = sr.nextInt();
        }
        k=nums[0];
        for(int i=1;i<nums.length;i++){
                if(nums[i]<k) k=nums[i];
                if(nums[i]>m) m=nums[i];
            }
    }

    void cz(){
        res=new int[m - k + 1];
        res[0]=k;
        for(int i=0;i<nums.length;i++){
            res[nums[i]-k]=nums[i];
        }
    }

    int cz1(){
        int j=0;
        int[] d=new int[res.length];
        for(int i=0;i<res.length-1;i++){
            if(res[i+1]!=0){
               nn++;
            }
            else{
                if(nn>0){
                d[j++]=nn;}
                nn=0;}
        }
        if(nn>0){
            d[j++]=nn;}
        j=d[0];
        for(int i=1;i<d.length;i++){
            if(d[i]>j) j=d[i];
        }
    return j+1;}


    void print(int[] nums){
        int i;
        System.out.print("[");
        for (i = 0; i < nums.length; i++) {
            if (i == nums.length - 1) System.out.print(nums[i]);
            else System.out.print(nums[i] + ",");
            }
        System.out.println("]");
        }
    }

