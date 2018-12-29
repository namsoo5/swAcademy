

import java.util.ArrayList;
import java.util.Scanner;

public class sw2_2 {
    public static void main(String[] args)  {
        Scanner scan = new Scanner(System.in);


        int t = scan.nextInt();
        int count = 1;
        int n, m;

        StringBuilder sb;

        int oddsum;
        int evensum;

        StringBuilder pass = new StringBuilder();

        ArrayList<StringBuilder> arrsb = new ArrayList<StringBuilder>();
        arrsb.add(new StringBuilder("0001101"));
        arrsb.add(new StringBuilder("0011001"));
        arrsb.add(new StringBuilder("0010011"));
        arrsb.add(new StringBuilder("0111101"));
        arrsb.add(new StringBuilder("0100011"));
        arrsb.add(new StringBuilder("0110001"));
        arrsb.add(new StringBuilder("0101111"));
        arrsb.add(new StringBuilder("0111011"));
        arrsb.add(new StringBuilder("0110111"));
        arrsb.add(new StringBuilder("0001011"));

        StringBuilder code0 ;
        StringBuilder code1;
        StringBuilder code2;
        StringBuilder code3 ;
        StringBuilder code4 ;
        StringBuilder code5 ;
        StringBuilder code6 ;
        StringBuilder code7 ;
        StringBuilder code8 ;
        StringBuilder code9 ;
        while (t > 0) {


            scan.nextLine();
            n = scan.nextInt();
            m = scan.nextInt();


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


            String[] splits = null;
            ArrayList<String> str = new ArrayList<String>();
            for (int i = 0; i < sb.length() / m; i++) {

                if (start == -1) {
                    for (int j = i * m; j < (i + 1) * m; j++) {  //처음
                        if (sb.charAt(j) != '0') {
                            start = j;
                            break;
                        }
                    }
                }
                if (start != -1 ) { //존재할때만실행

                    for (int k = m * (i + 1); k >= i * m; k--) {  //끝부터
                        if (sb.charAt(k) != '0') {
                            end = k + 1;
                            if (sb.substring(start, end).indexOf("0000") != -1) { //빈공백존재시
                                splits = sb.substring(start, end).split("0000");


                                for (String input : splits) {
                                    input = input.replace("0", "");

                                    if (str.indexOf(input) == -1) {//없는암호시 실행
                                        str.add(input);
                                    }
                                }
                            } else {
                                if (str.indexOf(sb.substring(start, end)) == -1)//없는암호시 실행
                                    str.add(sb.substring(start, end));
                            }


                            start = -1;
                            end = -1;
                            break;


                        }
                    }
                }
            }

             code0 = arrsb.get(0);
             code1 = arrsb.get(1);
             code2 = arrsb.get(2);
             code3 = arrsb.get(3);
             code4 = arrsb.get(4);
             code5 = arrsb.get(5);
             code6 = arrsb.get(6);
             code7 = arrsb.get(7);
             code8 = arrsb.get(8);
             code9 = arrsb.get(9);

            for (String s : str) {

                if(s.length()<15)
                    continue;

                int size = (s.length()+3) / 14;
                StringBuilder hexstring = new StringBuilder(); //바이너리로 변환
                if (size > 1) {  //길이에따른 암호문
                    for (int i = code0.length()-1; i >= 0; i --) {
                        for (int k =1; k<size; k++) {
                            code0.insert(i, code0.charAt(i));
                            code1.insert(i, code1.charAt(i));
                            code2.insert(i, code2.charAt(i));
                            code3.insert(i, code3.charAt(i));
                            code4.insert(i, code4.charAt(i));
                            code5.insert(i, code5.charAt(i));
                            code6.insert(i, code6.charAt(i));
                            code7.insert(i, code7.charAt(i));
                            code8.insert(i, code8.charAt(i));
                            code9.insert(i, code9.charAt(i));


                        }
                    }
                }

                for(int i=0; i<size; i++){
                    hexstring.append("000");  //비율에맞춰 앞의 0추가
                }
                int len = s.length();

                if(len>15){
                    for(int i=0; i<len/15+1; i++) {
                        if (i == len / 15) {

                            hexstring.append(Long.toBinaryString(Long.parseLong(s.substring(i * 15 , len), 16)));
                            break;
                        } else {
                            hexstring.append(Long.toBinaryString(Long.parseLong(s.substring(i * 15, (i + 1) * 15), 16)));

                        }
                    }

                }else
                    hexstring.append(Long.toBinaryString(Long.parseLong(s, 16)));



                    int index =0;
                    int temp;
                   for(int j=0; j<hexstring.length(); j++){
                       if(j >= hexstring.length() - size*7 )
                           break;
                       temp=-1;
                      if(hexstring.substring(j, j+size+7).equals(code0.toString())){
                          temp =0;
                       }else if(hexstring.substring(j, j+size*7).equals(code1.toString())){
                           temp =1;
                       }else if(hexstring.substring(j, j+size*7).equals(code2.toString())){
                           temp =2;
                       }else if(hexstring.substring(j, j+size*7).equals(code3.toString())){
                           temp =3;
                       }else if(hexstring.substring(j, j+size*7).equals(code4.toString())){
                           temp =4;
                       }else if(hexstring.substring(j, j+size*7).equals(code5.toString())){
                           temp =5;
                       }else if(hexstring.substring(j, j+size*7).equals(code6.toString())){
                           temp =6;
                       }else if(hexstring.substring(j, j+size*7).equals(code7.toString())){
                           temp =7;
                       }else if(hexstring.substring(j, j+size*7).equals(code8.toString())){
                           temp =8;
                       }else if(hexstring.substring(j, j+size*7).equals(code9.toString())) {
                           temp = 9;
                       }
                       if(temp != -1) {

                           j += size*7-1;
                           if (index % 2 == 0) //짝수
                           {
                               evensum += temp;
                           } else {
                               oddsum += temp;
                           }
                           index++;
                           if (index == 8 * size) {
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