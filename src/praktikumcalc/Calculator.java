/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package praktikumcalc;

/**
 *
 * @author Leon Haffmans
 */
public class Calculator {
    public static double standardabweichung(Double[] werte, double mittelwert){
        double ret = 0;
        int counter = 0;
        for(Double wert : werte)
            if(wert != null){
                ret+=Math.pow(wert-mittelwert, 2);
                counter++;
            }
        return Math.sqrt(ret/counter);
    }
    public static double mittelwert(Double[] werte){
        double ret = 0;
        int counter = 0;
        for(Double wert : werte)
            if(wert != null){
                ret+=wert;
                counter++;
            }
        return ret/counter;
    }
    public static double mittelwertX(Double[][] werte){
        double ret = 0;
        int counter = 0;
        for(int i=0; i<werte.length; i++)
            if(werte[i] != null){
                ret+=werte[i][0];
                counter++;
            }
        return ret/counter;
    }
    public static double mittelwertY(Double[][] werte){
        double ret = 0;
        int counter = 0;
        for(int i=0; i<werte.length; i++)
            if(werte[i] != null){
                ret+=werte[i][1];
                counter++;
            }
        return ret/counter;
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
    public static double a(Double[][] points, double xMitte, double yMitte){
        double zaehler=0, nenner=0;
        for(int i=0; i<points.length; i++){
            if(points[i] != null){
                zaehler+=((points[i][0]-xMitte)*(points[i][1]-yMitte));
                nenner+=Math.pow(points[i][0]-xMitte, 2);
            }
        }
        return zaehler/nenner;
    }
    public static double sigmaA(double sigmaY, Double[][] points, double xMitte){
        double ret=0;
        for(int i=0; i<points.length; i++)
            if(points[i] != null)
                ret+=Math.pow(points[i][0]-xMitte, 2);
        return sigmaY*Math.sqrt(1/ret);
    }
    public static double sigmaY(double a, double b, Double[][] points){
        double ret =0;
        int counter = 0;
        for(int i=0; i<points.length; i++)
            if(points[i] != null){
                ret+=Math.pow(a*points[i][0]+b-points[i][1],2);
                counter++;
            }
        return Math.sqrt(ret/(counter-2));
    }
    public static double sigmaB(double sigmaY, Double[][] points, double xMitte){
        double zaehler=0, nenner=0;
        int counter = 0;
        for(int i=0; i<points.length; i++){
            if(points[i] != null){
                zaehler+=Math.pow(points[i][0], 2);
                nenner+=Math.pow(points[i][0]-xMitte, 2);
                counter++;
            }
        }
        return sigmaY*Math.sqrt(zaehler/(counter*nenner));
    }
}
