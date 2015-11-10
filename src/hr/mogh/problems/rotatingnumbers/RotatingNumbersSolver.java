package hr.mogh.problems.rotatingnumbers;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Solves the following problem:<br/>
 * Check given Number is same after 180 degree rotation?<br/>
 * <br/>
 * i/p: 69<br/>
 * o/p: True<br/>
 * <br/>
 * i/p: 916<br/>
 * o/p: True<br/>
 * <br/>
 * i/p: 123<br/>
 * o/p: False<br/>
 * <br/>
 * Created by vlado on 9.11.2015.
 */
public class RotatingNumbersSolver {
    private HashMap<Integer, Integer> numberRotationMap;

    public RotatingNumbersSolver() {
        this.numberRotationMap = new HashMap<>();
        this.numberRotationMap.put(0, 0);
        this.numberRotationMap.put(1, 1);
        this.numberRotationMap.put(2, 5);
        this.numberRotationMap.put(5, 2);
        this.numberRotationMap.put(6, 9);
        this.numberRotationMap.put(8, 8);
        this.numberRotationMap.put(9, 6);
    }

    /**
     * Tests if a number is rotatable and equal after 180 degree rotation. Eg. <code>269</code> becomes
     * <code>596</code>, <code>619</code> becomes <code>619</code>.<br/>
     * Time complexity: O(n)<br/>
     * Space complexity: O(n)<br/>
     *
     * @param number Number that will be checked.
     * @return True if number is rotatable and equal after rotation.
     */
    public boolean isEqualAfterRotation(int number) {
        String originalWord = String.valueOf(number);
        String rotatedWord = "";

        boolean isRotatable = true;
        for (int i = 0; i < originalWord.length(); i++) {
            int numberPart = Integer.valueOf(Character.valueOf(originalWord.charAt(i)).toString());
            Integer rotatedPart = this.numberRotationMap.get(numberPart);
            if (rotatedPart == null) {
                isRotatable = false;
                break;
            } else {
                rotatedWord += rotatedPart.toString();
            }
        }

        if (isRotatable) {
            rotatedWord = new StringBuilder(rotatedWord).reverse().toString();
            int rotatedNumber = Integer.valueOf(rotatedWord);
            isRotatable = rotatedNumber == number;
        }

        return isRotatable;
    }
}
