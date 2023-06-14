package TwentyThree.June.dataStructure;

import java.util.List;

public class Queue<E> {
    private int tailPointer;
    private int headPointer;
    private List<E> dat;

    boolean add(E e){
        this.tailPointer++;
        return this.dat.add(e);
    }

    boolean offer(E e){
        this.tailPointer++;
        return this.dat.add(e);
    }

    E remove(){
        this.headPointer--;
        return this.dat.remove(headPointer);
    }
//    E poll(){
//        return
//    };
//
//    E element(){
//        return new E();
//    }

    E peek(){
        return dat.get(headPointer);
    }
}
