package phase4.chapter16;

public class FlightSecurityTest {

    static class Passengers extends Thread {

        private final FlightSecurity flightSecurity;

        private final String idCard;

        private final String boardingPass;

        public Passengers(FlightSecurity flightSecurity, String idCard, String boardingPass) {
            this.flightSecurity = flightSecurity;
            this.idCard = idCard;
            this.boardingPass = boardingPass;
        }


        @Override
        public void run() {
            while (true) {
                flightSecurity.pass(boardingPass, idCard);
            }


        }


        public static void main(String[] args) {

            final FlightSecurity flightSecurity = new FlightSecurity();

            new Passengers(flightSecurity,"awerffz","asdasdz").start();
            new Passengers(flightSecurity,"awerffz","asdasdz").start();
            new Passengers(flightSecurity,"awerffz","asdasdz").start();
            new Passengers(flightSecurity,"gdfdt","fdghh").start();


        }


    }


}
