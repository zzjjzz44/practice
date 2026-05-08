import java.util.*;

public class Shudu {
int[][] sd=new int[9][9];

void sc(int sd[][],int i,int j) {
    if(sd[8][8]!=0){
        return;
    }
    List<Integer> can = new ArrayList<>();
    do {
        sd[i][j] = (int) (Math.random() * 9) + 1;
        can.add(sd[i][j]);
    }
    while(cc(can));
        can.clear();
        if(yz(sd,i,j)){
            sc(sd,i,j+1);
        }
        else sc(sd,i,j-1);
    }



boolean cc(List<Integer> list){
    for (int i = 0; i < list.size(); i++) {
        for (int j = i + 1; j < list.size(); j++) {
            if (list.get(i).equals(list.get(j))) {
                return true;
            }
        }
    }
    return false;
}


boolean yz(int [][]a,int x,int y) {
    int n = a[x][y];
    for (int i = 0; i < 9; i++) {
        if (a[i][y] == n || a[x][i] == n) {
            return false;
        }
    }
    int []b ={2,5,8};
    int m = 0;
    int k = 0;
    for(int j=0;j<3;j++){
        if(x<=b[j]&&m==0){
            m=b[j]-1;
        }
        if(y<=b[j]&&k==0){
            k=b[j]-1;
        }
    }
    for(int dx=-1;dx<=1;dx++){
        for(int dy=-1;dy<=1;dy++){
            if(a[m+dx][k+dy]==n&&m+dx!=x||k+dy!=y){
                return false;
            }
        }
    }
    return true;
    }

  static void main(String[] args) {
    Shudu s=new Shudu();
    for(int i=0;i<9;i++){
        for(int j=0;j<9;j++){
            s.sc(s.sd,i,j);
        }
    }

    for(int i=0;i<9;i++){
        for(int j=0;j<9;j++){
            System.out.print(s.sd[i][j]+" ");
            if((j+1)%3==0){
                System.out.print("|");
            }
            if((i+1)%3==0&&j==8){
                System.out.println();
                System.out.println("---------------------");
            }
        }
        System.out.println();
    }
}
}


