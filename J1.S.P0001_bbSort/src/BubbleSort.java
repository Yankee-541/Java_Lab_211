
import java.util.Random;
import java.util.Scanner;
/**
 *
 * @author Yankee
 */
public class BubbleSort {

    public int checkInput() {
        int n = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of array: ");
        while (true) {
            try {
                n = Integer.parseInt(sc.nextLine());
                if (n <= 0) {
                    System.out.println("Please input positive number.");
                } else {
                    break;
                }
            } catch (Exception e) {
                System.out.println("Invalid date! Please re-input agian: ");
            }
        }
        return n;
    }

    public void initArr(int a[], int n) {
        Random r = new Random();
        //random elements
        for (int i = 0; i < n; i++) {
            a[i] = r.nextInt(n); //random từ 0-n
        }
    }

    public void display(int a[], int n, String mess) {
        System.out.print(mess);
        for (int i = 0; i < n; i++) {
            if (i == n - 1) {
                System.out.print(a[i] + "]");
            } else {
                System.out.print(a[i] + ", ");
            }
        }
    }

    public void bbsort(int a[], int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (a[j] > a[j + 1]) {
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
        }
    }
    
//check day so tang hay chua
    public int checkIncrease(int a[], int n) {
        for (int i = 0; i < n - 2; i++) {
            if (a[i] > a[i + 1]) {
                return 0;  
            }
        }
        return 1; //return ve 1 thi day so da duoc tang 
    }

    public static void main(String[] args) {
        BubbleSort bbs = new BubbleSort();
        int n = bbs.checkInput();
        int a[] = new int[n];
        bbs.initArr(a, n);
        bbs.display(a, n, "Unsorted array: [");
        int check = bbs.checkIncrease(a, n);
        if (check == 0) {
            bbs.bbsort(a, n);
        }
        bbs.bbsort(a, n);
        bbs.display(a, n, "\nSorted array: [");

    }
}
