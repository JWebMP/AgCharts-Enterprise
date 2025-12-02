package com.jwebmp.plugins.agchartsenterprise.options.axes;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.jwebmp.plugins.agcharts.options.axes.AgBaseCartesianAxisLabelOptions;

/**
 * Polar axis label options for angle and radius axes.
 *
 * Extends base label options and adds orientation for polar coordinate systems.
 * Used by both angle (azimuth) and radius (radial) axes in polar/gauge charts.
 *
 * @param <J> the self type for CRTP fluent API pattern
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AgPolarAxisLabelOptions<J extends AgPolarAxisLabelOptions<J>> extends AgBaseCartesianAxisLabelOptions<J>
{
    /**
     * Label orientation for polar axes.
     * - fixed: Labels maintain their angle (default horizontal)
     * - parallel: Labels align with the axis line
     * - perpendicular: Labels perpendicular to axis line
     */
    private AgAxisLabelOrientation orientation;

    /**
     * Optional rotation angle for labels in degrees.
     * Applied in addition to orientation setting.
     */
    private Integer rotation;

    /**
     * Gets the orientation of polar axis labels.
     *
     * @return the label orientation (fixed, parallel, or perpendicular), or null for default
     */
    public AgAxisLabelOrientation getOrientation()
    {
        return orientation;
    }

    /**
     * Sets the orientation of polar axis labels.
     *
     * @param orientation the desired label orientation
     * @return this instance for method chaining
     */
    public @org.jspecify.annotations.NonNull J setOrientation(AgAxisLabelOrientation orientation)
    {
        this.orientation = orientation;
        return (J) this;
    }

    /**
     * Gets the rotation angle for labels.
     *
     * @return the rotation angle in degrees, or null for default
     */
    public Integer getRotation()
    {
        return rotation;
    }

    /**
     * Sets the rotation angle for polar axis labels.
     *
     * @param rotation the angle in degrees to rotate labels
     * @return this instance for method chaining
     */
    public @org.jspecify.annotations.NonNull J setRotation(Integer rotation)
    {
        this.rotation = rotation;
        return (J) this;
    }
}
