import java.util.*;
public class yanzheng {
    Random s=new Random();
    String sc(){
    char[] a=new char[4];
    int i=0;int b;
    while(i<4){
        b=s.nextInt(48,123);
        if(b>90&&b<97||b>57&&b<65){continue;}
        a[i]=(char)b;
        i++;}
    String str=String.valueOf(a);
    return str;
}
public static void main(String[] args) {
    yanzheng y = new yanzheng();
    String k = y.sc();
    System.out.println("验证码：" + k);
    System.out.println("请输入验证码：");
    Scanner a = new Scanner(System.in);
    String b = a.next();
    if (b.equals(k)) {
        System.out.println("验证通过");
    } else {
        System.out.println("验证失败");
    }
}
}