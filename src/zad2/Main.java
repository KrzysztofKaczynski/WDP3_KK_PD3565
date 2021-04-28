/**
 * @author Kaczyński Krzysztof PD3565
 */

package zad2;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String fname = System.getProperty("user.home") + "/tab.txt";
        List<String> arrayList = new ArrayList<>();
        FileReader reader;
        try {
            reader = new FileReader(fname);
            Scanner scanner = new Scanner(reader);
            while (scanner.hasNext()) {
                String number = scanner.next();
                try {
                    Long d = Long.parseLong(number);
                } catch (NumberFormatException exception) {
                    System.out.println("***");
                    System.exit(0);
                }
                arrayList.add(number);
            }
        } catch (FileNotFoundException e) {
            System.out.println("***");
            System.exit(0);
        }
        long[] tab = new long[arrayList.size()];
        for (int i = 0; i < tab.length; i++) {
            tab[i] = Long.parseLong(arrayList.get(i));
            System.out.print(tab[i] + " ");
        }
        System.out.println();
        long max = tab[0];
        for (int i = 1; i < tab.length; i++) {
            if (max < tab[i])
                max = tab[i];
        }
        System.out.println(max);
        for (int i = 0; i < tab.length; i++) {
            if (max == tab[i])
                System.out.print(i + " ");
        }
    }
}
