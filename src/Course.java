/**
 * Represents a UoN course with the data that is relavent to
 * the WAMulator; namely the course code, unit value, final
 * mark and weighting (derrived from the code).
 *
 * @author Zachary Cockshutt
 * @since  2023-11-12
 */
public class Course
{
    private String code;
    private int units, mark, weight;

    public Course()
    {
        code = "";
        units = 0;
        mark = 0;
        weight = 0;
    }

    public Course(String code, int units, int mark)
    {
        this();
        this.code = code;
        this.units = units;
        this.mark = mark;
        this.init();
    }

    /**
     * Initialises the courses data by applying a lower bound
     * of 44 to the final mark and then determining the course
     *  weighting based off the course code. This is to align
     * course data with UoN guidelines (see README.md).
     */
    private void init()
    {
        initMark();
        initWeight();
    }

    /**
     * Applies a lower bound of 44 to this courses mark.
     */
    private void initMark()
    {
        var m = this.mark;
        if (m < 44) { m = 44; }
        this.mark = m;
    }

    /**
     * Parses the course code to retrieve the weight via the
     * fourth char. This is then upper bounded to 4.
     */
    private void initWeight()
    {
        var w = this.code.charAt(4) - 48;
        if (w > 4) { w = 4; }
        this.weight = w;
    }

    /**
     * Generates a string containing all the course data in a
     * standard format. This string is designed to match the
     * table print out of the Calculator.toString() method.
     *
     * @return The string representation of a course.
     */
    public String toString()
    {
        return String.format("%-9s %-6d %-6d %d", code, units, mark, weight);
    }

    /* Getters */

    public int getMark()
    {
        return mark;
    }

    public int getUnits()
    {
        return units;
    }

    public int getWeight()
    {
        return weight;
    }
}