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
import java.util.ArrayList;
import java.util.Arrays;

class TestCase {

    int numberOfVariables;
    Variable[] variables;
    Variable outputSet;
    int numberOfRules;
    Rule[] rules;

    public TestCase() {

    }

    public Variable getVariable(String name) {
        if (outputSet.variableName.equalsIgnoreCase(name)) {
            return outputSet;
        }
        for (Variable variable : variables) {
            if (variable.variableName.equalsIgnoreCase(name)) {
                return variable;
            }
        }

        System.out.println("Variable not found ");
        return null;
    }

    public FuzzySet getfuzzyset(Variable v, String name) {
        for (FuzzySet fuzzySet : v.fuzzySet) {
            if (fuzzySet.fuzzySetName.equalsIgnoreCase(name)) {
                return fuzzySet;
            }
        }
        System.out.println("fuzzyset not found ");

        return null;
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

            for (Variable variable : variables) {
                variable.fuzzify();
            }

            numberOfRules = scanner.nextInt();

            int numOfPremises;
            String statement;

            rules = new Rule[numberOfRules];
            for (int i = 0; i < numberOfRules; i++) {
                numOfPremises = scanner.nextInt();
                statement = scanner.nextLine();
                rules[i] = interprter(numOfPremises, statement);
            }
            for (Rule rule : rules) {
                rule.executee();
            }

            outputSet.defuzzify();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(TestCase.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Rule interprter(int numberOfPremises, String statement) {
        ArrayList<FuzzySet> fuzzy = new ArrayList<>(numberOfPremises);
        ArrayList<String> opertor = new ArrayList<>(numberOfPremises - 1);
        Variable vtemp;
        FuzzySet ftemp;
        while (statement.startsWith(" ")) {
            statement = statement.substring(1);
        }
        String[] elements = statement.split(" ");
        //System.out.println(elements[0]);
        //System.out.println();
        vtemp = getVariable(elements[0]);
        //System.out.println(vtemp);
        //System.out.println(elements[2]);
        ftemp = getfuzzyset(vtemp, elements[2]);
        //System.out.println(ftemp+" here ");
        fuzzy.add(ftemp);
        for (int i = 0; i < elements.length; i++) {

            if (elements[i].equals("AND") || elements[i].equals("OR")) {

                vtemp = getVariable(elements[i + 1]);
                ftemp = getfuzzyset(vtemp, elements[i + 3]);
                fuzzy.add(ftemp);
            }
            if (elements[i].equalsIgnoreCase("then")) {
                vtemp = getVariable(elements[i + 1]);
                ftemp = getfuzzyset(vtemp, elements[i + 3]);
            }
        }

        for (String element : elements) {
            if (element.equals("AND")) {
                opertor.add("AND");
            } else if (element.equals("OR")) {
                opertor.add("OR");
            }
        }
        String outputname = elements[elements.length - 1];
        FuzzySet ou = ftemp;
        Rule ru = new Rule(fuzzy, opertor, ou, statement);
        return ru;
    }

    @Override
    public String toString() {
        return "TestCase{" + "numberOfVariables=" + numberOfVariables + ", \nvariables=" + Arrays.toString(variables) + ", \noutputSet=" + outputSet + ", \nnumberOfRules=" + numberOfRules + ", \nrules=" + Arrays.toString(rules) + '}';
    }

}
