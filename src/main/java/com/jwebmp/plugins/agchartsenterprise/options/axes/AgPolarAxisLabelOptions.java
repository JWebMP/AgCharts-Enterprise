package com.jwebmp.plugins.agchartsenterprise.options.axes;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.jwebmp.plugins.agcharts.options.axes.AgBaseCartesianAxisLabelOptions;

/**
 * Polar axis label options extending base label options and adding orientation.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AgPolarAxisLabelOptions<J extends AgPolarAxisLabelOptions<J>> extends AgBaseCartesianAxisLabelOptions<J> {
    private AgAxisLabelOrientation orientation; // fixed | parallel | perpendicular

    public AgAxisLabelOrientation getOrientation() {
        return orientation;
    }

    public J setOrientation(AgAxisLabelOrientation orientation) {
        this.orientation = orientation;
        return (J) this;
    }
}
