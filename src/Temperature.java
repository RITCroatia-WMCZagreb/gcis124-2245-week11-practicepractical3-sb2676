import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Temperature {

    public interface TemperatureScale {//functional interface
        double convert(double temperature);
    }

    /**
     * Part A
     * Create and return an anonymous class of type TemperatureScale that
     * converts a temperature given in Fahrenheit to Celsius
     * C = (F - 32) / 1.8
     * @return
     */
    public static TemperatureScale createF2C() {
        TemperatureScale f2C = null;


        // Delete from here
        f2C = new TemperatureScale() {//instantiate new class in a variable

            @Override
            public double convert(double temperature) {
                double c=(temperature -32)/1.8;
                return c;
            }
            
           };

        
        // to here

        return f2C;
    }

    /**
     * Part B
     * Create and return an lambda of type TempConv that
     * converts a temperature given in Celsius to Fahrenheit
     * F = (C * 1.8) + 32
     * @return
     */
    public static TemperatureScale createC2F() {
        TemperatureScale c2F = null;

        // Delete from here
       
        c2F = (temperature)->{
            double c=(temperature*1.8)+32;
            return c;
        };

        // to here

        return c2F;
    }

    public static void main(String[] args) {
        
        TemperatureScale c2F = createC2F();
        TemperatureScale f2C = createF2C();

        List<Double> temps = Arrays.asList(0.0, 32.0, 12.3, 45.6, -12.0);

        List<Double> celsiusTemps = new ArrayList<>();
        List<Double> fahrenheitTemps = new ArrayList<>();

        // Part C
        // For each temperature in temps
            // 1. Use c2F variable to convert the temperature to Fahrenheit and
            //    store result in fahrenheitTemps
            // 2. Use f2C variable to convert the temperature to Celsius and
            //    store result in celciusTemps
        // Delete from here
        for(double temp:temps){
            double celsius=f2C.convert(temp);
            celsiusTemps.add(celsius);
            double fahrenheit=c2F.convert(temp);
            fahrenheitTemps.add(fahrenheit);
        }
        System.out.println("Celsius: "+celsiusTemps);
        System.out.println("fahrenheit: "+fahrenheitTemps);
        System.out.println();
       

        // to here

        // Part D
        // Using stream(), filter(), and forEach(), print on a separate line all
        // elements of fahrenheitTemps that are *above* feezing (32F)
        // Delete from here
        fahrenheitTemps.stream().filter(temp->temp>32).forEach(System.out::println);
      
       
      
        // to here

        // Part E
        // Using streams(), filter(), and forEach(), print on a separate line all
        // elements of celsiusTemps that are *below* freezing (0C)
        // Delete from here
      
        celsiusTemps.stream().filter(temp->temp<0).forEach(System.out::println);
      
        // to here
    }
    
}
