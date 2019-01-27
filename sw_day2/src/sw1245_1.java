import java.util.ArrayList;
import java.util.Scanner;

public class sw1245_1 {



    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayList<Integer> x;
        ArrayList<String> f;
        ArrayList<Integer> m;

        int t = scan.nextInt();
        int count =1;

        while(t>0){
            int n = scan.nextInt();

            x = new ArrayList<Integer>();
            m = new ArrayList<Integer>();
            f = new ArrayList<String>();

            for(int i =0; i<n; i++){
                x.add(scan.nextInt());
            }
            for(int i =0; i<n; i++) {
                m.add(scan.nextInt());
            }

            for(int i=0; i<n-1; i++){
                double a= x.get(i);
                double b= x.get(i+1);
                double cb = (a+b)/2.0;
                double left = 0;
                double right = 0;

                for(int k =0;; k++) {
                    double val1 = 0;
                    double val2 = 0;

                    // System.out.println("i: " + i + " a: " + a + " b: " + b + " cb: " + cb);

                    for (int j = 0; j < n; j++) {
                        double temp = cb;
                        double pos = x.get(j);
                        if (pos < cb) {
                            val1 += (double) m.get(j) / Math.pow(temp - pos, 2); //왼쪽인력
                            continue;
                        } else {
                            val2 += (double) m.get(j) / Math.pow(pos - temp, 2);//오른쪽인력
                            continue;
                        }
                    }

                     //System.out.println(val1);
                    // System.out.println(val2);

                    //오차범위
                    if (val2 - 0.0000000000001f <= val1 && val1 <= val2 + 0.0000000000001f || k>10000000) {
                        f.add(String.format("%.10f", cb));
                        break;
                    }

                    double temp = cb;
                    if (val1 < val2) {   // <--이동 , 최댓값 변경
                       // cb = cb - (cb - a) / 20000
                        if(left == 0 ){
                            left = a;
                        }
                        cb = (cb+left)/2;

                        right = temp;

                    } else if (val2 < val1) {  // -->이동, 최솟값변경
                      //  cb = cb + (cb - a) / 2000000 ;
                        if(right == 0 ){
                            right = b;
                        }

                        cb = (right+cb)/2;

                        left = temp;
                    }

                }
            }
            System.out.print("#" + count);
            for(int i=0; i<f.size(); i++) {
                System.out.print(" "+f.get(i));
                //String.format("%.10f",Math.round(f.get(i)*10000000000.0)/10000000000.0)
            }
            System.out.println();
            count++;
            t--;
        }

    }
    /*static double value(int i, double a, double b, double cb) {

        double result = 0;

        System.out.println("i: " + i + " a: " + a + " b: " + b + " cb: " + cb);
        double val1 = (double) m.get(i) / Math.pow(cb - a, 2);
        double val2 = (double) m.get(i + 1) / Math.pow(b - cb, 2);

       // val1 = Double.parseDouble(String.format("%.10f", val1));
        //val2 = Double.parseDouble(String.format("%.10f", val2));
        System.out.println(val1);
        System.out.println(val2);
        if (val2 - 0.001f<= val1 && val1 <= val2 + 0.001f){
            cb = Double.parseDouble(String.format("%.10f", cb));
            return cb;
        }


        if (val1 < val2) {
            result = value(i, a, b, cb-((a+cb)/2 - a)/1000);
        } else if (val2 < val1) {
            result = value(i, a, b, ((a+cb)/2 - a)/10000+cb);
        }


        return result;
    }*/

}
