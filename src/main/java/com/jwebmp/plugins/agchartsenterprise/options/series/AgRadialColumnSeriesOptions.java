package com.jwebmp.plugins.agchartsenterprise.options.series;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.jwebmp.plugins.agcharts.options.series.AgBarSeriesLabelOptions;
import com.jwebmp.plugins.agcharts.options.series.AgSeriesBaseOptions;
import com.jwebmp.plugins.agcharts.options.series.AgSeriesListeners;

import java.util.List;

/**
 * Radial Column (aka Circular Column) series options for AG Charts Enterprise.
 * <p>
 * Mirrors API described in docs for 'radial-column' with angle and radius keys, stacking/grouping,
 * width controls, and standard styling/tooltip/highlight hooks.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AgRadialColumnSeriesOptions<J extends AgRadialColumnSeriesOptions<J>> extends AgSeriesBaseOptions<J>
{
    // --- Required keys ---
    private String angleKey;   // DatumKey (category for polar angle)
    private String radiusKey;  // DatumKey (numeric for radius)

    // --- Names for display ---contin 
    private String angleName;
    private String radiusName;
    private String legendItemName;

    // --- Identity/Data/Visibility ---
    @JsonProperty("id")
    private String id;                 // seriesId exposed to callbacks
    private List<?> data;              // TDatum[]
    private Boolean visible;

    // --- Interaction/Legend/Listeners ---
    private String cursor;             // CSS cursor
    private Object context;            // user context passed to callbacks
    private Object nodeClickRange;     // 'nearest' | 'exact' | number
    private Boolean showInLegend;
    private AgSeriesListeners<?> listeners;

    // --- Grouping/Stacking/Normalisation ---
    private Boolean grouped;           // adjacent grouping
    private Boolean stacked;           // stacked columns
    private String stackGroup;         // grouping id for stacks
    private Number normalizedTo;       // normalise stacks to value

    // --- Geometry/Width ---
    private Double columnWidthRatio;   // ratio
    private Double maxColumnWidthRatio;// ratio relative to diameter

    // --- Styling ---
    private Integer cornerRadius;      // rounded corners
    private Double fillOpacity;
    private String stroke;
    private Integer strokeWidth;
    private Double strokeOpacity;
    private List<Integer> lineDash;
    private Integer lineDashOffset;

    // --- Labels ---
    private AgBarSeriesLabelOptions<?> label; // reuse bar label options for value labels

    public AgRadialColumnSeriesOptions()
    {
        setType("radial-column");
    }

    // --- Getters/Setters ---
    
    /**
     * Gets the angle key for mapping data to polar angles.
     * <p>
     * The angle key determines which data field contains the categorical values
     * that will be mapped to angular positions on the polar chart.
     *
     * @return the angle key field name, or null if not set
     */
    public String getAngleKey() {return angleKey;}

    /**
     * Sets the angle key for mapping data to polar angles.
     * <p>
     * Specifies which field in the data array contains the categorical values
     * that will determine the angular position of each column in the polar chart.
     * This is typically a category or label field.
     *
     * @param angleKey the field name in the data that contains angle categories
     * @return this instance for method chaining
     */
    public J setAngleKey(String angleKey)
    {
        this.angleKey = angleKey;
        return (J) this;
    }

    /**
     * Gets the radius key for mapping data to radial values.
     * <p>
     * The radius key determines which data field contains the numeric values
     * that will be mapped to the radial distance from the center.
     *
     * @return the radius key field name, or null if not set
     */
    public String getRadiusKey() {return radiusKey;}

    /**
     * Sets the radius key for mapping data to radial values.
     * <p>
     * Specifies which field in the data array contains the numeric values
     * that will determine the height (radial distance) of each column from
     * the center of the polar chart.
     *
     * @param radiusKey the field name in the data that contains numeric values
     * @return this instance for method chaining
     */
    public J setRadiusKey(String radiusKey)
    {
        this.radiusKey = radiusKey;
        return (J) this;
    }

    /**
     * Gets the display name for the angle axis.
     * <p>
     * The angle name is used in tooltips, legends, and labels to provide
     * a human-readable description of what the angle axis represents.
     *
     * @return the angle axis display name, or null if not set
     */
    public String getAngleName() {return angleName;}

    /**
     * Sets the display name for the angle axis.
     * <p>
     * Provides a human-readable name for the angle axis that will be used
     * in tooltips, legends, and other chart elements to describe what the
     * angle dimension represents.
     *
     * @param angleName the human-readable name for the angle axis
     * @return this instance for method chaining
     */
    public J setAngleName(String angleName)
    {
        this.angleName = angleName;
        return (J) this;
    }

    /**
     * Gets the display name for the radius axis.
     * <p>
     * The radius name is used in tooltips, legends, and labels to provide
     * a human-readable description of what the radius axis represents.
     *
     * @return the radius axis display name, or null if not set
     */
    public String getRadiusName() {return radiusName;}

    /**
     * Sets the display name for the radius axis.
     * <p>
     * Provides a human-readable name for the radius axis that will be used
     * in tooltips, legends, and other chart elements to describe what the
     * radius dimension represents.
     *
     * @param radiusName the human-readable name for the radius axis
     * @return this instance for method chaining
     */
    public J setRadiusName(String radiusName)
    {
        this.radiusName = radiusName;
        return (J) this;
    }

    /**
     * Gets the name to display for this series in the legend.
     * <p>
     * The legend item name overrides the default series name that would
     * appear in the chart legend.
     *
     * @return the legend item name, or null if using default series name
     */
    public String getLegendItemName() {return legendItemName;}

    /**
     * Sets the name to display for this series in the legend.
     * <p>
     * Allows customization of how this series appears in the chart legend,
     * overriding the default series identifier.
     *
     * @param legendItemName the custom name to show in the legend
     * @return this instance for method chaining
     */
    public J setLegendItemName(String legendItemName)
    {
        this.legendItemName = legendItemName;
        return (J) this;
    }

    /**
     * Gets the unique identifier for this series.
     * <p>
     * The series ID is used to identify this series in callbacks, events, and
     * programmatic access. It's also exposed as the seriesId in callback functions,
     * allowing for targeted interaction handling.
     *
     * @return the series identifier, or null if not explicitly set
     */
    public String getId() {return id;}

    /**
     * Sets the unique identifier for this series.
     * <p>
     * Assigns a unique identifier that will be used in callbacks and events to
     * identify this specific series. This ID is also set as the base seriesId
     * for consistency across the charting framework.
     *
     * @param id the unique identifier for this series
     * @return this instance for method chaining
     */
    public J setId(String id)
    {
        this.id = id;
        setSeriesId(id);
        return (J) this;
    }

    /**
     * Gets the data array for this radial column series.
     * <p>
     * The data array contains the objects that will be visualized as radial columns.
     * Each data object should have properties matching the angleKey and radiusKey
     * for proper mapping to the polar coordinate system.
     *
     * @return the array of data objects to be visualized, or null if no data is set
     */
    public List<?> getData() {return data;}

    /**
     * Sets the data array for this radial column series.
     * <p>
     * Provides the data objects that will be rendered as radial columns. Each object
     * should contain properties that correspond to the angleKey (categorical values
     * for angular positioning) and radiusKey (numeric values for radial distance).
     *
     * @param data the array of data objects where each object contains angle and radius properties
     * @return this instance for method chaining
     */
    public J setData(List<?> data)
    {
        this.data = data;
        return (J) this;
    }

    /**
     * Gets the visibility state of this series.
     * <p>
     * When false, the series will be hidden from the chart but remain in the
     * configuration. Hidden series don't contribute to axis scaling or legend
     * display but can be shown again programmatically.
     *
     * @return true if the series is visible, false if hidden, or null for default (visible)
     */
    public Boolean getVisible() {return visible;}

    /**
     * Sets the visibility state of this series.
     * <p>
     * Controls whether this series appears in the chart. Hidden series are excluded
     * from rendering, axis calculations, and legend display, but the configuration
     * remains intact for potential re-showing.
     *
     * @param visible true to show the series, false to hide it, null for default (visible)
     * @return this instance for method chaining
     */
    public J setVisible(Boolean visible)
    {
        this.visible = visible;
        return (J) this;
    }

    /**
     * Gets the cursor style when hovering over series elements.
     * <p>
     * Specifies the CSS cursor type that appears when the user hovers over
     * radial columns in this series. Common values include 'pointer' for
     * clickable elements or 'crosshair' for measurement interactions.
     *
     * @return the CSS cursor name, or null for default cursor behavior
     */
    public String getCursor() {return cursor;}

    /**
     * Sets the cursor style when hovering over series elements.
     * <p>
     * Defines the CSS cursor that appears when hovering over radial columns.
     * Use 'pointer' for clickable columns, 'crosshair' for precision targeting,
     * or any valid CSS cursor value.
     *
     * @param cursor the CSS cursor name (e.g., 'pointer', 'crosshair', 'grab')
     * @return this instance for method chaining
     */
    public J setCursor(String cursor)
    {
        this.cursor = cursor;
        return (J) this;
    }

    /**
     * Gets the additional context object for this series.
     * <p>
     * The context object provides custom data that is passed to all callback
     * functions (formatters, listeners, tooltips) for this series, enabling
     * state sharing and custom logic implementation.
     *
     * @return the context object, or null if no context is set
     */
    public Object getContext() {return context;}

    /**
     * Sets the additional context object for this series.
     * <p>
     * Provides custom data that will be available in all callback functions
     * associated with this series. Useful for passing application state,
     * configuration objects, or any data needed in formatters and event handlers.
     *
     * @param context the context object to be passed to callbacks
     * @return this instance for method chaining
     */
    public J setContext(Object context)
    {
        this.context = context;
        return (J) this;
    }

    /**
     * Gets the click detection range for series nodes.
     * <p>
     * Defines the area around each radial column where clicks are detected.
     * Can be specified as a CSS distance value (e.g., "5px") or as a pixel
     * integer for consistent hit-testing behavior.
     *
     * @return the click range as String or Integer, or null for default detection
     */
    public Object getNodeClickRange() {return nodeClickRange;}

    /**
     * Sets the click detection range using a CSS distance value.
     * <p>
     * Specifies the clickable area around each radial column using CSS distance
     * units. Larger values make columns easier to click but may cause overlap
     * in dense polar charts.
     *
     * @param range the click detection range as CSS distance (e.g., "5px", "10%")
     * @return this instance for method chaining
     */
    public J setNodeClickRange(String range)
    {
        this.nodeClickRange = range;
        return (J) this;
    }

    /**
     * Sets the click detection range using pixel values.
     * <p>
     * Defines the clickable area around each radial column in absolute pixels.
     * Provides consistent hit-testing regardless of chart size or zoom level.
     *
     * @param pixels the click detection range in pixels
     * @return this instance for method chaining
     */
    public J setNodeClickRange(Integer pixels)
    {
        this.nodeClickRange = pixels;
        return (J) this;
    }

    /**
     * Gets whether this series appears in the chart legend.
     * <p>
     * When true, the series will have an entry in the legend with its name
     * and visual indicator. Legend entries allow users to toggle series
     * visibility and identify data sources.
     *
     * @return true if series shows in legend, false if hidden, or null for default (true)
     */
    public Boolean getShowInLegend() {return showInLegend;}

    public J setShowInLegend(Boolean showInLegend)
    {
        this.showInLegend = showInLegend;
        return (J) this;
    }

    public AgSeriesListeners<?> getListeners() {return listeners;}

    public J setListeners(AgSeriesListeners<?> listeners)
    {
        this.listeners = listeners;
        return (J) this;
    }

    public Boolean getGrouped() {return grouped;}

    public J setGrouped(Boolean grouped)
    {
        this.grouped = grouped;
        return (J) this;
    }

    public Boolean getStacked() {return stacked;}

    public J setStacked(Boolean stacked)
    {
        this.stacked = stacked;
        return (J) this;
    }

    public String getStackGroup() {return stackGroup;}

    public J setStackGroup(String stackGroup)
    {
        this.stackGroup = stackGroup;
        return (J) this;
    }

    public Number getNormalizedTo() {return normalizedTo;}

    public J setNormalizedTo(Number normalizedTo)
    {
        this.normalizedTo = normalizedTo;
        return (J) this;
    }

    public Double getColumnWidthRatio() {return columnWidthRatio;}

    public J setColumnWidthRatio(Double columnWidthRatio)
    {
        this.columnWidthRatio = columnWidthRatio;
        return (J) this;
    }

    public Double getMaxColumnWidthRatio() {return maxColumnWidthRatio;}

    public J setMaxColumnWidthRatio(Double maxColumnWidthRatio)
    {
        this.maxColumnWidthRatio = maxColumnWidthRatio;
        return (J) this;
    }

    public Integer getCornerRadius() {return cornerRadius;}

    public J setCornerRadius(Integer cornerRadius)
    {
        this.cornerRadius = cornerRadius;
        return (J) this;
    }

    public Double getFillOpacity() {return fillOpacity;}

    public J setFillOpacity(Double fillOpacity)
    {
        this.fillOpacity = fillOpacity;
        return (J) this;
    }

    public String getStroke() {return stroke;}

    public J setStroke(String stroke)
    {
        this.stroke = stroke;
        return (J) this;
    }

    public Integer getStrokeWidth() {return strokeWidth;}

    public J setStrokeWidth(Integer strokeWidth)
    {
        this.strokeWidth = strokeWidth;
        return (J) this;
    }

    public Double getStrokeOpacity() {return strokeOpacity;}

    public J setStrokeOpacity(Double strokeOpacity)
    {
        this.strokeOpacity = strokeOpacity;
        return (J) this;
    }

    public List<Integer> getLineDash() {return lineDash;}

    public J setLineDash(List<Integer> lineDash)
    {
        this.lineDash = lineDash;
        return (J) this;
    }

    public Integer getLineDashOffset() {return lineDashOffset;}

    public J setLineDashOffset(Integer lineDashOffset)
    {
        this.lineDashOffset = lineDashOffset;
        return (J) this;
    }

    public AgBarSeriesLabelOptions<?> getLabel() {return label;}

    public J setLabel(AgBarSeriesLabelOptions<?> label)
    {
        this.label = label;
        return (J) this;
    }
}