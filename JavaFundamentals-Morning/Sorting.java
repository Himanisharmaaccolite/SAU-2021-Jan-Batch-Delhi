import java.util.*;
class Sorting {

    public static void printList(ArrayList<Integer> list) {
        for(Integer i : list) {
            System.out.print(i+" ");
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        ArrayList<Integer> list=new ArrayList<Integer>();
        Scanner sc=new Scanner(System.in);
        int n;

        System.out.println("Enter the number of elements:");
        n=sc.nextInt();

        System.out.println("Enter the elements now:");
        for(int i=0;i<n;i++) {
            list.add(sc.nextInt());
        }

        System.out.println("Before Sorting:");
        printList(list);

        Collections.sort(list);

        System.out.println("After Sorting:");
        printList(list);
        

    }
}