package com.jwebmp.plugins.agchartsenterprise;

import com.jwebmp.core.htmlbuilder.javascript.JavaScriptPart;
import com.jwebmp.plugins.agchartsenterprise.options.series.AgRangeAreaSeriesOptions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Tests for Range Area Series options serialization and configuration.
 *
 * Verifies that range area series serialize correctly to JSON with min-max range data,
 * including opacity and styling customizations for area visualization.
 */
public class AgRangeAreaSeriesTest
{
    @Test
    public void testRangeAreaBasicConfiguration()
    {
        AgRangeAreaSeriesOptions<?> series = new AgRangeAreaSeriesOptions<>()
                .setxKey("date")
                .setyLowKey("low")
                .setyHighKey("high");

        String json = new JavaScriptPart<>().objectAsString(series);

        assertTrue(json.contains("\"range-area\""), "Expected series type 'range-area': " + json);
        assertTrue(json.contains("\"xKey\":\"date\"") || json.contains("\"x-key\":\"date\""), json);
        assertTrue(json.contains("\"yLowKey\":\"low\"") || json.contains("\"y-low-key\":\"low\""), json);
        assertTrue(json.contains("\"yHighKey\":\"high\"") || json.contains("\"y-high-key\":\"high\""), json);
    }

    @Test
    public void testRangeAreaWithColors()
    {
        AgRangeAreaSeriesOptions<?> series = new AgRangeAreaSeriesOptions<>()
                .setxKey("date")
                .setyLowKey("low")
                .setyHighKey("high")
                .setFill("#FF6B6B")     // Red fill for confidence band
                .setStroke("#CC0000"); // Dark red outline

        String json = new JavaScriptPart<>().objectAsString(series);

        assertTrue(json.contains("\"fill\":\"#FF6B6B\""), json);
        assertTrue(json.contains("\"stroke\":\"#CC0000\""), json);
    }

    @Test
    public void testRangeAreaWithData()
    {
        List<Map<String, Object>> data = new ArrayList<>();
        Map<String, Object> point1 = new HashMap<>();
        point1.put("date", "2025-01-01");
        point1.put("low", 15.5);
        point1.put("high", 25.3);
        data.add(point1);

        Map<String, Object> point2 = new HashMap<>();
        point2.put("date", "2025-01-02");
        point2.put("low", 14.8);
        point2.put("high", 26.1);
        data.add(point2);

        AgRangeAreaSeriesOptions<?> series = new AgRangeAreaSeriesOptions<>()
                .setxKey("date")
                .setyLowKey("low")
                .setyHighKey("high")
                .setData(data);

        String json = new JavaScriptPart<>().objectAsString(series);

        assertTrue(json.contains("\"data\""), "Expected data property: " + json);
        assertTrue(json.contains("\"date\":\"2025-01-01\""), json);
        assertTrue(json.contains("\"low\":15.5"), json);
        assertTrue(json.contains("\"high\":25.3"), json);
    }

    @Test
    public void testRangeAreaWithDisplayNames()
    {
        AgRangeAreaSeriesOptions<?> series = new AgRangeAreaSeriesOptions<>()
                .setxKey("date")
                .setyLowKey("low")
                .setyHighKey("high")
                .setxName("Date")
                .setyLowName("Lower Bound")
                .setyHighName("Upper Bound");

        String json = new JavaScriptPart<>().objectAsString(series);

        assertTrue(json.contains("\"xName\":\"Date\"") || json.contains("\"x-name\":\"Date\""), json);
        assertTrue(json.contains("\"yLowName\":\"Lower Bound\"") || json.contains("\"y-low-name\":\"Lower Bound\""), json);
        assertTrue(json.contains("\"yHighName\":\"Upper Bound\"") || json.contains("\"y-high-name\":\"Upper Bound\""), json);
    }

    @Test
    public void testRangeAreaWithStyling()
    {
        AgRangeAreaSeriesOptions<?> series = new AgRangeAreaSeriesOptions<>()
                .setxKey("date")
                .setyLowKey("low")
                .setyHighKey("high")
                .setFillOpacity(0.3)  // Transparent area for confidence band
                .setStroke("#CC0000")
                .setStrokeWidth(2)
                .setStrokeOpacity(1.0);

        String json = new JavaScriptPart<>().objectAsString(series);

        assertTrue(json.contains("\"fillOpacity\":0.3") || json.contains("\"fill-opacity\":0.3"), json);
        assertTrue(json.contains("\"stroke\":\"#CC0000\""), json);
        assertTrue(json.contains("\"strokeWidth\":2") || json.contains("\"stroke-width\":2"), json);
        assertTrue(json.contains("\"strokeOpacity\":1.0") || json.contains("\"stroke-opacity\":1.0"), json);
    }

    @Test
    public void testRangeAreaNullExclusion()
    {
        // Test that null values are not serialized (JsonInclude.NON_NULL)
        AgRangeAreaSeriesOptions<?> series = new AgRangeAreaSeriesOptions<>()
                .setxKey("date")
                .setyLowKey("low")
                .setyHighKey("high");
        // Don't set optional fields

        String json = new JavaScriptPart<>().objectAsString(series);

        // Should not contain nulls or undefined optional fields
        assertNoNullFields(json);
    }

    @Test
    public void testRangeAreaCompleteConfiguration()
    {
        List<Map<String, Object>> data = new ArrayList<>();
        Map<String, Object> point = new HashMap<>();
        point.put("date", "2025-01-01");
        point.put("low", 15.5);
        point.put("high", 25.3);
        data.add(point);

        AgRangeAreaSeriesOptions<?> series = new AgRangeAreaSeriesOptions<>()
                .setxKey("date")
                .setyLowKey("low")
                .setyHighKey("high")
                .setxName("Date")
                .setyLowName("Lower Bound")
                .setyHighName("Upper Bound")
                .setFill("#FF6B6B")
                .setStroke("#CC0000")
                .setFillOpacity(0.3)
                .setStrokeWidth(2)
                .setStrokeOpacity(1.0)
                .setData(data)
                .setVisible(true)
                .setShowInMiniChart(true)
                .setShowInLegend(true);

        String json = new JavaScriptPart<>().objectAsString(series);

        // Verify all major properties are present
        assertTrue(json.contains("\"range-area\""), json);
        assertTrue(json.contains("\"xKey\""), json);
        assertTrue(json.contains("\"yLowKey\""), json);
        assertTrue(json.contains("\"yHighKey\""), json);
        assertTrue(json.contains("\"fill\":\"#FF6B6B\""), json);
        assertTrue(json.contains("\"fillOpacity\":0.3"), json);
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
