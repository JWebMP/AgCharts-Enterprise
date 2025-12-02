package com.jwebmp.plugins.agchartsenterprise.options.series;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRawValue;
import com.jwebmp.plugins.agcharts.options.series.AgSeriesBaseOptions;
import com.jwebmp.plugins.agcharts.options.series.AgSeriesLabelOptions;
import com.jwebmp.plugins.agcharts.options.series.AgSeriesListeners;

import java.util.List;

/**
 * Sankey Series options for AG Charts Enterprise.
 *
 * <p>
 * The Sankey series visualizes the flow of quantities between nodes,
 * showing how values distribute from source to destination. Width of flows
 * is proportional to quantity. Ideal for analyzing energy flow, financial transfers,
 * and process pipelines.
 * </p>
 *
 * <p>
 * Key properties:
 * <ul>
 *   <li><strong>sourceKey</strong> - Property defining the flow source node</li>
 *   <li><strong>targetKey</strong> - Property defining the flow destination node</li>
 *   <li><strong>valueKey</strong> - Property defining the flow quantity/width</li>
 * </ul>
 * </p>
 *
 * @param <J> the CRTP parameter for fluent API chaining
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AgSankeySeriesOptions<J extends AgSankeySeriesOptions<J>> extends AgSeriesBaseOptions<J>
{
    // --- Required keys ---
    private String sourceKey;  // Source node property
    private String targetKey;  // Target/destination node property
    private String valueKey;   // Flow value/width property

    // --- Display names ---
    private String sourceName;
    private String targetName;
    private String valueName;

    // --- Identity & linkage ---
    @JsonProperty("id")
    private String id;
    private Object context;

    // --- Data/visibility/misc ---
    private List<?> data;
    private Boolean visible;
    private String cursor;
    private Object nodeClickRange;
    private AgSeriesListeners<?> listeners;
    private Boolean showInMiniChart;
    private Boolean showInLegend;

    // --- Labels & Styling ---
    private AgSeriesLabelOptions<?> label;
    @JsonRawValue
    private String itemStyler;

    // --- Flow/Link styling ---
    private String fill;
    private Double fillOpacity;
    private String stroke;
    private Integer strokeWidth;
    private Double strokeOpacity;

    // --- Node styling ---
    private String nodeFill;
    private String nodeStroke;
    private Integer nodeStrokeWidth;
    private Double nodeOpacity;
    private Integer nodePaddingTop;
    private Integer nodePaddingRight;
    private Integer nodePaddingBottom;
    private Integer nodePaddingLeft;

    public AgSankeySeriesOptions()
    {
        setType("sankey");
    }

    /**
     * Gets the property name for flow source nodes.
     *
     * @return the source key, or null if not set
     */
    public String getSourceKey()
    {
        return sourceKey;
    }

    /**
     * Sets the property name for flow source nodes.
     *
     * @param sourceKey the property name
     * @return this instance for method chaining
     */
    public @org.jspecify.annotations.NonNull J setSourceKey(String sourceKey)
    {
        this.sourceKey = sourceKey;
        return (J) this;
    }

    /**
     * Gets the property name for flow target/destination nodes.
     *
     * @return the target key, or null if not set
     */
    public String getTargetKey()
    {
        return targetKey;
    }

    /**
     * Sets the property name for flow target/destination nodes.
     *
     * @param targetKey the property name
     * @return this instance for method chaining
     */
    public @org.jspecify.annotations.NonNull J setTargetKey(String targetKey)
    {
        this.targetKey = targetKey;
        return (J) this;
    }

    /**
     * Gets the property name for flow values/quantities.
     *
     * @return the value key, or null if not set
     */
    public String getValueKey()
    {
        return valueKey;
    }

    /**
     * Sets the property name for flow values/quantities.
     *
     * @param valueKey the property name
     * @return this instance for method chaining
     */
    public @org.jspecify.annotations.NonNull J setValueKey(String valueKey)
    {
        this.valueKey = valueKey;
        return (J) this;
    }

    /**
     * Gets the display name for the source node field.
     *
     * @return the source display name, or null for default
     */
    public String getSourceName()
    {
        return sourceName;
    }

    /**
     * Sets the display name for the source node field.
     *
     * @param sourceName the display name
     * @return this instance for method chaining
     */
    public @org.jspecify.annotations.NonNull J setSourceName(String sourceName)
    {
        this.sourceName = sourceName;
        return (J) this;
    }

    /**
     * Gets the display name for the target node field.
     *
     * @return the target display name, or null for default
     */
    public String getTargetName()
    {
        return targetName;
    }

    /**
     * Sets the display name for the target node field.
     *
     * @param targetName the display name
     * @return this instance for method chaining
     */
    public @org.jspecify.annotations.NonNull J setTargetName(String targetName)
    {
        this.targetName = targetName;
        return (J) this;
    }

    /**
     * Gets the display name for the value/quantity field.
     *
     * @return the value display name, or null for default
     */
    public String getValueName()
    {
        return valueName;
    }

    /**
     * Sets the display name for the value/quantity field.
     *
     * @param valueName the display name
     * @return this instance for method chaining
     */
    public @org.jspecify.annotations.NonNull J setValueName(String valueName)
    {
        this.valueName = valueName;
        return (J) this;
    }

    /**
     * Gets the unique identifier for this series.
     *
     * @return the series id, or null if not set
     */
    public String getId()
    {
        return id;
    }

    /**
     * Sets the unique identifier for this series.
     *
     * @param id the unique identifier
     * @return this instance for method chaining
     */
    public @org.jspecify.annotations.NonNull J setId(String id)
    {
        this.id = id;
        return (J) this;
    }

    /**
     * Gets the custom context object for this series.
     *
     * @return the context object, or null if not set
     */
    public Object getContext()
    {
        return context;
    }

    /**
     * Sets the custom context object for this series.
     *
     * @param context the context object passed to callbacks
     * @return this instance for method chaining
     */
    public @org.jspecify.annotations.NonNull J setContext(Object context)
    {
        this.context = context;
        return (J) this;
    }

    /**
     * Gets the data array for this series.
     *
     * @return the array of data objects, or null if not set
     */
    public List<?> getData()
    {
        return data;
    }

    /**
     * Sets the data array for this series.
     *
     * @param data the array of sankey flow objects
     * @return this instance for method chaining
     */
    public @org.jspecify.annotations.NonNull J setData(List<?> data)
    {
        this.data = data;
        return (J) this;
    }

    /**
     * Gets the visibility state of this series.
     *
     * @return true if visible, false if hidden, or null for default (true)
     */
    public Boolean getVisible()
    {
        return visible;
    }

    /**
     * Sets the visibility state of this series.
     *
     * @param visible true to show, false to hide
     * @return this instance for method chaining
     */
    public @org.jspecify.annotations.NonNull J setVisible(Boolean visible)
    {
        this.visible = visible;
        return (J) this;
    }

    /**
     * Gets the cursor style for hovering over series elements.
     *
     * @return the CSS cursor name, or null for default
     */
    public String getCursor()
    {
        return cursor;
    }

    /**
     * Sets the cursor style for hovering over series elements.
     *
     * @param cursor the CSS cursor name (e.g., "pointer")
     * @return this instance for method chaining
     */
    public @org.jspecify.annotations.NonNull J setCursor(String cursor)
    {
        this.cursor = cursor;
        return (J) this;
    }

    /**
     * Gets the click detection range for sankey links.
     *
     * @return the range as String or Integer, or null for default
     */
    public Object getNodeClickRange()
    {
        return nodeClickRange;
    }

    /**
     * Sets the click detection range using a CSS distance value.
     *
     * @param range the CSS distance (e.g., "5px")
     * @return this instance for method chaining
     */
    public @org.jspecify.annotations.NonNull J setNodeClickRange(String range)
    {
        this.nodeClickRange = range;
        return (J) this;
    }

    /**
     * Sets the click detection range using pixel values.
     *
     * @param pixels the distance in pixels
     * @return this instance for method chaining
     */
    public @org.jspecify.annotations.NonNull J setNodeClickRange(Integer pixels)
    {
        this.nodeClickRange = pixels;
        return (J) this;
    }

    /**
     * Gets the event listeners for this series.
     *
     * @return the listeners configuration, or null if not set
     */
    public AgSeriesListeners<?> getListeners()
    {
        return listeners;
    }

    /**
     * Sets the event listeners for this series.
     *
     * @param listeners the listeners configuration
     * @return this instance for method chaining
     */
    public @org.jspecify.annotations.NonNull J setListeners(AgSeriesListeners<?> listeners)
    {
        this.listeners = listeners;
        return (J) this;
    }

    /**
     * Gets whether this series appears in the mini chart.
     *
     * @return true to show in mini chart, false to hide, or null for default
     */
    public Boolean getShowInMiniChart()
    {
        return showInMiniChart;
    }

    /**
     * Sets whether this series appears in the mini chart.
     *
     * @param showInMiniChart true to include in mini chart, false to exclude
     * @return this instance for method chaining
     */
    public @org.jspecify.annotations.NonNull J setShowInMiniChart(Boolean showInMiniChart)
    {
        this.showInMiniChart = showInMiniChart;
        return (J) this;
    }

    /**
     * Gets whether this series appears in the legend.
     *
     * @return true to show in legend, false to hide, or null for default
     */
    public Boolean getShowInLegend()
    {
        return showInLegend;
    }

    /**
     * Sets whether this series appears in the legend.
     *
     * @param showInLegend true to show in legend, false to hide
     * @return this instance for method chaining
     */
    public @org.jspecify.annotations.NonNull J setShowInLegend(Boolean showInLegend)
    {
        this.showInLegend = showInLegend;
        return (J) this;
    }

    /**
     * Gets the label options for this series.
     *
     * @return the label configuration, or null if not set
     */
    public AgSeriesLabelOptions<?> getLabel()
    {
        return label;
    }

    /**
     * Sets the label options for this series.
     *
     * @param label the label configuration
     * @return this instance for method chaining
     */
    public @org.jspecify.annotations.NonNull J setLabel(AgSeriesLabelOptions<?> label)
    {
        this.label = label;
        return (J) this;
    }

    /**
     * Gets the item styler function as raw JSON.
     *
     * @return the item styler function, or null if not set
     */
    public String getItemStyler()
    {
        return itemStyler;
    }

    /**
     * Sets the item styler function as raw JSON.
     *
     * @param itemStyler the item styler function
     * @return this instance for method chaining
     */
    public @org.jspecify.annotations.NonNull J setItemStyler(String itemStyler)
    {
        this.itemStyler = itemStyler;
        return (J) this;
    }

    /**
     * Gets the fill color for sankey flows/links.
     *
     * @return the hex color code or CSS color name, or null for default
     */
    public String getFill()
    {
        return fill;
    }

    /**
     * Sets the fill color for sankey flows/links.
     *
     * @param fill the hex color code or CSS color name
     * @return this instance for method chaining
     */
    public @org.jspecify.annotations.NonNull J setFill(String fill)
    {
        this.fill = fill;
        return (J) this;
    }

    /**
     * Gets the fill opacity for sankey flows/links.
     *
     * @return the opacity (0..1), or null for default (0.5)
     */
    public Double getFillOpacity()
    {
        return fillOpacity;
    }

    /**
     * Sets the fill opacity for sankey flows/links.
     *
     * @param fillOpacity the opacity value (0..1)
     * @return this instance for method chaining
     */
    public @org.jspecify.annotations.NonNull J setFillOpacity(Double fillOpacity)
    {
        this.fillOpacity = fillOpacity;
        return (J) this;
    }

    /**
     * Gets the stroke color for sankey link outlines.
     *
     * @return the hex color code or CSS color name, or null for default
     */
    public String getStroke()
    {
        return stroke;
    }

    /**
     * Sets the stroke color for sankey link outlines.
     *
     * @param stroke the hex color code or CSS color name
     * @return this instance for method chaining
     */
    public @org.jspecify.annotations.NonNull J setStroke(String stroke)
    {
        this.stroke = stroke;
        return (J) this;
    }

    /**
     * Gets the stroke width for sankey link outlines.
     *
     * @return the stroke width in pixels, or null for default (0)
     */
    public Integer getStrokeWidth()
    {
        return strokeWidth;
    }

    /**
     * Sets the stroke width for sankey link outlines.
     *
     * @param strokeWidth the width in pixels
     * @return this instance for method chaining
     */
    public @org.jspecify.annotations.NonNull J setStrokeWidth(Integer strokeWidth)
    {
        this.strokeWidth = strokeWidth;
        return (J) this;
    }

    /**
     * Gets the stroke opacity for sankey link outlines.
     *
     * @return the opacity (0..1), or null for default (1)
     */
    public Double getStrokeOpacity()
    {
        return strokeOpacity;
    }

    /**
     * Sets the stroke opacity for sankey link outlines.
     *
     * @param strokeOpacity the opacity value (0..1)
     * @return this instance for method chaining
     */
    public @org.jspecify.annotations.NonNull J setStrokeOpacity(Double strokeOpacity)
    {
        this.strokeOpacity = strokeOpacity;
        return (J) this;
    }

    /**
     * Gets the fill color for sankey nodes.
     *
     * @return the hex color code or CSS color name, or null for default
     */
    public String getNodeFill()
    {
        return nodeFill;
    }

    /**
     * Sets the fill color for sankey nodes.
     *
     * @param nodeFill the hex color code or CSS color name
     * @return this instance for method chaining
     */
    public @org.jspecify.annotations.NonNull J setNodeFill(String nodeFill)
    {
        this.nodeFill = nodeFill;
        return (J) this;
    }

    /**
     * Gets the stroke color for sankey node outlines.
     *
     * @return the hex color code or CSS color name, or null for default
     */
    public String getNodeStroke()
    {
        return nodeStroke;
    }

    /**
     * Sets the stroke color for sankey node outlines.
     *
     * @param nodeStroke the hex color code or CSS color name
     * @return this instance for method chaining
     */
    public @org.jspecify.annotations.NonNull J setNodeStroke(String nodeStroke)
    {
        this.nodeStroke = nodeStroke;
        return (J) this;
    }

    /**
     * Gets the stroke width for sankey node outlines.
     *
     * @return the stroke width in pixels, or null for default (1)
     */
    public Integer getNodeStrokeWidth()
    {
        return nodeStrokeWidth;
    }

    /**
     * Sets the stroke width for sankey node outlines.
     *
     * @param nodeStrokeWidth the width in pixels
     * @return this instance for method chaining
     */
    public @org.jspecify.annotations.NonNull J setNodeStrokeWidth(Integer nodeStrokeWidth)
    {
        this.nodeStrokeWidth = nodeStrokeWidth;
        return (J) this;
    }

    /**
     * Gets the opacity for sankey nodes.
     *
     * @return the opacity (0..1), or null for default (1)
     */
    public Double getNodeOpacity()
    {
        return nodeOpacity;
    }

    /**
     * Sets the opacity for sankey nodes.
     *
     * @param nodeOpacity the opacity value (0..1)
     * @return this instance for method chaining
     */
    public @org.jspecify.annotations.NonNull J setNodeOpacity(Double nodeOpacity)
    {
        this.nodeOpacity = nodeOpacity;
        return (J) this;
    }

    /**
     * Gets the top padding for sankey nodes.
     *
     * @return the padding in pixels, or null for default
     */
    public Integer getNodePaddingTop()
    {
        return nodePaddingTop;
    }

    /**
     * Sets the top padding for sankey nodes.
     *
     * @param nodePaddingTop the padding in pixels
     * @return this instance for method chaining
     */
    public @org.jspecify.annotations.NonNull J setNodePaddingTop(Integer nodePaddingTop)
    {
        this.nodePaddingTop = nodePaddingTop;
        return (J) this;
    }

    /**
     * Gets the right padding for sankey nodes.
     *
     * @return the padding in pixels, or null for default
     */
    public Integer getNodePaddingRight()
    {
        return nodePaddingRight;
    }

    /**
     * Sets the right padding for sankey nodes.
     *
     * @param nodePaddingRight the padding in pixels
     * @return this instance for method chaining
     */
    public @org.jspecify.annotations.NonNull J setNodePaddingRight(Integer nodePaddingRight)
    {
        this.nodePaddingRight = nodePaddingRight;
        return (J) this;
    }

    /**
     * Gets the bottom padding for sankey nodes.
     *
     * @return the padding in pixels, or null for default
     */
    public Integer getNodePaddingBottom()
    {
        return nodePaddingBottom;
    }

    /**
     * Sets the bottom padding for sankey nodes.
     *
     * @param nodePaddingBottom the padding in pixels
     * @return this instance for method chaining
     */
    public @org.jspecify.annotations.NonNull J setNodePaddingBottom(Integer nodePaddingBottom)
    {
        this.nodePaddingBottom = nodePaddingBottom;
        return (J) this;
    }

    /**
     * Gets the left padding for sankey nodes.
     *
     * @return the padding in pixels, or null for default
     */
    public Integer getNodePaddingLeft()
    {
        return nodePaddingLeft;
    }

    /**
     * Sets the left padding for sankey nodes.
     *
     * @param nodePaddingLeft the padding in pixels
     * @return this instance for method chaining
     */
    public @org.jspecify.annotations.NonNull J setNodePaddingLeft(Integer nodePaddingLeft)
    {
        this.nodePaddingLeft = nodePaddingLeft;
        return (J) this;
    }
}
