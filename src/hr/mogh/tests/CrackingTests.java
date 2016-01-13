package hr.mogh.tests;

import hr.mogh.crackingthecodinginterview.ch1.SpaceReplacer;
import hr.mogh.crackingthecodinginterview.ch1.StringCompressor;
import hr.mogh.crackingthecodinginterview.ch1.StringPermutationChecker;
import hr.mogh.crackingthecodinginterview.ch1.UniqueCharacterStringSolver;
import org.junit.Assert;
import org.junit.Test;

/**
 * Contains tests that ensure that all solution to problems from Cracking the Coding Interview work properly.<br/>
 * Created by vlado on 6.1.2016.
 */
public class CrackingTests {

    @Test
    public void uniqueCharacterTest_uniqueCharacters() {
        String input = "s0dleog7Šðž]÷¤23bm<";
        boolean allCharactersUnique = UniqueCharacterStringSolver.hasAllUniqueCharacters(input);
        Assert.assertTrue(allCharactersUnique);
    }

    @Test
    public void uniqueCharacterTest_nonUniqueCharacters() {
        String input = "sodkfirjauu29103p.cbn";
        boolean allCharactersUnique = UniqueCharacterStringSolver.hasAllUniqueCharacters(input);
        Assert.assertFalse(allCharactersUnique);
    }

    @Test
    public void uniqueCharactersNoExtraDataStructuresTest_uniqueCharacters() {
        String input = "s0dleog7Šðž]÷¤23bm<";
        boolean allCharactersUnique = UniqueCharacterStringSolver.hasAllUniqueCharactersNoExtraDataStructures(input);
        Assert.assertTrue(allCharactersUnique);
    }

    @Test
    public void uniqueCharactersNoExtraDataStructuresTest_nonUniqueCharacters() {
        String input = "sodkfirjauu29103p.cbn";
        boolean allCharactersUnique = UniqueCharacterStringSolver.hasAllUniqueCharactersNoExtraDataStructures(input);
        Assert.assertFalse(allCharactersUnique);
    }

    @Test
    public void isPermutationCheckTest_true() {
        String first = "Cracking the Coding Interview";
        String second = "CtCI   rackinggindohetenweirv";
        boolean isPermutation = StringPermutationChecker.isPermutation(first, second);
        Assert.assertTrue(isPermutation);
    }

    @Test
    public void isPermutationCheckTest_false() {
        String first = "Cracking the Coding Interview";
        String second = "CtCI   rackinggindohetenweirr";
        boolean isPermutation = StringPermutationChecker.isPermutation(first, second);
        Assert.assertFalse(isPermutation);
    }

    @Test
    public void isPermutationCheckTest_differentLength() {
        String first = "Cracking the Coding Interview";
        String second = "CtCI   rackinggindohetenweir";
        boolean isPermutation = StringPermutationChecker.isPermutation(first, second);
        Assert.assertFalse(isPermutation);
    }

    @Test
    public void insertSpaceSymbolsTest() {
        char[] input = {'M', 'r', ' ', 'J', 'o', 'h', 'n', ' ', 'S', 'm', 'i', 't', 'h', ' ', ' ', ' ', ' '};
        char[] expectedOutput = {'M', 'r', '%', '2', '0', 'J', 'o', 'h', 'n', '%', '2', '0', 'S', 'm', 'i', 't', 'h'};
        char[] output = SpaceReplacer.replaceSpaces(input);
        Assert.assertTrue(areEqual(expectedOutput, output));
    }

    @Test
    public void insertSpaceSymbolsTest_spaceInFront() {
        char[] input = {' ', 'a', ' ', ' '};
        char[] expectedOutput = {'%', '2', '0', 'a'};
        char[] output = SpaceReplacer.replaceSpaces(input);
        Assert.assertTrue(areEqual(expectedOutput, output));
    }

    public boolean areEqual(char[] first, char[] second) {
        if (first.length != second.length) {
            return false;
        }

        boolean areEqual = true;

        for (int i = 0; i < first.length; i++) {
            if (first[i] != second[i]) {
                areEqual = false;
                break;
            }
        }
        return areEqual;
    }

    @Test
    public void compressStringTest() {
        String input = "aabcccccaaa";
        String expectedOutput = "a2b1c5a3";
        String output = StringCompressor.compressString(input);
        Assert.assertEquals(expectedOutput, output);
    }

    @Test
    public void compressStringTest_producesLongerString() {
        String input = "abcd";
        String output = StringCompressor.compressString(input);
        Assert.assertEquals(input, output);
    }
}
