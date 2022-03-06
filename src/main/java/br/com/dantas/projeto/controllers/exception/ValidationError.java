package br.com.dantas.projeto.controllers.exception;

import java.util.ArrayList;
import java.util.List;

public class ValidationError extends StandardError{

    private List<FieldMessage> list = new ArrayList<>();

    public ValidationError(Integer status, String msg, Long timeStamp) {
        super(status, msg, timeStamp);
    }

    public List<FieldMessage> getErrors() {
        return list;
    }

    public void AddEError(String fieldName, String message) {
        list.add(new FieldMessage(fieldName, message));
    }
}
