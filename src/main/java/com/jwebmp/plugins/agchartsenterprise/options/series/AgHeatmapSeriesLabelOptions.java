package com.jwebmp.plugins.agchartsenterprise.options.series;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonRawValue;
import com.jwebmp.plugins.agcharts.options.series.AgSeriesLabelOptions;

/**
 * Heatmap cell label options.
 * Extends generic series label options with enable/formatter controls expected by heatmap labels.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AgHeatmapSeriesLabelOptions<J extends AgHeatmapSeriesLabelOptions<J>> extends AgSeriesLabelOptions<J>
{
    private Boolean enabled;

    /**
     * Formatter function: function(params){ return string; }
     */
    @JsonRawValue
    private String formatter;

    public Boolean getEnabled()
    {
        return enabled;
    }

    public J setEnabled(Boolean enabled)
    {
        this.enabled = enabled;
        return (J) this;
    }

    public String getFormatter()
    {
        return formatter;
    }

    public J setFormatter(String formatter)
    {
        this.formatter = formatter;
        return (J) this;
    }
}
