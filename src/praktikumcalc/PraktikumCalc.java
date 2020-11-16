/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package praktikumcalc;

/**
 *
 * @author haffm
 */
public class PraktikumCalc {

    /**
     * @param args the command line arguments
     */
    public static void main2(String[] args) {
        /*double[] werte1T = {299.3,299.4,299.3,299.5,299.5,299.3,299.5,299.5,299.4,299.5,299.6};
        double[] werte1P = {999.4,1019.4,1037.8,1053.4,1070.1,1088.7,1101.4,1117.6,1124.1,1139.7,1150.4};
        double[] werte1V = {53,52,51,50,49,48,47,46,45,44,43};
        double[] pVT1 = divArrs(multArrs(werte1P,werte1V),werte1T);
        double[] werte2 = {1004,1024.9,1023.8,1022.3,1021.2,1020,1019.4};
        double[] werte3T = {373.4,373.7,373.6,373.5,373.5,373.6,373.5,373.3,373.2,373,372.9};
        double[] werte3P = {1005.2,1022.8,1042.5,1060.6,1080,1100.3,1120.1,1138.3,1151.9,1176.7,1196.8};
        double[] werte3V = {53,52,51,50,49,48,47,46,45,44,43};
        double[] pVT3 = divArrs(multArrs(werte3P,werte3V),werte3T);
        double mittelwert = mittelwert(pVT1);
        double st = standardabweichung(pVT1, mittelwert);
        
        System.out.println("Mittelwert: "+mittelwert+", Standardabweichung: "+st);
        /*System.out.println("Mittelwert V: "+mittelwert(werte1V));
        System.out.println("Mittelwert p: "+mittelwert(werte1P));
        System.out.println("Mittelwert T: "+mittelwert(werte1T));*/
        double[][] pointsStab1 = {
            {30.5,0},
            {33,45},
            {36,70},
            {39,90},
            {42,110},
            {45,130},
            {48,150},
            {51,170},
            {54,190},
            {57,210},
            {60,230}
        }, pointsStab2 = {
            {30.5,0},
            {33,40},
            {36,60},
            {39,80},
            {42,100},
            {45,120},
            {48,140},
            {51,155},
            {54,175},
            {57,200},
            {60,220}
        };
        double xM1 = mittelwertX(pointsStab1), yM1 = mittelwertY(pointsStab1);
        double a1 = a(pointsStab1, xM1, yM1), b1 = yM1-a1*xM1;
        double sigmaY1 = sigmaY(a1, b1, pointsStab1), sigmaA1 = sigmaA(sigmaY1, pointsStab1, xM1),
                sigmaB1 = sigmaB(sigmaY1, pointsStab1, xM1);
        
        double xM2 = mittelwertX(pointsStab2), yM2 = mittelwertY(pointsStab2);
        double a2 = a(pointsStab2, xM2, yM2), b2 = yM2-a2*xM2;
        double sigmaY2 = sigmaY(a2, b2, pointsStab2), sigmaA2 = sigmaA(sigmaY2, pointsStab2, xM2),
                sigmaB2 = sigmaB(sigmaY2, pointsStab2, xM2);
        
        System.out.println("Stab 1:");
        System.out.println("Mittelwert von x: "+xM1+", Mittelwert von y: "+yM1);
        System.out.println("a = "+a1+", b = "+b1);
        System.out.println("sigmaY = "+sigmaY1+", sigmaA = "+sigmaA1+", sigmaB = "+sigmaB1);
        System.out.println();
        System.out.println("Stab 2:");
        System.out.println("Mittelwert von x: "+xM2+", Mittelwert von y: "+yM2);
        System.out.println("a = "+a2+", b = "+b2);
        System.out.println("sigmaY = "+sigmaY2+", sigmaA = "+sigmaA2+", sigmaB = "+sigmaB2);
        System.out.println();
    }
    public static double standardabweichung(double[] werte, double mittelwert){
        double ret = 0;
        for(double wert : werte)
            ret+=Math.pow(wert-mittelwert, 2)/werte.length;
        return Math.sqrt(ret);
    }
    public static double mittelwert(double[] werte){
        double ret = 0;
        for(double wert : werte)
            ret+=wert/werte.length;
        return ret;
    }
    public static double mittelwertX(double[][] werte){
        double ret = 0;
        for(int i=0; i<werte.length; i++)
            ret+=werte[i][0]/werte.length;
        return ret;
    }
    public static double mittelwertY(double[][] werte){
        double ret = 0;
        for(int i=0; i<werte.length; i++)
            ret+=werte[i][1]/werte.length;
        return ret;
    }
    public static double[] multArrs(double[] werte1, double[] werte2){
        double[] ret = new double[werte1.length];
        for(int i=0; i<werte1.length; i++)
            ret[i]=werte1[i]*werte2[i];
        return ret;
    }
    public static double[] divArrs(double[] werte1, double[] werte2){
        double[] ret = new double[werte1.length];
        for(int i=0; i<werte1.length; i++)
            ret[i]=werte1[i]/werte2[i];
        return ret;
    }
    public static double a(double[][] points, double xMitte, double yMitte){
        double zaehler=0, nenner=0;
        for(int i=0; i<points.length; i++){
            zaehler+=((points[i][0]-xMitte)*(points[i][1]-yMitte));
            nenner+=Math.pow(points[i][0]-xMitte, 2);
        }
        return zaehler/nenner;
    }
    public static double sigmaA(double sigmaY, double[][] points, double xMitte){
        double ret=0;
        for(int i=0; i<points.length; i++)
            ret+=Math.pow(points[i][0]-xMitte, 2);
        return sigmaY*Math.sqrt(1/ret);
    }
    public static double sigmaY(double a, double b, double[][] points){
        double ret =0;
        for(int i=0; i<points.length; i++)
            ret+=Math.pow(a*points[i][0]+b-points[i][1],2);
        return Math.sqrt(ret/(points.length-2));
    }
    public static double sigmaB(double sigmaY, double[][] points, double xMitte){
        double zaehler=0, nenner=0;
        for(int i=0; i<points.length; i++){
            zaehler+=Math.pow(points[i][0], 2);
            nenner+=Math.pow(points[i][0]-xMitte, 2);
        }
        return sigmaY*Math.sqrt(zaehler/(points.length*nenner));
    }
}
