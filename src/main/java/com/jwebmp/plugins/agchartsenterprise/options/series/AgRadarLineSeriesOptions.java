package com.jwebmp.plugins.agchartsenterprise.options.series;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRawValue;
import com.jwebmp.plugins.agcharts.options.series.AgSeriesBaseOptions;
import com.jwebmp.plugins.agcharts.options.series.AgSeriesLabelOptions;
import com.jwebmp.plugins.agcharts.options.series.AgSeriesListeners;

import java.util.List;

/**
 * Radar Line Series options for AG Charts Enterprise.
 *
 * <p>
 * The Radar Line series visualizes multivariate data on a polar/radar plot,
 * displaying values at multiple angles around a center point. Useful for
 * comparing multiple attributes across dimensions or tracking performance
 * metrics across different categories.
 * </p>
 *
 * <p>
 * Key properties:
 * <ul>
 *   <li><strong>angleKey</strong> - Property defining the angle/axis label</li>
 *   <li><strong>radiusKey</strong> - Property defining the distance from center</li>
 *   <li><strong>strokeWidth</strong> - Line thickness for radar plot</li>
 * </ul>
 * </p>
 *
 * @param <J> the CRTP parameter for fluent API chaining
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AgRadarLineSeriesOptions<J extends AgRadarLineSeriesOptions<J>> extends AgSeriesBaseOptions<J>
{
    // --- Required keys ---
    private String angleKey;   // Angle/axis label property
    private String radiusKey;  // Radius/distance property

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

    // --- Line styling ---
    private String stroke;
    private Integer strokeWidth;
    private Double strokeOpacity;
    private List<Integer> lineDash;
    private Integer lineDashOffset;

    // --- Marker styling ---
    private String markerFill;
    private String markerStroke;
    private Integer markerSize;

    public AgRadarLineSeriesOptions()
    {
        setType("radar-line");
    }

    /**
     * Gets the property name for angle/axis labels.
     *
     * @return the angle key, or null if not set
     */
    public String getAngleKey()
    {
        return angleKey;
    }

    /**
     * Sets the property name for angle/axis labels.
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
     * Gets the property name for radius/distance values.
     *
     * @return the radius key, or null if not set
     */
    public String getRadiusKey()
    {
        return radiusKey;
    }

    /**
     * Sets the property name for radius/distance values.
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
     * Gets the display name for the angle/axis field.
     *
     * @return the angle display name, or null for default
     */
    public String getAngleName()
    {
        return angleName;
    }

    /**
     * Sets the display name for the angle/axis field.
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
     * Gets the display name for the radius/distance field.
     *
     * @return the radius display name, or null for default
     */
    public String getRadiusName()
    {
        return radiusName;
    }

    /**
     * Sets the display name for the radius/distance field.
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
     * @param data the array of radar data points
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
     * Gets the click detection range for radar points.
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
     * Gets the stroke color for the radar line.
     *
     * @return the hex color code or CSS color name, or null for default
     */
    public String getStroke()
    {
        return stroke;
    }

    /**
     * Sets the stroke color for the radar line.
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
     * Gets the stroke width for the radar line.
     *
     * @return the stroke width in pixels, or null for default (1)
     */
    public Integer getStrokeWidth()
    {
        return strokeWidth;
    }

    /**
     * Sets the stroke width for the radar line.
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
     * Gets the stroke opacity for the radar line.
     *
     * @return the opacity (0..1), or null for default (1)
     */
    public Double getStrokeOpacity()
    {
        return strokeOpacity;
    }

    /**
     * Sets the stroke opacity for the radar line.
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
     * Gets the dash pattern for the radar line.
     *
     * @return the line dash pattern, or null for solid line
     */
    public List<Integer> getLineDash()
    {
        return lineDash;
    }

    /**
     * Sets the dash pattern for the radar line.
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
     * Gets the dash offset for the radar line.
     *
     * @return the dash offset in pixels, or null for default (0)
     */
    public Integer getLineDashOffset()
    {
        return lineDashOffset;
    }

    /**
     * Sets the dash offset for the radar line.
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
     * Gets the fill color for radar line markers/points.
     *
     * @return the hex color code or CSS color name, or null for default
     */
    public String getMarkerFill()
    {
        return markerFill;
    }

    /**
     * Sets the fill color for radar line markers/points.
     *
     * @param markerFill the hex color code or CSS color name
     * @return this instance for method chaining
     */
    public @org.jspecify.annotations.NonNull J setMarkerFill(String markerFill)
    {
        this.markerFill = markerFill;
        return (J) this;
    }

    /**
     * Gets the stroke color for radar line marker outlines.
     *
     * @return the hex color code or CSS color name, or null for default
     */
    public String getMarkerStroke()
    {
        return markerStroke;
    }

    /**
     * Sets the stroke color for radar line marker outlines.
     *
     * @param markerStroke the hex color code or CSS color name
     * @return this instance for method chaining
     */
    public @org.jspecify.annotations.NonNull J setMarkerStroke(String markerStroke)
    {
        this.markerStroke = markerStroke;
        return (J) this;
    }

    /**
     * Gets the size of radar line markers/points.
     *
     * @return the marker size in pixels, or null for default
     */
    public Integer getMarkerSize()
    {
        return markerSize;
    }

    /**
     * Sets the size of radar line markers/points.
     *
     * @param markerSize the size in pixels
     * @return this instance for method chaining
     */
    public @org.jspecify.annotations.NonNull J setMarkerSize(Integer markerSize)
    {
        this.markerSize = markerSize;
        return (J) this;
    }
}
