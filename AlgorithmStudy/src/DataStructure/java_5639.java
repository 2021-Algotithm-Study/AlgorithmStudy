//5639 이진검색트리(Silver 1)
import java.io.*;

public class java_5639 {
    static StringBuilder sb = new StringBuilder();
    static Node root;

    static class Node{
        Node left;
        Node right;
        int val;
        public Node(int val){
            this.val = val;
        }
    }

    static void insert(Node n, int v){
        if(n.val < v){
            if(n.right == null) n.right = new Node(v);
            else                insert(n.right, v);
        }else{
            if(n.left == null)  n.left = new Node(v);
            else                insert(n.left, v);
        }
    }

    static void postOrder(Node n){
        if(n == null)   return;
        postOrder(n.left);
        postOrder(n.right);
        sb.append(n.val + "\n");
    }

    public static void main(String[] args) throws Exception{
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader("test.txt"));
        String line;
        root = new Node(Integer.parseInt(br.readLine())); 
        while((line = br.readLine()) != null)
            insert(root, Integer.parseInt(line));
        postOrder(root);
        System.out.print(sb);
        br.close();
    }
}
