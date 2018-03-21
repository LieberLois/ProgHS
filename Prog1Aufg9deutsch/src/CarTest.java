public class CarTest  {
    public static void main(String[] args) throws Exception{

        Car auto = new Car("Bugatti Chiron", 120f, 50f, 15f, 50);
        Traffic traffic = new Traffic(auto);
        traffic.setSize(1000, 200);
        traffic.setVisible(true);

        // start animation
        traffic.start();

        System.out.println(auto.toString());
        System.out.println("Starte Motor...");
        Thread.sleep(2000);
        auto.setMotorOn();
        System.out.println(auto.toString());
        auto.setSpeed(50f);
        System.out.println(auto.toString());

        while(auto.fuelStatus() > 0){
            Traffic.waitAWhile(1000);
            System.out.println(auto.toString());
        }

        auto.setMotorOff();
        System.out.println("************************");
        System.out.println("     Fülle Tank auf");
        System.out.println("************************");
        Thread.sleep(2000);
        System.out.println("Aufgtankt - Starte Motor...");
        Thread.sleep(2000);
        System.out.println("Fahre 40 m/s");
        auto.setMotorOn();
        auto.setSpeed(80f);
        auto.refuel(30f);
        System.out.println(auto.toString());

        while(auto.fuelStatus() > 0){
            Traffic.waitAWhile(1000);
            System.out.println(auto.toString());
        }

        System.out.println("Am Ziel angekommen");


    }
}