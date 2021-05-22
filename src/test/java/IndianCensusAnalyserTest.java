import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class IndianCensusAnalyserTest {

    public static String IndianCensusCSV = "C:\\Users\\bhush\\IdeaProjects\\IndianCensusAnalyser\\src\\main\\resources\\IndiaStateCensusData.csv";

    @Test
    void givenCSVFile_CheckIfTheNumberOfEntriesMatches() {
        IndianCensusAnalyser indianCensusAnalyser = new IndianCensusAnalyser();
        long result = indianCensusAnalyser.getCount(IndianCensusCSV);
        Assertions.assertEquals(30, result);
    }
}
