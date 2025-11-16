package com.jwebmp.plugins.agchartsenterprise.options.gauge;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.jwebmp.core.htmlbuilder.javascript.JavaScriptPart;

import java.util.List;

/**
 * Bar style for linear gauge value representation.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AgLinearGaugeBarStyle<J extends AgLinearGaugeBarStyle<J>> extends JavaScriptPart<J>
{
    /** Absolute thickness in pixels. */
    private Integer thickness;
    /** Thickness relative to the scale thickness (0..1). */
    private Double thicknessRatio;

    private String fill; // single color
    private List<AgGaugeColorStop<?>> fills; // multi-color stops
    private AgGaugeFillMode fillMode; // continuous | discrete

    public Integer getThickness() {return thickness;}
    public J setThickness(Integer thickness) {this.thickness = thickness; return (J) this;}

    public Double getThicknessRatio() {return thicknessRatio;}
    public J setThicknessRatio(Double thicknessRatio) {this.thicknessRatio = thicknessRatio; return (J) this;}

    public String getFill() {return fill;}
    public J setFill(String fill) {this.fill = fill; return (J) this;}

    public List<AgGaugeColorStop<?>> getFills() {return fills;}
    public J setFills(List<AgGaugeColorStop<?>> fills) {this.fills = fills; return (J) this;}

    public AgGaugeFillMode getFillMode() {return fillMode;}
    public J setFillMode(AgGaugeFillMode fillMode) {this.fillMode = fillMode; return (J) this;}
}
