import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class IndianCensusAnalyserTest {
    public static final String censusCSV = "src\\main\\resources\\IndianStateCensusData.csv";
    public static final String stateCodeCSV = "src\\main\\resources\\IndiaStateCode.csv";
    public static final String wrongCSV = "src\\main\\resources\\IndiaStateCode";
    public static final String wrongFileType = "src\\main\\resources\\IndiaStateCensusData.txt";
    public static final String wrongDelimiter = "src\\main\\resources\\IndiaStateCensusDataDelimiter.csv";

    @Test
    public void givenTheStateCodesCsvFile_IfHasCorrectNumberOfRecords_ShouldReturnTrue() {
        try {
            int count = IndianCensusAnalyser.loadCensusData(censusCSV);
            Assertions.assertEquals(29, count);
        } catch (CustomException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenIndianStateCodeCSVFile_ReturnsCorrectRecords_PassesTheTest() {
        try {
            int count = IndianCensusAnalyser.loadCodeData(stateCodeCSV);
            Assertions.assertEquals(37, count);
        } catch (CustomException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenIndiaStateCensusFile_WithNoCSV_ShouldThrowCustomException() {
        try {
            IndianCensusAnalyser.loadCensusData(wrongCSV);
        } catch (CustomException e) {
            System.out.println(e.type);
            Assertions.assertEquals(CustomException.ExceptionType.NO_EXTENTION_FOUND,e.type);
        }
    }

    @Test
    public void givenIndiaCensusData_WithWrongFileType_ShouldThrowException() {
        try {
            IndianCensusAnalyser.loadWrongCensusData(wrongFileType);
        } catch (CustomException e) {
            System.out.println(e.type);
            Assertions.assertEquals(CustomException.ExceptionType.WRONG_FILE_TYPE,e.type);
        }
    }

    @Test
    public void givenIndiaCensusData_WithWrongFileDelimiter_ShouldThrowException() {
        try {
            IndianCensusAnalyser.loadCensusData(wrongDelimiter);
        } catch (CustomException e) {
            System.out.println(e.type);
            Assertions.assertEquals(CustomException.ExceptionType.WRONG_FILE_CONTENT,e.type);
        }
    }
}
