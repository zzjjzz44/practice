public class p {
    String tn;
    String name;
    String ad;
    double w;
    String[] st={"待揽收","运输中","已签收","派送中","已到达分拣中心"};
    String stu;
    p(String tn, String name, String ad, double w) {
        this.tn = tn;
        this.name = name;
        this.ad = ad;
        this.w = w;
        this.stu = st[0];
    }

    int csf(double w) {
        int a = (int) Math.ceil(w);
        return a < 1 ? 10 : (a - 1) * 3 + 10;
    }

    void us(String news) {
            int i=0;
        while (i<5){
        if(news.equals(st[i])) {
            stu=news;
            return;
        }
        i++;}
        System.out.println("状态无效");
    }


    void ts(){
        System.out.println("快递单号："+tn);
        System.out.println("收件人："+name);
        System.out.println("收件地址："+ad);
        System.out.println("包裹重量："+w+"kg");
        System.out.println("运费："+csf(w)+"元");
        System.out.println("当前状态："+stu);
    }
    public static void main(String[] args) {
    p zjz=new p("SF123456789","张hua","北京市朝阳区",3.5);
    zjz.us("已到达分拣中心");
    zjz.ts();
    }
}

