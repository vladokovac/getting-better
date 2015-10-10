package hr.mogh.trees.offbyoneletter;

import hr.mogh.trees.Node;

import java.util.*;

/**
 * Created by vlado on 9.10.2015..
 */
public class OffByOneLetterSolver {

    static Set<String> legalWords = new HashSet<String>(Arrays.asList("book", "look", "crook", "nook", "nuts",
            "buck", "boob", "loot", "hoot", "horn", "turn", "run", "prune", "boom", "loom", "hunt", "poop", "punt",
            "treat", "greet", "null", "point", "runt", "lint", "burn", "lick", "luck", "lunch", "boon", "broom",
            "pole", "noon", "boot", "boat", "brook", "bunk", "trunk", "room", "broom", "tomb", "gloom", "foot",
            "font", "cool", "fool", "boil"));
    static List<Character> alphabet = new ArrayList<>(Arrays.asList('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j',
            'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'x', 'w', 'y', 'z'));

    public static Node generateOffByOneLetterTree() {
        String rootName = "bool";
        Set<String> usedWords = new HashSet<>();
        usedWords.add(rootName);
        Node root = new Node();
        root.setPayload(rootName);
        root.setParent(null);
        root.setChildren(generateOneLetterDifferentNodes(root.getPayload().toString(), usedWords));
        return root;
    }

    /**
     * Uses BFS to find a path from one word to another by using one-letter differences.
     *
     * @param root Tree root
     * @param word Final word.
     * @return The list of strings representing the path from <code>startWord</code> to <code>finishWord</code>.
     * <code>null</code> if no such path exists.
     */
    public static List<String> findPathFromWordToWord(Node root, String word) throws IllegalArgumentException {
        // do a BFS to find the child
        List<String> pathToWord = new ArrayList<>();

        if (word == null || word.length() == 0) {
            throw new IllegalArgumentException();
        }

        boolean pathFound = false;
        List<Node> searchList = new ArrayList<>();
        searchList.add(root);
        Node targetNode = null;
        while (searchList.size() > 0) {
            Node node = searchList.get(0);
            if (node.getPayload().equals(word)) {
                targetNode = node;
                pathFound = true;
                break;
            } else {
                searchList.addAll(node.getChildren());
            }
            searchList.remove(0);
        }

        if (targetNode != null) {
            while (targetNode != null) {
                pathToWord.add(targetNode.getPayload().toString());
                targetNode = targetNode.getParent();
            }
            Collections.reverse(pathToWord);
        }

        return pathFound ? pathToWord : null;
    }

    private static List<Node> generateOneLetterDifferentNodes(String word, Set<String> usedWords) {
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
