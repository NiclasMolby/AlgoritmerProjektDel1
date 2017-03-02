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
        elements.set(0, elements.get(elements.size()-1));
        elements.remove(max);

        heapify(elements, 0);
        return max;
    }

    private void heapify(ArrayList<Element> elements, int i) {
        int left = i*2;
        int right = i*2 + 1;
        int largest = i;

        if(left <= elements.size()-1 && elements.get(left).key > elements.get(i).key){
            largest = left;
        }
        else {
            largest = i;
        }

        if(right <= elements.size()-1 && elements.get(right).key > elements.get(largest).key) {
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
        int i = elements.size()-1;
        while(i > 0 && parent(e).key < e.key){
            int index1 = elements.indexOf(parent(e));
            int index2 = elements.indexOf(e);
            Element temp = parent(e);

            elements.set(index1, e);
            elements.set(index2, temp);
            i = index2;
        }
    }

    private Element parent(Element i){

        return elements.get((int) Math.floor(elements.indexOf(i) / 2));
    }
}
