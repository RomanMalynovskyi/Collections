package com.gmail.malynovskyiroman.task4;

import java.util.ArrayDeque;

public class DoubleColaAutomat {

    private ArrayDeque<Human> queue;

    public DoubleColaAutomat() {
        queue = new ArrayDeque<>();
        queue.offerLast(new Human("Sheldon",this));
        queue.offerLast(new Human("Leonard",this));
        queue.offerLast(new Human("Volovitc",this));
        queue.offerLast(new Human("Kutrapalli",this));
        queue.offerLast(new Human("Penny",this));
    }

    public ArrayDeque<Human> getQueue() {
        return queue;
    }

    public void setQueue(ArrayDeque<Human> queue) {
        this.queue = queue;
    }

    public void deliveryCola (int glasses){
        for (int i = 0; i < glasses; i++) {
            queue.getFirst().drinkCola();
        }
    }

    @Override
    public String toString() {
        return "" + queue;
    }
}
