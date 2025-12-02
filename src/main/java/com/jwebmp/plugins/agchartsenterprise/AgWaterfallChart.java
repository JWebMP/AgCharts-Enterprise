package com.jwebmp.plugins.agchartsenterprise;

import com.jwebmp.plugins.agcharts.AgChart;
import com.jwebmp.plugins.agcharts.options.AgChartOptions;
import com.jwebmp.plugins.agchartsenterprise.options.AgFinancialChartOptions;
import com.jwebmp.plugins.agchartsenterprise.options.series.AgWaterfallSeriesOptions;
import io.smallrye.mutiny.Uni;

/**
 * Waterfall Chart component for AG Charts Enterprise.
 *
 * <p>
 * Builds a Waterfall chart showing cumulative changes over time, illustrating
 * how an initial value is affected by a series of positive or negative changes.
 * Ideal for budget variance analysis, profit/loss breakdown, or financial flows.
 * </p>
 *
 * <p>
 * Example usage:
 * <pre>
 * new AgWaterfallChart()
 *   .setSeries(new AgWaterfallSeriesOptions<>()
 *     .setxKey("category")
 *     .setValueKey("change"))
 *   .setData(waterfallData);
 * </pre>
 * </p>
 */
public class AgWaterfallChart extends AgChart<AgWaterfallChart>
{
    private AgWaterfallSeriesOptions<?> series;
    private AgFinancialChartOptions<?> options;

    public AgWaterfallChart()
    {
        super();
    }

    /**
     * Sets the waterfall series configuration.
     *
     * @param series the waterfall series options
     * @return this instance for method chaining
     */
    public AgWaterfallChart setSeries(AgWaterfallSeriesOptions<?> series)
    {
        this.series = series;
        return this;
    }

    /**
     * Gets the waterfall series configuration.
     *
     * @return the series options, or null if not set
     */
    public AgWaterfallSeriesOptions<?> getSeries()
    {
        return series;
    }

    /**
     * Sets the chart options configuration.
     *
     * @param options the chart options
     * @return this instance for method chaining
     */
    public AgWaterfallChart setOptions(AgFinancialChartOptions<?> options)
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
     * @return a Uni emitting the configured AgChartOptions for this waterfall chart
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
