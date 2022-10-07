package agh.ics.oop;
import static java.lang.System.out;

public class World {
    public static void run(String[] args){
        out.println("Zwierzak idzie do przodu");
        for (Integer i=0;i<args.length;i++) {
            switch (args[i]) {
                case "f":
                    out.println("Zwierzak idzie do przodu");
                    break;
                case "b":
                    out.println("Zwierzak idzie do tyłu");
                    break;
                case "r":
                    out.println("Zwierzak skręca w prawo");
                    break;
                case "l":
                    out.println("Zwierzak skręca w lewo");
                    break;
                default:
                    break;
            }
        }
    }
    public static void main(String[] args){
        out.println("system wystartował");
        run(args);
        out.println("system zakończył działanie");
    }
}
