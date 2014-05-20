package org.primefaces.examples.view;
 
import java.util.ArrayList;
import java.util.List;

public class imageClass {
    
    public List<String> images;
 
    public imageClass() {
        images = new ArrayList<String>();
        images.add("sp_1.jpg");
        images.add("sp_2.jpg");
        images.add("sp_3.jpg");
    }
 
    public List<String> getImages() {
        return images;
    }
}
