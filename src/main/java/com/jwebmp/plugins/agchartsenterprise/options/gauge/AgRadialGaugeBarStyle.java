package com.jwebmp.plugins.agchartsenterprise.options.gauge;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.jwebmp.core.htmlbuilder.javascript.JavaScriptPart;

import java.util.List;

/**
 * Bar style for radial gauge value representation.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AgRadialGaugeBarStyle<J extends AgRadialGaugeBarStyle<J>> extends JavaScriptPart<J>
{
    private Boolean enabled;
    private String fill; // single color
    private List<AgGaugeColorStop<?>> fills; // multi-color stops
    private AgGaugeFillMode fillMode; // continuous | discrete

    public Boolean getEnabled() {return enabled;}

    public J setEnabled(Boolean enabled)
    {
        this.enabled = enabled;
        return (J) this;
    }

    public String getFill() {return fill;}

    public J setFill(String fill)
    {
        this.fill = fill;
        return (J) this;
    }

    public List<AgGaugeColorStop<?>> getFills() {return fills;}

    public J setFills(List<AgGaugeColorStop<?>> fills)
    {
        this.fills = fills;
        return (J) this;
    }

    public AgGaugeFillMode getFillMode() {return fillMode;}

    public J setFillMode(AgGaugeFillMode fillMode)
    {
        this.fillMode = fillMode;
        return (J) this;
    }
}
