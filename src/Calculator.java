import java.util.ArrayList;
import java.util.List;

/**
 * TODO: add class desc
 *
 * @author Zachary Cockshutt
 * @since  2023-11-12
 */
public class Calculator
{
    private List<Course> courses;
    private float gpa;

    public Calculator()
    {
        this.courses = new ArrayList<Course>();
        this.gpa = -1;
    }

    public Calculator(ArrayList<Course> courses)
    {
        this();
        this.courses = courses;
    }

    public float calcWAM(boolean isHonours)
    {
        float x = 0.0f, y = 0.0f;
        for (var c : courses)
        {
            var w = c.getWeight();
            if (w == 1 && isHonours) { w = 0; }
            x += (c.getMark() * c.getUnits() * w);
            y += (c.getUnits() * w);
        }
        if (y == 0) { return 0; }
        return x / y;
    }

    public float calcGPA()
    {
        if (this.gpa > -1) { return gpa; }
        float x = 0.0f, y = 0.0f;
        for (var c : courses)
        {
            x += calcGradePoint(c.getMark()) * c.getUnits();
            y += c.getUnits();
        }
        this.gpa = x / y;
        return this.gpa;
    }

    private int calcGradePoint(int mark)
    {
        int gp = 0;
        var ranges = new int[] { 84, 74, 64, 49 };
        for (int i = 0; i < ranges.length; i++)
        {
            if (mark <= ranges[i]) { continue; }
            gp = 7 - i;
            break;
        }
        return gp;
    }

    public String toString()
    {
        var str = String.format("%-9s %-6s %-6s %s", "Code", "Units", "Mark", "Weight");
        str += String.format("\n%-30s\n", "").replace(" ", "-");
        for (var c : courses) { str += c.toString()+"\n"; }
        return str;
    }
}