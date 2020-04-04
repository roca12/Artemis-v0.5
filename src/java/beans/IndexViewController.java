package beans;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

@ManagedBean(name = "indexViewController")
public class IndexViewController {

    private List<String> images;

    @PostConstruct
    public void init() {
        images = new ArrayList<>();
        for (int i = 1; i <= 102; i++) {
            images.add("GPC (" + i + ").jpg");
        }

    }

    public String links() {
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        String url = request.getRequestURL().toString();
        int cont = 0, index=0;
        for (int i = 0; i < url.length(); i++) {
            if (url.charAt(i)=='/') {
                cont++;
            }
            if(cont==4){
            index=i;
            break;
            }
        }
        url = url.substring(0, index+1);
        return url;
    }

    public List<String> getImages() {
        return images;

    }
}
