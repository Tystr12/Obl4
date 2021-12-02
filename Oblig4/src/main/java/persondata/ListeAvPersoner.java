package persondata;

import java.util.ArrayList;
import java.util.List;

public class ListeAvPersoner {
	
	private List<Person> items = new ArrayList<>();
    
    public void addItem(Person person) {
        items.add(person);
    }
    
    public List<Person> getItems() {
        return items;
    }
}
