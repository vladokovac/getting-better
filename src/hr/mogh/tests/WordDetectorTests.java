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

    private static List<String> availableWords = new ArrayList<>(Arrays.asList("ok","test","one","try","trying", "determination", "term", "er", "nation", "at", "ion", "on", "deter"));

    @Test
    public void detectWordsTest_1() {
        List<String> results = WordDetectorSolver.detectWords("abcokdeftrying", availableWords);
        Assert.assertNotNull(results);
        Assert.assertEquals(3, results.size());
    }

    @Test
    public void detectWordsTest_2() {
        List<String> results = WordDetectorSolver.detectWords("determinationerabcde", availableWords);
        Assert.assertNotNull(results);
        Assert.assertEquals(10, results.size());
    }

    @Test
    public void nullInput() {
        List<String> results = WordDetectorSolver.detectWords(null, availableWords);
        Assert.assertNotNull(results);
        Assert.assertEquals(0, results.size());
    }

    @Test
    public void noAvailableWords() {
        List<String> results = WordDetectorSolver.detectWords("abcokdeftrying", null);
        Assert.assertNotNull(results);
        Assert.assertEquals(0, results.size());
    }
}
