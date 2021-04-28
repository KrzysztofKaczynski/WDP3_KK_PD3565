/**
 * @author Kaczyński Krzysztof PD3565
 */

package zad3;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String fname = System.getProperty("user.home") + "/pakiety.txt";
        try {
            Scanner scan = new Scanner(new File(fname));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


        int megabit = 1048576;

        int sizeOfFirstPackage = 1;
        int odczytane = 0;
        int freeSpace = odczytane * megabit;
        int sizeOfNextPackage = sizeOfFirstPackage;
        int usedSpace = 0;
        int nr = 0;
        while (usedSpace + sizeOfNextPackage <= freeSpace) {
            usedSpace += sizeOfNextPackage;
            if (nr < 4) {
                sizeOfNextPackage *= 2;
            } else {
                sizeOfNextPackage *= 3;
            }
            nr++;
        }
    }
}
