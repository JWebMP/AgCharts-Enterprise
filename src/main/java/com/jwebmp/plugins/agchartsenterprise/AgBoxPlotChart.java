package com.jwebmp.plugins.agchartsenterprise;

import com.jwebmp.plugins.agcharts.AgChart;
import com.jwebmp.plugins.agcharts.options.AgChartOptions;
import com.jwebmp.plugins.agchartsenterprise.options.AgFinancialChartOptions;
import com.jwebmp.plugins.agchartsenterprise.options.series.AgBoxPlotSeriesOptions;
import io.smallrye.mutiny.Uni;

/**
 * Box Plot Chart component for AG Charts Enterprise.
 *
 * <p>
 * Builds a Box Plot chart visualizing statistical distribution of data,
 * showing quartiles, median, and outliers. Each box represents a distribution
 * group with whiskers extending to min/max and potential outlier points.
 * </p>
 *
 * <p>
 * Example usage:
 * <pre>
 * new AgBoxPlotChart()
 *   .setSeries(new AgBoxPlotSeriesOptions<>()
 *     .setxKey("group")
 *     .setMinKey("min")
 *     .setQ1Key("q1")
 *     .setMedianKey("median")
 *     .setQ3Key("q3")
 *     .setMaxKey("max"))
 *   .setData(distributionData);
 * </pre>
 * </p>
 */
public class AgBoxPlotChart extends AgChart<AgBoxPlotChart>
{
    private AgBoxPlotSeriesOptions<?> series;
    private AgFinancialChartOptions<?> options;

    public AgBoxPlotChart()
    {
        super();
    }

    /**
     * Sets the box plot series configuration.
     *
     * @param series the box plot series options
     * @return this instance for method chaining
     */
    public AgBoxPlotChart setSeries(AgBoxPlotSeriesOptions<?> series)
    {
        this.series = series;
        return this;
    }

    /**
     * Gets the box plot series configuration.
     *
     * @return the series options, or null if not set
     */
    public AgBoxPlotSeriesOptions<?> getSeries()
    {
        return series;
    }

    /**
     * Sets the chart options configuration.
     *
     * @param options the chart options
     * @return this instance for method chaining
     */
    public AgBoxPlotChart setOptions(AgFinancialChartOptions<?> options)
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
     * @return a Uni emitting the configured AgChartOptions for this box plot chart
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
