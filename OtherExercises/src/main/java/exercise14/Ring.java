package exercise14;

import java.util.Iterator;

public class Ring <T> implements Iterable<T>{
    private RingElement current = null;
    private int count = 0;
    public void add(T element){
        RingElement newElement;
        if(current == null){
            newElement = new RingElement(element);
            this.current = newElement;
        }else{
            newElement = new RingElement(element, current, current.next);
            current.next.previous = newElement;
            current.next = newElement;
        }
        incrementCount();
    }

    public void remove(){
        if(current == null) throw new InvalidOperationOverEmptyRingException();
        if(size() == 1) {
            current.previous = null;
            current.next = null;
            current = null;
        }
        else {
            current.previous.next = current.next;
            current.next.previous = current.previous;
            current = current.next;
        }
        decrementCount();
    }

    private void incrementCount(){
        count++;
    }
    private void decrementCount(){
        count--;
    }

    public int size(){
        return count;
    }

    public T getNext(){
        if(current == null) throw new InvalidOperationOverEmptyRingException();
        this.current = current.next;
        return current.self;
    }

    public T getPrevious(){
        if(current == null) throw new InvalidOperationOverEmptyRingException();
        this.current = current.previous;
        return current.self;
    }

    public T getCurrent(){
        if(current == null) throw new InvalidOperationOverEmptyRingException();
        return this.current.self;
    }

    @Override
    public Iterator<T> iterator() {
        if(current == null) throw new InvalidOperationOverEmptyRingException();
        return new Iterator<T>() {
            {
                current = current.previous;
            }
            private int returnedValues = 0;
            @Override
            public boolean hasNext() {
                return returnedValues++ < count;
            }

            @Override
            public T next() {
                return getNext();
            }
        };
    }

    private class RingElement {
        private RingElement previous;
        private RingElement next;
        private T self;

        private RingElement (T self, RingElement previous, RingElement next){
            this.self = self;
            this.previous = previous;
            this.next = next;
        }

        private RingElement(T self){
            this.self = self;
            this.previous = this;
            this.next = this;
        }

    }
}
