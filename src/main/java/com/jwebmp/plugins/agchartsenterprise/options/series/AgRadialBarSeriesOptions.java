package com.jwebmp.plugins.agchartsenterprise.options.series;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRawValue;
import com.jwebmp.core.htmlbuilder.javascript.JavaScriptPart;
import com.jwebmp.plugins.agcharts.options.series.*;

import java.util.List;

/**
 * Radial Bar (Circular Bar) Series options for AG Charts Enterprise.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AgRadialBarSeriesOptions<J extends AgRadialBarSeriesOptions<J>> extends AgSeriesBaseOptions<J> {

    // --- Required keys ---
    private String angleKey;   // DatumKey (numeric values)
    private String radiusKey;  // DatumKey (category values)

    // --- Grouping & Stacking ---
    private Boolean grouped;       // whether to group adjacently
    private Boolean stacked;       // whether to stack
    private String stackGroup;     // ID grouping stacked items
    private Number normalizedTo;   // normalise stacks to this value

    // --- Identity & linkage ---
    /** Primary identifier for the series (exposed to callbacks as seriesId). */
    @JsonProperty("id")
    private String id;
    private Object context; // user context object passed to callbacks

    // --- Data/visibility/legend ---
    private List<?> data; // TDatum[]
    private Boolean visible;
    private String cursor; // CSS cursor for hovered nodes
    private Object nodeClickRange; // 'nearest' | 'exact' | number
    private Boolean showInLegend;
    private AgSeriesListeners<?> listeners;

    // --- Names for display ---
    private String angleName;
    private String radiusName;

    // --- Labels & Tooltip ---
    // Label uses base AgSeriesLabelOptions (box with fill/border/padding + itemStyler)
    private AgSeriesLabelOptions<?> label;
    // Tooltip is inherited from base via setTooltip/getTooltip

    // --- Style/Styler/Highlight ---
    /** Per-item styler for adjusting bar styling. */
    @JsonRawValue
    private String itemStyler;

    // Highlight options inherited from base via setHighlight/getHighlight

    // --- Geometry & Styling ---
    private Integer cornerRadius;   // bar corner radius
    private Double fillOpacity;     // 0..1
    private String stroke;          // stroke color
    private Integer strokeWidth;    // px
    private Double strokeOpacity;   // 0..1
    private List<Integer> lineDash; // dash pattern
    private Integer lineDashOffset; // px

    public AgRadialBarSeriesOptions() {
        setType("radial-bar");
    }

    // --- Getters/Setters ---
    public String getAngleKey() { return angleKey; }
    public J setAngleKey(String angleKey) { this.angleKey = angleKey; return (J) this; }

    public String getRadiusKey() { return radiusKey; }
    public J setRadiusKey(String radiusKey) { this.radiusKey = radiusKey; return (J) this; }

    public Boolean getGrouped() { return grouped; }
    public J setGrouped(Boolean grouped) { this.grouped = grouped; return (J) this; }

    public Boolean getStacked() { return stacked; }
    public J setStacked(Boolean stacked) { this.stacked = stacked; return (J) this; }

    public String getStackGroup() { return stackGroup; }
    public J setStackGroup(String stackGroup) { this.stackGroup = stackGroup; return (J) this; }

    public Number getNormalizedTo() { return normalizedTo; }
    public J setNormalizedTo(Number normalizedTo) { this.normalizedTo = normalizedTo; return (J) this; }

    public String getId() { return id; }
    /** Also sets the base seriesId for consistency. */
    public J setId(String id) { this.id = id; setSeriesId(id); return (J) this; }

    public Object getContext() { return context; }
    public J setContext(Object context) { this.context = context; return (J) this; }

    public List<?> getData() { return data; }
    public J setData(List<?> data) { this.data = data; return (J) this; }

    public Boolean getVisible() { return visible; }
    public J setVisible(Boolean visible) { this.visible = visible; return (J) this; }

    public String getCursor() { return cursor; }
    public J setCursor(String cursor) { this.cursor = cursor; return (J) this; }

    public Object getNodeClickRange() { return nodeClickRange; }
    public J setNodeClickRange(String range) { this.nodeClickRange = range; return (J) this; }
    public J setNodeClickRange(Integer pixels) { this.nodeClickRange = pixels; return (J) this; }

    public Boolean getShowInLegend() { return showInLegend; }
    public J setShowInLegend(Boolean showInLegend) { this.showInLegend = showInLegend; return (J) this; }

    public AgSeriesListeners<?> getListeners() { return listeners; }
    public J setListeners(AgSeriesListeners<?> listeners) { this.listeners = listeners; return (J) this; }

    public String getAngleName() { return angleName; }
    public J setAngleName(String angleName) { this.angleName = angleName; return (J) this; }

    public String getRadiusName() { return radiusName; }
    public J setRadiusName(String radiusName) { this.radiusName = radiusName; return (J) this; }

    public AgSeriesLabelOptions<?> getLabel() { return label; }
    public J setLabel(AgSeriesLabelOptions<?> label) { this.label = label; return (J) this; }

    public String getItemStyler() { return itemStyler; }
    public J setItemStyler(String itemStyler) { this.itemStyler = itemStyler; return (J) this; }

    public Integer getCornerRadius() { return cornerRadius; }
    public J setCornerRadius(Integer cornerRadius) { this.cornerRadius = cornerRadius; return (J) this; }

    public Double getFillOpacity() { return fillOpacity; }
    public J setFillOpacity(Double fillOpacity) { this.fillOpacity = fillOpacity; return (J) this; }

    public String getStroke() { return stroke; }
    public J setStroke(String stroke) { this.stroke = stroke; return (J) this; }

    public Integer getStrokeWidth() { return strokeWidth; }
    public J setStrokeWidth(Integer strokeWidth) { this.strokeWidth = strokeWidth; return (J) this; }

    public Double getStrokeOpacity() { return strokeOpacity; }
    public J setStrokeOpacity(Double strokeOpacity) { this.strokeOpacity = strokeOpacity; return (J) this; }

    public List<Integer> getLineDash() { return lineDash; }
    public J setLineDash(List<Integer> lineDash) { this.lineDash = lineDash; return (J) this; }

    public Integer getLineDashOffset() { return lineDashOffset; }
    public J setLineDashOffset(Integer lineDashOffset) { this.lineDashOffset = lineDashOffset; return (J) this; }
}
