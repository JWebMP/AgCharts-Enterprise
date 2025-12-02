package com.jwebmp.plugins.agchartsenterprise;

import com.jwebmp.core.htmlbuilder.javascript.JavaScriptPart;
import com.jwebmp.plugins.agchartsenterprise.options.series.AgCandlestickSeriesOptions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Tests for Candlestick Series options serialization and configuration.
 *
 * Verifies that candlestick series serialize correctly to JSON with OHLC data,
 * including color configuration for up/down days and styling options.
 */
public class AgCandlestickSeriesTest
{
    @Test
    public void testCandlestickBasicConfiguration()
    {
        AgCandlestickSeriesOptions<?> series = new AgCandlestickSeriesOptions<>()
                .setDateKey("date")
                .setOpenKey("open")
                .setCloseKey("close")
                .setHighKey("high")
                .setLowKey("low");

        String json = new JavaScriptPart<>().objectAsString(series);

        assertTrue(json.contains("\"candlestick\""), "Expected series type 'candlestick': " + json);
        assertTrue(json.contains("\"dateKey\":\"date\"") || json.contains("\"date-key\":\"date\""), json);
        assertTrue(json.contains("\"openKey\":\"open\"") || json.contains("\"open-key\":\"open\""), json);
        assertTrue(json.contains("\"closeKey\":\"close\"") || json.contains("\"close-key\":\"close\""), json);
        assertTrue(json.contains("\"highKey\":\"high\"") || json.contains("\"high-key\":\"high\""), json);
        assertTrue(json.contains("\"lowKey\":\"low\"") || json.contains("\"low-key\":\"low\""), json);
    }

    @Test
    public void testCandlestickWithColors()
    {
        AgCandlestickSeriesOptions<?> series = new AgCandlestickSeriesOptions<>()
                .setDateKey("date")
                .setOpenKey("open")
                .setCloseKey("close")
                .setHighKey("high")
                .setLowKey("low")
                .setUpColor("#00AA00")    // Green for bullish
                .setDownColor("#CC0000"); // Red for bearish

        String json = new JavaScriptPart<>().objectAsString(series);

        assertTrue(json.contains("\"upColor\":\"#00AA00\"") || json.contains("\"up-color\":\"#00AA00\""), json);
        assertTrue(json.contains("\"downColor\":\"#CC0000\"") || json.contains("\"down-color\":\"#CC0000\""), json);
    }

    @Test
    public void testCandlestickWithData()
    {
        List<Map<String, Object>> data = new ArrayList<>();
        Map<String, Object> point1 = new HashMap<>();
        point1.put("date", "2025-01-01");
        point1.put("open", 100.0);
        point1.put("close", 105.0);
        point1.put("high", 106.0);
        point1.put("low", 99.0);
        data.add(point1);

        AgCandlestickSeriesOptions<?> series = new AgCandlestickSeriesOptions<>()
                .setDateKey("date")
                .setOpenKey("open")
                .setCloseKey("close")
                .setHighKey("high")
                .setLowKey("low")
                .setData(data);

        String json = new JavaScriptPart<>().objectAsString(series);

        assertTrue(json.contains("\"data\""), "Expected data property: " + json);
        assertTrue(json.contains("\"date\":\"2025-01-01\""), json);
        assertTrue(json.contains("\"open\":100"), json);
    }

    @Test
    public void testCandlestickWithDisplayNames()
    {
        AgCandlestickSeriesOptions<?> series = new AgCandlestickSeriesOptions<>()
                .setDateKey("date")
                .setOpenKey("open")
                .setCloseKey("close")
                .setHighKey("high")
                .setLowKey("low")
                .setDateName("Trade Date")
                .setOpenName("Opening Price")
                .setCloseName("Closing Price")
                .setHighName("High Price")
                .setLowName("Low Price");

        String json = new JavaScriptPart<>().objectAsString(series);

        assertTrue(json.contains("\"dateName\":\"Trade Date\"") || json.contains("\"date-name\":\"Trade Date\""), json);
        assertTrue(json.contains("\"openName\":\"Opening Price\"") || json.contains("\"open-name\":\"Opening Price\""), json);
        assertTrue(json.contains("\"closeName\":\"Closing Price\"") || json.contains("\"close-name\":\"Closing Price\""), json);
    }

    @Test
    public void testCandlestickWithStyling()
    {
        AgCandlestickSeriesOptions<?> series = new AgCandlestickSeriesOptions<>()
                .setDateKey("date")
                .setOpenKey("open")
                .setCloseKey("close")
                .setHighKey("high")
                .setLowKey("low")
                .setCornerRadius(3)
                .setFillOpacity(0.8)
                .setStroke("#333333")
                .setStrokeWidth(2)
                .setStrokeOpacity(0.9);

        String json = new JavaScriptPart<>().objectAsString(series);

        assertTrue(json.contains("\"cornerRadius\":3") || json.contains("\"corner-radius\":3"), json);
        assertTrue(json.contains("\"fillOpacity\":0.8") || json.contains("\"fill-opacity\":0.8"), json);
        assertTrue(json.contains("\"stroke\":\"#333333\""), json);
        assertTrue(json.contains("\"strokeWidth\":2") || json.contains("\"stroke-width\":2"), json);
    }

    @Test
    public void testCandlestickNullExclusion()
    {
        // Test that null values are not serialized (JsonInclude.NON_NULL)
        AgCandlestickSeriesOptions<?> series = new AgCandlestickSeriesOptions<>()
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
    public void testCandlestickCompleteConfiguration()
    {
        List<Map<String, Object>> data = new ArrayList<>();
        Map<String, Object> point = new HashMap<>();
        point.put("date", "2025-01-01");
        point.put("open", 100.0);
        point.put("close", 105.0);
        point.put("high", 106.0);
        point.put("low", 99.0);
        data.add(point);

        AgCandlestickSeriesOptions<?> series = new AgCandlestickSeriesOptions<>()
                .setDateKey("date")
                .setOpenKey("open")
                .setCloseKey("close")
                .setHighKey("high")
                .setLowKey("low")
                .setDateName("Trade Date")
                .setOpenName("Open")
                .setCloseName("Close")
                .setHighName("High")
                .setLowName("Low")
                .setUpColor("#00AA00")
                .setDownColor("#CC0000")
                .setData(data)
                .setVisible(true)
                .setShowInMiniChart(true)
                .setCornerRadius(3)
                .setFillOpacity(0.85)
                .setStroke("#1a1a1a")
                .setStrokeWidth(1)
                .setStrokeOpacity(1.0);

        String json = new JavaScriptPart<>().objectAsString(series);

        // Verify all major properties are present
        assertTrue(json.contains("\"candlestick\""), json);
        assertTrue(json.contains("\"dateKey\""), json);
        assertTrue(json.contains("\"upColor\":\"#00AA00\""), json);
        assertTrue(json.contains("\"downColor\":\"#CC0000\""), json);
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
