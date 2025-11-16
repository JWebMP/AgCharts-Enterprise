package com.jwebmp.plugins.agchartsenterprise.options.series;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.jwebmp.plugins.agcharts.options.axes.AgAxisBaseOptions;

/**
 * Radius Number Axis options for polar charts.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AgRadiusNumberAxisOptions<J extends AgRadiusNumberAxisOptions<J>> extends AgAxisBaseOptions<J>
{
    private Double innerRadiusRatio; // 0..1 sets inner hole size
    private Integer positionAngle;   // degrees for axis line position

    public AgRadiusNumberAxisOptions()
    {
        setType("radius-number");
    }

    /**
     * Gets the inner radius ratio for the polar chart.
     * <p>
     * The inner radius ratio determines the size of the inner hole in polar charts,
     * creating a donut-like appearance when greater than 0.
     *
     * @return the inner radius ratio as a value between 0 and 1, or null if not set
     */
    public Double getInnerRadiusRatio() {return innerRadiusRatio;}

    /**
     * Sets the inner radius ratio for the polar chart.
     * <p>
     * Controls the size of the inner hole in polar charts. A value of 0 creates
     * a full circle, while values closer to 1 create a larger inner hole.
     *
     * @param innerRadiusRatio the inner radius ratio, should be between 0 and 1
     * @return this instance for method chaining
     */
    public J setInnerRadiusRatio(Double innerRadiusRatio)
    {
        this.innerRadiusRatio = innerRadiusRatio;
        return (J) this;
    }

    /**
     * Gets the position angle for the axis line.
     * <p>
     * The position angle determines where the axis line is drawn on the polar chart,
     * measured in degrees from the positive x-axis.
     *
     * @return the position angle in degrees, or null if not set
     */
    public Integer getPositionAngle() {return positionAngle;}

    /**
     * Sets the position angle for the axis line.
     * <p>
     * Defines the angular position where the axis line should be drawn on the
     * polar chart, measured in degrees from the positive x-axis (0 degrees).
     *
     * @param positionAngle the position angle in degrees (0-360)
     * @return this instance for method chaining
     */
    public J setPositionAngle(Integer positionAngle)
    {
        this.positionAngle = positionAngle;
        return (J) this;
    }
}
