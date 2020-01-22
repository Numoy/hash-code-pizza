import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Hashcode {
    static int target = 505000000;
    static int[] values = {

    };
    static List<Integer> selected = new ArrayList<>();

    static List<Integer> solution = new ArrayList<>();
    static int missedPoints = Integer.MAX_VALUE;


    public static void main(String[] args) {

        Scanner scanner;
        try {
            scanner = new Scanner(new File("src/test.in"),
                    "UTF-8");
            scanner.useLocale(Locale.GERMANY);
            int i = 0;
            target = scanner.nextInt();
            values = new int[scanner.nextInt()];


            while (scanner.hasNext()) {
                    values[i] = scanner.nextInt();
                    i++;
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


        findNext(values.length - 1);
        System.out.println(sumOfSelected());
        System.out.println(selected);

    }

    public static void findNext(int startIndex) {
        for (int i = startIndex; i >= 0; i--) {
            selected.add(Integer.valueOf(i));
            if (sumOfSelected() == target) {
                return;
            }


            if (sumOfSelected() < target) {
                findNext(i - 1);
            } else if (target - sumWithoutLastElement() < missedPoints) {
                solution = new ArrayList<>();
                solution.addAll(selected);
                missedPoints = target - sumWithoutLastElement();
            }

            selected.remove(selected.size() - 1);
        }
    }

    public static int sumOfSelected() {
        int sum = 0;
        for (Integer i : selected) {
            sum += values[i.intValue()];
        }
        return sum;
    }

    public static int sumWithoutLastElement() {
        int sum = 0;
        for (int i = 0; i < selected.size() - 1; i++) {
            sum += values[i];
        }
        return sum;
    }


}