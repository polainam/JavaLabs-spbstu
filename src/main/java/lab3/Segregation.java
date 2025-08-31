package lab3;

import lab3.animals.classes.Mammals;
import lab3.animals.kinds.CommonHedgehog;
import lab3.animals.kinds.Lynx;
import lab3.animals.kinds.Manul;

import java.util.Collection;
import java.util.Iterator;

public class Segregation {
    public static void segregate(Collection<? extends Mammals> srcCollection,
                                 Collection<? super CommonHedgehog> collection1,
                                 Collection<? super Manul> collection2,
                                 Collection<? super Lynx> collection3) {
        Iterator<? extends Mammals> iterator = srcCollection.iterator();

        while (iterator.hasNext()) {
            Mammals mammal = iterator.next();
            if (mammal instanceof CommonHedgehog) {
                collection1.add((CommonHedgehog) mammal);
            } else if (mammal instanceof Manul) {
                collection2.add((Manul) mammal);
            } else if (mammal instanceof Lynx) {
                collection3.add((Lynx) mammal);
            }
            iterator.remove();
        }
    }
}
