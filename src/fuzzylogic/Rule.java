/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fuzzylogic;

/**
 *
 * @author MrHacker
 */
public class Rule {

    public int numberOfPremises;
    public String statement;

    public Rule(int numberOfPremises, String statement) {
        this.numberOfPremises = numberOfPremises;
        this.statement = statement;
    }

    @Override
    public String toString() {
        return "Rule{" + "numberOfPremises=" + numberOfPremises + "\n,"
                + " statement=" + statement + '}';
    }
    
}
