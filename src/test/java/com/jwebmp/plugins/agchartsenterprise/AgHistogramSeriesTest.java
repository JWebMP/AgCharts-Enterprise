package com.jwebmp.plugins.agchartsenterprise;

import com.jwebmp.core.htmlbuilder.javascript.JavaScriptPart;
import com.jwebmp.plugins.agchartsenterprise.options.series.AgHistogramSeriesOptions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Tests for Histogram Series options serialization and configuration.
 *
 * Verifies that histogram series serialize correctly to JSON with frequency
 * distribution data, including bin configuration and cumulative options.
 */
public class AgHistogramSeriesTest
{
    @Test
    public void testHistogramBasicConfiguration()
    {
        AgHistogramSeriesOptions<?> series = new AgHistogramSeriesOptions<>()
                .setxKey("value");

        String json = new JavaScriptPart<>().objectAsString(series);

        assertTrue(json.contains("\"histogram\""), "Expected series type 'histogram': " + json);
        assertTrue(json.contains("\"xKey\":\"value\"") || json.contains("\"x-key\":\"value\""), json);
    }

    @Test
    public void testHistogramWithBinCount()
    {
        AgHistogramSeriesOptions<?> series = new AgHistogramSeriesOptions<>()
                .setxKey("value")
                .setBinCount(20);

        String json = new JavaScriptPart<>().objectAsString(series);

        assertTrue(json.contains("\"binCount\":20") || json.contains("\"bin-count\":20"), json);
    }

    @Test
    public void testHistogramWithCumulative()
    {
        AgHistogramSeriesOptions<?> series = new AgHistogramSeriesOptions<>()
                .setxKey("value")
                .setBinCount(15)
                .setCumulative(true);

        String json = new JavaScriptPart<>().objectAsString(series);

        assertTrue(json.contains("\"cumulative\":true"), json);
    }

    @Test
    public void testHistogramWithData()
    {
        List<Map<String, Object>> data = new ArrayList<>();
        Map<String, Object> item1 = new HashMap<>();
        item1.put("value", 42.5);
        data.add(item1);

        Map<String, Object> item2 = new HashMap<>();
        item2.put("value", 45.3);
        data.add(item2);

        AgHistogramSeriesOptions<?> series = new AgHistogramSeriesOptions<>()
                .setxKey("value")
                .setBinCount(10)
                .setData(data);

        String json = new JavaScriptPart<>().objectAsString(series);

        assertTrue(json.contains("\"data\""), "Expected data property: " + json);
        assertTrue(json.contains("\"value\":42.5"), json);
    }

    @Test
    public void testHistogramWithDisplayNames()
    {
        AgHistogramSeriesOptions<?> series = new AgHistogramSeriesOptions<>()
                .setxKey("value")
                .setxName("Measurement")
                .setyName("Frequency Count");

        String json = new JavaScriptPart<>().objectAsString(series);

        assertTrue(json.contains("\"xName\":\"Measurement\"") || json.contains("\"x-name\":\"Measurement\""), json);
        assertTrue(json.contains("\"yName\":\"Frequency Count\"") || json.contains("\"y-name\":\"Frequency Count\""), json);
    }

    @Test
    public void testHistogramWithStyling()
    {
        AgHistogramSeriesOptions<?> series = new AgHistogramSeriesOptions<>()
                .setxKey("value")
                .setBinCount(20)
                .setFill("#4472C4")
                .setFillOpacity(0.85)
                .setStroke("#2E5090")
                .setStrokeWidth(1)
                .setStrokeOpacity(1.0)
                .setCornerRadius(2);

        String json = new JavaScriptPart<>().objectAsString(series);

        assertTrue(json.contains("\"fill\":\"#4472C4\""), json);
        assertTrue(json.contains("\"fillOpacity\":0.85") || json.contains("\"fill-opacity\":0.85"), json);
        assertTrue(json.contains("\"stroke\":\"#2E5090\""), json);
        assertTrue(json.contains("\"strokeWidth\":1") || json.contains("\"stroke-width\":1"), json);
        assertTrue(json.contains("\"cornerRadius\":2") || json.contains("\"corner-radius\":2"), json);
    }

    @Test
    public void testHistogramNullExclusion()
    {
        AgHistogramSeriesOptions<?> series = new AgHistogramSeriesOptions<>()
                .setxKey("value");

        String json = new JavaScriptPart<>().objectAsString(series);

        assertNoNullFields(json);
    }

    @Test
    public void testHistogramCompleteConfiguration()
    {
        List<Map<String, Object>> data = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            Map<String, Object> item = new HashMap<>();
            item.put("value", Math.random() * 100);
            data.add(item);
        }

        AgHistogramSeriesOptions<?> series = new AgHistogramSeriesOptions<>()
                .setxKey("value")
                .setBinCount(20)
                .setCumulative(false)
                .setxName("Measurement")
                .setyName("Frequency")
                .setFill("#4472C4")
                .setStroke("#2E5090")
                .setStrokeWidth(1)
                .setCornerRadius(2)
                .setData(data)
                .setVisible(true)
                .setShowInLegend(true);

        String json = new JavaScriptPart<>().objectAsString(series);

        assertTrue(json.contains("\"histogram\""), json);
        assertTrue(json.contains("\"xKey\""), json);
        assertTrue(json.contains("\"binCount\":20"), json);
        assertTrue(json.contains("\"cumulative\":false"), json);
        assertTrue(json.contains("\"fill\":\"#4472C4\""), json);
        assertTrue(json.contains("\"data\""), json);
        assertTrue(json.contains("\"visible\":true"), json);
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
