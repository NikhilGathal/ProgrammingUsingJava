import java.util.Map;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;

class Student {

    public static Map<String, Double> findMaxMinScorers(Map<String, Double> studentMarks) {
        double lowValue = Double.MAX_VALUE;
        double highValue = 0;

        for (String key : studentMarks.keySet()) {
            if (studentMarks.get(key) < lowValue) {
                lowValue = studentMarks.get(key);

            }
            if (studentMarks.get(key) > highValue)
                highValue = studentMarks.get(key);
        }

        Map<String, Double> map = new HashMap<String, Double>();

        for (String key : studentMarks.keySet()) {
            if (studentMarks.get(key) == lowValue || studentMarks.get(key) == highValue) {
                map.put(key, studentMarks.get(key));

            }

        }

        return map;
    }

}

class Tester {

    public static void main(String args[]) {
        Map<String, Double> studentMarks = new HashMap<String, Double>();
        studentMarks.put("Lily", 90.0);
        studentMarks.put("Robin", 68.0);
        studentMarks.put("Marshall", 76.5);
        studentMarks.put("Neil", 67.0);
        studentMarks.put("Ted", 92.0);

        Map<String, Double> maxMinScorers = Student.findMaxMinScorers(studentMarks);

        System.out.println("Details of Top Scorers & Low Scorers\n====================================");
        for (Entry<String, Double> entry : maxMinScorers.entrySet()) {
            System.out.println(entry.getKey() + " -- " + entry.getValue());
        }

    }
}