/*
Determine if a word or phrase is an isogram.
An isogram (also known as a "nonpattern word") is a word or phrase without a repeating letter, however spaces and hyphens are allowed to appear multiple times.
Examples of isograms:
lumberjacks
background
downstream
six-year-old
The word isograms, however, is not an isogram, because the s repeats.
*/

package Assign2;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Q8 {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {

        String inputString = null;

        System.out.println("Enter the String: ");
        inputString = userInput();

        Boolean isIsogram = checkIsIsogram(inputString);
        if(isIsogram) {
            System.out.println("The given input string is an Isogram");
        } else {
            System.out.println("The given input String is not an Isogram");
        }
    }
    private static Boolean checkIsIsogram(String inputString) {
        String[] arr = inputString.split("");
        Set<String> set = new HashSet<String>(Arrays.asList(arr));
        return inputString.length() == set.size();
     }
     private static String userInput() {
        String str = sc.nextLine();
        return str;
     }

}
