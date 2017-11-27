/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fuzzylogic;

import java.util.Arrays;

class Variable {

    public String variableName;
    public float variableValue;
    public int numberOfSetsForEachVar;
    public FuzzySet[] fuzzySet;//map between membership and fuzzyset

    public Variable(String varName, float varValue, int newNum) {

        variableName = varName;
        variableValue = varValue;

        numberOfSetsForEachVar = newNum;

        fuzzySet = new FuzzySet[numberOfSetsForEachVar];
    }

    public void fuzzify() {
        for (FuzzySet Set : fuzzySet) {
            Set.calculateMembership(variableValue);
        }
    }

    public void defuzzify() {
        variableValue = 0;
        float divisor = 0;
        for (FuzzySet Set : fuzzySet) {
            Set.calculateCentroid();
            variableValue += Set.centroid * Set.membership;
            divisor += Set.membership;
        }
        if(divisor !=0)
            variableValue /= divisor;
    }

    @Override
    public String toString() {
        return "Variable{" + "variableName=" + variableName + ", variableValue=" + variableValue + ", numberOfSetsForEachVar=" + numberOfSetsForEachVar + ", fuzzySet=" + Arrays.toString(fuzzySet) + '}';
    }

}
