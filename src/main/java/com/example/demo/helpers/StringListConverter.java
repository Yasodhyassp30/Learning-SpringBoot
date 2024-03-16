package com.example.demo.helpers;


import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.List;

public class StringListConverter implements AttributeConverter<List<String>, String> {

    private  Gson gson;
    private  Type listType;

    public StringListConverter() {
        this.gson = new Gson();
        this.listType = new TypeToken<List<String>>() {}.getType();
    }

    @Override
    public String convertToDatabaseColumn(List<String> attribute) {
        return gson.toJson(attribute);
    }

    @Override
    public List<String> convertToEntityAttribute(String dbData) {
        return gson.fromJson(dbData, listType);
    }
}
