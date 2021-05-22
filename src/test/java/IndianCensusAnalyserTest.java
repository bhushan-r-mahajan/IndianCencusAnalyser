import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class IndianCensusAnalyserTest {

    public static String IndianCensusCSV = "C:\\Users\\bhush\\IdeaProjects\\IndianCensusAnalyser\\src\\main\\resources\\IndiaStateCensusData.csv";
    public static String IncorrectPath = "C:\\Users\\bhush\\IdeaProjects\\IndianCensusAnalyser\\src\\test\\resources\\IndiaStateCensusData.csv";
    public static String IndianCensus = "C:\\Users\\bhush\\IdeaProjects\\IndianCensusAnalyser\\src\\main\\resources\\IndiaStateCensusData";


    @Test
    void givenCSVFile_CheckIfTheNumberOfEntriesMatches() throws CustomException, IOException {
        IndianCensusAnalyser indianCensusAnalyser = new IndianCensusAnalyser();
        long result = indianCensusAnalyser.getCount(IndianCensusCSV);
        Assertions.assertEquals(30, result);
    }

    @Test
    void givenIncorrectPath_ShouldThrowCustomException() {
        IndianCensusAnalyser indianCensusAnalyser = new IndianCensusAnalyser();
        Assertions.assertThrows(CustomException.class, () -> { indianCensusAnalyser.getCount(IncorrectPath); } );
    }

    @Test
    void givenIncorrectFileName_ShouldThrowCustomException() {
        IndianCensusAnalyser indianCensusAnalyser = new IndianCensusAnalyser();
        Assertions.assertThrows(CustomException.class, () -> { indianCensusAnalyser.getCount(IndianCensus); } );
    }
}
