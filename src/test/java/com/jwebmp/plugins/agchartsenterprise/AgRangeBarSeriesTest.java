package com.jwebmp.plugins.agchartsenterprise;

import com.jwebmp.core.htmlbuilder.javascript.JavaScriptPart;
import com.jwebmp.plugins.agchartsenterprise.options.series.AgRangeBarSeriesOptions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Tests for Range Bar Series options serialization and configuration.
 *
 * Verifies that range bar series serialize correctly to JSON with min-max data,
 * including styling and visual customization options.
 */
public class AgRangeBarSeriesTest
{
    @Test
    public void testRangeBarBasicConfiguration()
    {
        AgRangeBarSeriesOptions<?> series = new AgRangeBarSeriesOptions<>()
                .setxKey("category")
                .setyLowKey("minValue")
                .setyHighKey("maxValue");

        String json = new JavaScriptPart<>().objectAsString(series);

        assertTrue(json.contains("\"range-bar\""), "Expected series type 'range-bar': " + json);
        assertTrue(json.contains("\"xKey\":\"category\"") || json.contains("\"x-key\":\"category\""), json);
        assertTrue(json.contains("\"yLowKey\":\"minValue\"") || json.contains("\"y-low-key\":\"minValue\""), json);
        assertTrue(json.contains("\"yHighKey\":\"maxValue\"") || json.contains("\"y-high-key\":\"maxValue\""), json);
    }

    @Test
    public void testRangeBarWithColors()
    {
        AgRangeBarSeriesOptions<?> series = new AgRangeBarSeriesOptions<>()
                .setxKey("category")
                .setyLowKey("minValue")
                .setyHighKey("maxValue")
                .setFill("#0066CC")     // Blue fill
                .setStroke("#004499"); // Dark blue outline

        String json = new JavaScriptPart<>().objectAsString(series);

        assertTrue(json.contains("\"fill\":\"#0066CC\""), json);
        assertTrue(json.contains("\"stroke\":\"#004499\""), json);
    }

    @Test
    public void testRangeBarWithData()
    {
        List<Map<String, Object>> data = new ArrayList<>();
        Map<String, Object> item1 = new HashMap<>();
        item1.put("category", "Q1");
        item1.put("minValue", 10.0);
        item1.put("maxValue", 50.0);
        data.add(item1);

        Map<String, Object> item2 = new HashMap<>();
        item2.put("category", "Q2");
        item2.put("minValue", 15.0);
        item2.put("maxValue", 55.0);
        data.add(item2);

        AgRangeBarSeriesOptions<?> series = new AgRangeBarSeriesOptions<>()
                .setxKey("category")
                .setyLowKey("minValue")
                .setyHighKey("maxValue")
                .setData(data);

        String json = new JavaScriptPart<>().objectAsString(series);

        assertTrue(json.contains("\"data\""), "Expected data property: " + json);
        assertTrue(json.contains("\"category\":\"Q1\""), json);
        assertTrue(json.contains("\"minValue\":10"), json);
        assertTrue(json.contains("\"maxValue\":50"), json);
    }

    @Test
    public void testRangeBarWithDisplayNames()
    {
        AgRangeBarSeriesOptions<?> series = new AgRangeBarSeriesOptions<>()
                .setxKey("category")
                .setyLowKey("minValue")
                .setyHighKey("maxValue")
                .setxName("Product")
                .setyLowName("Minimum Sales")
                .setyHighName("Maximum Sales");

        String json = new JavaScriptPart<>().objectAsString(series);

        assertTrue(json.contains("\"xName\":\"Product\"") || json.contains("\"x-name\":\"Product\""), json);
        assertTrue(json.contains("\"yLowName\":\"Minimum Sales\"") || json.contains("\"y-low-name\":\"Minimum Sales\""), json);
        assertTrue(json.contains("\"yHighName\":\"Maximum Sales\"") || json.contains("\"y-high-name\":\"Maximum Sales\""), json);
    }

    @Test
    public void testRangeBarWithStyling()
    {
        AgRangeBarSeriesOptions<?> series = new AgRangeBarSeriesOptions<>()
                .setxKey("category")
                .setyLowKey("minValue")
                .setyHighKey("maxValue")
                .setCornerRadius(5)
                .setFillOpacity(0.75)
                .setStroke("#333333")
                .setStrokeWidth(2)
                .setStrokeOpacity(0.95);

        String json = new JavaScriptPart<>().objectAsString(series);

        assertTrue(json.contains("\"cornerRadius\":5") || json.contains("\"corner-radius\":5"), json);
        assertTrue(json.contains("\"fillOpacity\":0.75") || json.contains("\"fill-opacity\":0.75"), json);
        assertTrue(json.contains("\"stroke\":\"#333333\""), json);
        assertTrue(json.contains("\"strokeWidth\":2") || json.contains("\"stroke-width\":2"), json);
        assertTrue(json.contains("\"strokeOpacity\":0.95") || json.contains("\"stroke-opacity\":0.95"), json);
    }

    @Test
    public void testRangeBarNullExclusion()
    {
        // Test that null values are not serialized (JsonInclude.NON_NULL)
        AgRangeBarSeriesOptions<?> series = new AgRangeBarSeriesOptions<>()
                .setxKey("category")
                .setyLowKey("minValue")
                .setyHighKey("maxValue");
        // Don't set optional fields

        String json = new JavaScriptPart<>().objectAsString(series);

        // Should not contain nulls or undefined optional fields
        assertNoNullFields(json);
    }

    @Test
    public void testRangeBarCompleteConfiguration()
    {
        List<Map<String, Object>> data = new ArrayList<>();
        Map<String, Object> item = new HashMap<>();
        item.put("category", "Q1");
        item.put("minValue", 10.0);
        item.put("maxValue", 50.0);
        data.add(item);

        AgRangeBarSeriesOptions<?> series = new AgRangeBarSeriesOptions<>()
                .setxKey("category")
                .setyLowKey("minValue")
                .setyHighKey("maxValue")
                .setxName("Product")
                .setyLowName("Minimum Sales")
                .setyHighName("Maximum Sales")
                .setFill("#0066CC")
                .setStroke("#004499")
                .setCornerRadius(5)
                .setFillOpacity(0.8)
                .setStrokeWidth(2)
                .setStrokeOpacity(1.0)
                .setData(data)
                .setVisible(true)
                .setShowInMiniChart(true)
                .setShowInLegend(true);

        String json = new JavaScriptPart<>().objectAsString(series);

        // Verify all major properties are present
        assertTrue(json.contains("\"range-bar\""), json);
        assertTrue(json.contains("\"xKey\""), json);
        assertTrue(json.contains("\"yLowKey\""), json);
        assertTrue(json.contains("\"yHighKey\""), json);
        assertTrue(json.contains("\"fill\":\"#0066CC\""), json);
        assertTrue(json.contains("\"stroke\":\"#004499\""), json);
        assertTrue(json.contains("\"data\""), json);
        assertTrue(json.contains("\"visible\":true"), json);
    }

    /**
     * Helper to verify that null values are properly excluded from JSON serialization.
     */
    private void assertNoNullFields(String json)
    {
        assertTrue(!json.contains(":null"), "JSON should not contain null values: " + json);
        assertTrue(!json.contains("undefined"), "JSON should not contain undefined: " + json);
    }
}
