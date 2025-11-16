package com.jwebmp.plugins.agchartsenterprise.options.gauge;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.jwebmp.core.htmlbuilder.javascript.JavaScriptPart;

/**
 * Label options for Linear Gauge.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AgLinearGaugeLabelOptions<J extends AgLinearGaugeLabelOptions<J>> extends JavaScriptPart<J>
{
    private Boolean enabled;
    /** inside-start | inside-end | outside-start | outside-end etc; using string for flexibility. */
    private String placement;
    /** Avoid overlapping both the bar and the scale. */
    private Boolean avoidCollisions;

    public Boolean getEnabled() {return enabled;}
    public J setEnabled(Boolean enabled) {this.enabled = enabled; return (J) this;}

    public String getPlacement() {return placement;}
    public J setPlacement(String placement) {this.placement = placement; return (J) this;}

    public Boolean getAvoidCollisions() {return avoidCollisions;}
    public J setAvoidCollisions(Boolean avoidCollisions) {this.avoidCollisions = avoidCollisions; return (J) this;}
}
