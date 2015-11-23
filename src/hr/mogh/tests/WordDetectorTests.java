package hr.mogh.tests;

import hr.mogh.problems.worddetector.WordDetectorSolver;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Contains tests designed to check if WordDetectorSolver works as intended.<p/>
 * Created by vlado on 23.11.2015.<br/>
 * @see WordDetectorSolver WordDetectorSolver
 */
public class WordDetectorTests {

    private static List<String> availableWords = new ArrayList<>(Arrays.asList("ok","test","one","try","trying"));

    @Test
    public void detectWordTest() {
        List<String> results = WordDetectorSolver.detectWords("abcokdeftrying", availableWords);
        Assert.assertNotNull(results);
        Assert.assertEquals(3, results.size());
    }
}
