package com.jwebmp.plugins.agchartsenterprise;

import com.jwebmp.core.htmlbuilder.javascript.JavaScriptPart;
import com.jwebmp.plugins.agchartsenterprise.options.series.AgOhlcSeriesOptions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Tests for OHLC Series options serialization and configuration.
 *
 * Verifies that OHLC series serialize correctly to JSON with OHLC data,
 * including up/down color configuration and line styling options.
 */
public class AgOhlcSeriesTest
{
    @Test
    public void testOhlcBasicConfiguration()
    {
        AgOhlcSeriesOptions<?> series = new AgOhlcSeriesOptions<>()
                .setDateKey("date")
                .setOpenKey("open")
                .setCloseKey("close")
                .setHighKey("high")
                .setLowKey("low");

        String json = new JavaScriptPart<>().objectAsString(series);

        assertTrue(json.contains("\"ohlc\""), "Expected series type 'ohlc': " + json);
        assertTrue(json.contains("\"dateKey\":\"date\"") || json.contains("\"date-key\":\"date\""), json);
        assertTrue(json.contains("\"openKey\":\"open\"") || json.contains("\"open-key\":\"open\""), json);
    }

    @Test
    public void testOhlcWithColors()
    {
        AgOhlcSeriesOptions<?> series = new AgOhlcSeriesOptions<>()
                .setDateKey("date")
                .setOpenKey("open")
                .setCloseKey("close")
                .setHighKey("high")
                .setLowKey("low")
                .setUpColor("#2196F3")    // Blue for bullish
                .setDownColor("#F44336"); // Red for bearish

        String json = new JavaScriptPart<>().objectAsString(series);

        assertTrue(json.contains("\"upColor\":\"#2196F3\"") || json.contains("\"up-color\":\"#2196F3\""), json);
        assertTrue(json.contains("\"downColor\":\"#F44336\"") || json.contains("\"down-color\":\"#F44336\""), json);
    }

    @Test
    public void testOhlcWithData()
    {
        List<Map<String, Object>> data = new ArrayList<>();
        Map<String, Object> point = new HashMap<>();
        point.put("date", "2025-01-01");
        point.put("open", 100.0);
        point.put("close", 103.0);
        point.put("high", 105.0);
        point.put("low", 99.5);
        data.add(point);

        AgOhlcSeriesOptions<?> series = new AgOhlcSeriesOptions<>()
                .setDateKey("date")
                .setOpenKey("open")
                .setCloseKey("close")
                .setHighKey("high")
                .setLowKey("low")
                .setData(data);

        String json = new JavaScriptPart<>().objectAsString(series);

        assertTrue(json.contains("\"data\""), "Expected data property: " + json);
        assertTrue(json.contains("2025-01-01"), json);
        assertTrue(json.contains("\"open\":100"), json);
    }

    @Test
    public void testOhlcWithLineStying()
    {
        AgOhlcSeriesOptions<?> series = new AgOhlcSeriesOptions<>()
                .setDateKey("date")
                .setOpenKey("open")
                .setCloseKey("close")
                .setHighKey("high")
                .setLowKey("low")
                .setStrokeWidth(2)
                .setStrokeOpacity(0.95)
                .setFillOpacity(0.7);

        String json = new JavaScriptPart<>().objectAsString(series);

        assertTrue(json.contains("\"strokeWidth\":2") || json.contains("\"stroke-width\":2"), json);
        assertTrue(json.contains("\"strokeOpacity\":0.95") || json.contains("\"stroke-opacity\":0.95"), json);
        assertTrue(json.contains("\"fillOpacity\":0.7") || json.contains("\"fill-opacity\":0.7"), json);
    }

    @Test
    public void testOhlcWithDisplayNames()
    {
        AgOhlcSeriesOptions<?> series = new AgOhlcSeriesOptions<>()
                .setDateKey("date")
                .setOpenKey("open")
                .setCloseKey("close")
                .setHighKey("high")
                .setLowKey("low")
                .setDateName("Date")
                .setOpenName("O")
                .setCloseName("C")
                .setHighName("H")
                .setLowName("L");

        String json = new JavaScriptPart<>().objectAsString(series);

        assertTrue(json.contains("\"openName\":\"O\"") || json.contains("\"open-name\":\"O\""), json);
        assertTrue(json.contains("\"closeName\":\"C\"") || json.contains("\"close-name\":\"C\""), json);
    }

    @Test
    public void testOhlcNullExclusion()
    {
        // Test that null values are not serialized (JsonInclude.NON_NULL)
        AgOhlcSeriesOptions<?> series = new AgOhlcSeriesOptions<>()
                .setDateKey("date")
                .setOpenKey("open")
                .setCloseKey("close")
                .setHighKey("high")
                .setLowKey("low");
        // Don't set optional fields

        String json = new JavaScriptPart<>().objectAsString(series);

        // Should not contain nulls or undefined optional fields
        assertNoNullFields(json);
    }

    @Test
    public void testOhlcVisibility()
    {
        AgOhlcSeriesOptions<?> series = new AgOhlcSeriesOptions<>()
                .setDateKey("date")
                .setOpenKey("open")
                .setCloseKey("close")
                .setHighKey("high")
                .setLowKey("low")
                .setVisible(true)
                .setShowInMiniChart(true)
                .setShowInLegend(true);

        String json = new JavaScriptPart<>().objectAsString(series);

        assertTrue(json.contains("\"visible\":true"), json);
    }

    @Test
    public void testOhlcCompleteConfiguration()
    {
        List<Map<String, Object>> data = new ArrayList<>();
        for (int i = 0; i < 3; i++)
        {
            Map<String, Object> point = new HashMap<>();
            point.put("date", "2025-01-0" + (i + 1));
            point.put("open", 100.0 + i);
            point.put("close", 103.0 + i);
            point.put("high", 105.0 + i);
            point.put("low", 99.0 + i);
            data.add(point);
        }

        AgOhlcSeriesOptions<?> series = new AgOhlcSeriesOptions<>()
                .setDateKey("date")
                .setOpenKey("open")
                .setCloseKey("close")
                .setHighKey("high")
                .setLowKey("low")
                .setDateName("Trading Date")
                .setOpenName("Opening")
                .setCloseName("Closing")
                .setHighName("Daily High")
                .setLowName("Daily Low")
                .setUpColor("#4CAF50")
                .setDownColor("#F44336")
                .setData(data)
                .setVisible(true)
                .setShowInMiniChart(true)
                .setStrokeWidth(1)
                .setStrokeOpacity(1.0)
                .setFillOpacity(0.8);

        String json = new JavaScriptPart<>().objectAsString(series);

        // Verify key properties
        assertTrue(json.contains("\"ohlc\""), json);
        assertTrue(json.contains("\"dateKey\":\"date\""), json);
        assertTrue(json.contains("\"upColor\":\"#4CAF50\""), json);
        assertTrue(json.contains("\"downColor\":\"#F44336\""), json);
        assertTrue(json.contains("\"data\""), json);
        assertTrue(json.contains("2025-01-01"), json);
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
