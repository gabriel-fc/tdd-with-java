package exercise14;

public class Ring <T>{
    private RingElement current = null;
    private int count = 0;
    public void add(T element){
        RingElement newElement = new RingElement(element);
        if(current == null){
            newElement.previous = newElement;
            newElement.next = newElement;
            current = newElement;
        }else{
            newElement.previous = current;
            newElement.next = current.next;
            current.next.previous = newElement;
            current.next = newElement;
        }
        incrementCount();
    }

    public void remove(){
        if(size() == 1) current = null;
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

    private class RingElement {
        private RingElement previous;
        private RingElement next;
        private T self;

        private RingElement (T self){
            this.self = self;
            this.previous = null;
            this.next = null;
        }

    }
}
