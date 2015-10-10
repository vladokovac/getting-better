package hr.mogh.test;

import hr.mogh.trees.Node;
import hr.mogh.trees.offbyoneletter.OffByOneLetterSolver;
import org.junit.Assert;
import org.junit.Test;

import java.util.*;

/**
 * Created by vlado on 9.10.2015..
 */
public class TreeTests {

    @Test
    public void treeGenerationTest() {
        Node root = OffByOneLetterSolver.generateOffByOneLetterTree();
        Assert.assertNotNull(root.getChildren());
        Assert.assertTrue(root.getChildren().size() > 0);
    }

    @Test
    public void findOffByOneLetterWordPathToFinalWord_shouldSucceed() {
        Node root = OffByOneLetterSolver.generateOffByOneLetterTree();
        List<String> path = OffByOneLetterSolver.findPathFromWordToWord(root, "gloom");
        Assert.assertNotNull(path);
        Assert.assertTrue(path.size() > 0);
    }

    @Test
    public void findOffByOneLetterWordPathToFakeWord_shouldFail() {
        Node root = OffByOneLetterSolver.generateOffByOneLetterTree();
        List<String> path = OffByOneLetterSolver.findPathFromWordToWord(root, "token");
        Assert.assertNull(path);
    }
}
