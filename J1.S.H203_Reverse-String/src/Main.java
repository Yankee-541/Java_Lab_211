/**
 *
 * @author Yankee
 */
public class Main {

    public static void main(String[] args) {
        while (true) {
            Validate v = new Validate();
            String str = v.inputString();
            System.out.print("String after reverse: ");
            v.printReverse(str);
            if(!v.checkYesNo("Do you want to reverse another string?")){
                break;
            }else{
                continue;
            }
        }
    }
}
