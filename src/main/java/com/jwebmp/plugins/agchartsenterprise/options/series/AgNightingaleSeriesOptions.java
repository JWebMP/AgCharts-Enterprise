package com.jwebmp.plugins.agchartsenterprise.options.series;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRawValue;
import com.jwebmp.plugins.agcharts.options.series.AgSeriesBaseOptions;
import com.jwebmp.plugins.agcharts.options.series.AgSeriesLabelOptions;
import com.jwebmp.plugins.agcharts.options.series.AgSeriesListeners;

import java.util.List;

/**
 * Nightingale Series options for AG Charts Enterprise.
 *
 * <p>
 * The Nightingale (Polar Area) series visualizes categorical data using
 * sectors of a circle, where both the angle (sector width) and radius (sector area)
 * represent different dimensions of the data. Useful for comparing multiple
 * attributes across categories with emphasis on area-based representation.
 * </p>
 *
 * <p>
 * Key properties:
 * <ul>
 *   <li><strong>angleKey</strong> - Property defining the category/angle label</li>
 *   <li><strong>radiusKey</strong> - Property defining the sector radius/value</li>
 *   <li><strong>fill</strong> - Sector fill color with opacity support</li>
 * </ul>
 * </p>
 *
 * @param <J> the CRTP parameter for fluent API chaining
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AgNightingaleSeriesOptions<J extends AgNightingaleSeriesOptions<J>> extends AgSeriesBaseOptions<J>
{
    // --- Required keys ---
    private String angleKey;   // Category/angle label property
    private String radiusKey;  // Sector radius/value property

    // --- Display names ---
    private String angleName;
    private String radiusName;

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

    // --- Fill styling ---
    private String fill;
    private Double fillOpacity;

    // --- Outline/stroke styling ---
    private String stroke;
    private Integer strokeWidth;
    private Double strokeOpacity;
    private List<Integer> lineDash;
    private Integer lineDashOffset;

    // --- Sector/Corner styling ---
    private Integer cornerRadius;

    public AgNightingaleSeriesOptions()
    {
        setType("nightingale");
    }

    /**
     * Gets the property name for category/angle labels.
     *
     * @return the angle key, or null if not set
     */
    public String getAngleKey()
    {
        return angleKey;
    }

    /**
     * Sets the property name for category/angle labels.
     *
     * @param angleKey the property name
     * @return this instance for method chaining
     */
    public @org.jspecify.annotations.NonNull J setAngleKey(String angleKey)
    {
        this.angleKey = angleKey;
        return (J) this;
    }

    /**
     * Gets the property name for sector radius/value.
     *
     * @return the radius key, or null if not set
     */
    public String getRadiusKey()
    {
        return radiusKey;
    }

    /**
     * Sets the property name for sector radius/value.
     *
     * @param radiusKey the property name
     * @return this instance for method chaining
     */
    public @org.jspecify.annotations.NonNull J setRadiusKey(String radiusKey)
    {
        this.radiusKey = radiusKey;
        return (J) this;
    }

    /**
     * Gets the display name for the category/angle field.
     *
     * @return the angle display name, or null for default
     */
    public String getAngleName()
    {
        return angleName;
    }

    /**
     * Sets the display name for the category/angle field.
     *
     * @param angleName the display name
     * @return this instance for method chaining
     */
    public @org.jspecify.annotations.NonNull J setAngleName(String angleName)
    {
        this.angleName = angleName;
        return (J) this;
    }

    /**
     * Gets the display name for the radius/value field.
     *
     * @return the radius display name, or null for default
     */
    public String getRadiusName()
    {
        return radiusName;
    }

    /**
     * Sets the display name for the radius/value field.
     *
     * @param radiusName the display name
     * @return this instance for method chaining
     */
    public @org.jspecify.annotations.NonNull J setRadiusName(String radiusName)
    {
        this.radiusName = radiusName;
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
     * @param data the array of nightingale data points
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
     * Gets the click detection range for nightingale sectors.
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
     * Gets the fill color for the nightingale sectors.
     *
     * @return the hex color code or CSS color name, or null for default
     */
    public String getFill()
    {
        return fill;
    }

    /**
     * Sets the fill color for the nightingale sectors.
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
     * Gets the fill opacity for the nightingale sectors.
     *
     * @return the opacity (0..1), or null for default (1)
     */
    public Double getFillOpacity()
    {
        return fillOpacity;
    }

    /**
     * Sets the fill opacity for the nightingale sectors.
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
     * Gets the stroke color for the sector outlines.
     *
     * @return the hex color code or CSS color name, or null for default
     */
    public String getStroke()
    {
        return stroke;
    }

    /**
     * Sets the stroke color for the sector outlines.
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
     * Gets the stroke width for the sector outlines.
     *
     * @return the stroke width in pixels, or null for default (1)
     */
    public Integer getStrokeWidth()
    {
        return strokeWidth;
    }

    /**
     * Sets the stroke width for the sector outlines.
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
     * Gets the stroke opacity for the sector outlines.
     *
     * @return the opacity (0..1), or null for default (1)
     */
    public Double getStrokeOpacity()
    {
        return strokeOpacity;
    }

    /**
     * Sets the stroke opacity for the sector outlines.
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
     * Gets the dash pattern for the sector outlines.
     *
     * @return the line dash pattern, or null for solid line
     */
    public List<Integer> getLineDash()
    {
        return lineDash;
    }

    /**
     * Sets the dash pattern for the sector outlines.
     *
     * @param lineDash the dash pattern (e.g., [5, 5])
     * @return this instance for method chaining
     */
    public @org.jspecify.annotations.NonNull J setLineDash(List<Integer> lineDash)
    {
        this.lineDash = lineDash;
        return (J) this;
    }

    /**
     * Gets the dash offset for the sector outlines.
     *
     * @return the dash offset in pixels, or null for default (0)
     */
    public Integer getLineDashOffset()
    {
        return lineDashOffset;
    }

    /**
     * Sets the dash offset for the sector outlines.
     *
     * @param lineDashOffset the offset in pixels
     * @return this instance for method chaining
     */
    public @org.jspecify.annotations.NonNull J setLineDashOffset(Integer lineDashOffset)
    {
        this.lineDashOffset = lineDashOffset;
        return (J) this;
    }

    /**
     * Gets the corner radius for nightingale sector corners.
     *
     * @return the corner radius in pixels, or null for no rounding
     */
    public Integer getCornerRadius()
    {
        return cornerRadius;
    }

    /**
     * Sets the corner radius for nightingale sector corners.
     *
     * @param cornerRadius the radius in pixels
     * @return this instance for method chaining
     */
    public @org.jspecify.annotations.NonNull J setCornerRadius(Integer cornerRadius)
    {
        this.cornerRadius = cornerRadius;
        return (J) this;
    }
}
