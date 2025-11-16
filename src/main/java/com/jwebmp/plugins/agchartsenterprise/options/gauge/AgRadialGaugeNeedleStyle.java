package com.jwebmp.plugins.agchartsenterprise.options.gauge;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.jwebmp.core.htmlbuilder.javascript.JavaScriptPart;

/**
 * Needle style for radial gauge.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AgRadialGaugeNeedleStyle<J extends AgRadialGaugeNeedleStyle<J>> extends JavaScriptPart<J>
{
    private Boolean enabled;
    private String fill;
    private String stroke;
    private Integer strokeWidth;

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

    public String getStroke() {return stroke;}

    public J setStroke(String stroke)
    {
        this.stroke = stroke;
        return (J) this;
    }

    public Integer getStrokeWidth() {return strokeWidth;}

    public J setStrokeWidth(Integer strokeWidth)
    {
        this.strokeWidth = strokeWidth;
        return (J) this;
    }
}
