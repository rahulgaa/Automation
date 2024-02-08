package JavaPackage;


class Car{
    void car()
    {
        System.out.println("Class Car");
    
    }
    void vehicleType()
    {
        System.out.println("Vehicle Type: Car");
    }
}

class Maruti extends Car
{
    Maruti ()
    {
        System.out.println("Class Maruti");
    }
    void brand ()
    {
        System.out.println("Brand: Maruti");
    }
    void speed()
    {
        System.out.println("Max 90 kmph");
    }
}

public class Maruti800 extends Maruti
{
    public Maruti800 ()
    {
        System.out.println("Maruti Model: 800");
    }
    public void speed()
    {
        System.out.println("Max: 80kmph");
    }
    public static void main (String args[])
    {
        Maruti800 obj = new Maruti800();
        obj.car();
        obj.vehicleType();
        obj.brand();
        obj.speed();
    }
}
