package com.jwebmp.plugins.agchartsenterprise.options.series;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRawValue;
import com.jwebmp.plugins.agcharts.options.series.AgSeriesBaseOptions;
import com.jwebmp.plugins.agcharts.options.series.AgSeriesLabelOptions;
import com.jwebmp.plugins.agcharts.options.series.AgSeriesListeners;

import java.util.List;

/**
 * Box Plot Series options for AG Charts Enterprise.
 *
 * <p>
 * The Box Plot series visualizes statistical distribution of data showing
 * quartiles, median, and outliers. Each box represents a distribution group
 * with whiskers extending to min/max values and potential outlier points.
 * </p>
 *
 * <p>
 * Key properties:
 * <ul>
 *   <li><strong>xKey</strong> - Category/group property</li>
 *   <li><strong>minKey</strong> - Minimum value property</li>
 *   <li><strong>q1Key</strong> - First quartile (25th percentile)</li>
 *   <li><strong>medianKey</strong> - Median (50th percentile)</li>
 *   <li><strong>q3Key</strong> - Third quartile (75th percentile)</li>
 *   <li><strong>maxKey</strong> - Maximum value property</li>
 * </ul>
 * </p>
 *
 * @param <J> the CRTP parameter for fluent API chaining
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AgBoxPlotSeriesOptions<J extends AgBoxPlotSeriesOptions<J>> extends AgSeriesBaseOptions<J>
{
    // --- Required keys ---
    private String xKey;        // Category/group property
    private String minKey;      // Minimum value
    private String q1Key;       // First quartile (25th percentile)
    private String medianKey;   // Median (50th percentile)
    private String q3Key;       // Third quartile (75th percentile)
    private String maxKey;      // Maximum value

    // --- Optional keys ---
    private String outlierKeys; // Outlier values (array)

    // --- Display names ---
    private String xName;
    private String minName;
    private String q1Name;
    private String medianName;
    private String q3Name;
    private String maxName;
    private String outlierName;

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

    // --- Box styling ---
    private String fill;
    private Double fillOpacity;
    private String stroke;
    private Integer strokeWidth;
    private Double strokeOpacity;

    // --- Whisker/line styling ---
    private Integer lineWidth;
    private String lineDash;

    // --- Outlier styling ---
    private Integer outlierSize;
    private String outlierFill;
    private String outlierStroke;

    // --- Corner radius ---
    private Integer cornerRadius;

    public AgBoxPlotSeriesOptions()
    {
        setType("box-plot");
    }

    /**
     * Gets the property name for category/group labels.
     *
     * @return the x key, or null if not set
     */
    public String getxKey()
    {
        return xKey;
    }

    /**
     * Sets the property name for category/group labels.
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
     * Gets the property name for minimum values.
     *
     * @return the min key, or null if not set
     */
    public String getMinKey()
    {
        return minKey;
    }

    /**
     * Sets the property name for minimum values.
     *
     * @param minKey the property name
     * @return this instance for method chaining
     */
    public @org.jspecify.annotations.NonNull J setMinKey(String minKey)
    {
        this.minKey = minKey;
        return (J) this;
    }

    /**
     * Gets the property name for Q1 (first quartile, 25th percentile) values.
     *
     * @return the q1 key, or null if not set
     */
    public String getQ1Key()
    {
        return q1Key;
    }

    /**
     * Sets the property name for Q1 (first quartile, 25th percentile) values.
     *
     * @param q1Key the property name
     * @return this instance for method chaining
     */
    public @org.jspecify.annotations.NonNull J setQ1Key(String q1Key)
    {
        this.q1Key = q1Key;
        return (J) this;
    }

    /**
     * Gets the property name for median (50th percentile) values.
     *
     * @return the median key, or null if not set
     */
    public String getMedianKey()
    {
        return medianKey;
    }

    /**
     * Sets the property name for median (50th percentile) values.
     *
     * @param medianKey the property name
     * @return this instance for method chaining
     */
    public @org.jspecify.annotations.NonNull J setMedianKey(String medianKey)
    {
        this.medianKey = medianKey;
        return (J) this;
    }

    /**
     * Gets the property name for Q3 (third quartile, 75th percentile) values.
     *
     * @return the q3 key, or null if not set
     */
    public String getQ3Key()
    {
        return q3Key;
    }

    /**
     * Sets the property name for Q3 (third quartile, 75th percentile) values.
     *
     * @param q3Key the property name
     * @return this instance for method chaining
     */
    public @org.jspecify.annotations.NonNull J setQ3Key(String q3Key)
    {
        this.q3Key = q3Key;
        return (J) this;
    }

    /**
     * Gets the property name for maximum values.
     *
     * @return the max key, or null if not set
     */
    public String getMaxKey()
    {
        return maxKey;
    }

    /**
     * Sets the property name for maximum values.
     *
     * @param maxKey the property name
     * @return this instance for method chaining
     */
    public @org.jspecify.annotations.NonNull J setMaxKey(String maxKey)
    {
        this.maxKey = maxKey;
        return (J) this;
    }

    /**
     * Gets the property name for outlier values.
     *
     * @return the outlier keys, or null if not set
     */
    public String getOutlierKeys()
    {
        return outlierKeys;
    }

    /**
     * Sets the property name for outlier values.
     *
     * @param outlierKeys the property name
     * @return this instance for method chaining
     */
    public @org.jspecify.annotations.NonNull J setOutlierKeys(String outlierKeys)
    {
        this.outlierKeys = outlierKeys;
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
     * Gets the display name for minimum values.
     *
     * @return the min display name, or null for default
     */
    public String getMinName()
    {
        return minName;
    }

    /**
     * Sets the display name for minimum values.
     *
     * @param minName the display name
     * @return this instance for method chaining
     */
    public @org.jspecify.annotations.NonNull J setMinName(String minName)
    {
        this.minName = minName;
        return (J) this;
    }

    /**
     * Gets the display name for Q1 values.
     *
     * @return the q1 display name, or null for default
     */
    public String getQ1Name()
    {
        return q1Name;
    }

    /**
     * Sets the display name for Q1 values.
     *
     * @param q1Name the display name
     * @return this instance for method chaining
     */
    public @org.jspecify.annotations.NonNull J setQ1Name(String q1Name)
    {
        this.q1Name = q1Name;
        return (J) this;
    }

    /**
     * Gets the display name for median values.
     *
     * @return the median display name, or null for default
     */
    public String getMedianName()
    {
        return medianName;
    }

    /**
     * Sets the display name for median values.
     *
     * @param medianName the display name
     * @return this instance for method chaining
     */
    public @org.jspecify.annotations.NonNull J setMedianName(String medianName)
    {
        this.medianName = medianName;
        return (J) this;
    }

    /**
     * Gets the display name for Q3 values.
     *
     * @return the q3 display name, or null for default
     */
    public String getQ3Name()
    {
        return q3Name;
    }

    /**
     * Sets the display name for Q3 values.
     *
     * @param q3Name the display name
     * @return this instance for method chaining
     */
    public @org.jspecify.annotations.NonNull J setQ3Name(String q3Name)
    {
        this.q3Name = q3Name;
        return (J) this;
    }

    /**
     * Gets the display name for maximum values.
     *
     * @return the max display name, or null for default
     */
    public String getMaxName()
    {
        return maxName;
    }

    /**
     * Sets the display name for maximum values.
     *
     * @param maxName the display name
     * @return this instance for method chaining
     */
    public @org.jspecify.annotations.NonNull J setMaxName(String maxName)
    {
        this.maxName = maxName;
        return (J) this;
    }

    /**
     * Gets the display name for outliers.
     *
     * @return the outlier display name, or null for default
     */
    public String getOutlierName()
    {
        return outlierName;
    }

    /**
     * Sets the display name for outliers.
     *
     * @param outlierName the display name
     * @return this instance for method chaining
     */
    public @org.jspecify.annotations.NonNull J setOutlierName(String outlierName)
    {
        this.outlierName = outlierName;
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
     * @param data the array of data objects with box plot statistics
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
     * Gets the click detection range for box plot boxes.
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
     * Gets the fill color for the box region.
     *
     * @return the hex color code or CSS color name, or null for default
     */
    public String getFill()
    {
        return fill;
    }

    /**
     * Sets the fill color for the box region.
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
     * Gets the fill opacity for the box.
     *
     * @return the opacity (0..1), or null for default (1)
     */
    public Double getFillOpacity()
    {
        return fillOpacity;
    }

    /**
     * Sets the fill opacity for the box.
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
     * Gets the stroke color for box outline and whiskers.
     *
     * @return the hex color code or CSS color name, or null for default
     */
    public String getStroke()
    {
        return stroke;
    }

    /**
     * Sets the stroke color for box outline and whiskers.
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
     * Gets the stroke width for box outline.
     *
     * @return the stroke width in pixels, or null for default (1)
     */
    public Integer getStrokeWidth()
    {
        return strokeWidth;
    }

    /**
     * Sets the stroke width for box outline.
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
     * Gets the stroke opacity for box outline and whiskers.
     *
     * @return the opacity (0..1), or null for default (1)
     */
    public Double getStrokeOpacity()
    {
        return strokeOpacity;
    }

    /**
     * Sets the stroke opacity for box outline and whiskers.
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
     * Gets the line width for whiskers (min/max lines).
     *
     * @return the line width in pixels, or null for default
     */
    public Integer getLineWidth()
    {
        return lineWidth;
    }

    /**
     * Sets the line width for whiskers (min/max lines).
     *
     * @param lineWidth the width in pixels
     * @return this instance for method chaining
     */
    public @org.jspecify.annotations.NonNull J setLineWidth(Integer lineWidth)
    {
        this.lineWidth = lineWidth;
        return (J) this;
    }

    /**
     * Gets the line dash pattern for whiskers.
     *
     * @return the dash pattern, or null for solid line
     */
    public String getLineDash()
    {
        return lineDash;
    }

    /**
     * Sets the line dash pattern for whiskers.
     *
     * @param lineDash the dash pattern specification
     * @return this instance for method chaining
     */
    public @org.jspecify.annotations.NonNull J setLineDash(String lineDash)
    {
        this.lineDash = lineDash;
        return (J) this;
    }

    /**
     * Gets the size of outlier point markers.
     *
     * @return the size in pixels, or null for default
     */
    public Integer getOutlierSize()
    {
        return outlierSize;
    }

    /**
     * Sets the size of outlier point markers.
     *
     * @param outlierSize the size in pixels
     * @return this instance for method chaining
     */
    public @org.jspecify.annotations.NonNull J setOutlierSize(Integer outlierSize)
    {
        this.outlierSize = outlierSize;
        return (J) this;
    }

    /**
     * Gets the fill color for outlier points.
     *
     * @return the hex color code or CSS color name, or null for default
     */
    public String getOutlierFill()
    {
        return outlierFill;
    }

    /**
     * Sets the fill color for outlier points.
     *
     * @param outlierFill the hex color code or CSS color name
     * @return this instance for method chaining
     */
    public @org.jspecify.annotations.NonNull J setOutlierFill(String outlierFill)
    {
        this.outlierFill = outlierFill;
        return (J) this;
    }

    /**
     * Gets the stroke color for outlier points.
     *
     * @return the hex color code or CSS color name, or null for default
     */
    public String getOutlierStroke()
    {
        return outlierStroke;
    }

    /**
     * Sets the stroke color for outlier points.
     *
     * @param outlierStroke the hex color code or CSS color name
     * @return this instance for method chaining
     */
    public @org.jspecify.annotations.NonNull J setOutlierStroke(String outlierStroke)
    {
        this.outlierStroke = outlierStroke;
        return (J) this;
    }

    /**
     * Gets the corner radius for box plot boxes.
     *
     * @return the corner radius in pixels, or null for sharp corners
     */
    public Integer getCornerRadius()
    {
        return cornerRadius;
    }

    /**
     * Sets the corner radius for box plot boxes.
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
