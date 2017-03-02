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
        Element max = elements.get(0);
        elements.set(0, elements.get(elements.size()));
        elements.remove(max);

        heapify(elements, 1);
        return max;
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
            Element temp = elements.get(i);
            elements.set(i, elements.get(largest));
            elements.set(largest, temp);
            heapify(elements, largest);
        }
    }

    @Override
    public void insert(Element e) {
        elements.add(e);
    }
}
