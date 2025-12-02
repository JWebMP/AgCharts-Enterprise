package com.jwebmp.plugins.agchartsenterprise;

import com.jwebmp.plugins.agcharts.AgChart;
import com.jwebmp.plugins.agcharts.options.AgChartOptions;
import com.jwebmp.plugins.agchartsenterprise.options.series.AgFunnelSeriesOptions;
import io.smallrye.mutiny.Uni;

import java.util.List;

/**
 * Funnel Chart builder for AG Charts Enterprise.
 *
 * @param <J> the CRTP parameter for fluent API chaining
 */
public class AgFunnelChart<J extends AgFunnelChart<J>> extends AgChart<J>
{
    private String labelKey;
    private String valueKey;
    private String labelName;
    private String valueName;
    private List<?> data;
    private Boolean visible;
    private Boolean showInLegend;
    private Boolean showInMiniChart;
    private String fill;
    private Double fillOpacity;
    private String stroke;
    private Integer strokeWidth;
    private Integer cornerRadius;
    private String orientation;

    public AgFunnelChart(String id)
    {
        super(id);
    }

    public @org.jspecify.annotations.NonNull J setLabelKey(String labelKey)
    {
        this.labelKey = labelKey;
        return (J) this;
    }

    public @org.jspecify.annotations.NonNull J setValueKey(String valueKey)
    {
        this.valueKey = valueKey;
        return (J) this;
    }

    public @org.jspecify.annotations.NonNull J setLabelName(String labelName)
    {
        this.labelName = labelName;
        return (J) this;
    }

    public @org.jspecify.annotations.NonNull J setValueName(String valueName)
    {
        this.valueName = valueName;
        return (J) this;
    }

    public @org.jspecify.annotations.NonNull J setData(List<?> data)
    {
        this.data = data;
        return (J) this;
    }

    public @org.jspecify.annotations.NonNull J setVisible(Boolean visible)
    {
        this.visible = visible;
        return (J) this;
    }

    public @org.jspecify.annotations.NonNull J setShowInLegend(Boolean showInLegend)
    {
        this.showInLegend = showInLegend;
        return (J) this;
    }

    public @org.jspecify.annotations.NonNull J setShowInMiniChart(Boolean showInMiniChart)
    {
        this.showInMiniChart = showInMiniChart;
        return (J) this;
    }

    public @org.jspecify.annotations.NonNull J setFill(String fill)
    {
        this.fill = fill;
        return (J) this;
    }

    public @org.jspecify.annotations.NonNull J setFillOpacity(Double fillOpacity)
    {
        this.fillOpacity = fillOpacity;
        return (J) this;
    }

    public @org.jspecify.annotations.NonNull J setStroke(String stroke)
    {
        this.stroke = stroke;
        return (J) this;
    }

    public @org.jspecify.annotations.NonNull J setStrokeWidth(Integer strokeWidth)
    {
        this.strokeWidth = strokeWidth;
        return (J) this;
    }

    public @org.jspecify.annotations.NonNull J setCornerRadius(Integer cornerRadius)
    {
        this.cornerRadius = cornerRadius;
        return (J) this;
    }

    public @org.jspecify.annotations.NonNull J setOrientation(String orientation)
    {
        this.orientation = orientation;
        return (J) this;
    }

    @Override
    public Uni<AgChartOptions<?>> getInitialOptions()
    {
        return Uni.createFrom().item(() -> {
            AgFunnelSeriesOptions<?> series = new AgFunnelSeriesOptions<>()
                    .setLabelKey(labelKey)
                    .setValueKey(valueKey);

            if (labelName != null) series.setLabelName(labelName);
            if (valueName != null) series.setValueName(valueName);
            if (data != null) series.setData(data);
            if (visible != null) series.setVisible(visible);
            if (showInLegend != null) series.setShowInLegend(showInLegend);
            if (showInMiniChart != null) series.setShowInMiniChart(showInMiniChart);
            if (fill != null) series.setFill(fill);
            if (fillOpacity != null) series.setFillOpacity(fillOpacity);
            if (stroke != null) series.setStroke(stroke);
            if (strokeWidth != null) series.setStrokeWidth(strokeWidth);
            if (cornerRadius != null) series.setCornerRadius(cornerRadius);
            if (orientation != null) series.setOrientation(orientation);

            return new AgChartOptions<>().setSeries(List.of(series));
        });
    }
}
