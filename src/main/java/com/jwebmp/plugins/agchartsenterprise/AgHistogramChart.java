package com.jwebmp.plugins.agchartsenterprise;

import com.jwebmp.plugins.agcharts.AgChart;
import com.jwebmp.plugins.agcharts.options.AgChartOptions;
import com.jwebmp.plugins.agchartsenterprise.options.AgFinancialChartOptions;
import com.jwebmp.plugins.agchartsenterprise.options.series.AgHistogramSeriesOptions;
import io.smallrye.mutiny.Uni;

/**
 * Histogram Chart component for AG Charts Enterprise.
 *
 * <p>
 * Builds a Histogram chart visualizing the frequency distribution of continuous
 * numeric data, grouping values into bins and displaying their frequency as columns.
 * Useful for analyzing data distributions and identifying patterns.
 * </p>
 *
 * <p>
 * Example usage:
 * <pre>
 * new AgHistogramChart()
 *   .setSeries(new AgHistogramSeriesOptions<>()
 *     .setxKey("value")
 *     .setBinCount(20)
 *     .setCumulative(false))
 *   .setData(numericData);
 * </pre>
 * </p>
 */
public class AgHistogramChart extends AgChart<AgHistogramChart>
{
    private AgHistogramSeriesOptions<?> series;
    private AgFinancialChartOptions<?> options;

    public AgHistogramChart()
    {
        super();
    }

    /**
     * Sets the histogram series configuration.
     *
     * @param series the histogram series options
     * @return this instance for method chaining
     */
    public AgHistogramChart setSeries(AgHistogramSeriesOptions<?> series)
    {
        this.series = series;
        return this;
    }

    /**
     * Gets the histogram series configuration.
     *
     * @return the series options, or null if not set
     */
    public AgHistogramSeriesOptions<?> getSeries()
    {
        return series;
    }

    /**
     * Sets the chart options configuration.
     *
     * @param options the chart options
     * @return this instance for method chaining
     */
    public AgHistogramChart setOptions(AgFinancialChartOptions<?> options)
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
     * @return a Uni emitting the configured AgChartOptions for this histogram chart
     */
    @Override
    public Uni<AgChartOptions<?>> getInitialOptions(com.jwebmp.core.base.ajax.AjaxCall<?> call, com.jwebmp.core.base.ajax.AjaxResponse<?> response)
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
