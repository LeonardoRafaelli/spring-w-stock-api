package javastudies.stockapi.api;

import com.google.gson.FieldNamingStrategy;

import java.lang.reflect.Field;

public class CustomFieldNamingStrategy implements FieldNamingStrategy {
    @Override
    public String translateName(Field field) {
        //
        return field.getName().substring(4);
    }
}
