package phase4.chapter16;

/**
 * @classname: TablewarePair
 * @description:
 * @author: Desire
 * @date: 2019-08-08 10:53
 */
public class TablewarePair {

    private final Tableware leftTool;
    private final Tableware rightTool;

    public TablewarePair(Tableware leftTool, Tableware rightTool) {
        this.leftTool = leftTool;
        this.rightTool = rightTool;
    }


    public Tableware getLeftTool() {
        return leftTool;
    }

    public Tableware getRightTool() {
        return rightTool;
    }
}
