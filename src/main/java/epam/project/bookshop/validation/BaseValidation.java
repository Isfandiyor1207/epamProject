package epam.project.bookshop.validation;

import java.util.List;

public class BaseValidation {
    
    public boolean isEmpty(String text){
        return text == null || text.isEmpty();
    }

    public boolean isEmpty(Object obj){
        return obj == null;
    }

    public boolean isEmpty(List<?> items){
        return items == null || items.isEmpty();
    }

}
