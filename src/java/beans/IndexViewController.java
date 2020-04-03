
package beans;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
 
@ManagedBean(name="indexViewController")
public class IndexViewController{
     
    private List<String> images;
      
     
    @PostConstruct
    public void init() {
        images = new ArrayList<>();
        for (int i = 1; i <= 102; i++) {
            images.add( "GPC ("+i+ ").jpg");
        }

    }
 
    public List<String> getImages() {
        return images;

    }
}
