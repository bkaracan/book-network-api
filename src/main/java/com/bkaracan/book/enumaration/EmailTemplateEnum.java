package com.bkaracan.book.enumaration;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum EmailTemplateEnum {

    ACTIVATE_ACCOUNT("activate_account");

    private final String name;
}
