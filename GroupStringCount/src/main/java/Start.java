import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.OutputStreamWriter;
import java.util.Map;
import java.util.HashSet;
import java.util.Set;

/**
 * Work class.
 */
public class Start {
    /**
     * Input file.
     */
    private String fileInpit;
    /**
     * Output file.
     */
    private String fileOutput;
    /**
     * Class count.
     */
    private Count count;
    /**
     * Group number.
     */
    private int countGroup;

    /**
     * Constructor.
     *
     * @param fileInpit  input file.
     * @param fileOutput output file.
     */
    public Start(String fileInpit, String fileOutput) {
        this.fileInpit = fileInpit;
        this.fileOutput = fileOutput;
        countGroup = 0;
        count = new Count();
    }

    /**
     * Work method.
     * Return group number.
     */
    Integer groupStringCount() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(fileInpit)));) {
            String str;
            while ((str = reader.readLine()) != null) {
                str = str.replaceAll("[\\\"]", "");
                String[] arr = str.split(";");
                if (arr.length == 3) {
                    count.searchKey(arr);           //1
                    count.addNewStringArray(arr);   //2
                    count.addStringToOut(str);      //3
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        count.getSorted_map().putAll(count.getOut());

        try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileOutput)))) {
            int groupNumber = 1;
            for (Map.Entry<Long, HashSet<String>> map : count.getSorted_map().entrySet()) {
                writer.write("Group :" + groupNumber + "\n");
                if (map.getValue().size() > 1) {
                    countGroup++;
                }
                for (String set : map.getValue()) {
                    writer.write(set + "\n");
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return countGroup;
    }

    /**
     * Start.
     *
     * @param args String array.
     */
    public static void main(String[] args) {
        long start = System.currentTimeMillis();

        //Start startCount = new Start();
        //int group = startCount.groupStringCount();

        long workTime = (System.currentTimeMillis() - start) / 1000;
        System.out.println("Work :" + workTime + "  sec");

        //System.out.println("Найдено Групп " + group);

        System.out.println();
    }
}



