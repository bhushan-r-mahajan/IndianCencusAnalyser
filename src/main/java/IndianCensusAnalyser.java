import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class IndianCensusAnalyser {

    public long getCount(String filepath) throws CustomException {
        long entries;
        Path path = Paths.get(filepath);
        try {
                entries = Files.lines(path).count();
        } catch (IOException e) {
            throw new CustomException("The File Path is Not Correct!!");
        }
        System.out.println("The number of Records in the File is: " + entries);
        return entries;
    }
}
