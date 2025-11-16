package com.jwebmp.plugins.agchartsenterprise;

import com.jwebmp.plugins.agchartsenterprise.options.gauge.AgRadialGaugeOptions;
import com.jwebmp.plugins.agchartsenterprise.options.gauge.AgRadialGaugeScale;

/**
 * Convenience Radial Gauge component.
 * <p>
 * Provides a simple way to instantiate a gauge with value and scale min/max.
 */
public class AgRadialGauge<J extends AgRadialGauge<J>> extends AgGauge<J>
{
    private Number value;
    private Number min;
    private Number max;

    public AgRadialGauge(String id, Number value, Number min, Number max)
    {
        super(id);
        this.value = value;
        this.min = min;
        this.max = max;
    }

    /**
     * Sets the current value of the radial gauge.
     * <p>
     * The value should typically be within the range defined by min and max
     * for proper visualization, though values outside this range are allowed.
     *
     * @param value the numeric value to display on the gauge
     * @return this instance for method chaining
     */
    @SuppressWarnings("unchecked")
    public J setValue(Number value)
    {
        this.value = value;
        return (J) this;
    }

    /**
     * Sets the minimum value for the gauge scale.
     * <p>
     * This defines the lower bound of the gauge's scale range and affects
     * the visualization of the gauge's scale and needle positioning.
     *
     * @param min the minimum value for the gauge scale
     * @return this instance for method chaining
     */
    @SuppressWarnings("unchecked")
    public J setMin(Number min)
    {
        this.min = min;
        return (J) this;
    }

    /**
     * Sets the maximum value for the gauge scale.
     * <p>
     * This defines the upper bound of the gauge's scale range and affects
     * the visualization of the gauge's scale and needle positioning.
     *
     * @param max the maximum value for the gauge scale
     * @return this instance for method chaining
     */
    @SuppressWarnings("unchecked")
    public J setMax(Number max)
    {
        this.max = max;
        return (J) this;
    }

    /**
     * Gets the initial configuration options for this radial gauge.
     * <p>
     * Creates and returns a configured {@link AgRadialGaugeOptions} instance
     * with the current value, min, and max settings applied to the gauge scale.
     *
     * @return the configured radial gauge options
     */
    @Override
    public AgRadialGaugeOptions<?> getInitialOptions()
    {
        AgRadialGaugeScale<?> scale = new AgRadialGaugeScale<>()
                .setMin(min)
                .setMax(max);
        return new AgRadialGaugeOptions<>()
                .setValue(value)
                .setScale(scale);
    }
}
