import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import parsing.Parser;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ArithParserTests {

    @ParameterizedTest
    @CsvFileSource(resources = "/oracleExpressions.csv", numLinesToSkip = 1)
    void testExpressionsFromCSV(
        String input, Double expected) {
        Double actualValue = Parser.parse(input).evaluate();
        assertEquals(expected, actualValue);
    }
}
