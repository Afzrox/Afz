import java.util.Scanner;

public class WindChill{



    public static void main(String[] args) {
        double dResult=0;
        double dWind = Double.parseDouble(args[0]);
        double dTemp = Double.parseDouble(args[1]);
        WindChill WCObject=new WindChill();
        if((dTemp>0 && dTemp<50) && (dWind>3 && dWind<120)){
        dResult = WCObject.m_windChill(dWind,dTemp);
        }
        else{
            System.out.println("Run Again with proper parameter");    
        }
        System.out.format("WindChill is %.3f ",dResult);
    }
    
    public double m_windChill(double dWind,double dTemp){
        double dWindChill;
        dWind = Math.pow(dWind, 0.16);
        dWindChill   = 35.74+0.+6215*dTemp+(0.4275*dTemp-35.75)*dWind;
        return dWindChill;
    }
}