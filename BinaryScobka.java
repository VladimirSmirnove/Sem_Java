
import java.io.*;
import java.util.*;
 
class BinaryTreesSkobka{
     
static class Node
{
    int data;
    Node left,right;
     
    Node(int data)
    {
        this.data = data;
        this.left = this.right = null;
    }
}
 
static int start = 0;
 static Node constructTree(String s)
{
    if (s.length() == 0 || s == null)
    {
        return null;
    }
     
    if (start >= s.length())
        return null;
     
    boolean neg = false;
    if (s.charAt(start) == '-')
    {
        neg = true;
        start++;
    }
    int num = 0;
    while (start < s.length() &&
           Character.isDigit(s.charAt(start)))
    {
        int digit = Character.getNumericValue(
            s.charAt(start));
        num = num * 10 + digit;
        start++;
    }
    if (neg)
        num = -num;
    Node node = new Node(num);
     
    if (start >= s.length())
    {
        return node;
    }
    if (start < s.length() && s.charAt(start) == '(' )
    {
        start++;
        node.left = constructTree(s);
    }
     
    if (start < s.length() && s.charAt(start) == ')')
    {
        start++;
        return node;
    }
    if (start < s.length() && s.charAt(start) == '(')
    {
        start++;
        node.right = constructTree(s);
    }
     
    if (start < s.length() && s.charAt(start) == ')')
    {
        start++;
        return node;
    }
    return node;
}
public static void printTree(Node node, String space)
{
    if (node == null)
        return;
   
    System.out.printf("%s%s\n", space, node.data);
    printTree(node.left, space + " ");
    printTree(node.right, space + " ");
}
public static void main(String[] args)
{
    String s = "4(2(3)(1(10)))(6(5))";
    Node root = constructTree(s);
    printTree(root,  " ");
}
}
 
