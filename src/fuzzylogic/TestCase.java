/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fuzzylogic;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

class TestCase {

    int numberOfVariables;
    Variable[] variables;
    Variable outputSet;
    int numberOfRules;
    Rule[] rules;

    public TestCase() {

    }

    void takeInput() {

        Scanner scanner;
        try {
            scanner = new Scanner(new File("input.txt"));

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

            varName = scanner.next();
            numOfSets = scanner.nextInt();
            outputSet = new Variable(varName, 0, numOfSets);

            for (int i = 0; i < numOfSets; i++) {
                setName = scanner.next();
                setType = scanner.next();
                outputSet.fuzzySet[i] = new FuzzySet(setName, setType);
                for (int j = 0; j < outputSet.fuzzySet[i].numOfValues.length; j++) {
                    varValue = scanner.nextInt();
                    outputSet.fuzzySet[i].numOfValues[j] = varValue;
                }
            }

            numberOfRules = scanner.nextInt();

            int numOfPremises;
            String statement;

            rules = new Rule[numberOfRules];
            for (int i = 0; i < numberOfRules; i++) {
                numOfPremises = scanner.nextInt();
                statement = scanner.nextLine();
                rules[i] = new Rule(numOfPremises, statement);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(TestCase.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String toString() {
        return "TestCase{" + "numberOfVariables=" + numberOfVariables + ", variables=" + variables + ", outputSet=" + outputSet + ", numberOfRules=" + numberOfRules + ", rules=" + rules + '}';
    }

}
