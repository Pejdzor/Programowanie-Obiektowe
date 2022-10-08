package agh.ics.oop;
import static java.lang.System.out;

public class World {
    public static void run(Direction[] args){
        out.println("Zwierzak idzie do przodu");
        for (Integer i=0;i<args.length;i++) {
            switch (args[i]) {
                case FORWARD:
                    out.println("Zwierzak idzie do przodu");
                    break;
                case BACKWARD:
                    out.println("Zwierzak idzie do tyłu");
                    break;
                case LEFT:
                    out.println("Zwierzak skręca w prawo");
                    break;
                case RIGHT:
                    out.println("Zwierzak skręca w lewo");
                    break;
                default:
                    break;
            }
        }
    }
    public static void main(String[] args){
        out.println("system wystartował");
        // Tutaj jakiś konstruktor enuma, jeszcze nie napisałem szefuńciu :<<
        run(args);
        out.println("system zakończył działanie");
    }
}
