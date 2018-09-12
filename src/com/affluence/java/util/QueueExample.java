package com.affluence.java.util;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class QueueExample {

    public static void main(String[] args) {

        Queue<String> qe=new LinkedList<String>();

        qe.add("b");
        qe.add("a");
        qe.add("c");
        qe.add("e");
        qe.add("d");
    Map map=new HashMap();
    map.put("c", "cc");
    map.put("b", "bb");
    map.put("d", "dd");
    map.put("e", "ee");
    map.put("a", "aa");
    
        Iterator it=qe.iterator();

        System.out.println("Initial Size of Queue :"+qe.size());

        while(it.hasNext())
        {
            String iteratorValue=(String)it.next();
            System.out.println("Queue Next Value :"+map.get(iteratorValue));
        }

        // get value and does not remove element from queue
        System.out.println("Queue peek :"+qe.peek());

        // get first value and remove that object from queue
        System.out.println("Queue poll :"+qe.poll());

        System.out.println("Final Size of Queue :"+qe.size());
    }
}
