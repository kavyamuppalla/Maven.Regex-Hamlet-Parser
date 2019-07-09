import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class HamletParserTest {
    private String hamletText;
    private HamletParser hamletParser;

    @Before
    public void setUp() {
        this.hamletParser = new HamletParser();
        this.hamletText = hamletParser.getHamletData();
    }

    @Test
    public void testChangeHamletToLeon() {
        String str = this.hamletParser.replaceText("Hamlet", "Leon");
        System.out.println(str);
        Assert.assertFalse(str.contains("Hamlet"));
        Assert.assertTrue(str.contains("Leon"));
    }

    @Test
    public void testChangeHoratioToTariq() {
        String str = this.hamletParser.replaceText("Horatio","Tariq");
        Assert.assertFalse(str.contains("Horatio"));
        Assert.assertTrue(str.contains("Tariq"));
    }

    @Test
    public void testFindHoratio() {
        List<Integer> list = this.hamletParser.findText("Horatio");
        Integer expected = 158;
        Integer actual = list.size();
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void testFindHamlet() {
        List<Integer> list = this.hamletParser.findText("Hamlet");
        Integer expected = 472;
        Integer actual = list.size();
        Assert.assertEquals(expected,actual);
    }
}