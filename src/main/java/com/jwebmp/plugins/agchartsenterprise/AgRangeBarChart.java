package com.jwebmp.plugins.agchartsenterprise;

import com.jwebmp.plugins.agcharts.AgChart;
import com.jwebmp.plugins.agcharts.options.AgChartOptions;
import com.jwebmp.plugins.agchartsenterprise.options.AgFinancialChartOptions;
import com.jwebmp.plugins.agchartsenterprise.options.series.AgRangeBarSeriesOptions;
import io.smallrye.mutiny.Uni;

/**
 * Range Bar Chart component for AG Charts Enterprise.
 *
 * <p>
 * Builds a Range Bar chart showing data as horizontal bars representing
 * a range between minimum and maximum values. Each bar spans from yLowKey
 * to yHighKey for categories defined by xKey.
 * </p>
 *
 * <p>
 * Example usage:
 * <pre>
 * new AgRangeBarChart()
 *   .setSeries(new AgRangeBarSeriesOptions<>()
 *     .setxKey("month")
 *     .setyLowKey("tempMin")
 *     .setyHighKey("tempMax"))
 *   .setData(temperatureData);
 * </pre>
 * </p>
 */
public class AgRangeBarChart extends AgChart<AgRangeBarChart>
{
    private AgRangeBarSeriesOptions<?> series;
    private AgFinancialChartOptions<?> options;

    public AgRangeBarChart()
    {
        super();
    }

    /**
     * Sets the range bar series configuration.
     *
     * @param series the range bar series options
     * @return this instance for method chaining
     */
    public AgRangeBarChart setSeries(AgRangeBarSeriesOptions<?> series)
    {
        this.series = series;
        return this;
    }

    /**
     * Gets the range bar series configuration.
     *
     * @return the series options, or null if not set
     */
    public AgRangeBarSeriesOptions<?> getSeries()
    {
        return series;
    }

    /**
     * Sets the chart options configuration.
     *
     * @param options the chart options
     * @return this instance for method chaining
     */
    public AgRangeBarChart setOptions(AgFinancialChartOptions<?> options)
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
     * @return a Uni emitting the configured AgChartOptions for this range bar chart
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
