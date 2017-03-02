import java.util.ArrayList;

/**
 * Created by niclasmolby on 28/02/2017.
 */
public class PQHeap implements PQ {

    private ArrayList<Element> elements;

    PQHeap(int maxElms){
        elements = new ArrayList<>(maxElms);
    }

    @Override
    public Element extractMin() {
        int max = elements.get(0).key;
        elements.get(0).key = elements.get(elements.size()).key;
        elements.remove(max);

        return elements.get(max);
    }

    private void heapify(ArrayList<Element> elements, int i) {
        int left = i*2;
        int right = i*2 + 1;
        int largest = i;

        if(left <= elements.size() && elements.get(left).key > elements.get(i).key){
            largest = left;
        }
        else {
            largest = i;
        }

        if(right <= elements.size() && elements.get(right).key > elements.get(largest).key) {
            largest = right;
        }

        if(largest != i){
            int temp = elements.get(i).key;
            elements.get(i).key = elements.get(largest).key;
            elements.get(largest).key = temp;
            heapify(elements, largest);
        }
    }

    @Override
    public void insert(Element e) {

    }
}
