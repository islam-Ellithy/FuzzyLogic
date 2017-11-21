/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fuzzylogic;

import java.util.Scanner;

class TestCase {

    int numberOfVariables;
    Variable[] variables;

    public TestCase() {

    }

    void takeInput() {

        Scanner scanner = new Scanner(System.in);
        numberOfVariables = scanner.nextInt();
        variables = new Variable[numberOfVariables];

        String varName;
        int numOfSets;
        int varValue;
        String setName;
        String setType;
        for (int i = 0; i < numberOfVariables; i++) {

            varName = scanner.next();
            varValue = scanner.nextInt();
            numOfSets = scanner.nextInt();

            variables[i] = new Variable(varName, varValue, numOfSets);

            for (int j = 0; j < numOfSets; j++) {
                setName = scanner.next();
                setType = scanner.next();

                variables[i].fuzzySet[j] = new FuzzySet(setName, setType);
                int element;
                for (int k = 0; k < variables[i].fuzzySet[j].numOfValues.length; k++) {
                    element = scanner.nextInt();
                    variables[i].fuzzySet[j].numOfValues[k] = element;
                }
            }
        }
    }

    @Override
    public String toString() {
        return "TestCase{" + "numberOfVariables=" + numberOfVariables + ", variables=" + variables + '}';
    }

}
