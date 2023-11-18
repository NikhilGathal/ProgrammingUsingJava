import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

class Tester {

    public static List<String> sortSales(Map<String, Integer> sales) {
        // Implement your logic here and change the return statement accordingly

        List<Entry<String, Integer>> unsoretdMapList = new ArrayList<Entry<String, Integer>>();
        unsoretdMapList.addAll(sales.entrySet());
        Collections.sort(unsoretdMapList, new Comparator<Entry<String, Integer>>() {

            @Override
            public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
                // TODO Auto-generated method stub
                if (o1.getValue() > o2.getValue())
                    return -1;
                else if (o1.getValue() <= o2.getValue())
                    return 1;
                return 0;
            }
        });

        List<String> list = new ArrayList<String>();
        for (Entry<String, Integer> e : unsoretdMapList) {
            list.add(e.getKey());
        }

        return list;
    }

    public static void main(String args[]) {
        Map<String, Integer> sales = new HashMap<String, Integer>();
        sales.put("Mathew", 50);
        sales.put("Lisa", 76);
        sales.put("Courtney", 45);
        sales.put("David", 49);
        sales.put("Paul", 49);

        List<String> employees = sortSales(sales);

        System.out.println("Employees in the decreasing order of their sales\n=====================================");
        for (String employeeName : employees) {
            System.out.println(employeeName);
        }
    }

}