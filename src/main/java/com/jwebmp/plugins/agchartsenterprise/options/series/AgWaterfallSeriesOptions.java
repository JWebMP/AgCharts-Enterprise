package com.jwebmp.plugins.agchartsenterprise.options.series;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRawValue;
import com.jwebmp.plugins.agcharts.options.series.AgSeriesBaseOptions;
import com.jwebmp.plugins.agcharts.options.series.AgSeriesLabelOptions;
import com.jwebmp.plugins.agcharts.options.series.AgSeriesListeners;

import java.util.List;

/**
 * Waterfall Series options for AG Charts Enterprise.
 *
 * <p>
 * The Waterfall series visualizes cumulative changes over time, showing
 * how a starting value is affected by a series of positive or negative values.
 * Useful for budget variance analysis, profit/loss breakdown, or financial flows.
 * </p>
 *
 * <p>
 * Key properties:
 * <ul>
 *   <li><strong>xKey</strong> - Category property (stage/period name)</li>
 *   <li><strong>valueKey</strong> - Change amount property (positive/negative)</li>
 *   <li><strong>openingValueKey</strong> - Starting balance (optional)</li>
 *   <li><strong>closingValueKey</strong> - Ending balance (optional)</li>
 * </ul>
 * </p>
 *
 * @param <J> the CRTP parameter for fluent API chaining
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AgWaterfallSeriesOptions<J extends AgWaterfallSeriesOptions<J>> extends AgSeriesBaseOptions<J>
{
    // --- Required keys ---
    private String xKey;              // Category property
    private String valueKey;          // Change amount

    // --- Optional keys ---
    private String openingValueKey;   // Starting balance
    private String closingValueKey;   // Ending balance

    // --- Display names ---
    private String xName;
    private String valueName;
    private String openingValueName;
    private String closingValueName;

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

    // --- Fill/Stroke (positive values) ---
    private String fill;
    private Double fillOpacity;
    private String stroke;
    private Integer strokeWidth;
    private Double strokeOpacity;

    // --- Negative value styling ---
    private String negativeFill;
    private Double negativeFillOpacity;

    // --- Opening/Closing value styling ---
    private String totalFill;
    private Double totalFillOpacity;

    // --- Corner radius ---
    private Integer cornerRadius;

    public AgWaterfallSeriesOptions()
    {
        setType("waterfall");
    }

    /**
     * Gets the property name for category/stage labels.
     *
     * @return the x key, or null if not set
     */
    public String getxKey()
    {
        return xKey;
    }

    /**
     * Sets the property name for category/stage labels.
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
     * Gets the property name for change amounts (positive/negative values).
     *
     * @return the value key, or null if not set
     */
    public String getValueKey()
    {
        return valueKey;
    }

    /**
     * Sets the property name for change amounts (positive/negative values).
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
     * Gets the property name for opening (starting) balance values.
     *
     * @return the opening value key, or null if not set
     */
    public String getOpeningValueKey()
    {
        return openingValueKey;
    }

    /**
     * Sets the property name for opening (starting) balance values.
     *
     * @param openingValueKey the property name
     * @return this instance for method chaining
     */
    public @org.jspecify.annotations.NonNull J setOpeningValueKey(String openingValueKey)
    {
        this.openingValueKey = openingValueKey;
        return (J) this;
    }

    /**
     * Gets the property name for closing (ending) balance values.
     *
     * @return the closing value key, or null if not set
     */
    public String getClosingValueKey()
    {
        return closingValueKey;
    }

    /**
     * Sets the property name for closing (ending) balance values.
     *
     * @param closingValueKey the property name
     * @return this instance for method chaining
     */
    public @org.jspecify.annotations.NonNull J setClosingValueKey(String closingValueKey)
    {
        this.closingValueKey = closingValueKey;
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
     * Gets the display name for the change value field.
     *
     * @return the value display name, or null for default
     */
    public String getValueName()
    {
        return valueName;
    }

    /**
     * Sets the display name for the change value field.
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
     * Gets the display name for opening balance field.
     *
     * @return the opening value display name, or null for default
     */
    public String getOpeningValueName()
    {
        return openingValueName;
    }

    /**
     * Sets the display name for opening balance field.
     *
     * @param openingValueName the display name
     * @return this instance for method chaining
     */
    public @org.jspecify.annotations.NonNull J setOpeningValueName(String openingValueName)
    {
        this.openingValueName = openingValueName;
        return (J) this;
    }

    /**
     * Gets the display name for closing balance field.
     *
     * @return the closing value display name, or null for default
     */
    public String getClosingValueName()
    {
        return closingValueName;
    }

    /**
     * Sets the display name for closing balance field.
     *
     * @param closingValueName the display name
     * @return this instance for method chaining
     */
    public @org.jspecify.annotations.NonNull J setClosingValueName(String closingValueName)
    {
        this.closingValueName = closingValueName;
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
     * @param data the array of data objects with waterfall entries
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
     * Gets the click detection range for waterfall bars.
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
     * Gets the fill color for positive waterfall bars.
     *
     * @return the hex color code or CSS color name, or null for default
     */
    public String getFill()
    {
        return fill;
    }

    /**
     * Sets the fill color for positive waterfall bars.
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
     * Gets the fill opacity for positive bars.
     *
     * @return the opacity (0..1), or null for default (1)
     */
    public Double getFillOpacity()
    {
        return fillOpacity;
    }

    /**
     * Sets the fill opacity for positive bars.
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
     * Gets the stroke color for bar outline.
     *
     * @return the hex color code or CSS color name, or null for default
     */
    public String getStroke()
    {
        return stroke;
    }

    /**
     * Sets the stroke color for bar outline.
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
     * Gets the stroke width for bar outline.
     *
     * @return the stroke width in pixels, or null for default (1)
     */
    public Integer getStrokeWidth()
    {
        return strokeWidth;
    }

    /**
     * Sets the stroke width for bar outline.
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
     * Gets the stroke opacity for bar outline.
     *
     * @return the opacity (0..1), or null for default (1)
     */
    public Double getStrokeOpacity()
    {
        return strokeOpacity;
    }

    /**
     * Sets the stroke opacity for bar outline.
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
     * Gets the fill color for negative (downward) bars.
     *
     * @return the hex color code or CSS color name, or null for default
     */
    public String getNegativeFill()
    {
        return negativeFill;
    }

    /**
     * Sets the fill color for negative (downward) bars.
     *
     * @param negativeFill the hex color code or CSS color name
     * @return this instance for method chaining
     */
    public @org.jspecify.annotations.NonNull J setNegativeFill(String negativeFill)
    {
        this.negativeFill = negativeFill;
        return (J) this;
    }

    /**
     * Gets the fill opacity for negative bars.
     *
     * @return the opacity (0..1), or null for default (1)
     */
    public Double getNegativeFillOpacity()
    {
        return negativeFillOpacity;
    }

    /**
     * Sets the fill opacity for negative bars.
     *
     * @param negativeFillOpacity the opacity value (0..1)
     * @return this instance for method chaining
     */
    public @org.jspecify.annotations.NonNull J setNegativeFillOpacity(Double negativeFillOpacity)
    {
        this.negativeFillOpacity = negativeFillOpacity;
        return (J) this;
    }

    /**
     * Gets the fill color for total/opening/closing bars.
     *
     * @return the hex color code or CSS color name, or null for default
     */
    public String getTotalFill()
    {
        return totalFill;
    }

    /**
     * Sets the fill color for total/opening/closing bars.
     *
     * @param totalFill the hex color code or CSS color name
     * @return this instance for method chaining
     */
    public @org.jspecify.annotations.NonNull J setTotalFill(String totalFill)
    {
        this.totalFill = totalFill;
        return (J) this;
    }

    /**
     * Gets the fill opacity for total bars.
     *
     * @return the opacity (0..1), or null for default (1)
     */
    public Double getTotalFillOpacity()
    {
        return totalFillOpacity;
    }

    /**
     * Sets the fill opacity for total bars.
     *
     * @param totalFillOpacity the opacity value (0..1)
     * @return this instance for method chaining
     */
    public @org.jspecify.annotations.NonNull J setTotalFillOpacity(Double totalFillOpacity)
    {
        this.totalFillOpacity = totalFillOpacity;
        return (J) this;
    }

    /**
     * Gets the corner radius for waterfall bars.
     *
     * @return the corner radius in pixels, or null for sharp corners
     */
    public Integer getCornerRadius()
    {
        return cornerRadius;
    }

    /**
     * Sets the corner radius for waterfall bars.
     *
     * @param cornerRadius the corner radius in pixels
     * @return this instance for method chaining
     */
    public @org.jspecify.annotations.NonNull J setCornerRadius(Integer cornerRadius)
    {
        this.cornerRadius = cornerRadius;
        return (J) this;
    }
}
