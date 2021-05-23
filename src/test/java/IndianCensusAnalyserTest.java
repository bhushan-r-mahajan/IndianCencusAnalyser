import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class IndianCensusAnalyserTest {
    public static final String censusCSV = "src\\main\\resources\\IndianStateCensusData.csv";
    public static final String stateCodeCSV = "src\\main\\resources\\IndiaStateCode.csv";
    public static final String wrongCSV = "src\\main\\resources\\IndiaStateCode";

    @Test
    public void GivenTheStateCodesCsvFile_IfHasCorrectNumberOfRecords_ShouldReturnTrue() {
        try {
            int count = IndianCensusAnalyser.loadCensusData(censusCSV);
            Assertions.assertEquals(29, count);
        } catch (CustomException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenIndianStateCodeCSVFile_ReturnsCorrectRecords() {
        try {
            int count = IndianCensusAnalyser.loadCodeData(stateCodeCSV);
            System.out.println(count);
            Assertions.assertEquals(37, count);
        } catch (CustomException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenIndiaStateCensusFile_WithIncorrectFile_ShouldThrowException() {
        try {
            IndianCensusAnalyser.loadCensusData(wrongCSV);
        } catch (CustomException e) {
            Assertions.assertEquals(CustomException.ExceptionType.CENSUS_FILE_PROBLEM,e.type);
        }
    }
}
