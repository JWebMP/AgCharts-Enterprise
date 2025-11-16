package com.jwebmp.plugins.agchartsenterprise.options.gauge;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * How multiple fills are applied to the gauge bar.
 */
public enum AgGaugeFillMode
{
    CONTINUOUS("continuous"),
    DISCRETE("discrete");

    private final String value;

    AgGaugeFillMode(String value) {this.value = value;}

    @JsonValue
    public String getValue() {return value;}

    @Override
    public String toString() {return value;}
}
