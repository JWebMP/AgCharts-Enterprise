package com.jwebmp.plugins.agchartsenterprise.options.series;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRawValue;
import com.jwebmp.plugins.agcharts.options.series.AgSeriesBaseOptions;
import com.jwebmp.plugins.agcharts.options.series.AgSeriesLabelOptions;
import com.jwebmp.plugins.agcharts.options.series.AgSeriesListeners;

import java.util.List;

/**
 * Range Area Series options for AG Charts Enterprise.
 *
 * <p>
 * The Range Area series visualizes data as an area chart representing a range
 * between minimum and maximum values. Useful for displaying confidence bands,
 * temperature ranges, price ranges over time, or any min-max paired time series data.
 * </p>
 *
 * <p>
 * Key properties:
 * <ul>
 *   <li><strong>xKey</strong> - X-axis property name (typically date/time)</li>
 *   <li><strong>yLowKey</strong> - Lower bound value property name</li>
 *   <li><strong>yHighKey</strong> - Upper bound value property name</li>
 *   <li><strong>fill/stroke</strong> - Area appearance customization</li>
 * </ul>
 * </p>
 *
 * @param <J> the CRTP parameter for fluent API chaining
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AgRangeAreaSeriesOptions<J extends AgRangeAreaSeriesOptions<J>> extends AgSeriesBaseOptions<J>
{
    // --- Required keys ---
    private String xKey;      // X-axis property name (typically date/time)
    private String yLowKey;   // Lower bound property name
    private String yHighKey;  // Upper bound property name

    // --- Display names ---
    private String xName;
    private String yLowName;
    private String yHighName;

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

    // --- Fill/Stroke ---
    private String fill;
    private Double fillOpacity;
    private String stroke;
    private Integer strokeWidth;
    private Double strokeOpacity;
    private List<Integer> lineDash;
    private Integer lineDashOffset;

    public AgRangeAreaSeriesOptions()
    {
        setType("range-area");
    }

    /**
     * Gets the property name for x-axis values (typically date/time).
     *
     * @return the x key, or null if not set
     */
    public String getxKey()
    {
        return xKey;
    }

    /**
     * Sets the property name for x-axis values (typically date/time).
     *
     * @param xKey the property name
     * @return this instance for method chaining
     */
    public @org.jspecify.annotations.NonNull J setxKey(String xKey)
    {
        this.xKey = xKey;
        return (J) this;
    }

    /**
     * Gets the property name for the lower bound (minimum) values.
     *
     * @return the yLow key, or null if not set
     */
    public String getyLowKey()
    {
        return yLowKey;
    }

    /**
     * Sets the property name for the lower bound (minimum) values.
     *
     * @param yLowKey the property name
     * @return this instance for method chaining
     */
    public @org.jspecify.annotations.NonNull J setyLowKey(String yLowKey)
    {
        this.yLowKey = yLowKey;
        return (J) this;
    }

    /**
     * Gets the property name for the upper bound (maximum) values.
     *
     * @return the yHigh key, or null if not set
     */
    public String getyHighKey()
    {
        return yHighKey;
    }

    /**
     * Sets the property name for the upper bound (maximum) values.
     *
     * @param yHighKey the property name
     * @return this instance for method chaining
     */
    public @org.jspecify.annotations.NonNull J setyHighKey(String yHighKey)
    {
        this.yHighKey = yHighKey;
        return (J) this;
    }

    /**
     * Gets the display name for the x-axis field.
     *
     * @return the x display name, or null for default
     */
    public String getxName()
    {
        return xName;
    }

    /**
     * Sets the display name for the x-axis field.
     *
     * @param xName the display name
     * @return this instance for method chaining
     */
    public @org.jspecify.annotations.NonNull J setxName(String xName)
    {
        this.xName = xName;
        return (J) this;
    }

    /**
     * Gets the display name for the lower bound field.
     *
     * @return the yLow display name, or null for default
     */
    public String getyLowName()
    {
        return yLowName;
    }

    /**
     * Sets the display name for the lower bound field.
     *
     * @param yLowName the display name
     * @return this instance for method chaining
     */
    public @org.jspecify.annotations.NonNull J setyLowName(String yLowName)
    {
        this.yLowName = yLowName;
        return (J) this;
    }

    /**
     * Gets the display name for the upper bound field.
     *
     * @return the yHigh display name, or null for default
     */
    public String getyHighName()
    {
        return yHighName;
    }

    /**
     * Sets the display name for the upper bound field.
     *
     * @param yHighName the display name
     * @return this instance for method chaining
     */
    public @org.jspecify.annotations.NonNull J setyHighName(String yHighName)
    {
        this.yHighName = yHighName;
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
     * @param data the array of data objects with range properties
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
     * Gets the click detection range for range area.
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
     * Gets the fill color for the range area.
     *
     * @return the hex color code or CSS color name, or null for default
     */
    public String getFill()
    {
        return fill;
    }

    /**
     * Sets the fill color for the range area.
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
     * Gets the fill opacity for the range area.
     *
     * @return the opacity (0..1), or null for default (1)
     */
    public Double getFillOpacity()
    {
        return fillOpacity;
    }

    /**
     * Sets the fill opacity for the range area.
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
     * Gets the stroke color for the area outline.
     *
     * @return the hex color code or CSS color name, or null for default
     */
    public String getStroke()
    {
        return stroke;
    }

    /**
     * Sets the stroke color for the area outline.
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
     * Gets the stroke width for the area outline.
     *
     * @return the stroke width in pixels, or null for default (1)
     */
    public Integer getStrokeWidth()
    {
        return strokeWidth;
    }

    /**
     * Sets the stroke width for the area outline.
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
     * Gets the stroke opacity for the area outline.
     *
     * @return the opacity (0..1), or null for default (1)
     */
    public Double getStrokeOpacity()
    {
        return strokeOpacity;
    }

    /**
     * Sets the stroke opacity for the area outline.
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
     * Gets the dash pattern for the area outline.
     *
     * @return the line dash pattern, or null for solid line
     */
    public List<Integer> getLineDash()
    {
        return lineDash;
    }

    /**
     * Sets the dash pattern for the area outline.
     *
     * @param lineDash the dash pattern (e.g., [5, 5] for alternating dashes)
     * @return this instance for method chaining
     */
    public @org.jspecify.annotations.NonNull J setLineDash(List<Integer> lineDash)
    {
        this.lineDash = lineDash;
        return (J) this;
    }

    /**
     * Gets the dash offset for the area outline.
     *
     * @return the dash offset in pixels, or null for default (0)
     */
    public Integer getLineDashOffset()
    {
        return lineDashOffset;
    }

    /**
     * Sets the dash offset for the area outline.
     *
     * @param lineDashOffset the offset in pixels
     * @return this instance for method chaining
     */
    public @org.jspecify.annotations.NonNull J setLineDashOffset(Integer lineDashOffset)
    {
        this.lineDashOffset = lineDashOffset;
        return (J) this;
    }
}
