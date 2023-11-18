import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

class Tester {

    public static List<Integer> removeDuplicates(List<Integer> list) {
        HashSet<Integer> set = new HashSet<Integer>();

        Iterator<Integer> it = list.iterator();

        while (it.hasNext()) {
            Integer i = it.next();

            if (set.contains(i))
                it.remove();
            else
                set.add(i);
        }
        ;
        return list;
    }

    public static void main(String args[]) {
        List<Integer> list = new LinkedList<Integer>();
        list.add(10);
        list.add(15);
        list.add(21);
        list.add(15);
        list.add(10);

        List<Integer> updatedList = removeDuplicates(list);

        System.out.println("Linked list without duplicates");
        for (Integer value : updatedList) {
            System.out.print(value + " ");
        }
    }

}