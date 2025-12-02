package com.jwebmp.plugins.agchartsenterprise;

import com.jwebmp.plugins.agcharts.AgChart;
import com.jwebmp.plugins.agcharts.options.AgChartOptions;
import com.jwebmp.plugins.agchartsenterprise.options.series.AgSankeySeriesOptions;
import io.smallrye.mutiny.Uni;

import java.util.List;

/**
 * Sankey Chart builder for AG Charts Enterprise.
 *
 * @param <J> the CRTP parameter for fluent API chaining
 */
public class AgSankeyChart<J extends AgSankeyChart<J>> extends AgChart<J>
{
    private String sourceKey;
    private String targetKey;
    private String valueKey;
    private String sourceName;
    private String targetName;
    private String valueName;
    private List<?> data;
    private Boolean visible;
    private Boolean showInLegend;
    private Boolean showInMiniChart;
    private String fill;
    private Double fillOpacity;
    private String stroke;
    private Integer strokeWidth;
    private Double strokeOpacity;
    private String nodeFill;
    private String nodeStroke;
    private Integer nodeStrokeWidth;
    private Double nodeOpacity;
    private Integer nodePaddingTop;
    private Integer nodePaddingRight;
    private Integer nodePaddingBottom;
    private Integer nodePaddingLeft;

    public AgSankeyChart(String id)
    {
        super(id);
    }

    public @org.jspecify.annotations.NonNull J setSourceKey(String sourceKey)
    {
        this.sourceKey = sourceKey;
        return (J) this;
    }

    public @org.jspecify.annotations.NonNull J setTargetKey(String targetKey)
    {
        this.targetKey = targetKey;
        return (J) this;
    }

    public @org.jspecify.annotations.NonNull J setValueKey(String valueKey)
    {
        this.valueKey = valueKey;
        return (J) this;
    }

    public @org.jspecify.annotations.NonNull J setSourceName(String sourceName)
    {
        this.sourceName = sourceName;
        return (J) this;
    }

    public @org.jspecify.annotations.NonNull J setTargetName(String targetName)
    {
        this.targetName = targetName;
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

    public @org.jspecify.annotations.NonNull J setStrokeOpacity(Double strokeOpacity)
    {
        this.strokeOpacity = strokeOpacity;
        return (J) this;
    }

    public @org.jspecify.annotations.NonNull J setNodeFill(String nodeFill)
    {
        this.nodeFill = nodeFill;
        return (J) this;
    }

    public @org.jspecify.annotations.NonNull J setNodeStroke(String nodeStroke)
    {
        this.nodeStroke = nodeStroke;
        return (J) this;
    }

    public @org.jspecify.annotations.NonNull J setNodeStrokeWidth(Integer nodeStrokeWidth)
    {
        this.nodeStrokeWidth = nodeStrokeWidth;
        return (J) this;
    }

    public @org.jspecify.annotations.NonNull J setNodeOpacity(Double nodeOpacity)
    {
        this.nodeOpacity = nodeOpacity;
        return (J) this;
    }

    public @org.jspecify.annotations.NonNull J setNodePaddingTop(Integer nodePaddingTop)
    {
        this.nodePaddingTop = nodePaddingTop;
        return (J) this;
    }

    public @org.jspecify.annotations.NonNull J setNodePaddingRight(Integer nodePaddingRight)
    {
        this.nodePaddingRight = nodePaddingRight;
        return (J) this;
    }

    public @org.jspecify.annotations.NonNull J setNodePaddingBottom(Integer nodePaddingBottom)
    {
        this.nodePaddingBottom = nodePaddingBottom;
        return (J) this;
    }

    public @org.jspecify.annotations.NonNull J setNodePaddingLeft(Integer nodePaddingLeft)
    {
        this.nodePaddingLeft = nodePaddingLeft;
        return (J) this;
    }

    @Override
    public Uni<AgChartOptions<?>> getInitialOptions()
    {
        return Uni.createFrom().item(() -> {
            AgSankeySeriesOptions<?> series = new AgSankeySeriesOptions<>()
                    .setSourceKey(sourceKey)
                    .setTargetKey(targetKey)
                    .setValueKey(valueKey);

            if (sourceName != null) series.setSourceName(sourceName);
            if (targetName != null) series.setTargetName(targetName);
            if (valueName != null) series.setValueName(valueName);
            if (data != null) series.setData(data);
            if (visible != null) series.setVisible(visible);
            if (showInLegend != null) series.setShowInLegend(showInLegend);
            if (showInMiniChart != null) series.setShowInMiniChart(showInMiniChart);
            if (fill != null) series.setFill(fill);
            if (fillOpacity != null) series.setFillOpacity(fillOpacity);
            if (stroke != null) series.setStroke(stroke);
            if (strokeWidth != null) series.setStrokeWidth(strokeWidth);
            if (strokeOpacity != null) series.setStrokeOpacity(strokeOpacity);
            if (nodeFill != null) series.setNodeFill(nodeFill);
            if (nodeStroke != null) series.setNodeStroke(nodeStroke);
            if (nodeStrokeWidth != null) series.setNodeStrokeWidth(nodeStrokeWidth);
            if (nodeOpacity != null) series.setNodeOpacity(nodeOpacity);
            if (nodePaddingTop != null) series.setNodePaddingTop(nodePaddingTop);
            if (nodePaddingRight != null) series.setNodePaddingRight(nodePaddingRight);
            if (nodePaddingBottom != null) series.setNodePaddingBottom(nodePaddingBottom);
            if (nodePaddingLeft != null) series.setNodePaddingLeft(nodePaddingLeft);

            return new AgChartOptions<>().setSeries(List.of(series));
        });
    }
}
