import java.util.ArrayList;
import java.util.Scanner;

public class sw_1248 {
    static ArrayList<Integer> al;
    static int parent;
    static int subcount;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int count = 1;
        int t = scan.nextInt();

        Node tree[];

        while (t > 0) {
            int v = scan.nextInt(); //정점
            int e = scan.nextInt(); //간선
            tree = new Node[v + 1];  //1~v의 인덱스사용
            parent=-1;
            subcount = 1;
            for (int i = 1; i < v + 1; i++) {
                tree[i] = new Node(i);
            }

            int num1 = scan.nextInt();
            int num2 = scan.nextInt();

            for (int i = 0; i < e; i++) {  //트리구성
                int root = scan.nextInt();
                int sub = scan.nextInt();
               // System.out.println(root + ", " + sub);
                if (tree[root].left == null) {
                    tree[root].left = tree[sub];
                    tree[sub].root = tree[root];
                } else {
                    tree[root].right = tree[sub];
                    tree[sub].root = tree[root];
                }
            }

            al = new ArrayList<Integer>();


            search(tree[num1]);

            search(tree[num2]);

            subtree(tree[parent]);

            System.out.println("#"+count+" "+parent+" "+subcount);
            count++;
            t--;
        }
    }

    static void search(Node node){  //부모찾기
       if(node.root == null )
           return ;
       if(al.contains(node.root.value)){
           parent = node.root.value;
           return;
       }

       al.add(node.root.value);
       //System.out.println(node.root.value);
       search(node.root);
    }

    static void subtree(Node node){   //서브트리개수(자식정점개수찾기)
        if(node.left == null && node.right == null){
            return;
        }
        if(node.left != null) {
            subtree(node.left);
            subcount++;
        }
        if(node.right != null) {
            subtree(node.right);
            subcount++;
        }
    }

    static class Node{
        Node root;
        Node left;
        Node right;
        int value;
        Node(int n){
            value = n;
        }
    }
}
