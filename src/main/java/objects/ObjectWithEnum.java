package objects;

import java.util.Random;

public class ObjectWithEnum {

    public void testEnum(){
        NumberWorker nw = new NumberWorker();
        System.out.println(nw.convertEnum());
    }

    enum Number {low, mid, high}

    class NumberWorker{

        Number randomEnum(){
            Random r = new Random();

            //between 0 and 2
            int randomResult = r.nextInt(3);

            if (randomResult == 0){return Number.low;}

            else if (randomResult == 1){return Number.mid;}

            else {return Number.high;}
        }

        String convertEnum(){
            String s = "";

            Number number = randomEnum();

            switch (number){
                case low: s = "Number is low";
                break;

                case mid: s = "Number is mid";
                break;

                case high: s = "Number is high";
                break;
            }
            return s;
        }
    }
}

