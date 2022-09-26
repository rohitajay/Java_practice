
/* Create an ArrayList which will be able to store only Strings. 
Create a printAll method which will print all the elements using an Iterator.
*/


package Assignment1;

import java.util.ArrayList;
import java.util.Iterator;

public class Q3 {
    static ArrayList<String> arrList = new ArrayList<String>();
    public static void printAll(){
        Iterator<String>it = arrList.iterator();
        while(it.hasNext()){
            Object obj = it.next();
            System.out.println(obj + " ");
        }
    }

    public static void main(String[] args) {
        arrList.add("A");
        arrList.add("B");
        arrList.add("C");
        arrList.add("D");
        arrList.add("E");
        printAll();
    }
}
