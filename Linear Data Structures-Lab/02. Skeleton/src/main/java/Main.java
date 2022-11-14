import implementations.ArrayList;

import java.sql.SQLOutput;

public class Main {
    public static void main(String[] args) {


        ArrayList<String> list = new ArrayList<>();
        list.add("1");
        list.add("two");
        list.add(1,"test");
        list.add("5");
        list.add(3,"lastAdded");

        System.out.println(list.get(0));
        System.out.println(list.get(1));
        System.out.println(list.get(2));
        System.out.println(list.get(3));
        System.out.println(list.get(4));
        System.out.println("----");
        list.remove(4);
        System.out.println(list.get(0));
        System.out.println(list.get(1));
        System.out.println(list.get(2));
        System.out.println(list.get(3));
        System.out.println("----");
        list.remove(0);
        System.out.println(list.get(0));
        System.out.println(list.get(1));
        System.out.println(list.get(2));

    }
}
