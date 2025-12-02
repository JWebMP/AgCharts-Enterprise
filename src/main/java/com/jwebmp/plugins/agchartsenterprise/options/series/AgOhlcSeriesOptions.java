package com.jwebmp.plugins.agchartsenterprise.options.series;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRawValue;
import com.jwebmp.plugins.agcharts.options.series.AgSeriesBaseOptions;
import com.jwebmp.plugins.agcharts.options.series.AgSeriesLabelOptions;
import com.jwebmp.plugins.agcharts.options.series.AgSeriesListeners;

import java.util.List;

/**
 * OHLC (Open-High-Low-Close) Series options for AG Charts Enterprise.
 *
 * <p>
 * The OHLC series visualizes financial data similar to Candlestick,
 * but uses a line-based representation instead of bodies and wicks.
 * It shows open, high, low, and close prices for each time period
 * using tick marks and connecting lines.
 * </p>
 *
 * <p>
 * Key properties:
 * <ul>
 *   <li><strong>dateKey</strong> - Property name for date/time values</li>
 *   <li><strong>openKey</strong> - Property name for opening price</li>
 *   <li><strong>closeKey</strong> - Property name for closing price</li>
 *   <li><strong>highKey</strong> - Property name for high price</li>
 *   <li><strong>lowKey</strong> - Property name for low price</li>
 *   <li><strong>upColor</strong> - Color when close >= open (bullish)</li>
 *   <li><strong>downColor</strong> - Color when close < open (bearish)</li>
 * </ul>
 * </p>
 *
 * @param <J> the CRTP parameter for fluent API chaining
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AgOhlcSeriesOptions<J extends AgOhlcSeriesOptions<J>> extends AgSeriesBaseOptions<J>
{
    // --- Required keys ---
    private String dateKey;   // Date/time property name
    private String openKey;   // Open price property name
    private String closeKey;  // Close price property name
    private String highKey;   // High price property name
    private String lowKey;    // Low price property name

    // --- Display names ---
    private String dateName;
    private String openName;
    private String closeName;
    private String highName;
    private String lowName;

    // --- Colors ---
    private String upColor;    // Bullish bar color (close >= open)
    private String downColor;  // Bearish bar color (close < open)

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

    // --- Labels & Styling ---
    private AgSeriesLabelOptions<?> label;
    @JsonRawValue
    private String itemStyler;

    // --- Geometry & Stroke ---
    private Integer strokeWidth;
    private Double strokeOpacity;
    private Double fillOpacity;

    public AgOhlcSeriesOptions()
    {
        setType("ohlc");
    }

    /**
     * Gets the property name used for date/time values in the data.
     *
     * @return the date key property name, or null if not set
     */
    public String getDateKey()
    {
        return dateKey;
    }

    /**
     * Sets the property name used for date/time values in the data.
     *
     * @param dateKey the property name for date/time values
     * @return this instance for method chaining
     */
    public @org.jspecify.annotations.NonNull J setDateKey(String dateKey)
    {
        this.dateKey = dateKey;
        return (J) this;
    }

    /**
     * Gets the property name used for opening prices in the data.
     *
     * @return the open key property name, or null if not set
     */
    public String getOpenKey()
    {
        return openKey;
    }

    /**
     * Sets the property name used for opening prices in the data.
     *
     * @param openKey the property name for opening price values
     * @return this instance for method chaining
     */
    public @org.jspecify.annotations.NonNull J setOpenKey(String openKey)
    {
        this.openKey = openKey;
        return (J) this;
    }

    /**
     * Gets the property name used for closing prices in the data.
     *
     * @return the close key property name, or null if not set
     */
    public String getCloseKey()
    {
        return closeKey;
    }

    /**
     * Sets the property name used for closing prices in the data.
     *
     * @param closeKey the property name for closing price values
     * @return this instance for method chaining
     */
    public @org.jspecify.annotations.NonNull J setCloseKey(String closeKey)
    {
        this.closeKey = closeKey;
        return (J) this;
    }

    /**
     * Gets the property name used for high prices in the data.
     *
     * @return the high key property name, or null if not set
     */
    public String getHighKey()
    {
        return highKey;
    }

    /**
     * Sets the property name used for high prices in the data.
     *
     * @param highKey the property name for high price values
     * @return this instance for method chaining
     */
    public @org.jspecify.annotations.NonNull J setHighKey(String highKey)
    {
        this.highKey = highKey;
        return (J) this;
    }

    /**
     * Gets the property name used for low prices in the data.
     *
     * @return the low key property name, or null if not set
     */
    public String getLowKey()
    {
        return lowKey;
    }

    /**
     * Sets the property name used for low prices in the data.
     *
     * @param lowKey the property name for low price values
     * @return this instance for method chaining
     */
    public @org.jspecify.annotations.NonNull J setLowKey(String lowKey)
    {
        this.lowKey = lowKey;
        return (J) this;
    }

    /**
     * Gets the display name for the date/time field.
     *
     * @return the date display name, or null for default
     */
    public String getDateName()
    {
        return dateName;
    }

    /**
     * Sets the display name for the date/time field.
     *
     * @param dateName the name to display in tooltips
     * @return this instance for method chaining
     */
    public @org.jspecify.annotations.NonNull J setDateName(String dateName)
    {
        this.dateName = dateName;
        return (J) this;
    }

    /**
     * Gets the display name for the open price field.
     *
     * @return the open name, or null for default
     */
    public String getOpenName()
    {
        return openName;
    }

    /**
     * Sets the display name for the open price field.
     *
     * @param openName the name to display in tooltips
     * @return this instance for method chaining
     */
    public @org.jspecify.annotations.NonNull J setOpenName(String openName)
    {
        this.openName = openName;
        return (J) this;
    }

    /**
     * Gets the display name for the close price field.
     *
     * @return the close name, or null for default
     */
    public String getCloseName()
    {
        return closeName;
    }

    /**
     * Sets the display name for the close price field.
     *
     * @param closeName the name to display in tooltips
     * @return this instance for method chaining
     */
    public @org.jspecify.annotations.NonNull J setCloseName(String closeName)
    {
        this.closeName = closeName;
        return (J) this;
    }

    /**
     * Gets the display name for the high price field.
     *
     * @return the high name, or null for default
     */
    public String getHighName()
    {
        return highName;
    }

    /**
     * Sets the display name for the high price field.
     *
     * @param highName the name to display in tooltips
     * @return this instance for method chaining
     */
    public @org.jspecify.annotations.NonNull J setHighName(String highName)
    {
        this.highName = highName;
        return (J) this;
    }

    /**
     * Gets the display name for the low price field.
     *
     * @return the low name, or null for default
     */
    public String getLowName()
    {
        return lowName;
    }

    /**
     * Sets the display name for the low price field.
     *
     * @param lowName the name to display in tooltips
     * @return this instance for method chaining
     */
    public @org.jspecify.annotations.NonNull J setLowName(String lowName)
    {
        this.lowName = lowName;
        return (J) this;
    }

    /**
     * Gets the color for bullish bars (close >= open).
     *
     * @return the hex color code or CSS color name, or null for default
     */
    public String getUpColor()
    {
        return upColor;
    }

    /**
     * Sets the color for bullish bars (close >= open).
     *
     * @param upColor the hex color code (e.g., "#00AA00") or CSS color name
     * @return this instance for method chaining
     */
    public @org.jspecify.annotations.NonNull J setUpColor(String upColor)
    {
        this.upColor = upColor;
        return (J) this;
    }

    /**
     * Gets the color for bearish bars (close < open).
     *
     * @return the hex color code or CSS color name, or null for default
     */
    public String getDownColor()
    {
        return downColor;
    }

    /**
     * Sets the color for bearish bars (close < open).
     *
     * @param downColor the hex color code (e.g., "#CC0000") or CSS color name
     * @return this instance for method chaining
     */
    public @org.jspecify.annotations.NonNull J setDownColor(String downColor)
    {
        this.downColor = downColor;
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
     * @param data the array of data objects with OHLC properties
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
     * Gets the click detection range for OHLC bars.
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
     * Gets whether this series appears in the legend.
     *
     * @return true to show in legend, false to hide, or null for default
     */
    public Boolean getShowInLegend()
    {
        return showInMiniChart;
    }

    /**
     * Sets whether this series appears in the legend.
     *
     * @param showInLegend true to show in legend, false to hide
     * @return this instance for method chaining
     */
    public @org.jspecify.annotations.NonNull J setShowInLegend(Boolean showInLegend)
    {
        // Set through parent class if needed; for now store via our field
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
     * Gets the stroke width for OHLC bars and lines.
     *
     * @return the stroke width in pixels, or null for default (1)
     */
    public Integer getStrokeWidth()
    {
        return strokeWidth;
    }

    /**
     * Sets the stroke width for OHLC bars and lines.
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
     * Gets the stroke opacity for OHLC bars and lines.
     *
     * @return the opacity (0..1), or null for default (1)
     */
    public Double getStrokeOpacity()
    {
        return strokeOpacity;
    }

    /**
     * Sets the stroke opacity for OHLC bars and lines.
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
     * Gets the fill opacity for OHLC bars.
     *
     * @return the opacity (0..1), or null for default
     */
    public Double getFillOpacity()
    {
        return fillOpacity;
    }

    /**
     * Sets the fill opacity for OHLC bars.
     *
     * @param fillOpacity the opacity value (0..1)
     * @return this instance for method chaining
     */
    public @org.jspecify.annotations.NonNull J setFillOpacity(Double fillOpacity)
    {
        this.fillOpacity = fillOpacity;
        return (J) this;
    }
}
