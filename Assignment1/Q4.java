
/*
Create an ArrayList which will be able to store only numbers like int,float,double,etc, but not any other data type.
*/














package Assignment1;

import java.util.ArrayList;
import java.util.List;

class MyArrayList<E> extends ArrayList<E>{

    public boolean add(E e) {
        if (e instanceof Integer || e instanceof Float || e instanceof Double) {
            super.add(e); // understand this comment
            return true;
        }
        else{
            throw new ClassCastException("Only Integer, Float and Double are allowed");
        }
    }
}

public class Q4 {
    public static void main(String[] args) {
        List<Object> list = new MyArrayList<>();
        try {
            list.add(1515);
            list.add(11.2F);
            list.add(3.141545D);
        }
        catch (Exception e){
            e.printStackTrace();
        }

        System.out.println(list);
    }
}
