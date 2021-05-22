import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class IndianCensusAnalyser {

    public long getCount(String filepath) throws CustomException, IOException {
        long entries;
        Path path = Paths.get(filepath);
        if(!path.isAbsolute()) {
            throw new CustomException("The File Path is Not Correct!!");
        } else {
            entries = Files.lines(path).count();
        }
        System.out.println("The number of Records in the File is: " + entries);
        return entries;
    }
}
