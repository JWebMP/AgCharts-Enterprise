package com.jwebmp.plugins.agchartsenterprise.options.series;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRawValue;
import com.jwebmp.plugins.agcharts.options.series.AgSeriesBaseOptions;
import com.jwebmp.plugins.agcharts.options.series.AgSeriesLabelOptions;
import com.jwebmp.plugins.agcharts.options.series.AgSeriesListeners;

import java.util.List;

/**
 * Sunburst Series options for AG Charts Enterprise.
 *
 * <p>
 * The Sunburst series visualizes hierarchical data as concentric circles,
 * where inner rings represent parent categories and outer rings represent
 * child categories. The angle and radius encode multiple dimensions.
 * </p>
 *
 * <p>
 * Key properties:
 * <ul>
 *   <li><strong>labelKey</strong> - Property defining the segment label</li>
 *   <li><strong>valueKey</strong> - Property defining the segment size</li>
 *   <li><strong>colorKey</strong> - Property for color mapping</li>
 * </ul>
 * </p>
 *
 * @param <J> the CRTP parameter for fluent API chaining
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AgSunburstSeriesOptions<J extends AgSunburstSeriesOptions<J>> extends AgSeriesBaseOptions<J>
{
    // --- Required keys ---
    private String labelKey;
    private String valueKey;
    private String colorKey;

    // --- Display names ---
    private String labelName;
    private String valueName;
    private String colorName;

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

    // --- Segment styling ---
    private String fill;
    private Double fillOpacity;
    private String stroke;
    private Integer strokeWidth;
    private Double strokeOpacity;
    private Integer cornerRadius;

    // --- Color scale ---
    @JsonRawValue
    private String colorScale;
    private Double colorDomain;

    public AgSunburstSeriesOptions()
    {
        setType("sunburst");
    }

    /**
     * Gets the property name for segment labels.
     *
     * @return the label key, or null if not set
     */
    public String getLabelKey()
    {
        return labelKey;
    }

    /**
     * Sets the property name for segment labels.
     *
     * @param labelKey the property name
     * @return this instance for method chaining
     */
    public @org.jspecify.annotations.NonNull J setLabelKey(String labelKey)
    {
        this.labelKey = labelKey;
        return (J) this;
    }

    /**
     * Gets the property name for segment values/sizes.
     *
     * @return the value key, or null if not set
     */
    public String getValueKey()
    {
        return valueKey;
    }

    /**
     * Sets the property name for segment values/sizes.
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
     * Gets the property name for segment color mapping.
     *
     * @return the color key, or null if not set
     */
    public String getColorKey()
    {
        return colorKey;
    }

    /**
     * Sets the property name for segment color mapping.
     *
     * @param colorKey the property name
     * @return this instance for method chaining
     */
    public @org.jspecify.annotations.NonNull J setColorKey(String colorKey)
    {
        this.colorKey = colorKey;
        return (J) this;
    }

    /**
     * Gets the display name for the label field.
     *
     * @return the label display name, or null for default
     */
    public String getLabelName()
    {
        return labelName;
    }

    /**
     * Sets the display name for the label field.
     *
     * @param labelName the display name
     * @return this instance for method chaining
     */
    public @org.jspecify.annotations.NonNull J setLabelName(String labelName)
    {
        this.labelName = labelName;
        return (J) this;
    }

    /**
     * Gets the display name for the value field.
     *
     * @return the value display name, or null for default
     */
    public String getValueName()
    {
        return valueName;
    }

    /**
     * Sets the display name for the value field.
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
     * Gets the display name for the color field.
     *
     * @return the color display name, or null for default
     */
    public String getColorName()
    {
        return colorName;
    }

    /**
     * Sets the display name for the color field.
     *
     * @param colorName the display name
     * @return this instance for method chaining
     */
    public @org.jspecify.annotations.NonNull J setColorName(String colorName)
    {
        this.colorName = colorName;
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
     * @param data the array of sunburst data objects
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
     * Gets the click detection range for sunburst segments.
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
     * Gets the fill color for sunburst segments.
     *
     * @return the hex color code or CSS color name, or null for default
     */
    public String getFill()
    {
        return fill;
    }

    /**
     * Sets the fill color for sunburst segments.
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
     * Gets the fill opacity for sunburst segments.
     *
     * @return the opacity (0..1), or null for default (1)
     */
    public Double getFillOpacity()
    {
        return fillOpacity;
    }

    /**
     * Sets the fill opacity for sunburst segments.
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
     * Gets the stroke color for sunburst segment outlines.
     *
     * @return the hex color code or CSS color name, or null for default
     */
    public String getStroke()
    {
        return stroke;
    }

    /**
     * Sets the stroke color for sunburst segment outlines.
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
     * Gets the stroke width for sunburst segment outlines.
     *
     * @return the stroke width in pixels, or null for default (1)
     */
    public Integer getStrokeWidth()
    {
        return strokeWidth;
    }

    /**
     * Sets the stroke width for sunburst segment outlines.
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
     * Gets the stroke opacity for sunburst segment outlines.
     *
     * @return the opacity (0..1), or null for default (1)
     */
    public Double getStrokeOpacity()
    {
        return strokeOpacity;
    }

    /**
     * Sets the stroke opacity for sunburst segment outlines.
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
     * Gets the corner radius for sunburst segments.
     *
     * @return the corner radius in pixels, or null for no rounding
     */
    public Integer getCornerRadius()
    {
        return cornerRadius;
    }

    /**
     * Sets the corner radius for sunburst segments.
     *
     * @param cornerRadius the radius in pixels
     * @return this instance for method chaining
     */
    public @org.jspecify.annotations.NonNull J setCornerRadius(Integer cornerRadius)
    {
        this.cornerRadius = cornerRadius;
        return (J) this;
    }

    /**
     * Gets the color scale function as raw JSON.
     *
     * @return the color scale function, or null for default
     */
    public String getColorScale()
    {
        return colorScale;
    }

    /**
     * Sets the color scale function as raw JSON.
     *
     * @param colorScale the color scale function
     * @return this instance for method chaining
     */
    public @org.jspecify.annotations.NonNull J setColorScale(String colorScale)
    {
        this.colorScale = colorScale;
        return (J) this;
    }

    /**
     * Gets the color domain for scaling.
     *
     * @return the domain value, or null for auto-scaling
     */
    public Double getColorDomain()
    {
        return colorDomain;
    }

    /**
     * Sets the color domain for scaling.
     *
     * @param colorDomain the domain value
     * @return this instance for method chaining
     */
    public @org.jspecify.annotations.NonNull J setColorDomain(Double colorDomain)
    {
        this.colorDomain = colorDomain;
        return (J) this;
    }
}
