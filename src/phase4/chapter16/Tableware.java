package phase4.chapter16;

/**
 * @classname: Tableware
 * @description:
 * @author: Desire
 * @date: 2019-08-08 10:15
 */
public class Tableware {

    private final String toolName;

    public Tableware(String toolName) {
        this.toolName = toolName;
    }


    @Override
    public String toString() {
        return "Tool: " + toolName;
    }
}
