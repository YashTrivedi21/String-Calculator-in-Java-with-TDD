import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringCalculatorTest {

    StringCalculator tst;
    @BeforeEach
    void setUp() {
        tst = new StringCalculator();
    }

    @Test
    public void singleNumberTest() {
        assertEquals(tst.add("2"), 2);
    }

    @Test
    public void emptyStringTest() {
        assertEquals(tst.add(""), 0);
    }

    @Test
    public void multiDigitsTest() {
        assertEquals(tst.add("420,69"), 489);
    }

    @Test
    public void twoNumbersTest() {
        assertEquals(tst.add("4,9"), 13);
    }

    @Test
    public void unknownAmountOfNumbersTest(){
        assertEquals(tst.add("10,20,30,40,50,60,70"),280);
    }

    @Test
    public void newLineCharacterTest1(){
        assertEquals(tst.add("30\n40,50"),120);
    }

    @Test
    public void supportForCustomDelimiter() {
        assertEquals(233, tst.add("//;\n123;29;37;44"));
    }

    @Test
    public void negativeNotAllowedTest() {
        try {
            tst.add("-1,2");
        }
        catch (IllegalArgumentException e){
            assertEquals(e.getMessage(), "Negatives not allowed -1");
        }
        try {
            tst.add("2,-4,3,-5");
        }
        catch (IllegalArgumentException e){
            assertEquals(e.getMessage(), "Negatives not allowed -4,-5");
        }
    }

    @Test
    public void moreThanThousandNumberTest(){
        assertEquals(1090,tst.add("20,30,40,1000,10100"));
    }
}
