package hr.mogh.test;

import hr.mogh.datastructures.trees.Node;
import hr.mogh.problems.offbyoneletter.OffByOneLetterSolver;
import org.junit.Assert;
import org.junit.Test;

import java.util.*;

/**
 * Contains tests written to ensure correct generation and pathfinding of the Off-By-One-Letter Word Tree.
 */
public class OffByOneLetterTreeTests {

    @Test
    public void treeGenerationTest() {
        Node root = OffByOneLetterSolver.generateOffByOneLetterTree("bomb");
        Assert.assertNotNull(root.getChildren());
        Assert.assertTrue(root.getChildren().size() > 0);
    }

    @Test
    public void findOffByOneLetterWordPathToFinalWord_shouldSucceed() {
        String rootWord = "bool";
        String targetWord = "gloom";
        Node root = OffByOneLetterSolver.generateOffByOneLetterTree(rootWord);
        List<List<String>> paths = OffByOneLetterSolver.findPathFromRootToWord(root, targetWord);
        Assert.assertNotNull(paths);
        Assert.assertTrue(paths.size() > 0);
        for (List<String> path : paths) {
            Assert.assertEquals(path.get(0), rootWord);
            Assert.assertEquals(path.get(path.size() - 1), targetWord);
        }
    }

    @Test
    public void findOffByOneLetterWordPathToFakeWord_shouldFail() {
        Node root = OffByOneLetterSolver.generateOffByOneLetterTree("bool");
        List<List<String>> paths = OffByOneLetterSolver.findPathFromRootToWord(root, "token");
        Assert.assertNull(paths);
    }

    /**
     * Tests if the solver can locate multiple off-by-one-letter paths from "boon" to "coil".<p/>
     * Examples:<br/> boon -> bool -> cool -> coil <br/> boon -> boot -> foot -> fool -> cool -> coil
     */
    @Test
    public void findOffByOneLetterWordPathToFakeWord_multiplePathsExist() {
        String rootWord = "boon";
        String targetWord = "coil";
        Node root = OffByOneLetterSolver.generateOffByOneLetterTree(rootWord);
        List<List<String>> paths = OffByOneLetterSolver.findPathFromRootToWord(root, targetWord);
        Assert.assertNotNull(paths);
        Assert.assertTrue(paths.size() > 1);
        checkIfPathsAreValid(rootWord, targetWord, paths);
    }

    @Test
    public void findWordPathBetweenAnyTwoWords_shouldSucceed() {
        String startWord = "room";
        String targetWord = "coil";
        List<List<String>> paths = OffByOneLetterSolver.findPathFromWordToWord(startWord, targetWord);
        Assert.assertNotNull(paths);
        checkIfPathsAreValid(startWord, targetWord, paths);
    }

    private void checkIfPathsAreValid(String startWord, String targetWord, List<List<String>> paths) {
        // check if all paths are valid
        Set<String> concatenatedPathSet = new HashSet<>();
        for (List<String> path : paths) {
            StringBuilder stringBuilder = new StringBuilder();
            Assert.assertEquals(path.get(0), startWord);
            Assert.assertEquals(path.get(path.size() - 1), targetWord);
            // check for circular references
            Set<String> usedWords = new HashSet<>();
            for (String word : path) {
                Assert.assertFalse(usedWords.contains(word));
                usedWords.add(word);
                stringBuilder.append(word);
                stringBuilder.append("->");
            }
            String concatenatedPath = stringBuilder.toString();

            concatenatedPath = concatenatedPath.substring(0, concatenatedPath.length() - 2);
            Assert.assertFalse(concatenatedPathSet.contains(concatenatedPath));
            concatenatedPathSet.add(concatenatedPath);
        }
    }
}
