package com.jwebmp.plugins.agchartsenterprise.options.axes;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Label orientation options for polar (angle) axes.
 */
public enum AgAxisLabelOrientation {
    FIXED("fixed"),
    PARALLEL("parallel"),
    PERPENDICULAR("perpendicular");

    private final String value;

    AgAxisLabelOrientation(String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value;
    }
}
