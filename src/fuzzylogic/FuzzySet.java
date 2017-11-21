/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fuzzylogic;

class FuzzySet {

    final String triangle = "triangle";
    final String trapezoidal = "trapezoidal";
    public String fuzzySetName;
    public String fuzzySetType;
    public int[] numOfValues;

    public FuzzySet() {
        fuzzySetName = "";
        fuzzySetType = "";
    }

    public FuzzySet(String fuzzyName, String fuzzyType) {

        fuzzySetName = fuzzyName;
        fuzzySetType = fuzzyType;

        if (fuzzySetType.contains(triangle)) {
            numOfValues = new int[3];
        } else if (fuzzySetType.contains(trapezoidal)) {
            numOfValues = new int[4];
        }
    }

    @Override
    public String toString() {
        return "FuzzySet{" + "fuzzySetName=" + fuzzySetName + ", fuzzySetType=" + fuzzySetType + ", numOfValues=" + numOfValues + '}';
    }

    
}
