import java.util.ArrayList;
import java.util.Collections;

/**
 * Medlemmer:
 * Niclas Schilling Mølby: nicmo15
 * Jebisan Nadarajah: jenad14
 * Emil Villefrance: emvil15
 */
public class PQHeap implements PQ {

    private ArrayList<Element> elements;

    PQHeap(int maxElms){
        elements = new ArrayList<>(maxElms);
        elements.add(new Element(0,null));
    }

    /**
     *
     * @return returnerer det element der har den mindste key værdi
     */
    @Override
    public Element extractMin() {
        Element min = elements.get(1);
        Collections.swap(elements, 1, elements.size()-1);
        elements.remove(elements.size()-1);

        heapify(1);
        return min;
    }

    /**
     *
     * @param i positionen i array'et, hvor heapify skal starte fra
     */
    private void heapify(int i) {
        int left = i*2;
        int right = i*2 + 1;
        int min;

        // Tjekker om den nuværende positions venstre barn har en mindre key værdi
        if(left < elements.size() && elements.get(left).key < elements.get(i).key){
            min = left;
        }
        else {
            min = i;
        }

        // Tjekker om den nuværene positions højre barn har en mindre key værdi
        if(right < elements.size() && elements.get(right).key < elements.get(min).key) {
            min = right;
        }

        /*
            Tjekker om forældren har den mindste key værdi
            hvis ikke skal den byttes ud med den midnste værdi og heapify skal køres igen
        */
        if(min != i){
            Collections.swap(elements, i, min);
            heapify(min);
        }
    }

    /**
     *
     * @param e tilføjer et element til sidst i heapen og ordner heapen, så det nye element kommer hen på den korrekte plads.
     */
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

    /**
     *
     * @param e det element hvis forældre skal findes
     * @return returnerer det element der er forældre til det indtastede element
     */
    private Element parent(Element e){

        return elements.get((int) Math.floor(elements.indexOf(e) / 2));
    }
}
