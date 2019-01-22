
import java.util.Scanner;
public class snailArray {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("배열넓이: ");
        int n = scan.nextInt();
        int temp = n;
        int arr[][] = new int[n][n];

        int row = 0, col=0; //행, 렬
        int sw = 1; // 증가와 감소 전환
        int num = 1; // 들어갈숫자

        while(true){

            for(int i = 0; i<n; i++){
                arr[row][col] = num++;      //  ->,  <-방향
                col += sw;
            }
            col -= sw;   //한번더 +나 -된것 처리
            row += sw;   //현재행은 이미 계산됫으므로 다음행부터시작하도록
            n--;
            if(n==0)
                break;
            for(int j= 0; j< n; j++){      // 위, 아래방향
                arr[row][col] = num++;
                row += sw;
            }

            sw *= -1;
            row += sw;       //한번더 +나 -된것 처리
            col += sw;       //현재열은 이미 계산됫으므로 다음열부터시작하도록
        }

        for (int i=0; i<temp; i++){
            for (int j=0; j<temp; j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }


    }
}


//달팽이배열