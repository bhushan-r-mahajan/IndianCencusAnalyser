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
        } catch (IOException e) {
            throw new CustomException(e.getMessage(), CustomException.ExceptionType.NO_EXTENTION_FOUND);
        } catch (RuntimeException e) {
            throw new CustomException(e.getMessage(), CustomException.ExceptionType.WRONG_FILE_CONTENT);
        }
    }

    public static int loadWrongCensusData(String filePathCSV) throws CustomException {
        if (!filePathCSV.contains(".csv"))
            throw new CustomException("This is invalid file type", CustomException.ExceptionType.WRONG_FILE_TYPE);
        try (Reader reader = Files.newBufferedReader(Paths.get(filePathCSV))) {
            CsvToBean<IndiaCensusCSV> csvToBean = new CsvToBeanBuilder<IndiaCensusCSV>(reader)
                    .withType(IndiaCensusCSV.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();
            Iterator<IndiaCensusCSV> indiaCensusCSVIterator = csvToBean.iterator();
            Iterable<IndiaCensusCSV> censusCSVIterable = () -> indiaCensusCSVIterator;
            return (int) StreamSupport.stream(censusCSVIterable.spliterator(), false).count();
        } catch (IOException e) {
            throw new CustomException(e.getMessage(), CustomException.ExceptionType.NO_EXTENTION_FOUND);
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
        } catch (Exception e) {
            throw new CustomException(e.getMessage(), CustomException.ExceptionType.NO_EXTENTION_FOUND);
        }
    }
}
