import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by thook on 10/7/15.
 */
public class HamletParser {

    private String hamletData;

    public HamletParser(){
        this.hamletData = loadFile();
    }

    private String loadFile(){
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("hamlet.txt").getFile());
        StringBuilder result = new StringBuilder("");

        try(Scanner scanner = new Scanner(file)){
            while(scanner.hasNextLine()){
                String line = scanner.nextLine();
                result.append(line).append("\n");
            }

            scanner.close();

        }catch(IOException e){
            e.printStackTrace();
        }

        return result.toString();
    }

    public String getHamletData(){
        return hamletData;
    }

    public List<Integer> findText(String text) {

        List<Integer> indexes = new ArrayList<>();

        Pattern pattern = Pattern.compile(text,Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(this.hamletData);

        while(matcher.find()) {
            indexes.add(matcher.start());
        }

        return indexes;
    }
    public String replaceText(String text, String replaceText) {
        StringBuilder sb = new StringBuilder();
        List<Integer> indexs = findText(text);
        int startIndex = 0;
        for(int index : indexs) {
            sb.append(this.hamletData.substring(startIndex, index));
            sb.append(replaceText);
            startIndex = index + text.length();
        }
        if(startIndex < this.hamletData.length()-1) {
            sb.append(this.hamletData.substring(startIndex));
        }
        return sb.toString();
    }

}
