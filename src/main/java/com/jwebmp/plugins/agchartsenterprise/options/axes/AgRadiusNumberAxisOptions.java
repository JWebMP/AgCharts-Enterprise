package com.jwebmp.plugins.agchartsenterprise.options.axes;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.jwebmp.plugins.agcharts.options.axes.AgAxisBaseOptions;

/**
 * Radius Number Axis options for polar charts.
 * 
 * <p>
 * The Radius Number Axis is used in polar charts to represent numeric data
 * along the radius (distance from center). It complements the Angle Axis
 * to create fully-configured polar coordinate systems.
 * </p>
 * 
 * <p>
 * Key properties:
 * <ul>
 *   <li><strong>innerRadiusRatio</strong> - Controls the size of the inner hole (0..1)
 *       where 0 = full circle, 1 = outer edge only</li>
 *   <li><strong>positionAngle</strong> - Sets the angular position of the axis line
 *       in degrees (0-360)</li>
 * </ul>
 * </p>
 * 
 * @param <J> the CRTP parameter for fluent API chaining
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AgRadiusNumberAxisOptions<J extends AgRadiusNumberAxisOptions<J>> extends AgAxisBaseOptions<J>
{
    private Double innerRadiusRatio; // 0..1 sets inner hole size
    private Integer positionAngle;   // degrees for axis line position

    /**
     * Constructor initializing the axis type as "radius-number".
     */
    public AgRadiusNumberAxisOptions()
    {
        setType("radius-number");
    }

    /**
     * Gets the inner radius ratio for the polar chart.
     * <p>
     * The inner radius ratio determines the size of the inner hole in polar charts,
     * creating a donut-like appearance when greater than 0. Used primarily in
     * gauges and radial column/bar charts.
     *
     * @return the inner radius ratio as a value between 0 and 1, or null if not set
     */
    public Double getInnerRadiusRatio()
    {
        return innerRadiusRatio;
    }

    /**
     * Sets the inner radius ratio for the polar chart.
     * <p>
     * Controls the size of the inner hole in polar charts. A value of 0 creates
     * a full circle, while values closer to 1 create a larger inner hole.
     * This is essential for creating gauge and radial visualizations with
     * variable donut sizes.
     *
     * @param innerRadiusRatio the inner radius ratio, should be between 0 and 1
     * @return this instance for method chaining
     */
    public @org.jspecify.annotations.NonNull J setInnerRadiusRatio(Double innerRadiusRatio)
    {
        this.innerRadiusRatio = innerRadiusRatio;
        return (J) this;
    }

    /**
     * Gets the position angle for the axis line.
     * <p>
     * The position angle determines where the axis line is drawn on the polar chart,
     * measured in degrees from the positive x-axis (0 degrees = right, 90 = top,
     * 180 = left, 270 = bottom).
     *
     * @return the position angle in degrees (0-360), or null if not set
     */
    public Integer getPositionAngle()
    {
        return positionAngle;
    }

    /**
     * Sets the position angle for the axis line.
     * <p>
     * Defines the angular position where the axis line should be drawn on the
     * polar chart, measured in degrees from the positive x-axis (0 degrees).
     * This allows flexible positioning of the radius axis around the circle.
     *
     * @param positionAngle the position angle in degrees (0-360), typically 0, 90, 180, or 270
     * @return this instance for method chaining
     */
    public @org.jspecify.annotations.NonNull J setPositionAngle(Integer positionAngle)
    {
        this.positionAngle = positionAngle;
        return (J) this;
    }
}
