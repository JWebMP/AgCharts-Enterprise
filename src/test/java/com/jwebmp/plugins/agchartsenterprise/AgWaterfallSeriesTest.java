package com.jwebmp.plugins.agchartsenterprise;

import com.jwebmp.core.htmlbuilder.javascript.JavaScriptPart;
import com.jwebmp.plugins.agchartsenterprise.options.series.AgWaterfallSeriesOptions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Tests for Waterfall Series options serialization and configuration.
 *
 * Verifies that waterfall series serialize correctly to JSON with cumulative
 * flow data, including positive/negative and total bar styling.
 */
public class AgWaterfallSeriesTest
{
    @Test
    public void testWaterfallBasicConfiguration()
    {
        AgWaterfallSeriesOptions<?> series = new AgWaterfallSeriesOptions<>()
                .setxKey("category")
                .setValueKey("amount");

        String json = new JavaScriptPart<>().objectAsString(series);

        assertTrue(json.contains("\"waterfall\""), "Expected series type 'waterfall': " + json);
        assertTrue(json.contains("\"xKey\":\"category\"") || json.contains("\"x-key\":\"category\""), json);
        assertTrue(json.contains("\"valueKey\":\"amount\"") || json.contains("\"value-key\":\"amount\""), json);
    }

    @Test
    public void testWaterfallWithColors()
    {
        AgWaterfallSeriesOptions<?> series = new AgWaterfallSeriesOptions<>()
                .setxKey("category")
                .setValueKey("amount")
                .setFill("#00AA00")          // Green for positive
                .setNegativeFill("#CC0000") // Red for negative
                .setTotalFill("#0066CC");   // Blue for total

        String json = new JavaScriptPart<>().objectAsString(series);

        assertTrue(json.contains("\"fill\":\"#00AA00\""), json);
        assertTrue(json.contains("\"negativeFill\":\"#CC0000\"") || json.contains("\"negative-fill\":\"#CC0000\""), json);
        assertTrue(json.contains("\"totalFill\":\"#0066CC\"") || json.contains("\"total-fill\":\"#0066CC\""), json);
    }

    @Test
    public void testWaterfallWithData()
    {
        List<Map<String, Object>> data = new ArrayList<>();
        Map<String, Object> item1 = new HashMap<>();
        item1.put("category", "Starting");
        item1.put("amount", 100.0);
        data.add(item1);

        Map<String, Object> item2 = new HashMap<>();
        item2.put("category", "Revenue");
        item2.put("amount", 250.0);
        data.add(item2);

        AgWaterfallSeriesOptions<?> series = new AgWaterfallSeriesOptions<>()
                .setxKey("category")
                .setValueKey("amount")
                .setData(data);

        String json = new JavaScriptPart<>().objectAsString(series);

        assertTrue(json.contains("\"data\""), "Expected data property: " + json);
        assertTrue(json.contains("\"category\":\"Starting\""), json);
        assertTrue(json.contains("\"amount\":100"), json);
    }

    @Test
    public void testWaterfallWithDisplayNames()
    {
        AgWaterfallSeriesOptions<?> series = new AgWaterfallSeriesOptions<>()
                .setxKey("category")
                .setValueKey("amount")
                .setxName("Stage")
                .setValueName("Change Amount");

        String json = new JavaScriptPart<>().objectAsString(series);

        assertTrue(json.contains("\"xName\":\"Stage\"") || json.contains("\"x-name\":\"Stage\""), json);
        assertTrue(json.contains("\"valueName\":\"Change Amount\"") || json.contains("\"value-name\":\"Change Amount\""), json);
    }

    @Test
    public void testWaterfallWithStyling()
    {
        AgWaterfallSeriesOptions<?> series = new AgWaterfallSeriesOptions<>()
                .setxKey("category")
                .setValueKey("amount")
                .setCornerRadius(3)
                .setFillOpacity(0.8)
                .setNegativeFillOpacity(0.75)
                .setStroke("#333333")
                .setStrokeWidth(1)
                .setStrokeOpacity(1.0);

        String json = new JavaScriptPart<>().objectAsString(series);

        assertTrue(json.contains("\"cornerRadius\":3") || json.contains("\"corner-radius\":3"), json);
        assertTrue(json.contains("\"fillOpacity\":0.8") || json.contains("\"fill-opacity\":0.8"), json);
        assertTrue(json.contains("\"negativeFillOpacity\":0.75"), json);
        assertTrue(json.contains("\"stroke\":\"#333333\""), json);
    }

    @Test
    public void testWaterfallNullExclusion()
    {
        AgWaterfallSeriesOptions<?> series = new AgWaterfallSeriesOptions<>()
                .setxKey("category")
                .setValueKey("amount");

        String json = new JavaScriptPart<>().objectAsString(series);

        assertNoNullFields(json);
    }

    @Test
    public void testWaterfallCompleteConfiguration()
    {
        List<Map<String, Object>> data = new ArrayList<>();
        Map<String, Object> item = new HashMap<>();
        item.put("category", "Q1");
        item.put("amount", 150.0);
        data.add(item);

        AgWaterfallSeriesOptions<?> series = new AgWaterfallSeriesOptions<>()
                .setxKey("category")
                .setValueKey("amount")
                .setxName("Quarter")
                .setValueName("Net Change")
                .setFill("#00AA00")
                .setNegativeFill("#CC0000")
                .setTotalFill("#0066CC")
                .setStroke("#333333")
                .setStrokeWidth(1)
                .setCornerRadius(3)
                .setData(data)
                .setVisible(true)
                .setShowInLegend(true);

        String json = new JavaScriptPart<>().objectAsString(series);

        assertTrue(json.contains("\"waterfall\""), json);
        assertTrue(json.contains("\"xKey\""), json);
        assertTrue(json.contains("\"valueKey\""), json);
        assertTrue(json.contains("\"fill\":\"#00AA00\""), json);
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
