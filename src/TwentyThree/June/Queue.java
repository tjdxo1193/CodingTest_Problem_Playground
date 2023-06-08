package TwentyThree.June;

import java.util.List;

public class Queue<E> {
    private int tailPointer;
    private int headPointer;
    private List<E> dat;
    boolean add(E e){
        return this.dat.add(e);
    }

    boolean offer(E e){
        return this.dat.add(e);
    }

    E remove(){
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
