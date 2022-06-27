package epam.project.bookshop.validation;

import java.util.List;

public class BaseValidation {
    private static BaseValidation INSTANCE;

    private BaseValidation(){}

    public static BaseValidation getInstance() {
        if (INSTANCE == null){
            INSTANCE = new BaseValidation();
        }
        return INSTANCE;
    }

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
