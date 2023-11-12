/**
 * TODO: add class desc
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

    private void init()
    {
        initMark();
        initWeight();
    }

    private void initMark()
    {
        var m = this.mark;
        if (m < 44) { m = 44; }
        this.mark = m;
    }

    private void initWeight()
    {
        var w = this.code.charAt(4) - 48;
        if (w > 4) { w = 4; }
        this.weight = w;
    }

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