package com.jwebmp.plugins.agchartsenterprise.options.gauge;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.jwebmp.core.htmlbuilder.javascript.JavaScriptPart;

/**
 * Color stop for gauge fills (supports optional stop value relative to scale/domain).
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AgGaugeColorStop<J extends AgGaugeColorStop<J>> extends JavaScriptPart<J>
{
    private String color;
    private Number stop; // position, unit depends on usage (percent or value)

    public String getColor() {return color;}

    public @org.jspecify.annotations.NonNull J setColor(String color)
    {
        this.color = color;
        return (J) this;
    }

    public Number getStop() {return stop;}

    public @org.jspecify.annotations.NonNull J setStop(Number stop)
    {
        this.stop = stop;
        return (J) this;
    }
}
