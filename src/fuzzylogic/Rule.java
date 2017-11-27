/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fuzzylogic;

import java.time.Clock;
import java.util.ArrayList;

/**
 *
 * @author MrHacker
 */
public class Rule {

    public int numberOfPremises;
    public String statement;
    ArrayList<FuzzySet> prem;
    ArrayList<String> operation;
    FuzzySet output;

    public Rule(ArrayList<FuzzySet> pre, ArrayList<String> oper, FuzzySet out, String statement) {
        this.prem = pre;
        this.operation = oper;
        this.output = out;
        numberOfPremises = prem.size();
        this.statement = statement;
    }

    // get2prem(){}
    public FuzzySet executee() {

//        for (int i = 0; i < prem.size()-1; i++) {
//
//
//
//        }
        FuzzySet result = new FuzzySet();
        while (operation.size() > 0) {
            if (operation.get(0).equals("AND")) {
                result.membership = Math.min(prem.get(0).membership, prem.get(1).membership);
                prem.remove(0);
                prem.remove(0);
                prem.add(0, result);
                operation.remove(0);

            } else {
                result.membership = Math.max(prem.get(0).membership, prem.get(1).membership);
                prem.remove(0);
                prem.remove(0);
                prem.add(0, result);
                operation.remove(0);
            }

        }
       output.membership=result.membership;
       return output;
    }

//
//                System.out.println(ele);
//                System.out.println(opertor);
//
//
//	}
//	public static void main(String[] args) {
//		Rule r = new Rule(2, "position = Left AND angel = RBelow then firePosition = PosSm ");
//		r.interprter();
//	}
    @Override
    public String toString() {
        return "Rule{" + "numberOfPremises=" + numberOfPremises+ ", \nStatement: "+ statement + '}';
    }

}
