/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fuzzylogic;

import java.util.Arrays;

class FuzzySet {

    final String triangle = "triangle";
    final String trapezoidal = "trapezoidal";
    public String fuzzySetName;
    public String fuzzySetType;
    public float[] numOfValues;
    public float membership;
    public float centroid;

    public FuzzySet() {
        fuzzySetName = "";
        fuzzySetType = "";
        membership = 0;
        centroid = 0;
    }

    public FuzzySet(String fuzzyName, String fuzzyType) {

        fuzzySetName = fuzzyName;
        fuzzySetType = fuzzyType;
        membership = 0;
        centroid = 0;

        if (fuzzySetType.contains(triangle)) {
            numOfValues = new float[3];
        } else if (fuzzySetType.contains(trapezoidal)) {
            numOfValues = new float[4];
        }
    }

    public void calculateMembership(float target) {
        if (fuzzySetType.contains(triangle)) {
            if (target > numOfValues[0] && target < numOfValues[1]) {
                membership = 1 - ((numOfValues[1] - target) / (numOfValues[1] - numOfValues[0]));
            } else if (target > numOfValues[1] && target < numOfValues[2]) {
                membership = ((numOfValues[2] - target) / (numOfValues[2] - numOfValues[1]));
            } else if (target == numOfValues[1]) {
                membership = 1;
            } else {
                membership = 0;
            }
        } else if (fuzzySetType.contains(trapezoidal)) {
            if (target > numOfValues[0] && target < numOfValues[1]) {
                membership = 1 - ((numOfValues[1] - target) / (numOfValues[1] - numOfValues[0]));
            } else if (target > numOfValues[2] && target < numOfValues[3]) {
                membership = ((numOfValues[3] - target) / (numOfValues[3] - numOfValues[2]));
            } else if (target >= numOfValues[1] && target <= numOfValues[2]) {
                membership = 1;
            } else {
                membership = 0;
            }
        }
    }
    
    public void calculateCentroid(){
        centroid = 0;
        for (int i = 0; i < numOfValues.length; i++) {
            centroid+=numOfValues[i];
        }
        centroid /=numOfValues.length;
    }

    @Override
    public String toString() {
        return "FuzzySet{" + "fuzzySetName=" + fuzzySetName + ", fuzzySetType=" + fuzzySetType + ", membership=" + membership + ", numOfValues=" + Arrays.toString(numOfValues) + '}';
    }

}
