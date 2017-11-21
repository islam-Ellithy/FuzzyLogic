/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fuzzylogic;

import java.util.Scanner;

/**
 *
 * @author MrHacker
 */
public class FuzzyLogic {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        TestCase test = new TestCase();

        test.takeInput();

        System.out.println(test);
        
        for(int i = 0 ; i < test.numberOfRules;i++){
            System.out.println(test.rules[i]);
        }
            
    }

}
/*
2
position 10
2
Left trapezoidal
0 0 10 35
LeftCenter triangle
30 40 50
angel -45
2
RBelow triangle
-90 -45 9
RUpper triangle
-9 23 54
firePosition
3 
NegBig triangle
-30 -30 -15
NegMed triangle
-25 -15 -5 
NegSm triangle
-12 -6 0 

4
2 position = Left AND angel = RBelow then firePosition = PosSm 
2 ANGEL = RBelow OR position = LeftCenter then firePosition = PosMed 
2 position = Center AND angel = RBelow then firePosition = NegSm 
2 position = Center OR angel = LBelow then firePosition = NegMed 
 */
