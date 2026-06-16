import java.util.Scanner;
public class baoguo {
    public static void main(String[] args) {
        System.out.println("请输入包裹总重量（kg）：");
        Scanner sc = new Scanner(System.in);
        double w = sc.nextDouble();
        int a = (int) Math.ceil(w);
        /*
        int i=0;int b=1;
        int[] s={1,3,10,20};
        while(i<4){
         if (a<=s[i]){
            break;
         }
         else {
            i++;
            b++;
         }
        }
        */
        if (w <= 0) {
            System.out.println("无效输入数据");
        } else {
            //System.out.println(a);
            switch (a) {
                case 1:{
                    System.out.println("运费为3.5元");
                    break;
                }
                case 2,3:{
                    System.out.println("运费为5.5元");
                    break;
                }
                case 4,5,6,7,8,9,10:{
                    System.out.println("运费为8.5元");
                    break;
                }
                case 11,12,13,14,15,16,17,18,19,20:{
                    System.out.println("运费为10.5元");
                    break;
                }
                default: {
                    System.out.println("该包裹不能被寄送");
                    break;}
            }
        }
    }
}
