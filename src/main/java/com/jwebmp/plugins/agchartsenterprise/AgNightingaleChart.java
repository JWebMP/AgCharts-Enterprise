package com.jwebmp.plugins.agchartsenterprise;

import com.jwebmp.plugins.agcharts.AgChart;
import com.jwebmp.plugins.agcharts.options.AgChartOptions;
import com.jwebmp.plugins.agchartsenterprise.options.series.AgNightingaleSeriesOptions;
import io.smallrye.mutiny.Uni;

import java.util.List;

/**
 * Nightingale Chart builder for AG Charts Enterprise.
 *
 * <p>
 * Builds a polar area (Nightingale) chart where sectors represent categories
 * and sector area/radius represents values. Useful for comparing multiple
 * attributes with both angle and radius dimensions.
 * </p>
 *
 * <p>
 * Example usage:
 * <pre>{@code
 * Uni<AgChartOptions<?>> chartOptions = new AgNightingaleChart("chart-id")
 *     .setAngleKey("category")
 *     .setRadiusKey("value")
 *     .setData(dataPoints)
 *     .setFill("#1f77b4")
 *     .setCornerRadius(5)
 *     .getInitialOptions();
 * }</pre>
 * </p>
 *
 * @param <J> the CRTP parameter for fluent API chaining
 */
public class AgNightingaleChart<J extends AgNightingaleChart<J>> extends AgChart<J>
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

    // --- Sector styling ---
    private Integer cornerRadius;

    /**
     * Constructor with chart ID.
     *
     * @param id the unique chart identifier
     */
    public AgNightingaleChart(String id)
    {
        super(id);
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
     * Sets the data array for the chart.
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
     * Sets the visibility state of the nightingale series.
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
     * Sets the fill opacity for the nightingale sectors.
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
     * Sets the stroke opacity for the sector outlines.
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

    @Override
    public Uni<AgChartOptions<?>> getInitialOptions(com.jwebmp.core.base.ajax.AjaxCall<?> call, com.jwebmp.core.base.ajax.AjaxResponse<?> response)
    {
        return Uni.createFrom().item(() -> {
            // Build nightingale series with configured properties
            AgNightingaleSeriesOptions<?> series = new AgNightingaleSeriesOptions<>()
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

            // Set sector styling options
            if (cornerRadius != null) series.setCornerRadius(cornerRadius);

            return new AgChartOptions<>()
                    .setSeries(List.of(series));
        });
    }
}
