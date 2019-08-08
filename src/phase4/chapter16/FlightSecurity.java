package phase4.chapter16;

/**
 * @classname: FlightSecurity
 * @description: 非线程安全
 * @author: Desire
 * @date: 2019-08-07 17:00
 */
public class FlightSecurity {

    private int count = 0;

    private String boardingPass = "null";

    private String idCard = "null";

    public synchronized void pass(String boardingPass,String idCard){
        this.boardingPass = boardingPass;
        this.idCard = idCard;
        this.count ++;
        check();
    }
    private String check(){

        if(boardingPass.startsWith("a") && idCard.endsWith("z")){
            System.out.println("have a good trip,sir!");
            return "have a good trip,sir!";
        }else {
            throw new RuntimeException("Police Officer, catch him !");
        }
    }

}
