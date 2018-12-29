
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class sw2_1 {
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
                sb.append(scan.nextLine());
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


            int pos = 0; //가로줄 현위치
            for (int j = 0; j < m * n; j++) {

                if (end != -1 && sb.charAt(j) != '0') {  //암호코드가 더있다면
                    if (pass.toString().equals(sb.substring(j, j + 15))) { //같은암호코드라면
                        j += m - pos;//다음줄
                        pos = 0;
                    } else {
                        start = -1;
                        end = -1;
                        j--;
                        pos--;
                    }
                } else {
                    if (sb.charAt(j) != '0' && start == -1) {
                        start = j;    //암호코드시작
                    } else if (start != -1 && sb.charAt(j) == '0' && end == -1) {
                        end = j;       //암호코드끝
                        pass = new StringBuilder(sb.substring(start, end));
                        number.add(Long.parseLong(sb.substring(start, end), 16));
                        exist--;

                    }
                    if (exist == 0)
                        break;

                    pos++;
                    if (pos == m) {
                        pos = 0;
                    }
                }

            }


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

            count++;
            t--;

        }

    }
}
