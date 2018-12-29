
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class sw2_2 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scan = new Scanner(System.in);

        //  System.setIn(new java.io.FileInputStream("sample_input"));

        int t = scan.nextInt();
        int count = 1;
        int n, m;

        ArrayList<Long> number;
        StringBuilder sb;

        int oddsum;
        int evensum;

        StringBuilder pass = new StringBuilder();


        while (t > 0) {


            scan.nextLine();
            n = scan.nextInt();
            m = scan.nextInt();

            number = new ArrayList<Long>();
            oddsum = 0;
            evensum = 0;
            sb = new StringBuilder();

            for (int i = 0; i < n; i++) {
                sb.append( scan.nextLine());
            }

            if (m < 15 || n < 1) {  //비정상암호
                System.out.println("#" + count + " 0");
                t--;
                count++;
                continue;
            }

            int start = -1;
            int end = -1;
            int exist = m / 25;

            int row =0;


            for (int i = 0; i <sb.length()/m; i++) {
                if(i % m ==0)
                    row ++;  //다음행
                for(int j=0; j<m; j++){  //처음
                    if(sb.charAt(j) != '0') {
                        start = j;
                        break;
                    }
                }
                if( start != -1) { //존재할때만실행
                    for (int k = m; k <= 0; k--) {  //끝
                        if(sb.charAt(k) != '0'){
                            end = k;
                            break;
                        }
                    }
                }

                if( start != -1 && end != -1){
                    System.out.println(sb.substring(start, end));
                }
            }
/*

            if (number.isEmpty()) {   //암호문x
                System.out.println("#" + count + " 0");
                t--;
                count++;
                continue;
            }

            StringBuilder decode;
            int index ;
            int temp ;  //현재수저장
            for (int i = 0; i < number.size(); i++) {

                index = 0;
                decode = new StringBuilder("000" + Long.toBinaryString(number.get(i)));

                if (decode.length()<59) {
                    continue; //비정상암호코드
                }

                StringBuilder copy;



                for(int j=0; j<decode.length(); j++) {
                    temp = -1;

                    switch (decode.substring(j , j + 7)) {
                        case "0001101":
                            temp = 0;
                            break;
                        case "0011001":
                            temp = 1;
                            break;
                        case "0010011":
                            temp = 2;
                            break;
                        case "0111101":
                            temp = 3;
                            break;
                        case "0100011":
                            temp = 4;
                            break;
                        case "0110001":
                            temp = 5;
                            break;
                        case "0101111":
                            temp = 6;
                            break;
                        case "0111011":
                            temp = 7;
                            break;
                        case "0110111":
                            temp = 8;
                            break;
                        case "0001011":
                            temp = 9;
                            break;
                    }
                    if(temp != -1) {
                        j += 6;

                        if (index % 2 == 0) //짝수
                        {
                            evensum += temp;
                        } else {
                            oddsum += temp;
                        }
                        index++;
                        if(index == 8){
                            break;
                        }
                    }
                }
            }
            if ((evensum * 3 + oddsum) % 10 == 0)//10배수
            {
                System.out.println("#" + count + " " + (evensum + oddsum));
            } else {
                System.out.println("#" + count + " 0");
            }
*/
            count++;
            t--;

        }

    }
}
