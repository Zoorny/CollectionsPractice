package listpack;


import java.util.*;

public class MyTests {

    public void basicTests(){
        ILinkedList<Pet> pets = new MyLinkedList<Pet>();
        Doggo d1 = new Doggo("Bet", 10);
        Doggo d2 = new Doggo("Chus", 5);
        Pet d3 = new Cat("Glue", 15);
        Pet d4 = new Cat("LongTestCatNameHere", 155);
        pets.add(d1);
        pets.add(d2);
        pets.add(d3);
        pets.add(2,d4);

        System.out.println(pets);

        System.out.println("pet() method from array: ");
        Object[] arr;
        arr = (Object[]) pets.toArray();
        for (int i =0; i < arr.length; i++){
            Pet p = (Pet) arr[i];
            p.pet();
        }
        System.out.println("Index of d3--->" + pets.indexOf(d3));
        System.out.println("get element with index 2--->"+pets.get(2));
        System.out.println("size = " + pets.size());
        pets.remove(2);
        System.out.println("removed long named pet with index 2--->"+pets);
        System.out.println("size again = " + pets.size());
        pets.set(0,d4);
        System.out.println("set pet with index 0 as d4(long named one) \n"+pets);


        pets.clear();
        System.out.println("empty pets list after clear()--->"+pets);
    }


    public void timeComplexityMyLL(){
        System.out.println();
        System.out.println("Time complexity comparison:");
        MyLinkedList myLinkedList = new MyLinkedList();
        LinkedList linkedList = new LinkedList();
        for (int i =0; i < 100000; i++){
            myLinkedList.add(new Cat("Cat", 2));
            linkedList.add(new Cat("Cat", 2));
        }
        Cat last = new Cat("myLastCat", 10);
        long startTime, endTime1, endTime2;

        startTime = System.nanoTime();
        myLinkedList.add(last);
        endTime1 = (System.nanoTime() - startTime);

        startTime = System.nanoTime();
        linkedList.add(last);
        endTime2 = (System.nanoTime() - startTime);


        System.out.println("add() comparison: \n MyLinkedList: " + endTime1 + "ns LinkedList: " + endTime2 + "ns");

        startTime = System.nanoTime();
        myLinkedList.get(100000);
        endTime1 = (System.nanoTime() - startTime);

        startTime = System.nanoTime();
        linkedList.get(100000);
        endTime2 = (System.nanoTime() - startTime);

        System.out.println("get() comparison (index 100000): \n MyLinkedList: " + endTime1 + "ns LinkedList: " + endTime2 + "ns");

        startTime = System.nanoTime();
        myLinkedList.get(0);
        endTime1 = (System.nanoTime() - startTime);

        startTime = System.nanoTime();
        linkedList.get(0);
        endTime2 = (System.nanoTime() - startTime);

        System.out.println("get() comparison (index 0): \n MyLinkedList: " + endTime1 + "ns LinkedList: " + endTime2 + "ns");

        startTime = System.nanoTime();
        myLinkedList.remove(0);
        endTime1 = (System.nanoTime() - startTime);

        startTime = System.nanoTime();
        linkedList.remove(0);
        endTime2 = (System.nanoTime() - startTime);

        System.out.println("remove() comparison (index 0): \n MyLinkedList: " + endTime1 + "ns LinkedList: " + endTime2 + "ns");

        startTime = System.nanoTime();
        myLinkedList.remove(10000);
        endTime1 = (System.nanoTime() - startTime);

        startTime = System.nanoTime();
        linkedList.remove(10000);
        endTime2 = (System.nanoTime() - startTime);

        System.out.println("remove() comparison (index 10000): \n MyLinkedList: " + endTime1 + "ns LinkedList: " + endTime2 + "ns");



    }

    public void timeComplexityLists(){
        System.out.println("ArrayList, LinkedList tests");
        ArrayList arrayList = new ArrayList();
        LinkedList linkedList = new LinkedList();

        for (int i =0; i < 100000; i++){
            linkedList.add(new Cat("Cat", 2));
            arrayList.add(new Cat("Cat", 2));
        }
        Cat last = new Cat("myLastCat", 10);
        long startTime, endTime1, endTime2;

        startTime = System.nanoTime();
        arrayList.add(last);
        endTime1 = (System.nanoTime() - startTime);

        startTime = System.nanoTime();
        linkedList.add(last);
        endTime2 = (System.nanoTime() - startTime);

        System.out.println("add() comparison: \n ArrayList: " + endTime1 + "ns LinkedList: " + endTime2 + "ns");

        startTime = System.nanoTime();
        arrayList.add(90000,last);
        endTime1 = (System.nanoTime() - startTime);

        startTime = System.nanoTime();
        linkedList.add(90000, last);
        endTime2 = (System.nanoTime() - startTime);

        System.out.println("add(index: 90000, element) comparison: \n ArrayList: " + endTime1 + "ns LinkedList: " + endTime2 + "ns");

        startTime = System.nanoTime();
        arrayList.remove(90000);
        endTime1 = (System.nanoTime() - startTime);

        startTime = System.nanoTime();
        linkedList.remove(90000);
        endTime2 = (System.nanoTime() - startTime);

        System.out.println("remove(90000, element) comparison: \n ArrayList: " + endTime1 + "ns LinkedList: " + endTime2 + "ns");





    }

    public void timeComplexitySets(){
        System.out.println("HashSet, LinkedHashSet, TreeSet tests");

        HashSet hashSet = new HashSet();
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        TreeSet treeSet = new TreeSet();

        for (int i = 0; i < 100000; i++) {
            hashSet.add(i);
            linkedHashSet.add(i);
            treeSet.add(i);
        }

        long startTime, endTime1, endTime2, endTime3;

        startTime = System.nanoTime();
        hashSet.add(100000);
        endTime1 = (System.nanoTime() - startTime);

        startTime = System.nanoTime();
        linkedHashSet.add(100000);
        endTime2 = (System.nanoTime() - startTime);

        startTime = System.nanoTime();
        linkedHashSet.add(100000);
        endTime3 = (System.nanoTime() - startTime);

        System.out.println("add() comparison: \n HashSet: " + endTime1 + "ns LinkedHashSet: " + endTime2 + "ns TreeSet: " + endTime3 + "ns" );

        startTime = System.nanoTime();
        hashSet.contains(90000);
        endTime1 = (System.nanoTime() - startTime);

        startTime = System.nanoTime();
        linkedHashSet.contains(90000);
        endTime2 = (System.nanoTime() - startTime);

        startTime = System.nanoTime();
        linkedHashSet.contains(90000);
        endTime3 = (System.nanoTime() - startTime);

        System.out.println("contains() comparison: \n HashSet: " + endTime1 + "ns LinkedHashSet: " + endTime2 + "ns TreeSet: " + endTime3 + "ns" );

        startTime = System.nanoTime();
        hashSet.remove(90000);
        endTime1 = (System.nanoTime() - startTime);

        startTime = System.nanoTime();
        linkedHashSet.remove(90000);
        endTime2 = (System.nanoTime() - startTime);

        startTime = System.nanoTime();
        linkedHashSet.remove(90000);
        endTime3 = (System.nanoTime() - startTime);

        System.out.println("remove() comparison: \n HashSet: " + endTime1 + "ns LinkedHashSet: " + endTime2 + "ns TreeSet: " + endTime3 + "ns" );
    }

    public void timeComplexityMaps(){
        System.out.println("HashMap, LinkedHashMap, TreeMap tests");
        HashMap hashMap = new HashMap();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        TreeMap treeMap = new TreeMap();


        for (int i = 0; i < 100000; i++) {
            hashMap.put(i, i);
            linkedHashMap.put(i, i);
            treeMap.put(i, i);
        }

        long startTime, endTime1, endTime2, endTime3;

        startTime = System.nanoTime();
        hashMap.put(100000, 100000);
        endTime1 = (System.nanoTime() - startTime);

        startTime = System.nanoTime();
        linkedHashMap.put(100000, 100000);
        endTime2 = (System.nanoTime() - startTime);

        startTime = System.nanoTime();
        treeMap.put(100000, 100000);
        endTime3 = (System.nanoTime() - startTime);

        System.out.println("put() comparison: \n HashMap: " + endTime1 + "ns LinkedHashMap: " + endTime2 + "ns TreeMap: " + endTime3 + "ns" );

        startTime = System.nanoTime();
        hashMap.containsValue(50000);
        endTime1 = (System.nanoTime() - startTime);

        startTime = System.nanoTime();
        linkedHashMap.containsValue(50000);
        endTime2 = (System.nanoTime() - startTime);

        startTime = System.nanoTime();
        treeMap.containsValue(50000);
        endTime3 = (System.nanoTime() - startTime);

        System.out.println("containsValue() comparison: \n HashMap: " + endTime1 + "ns LinkedHashMap: " + endTime2 + "ns TreeMap: " + endTime3 + "ns" );

        startTime = System.nanoTime();
        hashMap.remove(50000);
        endTime1 = (System.nanoTime() - startTime);

        startTime = System.nanoTime();
        linkedHashMap.remove(50000);
        endTime2 = (System.nanoTime() - startTime);

        startTime = System.nanoTime();
        treeMap.remove(50000);
        endTime3 = (System.nanoTime() - startTime);

        System.out.println("remove() comparison: \n HashMap: " + endTime1 + "ns LinkedHashMap: " + endTime2 + "ns TreeMap: " + endTime3 + "ns" );

    }


}
