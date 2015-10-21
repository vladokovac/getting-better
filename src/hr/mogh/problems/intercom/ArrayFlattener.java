package hr.mogh.problems.intercom;

import java.util.ArrayList;
import java.util.List;

/**
 * Class that solves the following problem: Write some code, that will flatten an array of arbitrarily nested arrays
 * of integers into a flat array of integers. e.g. [[1,2,[3]],4] -> [1,2,3,4].
 * Created by vlado on 21.10.2015.
 */
public class ArrayFlattener {

    public static Integer[] flattenArray(Object[] array) {
        List<Integer> flatList = new ArrayList<>();

        if (array.length == 0) {
            return null;
        }

        for (int i = 0; i < array.length; i++) {
            Object arrayValue = array[i];
            try {
                Object[] subArray = (Object[]) arrayValue;
                Integer[] flattenedSubArray = ArrayFlattener.flattenArray(subArray);
                if (flattenedSubArray != null) {
                    for (int j = 0; j < flattenedSubArray.length; j++) {
                        flatList.add(flattenedSubArray[j]);
                    }
                }
            } catch (ClassCastException cce) {
                if (arrayValue instanceof Integer) {
                    Integer arrayInteger = (Integer) arrayValue;
                    flatList.add(arrayInteger);
                } else {
                    throw new IllegalArgumentException("ArrayFlattener.flattenArray accepts only arrays where " +
                            "elements are either subarrays or Integers.");
                }
            }
        }

        Integer[] flattenedArray = new Integer[flatList.size()];
        for (int i = 0; i < flatList.size(); i++) {
            flattenedArray[i] = flatList.get(i);
        }
        return flattenedArray;
    }

}
