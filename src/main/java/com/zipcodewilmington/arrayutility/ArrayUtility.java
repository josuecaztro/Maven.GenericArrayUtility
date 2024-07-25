package com.zipcodewilmington.arrayutility;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by leon on 3/6/18.
 */
public class ArrayUtility<T> {

    public T[] inputArray;

    public ArrayUtility(T[] inputArray){
        this.inputArray = inputArray;
    }

    public Integer getNumberOfOccurrences(T valueToEvaluate){
        Integer counter = 0;
        for (T x : inputArray){
            if (x == valueToEvaluate){
                counter++;
            }
        }
        return counter;
    }

    public Integer countDuplicatesInMerge(T[] arrayToMerge, T valueToEvaluate){
        Integer counter = 0;
        for (T x : inputArray){
            if (x == valueToEvaluate){
                counter++;
            }
        }
        for (T x : arrayToMerge){
            if (x == valueToEvaluate){
                counter++;
            }
        }
        return counter;
    }

    public T getMostCommonFromMerge(T[] arrayToMerge){

        Object[] result = Arrays.copyOf(inputArray, inputArray.length + arrayToMerge.length);
        System.arraycopy(arrayToMerge, 0, result, inputArray.length, arrayToMerge.length);

        int count = 1, tempCount;
        T popular = (T) result[0];
        T temp;
        for (int i = 0; i < (result.length - 1); i++){
            temp = (T) result[i];
            tempCount = 0;
            for (int j = 1; j < result.length; j++){
                if (temp == result[j]){
                    tempCount++;
                }
                if (tempCount > count){
                    popular = temp;
                    count = tempCount;
                }
            }
        }
        return popular;
    }

    public T[] removeValue(T valueToRemove){
        int count = 0;
        for (T x : inputArray){
            if (x == valueToRemove){
                count++;
            }
        }
        T[] newArr = Arrays.copyOf(inputArray, inputArray.length - count);
        int index = 0;

        for (T x : inputArray){
            if (!x.equals(valueToRemove)){
                newArr[index++] = x;
            }
        }
        return newArr;
    }

}

