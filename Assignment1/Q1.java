/*
1. Develop a java class with a method saveEvenNumbers(int N) using ArrayList to store even numbers from 2 to N, where N is an integer which is passed as a parameter to the method saveEvenNumbers().
The method should return the ArrayList (A1) created. 
In the same class create a method printEvenNumbers() which iterates through the arrayList A1 in step 1, and It should multiply each number with 2 and display it in format 4,8,12….2*N. and add these numbers in a new ArrayList (A2). 
The new ArrayList (A2) created needs to be returned.  Create a method printEvenNumber(int N) parameter is a number N. 
This method should search the arrayList (A1) for the existence of the number ‘N’ passed. If it exists it should return the Number else return zero.Hint: Use instance variable for storing the ArrayList A1 and A2. 
NOTE: You can test the methods using a main method.
*/

import java.util.ArrayList;

public class Q1 {
    static ArrayList<Integer> arrList = new ArrayList<Integer>();
    public static ArrayList<Integer> saveEvenNumber(int N) {

        for (int i=2; i<N; i++) {
            if(i%2==0) {
                arrList.add(i);
            }
        }
        return arrList;
    }

    public static ArrayList<Integer> printEvenNumbers() {
        ArrayList<Integer> arrList2 = new ArrayList<Integer>();

        for (int item: arrList) {
            arrList2.add(item * 2);
            System.out.println(item * 2);
        }
        return arrList2;
    }

    public static void main (String[] args ) {
        System.out.println("Lets Print the numbers");
        saveEvenNumber(10);
        printEvenNumbers();
    }
}
