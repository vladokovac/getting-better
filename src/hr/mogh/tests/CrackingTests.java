package hr.mogh.tests;

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
    public void isPermutationCheck_true() {
        String first = "Cracking the Coding Interview";
        String second = "CtCI   rackinggindohetenweirv";
        boolean isPermutation = StringPermutationChecker.isPermutation(first, second);
        Assert.assertTrue(isPermutation);
    }

    @Test
    public void isPermutationCheck_false() {
        String first = "Cracking the Coding Interview";
        String second = "CtCI   rackinggindohetenweirr";
        boolean isPermutation = StringPermutationChecker.isPermutation(first, second);
        Assert.assertFalse(isPermutation);
    }

    @Test
    public void isPermutationCheck_differentLength() {
        String first = "Cracking the Coding Interview";
        String second = "CtCI   rackinggindohetenweir";
        boolean isPermutation = StringPermutationChecker.isPermutation(first, second);
        Assert.assertFalse(isPermutation);
    }
}
