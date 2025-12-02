package com.jwebmp.plugins.agchartsenterprise;

import com.jwebmp.plugins.agchartsenterprise.options.series.AgRadarAreaSeriesOptions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Radar Area Series Tests")
class AgRadarAreaSeriesTest
{
    @Test
    @DisplayName("Should create radar area series with basic configuration")
    void testBasicConfiguration()
    {
        AgRadarAreaSeriesOptions<?> series = new AgRadarAreaSeriesOptions<>()
                .setAngleKey("category")
                .setRadiusKey("value");

        assertEquals("radar-area", series.getType());
        assertEquals("category", series.getAngleKey());
        assertEquals("value", series.getRadiusKey());
    }

    @Test
    @DisplayName("Should configure radar area series with display names")
    void testDisplayNames()
    {
        AgRadarAreaSeriesOptions<?> series = new AgRadarAreaSeriesOptions<>()
                .setAngleKey("category")
                .setRadiusKey("value")
                .setAngleName("Category Name")
                .setRadiusName("Radius Name");

        assertEquals("Category Name", series.getAngleName());
        assertEquals("Radius Name", series.getRadiusName());
    }

    @Test
    @DisplayName("Should configure radar area series with data")
    void testDataConfiguration()
    {
        List<?> testData = List.of(
                new Object() { public String category = "A"; public double value = 10; },
                new Object() { public String category = "B"; public double value = 20; }
        );

        AgRadarAreaSeriesOptions<?> series = new AgRadarAreaSeriesOptions<>()
                .setAngleKey("category")
                .setRadiusKey("value")
                .setData(testData);

        assertNotNull(series.getData());
        assertEquals(testData, series.getData());
    }

    @Test
    @DisplayName("Should configure radar area series with fill styling")
    void testFillStyleConfiguration()
    {
        AgRadarAreaSeriesOptions<?> series = new AgRadarAreaSeriesOptions<>()
                .setAngleKey("category")
                .setRadiusKey("value")
                .setFill("#1f77b4")
                .setFillOpacity(0.6);

        assertEquals("#1f77b4", series.getFill());
        assertEquals(0.6, series.getFillOpacity());
    }

    @Test
    @DisplayName("Should configure radar area series with outline styling")
    void testOutlineStyleConfiguration()
    {
        AgRadarAreaSeriesOptions<?> series = new AgRadarAreaSeriesOptions<>()
                .setAngleKey("category")
                .setRadiusKey("value")
                .setStroke("#333333")
                .setStrokeWidth(2)
                .setStrokeOpacity(0.9)
                .setLineDash(List.of(5, 5))
                .setLineDashOffset(2);

        assertEquals("#333333", series.getStroke());
        assertEquals(2, series.getStrokeWidth());
        assertEquals(0.9, series.getStrokeOpacity());
        assertEquals(List.of(5, 5), series.getLineDash());
        assertEquals(2, series.getLineDashOffset());
    }

    @Test
    @DisplayName("Should configure radar area series with marker styling")
    void testMarkerStyleConfiguration()
    {
        AgRadarAreaSeriesOptions<?> series = new AgRadarAreaSeriesOptions<>()
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
    @DisplayName("Should configure radar area series visibility and display options")
    void testVisibilityConfiguration()
    {
        AgRadarAreaSeriesOptions<?> series = new AgRadarAreaSeriesOptions<>()
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
    @DisplayName("Should handle null values in radar area series configuration")
    void testNullExclusion()
    {
        AgRadarAreaSeriesOptions<?> series = new AgRadarAreaSeriesOptions<>()
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
    @DisplayName("Should support complete radar area series configuration with all properties")
    void testCompleteConfiguration()
    {
        List<?> testData = List.of(new Object());

        AgRadarAreaSeriesOptions<?> series = new AgRadarAreaSeriesOptions<>()
                .setAngleKey("category")
                .setRadiusKey("value")
                .setAngleName("Categories")
                .setRadiusName("Values")
                .setData(testData)
                .setVisible(true)
                .setShowInLegend(true)
                .setShowInMiniChart(true)
                .setFill("#1f77b4")
                .setFillOpacity(0.7)
                .setStroke("#333333")
                .setStrokeWidth(2)
                .setStrokeOpacity(0.9)
                .setLineDash(List.of(4, 4))
                .setLineDashOffset(1)
                .setMarkerFill("#ff7f0e")
                .setMarkerStroke("#d62728")
                .setMarkerSize(5)
                .setId("radar-area-1")
                .setCursor("pointer");

        assertEquals("radar-area", series.getType());
        assertEquals("category", series.getAngleKey());
        assertEquals("value", series.getRadiusKey());
        assertEquals("Categories", series.getAngleName());
        assertEquals("Values", series.getRadiusName());
        assertTrue(series.getVisible());
        assertEquals("#1f77b4", series.getFill());
        assertEquals(0.7, series.getFillOpacity());
        assertEquals("#ff7f0e", series.getMarkerFill());
        assertEquals("radar-area-1", series.getId());
    }
}
