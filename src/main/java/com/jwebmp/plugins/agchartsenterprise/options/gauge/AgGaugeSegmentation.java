package com.jwebmp.plugins.agchartsenterprise.options.gauge;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.jwebmp.core.htmlbuilder.javascript.JavaScriptPart;

/**
 * Segmentation config for radial gauge.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AgGaugeSegmentation<J extends AgGaugeSegmentation<J>> extends JavaScriptPart<J>
{
    private Boolean enabled;
    private AgGaugeSegmentationInterval<?> interval;
    private Integer spacing; // px between segments

    public Boolean getEnabled() {return enabled;}

    public J setEnabled(Boolean enabled)
    {
        this.enabled = enabled;
        return (J) this;
    }

    public AgGaugeSegmentationInterval<?> getInterval() {return interval;}

    public J setInterval(AgGaugeSegmentationInterval<?> interval)
    {
        this.interval = interval;
        return (J) this;
    }

    public Integer getSpacing() {return spacing;}

    public J setSpacing(Integer spacing)
    {
        this.spacing = spacing;
        return (J) this;
    }
}
