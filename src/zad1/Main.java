/**
 * @author Kaczyński Krzysztof PD3565
 */

package zad1;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String fname = System.getProperty("user.home") + "/iter.txt";

        try {
            Scanner scan = new Scanner(new File(fname));
            int start = scan.nextInt(), end = scan.nextInt(), limit = scan.nextInt();
            if (end < start) {
                System.out.println("***");
            } else if (start == end) {
                System.out.println(start);
            } else {

                int suma = 0;
                for (int i = start; i <= end; ++i) {
                    suma += i;
                    if (suma >= limit) {
                        break;
                    }
                }

                System.out.println(suma);
            }
        } catch (FileNotFoundException exc) {
            System.out.println("***");
            System.exit(0);
        }

    }
}
