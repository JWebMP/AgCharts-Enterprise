package com.jwebmp.plugins.agchartsenterprise.options.axes;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.jwebmp.plugins.agcharts.options.axes.AgAxisBaseOptions;

/**
 * Radius Category Axis options (Enterprise Polar Axis).
 * Supports inner radius ratio (donut effect) and band paddings.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AgRadiusCategoryAxisOptions<J extends AgRadiusCategoryAxisOptions<J>> extends AgAxisBaseOptions<J> {
    private Double innerRadiusRatio;   // 0..1
    private Double paddingInner;       // 0..1
    private Double groupPaddingInner;  // 0..1
    private Double paddingOuter;       // 0..1

    /** Starting angle for the radius axis position (degrees). */
    private Integer positionAngle;

    public AgRadiusCategoryAxisOptions() {
        setType("radius-category");
    }

    public Double getInnerRadiusRatio() { return innerRadiusRatio; }
    public J setInnerRadiusRatio(Double innerRadiusRatio) { this.innerRadiusRatio = innerRadiusRatio; return (J) this; }

    public Double getPaddingInner() { return paddingInner; }
    public J setPaddingInner(Double paddingInner) { this.paddingInner = paddingInner; return (J) this; }

    public Double getGroupPaddingInner() { return groupPaddingInner; }
    public J setGroupPaddingInner(Double groupPaddingInner) { this.groupPaddingInner = groupPaddingInner; return (J) this; }

    public Double getPaddingOuter() { return paddingOuter; }
    public J setPaddingOuter(Double paddingOuter) { this.paddingOuter = paddingOuter; return (J) this; }

    public Integer getPositionAngle() { return positionAngle; }
    public J setPositionAngle(Integer positionAngle) { this.positionAngle = positionAngle; return (J) this; }
}
