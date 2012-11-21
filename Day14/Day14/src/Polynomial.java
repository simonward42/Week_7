/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author sward09
 */
public class Polynomial {
    private static final double PRECISION = 0.000001;
    private double[] coeffs;
    public void setCoefficients(double[] coeffs) {
        if(coeffs.length <2) {
            System.out.println("Polynomial must have a minimum of 2 coefficients. Please try again.");
            return;
        }
        this.coeffs = coeffs;
    }
    public double eval(double x) {
        // Evaluates the polynomial for x
        if(coeffs.length == 0) {
            System.out.println("Must set coefficients before evaluating!");
            return -1;
        }
        double result = 0.0;
        for(int i=0; i<coeffs.length; i++) {
            double exp = (double)i;
            result += coeffs[i] * Math.pow(x, exp);
        }
        return result;
    }
    public boolean isZeroAt(double x) {
        if(Math.abs((eval(x) - 0)) < PRECISION) {
            return true;
        }
        else {
            return false; 
        }
    }
    public boolean root() {
        // Returns true if a root is found in the range -1000.0 to +1000.0
        return root(-1000.0, +1000.0);
    }
    public boolean root(double min, double max) {
        // Returns true if a root is found in the range min to max
        if(isZeroAt(min) || isZeroAt(max)) {
            return true;
        }
        if(max - min < PRECISION) {
            return false;
        }
        double valueAtMin = eval(min);
        double valueAtMax = eval(max);
        
        if(valueAtMin < 0 && valueAtMax < 0) {
            double midPoint = (valueAtMax + valueAtMin) / 2;
            if(isZeroAt(midPoint)) {
                return true;
            }
            double valueAtMid = eval(midPoint);
            if(valueAtMid > 0) {
                // both halves contain a root, let's go with upper
                return root(midPoint, max);
            } else {
                // both halves may contain a root
                if(root(midPoint, max)) {
                    return true;
                }
                else if(root(min, midPoint)) {
                    return true;
                }
                else {
                    return false;
                }
            }
        }
        if(valueAtMin > 0 && valueAtMax > 0) {
            double midPoint = (valueAtMax + valueAtMin) / 2;
            if(isZeroAt(midPoint)) {
                return true;
            }
            double valueAtMid = eval(midPoint);
            if(valueAtMid < 0) {
                // both halves contain a root, let's go with upper
                return root(midPoint, max);
            } else {
                // both halves may contain a root
                if(root(midPoint, max)) {
                    return true;
                }
                else if(root(min, midPoint)) {
                    return true;
                }
                else {
                    return false;
                }
            }
        }
        if(valueAtMin < 0 && valueAtMax > 0) {
            // There's a root somewhere between min and max
            double midPoint = (valueAtMax + valueAtMin) / 2;
            if(isZeroAt(midPoint)) {
                return true;
            }
            double valueAtMid = eval(midPoint);
            if(valueAtMid < 0) {
                // upper half contains a root
                return root(midPoint, max);
            } else {
                // lower half contains a root
                return root(min, midPoint);
            }
        }
        else {
            // There's a root somewhere between min and max (valueAtMin>0 && valueAtMax<0)
            double midPoint = (valueAtMax + valueAtMin) / 2;
            if(isZeroAt(midPoint)) {
                return true;
            }
            double valueAtMid = eval(midPoint);
            if(valueAtMid > 0) {
                // upper half contains a root
                return root(midPoint, max);
            } else {
                // lower half contains a root
                return root(min, midPoint);
            }
        }
    }
}
