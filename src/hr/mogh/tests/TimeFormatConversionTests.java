package hr.mogh.tests;

import hr.mogh.problems.timeformatconversion.TimeFormatConverter;
import org.junit.Assert;
import org.junit.Test;

/**
 * Contains tests designed to check if TimeFormatConverter works as intended.<p/>
 * Created by vlado on 2.12.2015.
 * @see TimeFormatConverter TimeFormatConverter
 */
public class TimeFormatConversionTests {
    
    @Test
    public void convertPmTime() {
        String convertedTime = TimeFormatConverter.convert12To24("7:05:20PM");
        Assert.assertNotNull(convertedTime);
        Assert.assertEquals("19:05:20", convertedTime);
    }

    @Test
    public void convertAmTime() {
        String convertedTime = TimeFormatConverter.convert12To24("3:05:20AM");
        Assert.assertNotNull(convertedTime);
        Assert.assertEquals("03:05:20", convertedTime);
    }

    @Test
    public void convertMidnightTime() {
        String convertedTime = TimeFormatConverter.convert12To24("12:05:20AM");
        Assert.assertNotNull(convertedTime);
        Assert.assertEquals("00:05:20", convertedTime);
    }

    @Test
    public void convertNoonTime() {
        String convertedTime = TimeFormatConverter.convert12To24("12:05:20PM");
        Assert.assertNotNull(convertedTime);
        Assert.assertEquals("12:05:20", convertedTime);
    }
}
