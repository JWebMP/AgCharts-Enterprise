package com.jwebmp.plugins.agchartsenterprise.options.gauge;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.jwebmp.core.htmlbuilder.javascript.JavaScriptPart;

import java.util.List;

/**
 * Segmentation interval configuration.
 * Supports step, count or explicit values.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AgGaugeSegmentationInterval<J extends AgGaugeSegmentationInterval<J>> extends JavaScriptPart<J>
{
    private Number step;   // fixed interval step
    private Integer count; // number of segments
    private List<Number> values; // explicit positions

    public Number getStep() {return step;}

    public J setStep(Number step)
    {
        this.step = step;
        return (J) this;
    }

    public Integer getCount() {return count;}

    public J setCount(Integer count)
    {
        this.count = count;
        return (J) this;
    }

    public List<Number> getValues() {return values;}

    public J setValues(List<Number> values)
    {
        this.values = values;
        return (J) this;
    }
}
