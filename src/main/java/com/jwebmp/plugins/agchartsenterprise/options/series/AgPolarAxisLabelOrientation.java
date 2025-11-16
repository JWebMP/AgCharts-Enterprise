package com.jwebmp.plugins.agchartsenterprise.options.series;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Orientation options for polar axis labels.
 */
public enum AgPolarAxisLabelOrientation
{
    FIXED("fixed"),
    PARALLEL("parallel"),
    PERPENDICULAR("perpendicular");

    private final String value;

    AgPolarAxisLabelOrientation(String value)
    {
        this.value = value;
    }

    @JsonValue
    public String getValue()
    {
        return value;
    }

    @Override
    public String toString()
    {
        return value;
    }
}
