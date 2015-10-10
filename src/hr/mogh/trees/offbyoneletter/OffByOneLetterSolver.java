package hr.mogh.trees.offbyoneletter;

import hr.mogh.trees.Node;

import java.util.*;

/**
 * Solves the following problem: </p>
 * Given a word and a list of legal words find all paths from the root word to the given word. One step in the path
 * is a legal word that has exactly one letter added or changed from the step before it (a one-letter-different word).
 * Created by vlado on 9.10.2015.
 */
public class OffByOneLetterSolver {

    static Set<String> legalWords = new HashSet<String>(Arrays.asList("book", "look", "crook", "nook", "nuts",
            "buck", "boob", "loot", "hoot", "horn", "turn", "run", "prune", "boom", "loom", "hunt", "poop", "punt",
            "treat", "greet", "null", "point", "runt", "lint", "burn", "lick", "luck", "lunch", "boon", "broom",
            "pole", "noon", "boot", "boat", "brook", "bunk", "trunk", "room", "tomb", "gloom", "foot", "font",
            "cool", "fool", "boil", "rune", "pool", "burn", "barn", "born", "bank", "pink", "coil", "moat", "most",
            "mist", "must", "dust", "tool", "wool", "will", "till", "want", "foil", "toil", "toll", "told", "mold"));
    static List<Character> alphabet = new ArrayList<>(Arrays.asList('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j',
            'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'x', 'w', 'y', 'z'));

    public static Node generateOffByOneLetterTree(String rootWord) throws IllegalArgumentException {
        if (rootWord == null || rootWord.length() == 0) {
            throw new IllegalArgumentException();
        }
        String rootName = rootWord;
        Set<String> usedWords = new HashSet<>();
        usedWords.add(rootName);
        Node root = new Node();
        root.setPayload(rootName);
        root.setParent(null);
        root.setChildren(generateOneLetterDifferentNodes(root.getPayload().toString(), usedWords));
        return root;
    }

    /**
     * Uses BFS to find a path from the root word to another by using one-letter differences.
     *
     * @param root Tree root
     * @param word Final word.
     * @return List of lists of strings representing the path from <code>startWord</code> to <code>finishWord</code>.
     * <code>null</code> if no such path exists.
     */
    public static List<List<String>> findPathFromRootToWord(Node root, String word) throws IllegalArgumentException {
        // do a BFS to find the child
        List<List<String>> allPaths = new ArrayList<>(); // list of lists - very Python, much lists, wow
        List<String> pathToWord = null;

        if (word == null || word.length() == 0) {
            throw new IllegalArgumentException();
        }

        List<Node> searchList = new ArrayList<>();
        searchList.add(root);
        while (searchList.size() > 0) {
            Node node = searchList.get(0);
            if (node.getPayload().equals(word)) {
                // node found, generate the path to it
                pathToWord = getWordPathForNode(node);
                allPaths.add(pathToWord);
            } else {
                searchList.addAll(node.getChildren());
            }
            searchList.remove(0);
        }
        return allPaths.size() > 0 ? allPaths : null;
    }

    /**
     * Finds all word paths from one word to another. Each step in a path is a legal word that is one letter off from the word in the step before.
     * @param treeRoot Root of the word tree.
     * @param startWord Starting word in the path.
     * @param targetWord Final word in the path.
     * @return List of paths (lists of strings) or <code>null</code> if no paths exist.
     * @throws IllegalArgumentException
     */
    public static List<List<String>> findPathFromWordToWord(Node treeRoot, String startWord, String targetWord) throws
            IllegalArgumentException {
        if (startWord == null || startWord.length() == 0) {
            throw new IllegalArgumentException("Start word must not be null or empty");
        }
        if (targetWord == null || targetWord.length() == 0) {
            throw new IllegalArgumentException("Target word must not be null or empty");
        }

        List<List<String>> foundPaths = new ArrayList<>();
        List<Node> searchList = new ArrayList<>();
        searchList.add(treeRoot);
        while (searchList.size() > 0) {
            Node node = searchList.get(0);
            if (node.getPayload().equals(startWord)) {
                List<List<String>> paths = findPathFromRootToWord(node, targetWord);
                foundPaths.addAll(paths);
            } else {
                searchList.addAll(node.getChildren());
            }
            searchList.remove(0);
        }
        return foundPaths.size() > 0 ? foundPaths : null;
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

                String genWordReplace;
                String genWordAddInFront;

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
            Set<String> usedWordsForThisBranch = new HashSet<>(usedWords);
            usedWordsForThisBranch.add(generatedWord);
            node.setChildren(generateOneLetterDifferentNodes(generatedWord, usedWordsForThisBranch));
            generatedNodes.add(node);
        }

        return generatedNodes;
    }

    /**
     * Returns a path of words that lead from the root to the given node.
     *
     * @param node The last node in the path.
     * @return A list of words from the tree root to the given node.
     */
    private static List<String> getWordPathForNode(Node node) {
        List<String> pathToWord = new ArrayList<>();
        if (node != null) {
            while (node != null) {
                pathToWord.add(node.getPayload().toString());
                node = node.getParent();
            }
            Collections.reverse(pathToWord);
        }
        return pathToWord;
    }
}
