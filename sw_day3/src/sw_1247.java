import java.util.ArrayList;
import java.util.Scanner;

public class sw_1247 {
    static int dis;

    static Pos house;

    static Pos custom[];
    static ArrayList<Integer> al;
    public static void main(String[] args) {
        Pos company;

        Scanner scan = new Scanner(System.in);
        int count = 1;
        int t = scan.nextInt();

        while(t>0) {

            int n = scan.nextInt();
            al = new ArrayList<Integer>();

            custom = new Pos[n];
            company = new Pos();
            company.x = scan.nextInt();
            company.y = scan.nextInt();

            house = new Pos();
            house.x = scan.nextInt();
            house.y = scan.nextInt();

            for(int i=0; i < n; i++){
                custom[i] = new Pos();
                custom[i].x = scan.nextInt();
                custom[i].y = scan.nextInt();

            }

            boolean check[];
            for(int i=0; i<n; i++){
                check = new boolean[n];
                check[i] = true;
                dis = distance(custom[i], company);
                //System.out.println("----------------main i:"+i);
                move(i, dis, check, 0);

            }

            int min=9999999;
            for(int i=0; i<al.size(); i++){
                if(al.get(i)<min){
                    min = al.get(i);
                }
            }
           // System.out.println(al);
            System.out.println("#"+count+" "+min);
            t--;
            count++;
        }
    }

    static void move(int i, int dis , boolean[] ch, int cnt){
        int length=0;

        boolean[] check = ch.clone();
        check[i] = true;
        for(int j=0; j<custom.length; j++) {
            if(check[j])
                continue;
            length = distance(custom[i], custom[j])+dis;  //각 지점끼리의 거리
           // System.out.println("move : "+i+", "+j);
            move(j, length, check, cnt+1);  //다음 지점계산

        }
        if( cnt==custom.length-1) {
            dis += distance(custom[i], house);
            if(al.size()==0 || al.get(al.size()-1) > dis)
                al.add(dis);
           // System.out.println(al);
            return;
        }

    }
    static int distance(Pos p1, Pos p2){
        return Math.abs(p1.x-p2.x) + Math.abs(p1.y-p2.y);
    }

    static class Pos{
        int x;
        int y;

    }
}
