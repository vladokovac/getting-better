package hr.mogh.tests;

import hr.mogh.crackingthecodinginterview.ch1.ImageRotator;
import hr.mogh.crackingthecodinginterview.ch1.MatrixZeroing;
import hr.mogh.crackingthecodinginterview.ch1.RotatedStringDetector;
import hr.mogh.crackingthecodinginterview.ch1.SpaceReplacer;
import hr.mogh.crackingthecodinginterview.ch1.StringCompressor;
import hr.mogh.crackingthecodinginterview.ch1.StringPermutationChecker;
import hr.mogh.crackingthecodinginterview.ch1.UniqueCharacterStringSolver;
import hr.mogh.crackingthecodinginterview.ch2.CircularLinkedListDetector;
import hr.mogh.crackingthecodinginterview.ch2.LinkedListPartitioner;
import hr.mogh.crackingthecodinginterview.ch2.ListAdditionImplementations;
import hr.mogh.crackingthecodinginterview.ch2.ListNodeFinder;
import hr.mogh.crackingthecodinginterview.ch2.ListNodeRemover;
import hr.mogh.crackingthecodinginterview.ch2.ListPruner;
import hr.mogh.crackingthecodinginterview.ch2.PalindromeListDetector;
import hr.mogh.crackingthecodinginterview.ch3.AnimalShelter.Animal;
import hr.mogh.crackingthecodinginterview.ch3.AnimalShelter.AnimalShelter;
import hr.mogh.crackingthecodinginterview.ch3.AnimalShelter.AnimalType;
import hr.mogh.crackingthecodinginterview.ch3.FasterMinStack;
import hr.mogh.crackingthecodinginterview.ch3.HanoiTowerSolver;
import hr.mogh.crackingthecodinginterview.ch3.MinStack;
import hr.mogh.crackingthecodinginterview.ch3.MyQueue;
import hr.mogh.crackingthecodinginterview.ch3.SetOfStacks;
import hr.mogh.crackingthecodinginterview.ch3.SortedStack;
import hr.mogh.crackingthecodinginterview.ch3.TriStack;
import hr.mogh.crackingthecodinginterview.ch4.BinaryTreeBalanceDetector;
import hr.mogh.crackingthecodinginterview.ch4.RouteFinder;
import hr.mogh.datastructures.linkedlist.DoublyLinkedList;
import hr.mogh.datastructures.linkedlist.ListNode;
import hr.mogh.datastructures.trees.BinaryTreeNode;
import hr.mogh.datastructures.trees.Node;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * Contains tests that ensure that all solution to problems from Cracking the Coding Interview work properly.<br/>
 * Created by vlado on 6.1.2016.
 */
public class CrackingTests {

    @Test
    public void uniqueCharacterTest_uniqueCharacters() {
        String input = "s0dleog7+x23bm<";
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
        String input = "s0dleog7+x23bm<";
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

    @Test
    public void detectCircularLinkedList_noLoop() {
        Character[] characters = {'A', 'B', 'C', 'D', 'E', 'F'};
        DoublyLinkedList linkedList = new DoublyLinkedList(Arrays.asList(characters));
        Assert.assertNull(CircularLinkedListDetector.findStartOfLoop(linkedList));
    }

    @Test
    public void detectCircularLinkedList_withLoop() {
        Character[] characters = {'A', 'B', 'C', 'D', 'E', 'F'};
        DoublyLinkedList linkedList = new DoublyLinkedList((List) Arrays.asList(characters));
        ListNode someNode = linkedList.getLastNode().getNodeBefore().getNodeBefore();
        ListNode newNode = new ListNode('G');
        newNode.setNodeAfter(someNode);
        linkedList.getLastNode().setNodeAfter(newNode);
        ListNode loopStart = CircularLinkedListDetector.findStartOfLoop(linkedList);
        Assert.assertEquals(someNode, loopStart);
    }

    @Test
    public void isLinkedListAPalindrome_oddPalindrome() {
        Character[] characters = {'A', 'B', 'C', 'B', 'A'};
        DoublyLinkedList linkedList = new DoublyLinkedList((List) Arrays.asList(characters));
        Assert.assertTrue(PalindromeListDetector.isPalindrome(linkedList));
    }

    @Test
    public void isLinkedListAPalindrome_evenPalindrome() {
        Character[] characters = {'A', 'B', 'C', 'C', 'B', 'A'};
        DoublyLinkedList linkedList = new DoublyLinkedList((List) Arrays.asList(characters));
        Assert.assertTrue(PalindromeListDetector.isPalindrome(linkedList));
    }

    @Test
    public void isLinkedListAPalindrome_notAPalindrome() {
        Character[] characters = {'A', 'B', 'C', 'C'};
        DoublyLinkedList linkedList = new DoublyLinkedList((List) Arrays.asList(characters));
        Assert.assertFalse(PalindromeListDetector.isPalindrome(linkedList));
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

    @Test
    public void rotateImageTest_3x3Matrix() {
        short[][] image = new short[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        short[][] rotatedImage = new short[][]{{3, 6, 9}, {2, 5, 8}, {1, 4, 7}};
        ImageRotator.rotateImage(image);
        Assert.assertTrue(areMatricesEqual(rotatedImage, image));
    }

    @Test
    public void rotateImageTest_4x4Matrix() {
        short[][] image = new short[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        short[][] rotatedImage = new short[][]{{4, 8, 12, 16}, {3, 7, 11, 15}, {2, 6, 10, 14}, {1, 5, 9, 13}};
        ImageRotator.rotateImage(image);
        Assert.assertTrue(areMatricesEqual(rotatedImage, image));
    }

    @Test
    public void zeroOutMatrix() {
        short[][] matrix = new short[][]{{1, 2, 0, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        short[][] expectedResult = new short[][]{{0, 0, 0, 0}, {5, 6, 0, 8}, {9, 10, 0, 12}};
        MatrixZeroing.zeroOut(matrix);
        Assert.assertTrue(areMatricesEqual(expectedResult, matrix));
    }

    @Test
    public void zeroOutMatrix_overlappingZeroes() {
        short[][] matrix = new short[][]{{1, 2, 0, 0}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        short[][] expectedResult = new short[][]{{0, 0, 0, 0}, {5, 6, 0, 0}, {9, 10, 0, 0}};
        MatrixZeroing.zeroOut(matrix);
        Assert.assertTrue(areMatricesEqual(expectedResult, matrix));
    }

    @Test
    public void rotatedStringDetector_isRotated() {
        String original = "waterbottle";
        String rotated = "erbottlewat";

        boolean isRotated = RotatedStringDetector.isRotatedString(rotated, original);

        Assert.assertTrue(isRotated);
    }

    @Test
    public void rotatedStringDetector_isNotRotated() {
        String original = "waterbottle";
        String rotated = "rbottlewat";

        boolean isRotated = RotatedStringDetector.isRotatedString(rotated, original);

        Assert.assertFalse(isRotated);
    }

    @Test
    public void rotatedStringDetector_rotatedStringTooSmall() {
        String original = "waterbottle";
        String rotated = "wat";

        boolean isRotated = RotatedStringDetector.isRotatedString(rotated, original);

        Assert.assertFalse(isRotated);
    }

    @Test
    public void pruneLinkedList_withBuffer() {
        List<Object> valueList = new ArrayList<>(Arrays.asList((Object) "A", "B", "C", "A", "C", "D", "D", "A"));
        DoublyLinkedList list = new DoublyLinkedList(valueList);
        ListNode listRoot = list.getFirstNode();
        ListPruner.pruneLinkedListWithBuffer(listRoot);

        Assert.assertEquals(4, listRoot.size());
    }

    @Test
    public void pruneLinkedList_withoutBuffer() {
        List<Object> valueList = new ArrayList<>(Arrays.asList((Object) "A", "B", "C", "A", "C", "D", "D", "A"));
        DoublyLinkedList list = new DoublyLinkedList(valueList);
        ListNode listRoot = list.getFirstNode();
        ListPruner.pruneLinkedList(listRoot);

        Assert.assertEquals(4, listRoot.size());
    }

    @Test
    public void findKthToLastNode() {
        List<Object> valueList = new ArrayList<>(Arrays.asList((Object) "A", "B", "C", "A", "C", "D", "D", "A"));
        DoublyLinkedList list = new DoublyLinkedList(valueList);
        ListNode listRoot = list.getFirstNode();
        ListNode foundNode = ListNodeFinder.findKthToLastElement(4, listRoot);
        Assert.assertEquals("C", foundNode.getValue());
    }

    @Test(expected = IllegalArgumentException.class)
    public void findKthToLastNode_tooFewElements() {
        List<Object> valueList = new ArrayList<>(Arrays.asList((Object) "A", "B", "C"));
        DoublyLinkedList list = new DoublyLinkedList(valueList);
        ListNode listRoot = list.getFirstNode();
        ListNodeFinder.findKthToLastElement(4, listRoot);
    }

    @Test
    public void removeNodeFromList() {
        List<Object> valueList = new ArrayList<>(Arrays.asList((Object) "A", "B", "C", "D", "E"));
        DoublyLinkedList list = new DoublyLinkedList(valueList);
        ListNode listNode = list.getFirstNode();
        listNode = listNode.getNodeAfter();
        ListNodeRemover.removeNode(listNode);
        assertNoValueInList("B", list);
    }

    @Test
    public void removeNodeFromListCorrectly() {
        List<Object> valueList = new ArrayList<>(Arrays.asList((Object) "A", "B", "C", "D", "E"));
        DoublyLinkedList list = new DoublyLinkedList(valueList);
        ListNode listNode = list.getFirstNode();
        listNode = listNode.getNodeAfter();
        ListNodeRemover.removeNode(listNode);
        assertNoValueInList("B", list);
    }

    @Test
    public void partitionLinkedListAroundValue() {
        List<Object> valueList = new ArrayList<>(Arrays.asList((Object) 1, 33, 6, 3, 7, 4, 11, 5, 4, 5, 6, 2));
        int value = 5;
        DoublyLinkedList list = new DoublyLinkedList(valueList);
        DoublyLinkedList partitionedList = LinkedListPartitioner.partitionList(list, value);

        assertListPartitionedCorrectly(partitionedList, value);
    }

    @Test
    public void partitionLinkedListAroundValue_allValuesGreater() {
        List<Object> valueList = new ArrayList<>(Arrays.asList((Object) 33, 6, 3, 7, 4, 11, 5, 4, 5, 6, 2));
        int value = 2;
        DoublyLinkedList list = new DoublyLinkedList(valueList);
        DoublyLinkedList partitionedList = LinkedListPartitioner.partitionList(list, value);

        assertListPartitionedCorrectly(partitionedList, value);
    }

    @Test(expected = IllegalArgumentException.class)
    public void partitionLinkedListAroundValue_pivotDoesntExist() {
        List<Object> valueList = new ArrayList<>(Arrays.asList((Object) 33, 6, 3, 7, 4, 11, 5, 4, 5, 6, 2));
        int value = 22;
        DoublyLinkedList list = new DoublyLinkedList(valueList);
        LinkedListPartitioner.partitionList(list, value);
    }

    @Test
    public void sumReverseLists() {
        List<Object> list1 = new ArrayList<>(Arrays.asList((Object) 7, 1, 6));
        List<Object> list2 = new ArrayList<>(Arrays.asList((Object) 5, 9, 2));
        List<Object> listExpected = new ArrayList<>(Arrays.asList((Object) 2, 1, 9));
        DoublyLinkedList linkedListExpected = new DoublyLinkedList(listExpected);
        DoublyLinkedList linkedList1 = new DoublyLinkedList(list1);
        DoublyLinkedList linkedList2 = new DoublyLinkedList(list2);
        DoublyLinkedList summedList = ListAdditionImplementations.sumReverse(linkedList1, linkedList2);
        Assert.assertEquals(linkedListExpected, summedList);
    }

    @Test
    public void sumReverseLists_extraCarryOverNode() {
        List<Object> list1 = new ArrayList<>(Arrays.asList((Object) 9, 9, 9));
        List<Object> list2 = new ArrayList<>(Arrays.asList((Object) 5, 6, 7));
        List<Object> listExpected = new ArrayList<>(Arrays.asList((Object) 4, 6, 7, 1));
        DoublyLinkedList linkedListExpected = new DoublyLinkedList(listExpected);
        DoublyLinkedList linkedList1 = new DoublyLinkedList(list1);
        DoublyLinkedList linkedList2 = new DoublyLinkedList(list2);
        DoublyLinkedList summedList = ListAdditionImplementations.sumReverse(linkedList1, linkedList2);
        Assert.assertEquals(linkedListExpected, summedList);
    }

    @Test
    public void sumReverseLists_oneShorterList() {
        List<Object> list1 = new ArrayList<>(Arrays.asList((Object) 9, 9, 9));
        List<Object> list2 = new ArrayList<>(Arrays.asList((Object) 6, 7));
        List<Object> listExpected = new ArrayList<>(Arrays.asList((Object) 5, 7, 0, 1));
        DoublyLinkedList linkedListExpected = new DoublyLinkedList(listExpected);
        DoublyLinkedList linkedList1 = new DoublyLinkedList(list1);
        DoublyLinkedList linkedList2 = new DoublyLinkedList(list2);
        DoublyLinkedList summedList = ListAdditionImplementations.sumReverse(linkedList1, linkedList2);
        Assert.assertEquals(linkedListExpected, summedList);
    }

    @Test
    public void sumLists() {
        List<Object> list1 = new ArrayList<>(Arrays.asList((Object) 6, 1, 7));
        List<Object> list2 = new ArrayList<>(Arrays.asList((Object) 2, 9, 5));
        List<Object> listExpected = new ArrayList<>(Arrays.asList((Object) 9, 1, 2));
        DoublyLinkedList linkedListExpected = new DoublyLinkedList(listExpected);
        DoublyLinkedList linkedList1 = new DoublyLinkedList(list1);
        DoublyLinkedList linkedList2 = new DoublyLinkedList(list2);
        DoublyLinkedList summedList = ListAdditionImplementations.sum(linkedList1, linkedList2);
        Assert.assertEquals(linkedListExpected, summedList);
    }

    @Test
    public void sumLists_extraCarryOverNode() {
        List<Object> list1 = new ArrayList<>(Arrays.asList((Object) 9, 9, 9));
        List<Object> list2 = new ArrayList<>(Arrays.asList((Object) 7, 6, 5));
        List<Object> listExpected = new ArrayList<>(Arrays.asList((Object) 1, 7, 6, 4));
        DoublyLinkedList linkedListExpected = new DoublyLinkedList(listExpected);
        DoublyLinkedList linkedList1 = new DoublyLinkedList(list1);
        DoublyLinkedList linkedList2 = new DoublyLinkedList(list2);
        DoublyLinkedList summedList = ListAdditionImplementations.sum(linkedList1, linkedList2);
        Assert.assertEquals(linkedListExpected, summedList);
    }

    @Test
    public void sumLists_oneShorterList() {
        List<Object> list1 = new ArrayList<>(Arrays.asList((Object) 9, 9, 9));
        List<Object> list2 = new ArrayList<>(Arrays.asList((Object) 7, 6));
        List<Object> listExpected = new ArrayList<>(Arrays.asList((Object) 1, 0, 7, 5));
        DoublyLinkedList linkedListExpected = new DoublyLinkedList(listExpected);
        DoublyLinkedList linkedList1 = new DoublyLinkedList(list1);
        DoublyLinkedList linkedList2 = new DoublyLinkedList(list2);
        DoublyLinkedList summedList = ListAdditionImplementations.sum(linkedList1, linkedList2);
        Assert.assertEquals(linkedListExpected, summedList);
    }

    @Test
    public void triStack_pushPop() {
        TriStack triStack = new TriStack(9);
        triStack.push(1, 1);
        triStack.push(2, 2);
        triStack.push(3, 3);

        Assert.assertEquals(1, triStack.pop(1));
        Assert.assertEquals(2, triStack.pop(2));
        Assert.assertEquals(3, triStack.pop(3));
    }

    @Test
    public void triStack_pushWhenFull() {
        TriStack triStack = new TriStack(9);
        Assert.assertTrue(triStack.push(1, 2));
        Assert.assertTrue(triStack.push(2, 2));
        Assert.assertTrue(triStack.push(3, 2));
        Assert.assertFalse(triStack.push(4, 2));
    }

    @Test
    public void triStack_popWhenEmpty() {
        TriStack triStack = new TriStack(9);
        Assert.assertNull(triStack.pop(1));
    }

    @Test
    public void triStack_checkBorders() {
        TriStack triStack = new TriStack(9);
        triStack.push(1, 2);
        triStack.push(2, 2);
        triStack.push(3, 2);
        triStack.push(4, 3);
        Assert.assertEquals(4, triStack.pop(3));
        Assert.assertNull(triStack.pop(3));
        Assert.assertEquals(3, triStack.pop(2));
        Assert.assertEquals(2, triStack.pop(2));
        Assert.assertEquals(1, triStack.pop(2));
    }

    @Test
    public void minStack_popPush() {
        MinStack minStack = new MinStack();

        int[] inputs = new int[]{3, 2, 1, -1};

        for (int input : inputs) {
            minStack.push(input);
        }
        for (int i = inputs.length - 1; i >= 0; i--) {
            Assert.assertEquals(inputs[i], (int) minStack.pop());
        }
    }


    @Test
    public void fasterMinStack_minValue() {
        int[] inputs = new int[]{3, 1, 2, -1};
        int[] expectedMins = new int[]{3, 1, 1, -1};

        FasterMinStack fasterMinStack = new FasterMinStack();

        for (int i = 0; i < inputs.length; i++) {
            fasterMinStack.push(inputs[i]);
            Assert.assertEquals(expectedMins[i], fasterMinStack.getMin());
        }
    }

    @Test
    public void fasterStack_popPush() {
        FasterMinStack fasterMinStack = new FasterMinStack();

        int[] inputs = new int[]{3, 2, 1, -1};

        for (int input : inputs) {
            fasterMinStack.push(input);
        }
        for (int i = inputs.length - 1; i >= 0; i--) {
            Assert.assertEquals(inputs[i], fasterMinStack.pop());
        }
    }


    @Test
    public void minStack_minValue() {
        int[] inputs = new int[]{3, 1, 2, -1};
        int[] expectedMins = new int[]{3, 1, 1, -1};

        MinStack minStack = new MinStack();

        for (int i = 0; i < inputs.length; i++) {
            minStack.push(inputs[i]);
            Assert.assertEquals(expectedMins[i], minStack.getMin());
        }
    }

    @Test
    public void setOfStacks_pushPopSingleStack() {
        Integer[] inputs = new Integer[]{1, 2, 3};
        SetOfStacks setOfStacks = new SetOfStacks(10);

        for (int input : inputs) {
            setOfStacks.push(input);
        }

        for (int i = inputs.length - 1; i >= 0; i--) {
            Assert.assertEquals(inputs[i], setOfStacks.pop());
        }
    }

    @Test
    public void setOfStacks_pushPopMultipleStacks() {
        Integer[] inputs = new Integer[]{1, 2, 3};
        SetOfStacks setOfStacks = new SetOfStacks(1);

        for (int input : inputs) {
            setOfStacks.push(input);
        }

        for (int i = inputs.length - 1; i >= 0; i--) {
            Assert.assertEquals(inputs[i], setOfStacks.pop());
        }
    }

    @Test
    public void setOfStacks_popWhenEmptySingleStack() {
        SetOfStacks setOfStacks = new SetOfStacks(1);
        setOfStacks.push(1);
        Assert.assertEquals(1, setOfStacks.pop());
        Assert.assertNull(setOfStacks.pop());
    }

    @Test
    public void setOfStacks_popWhenEmptyMultipleStacks() {
        SetOfStacks setOfStacks = new SetOfStacks(1);
        setOfStacks.push(1);
        setOfStacks.push(2);
        Assert.assertEquals(2, setOfStacks.pop());
        Assert.assertEquals(1, setOfStacks.pop());
        Assert.assertNull(setOfStacks.pop());
    }

    @Test
    public void setOfStacks_popAt() {
        Integer[] inputs = new Integer[]{1, 2, 3};
        SetOfStacks setOfStacks = new SetOfStacks(1);

        for (int input : inputs) {
            setOfStacks.push(input);
        }
        Assert.assertEquals(1, setOfStacks.popAt(0));
        Assert.assertEquals(2, setOfStacks.popAt(0));
        Assert.assertEquals(3, setOfStacks.popAt(0));
        Assert.assertNull(setOfStacks.popAt(0));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void setOfStacks_popAtIndexOutOfBounds() {
        Integer[] inputs = new Integer[]{1, 2, 3};
        SetOfStacks setOfStacks = new SetOfStacks(1);
        for (int input : inputs) {
            setOfStacks.push(input);
        }
        Assert.assertEquals(1, setOfStacks.popAt(3));
    }

    @Test
    public void hanoiSolver_solve() {
        int totalDisks = 5;
        Stack solvedStack = HanoiTowerSolver.solve(totalDisks);
        Assert.assertEquals(totalDisks, solvedStack.size());
        for (int i = 0; i < totalDisks; i++) {
            Assert.assertEquals(i, (int) solvedStack.pop());
        }
    }

    @Test
    public void hanoiSolver_emptyStack() {
        int totalDisks = 0;
        Stack solvedStack = HanoiTowerSolver.solve(totalDisks);
        Assert.assertNull(solvedStack);
    }

    @Test
    public void myQueue_enqueueDequeue() {
        MyQueue myQueue = new MyQueue();
        Integer[] inputs = new Integer[]{1, 2, 3};
        myQueue.enqueue(inputs);

        for (int input : inputs) {
            Assert.assertEquals(input, myQueue.dequeue());
        }
    }

    @Test
    public void myQueue_dequeueWhenEmpty() {
        MyQueue myQueue = new MyQueue();
        Assert.assertNull(myQueue.dequeue());
    }

    @Test
    public void myQueue_enqueueDequeueSequence() {
        MyQueue myQueue = new MyQueue();
        Integer[] inputs = new Integer[]{1, 2, 3};
        myQueue.enqueue(inputs);

        Assert.assertEquals(inputs[0], myQueue.dequeue());
        myQueue.enqueue(4);
        Assert.assertEquals(inputs[1], myQueue.dequeue());
    }

    @Test
    public void sortedStack_pushPop() {
        SortedStack<Integer> sortedStack = new SortedStack<>();
        sortedStack.push(1);
        Assert.assertEquals(1, (int) sortedStack.pop());
    }

    @Test
    public void sortedStack_sortedPop() {
        SortedStack<Integer> sortedStack = new SortedStack<>();
        sortedStack.push(20);
        sortedStack.push(7);
        sortedStack.push(33);
        sortedStack.push(1);

        Integer lastValue = Integer.MAX_VALUE;
        while (sortedStack.peek() != null) {
            Assert.assertTrue(sortedStack.peek() < lastValue);
            lastValue = sortedStack.pop();
        }
    }

    @Test
    public void sortedStack_isEmpty_true() {
        SortedStack<Integer> sortedStack = new SortedStack<>();
        Assert.assertTrue(sortedStack.isEmpty());
    }

    @Test
    public void sortedStack_isEmpty_false() {
        SortedStack<Integer> sortedStack = new SortedStack<>();
        sortedStack.push(1);
        Assert.assertFalse(sortedStack.isEmpty());
    }

    @Test
    public void animalEnqueueDequeueAny() {
        AnimalShelter animalShelter = new AnimalShelter();

        animalShelter.enqueue(AnimalType.CAT);
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        animalShelter.enqueue(AnimalType.CAT);
        animalShelter.enqueue(AnimalType.DOG);
        animalShelter.enqueue(AnimalType.CAT);

        long lastTimeArrived = 0;
        for (int i = 0; i < 4; i++) {
            Animal animal = animalShelter.dequeueAny();
            Assert.assertTrue(animal.getTimeArrived() >= lastTimeArrived);
            lastTimeArrived = animal.getTimeArrived();
        }
        Assert.assertNull(animalShelter.dequeueAny());
    }

    @Test
    public void animalShelterDequeueEmpty() {
        AnimalShelter animalShelter = new AnimalShelter();
        Assert.assertNull(animalShelter.dequeueAny());
    }

    @Test
    public void animalEnqueueDequeueDog() {
        AnimalShelter animalShelter = new AnimalShelter();

        animalShelter.enqueue(AnimalType.CAT);
        animalShelter.enqueue(AnimalType.DOG);
        animalShelter.enqueue(AnimalType.DOG);
        animalShelter.enqueue(AnimalType.CAT);

        Assert.assertEquals(AnimalType.DOG, animalShelter.dequeueDog().getType());
    }

    @Test
    public void treeBalanceTest_isBalanced() {
        BinaryTreeNode root = new BinaryTreeNode(1, null);
        BinaryTreeNode left = new BinaryTreeNode(2, root);
        BinaryTreeNode right = new BinaryTreeNode(3, root);
        root.setLeftChild(left);
        root.setRightChild(right);

        left.setLeftChild(new BinaryTreeNode(4, left));
        left.setRightChild(new BinaryTreeNode(5, left));
        right.setLeftChild(new BinaryTreeNode(6, right));

        Assert.assertTrue(BinaryTreeBalanceDetector.isTreeBalanced(root));
    }

    @Test
    public void treeBalanceTest_isNotBalanced() {
        BinaryTreeNode root = new BinaryTreeNode(1, null);
        BinaryTreeNode left = new BinaryTreeNode(2, root);
        BinaryTreeNode leftLeft = new BinaryTreeNode(3, root);
        root.setLeftChild(left);

        left.setLeftChild(leftLeft);

        Assert.assertFalse(BinaryTreeBalanceDetector.isTreeBalanced(root));
    }

    @Test
    public void treeBalanceTest_nullTree() {
        Assert.assertTrue(BinaryTreeBalanceDetector.isTreeBalanced(null));
    }

    @Test
    public void directedGraphRouteSearch_routeExists() {
        Node node0 = new Node(1);
        Node node1 = new Node(2);
        Node node2 = new Node(3);
        Node node3 = new Node(4);
        Node node4 = new Node(5);
        Node node5 = new Node(6);

        node3.addChild(node4);
        node3.addChild(node5);
        node2.addChild(node3);
        node1.addChild(node2);
        node1.addChild(node4);
        node0.addChild(node1);

        List<Node> expectedRoute = Arrays.asList(node1, node2, node3, node5);
        List<Node> route = RouteFinder.findRoute(node1, node5);
        Assert.assertNotNull(route);
        Assert.assertEquals(expectedRoute.size(), route.size());
        for (int i = 0; i < expectedRoute.size(); i++) {
            Assert.assertEquals(expectedRoute.get(i), route.get(i));
        }
    }

    @Test
    public void directedGraphRouteSearch_routeDoesntExist() {
        Node node0 = new Node(1);
        Node node1 = new Node(2);
        Node node2 = new Node(3);
        Node node3 = new Node(4);
        Node node4 = new Node(5);
        Node node5 = new Node(6);

        node3.addChild(node4);
        node3.addChild(node5);
        node2.addChild(node3);
        node1.addChild(node2);
        node1.addChild(node4);
        node0.addChild(node1);

        Assert.assertNull(RouteFinder.findRoute(node4, node5));
    }

    private void assertListPartitionedCorrectly(DoublyLinkedList partitionedList, int pivotValue) {
        ListNode node = partitionedList.getFirstNode();
        ListNode pivotNode = node;
        while (pivotNode.getNodeAfter() != null && (int) pivotNode.getNodeAfter().getValue() <= pivotValue) {
            pivotNode = pivotNode.getNodeAfter();
        }

        boolean hasPassedPivot = false;
        do {
            if (!hasPassedPivot) {
                Assert.assertTrue(pivotValue >= (int) node.getValue());
            } else {
                Assert.assertTrue(pivotValue < (int) node.getValue());
            }
            if (node == pivotNode) {
                hasPassedPivot = true;
            }
            node = node.getNodeAfter();
        } while (node != null);
    }

    private void assertNoValueInList(String value, DoublyLinkedList list) {
        ListNode node = list.getFirstNode();
        do {
            Assert.assertNotSame(value, node.getValue());
            node = node.getNodeAfter();
        } while (node.getNodeAfter() != null);
    }

    private boolean areMatricesEqual(short[][] expected, short[][] actual) {
        if (expected.length != actual.length || expected[0].length != actual[0].length) {
            return false;
        }
        boolean areEqual = true;
        int rows = expected[0].length;
        int columns = expected.length;
        for (int i = 0; i < columns; i++) {
            for (int j = 0; j < rows; j++) {
                if (expected[i][j] != actual[i][j]) {
                    areEqual = false;
                    break;
                }
            }
            if (!areEqual) {
                break;
            }
        }
        return areEqual;
    }
}
