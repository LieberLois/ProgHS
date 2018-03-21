public class CarTest  {
    public static void main(String[] args) throws Exception{
        System.out.println("Which car do you want?");
        System.out.println("Audi R8 - MaxSpeed 60 m/s - 10 l / 100km            (1)");
        System.out.println("Fiat Doblo - MaxSpeed 40 m/s - 8 l / 100km          (2)");
        char whichCar = (char)System.in.read();
        Car auto = null;
        if (whichCar == '1') {
            auto = new Car("Audi A8", 60f, 50f, 10f, 50);
        } else if (whichCar == '2'){
            auto = new Car("Fiat Doblo", 40f, 50f, 8f, 50);
        }

        Traffic traffic = new Traffic(auto);
        traffic.setSize(1000, 200);
        traffic.setVisible(true);

        // start animation
        traffic.start();

        System.out.println(auto.toString());
        System.out.println("Starting Motor ...");
        Traffic.waitAWhile(2000);
        auto.setMotorOn();
        System.out.println(auto.toString());
        auto.setSpeed(auto.getMaximumSpeed());
        System.out.println(auto.toString());

        for(int i = 0; i<15; i++){
            Traffic.waitAWhile(1000);
            System.out.println(auto.toString());
        }

        auto.setMotorOff();
        System.out.println("************************");
        System.out.println("Refilling Fuel Tank");
        System.out.println("************************");
        Traffic.waitAWhile(2000);
        System.out.println("Refueled - Starting Motor again ...");
        Traffic.waitAWhile(2000);
        System.out.println("Driving at 30 m/s");
        auto.setMotorOn();
        auto.setSpeed(30f);
        auto.refuel(auto.getFuelTankCapacity());
        for(int i = 0; i<20; i++){
            Traffic.waitAWhile(1000);
            System.out.println(auto.toString());
        }
        System.out.println("Program ended");


    }
}