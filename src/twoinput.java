import java.util.*;

public class twoinput {
    String word;
    Scanner input = new Scanner(System.in);
    char[] c= {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
    int[][] a=new int[5][6];
    ArrayList<coordinate> points = new ArrayList<>();
    ArrayList<closedge> edges = new ArrayList<>();

    void sl(){
        System.out.println("请输入一个单词：");
        word = input.nextLine();
    }

    void address(String s) {
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            //System.out.println(chars[i]);
            for (int j = 0; j < c.length; j++) {
                if (chars[i] == c[j]) {
                    //System.out.println(j);
                    a[j /6][j % 6] = 1;
                }
            }
        }
//        for (int i = 0; i < a.length; i++) {
//            for (int j = 0; j < a[i].length; j++) {
//               System.out.print(a[i][j] + " ");
//           }
//           System.out.println();
//       }
    }

    int[][] getA(int[][] a) {
        int[][] b=new int[word.length()][word.length()];
        for(int i=0;i<a.length;i++){
            for (int j=0;j<a[i].length;j++){
                if(a[i][j]==1){
                points.add(new coordinate(i,j));
//                System.out.println(i+" "+j);
                }
            }
        }
        for(int i=0;i<points.size();i++){
            for(int j=0;j<points.size();j++){
                if(i!=j){
                    b[i][j]=Math.abs(points.get(i).x-points.get(j).x)+Math.abs(points.get(i).y-points.get(j).y);
                }
            }
        }
        for(int i=0;i<b.length;i++){
            for(int j=0;j<b.length;j++){
                System.out.print(b[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();
        return b;
}

   int distance(int[][] b) {
        int m=0;int sum=0;
       for (int i = 1; i < b.length; i++) {
           edges.add(new closedge(0, b[0][i]));
       }
       for (int i = 0; i < edges.size(); i++) {
           int max = 10;
           int k = 0;
           for (int j = 0; j < edges.size(); j++) {
               if (edges.get(j).weight < max && edges.get(j).weight != 0) {
                   max = edges.get(j).weight;
                   k = j;
               }
           }System.out.printf("选择边%d-%d，权值为%d\n",k+1,edges.get(k).v,edges.get(k).weight);

           if (edges.get(k).weight > m) {
               m = edges.get(k).weight;
           }
           System.out.println(edges.get(k).weight);
           sum = sum + edges.get(k).weight;

           edges.get(k).weight=0;
           for (int j = 0; j < edges.size(); j++) {
               for(int l=0;l<b.length;l++){

                          if (b[l][k+1]<edges.get(j).weight&&b[l][k+1]!=0) {
                            edges.get(j).weight = b[k+1][l];
                            edges.get(j).v=k+1;
                          }

               }
           }
       }
       return sum-m;
   }



}

 class coordinate{
        int x;
        int y;
        coordinate(int x,int y){
            this.x=x;
            this.y=y;
        }
}
class closedge{
    int v;
    int weight;
    closedge(int v,int weight){
        this.v=v;
        this.weight=weight;
    }
}