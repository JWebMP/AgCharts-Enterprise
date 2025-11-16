package com.jwebmp.plugins.agchartsenterprise.options.gauge;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.jwebmp.core.htmlbuilder.javascript.JavaScriptPart;

import java.util.List;

/**
 * Scale options for the linear gauge.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AgLinearGaugeScale<J extends AgLinearGaugeScale<J>> extends JavaScriptPart<J>
{
    private Number min;
    private Number max;

    private String fill; // single color for scale background
    private List<AgGaugeColorStop<?>> fills; // multi-color scale background
    private AgGaugeFillMode fillMode; // continuous/discrete

    // Reuse radial scale label options for font styling and enable/disable
    private AgRadialGaugeScaleLabelOptions<?> label;

    public Number getMin() {return min;}
    public J setMin(Number min) {this.min = min; return (J) this;}

    public Number getMax() {return max;}
    public J setMax(Number max) {this.max = max; return (J) this;}

    public String getFill() {return fill;}
    public J setFill(String fill) {this.fill = fill; return (J) this;}

    public List<AgGaugeColorStop<?>> getFills() {return fills;}
    public J setFills(List<AgGaugeColorStop<?>> fills) {this.fills = fills; return (J) this;}

    public AgGaugeFillMode getFillMode() {return fillMode;}
    public J setFillMode(AgGaugeFillMode fillMode) {this.fillMode = fillMode; return (J) this;}

    public AgRadialGaugeScaleLabelOptions<?> getLabel() {return label;}
    public J setLabel(AgRadialGaugeScaleLabelOptions<?> label) {this.label = label; return (J) this;}
}
