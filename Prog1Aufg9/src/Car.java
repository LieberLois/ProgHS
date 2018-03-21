public class Car  {
    private float x;
    private boolean motorOn = false;
    private float speed = 0;
    private float fuelTankCapacity;
    private float fuel;
    private float maximumSpeed;
    private long carTime;
    private String carName;
    private float consumption;
    private int y;

    public Car(final String name, final float maximumSpeed, final float maxFuel, final float consumpt, int y){
        fuelTankCapacity = maxFuel;
        this.maximumSpeed = maximumSpeed;
        carName = name;
        carTime = System.currentTimeMillis()/1000;
        fuel = maxFuel;
        consumption = consumpt;
        this.y = y;
    }


    // dummy implementations, change it !!!
    public float getX(){
        updateState();
        return x;
    }

    public float getY()  {
        return y;
    }


    public boolean getMotorOn() {
        return motorOn;
    }

    public float getFuelTankCapacity() {
        return fuelTankCapacity;
    }

    public float getFuel() {
        return fuel;
    }

    public float getMaximumSpeed() {
        return maximumSpeed;
    }

    public float getSpeed() {
        return speed;
    }


    public void setMotorOn(){
        motorOn = true;
    }
    public void setMotorOff(){
        motorOn = false;
    }

    public long getTime(){

        updateState();
        return carTime;
    }

    public void setTime(long newTime){
        carTime = newTime;
    }

    public void setSpeed(float f){
        updateState();
        if((speed >= 0) && speed <= fuelTankCapacity){
            speed = f;
        }
    }

    public void refuel(float f){
        if((fuel + f) < fuelTankCapacity){
            fuel += f;
        } else {
            fuel = fuelTankCapacity;
        }
    }

    /*
    public void tick(long ms){
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        updateState();
    }
    */

    private void updateState(){

        if((!(motorOn) || speed == 0.0) || (fuel == 0.0)) {
            setTime(System.currentTimeMillis()/1000);
            return;
        }

        if(consumption < fuel) {
            float oldX = x;
            double deltaTime = System.currentTimeMillis()/1000 - carTime;
            x += speed * (deltaTime);
            carTime += (deltaTime);

            /*
            Beispiel: 10 l auf 100 km => Verbrauch = x/100*10

             */
            fuel -= (consumption * (x - oldX) / (100)); // Noch mal 1000, aber zu lang
        } else {
            double deltaTime = System.currentTimeMillis()/1000 - carTime;
            x += speed * deltaTime * 2;
            carTime += (deltaTime);
            deltaTime = System.currentTimeMillis()/1000 - carTime;
            x += speed * deltaTime * 2;
            carTime += (deltaTime);
            speed = 0;
            fuel = 0;
            motorOn = false;
        }

    }

    public String toString(){
        return "Car: " + carName + " - MotorOn: " + motorOn + " - Speed: " + speed + " m/s  - Current Fuel: " + fuel + " - Car Time: " + carTime + " - Distance Travelled: " + (x);
    }

}