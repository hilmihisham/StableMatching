
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * - COMP 482 Project #1
 * - Stable Matching algorithm
 * - Determining whether the match is stable and if not give one instability.
 *
 * @author Muhammad Hilmi Badrol Hisham
 */
public class Project1 {

    public static void main(String[] args) throws FileNotFoundException {

        // initializing input file and scanner
        // get the directory where the .class file is at : System.getProperty("java.class.path")
        String inputpath = System.getProperty("java.class.path") + "\\input1.txt";
        System.out.println("input1.txt path : " + inputpath);
        File file = new File(inputpath);
        Scanner scan = new Scanner(file);

        // number of men/women involved
        int human;

        // holds the result whether the matching is stable or not
        boolean flag = true;

        // String holding the instability result
        String instability = "";

        // scan the first line in the txt file, put into human
        human = Integer.parseInt(scan.nextLine());
        System.out.println("Number of men/women : " + human);

        // creating 2D array of men's and women's preferences
        // menlist[man name][rank]
        // womenlist[woman name][rank]
        int menlist[][] = new int[human+1][human+1];
        int womenlist[][] = new int[human+1][human+1];

        // reading the rest of the txt file and put into both menlist[][] and womenlist[][]
        for (int i = 1; i <= human; i++) {
            for (int j = 1; j <= human; j++)
                menlist[i][j] = scan.nextInt();
        }

        for (int i = 1; i <= human; i++) {
            for (int j = 1; j <= human; j++)
                womenlist[i][j] = scan.nextInt();
        }

        // preprocessing womenlist[][] here
        // processedWomenList[woman name][man name]
        // data inside is the man's rank by woman's preferences
        int processedWomenList[][] = new int[human+1][human+1];

        for (int i = 1; i <= human ; i++) {
            for (int j = 1; j <= human ; j++) {
                int k = womenlist[i][j];
                processedWomenList[i][k] = j;
            }
        }

        // reading the last line of the txt file and put into processedWomanList[woman][0]
        // this column 0 holds the man's name that the woman (row index) got matched to
        for (int man = 1; man <= human; man++) {
            int woman = scan.nextInt();
            processedWomenList[woman][0] = man;
        }

        // now check if the instance is stable or not
        // go through menlist[][], getting the man to propose to the woman
        // man (from outerloop) is man's name
        // j (from innerloop) is women's rank in men's list
        outerloop:
        for (int man = 1; man <= human ; man++) {
            for (int j = 1; j <= human; j++) {

                // menlist[man][j] is the woman's name
                // pairedMan is the woman's current pair (man's name)
                int woman = menlist[man][j];
                int pairedMan = processedWomenList[woman][0];

                // we're checking the stability by men's ranking, from best to worst
                // if the pairedMan (woman's current pair) is this same man, then he got his best possible choice
                if (man == pairedMan)
                    break;

                // else if proposing man has lower value (better rank), than it's not stable
                // (processedWomenList[woman][man] will get us the ranking of this proposing man)
                // (processedWomanList[woman][pairedMan] will get us her current man's ranking in her list)
                else if (processedWomenList[woman][man] < processedWomenList[woman][pairedMan]) {
                    instability = man + ", " + woman;
                    flag = false;
                    break outerloop;
                }
                // if the proposing man ranked lower than the woman that he proposing, then he just gonna propose his
                // next preference
            }
        }

        // printing out result
        if (flag)
            System.out.println("Yes, matching is stable!");
        else
            System.out.println("No. (" + instability + ")");
    } // end main
} // end class