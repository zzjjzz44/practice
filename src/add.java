import java.util.*;
public class add {
    LinkL l1 = new LinkL();
    LinkL l2 = new LinkL();
    LinkL l3 = new LinkL();

    public void sl() {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个整数");
        int a = sc.nextInt();
        System.out.println("请输入另一个整数");
        int b = sc.nextInt();
        st(a, l1);
        st(b, l2);
    }

    public void st(int a,LinkL l){
        int i;
        while(a!=0){
            i=a%10;
            l.insert2(i);
            a=a/10;
        }
    }

    public void print(LinkL l){
        Node current=l.head;
        while(current!=null){
            System.out.print(current.data);
            if(current.next!=null) {
                System.out.print("->");
            }
            current=current.next;
        }
        System.out.println();
    }

    public void aTn(LinkL l1, LinkL l2) {
        Node p1 = l1.head;
        Node p2 = l2.head;
        th(l1,l2);
        int i=0;
        while (p1 != null || p2 != null || (i!=0&&p1==null&&p2==null)) {
            int s;
            int n1 = (p1 != null) ? p1.data : 0;
            int n2 = (p2 != null) ? p2.data : 0;
            s =n1 + n2 + i;
            l3.insert2(s % 10);
            i= s /10;
            if(p1!=null) p1 = p1.next;
            if(p2!=null) p2 = p2.next;
        }
    }

    public void th(LinkL l1,LinkL l2){
       Node a1=l1.head;
       Node a2=l2.head;
       while(a1!=null && a2!=null){
              a1=a1.next;
              a2=a2.next;
              if(a1==null && a2!=null){
                  l1.insert2(0);
              }else if(a2==null && a1!=null){
                  l2.insert2(0);}
       }
    }
}