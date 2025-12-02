package com.jwebmp.plugins.agchartsenterprise;

import com.jwebmp.core.htmlbuilder.javascript.JavaScriptPart;
import com.jwebmp.plugins.agchartsenterprise.options.series.AgBoxPlotSeriesOptions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Tests for Box Plot Series options serialization and configuration.
 *
 * Verifies that box plot series serialize correctly to JSON with statistical
 * distribution data, including quartile and outlier styling.
 */
public class AgBoxPlotSeriesTest
{
    @Test
    public void testBoxPlotBasicConfiguration()
    {
        AgBoxPlotSeriesOptions<?> series = new AgBoxPlotSeriesOptions<>()
                .setxKey("group")
                .setMinKey("min")
                .setQ1Key("q1")
                .setMedianKey("median")
                .setQ3Key("q3")
                .setMaxKey("max");

        String json = new JavaScriptPart<>().objectAsString(series);

        assertTrue(json.contains("\"box-plot\""), "Expected series type 'box-plot': " + json);
        assertTrue(json.contains("\"xKey\":\"group\"") || json.contains("\"x-key\":\"group\""), json);
        assertTrue(json.contains("\"minKey\":\"min\"") || json.contains("\"min-key\":\"min\""), json);
        assertTrue(json.contains("\"medianKey\":\"median\"") || json.contains("\"median-key\":\"median\""), json);
    }

    @Test
    public void testBoxPlotWithColors()
    {
        AgBoxPlotSeriesOptions<?> series = new AgBoxPlotSeriesOptions<>()
                .setxKey("group")
                .setMinKey("min")
                .setQ1Key("q1")
                .setMedianKey("median")
                .setQ3Key("q3")
                .setMaxKey("max")
                .setFill("#4472C4")         // Box fill
                .setStroke("#2E5090")       // Box outline
                .setOutlierFill("#FF0000") // Red for outliers
                .setOutlierStroke("#CC0000");

        String json = new JavaScriptPart<>().objectAsString(series);

        assertTrue(json.contains("\"fill\":\"#4472C4\""), json);
        assertTrue(json.contains("\"stroke\":\"#2E5090\""), json);
        assertTrue(json.contains("\"outlierFill\":\"#FF0000\"") || json.contains("\"outlier-fill\":\"#FF0000\""), json);
    }

    @Test
    public void testBoxPlotWithData()
    {
        List<Map<String, Object>> data = new ArrayList<>();
        Map<String, Object> item1 = new HashMap<>();
        item1.put("group", "A");
        item1.put("min", 10.0);
        item1.put("q1", 25.0);
        item1.put("median", 50.0);
        item1.put("q3", 75.0);
        item1.put("max", 100.0);
        data.add(item1);

        AgBoxPlotSeriesOptions<?> series = new AgBoxPlotSeriesOptions<>()
                .setxKey("group")
                .setMinKey("min")
                .setQ1Key("q1")
                .setMedianKey("median")
                .setQ3Key("q3")
                .setMaxKey("max")
                .setData(data);

        String json = new JavaScriptPart<>().objectAsString(series);

        assertTrue(json.contains("\"data\""), "Expected data property: " + json);
        assertTrue(json.contains("\"group\":\"A\""), json);
        assertTrue(json.contains("\"median\":50"), json);
    }

    @Test
    public void testBoxPlotWithDisplayNames()
    {
        AgBoxPlotSeriesOptions<?> series = new AgBoxPlotSeriesOptions<>()
                .setxKey("group")
                .setMinKey("min")
                .setQ1Key("q1")
                .setMedianKey("median")
                .setQ3Key("q3")
                .setMaxKey("max")
                .setxName("Test Group")
                .setMinName("Minimum")
                .setQ1Name("Q1 (25%)")
                .setMedianName("Median (50%)")
                .setQ3Name("Q3 (75%)")
                .setMaxName("Maximum")
                .setOutlierName("Outliers");

        String json = new JavaScriptPart<>().objectAsString(series);

        assertTrue(json.contains("\"xName\":\"Test Group\"") || json.contains("\"x-name\":\"Test Group\""), json);
        assertTrue(json.contains("\"minName\":\"Minimum\"") || json.contains("\"min-name\":\"Minimum\""), json);
        assertTrue(json.contains("\"medianName\":\"Median (50%)\"") || json.contains("\"median-name\":\"Median (50%)\""), json);
    }

    @Test
    public void testBoxPlotWithStyling()
    {
        AgBoxPlotSeriesOptions<?> series = new AgBoxPlotSeriesOptions<>()
                .setxKey("group")
                .setMinKey("min")
                .setQ1Key("q1")
                .setMedianKey("median")
                .setQ3Key("q3")
                .setMaxKey("max")
                .setFill("#4472C4")
                .setFillOpacity(0.7)
                .setStroke("#2E5090")
                .setStrokeWidth(2)
                .setLineWidth(1)
                .setOutlierSize(5)
                .setOutlierFill("#FF0000");

        String json = new JavaScriptPart<>().objectAsString(series);

        assertTrue(json.contains("\"fillOpacity\":0.7") || json.contains("\"fill-opacity\":0.7"), json);
        assertTrue(json.contains("\"strokeWidth\":2") || json.contains("\"stroke-width\":2"), json);
        assertTrue(json.contains("\"lineWidth\":1") || json.contains("\"line-width\":1"), json);
        assertTrue(json.contains("\"outlierSize\":5") || json.contains("\"outlier-size\":5"), json);
    }

    @Test
    public void testBoxPlotNullExclusion()
    {
        AgBoxPlotSeriesOptions<?> series = new AgBoxPlotSeriesOptions<>()
                .setxKey("group")
                .setMinKey("min")
                .setQ1Key("q1")
                .setMedianKey("median")
                .setQ3Key("q3")
                .setMaxKey("max");

        String json = new JavaScriptPart<>().objectAsString(series);

        assertNoNullFields(json);
    }

    @Test
    public void testBoxPlotCompleteConfiguration()
    {
        List<Map<String, Object>> data = new ArrayList<>();
        Map<String, Object> item = new HashMap<>();
        item.put("group", "A");
        item.put("min", 10.0);
        item.put("q1", 25.0);
        item.put("median", 50.0);
        item.put("q3", 75.0);
        item.put("max", 100.0);
        data.add(item);

        AgBoxPlotSeriesOptions<?> series = new AgBoxPlotSeriesOptions<>()
                .setxKey("group")
                .setMinKey("min")
                .setQ1Key("q1")
                .setMedianKey("median")
                .setQ3Key("q3")
                .setMaxKey("max")
                .setxName("Test Group")
                .setMedianName("Median")
                .setFill("#4472C4")
                .setStroke("#2E5090")
                .setStrokeWidth(2)
                .setOutlierFill("#FF0000")
                .setOutlierSize(5)
                .setData(data)
                .setVisible(true)
                .setShowInLegend(true);

        String json = new JavaScriptPart<>().objectAsString(series);

        assertTrue(json.contains("\"box-plot\""), json);
        assertTrue(json.contains("\"xKey\""), json);
        assertTrue(json.contains("\"minKey\""), json);
        assertTrue(json.contains("\"medianKey\""), json);
        assertTrue(json.contains("\"q3Key\""), json);
        assertTrue(json.contains("\"fill\":\"#4472C4\""), json);
        assertTrue(json.contains("\"data\""), json);
    }

    /**
     * Helper to verify that null values are properly excluded.
     */
    private void assertNoNullFields(String json)
    {
        assertTrue(!json.contains(":null"), "JSON should not contain null values: " + json);
        assertTrue(!json.contains("undefined"), "JSON should not contain undefined: " + json);
    }
}
