import java.util.ArrayList;
import java.util.Scanner;

public class sw_1249 {
    static int dis = 0;
    static ArrayList<Integer> al;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        int count = 1;

        while(t>0){
            al = new ArrayList<Integer>();
            int n = scan.nextInt();
            scan.nextLine();
            int arr[][] = new int[n][n];
            String[] s = new String[n];

            for(int i=0; i<n; i++){
                 s[i] = scan.nextLine();
            }

            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    arr[i][j] = Integer.parseInt(String.valueOf(s[i].charAt(j)));
                   // System.out.print(arr[i][j]);
                }
               // System.out.println();
            }
            move(arr, 0,0, 0, 0);
            //System.out.println(al);
            int min = 999999;
            for(int i=0; i<al.size(); i++){
                if( al.get(i)< min)
                    min = al.get(i);
            }

            System.out.println("#"+count+" "+min);
            t--;
            count++;

            System.out.println(al);
        }
    }

    //x아래로 y오른쪽
    static void move(int[][] map, int x1, int y1, int cnt1, int length1){
        int x=x1, y=y1;
        if( x>map[0].length-1 || y>map[0].length-1)
            return;
        boolean exist = false;
        int cnt = cnt1;
        int length = length1;
        length += map[x][y];

        //System.out.println("현위치: "+x+", "+y+", "+cnt+"leng"+length);
        if(x==map[0].length-1 && y==map[0].length-1){
            //System.out.println("값:"+length);
            if(al.size()==0 || al.get(al.size()-1)>length)
                al.add(length);
            return;
        }

        if((y<map[0].length-1 && map[x][y+1] == 0 ) || x==map[0].length-1) { //오른쪽으로
            y++;
            exist = true;  //트리거
    //        System.out.println("오른쪽이동0 ");
            move(map, x, y, cnt+1,length);
        }
        if(( x<map[0].length-1  && map[x+1][y]==0 )|| y==map[0].length-1){

            x++;
            exist = true;  //트리거
      //      System.out.println("아래0 ");
            move(map, x, y,cnt+1,length);
        }
        if(!exist && y<map[0].length-1 &&x<map[0].length-1){ //이동경로가 0이 아닐경우

          // System.out.println("둘다 "+x+" ,"+y);
            move(map, x, y+1,cnt+1,length);  //두곳다이동

            move(map, x+1, y,cnt+1,length);
        }
    }
}
