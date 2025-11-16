package com.jwebmp.plugins.agchartsenterprise.options.axes;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.jwebmp.plugins.agcharts.options.axes.AgAxisBaseOptions;

/**
 * Angle Number Axis options (Enterprise Polar Axis).
 * Supports start/end angles for circumference and label orientation.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AgAngleNumberAxisOptions<J extends AgAngleNumberAxisOptions<J>> extends AgAxisBaseOptions<J> {
    private Integer startAngle; // degrees
    private Integer endAngle;   // degrees

    public AgAngleNumberAxisOptions() {
        setType("angle-number");
    }

    public Integer getStartAngle() {
        return startAngle;
    }

    public J setStartAngle(Integer startAngle) {
        this.startAngle = startAngle;
        return (J) this;
    }

    public Integer getEndAngle() {
        return endAngle;
    }

    public J setEndAngle(Integer endAngle) {
        this.endAngle = endAngle;
        return (J) this;
    }

    /**
     * Helper to set a polar-specific label options instance which supports orientation.
     */
    public J setPolarLabel(AgPolarAxisLabelOptions<?> label) {
        // Reuse base setter but accept the extended type for convenience.
        super.setLabel(label);
        return (J) this;
    }
}
