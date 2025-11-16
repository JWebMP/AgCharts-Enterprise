package com.jwebmp.plugins.agchartsenterprise.options.gauge;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Placement of the target marker relative to the gauge thickness.
 */
public enum AgGaugeTargetPlacement
{
    INSIDE("inside"),
    MIDDLE("middle"),
    OUTSIDE("outside");

    private final String value;

    AgGaugeTargetPlacement(String value) {this.value = value;}

    @JsonValue
    public String getValue() {return value;}

    @Override
    public String toString() {return value;}
}
