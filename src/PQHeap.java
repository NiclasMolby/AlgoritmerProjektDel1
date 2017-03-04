import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by niclasmolby on 28/02/2017.
 */
public class PQHeap implements PQ {

    private ArrayList<Element> elements;

    PQHeap(int maxElms){
        elements = new ArrayList<>(maxElms);
        elements.add(new Element(0,null));
    }

    @Override
    public Element extractMin() {
        Element min = elements.get(1);
        Collections.swap(elements, 1, elements.size()-1);
        elements.remove(elements.size()-1);

        heapify(1);
        return min;
    }

    private void heapify(int i) {
        int left = i*2;
        int right = i*2 + 1;
        int min;

        if(left < elements.size() && elements.get(left).key < elements.get(i).key){
            min = left;
        }
        else {
            min = i;
        }

        if(right < elements.size() && elements.get(right).key < elements.get(min).key) {
            min = right;
        }

        if(min != i){
            Collections.swap(elements, i, min);
            heapify(min);
        }
    }

    @Override
    public void insert(Element e) {
        elements.add(e);
        int i = elements.size();
        while(i > 1 && parent(e).key > e.key){
            int index1 = elements.indexOf(parent(e));
            int index2 = elements.indexOf(e);

            Collections.swap(elements,index1, index2);

            i = index1;
        }
    }

    private Element parent(Element i){

        return elements.get((int) Math.floor(elements.indexOf(i) / 2));
    }
}
