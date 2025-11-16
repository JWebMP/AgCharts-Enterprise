package com.jwebmp.plugins.agchartsenterprise.options.gauge;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.jwebmp.core.htmlbuilder.javascript.JavaScriptPart;

import java.util.List;

/**
 * Scale options for the radial gauge.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AgRadialGaugeScale<J extends AgRadialGaugeScale<J>> extends JavaScriptPart<J>
{
    private Number min;
    private Number max;

    private String fill; // single color for scale background
    private List<AgGaugeColorStop<?>> fills; // multi-color scale background
    private AgGaugeFillMode fillMode; // continuous/discrete

    private AgRadialGaugeScaleLabelOptions<?> label; // tick labels

    /**
     * Gets the minimum value for the gauge scale.
     * <p>
     * The minimum value defines the lower bound of the gauge scale and determines
     * where the scale starts. Values below this minimum will be clamped to this value
     * for display purposes.
     *
     * @return the minimum scale value, or null if not explicitly set
     */
    public Number getMin() {return min;}

    /**
     * Sets the minimum value for the gauge scale.
     * <p>
     * Defines the lower bound of the gauge scale range. The gauge needle and scale
     * will be calibrated based on this minimum value. Must be less than the maximum
     * value when both are set.
     *
     * @param min the minimum scale value, should be less than max when both are defined
     * @return this instance for method chaining
     */
    public J setMin(Number min)
    {
        this.min = min;
        return (J) this;
    }

    /**
     * Gets the maximum value for the gauge scale.
     * <p>
     * The maximum value defines the upper bound of the gauge scale and determines
     * where the scale ends. Values above this maximum will be clamped to this value
     * for display purposes.
     *
     * @return the maximum scale value, or null if not explicitly set
     */
    public Number getMax() {return max;}

    /**
     * Sets the maximum value for the gauge scale.
     * <p>
     * Defines the upper bound of the gauge scale range. The gauge needle and scale
     * will be calibrated based on this maximum value. Must be greater than the minimum
     * value when both are set.
     *
     * @param max the maximum scale value, should be greater than min when both are defined
     * @return this instance for method chaining
     */
    public J setMax(Number max)
    {
        this.max = max;
        return (J) this;
    }

    /**
     * Gets the single fill color for the gauge scale background.
     * <p>
     * When using a single fill color, this provides a uniform background color
     * for the entire gauge scale. Mutually exclusive with the fills property.
     *
     * @return the fill color as a CSS color string (e.g., "#FF0000", "red"), or null if using multi-color fills
     */
    public String getFill() {return fill;}

    /**
     * Sets a single fill color for the gauge scale background.
     * <p>
     * Applies a uniform background color to the entire gauge scale. When set,
     * this overrides any multi-color fills configuration. Use CSS color formats
     * such as hex codes, RGB values, or named colors.
     *
     * @param fill the CSS color string for the scale background (e.g., "#FF0000", "rgba(255,0,0,0.5)")
     * @return this instance for method chaining
     */
    public J setFill(String fill)
    {
        this.fill = fill;
        return (J) this;
    }

    /**
     * Gets the multi-color fill configuration for the gauge scale.
     * <p>
     * Allows for gradient or segmented color fills across the gauge scale,
     * where different value ranges can have different colors. Mutually exclusive
     * with the single fill property.
     *
     * @return the list of color stops defining the multi-color fill, or null if using single fill
     */
    public List<AgGaugeColorStop<?>> getFills() {return fills;}

    /**
     * Sets a multi-color fill configuration for the gauge scale.
     * <p>
     * Enables gradient or segmented coloring across the gauge scale based on value ranges.
     * Each color stop defines a color and position. When set, this overrides any
     * single fill color configuration.
     *
     * @param fills the list of color stops, each defining a color and stop position (0.0 to 1.0)
     * @return this instance for method chaining
     */
    public J setFills(List<AgGaugeColorStop<?>> fills)
    {
        this.fills = fills;
        return (J) this;
    }

    /**
     * Gets the fill rendering mode for multi-color fills.
     * <p>
     * Determines how multi-color fills are rendered: as smooth gradients or
     * discrete color segments. Only applies when using the fills property.
     *
     * @return the fill mode (CONTINUOUS for gradients, DISCRETE for segments), or null for default
     */
    public AgGaugeFillMode getFillMode() {return fillMode;}

    /**
     * Sets the fill rendering mode for multi-color fills.
     * <p>
     * Controls the appearance of multi-color fills. CONTINUOUS creates smooth
     * gradient transitions between colors, while DISCRETE creates distinct
     * colored segments. Has no effect when using single fill color.
     *
     * @param fillMode the fill rendering mode (CONTINUOUS or DISCRETE)
     * @return this instance for method chaining
     */
    public J setFillMode(AgGaugeFillMode fillMode)
    {
        this.fillMode = fillMode;
        return (J) this;
    }

    /**
     * Gets the label configuration for scale tick marks.
     * <p>
     * Controls the appearance and behavior of numerical labels that appear
     * along the gauge scale to indicate values at major tick positions.
     *
     * @return the scale label options configuration, or null if using defaults
     */
    public AgRadialGaugeScaleLabelOptions<?> getLabel() {return label;}

    /**
     * Sets the label configuration for scale tick marks.
     * <p>
     * Configures how numerical values are displayed along the gauge scale.
     * This includes formatting, positioning, styling, and visibility of the
     * tick labels that help users read gauge values.
     *
     * @param label the scale label options for customizing tick label appearance and behavior
     * @return this instance for method chaining
     */
    public J setLabel(AgRadialGaugeScaleLabelOptions<?> label)
    {
        this.label = label;
        return (J) this;
    }
}
