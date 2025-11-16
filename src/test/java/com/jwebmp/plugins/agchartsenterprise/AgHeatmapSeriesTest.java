package com.jwebmp.plugins.agchartsenterprise;

import com.jwebmp.core.htmlbuilder.javascript.JavaScriptPart;
import com.jwebmp.plugins.agcharts.options.AgChartOptions;
import com.jwebmp.plugins.agcharts.options.legend.gradient.AgGradientLegendGradientOptions;
import com.jwebmp.plugins.agcharts.options.legend.gradient.AgGradientLegendOptions;
import com.jwebmp.plugins.agcharts.options.legend.gradient.AgGradientLegendScaleOptions;
import com.jwebmp.plugins.agchartsenterprise.options.series.AgHeatmapSeriesLabelOptions;
import com.jwebmp.plugins.agcharts.options.series.AgSeriesBaseOptions;
import com.jwebmp.plugins.agchartsenterprise.options.series.AgHeatmapSeriesOptions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class AgHeatmapSeriesTest
{

    @Test
    public void testHeatmapSeriesAndGradientLegendSerialization()
    {
        AgHeatmapSeriesOptions<?> series = new AgHeatmapSeriesOptions<>()
                .setxKey("month")
                .setyKey("year")
                .setColorKey("temperature")
                .setColorRange(Arrays.asList("#43a2ca", "#a8ddb5", "#f0f9e8"))
                .setTitle("Temperature");

        // Label options using heatmap label subclass
        AgHeatmapSeriesLabelOptions<?> label = new AgHeatmapSeriesLabelOptions<>()
                .setEnabled(true)
                .setFormatter("function(p){ return p.datum[p.colorKey] + '°C'; }");
        series.setLabel(label);

        AgChartOptions<?> options = new AgChartOptions<>()
                .setSeries(Collections.singletonList((AgSeriesBaseOptions<?>) series));

        AgGradientLegendOptions<?> gl = new AgGradientLegendOptions<>()
                .setEnabled(true)
                .setPosition("right")
                .setReverseOrder(true)
                .setGradient(new AgGradientLegendGradientOptions<>()
                        .setThickness(50)
                        .setPreferredLength(400))
                .setScale(new AgGradientLegendScaleOptions<>());
        options.setGradientLegend(gl);

        String json = new JavaScriptPart<>().objectAsString(options);

        assertTrue(json.contains("\"heatmap\""), "Expected series type 'heatmap' in JSON: " + json);
        assertTrue(json.contains("\"xKey\":\"month\"") || json.contains("\"x-key\":\"month\""), json);
        assertTrue(json.contains("\"yKey\":\"year\"") || json.contains("\"y-key\":\"year\""), json);
        assertTrue(json.contains("\"colorKey\":\"temperature\"") || json.contains("\"color-key\":\"temperature\""), json);
        assertTrue(json.contains("\"colorRange\":[\"#43a2ca\",\"#a8ddb5\",\"#f0f9e8\"]")
                || json.contains("\"color-range\":[\"#43a2ca\",\"#a8ddb5\",\"#f0f9e8\"]"), json);

        // Gradient legend
        assertTrue(json.contains("\"gradientLegend\""), "Expected gradientLegend block in JSON: " + json);
        assertTrue(json.contains("\"position\":\"right\"") || json.contains("\"position\":\"right\""), json);
        assertTrue(json.contains("\"thickness\":50"), json);
        assertTrue(json.contains("\"preferredLength\":400") || json.contains("\"preferred-length\":400"), json);

        // Label enabled flag
        assertTrue(json.contains("\"enabled\":true"), "Expected label enabled true in JSON: " + json);
    }
}
