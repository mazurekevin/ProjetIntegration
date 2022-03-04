package com.apiSpring.apiSpring.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class Response {

    public String notFound(String value) {
        return value + " n'a pas été trouvé.";
    }

    public String created(String value) {
        return value + " a bien été créé.";
    }

    public String updated(String value) {
        return value + " a bien été mis à jour.";
    }

    public String deleted(String value) {
        return value + " a bien été supprimé.";
    }
}
