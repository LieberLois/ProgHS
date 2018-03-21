public class Car  {

    private float x;
    private boolean motorStatus = false;
    private float speed = 0;
    private float fuelTankCapacity;
    private float fuel;
    private float maxSpeed;
    private long carTime;
    private String carName;
    private float consumption;
    private int y;

    public Car(final String name, final float maxSpeed, final float maxFuel, final float consumpt, int y){
        fuelTankCapacity = maxFuel;
        this.maxSpeed = maxSpeed;
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
        return motorStatus;
    }

    public float getFuelTankCapacity() {
        return fuelTankCapacity;
    }

    public float getFuel() {
        return fuel;
    }

    public float getMaxSpeed() {
        return maxSpeed;
    }

    public float getSpeed() {
        return speed;
    }


    public void setMotorOn()    {
        motorStatus = true;
    }
    public void setMotorOff()   {
        motorStatus = false;
    }

    public long getTime(){
        updateState();
        return carTime;
    }

    public void setTime(long newTime)   {
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


    public void tick(long ms) throws Exception  {
        Thread.sleep(ms);
        updateState();
    }

    private void updateState(){

        if((!(motorStatus) || speed == 0.0) || (fuel == 0.0)) {
            setTime(System.currentTimeMillis()/1000);
            return;
        }

        float conStatus = (consumption * speed)/100000;

        if(fuel > 0) {
            double deltaTime = System.currentTimeMillis()/1000 - carTime;
            float oldX = x;
            x += speed * (deltaTime);
            carTime += (deltaTime);


            // Beispiel: 10 l auf 100 km => Verbrauch = x/100*10
            fuel -= (consumption * (x - oldX) / (1000));

            if(fuel < 0) {
                fuel = 0;
                speed = 0;
                motorStatus = false;
            }
        }
    }

    public float fuelStatus() {
        float fuelStatus = (fuel);
        return fuelStatus;
    }

    public String toString(){
        return "Auto: " + carName + " - Motor Status: " + motorStatus + " - Geschwindigkeit: " + speed + " m/s  - Tank: " + fuel + "  - Consumpt.: " + consumption +" - Auto Zeit: " + carTime + " - Distanz zurückgelegt: " + (x);
    }
}