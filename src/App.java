import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Access point for the application.
 *
 * @author Zachary Cockshutt
 * @since  2023-11-12
 */
public class App
{
    private Calculator calculator;
    private int totalUnits;

    public App()
    {
        this.calculator = new Calculator();
        this.totalUnits = 0;
    }

    public static void main(String[] args)
    {
        var me = new App();
        me.init(new File(args[0]));
        me.run();
    }

    private void init(File f)
    {
        try (var sc = new Scanner(f))
        {
            var courses = new ArrayList<Course>();
            while (sc.hasNext()) { this.addCourse(sc, courses); }
            this.calculator = new Calculator(courses);
        }
        catch(Exception e)
        {
            System.out.println("Error: "+e);
            System.exit(-1);
        }
    }

    private void addCourse(Scanner sc, ArrayList<Course> courses)
    {
        var code = sc.next();
        var unit = sc.nextInt();
        var mark = sc.nextInt();
        courses.add(new Course(code, unit, mark));
        totalUnits += unit;
    }

    private void run()
    {
        var sc = new Scanner(System.in);
        var selection = 1;
        while (selection != 0)
        {
            System.out.println("\nCalculate WAM [1] | Calculate GPA [2] | Calculate Both [3] | Exit [0]");
            System.out.print("Enter your selection: ");
            selection = sc.nextInt();
            System.out.println();
            switch (selection)
            {
                case 1: runWAM(sc); break;
                case 2: runGPA();   break;
                case 3: runAll(sc); break;
                case 0: break;
                default: System.out.println("Invalid selection");
            }
        } sc.close();
    }

    private void runAll(Scanner sc)
    {
        this.runWAM(sc);
        this.runGPA();
    }

    private void runWAM(Scanner sc)
    {
        System.out.print("Does your degree have embedded Honours? [y/n] ");
        var isHonours = sc.next().equals("y");
        var wam = calculator.calcWAM(isHonours);
        System.out.println(String.format("WAM: %d (%2.2f)", Math.round(wam), wam));
    }

    private void runGPA()
    {
        var gpa = calculator.calcGPA();
        System.out.println(String.format("GPA: %2.2f\nTotal Units: %d", gpa, totalUnits));
    }
}