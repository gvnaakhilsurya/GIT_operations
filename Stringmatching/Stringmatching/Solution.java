import java.util.Scanner;
import java.io.FileReader;
import java.util.Map;
import java.util.HashMap;
import java.io.File;
import java.io.IOException;

/**
 * Class for files.
 */
class Files {
    /**
     * Constructs the object.
     */
    Files() {
    }
   /**
    * { filters files  }.
    *
    * @param      file         The file
    *
    * @return     { returns filtered file }
    *
    * @throws     IOException  { exception }
    */
    public static String file(final File file) throws IOException {
        String str = "";
            Scanner input = new Scanner(new FileReader(file));
            StringBuilder text = new StringBuilder();
            while (input.hasNext()) {
                text.append(input.next());
                text.append(" ");
            }
            input.close();
            str = text.toString();
        return str;
    }
    /**
     * { filters and counts }.
     *
     * @param      text  The text
     *
     * @return     { returns the hash map }
     */
    public Map filter(final String text) {
        text.toLowerCase();
        text.replaceAll("[0-9_]", "");
        String[] words = text.split(" ");
        Map<String, Integer> map = new HashMap<>();
        for (String e : words) {
         if (e.length() > 0) {
            if (!(map.containsKey(e))) {
                map.put(e, 1);
            } else {
                map.put(e, map.get(e) + 1);
            }
        }
    }
        return map;
    }
    /**
     * { largest common sub string  }.
     *
     * @param      file1  The file 1
     * @param      file2  The file 2
     *
     * @return     { return_value the percentage of two files}
     */
    public double lcs(final String file1, final String file2) {
        int file1len = file1.length();
        int file2len = file2.length();
        final int num = 100;

        double tlen = file1len + file2len;
        int max = 0;
        double lcs = 0;
        int[][] array = new int[file1len][file2len];
        for (int i = 0; i < file1len; i++) {
            for (int j = 0; j < file2len; j++) {
                if (file1.charAt(i) == file2.charAt(j)) {
                    if (i == 0 || j == 0) {
                        array[i][j] = 1;
                    } else {
                        array[i][j] = array[i - 1][j - 1] + 1;
                    }
                    if (max < array[i][j]) {
                        max = array[i][j];
                    }
                }
            }
        }
        lcs = (((max * 2) / tlen) * num);
        return lcs;
    }
}
/**
 * { Solution class }.
 */
public final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {
      //empty.
    }
    /**
     * { main function }.
     *
     * @param      args         The arguments
     *
     * @throws     IOException  { exception }
     */
    public static void main(final String[] args) throws IOException {
        try  {

        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();

        File f = new File(input);
        Files obj = new Files();
        File[] arrayf = f.listFiles();
        int length = arrayf.length;
        double maxValue = 0;
        final int num = 100;
        String result = "";
        double[][] mat = new double[length][length];
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (i == j) {
                    mat[i][j] = num;
                } else {
                    mat[i][j] = obj.lcs(
                        obj.file(arrayf[i]), obj.file(arrayf[j]));
                    if (maxValue < mat[i][j]) {
                        maxValue = mat[i][j];
                        result = "Maximum similarity is between "
                        + arrayf[i].getName() + " and "
                        + arrayf[j].getName();
                    }
                }
            }
        }
        System.out.print("      \t");
        for (int i = 0; i < length - 1; i++) {
            System.out.print("\t" + arrayf[i].getName());
        }
        System.out.println("\t" + arrayf[length - 1].getName());
        for (int i = 0; i < length; i++) {
            System.out.print(arrayf[i].getName() + "\t");
            for (int j = 0; j < length; j++) {
                    System.out.print(String.format(
                        "%.1f", mat[i][j])+" " +"%"+ "\t" + "\t");
            }
            System.out.println();
        }
/* Whenever any empty files are there it prints the following exception.*/
     System.out.println(result);
    } catch (Exception e) {
        System.out.println("Empty Directory");
    }
    }
}
