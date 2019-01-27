import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class sw1244_1 {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        int count =1;
        int max=0;
        int min=10;
        ArrayList <Integer> al;
        while(t>0) {
            al = new ArrayList<Integer>();//숫자 정보
            ArrayList<Integer> mal;

            int num= scan.nextInt();
            int change = scan.nextInt();

            StringBuilder snum = new StringBuilder(""+num);

            for(int i=0; i<snum.length(); i++){
                int index = Integer.parseInt(snum.substring(i,i+1));
                al.add(index);

                if(max < index)
                    max = index;
                if(min > index)
                    min = index;
            }

            mal = al;
            Collections.sort(mal);

            if(change == 1){
                if(al.get(0) != max){
                    int pos = al.lastIndexOf(max);
                    int temp = al.remove(0);
                    System.out.println("temp:"+temp+", pos: "+pos);
                    al.add(0, max);
                    al.remove(pos);
                    al.add(pos, temp);
                    System.out.println(al);
                }
            }else{

               //교환 2번이상시 구현

            }

            System.out.print("#"+count+" ");
            for(int i=0; i<al.size(); i++){
                System.out.print(al.get(i));
            }
            System.out.println();

            count++;
            t--;
        }


    }
}
