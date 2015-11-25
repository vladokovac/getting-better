package hr.mogh.problems.worddetector;

import java.util.ArrayList;
import java.util.List;

/**
 * Solves the following problem:<br/>
 * <code>Given an infinite stream of characters and a list L of strings, create a function that calls an external API
 * when a word in L is recognized during the processing of the stream.
 * <p/>
 * Example:
 * L = ["ok","test","one","try","trying"]
 * stream = a,b,c,o,k,d,e,f,t,r,y,i,n,g.............
 * <p/>
 * the call to external API (let's call it some function callAPI()) would be called when the 'k' is encountered,
 * again when the 'y' is encountered, and again at 'g'.</code><br/>
 * Created by vlado on 23.11.2015.
 */
public class WordDetectorSolver {

    public static List<String> detectWords(String charStream, List<String> availableWords) {

        if (charStream == null || charStream.length() == 0 || availableWords == null ||availableWords.size() == 0) {
            return new ArrayList<>();
        }

        // create word tree
        WordTreeNode root = new WordTreeNode(null, null, false);
        for (String word : availableWords) {
            WordTreeNode currentNode = root;
            for (int i = 0; i < word.length(); i++) {
                Character letter = word.charAt(i);
                List<WordTreeNode> children = currentNode.getChildren();
                boolean isChildWithLetterFound = false;
                for (WordTreeNode child : children) {
                    if (child.getValue().equals(Character.toLowerCase(letter))) {
                        // character is already represented in the tree
                        currentNode = child;
                        isChildWithLetterFound = true;
                        if (i == word.length() - 1) {
                            currentNode.setIsLastCharInWord(true);
                        }
                        break;
                    }
                }

                if (!isChildWithLetterFound) {
                    WordTreeNode node = new WordTreeNode(currentNode, letter, i == word.length() - 1);
                    currentNode.addChild(node);
                    currentNode = node;
                }
            }
        }

        // find words in stream
        List<String> detectedWords = new ArrayList<>();
        List<WordTreeNode> confirmedCandidates = new ArrayList<>();
        List<WordTreeNode> wordCandidates = new ArrayList<>();
        for (int i = 0; i < charStream.length(); i++) {
            wordCandidates.add(root);
            Character letter = charStream.charAt(i);
            int candidatesThisRound = wordCandidates.size();
            int j = 0;
            while (j < candidatesThisRound) {
                WordTreeNode candidate = wordCandidates.get(0);
                List<WordTreeNode> candidateChildren = candidate.getChildren();
                for (WordTreeNode child : candidateChildren) {
                    if (child.getValue().equals(Character.toLowerCase(letter))) {
                        wordCandidates.add(child);
                        if (child.isLastCharInWord()) {
                            confirmedCandidates.add(child);
                        }
                        break;
                    }
                }
                wordCandidates.remove(candidate);
                j++;
            }
        }

        // retrieve confirmed candidate values
        for (WordTreeNode node : confirmedCandidates) {
            detectedWords.add(node.getParentToNodeString());
        }

        return detectedWords;
    }
}
