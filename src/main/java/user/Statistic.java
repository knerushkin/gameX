package user;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by ekanner on 2017-03-23.
 */
public class Statistic {

    List<Integer> countResult;

    Statistic() { countResult = new ArrayList<>(); }

    public void update(int sample) {
        countResult.add(sample);
    }

    public String toString() {
        long last = countResult.stream().count();
        double total = (double) countResult.stream().mapToInt(Integer::intValue).sum();
        return  "Totoal: " + total  + ", Average " + total / last ;
    }
}
