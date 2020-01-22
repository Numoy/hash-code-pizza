import java.io.*;
import java.util.*;

public class Hashcode {
    static int target;
    static int[] values;
    static List<Integer> selected = new ArrayList<>();

    static List<Integer> solution = new ArrayList<>();
    static int missedPoints = Integer.MAX_VALUE;


    public static void main(String[] args) throws IOException {

        readFile("src/a_example.in");

        findNext(values.length - 1);

        outputSolution();

        System.out.println(selected.size());
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

    public static void readFile(String filePath) throws FileNotFoundException {
        try (Scanner scanner = new Scanner(new File(filePath),
                "UTF-8")) {
            scanner.useLocale(Locale.GERMANY);
            int i = 0;
            target = scanner.nextInt();
            values = new int[scanner.nextInt()];


            while (scanner.hasNext()) {
                values[i] = scanner.nextInt();
                i++;
            }
        }
    }

    public static void outputSolution() throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("solution.out", true))) {
            writer.append(String.valueOf(solution.size()));
            writer.append("\n");
            for (Integer number : solution) {
                writer.append(number + " ");
            }
        }
    }


}