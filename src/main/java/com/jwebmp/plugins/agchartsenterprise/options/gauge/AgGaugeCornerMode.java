package com.jwebmp.plugins.agchartsenterprise.options.gauge;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Whether corner radius applies to container ends or every item.
 */
public enum AgGaugeCornerMode
{
    CONTAINER("container"),
    ITEM("item");

    private final String value;

    AgGaugeCornerMode(String value) {this.value = value;}

    @JsonValue
    public String getValue() {return value;}

    @Override
    public String toString() {return value;}
}
