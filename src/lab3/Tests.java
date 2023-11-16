package lab3;

import lab3.animals.classes.Mammals;
import lab3.animals.families.Feline;
import lab3.animals.families.Hedgehog;
import lab3.animals.kinds.CommonHedgehog;
import lab3.animals.kinds.Lynx;
import lab3.animals.kinds.Manul;
import lab3.animals.squads.Insectivores;
import lab3.animals.squads.Predatory;
import lab3.animals.types.Chordate;

import java.util.ArrayList;
import java.util.List;

public class Tests {

    public static void print(List<? extends Chordate> collection) {
        for (Chordate c: collection) {
            System.out.println(c.getClass());
        }
    }

    public static void firstTest() {
        List<Mammals> mammalsList = new ArrayList<>();

        mammalsList.add(new Lynx(13, 100));
        mammalsList.add(new Lynx(10, 93));

        mammalsList.add(new CommonHedgehog(0.6, 25));
        mammalsList.add(new CommonHedgehog(0.7, 26));
        mammalsList.add(new CommonHedgehog(0.8, 28));
        mammalsList.add(new CommonHedgehog(0.9, 29));

        mammalsList.add(new Manul(0.45, 3));
        mammalsList.add(new Manul(0.5, 3.5));
        mammalsList.add(new Manul(0.6, 4));

        List<Hedgehog> hedgehogList = new ArrayList<>();
        List<Feline> felineList = new ArrayList<>();
        List<Predatory> predatoryList = new ArrayList<>();

        System.out.println("Млекопитающие:");
        print(mammalsList);

        Segregation.segregate(mammalsList, hedgehogList, felineList, predatoryList);

        System.out.println("Ежовые:");
        print(hedgehogList);
        System.out.println("Кошачьи:");
        print(felineList);
        System.out.println("Хищные:");
        print(predatoryList);
    }

    /*public static void secondTest() {

        List<Predatory> predatoryList = new ArrayList<>();

        predatoryList.add(new Lynx(13, 100));
        predatoryList.add(new Lynx(10, 93));

        predatoryList.add(new Manul(0.45, 3));
        predatoryList.add(new Manul(0.5, 3.5));
        predatoryList.add(new Manul(0.6, 4));

        List<Chordate> chordateList = new ArrayList<>();
        List<Manul> manulList = new ArrayList<>();
        List<Feline> felineList = new ArrayList<>();

        System.out.println("Хищные:");
        print(predatoryList);

        Segregation.segregate(predatoryList, chordateList, manulList, felineList);

        System.out.println("Хордовые:");
        print(chordateList);
        System.out.println("Манулы:");
        print(manulList);
        System.out.println("Кошачьи:");
        print(felineList);
    }

    public static void thirdTest() {

        List<Hedgehog> hedgehogList = new ArrayList<>();

        hedgehogList.add(new CommonHedgehog(0.6, 25));
        hedgehogList.add(new CommonHedgehog(0.7, 26));
        hedgehogList.add(new CommonHedgehog(0.8, 28));
        hedgehogList.add(new CommonHedgehog(0.9, 29));

        List<Insectivores> insectivoresList = new ArrayList<>();
        List<Predatory> predatoryList1 = new ArrayList<>();
        List<Predatory> predatoryList2 = new ArrayList<>();

        System.out.println("Ежовые:");
        print(hedgehogList);

        Segregation.segregate(hedgehogList, insectivoresList, predatoryList1, predatoryList2);

        System.out.println("Насекомоядные:");
        print(insectivoresList);
        System.out.println("Хищные:");
        print(predatoryList1);
        System.out.println("Хищные:");
        print(predatoryList1);
    }
*/
}
