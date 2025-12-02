package com.jwebmp.plugins.agchartsenterprise;

import com.jwebmp.plugins.agcharts.AgChart;
import com.jwebmp.plugins.agcharts.options.AgChartOptions;
import com.jwebmp.plugins.agchartsenterprise.options.AgFinancialChartOptions;
import com.jwebmp.plugins.agchartsenterprise.options.series.AgRangeAreaSeriesOptions;
import io.smallrye.mutiny.Uni;

/**
 * Range Area Chart component for AG Charts Enterprise.
 *
 * <p>
 * Builds a Range Area chart showing data as areas representing
 * a range between minimum and maximum values. Useful for displaying
 * confidence bands, temperature ranges, or any min-max paired time series.
 * </p>
 *
 * <p>
 * Example usage:
 * <pre>
 * new AgRangeAreaChart()
 *   .setSeries(new AgRangeAreaSeriesOptions<>()
 *     .setxKey("date")
 *     .setyLowKey("low")
 *     .setyHighKey("high"))
 *   .setData(rangeData);
 * </pre>
 * </p>
 */
public class AgRangeAreaChart extends AgChart<AgRangeAreaChart>
{
    private AgRangeAreaSeriesOptions<?> series;
    private AgFinancialChartOptions<?> options;

    public AgRangeAreaChart()
    {
        super();
    }

    /**
     * Sets the range area series configuration.
     *
     * @param series the range area series options
     * @return this instance for method chaining
     */
    public AgRangeAreaChart setSeries(AgRangeAreaSeriesOptions<?> series)
    {
        this.series = series;
        return this;
    }

    /**
     * Gets the range area series configuration.
     *
     * @return the series options, or null if not set
     */
    public AgRangeAreaSeriesOptions<?> getSeries()
    {
        return series;
    }

    /**
     * Sets the chart options configuration.
     *
     * @param options the chart options
     * @return this instance for method chaining
     */
    public AgRangeAreaChart setOptions(AgFinancialChartOptions<?> options)
    {
        this.options = options;
        return this;
    }

    /**
     * Gets the chart options configuration.
     *
     * @return the chart options, or null if not set
     */
    public AgFinancialChartOptions<?> getOptions()
    {
        return options;
    }

    /**
     * Builds and returns the initial chart configuration as a reactive Uni.
     *
     * @return a Uni emitting the configured AgChartOptions for this range area chart
     */
    @Override
    public Uni<AgChartOptions<?>> getInitialOptions()
    {
        return Uni.createFrom().item(() -> {
            AgChartOptions<?> opts = new AgChartOptions<>();

            if (series != null) {
                java.util.List<com.jwebmp.plugins.agcharts.options.series.AgSeriesBaseOptions<?>> seriesList = 
                    new java.util.ArrayList<>();
                seriesList.add(series);
                opts.setSeries(seriesList);
            }

            if (options != null) {
                if (options.getAxes() != null) {
                    opts.setAxes(options.getAxes());
                }
                if (options.getTooltip() != null) {
                    opts.setTooltip(options.getTooltip());
                }
                if (options.getLegend() != null) {
                    opts.setLegend(options.getLegend());
                }
                if (options.getBackground() != null) {
                    opts.setBackground(options.getBackground());
                }
                if (options.getTitle() != null) {
                    opts.setTitle(options.getTitle());
                }
                if (options.getSubtitle() != null) {
                    opts.setSubtitle(options.getSubtitle());
                }
                if (options.getAnimation() != null) {
                    opts.setAnimation(options.getAnimation());
                }
            }

            return opts;
        });
    }
}
