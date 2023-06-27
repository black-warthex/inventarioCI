package com.crud_ci.ci.utils;

import lombok.Getter;

public enum DefaultAnserEnum {
    MESSAGE_INSERT("successfully added"),MESSAGE_DELETE("removed item"),MESSAGE_UPDATE("item updated"), MESSAGE_ERROR("error process failed"), MESSAGE_DUPLICATE("You cannot add this object, it is already registered");
    @Getter
    private String value;

    private DefaultAnserEnum(String value) {
        this.value = value;
    }
}
