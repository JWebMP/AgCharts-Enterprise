package com.jwebmp.plugins.agchartsenterprise;

import com.jwebmp.plugins.agchartsenterprise.options.series.AgRadarLineSeriesOptions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Radar Line Series Tests")
class AgRadarLineSeriesTest
{
    @Test
    @DisplayName("Should create radar line series with basic configuration")
    void testBasicConfiguration()
    {
        AgRadarLineSeriesOptions<?> series = new AgRadarLineSeriesOptions<>()
                .setAngleKey("category")
                .setRadiusKey("value");

        assertEquals("radar-line", series.getType());
        assertEquals("category", series.getAngleKey());
        assertEquals("value", series.getRadiusKey());
    }

    @Test
    @DisplayName("Should configure radar line series with display names")
    void testDisplayNames()
    {
        AgRadarLineSeriesOptions<?> series = new AgRadarLineSeriesOptions<>()
                .setAngleKey("category")
                .setRadiusKey("value")
                .setAngleName("Category Name")
                .setRadiusName("Radius Name");

        assertEquals("Category Name", series.getAngleName());
        assertEquals("Radius Name", series.getRadiusName());
    }

    @Test
    @DisplayName("Should configure radar line series with data")
    void testDataConfiguration()
    {
        List<?> testData = List.of(
                new Object() { public String category = "A"; public double value = 10; },
                new Object() { public String category = "B"; public double value = 20; }
        );

        AgRadarLineSeriesOptions<?> series = new AgRadarLineSeriesOptions<>()
                .setAngleKey("category")
                .setRadiusKey("value")
                .setData(testData);

        assertNotNull(series.getData());
        assertEquals(testData, series.getData());
    }

    @Test
    @DisplayName("Should configure radar line series with line styling")
    void testLineStyleConfiguration()
    {
        AgRadarLineSeriesOptions<?> series = new AgRadarLineSeriesOptions<>()
                .setAngleKey("category")
                .setRadiusKey("value")
                .setStroke("#1f77b4")
                .setStrokeWidth(2)
                .setStrokeOpacity(0.8)
                .setLineDash(List.of(5, 5))
                .setLineDashOffset(3);

        assertEquals("#1f77b4", series.getStroke());
        assertEquals(2, series.getStrokeWidth());
        assertEquals(0.8, series.getStrokeOpacity());
        assertEquals(List.of(5, 5), series.getLineDash());
        assertEquals(3, series.getLineDashOffset());
    }

    @Test
    @DisplayName("Should configure radar line series with marker styling")
    void testMarkerStyleConfiguration()
    {
        AgRadarLineSeriesOptions<?> series = new AgRadarLineSeriesOptions<>()
                .setAngleKey("category")
                .setRadiusKey("value")
                .setMarkerFill("#ff7f0e")
                .setMarkerStroke("#d62728")
                .setMarkerSize(6);

        assertEquals("#ff7f0e", series.getMarkerFill());
        assertEquals("#d62728", series.getMarkerStroke());
        assertEquals(6, series.getMarkerSize());
    }

    @Test
    @DisplayName("Should configure radar line series visibility and display options")
    void testVisibilityConfiguration()
    {
        AgRadarLineSeriesOptions<?> series = new AgRadarLineSeriesOptions<>()
                .setAngleKey("category")
                .setRadiusKey("value")
                .setVisible(true)
                .setShowInLegend(true)
                .setShowInMiniChart(false);

        assertTrue(series.getVisible());
        assertTrue(series.getShowInLegend());
        assertFalse(series.getShowInMiniChart());
    }

    @Test
    @DisplayName("Should handle null values in radar line series configuration")
    void testNullExclusion()
    {
        AgRadarLineSeriesOptions<?> series = new AgRadarLineSeriesOptions<>()
                .setAngleKey("category")
                .setRadiusKey("value")
                .setAngleName(null)
                .setStroke(null);

        assertEquals("category", series.getAngleKey());
        assertEquals("value", series.getRadiusKey());
        assertNull(series.getAngleName());
        assertNull(series.getStroke());
    }

    @Test
    @DisplayName("Should support complete radar line series configuration with all properties")
    void testCompleteConfiguration()
    {
        List<?> testData = List.of(new Object());

        AgRadarLineSeriesOptions<?> series = new AgRadarLineSeriesOptions<>()
                .setAngleKey("category")
                .setRadiusKey("value")
                .setAngleName("Categories")
                .setRadiusName("Values")
                .setData(testData)
                .setVisible(true)
                .setShowInLegend(true)
                .setShowInMiniChart(true)
                .setStroke("#1f77b4")
                .setStrokeWidth(2)
                .setStrokeOpacity(0.9)
                .setLineDash(List.of(4, 4))
                .setLineDashOffset(2)
                .setMarkerFill("#ff7f0e")
                .setMarkerStroke("#d62728")
                .setMarkerSize(5)
                .setId("radar-line-1")
                .setCursor("pointer");

        assertEquals("radar-line", series.getType());
        assertEquals("category", series.getAngleKey());
        assertEquals("value", series.getRadiusKey());
        assertEquals("Categories", series.getAngleName());
        assertEquals("Values", series.getRadiusName());
        assertTrue(series.getVisible());
        assertEquals("#1f77b4", series.getStroke());
        assertEquals("#ff7f0e", series.getMarkerFill());
        assertEquals("radar-line-1", series.getId());
        assertEquals("pointer", series.getCursor());
    }
}
