/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fuzzylogic;

class Variable {

    public String variableName;
    public int variableValue;
    public int numberOfSetsForEachVar;
    public FuzzySet[] fuzzySet;

    public Variable(String varName, int varValue, int newNum) {

        variableName = varName;
        variableValue = varValue;

        numberOfSetsForEachVar = newNum;

        fuzzySet = new FuzzySet[numberOfSetsForEachVar];
    }

    @Override
    public String toString() {
        return "Variable{" + "variableName=" + variableName + ", variableValue=" + variableValue + ", numberOfSetsForEachVar=" + numberOfSetsForEachVar + ", fuzzySet=" + fuzzySet + '}';
    }
    
}
