package com.jwebmp.plugins.agchartsenterprise.options.series;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.jwebmp.plugins.agcharts.options.axes.AgBaseCartesianAxisLabelOptions;

/**
 * Label options for polar axes (angle/radius).
 * Adds orientation for angle axis while inheriting common label styling.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AgPolarAxisLabelOptions<J extends AgPolarAxisLabelOptions<J>> extends AgBaseCartesianAxisLabelOptions<J>
{
    private AgPolarAxisLabelOrientation orientation; // fixed | parallel | perpendicular

    public AgPolarAxisLabelOrientation getOrientation()
    {
        return orientation;
    }

    public J setOrientation(AgPolarAxisLabelOrientation orientation)
    {
        this.orientation = orientation;
        return (J) this;
    }
}
