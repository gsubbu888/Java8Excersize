package java8;

import java.util.Arrays;
import java.util.List;

public class StringExample {

	    public static void main(String[] args) {

	        List<String> list = Arrays.asList("Subramanyam","RajaShekar","VenkateswarluReddy");
	        String result = String.join(",", list);

	        System.out.println("Names: "+result);
	        
	        

	    }

}
