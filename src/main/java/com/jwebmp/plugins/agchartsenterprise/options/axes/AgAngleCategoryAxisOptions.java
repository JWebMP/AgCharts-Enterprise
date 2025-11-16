package com.jwebmp.plugins.agchartsenterprise.options.axes;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.jwebmp.plugins.agcharts.options.axes.AgAxisBaseOptions;

/**
 * Angle Category Axis options for polar charts.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AgAngleCategoryAxisOptions<J extends AgAngleCategoryAxisOptions<J>> extends AgAxisBaseOptions<J>
{
    private Double paddingInner;       // 0..1 gap between column groups
    private Double groupPaddingInner;  // 0..1 spacing within a group

    // Override label to polar label options supporting orientation
    private AgPolarAxisLabelOptions<?> label;

    public AgAngleCategoryAxisOptions()
    {
        setType("angle-category");
    }

    public Double getPaddingInner() {return paddingInner;}

    public J setPaddingInner(Double paddingInner)
    {
        this.paddingInner = paddingInner;
        return (J) this;
    }

    public Double getGroupPaddingInner() {return groupPaddingInner;}

    public J setGroupPaddingInner(Double groupPaddingInner)
    {
        this.groupPaddingInner = groupPaddingInner;
        return (J) this;
    }

    @Override
    public AgPolarAxisLabelOptions<?> getLabel()
    {
        return label;
    }

    public J setLabel(AgPolarAxisLabelOptions<?> label)
    {
        this.label = label;
        return (J) this;
    }
}
