import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class IndianCensusAnalyser {
    public long getCount(String filepath) {
        long entries = 0;
        Path path = Paths.get(filepath);
        try {
            if(path.isAbsolute()) {
                entries = Files.lines(path).count();
            } else {
                throw new CustomException("The File Path is Not Correct!!");
            }
        } catch (CustomException | IOException e) {
            e.printStackTrace();
        }
        System.out.println("The number of Records in the File is: " + entries);
        return entries;
    }
}
