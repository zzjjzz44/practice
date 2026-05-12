public class sl {
    void printData(int a){
       if(a%2==0&&a>0){
              System.out.println((a*a)/2);
              printData(a-1);
         }else if(a%2!=0&&a>0){
                System.out.println((a*a-1)/2);
                printData(a-1);
       }
    }
    public static void main(String[] args) {
        sl s=new sl();
        s.printData(10);
    }
}
