package com.jwebmp.plugins.agchartsenterprise.options;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.jwebmp.plugins.agcharts.options.AgChartOptions;
import com.jwebmp.plugins.agchartsenterprise.options.series.AgCandlestickSeriesOptions;
import com.jwebmp.plugins.agchartsenterprise.options.series.AgOhlcSeriesOptions;

/**
 * Financial Chart options for AG Charts Enterprise.
 *
 * <p>
 * Specialized chart configuration for financial data visualization with
 * pre-configured settings for candlestick or OHLC series. This class provides
 * convenience methods for building financial charts with common options like
 * navigator mini-chart, crosshair interactions, and tooltip formatting.
 * </p>
 *
 * <p>
 * Key components:
 * <ul>
 *   <li><strong>Candlestick Series</strong> - OHLC visualization with bodies and wicks</li>
 *   <li><strong>OHLC Series</strong> - Line-based OHLC visualization</li>
 *   <li><strong>Navigator</strong> - Mini-chart for time series navigation</li>
 *   <li><strong>Crosshair</strong> - Horizontal/vertical crosshair for price tracking</li>
 *   <li><strong>Default Styling</strong> - Green for up days, red for down days</li>
 * </ul>
 * </p>
 *
 * @param <J> the CRTP parameter for fluent API chaining
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AgFinancialChartOptions<J extends AgFinancialChartOptions<J>> extends AgChartOptions<J>
{
    private AgCandlestickSeriesOptions<?> candlestick; // Candlestick series if using candlestick visualization
    private AgOhlcSeriesOptions<?> ohlc;               // OHLC series if using OHLC visualization

    private Boolean enableNavigator;    // Show mini chart navigator for time series
    private Boolean enableCrosshair;    // Show crosshair interaction
    private Boolean enableTooltip;      // Show tooltip on hover

    /**
     * Gets the candlestick series options configured for this financial chart.
     *
     * @return the candlestick series options, or null if not configured
     */
    public AgCandlestickSeriesOptions<?> getCandlestick()
    {
        return candlestick;
    }

    /**
     * Sets the candlestick series options for this financial chart.
     * <p>
     * Use this to configure candlestick visualization of OHLC financial data.
     * When set, the OHLC series should typically be null to avoid conflicting series.
     * </p>
     *
     * @param candlestick the candlestick series configuration
     * @return this instance for method chaining
     */
    public @org.jspecify.annotations.NonNull J setCandlestick(AgCandlestickSeriesOptions<?> candlestick)
    {
        this.candlestick = candlestick;
        return (J) this;
    }

    /**
     * Gets the OHLC series options configured for this financial chart.
     *
     * @return the OHLC series options, or null if not configured
     */
    public AgOhlcSeriesOptions<?> getOhlc()
    {
        return ohlc;
    }

    /**
     * Sets the OHLC series options for this financial chart.
     * <p>
     * Use this to configure line-based OHLC visualization of financial data.
     * When set, the Candlestick series should typically be null to avoid conflicting series.
     * </p>
     *
     * @param ohlc the OHLC series configuration
     * @return this instance for method chaining
     */
    public @org.jspecify.annotations.NonNull J setOhlc(AgOhlcSeriesOptions<?> ohlc)
    {
        this.ohlc = ohlc;
        return (J) this;
    }

    /**
     * Gets whether the navigator mini-chart is enabled.
     *
     * @return true if navigator is enabled, false if disabled, or null for default
     */
    public Boolean getEnableNavigator()
    {
        return enableNavigator;
    }

    /**
     * Sets whether the navigator mini-chart should be displayed.
     * <p>
     * The navigator provides a miniature view of the entire time series,
     * allowing users to quickly zoom and pan to different time periods.
     * Recommended for time series data spanning long durations.
     * </p>
     *
     * @param enableNavigator true to show navigator, false to hide
     * @return this instance for method chaining
     */
    public @org.jspecify.annotations.NonNull J setEnableNavigator(Boolean enableNavigator)
    {
        this.enableNavigator = enableNavigator;
        return (J) this;
    }

    /**
     * Gets whether the crosshair interaction is enabled.
     *
     * @return true if crosshair is enabled, false if disabled, or null for default
     */
    public Boolean getEnableCrosshair()
    {
        return enableCrosshair;
    }

    /**
     * Sets whether the crosshair interaction should be enabled.
     * <p>
     * The crosshair provides vertical and horizontal lines that track the mouse cursor,
     * making it easy to read precise values from the chart. Particularly useful for
     * identifying price levels at specific times.
     * </p>
     *
     * @param enableCrosshair true to enable crosshair, false to disable
     * @return this instance for method chaining
     */
    public @org.jspecify.annotations.NonNull J setEnableCrosshair(Boolean enableCrosshair)
    {
        this.enableCrosshair = enableCrosshair;
        return (J) this;
    }

    /**
     * Gets whether the tooltip is enabled.
     *
     * @return true if tooltip is enabled, false if disabled, or null for default (true)
     */
    public Boolean getEnableTooltip()
    {
        return enableTooltip;
    }

    /**
     * Sets whether the tooltip should be displayed on hover.
     * <p>
     * The tooltip shows detailed information about each data point including
     * date, open, high, low, and close prices when hovering over candlesticks
     * or OHLC bars.
     * </p>
     *
     * @param enableTooltip true to show tooltip, false to hide
     * @return this instance for method chaining
     */
    public @org.jspecify.annotations.NonNull J setEnableTooltip(Boolean enableTooltip)
    {
        this.enableTooltip = enableTooltip;
        return (J) this;
    }
}
