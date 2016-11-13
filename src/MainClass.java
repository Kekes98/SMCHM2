import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.lang.Math;

import static java.lang.Math.pow;

/**
 * Created by Holy on 28.10.2016.
 */
public class MainClass {
    private int border1, border2, count;
   private int iterations = 0;
   private  int iteration;
    private double Epsilon;
    int x;
ArrayList < Integer > arr;
    MainClass(double Epsilon) {
        this.Epsilon = Epsilon;
        arr = new ArrayList<>();
if (func(-100) >0) SearchFromPlus(-100);
else SearchFromMinus(-100);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Задайте точность");
     double  Epsilon = Double.parseDouble(reader.readLine());

        new MainClass(Epsilon);

    }
    double func(double x){
        double result;
        result = pow(x,3) - 2*(pow(x,2))  - 12*x +12;
        return  result;
    }
    void SearchFromPlus(int x){
     border1 = x;
     boolean match = false;
       for(int i = x+1; i <=x+3 ; i++){
           double result = func(i);

           if (result  < 0) {

               border2 = i;
               arr.add(border1);
               arr.add(border2);
               System.out.println("Отрезок номер "  + arr.size()/2 + ": [" + border1 + "," +border2 + "]" );
            match = true;
            count++;
            break;

           }
       }
        if (x+3<100 && count !=3)  {
            if (match) {
                SearchFromMinus(border2);
            } else {
                SearchFromPlus(x+3);
            }
        }
        else{
Chordy();
        }
    }
    void SearchFromMinus(int x){

        border1 = x;
        boolean match = true;
        for(int i = x+1; i <=x+3 ; i++){
            double result = func(i);

            if (result  > 0) {

                border2 = i;
                arr.add(border1);
                arr.add(border2);
                System.out.println("Отрезок номер "  + arr.size()/2 + ": [" + border1 + "," +border2 + "]" );
                match = false;
                count++;
break;
            }
        }
        if (x+3<100 && count !=3) {
            if (!match) {
                SearchFromPlus(border2);
            }
            else {
                SearchFromMinus(x+3);
            }

        }
        else{
Chordy();
        }
    }
    void Chordy(){

        double x = 0;
        double temp = arr.get(iterations);
        System.out.println("Для отрезка "   + "[" +arr.get(iterations)+ "," + arr.get(iterations+1 )+"] :");
        double xn;

        do {
xn = temp;
x = xn - func(xn)/(func(arr.get(iterations+1)) - func(xn))  * (arr.get(iterations+1) - xn);
            temp = x;
System.out.println(x);

        } while (Math.abs(x-xn) >Epsilon);
        System.out.println(" x = " + x);
        iterations+=2;
        iteration++;
        if(iteration !=3) Chordy();
    }
}