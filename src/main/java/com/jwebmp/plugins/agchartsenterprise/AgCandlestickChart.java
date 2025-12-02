package com.jwebmp.plugins.agchartsenterprise;

import com.jwebmp.plugins.agcharts.AgChart;
import com.jwebmp.plugins.agcharts.options.AgChartOptions;
import com.jwebmp.plugins.agchartsenterprise.options.series.AgCandlestickSeriesOptions;
import io.smallrye.mutiny.Uni;

import java.util.List;

/**
 * Builder for Candlestick Charts using AG Charts Enterprise.
 *
 * <p>
 * Provides a fluent API for configuring and building candlestick charts
 * for financial data visualization. Returns a reactive Uni<AgChartOptions<?>>
 * for integration with Mutiny-based reactive pipelines.
 * </p>
 *
 * <p>
 * Example usage:
 * <pre>{@code
 * Uni<AgChartOptions<?>> chartConfig = new AgCandlestickChart("chart-id")
 *     .setDateKey("date")
 *     .setOpenKey("open")
 *     .setCloseKey("close")
 *     .setHighKey("high")
 *     .setLowKey("low")
 *     .setData(data)
 *     .getInitialOptions();
 * }</pre>
 * </p>
 *
 * @param <J> the CRTP parameter for fluent API chaining
 */
public class AgCandlestickChart<J extends AgCandlestickChart<J>> extends AgChart<J>
{
    // --- Required keys ---
    private String dateKey;
    private String openKey;
    private String closeKey;
    private String highKey;
    private String lowKey;

    // --- Display names ---
    private String dateName;
    private String openName;
    private String closeName;
    private String highName;
    private String lowName;

    // --- Colors ---
    private String upColor;
    private String downColor;

    // --- Data & Display ---
    private List<?> data;
    private Boolean visible;
    private Boolean showInLegend;
    private Boolean showInMiniChart;

    // --- Styling ---
    private Integer cornerRadius;
    private Double fillOpacity;
    private String stroke;
    private Integer strokeWidth;
    private Double strokeOpacity;

    /**
     * Constructor with chart ID.
     *
     * @param id the unique chart identifier
     */
    public AgCandlestickChart(String id)
    {
        super(id);
    }

    /**
     * Sets the property name for date/time values.
     *
     * @param dateKey the property name
     * @return this instance for method chaining
     */
    public @org.jspecify.annotations.NonNull J setDateKey(String dateKey)
    {
        this.dateKey = dateKey;
        return (J) this;
    }

    /**
     * Sets the property name for opening prices.
     *
     * @param openKey the property name
     * @return this instance for method chaining
     */
    public @org.jspecify.annotations.NonNull J setOpenKey(String openKey)
    {
        this.openKey = openKey;
        return (J) this;
    }

    /**
     * Sets the property name for closing prices.
     *
     * @param closeKey the property name
     * @return this instance for method chaining
     */
    public @org.jspecify.annotations.NonNull J setCloseKey(String closeKey)
    {
        this.closeKey = closeKey;
        return (J) this;
    }

    /**
     * Sets the property name for high prices.
     *
     * @param highKey the property name
     * @return this instance for method chaining
     */
    public @org.jspecify.annotations.NonNull J setHighKey(String highKey)
    {
        this.highKey = highKey;
        return (J) this;
    }

    /**
     * Sets the property name for low prices.
     *
     * @param lowKey the property name
     * @return this instance for method chaining
     */
    public @org.jspecify.annotations.NonNull J setLowKey(String lowKey)
    {
        this.lowKey = lowKey;
        return (J) this;
    }

    /**
     * Sets the display name for the date field.
     *
     * @param dateName the display name
     * @return this instance for method chaining
     */
    public @org.jspecify.annotations.NonNull J setDateName(String dateName)
    {
        this.dateName = dateName;
        return (J) this;
    }

    /**
     * Sets the display name for the open price field.
     *
     * @param openName the display name
     * @return this instance for method chaining
     */
    public @org.jspecify.annotations.NonNull J setOpenName(String openName)
    {
        this.openName = openName;
        return (J) this;
    }

    /**
     * Sets the display name for the close price field.
     *
     * @param closeName the display name
     * @return this instance for method chaining
     */
    public @org.jspecify.annotations.NonNull J setCloseName(String closeName)
    {
        this.closeName = closeName;
        return (J) this;
    }

    /**
     * Sets the display name for the high price field.
     *
     * @param highName the display name
     * @return this instance for method chaining
     */
    public @org.jspecify.annotations.NonNull J setHighName(String highName)
    {
        this.highName = highName;
        return (J) this;
    }

    /**
     * Sets the display name for the low price field.
     *
     * @param lowName the display name
     * @return this instance for method chaining
     */
    public @org.jspecify.annotations.NonNull J setLowName(String lowName)
    {
        this.lowName = lowName;
        return (J) this;
    }

    /**
     * Sets the color for bullish candlesticks (close >= open).
     *
     * @param upColor the hex color code or CSS color name
     * @return this instance for method chaining
     */
    public @org.jspecify.annotations.NonNull J setUpColor(String upColor)
    {
        this.upColor = upColor;
        return (J) this;
    }

    /**
     * Sets the color for bearish candlesticks (close < open).
     *
     * @param downColor the hex color code or CSS color name
     * @return this instance for method chaining
     */
    public @org.jspecify.annotations.NonNull J setDownColor(String downColor)
    {
        this.downColor = downColor;
        return (J) this;
    }

    /**
     * Sets the data array for the chart.
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
     * Sets the visibility state of the candlestick series.
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
     * Sets the corner radius for candlestick corners.
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
     * Sets the fill opacity for candlestick bodies.
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
     * Sets the stroke color for candlestick wicks and borders.
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
     * Sets the stroke width for candlestick wicks and borders.
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
     * Sets the stroke opacity for candlestick wicks and borders.
     *
     * @param strokeOpacity the opacity (0..1)
     * @return this instance for method chaining
     */
    public @org.jspecify.annotations.NonNull J setStrokeOpacity(Double strokeOpacity)
    {
        this.strokeOpacity = strokeOpacity;
        return (J) this;
    }

    @Override
    public Uni<AgChartOptions<?>> getInitialOptions()
    {
        return Uni.createFrom().item(() -> {
            // Build candlestick series with configured properties
            AgCandlestickSeriesOptions<?> series = new AgCandlestickSeriesOptions<>()
                    .setDateKey(dateKey)
                    .setOpenKey(openKey)
                    .setCloseKey(closeKey)
                    .setHighKey(highKey)
                    .setLowKey(lowKey);

            // Set optional display names
            if (dateName != null) series.setDateName(dateName);
            if (openName != null) series.setOpenName(openName);
            if (closeName != null) series.setCloseName(closeName);
            if (highName != null) series.setHighName(highName);
            if (lowName != null) series.setLowName(lowName);

            // Set colors
            if (upColor != null) series.setUpColor(upColor);
            if (downColor != null) series.setDownColor(downColor);

            // Set data and display options
            if (data != null) series.setData(data);
            if (visible != null) series.setVisible(visible);
            if (showInLegend != null) series.setShowInLegend(showInLegend);
            if (showInMiniChart != null) series.setShowInMiniChart(showInMiniChart);

            // Set styling options
            if (cornerRadius != null) series.setCornerRadius(cornerRadius);
            if (fillOpacity != null) series.setFillOpacity(fillOpacity);
            if (stroke != null) series.setStroke(stroke);
            if (strokeWidth != null) series.setStrokeWidth(strokeWidth);
            if (strokeOpacity != null) series.setStrokeOpacity(strokeOpacity);

            return new AgChartOptions<>()
                    .setSeries(List.of(series));
        });
    }
}
