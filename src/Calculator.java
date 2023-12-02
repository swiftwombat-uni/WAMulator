import java.util.ArrayList;
import java.util.List;

/**
 * Implements the calulation logic for the WAMulator. It should be
 * first initialised with a list of courses that should be input
 * via a text file (see README.md for input formatting guide).
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

    /**
     * Calculates the Weighted Average Mark (WAM) from the list of
     * courses passed to this calculator instance. For details on
     * the calculation used, regard the README.md
     *
     * @param isHonours Specifies if the degree contains embedded
     *                  honours or not.
     * @return The WAM for the provided course list.
     */
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

    /**
     * Calculates the Grade Point Average (GPA) from the marks and
     * unit values of the course list passed to the calculator. For
     * details on the exact calculation used, regard the README.md
     *
     * @return The GPA for the provided course list
     */
    public float calcGPA()
    {
        float x = 0.0f, y = 0.0f;
        for (var c : courses)
        {
            x += calcGradePoint(c.getMark()) * c.getUnits();
            y += c.getUnits();
        }
        if (y == 0) { return 0; }
        this.gpa = x / y;
        return this.gpa;
    }

    /**
     * Maps the given mark to the 7 point grade point that UoN uses.
     * The grade points are HD [85+] = 7, D [75-84] = 6, C [65-74] = 5,
     * P [50-64] = 4, FF [0-49] = 0.
     *
     * @param mark The course mark to map to a grade point.
     * @return The grade point for the given mark.
     */
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

    /**
     * Generates a string representing the course list passed to the
     * calculator. This will be in the form of a table, with a coloumn
     * for each data point of a course (code, units, mark and weight)
     *
     * @return The string representing a table of course data.
     */
    public String toString()
    {
        var str = String.format("%-9s %-6s %-6s %s", "Code", "Units", "Mark", "Weight");
        str += String.format("\n%-30s\n", "").replace(" ", "-");
        for (var c : courses) { str += c.toString()+"\n"; }
        return str;
    }
}