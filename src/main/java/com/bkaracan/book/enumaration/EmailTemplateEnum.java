package com.bkaracan.book.enumaration;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
public enum EmailTemplateEnum {

    ACTIVATE_ACCOUNT("activate_account");

    private final String name;
}
