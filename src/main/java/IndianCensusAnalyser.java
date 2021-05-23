import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.stream.StreamSupport;

public class IndianCensusAnalyser {
    public static int loadCensusData(String filePathCSV) throws CustomException {
        try (Reader reader = Files.newBufferedReader(Paths.get(filePathCSV))) {
            CsvToBean<IndiaCensusCSV> csvToBean = new CsvToBeanBuilder<IndiaCensusCSV>(reader)
                    .withType(IndiaCensusCSV.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();
            Iterator<IndiaCensusCSV> indiaCensusCSVIterator = csvToBean.iterator();
            Iterable<IndiaCensusCSV> censusCSVIterable = () -> indiaCensusCSVIterator;
            return (int) StreamSupport.stream(censusCSVIterable.spliterator(), false).count();
        } catch (IOException exception) {
            throw new CustomException(exception.getMessage(), CustomException.ExceptionType.CENSUS_FILE_PROBLEM);
        }
    }

    public static int loadCodeData(String filePathCSV) throws CustomException {
        try (Reader reader = Files.newBufferedReader(Paths.get(filePathCSV))) {
            CsvToBean<IndiaStateCodeCSV> csvToBean = new CsvToBeanBuilder<IndiaStateCodeCSV>(reader)
                    .withType(IndiaStateCodeCSV.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();
            Iterator<IndiaStateCodeCSV> indiaStateCodeCSVIterator = csvToBean.iterator();
            Iterable<IndiaStateCodeCSV> censusCSVIterable = () -> indiaStateCodeCSVIterator;
            return (int) StreamSupport.stream(censusCSVIterable.spliterator(), false).count();
        } catch (Exception exception) {
            throw new CustomException(exception.getMessage(), CustomException.ExceptionType.CENSUS_FILE_PROBLEM);
        }
    }
}
