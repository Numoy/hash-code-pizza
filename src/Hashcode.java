import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Hashcode {
    static int target = 100;
    static int[] values = {4,14,15,18,29,32,36,82,95,95};
    static List<Integer> selected = new ArrayList<>(100);

    static List<Integer> solution  = new ArrayList<>(100);
    static int missedPoints = Integer.MAX_VALUE;


    public static void main(String[] args) {

        findNext(values.length - 1);
        System.out.println(sumOfSelected());
        System.out.println(selected);

    }

    public static void findNext(int startIndex) {
        for (int i = startIndex; i >= 0; i-- ) {
            if( sumOfSelected() == target )
            {
                return;
            }

            selected.add(Integer.valueOf(i));
            if( sumOfSelected() < target )
                findNext(i - 1);
            else
            {
                selected.remove( selected.size() -1 );
                if ( sumOfSelected() < missedPoints )
                {
                    solution = new ArrayList<>();
                    solution.addAll(selected);
                    missedPoints = sumOfSelected();
                }
            }
        }
    }

    public static int sumOfSelected() {
        int sum = 0;
        for (Integer i : selected) {
            sum += values[i.intValue()];
        }
        return sum;
    }


}