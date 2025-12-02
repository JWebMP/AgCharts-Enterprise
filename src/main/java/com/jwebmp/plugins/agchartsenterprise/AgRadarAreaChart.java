package com.jwebmp.plugins.agchartsenterprise;

import com.jwebmp.plugins.agcharts.AgChart;
import com.jwebmp.plugins.agcharts.options.AgChartOptions;
import com.jwebmp.plugins.agchartsenterprise.options.series.AgRadarAreaSeriesOptions;
import io.smallrye.mutiny.Uni;

import java.util.List;

/**
 * Radar Area Chart builder for AG Charts Enterprise.
 *
 * <p>
 * Builds a radar/spider chart with filled area visualization connecting data points
 * around a central circle. Ideal for multivariate data comparisons with area-based emphasis
 * and visual overlap for multi-series displays.
 * </p>
 *
 * <p>
 * Example usage:
 * <pre>{@code
 * Uni<AgChartOptions<?>> chartOptions = new AgRadarAreaChart("chart-id")
 *     .setAngleKey("category")
 *     .setRadiusKey("value")
 *     .setData(dataPoints)
 *     .setFill("#1f77b4")
 *     .setFillOpacity(0.6)
 *     .getInitialOptions();
 * }</pre>
 * </p>
 *
 * @param <J> the CRTP parameter for fluent API chaining
 */
public class AgRadarAreaChart<J extends AgRadarAreaChart<J>> extends AgChart<J>
{
    // --- Required keys ---
    private String angleKey;
    private String radiusKey;

    // --- Display names ---
    private String angleName;
    private String radiusName;

    // --- Data & Display ---
    private List<?> data;
    private Boolean visible;
    private Boolean showInLegend;
    private Boolean showInMiniChart;

    // --- Fill styling ---
    private String fill;
    private Double fillOpacity;

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

    /**
     * Constructor with chart ID.
     *
     * @param id the unique chart identifier
     */
    public AgRadarAreaChart(String id)
    {
        super(id);
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
     * Sets the display name for the angle field.
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
     * Sets the display name for the radius field.
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
     * Sets the data array for the chart.
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
     * Sets the visibility state of the radar area series.
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
     * Sets whether the series appears in the legend.
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
     * Sets whether the series appears in the mini chart.
     *
     * @param showInMiniChart true to show in mini chart, false to hide
     * @return this instance for method chaining
     */
    public @org.jspecify.annotations.NonNull J setShowInMiniChart(Boolean showInMiniChart)
    {
        this.showInMiniChart = showInMiniChart;
        return (J) this;
    }

    /**
     * Sets the fill color for the radar area.
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
     * Sets the fill opacity for the radar area.
     *
     * @param fillOpacity the opacity (0..1)
     * @return this instance for method chaining
     */
    public @org.jspecify.annotations.NonNull J setFillOpacity(Double fillOpacity)
    {
        this.fillOpacity = fillOpacity;
        return (J) this;
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
     * Sets the stroke opacity for the area outline.
     *
     * @param strokeOpacity the opacity (0..1)
     * @return this instance for method chaining
     */
    public @org.jspecify.annotations.NonNull J setStrokeOpacity(Double strokeOpacity)
    {
        this.strokeOpacity = strokeOpacity;
        return (J) this;
    }

    /**
     * Sets the dash pattern for the area outline.
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

    /**
     * Sets the fill color for radar area markers/points.
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
     * Sets the stroke color for radar area marker outlines.
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
     * Sets the size of radar area markers/points.
     *
     * @param markerSize the size in pixels
     * @return this instance for method chaining
     */
    public @org.jspecify.annotations.NonNull J setMarkerSize(Integer markerSize)
    {
        this.markerSize = markerSize;
        return (J) this;
    }

    @Override
    public Uni<AgChartOptions<?>> getInitialOptions()
    {
        return Uni.createFrom().item(() -> {
            // Build radar area series with configured properties
            AgRadarAreaSeriesOptions<?> series = new AgRadarAreaSeriesOptions<>()
                    .setAngleKey(angleKey)
                    .setRadiusKey(radiusKey);

            // Set optional display names
            if (angleName != null) series.setAngleName(angleName);
            if (radiusName != null) series.setRadiusName(radiusName);

            // Set data and display options
            if (data != null) series.setData(data);
            if (visible != null) series.setVisible(visible);
            if (showInLegend != null) series.setShowInLegend(showInLegend);
            if (showInMiniChart != null) series.setShowInMiniChart(showInMiniChart);

            // Set fill styling options
            if (fill != null) series.setFill(fill);
            if (fillOpacity != null) series.setFillOpacity(fillOpacity);

            // Set line styling options
            if (stroke != null) series.setStroke(stroke);
            if (strokeWidth != null) series.setStrokeWidth(strokeWidth);
            if (strokeOpacity != null) series.setStrokeOpacity(strokeOpacity);
            if (lineDash != null) series.setLineDash(lineDash);
            if (lineDashOffset != null) series.setLineDashOffset(lineDashOffset);

            // Set marker styling options
            if (markerFill != null) series.setMarkerFill(markerFill);
            if (markerStroke != null) series.setMarkerStroke(markerStroke);
            if (markerSize != null) series.setMarkerSize(markerSize);

            return new AgChartOptions<>()
                    .setSeries(List.of(series));
        });
    }
}
