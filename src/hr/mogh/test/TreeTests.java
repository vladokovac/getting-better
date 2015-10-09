package hr.mogh.test;

import hr.mogh.trees.Node;
import org.junit.Assert;
import org.junit.Test;

import java.util.*;

/**
 * Created by vlado on 9.10.2015..
 */
public class TreeTests {

    Set<String> legalWords = new HashSet<String>(Arrays.asList("book", "look", "crook", "nook", "nuts", "buck",
            "boob", "loot", "hoot", "horn", "turn", "run", "prune", "boom", "loom", "hunt", "poop", "punt", "treat",
            "greet", "null", "point", "runt", "lint", "burn", "lick", "luck", "lunch", "boon", "broom", "pole",
            "noon", "boot", "boat", "brook", "bunk", "trunk", "room", "broom", "tomb", "gloom", "foot", "font"));
    List<Character> alphabet = new ArrayList<>(Arrays.asList('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k',
            'l', 'm', 'n', 'o', 'p', 'q', 'r', 't', 'u', 'x', 'y', 'z'));

    @Test
    public void treeGenerationTest() {
        String rootName = "bool";
        Set<String> usedWords = new HashSet<>();
        usedWords.add(rootName);
        Node root = new Node();
        root.setPayload(rootName);
        root.setChildren(generateOneLetterDifferentNodes(root.getPayload().toString(), usedWords));
        Assert.assertNotNull(root.getChildren());
        Assert.assertTrue(root.getChildren().size() > 0);
    }

    private List<Node> generateOneLetterDifferentNodes(String word, Set<String> usedWords) {
        List<String> generatedWords = new ArrayList<>();
        List<Node> generatedNodes = new ArrayList<>();
        for (Character alphabetLetter : alphabet) {

            for (int i = 0; i < word.length(); i++) {
                Character letterFromWord = word.charAt(i);
                if (alphabetLetter.equals(letterFromWord)) {
                    continue;
                }

                String genWordReplace = "";
                String genWordAddInFront = "";

                String wordPrefix = "";
                if (i > 0) {
                    wordPrefix = word.substring(0, i);
                }
                String wordReplaceSuffix = "";
                if (i < word.length() - 1) {
                    wordReplaceSuffix = word.substring(i + 1, word.length());
                }

                genWordReplace = wordPrefix + alphabetLetter + wordReplaceSuffix;
                genWordAddInFront = wordPrefix + alphabetLetter + word.substring(i, word.length());

                if (legalWords.contains(genWordReplace) && !usedWords.contains(genWordReplace)) {
                    generatedWords.add(genWordReplace);
                    usedWords.add(genWordReplace);
                }
                if (legalWords.contains(genWordAddInFront) && !usedWords.contains(genWordAddInFront)) {
                    generatedWords.add(genWordAddInFront);
                    usedWords.add(genWordAddInFront);
                }
            }
            String genWordAfterWord = word + alphabetLetter;
            if (legalWords.contains(genWordAfterWord) && !usedWords.contains(genWordAfterWord)) {
                generatedWords.add(genWordAfterWord);
                usedWords.add(genWordAfterWord);
            }
        }

        for (String generatedWord : generatedWords) {
            Node node = new Node();
            node.setPayload(generatedWord);
            node.setChildren(generateOneLetterDifferentNodes(generatedWord, usedWords));
            generatedNodes.add(node);
        }

        return generatedNodes;
    }
}
