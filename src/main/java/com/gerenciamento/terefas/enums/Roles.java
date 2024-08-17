package com.gerenciamento.terefas.enums;

public enum Roles {


    ADMIN("admin"),

    USER("user");

    private String value;

    Roles (String value){
        this.value = value;
    }

}
