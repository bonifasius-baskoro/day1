import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    static double calculateTriangleArea(double base, double height){
        return base*height/2;
    }
    static double calculateDiameter (double radius){
        return radius*2;
    }

    static double calculateCircumference (double radius){
        return 3.14*radius*2;
    }

    static double calculateCircleArea(double radius){
        return 3.14*radius*radius;
    }

    static String getCircleInfo(double radius){
        double diameter = calculateDiameter(radius);
        double circumference = calculateCircumference(radius);
        double circleArea = calculateCircleArea(radius);
        return "diameter: " + diameter + " circumference: "+ circumference+" circleArea: " + circleArea;
    }

    static double getAngle(double angle1, double angle2){
        if (180-angle1-angle2 > 0){
            return 180-angle1-angle2;
        }
        throw new IllegalArgumentException("wrong angle");
    }
    static Integer getDays (String date1, String date2){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-uuuu");
        LocalDate dt1= LocalDate.parse(date1,formatter);
        LocalDate dt2= LocalDate.parse(date2,formatter);

        return dt2.compareTo(dt1);
    }

    static String getInitial(String name){
        char initial1 = name.charAt(0);
        char initial2 = name.charAt(name.indexOf(" ")+1);
        String initialResult = ""+initial1+initial2;
        return initialResult.toUpperCase();
    }

    static String getInitial2(String name){
      List<String> listOfInitial = new ArrayList<>();
        Pattern pat = Pattern.compile("\\b[a-zA-Z]");
        Matcher m1 = pat.matcher(name);
        while (m1.find()){
            listOfInitial.add(m1.group());
        }
        return String.join("",listOfInitial);
    }

    public static void main(String[] args) {

        System.out.println(calculateTriangleArea(2.4,3.5));
        System.out.println(getCircleInfo(2.5));
        System.out.println("the last angle: " + getAngle(150,29));
        System.out.println("days differences: " + getDays("20-02-2024", "22-02-2024"));

        System.out.println(getInitial("Kentucky Friend Chicken"));
        System.out.println(getInitial2("Kentucky Fried Chicken"));



    }
}