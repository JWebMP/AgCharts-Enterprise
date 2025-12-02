package com.jwebmp.plugins.agchartsenterprise;

import com.jwebmp.plugins.agchartsenterprise.options.series.AgNightingaleSeriesOptions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Nightingale Series Tests")
class AgNightingaleSeriesTest
{
    @Test
    @DisplayName("Should create nightingale series with basic configuration")
    void testBasicConfiguration()
    {
        AgNightingaleSeriesOptions<?> series = new AgNightingaleSeriesOptions<>()
                .setAngleKey("category")
                .setRadiusKey("value");

        assertEquals("nightingale", series.getType());
        assertEquals("category", series.getAngleKey());
        assertEquals("value", series.getRadiusKey());
    }

    @Test
    @DisplayName("Should configure nightingale series with display names")
    void testDisplayNames()
    {
        AgNightingaleSeriesOptions<?> series = new AgNightingaleSeriesOptions<>()
                .setAngleKey("category")
                .setRadiusKey("value")
                .setAngleName("Category Name")
                .setRadiusName("Radius Name");

        assertEquals("Category Name", series.getAngleName());
        assertEquals("Radius Name", series.getRadiusName());
    }

    @Test
    @DisplayName("Should configure nightingale series with data")
    void testDataConfiguration()
    {
        List<?> testData = List.of(
                new Object() { public String category = "A"; public double value = 10; },
                new Object() { public String category = "B"; public double value = 20; }
        );

        AgNightingaleSeriesOptions<?> series = new AgNightingaleSeriesOptions<>()
                .setAngleKey("category")
                .setRadiusKey("value")
                .setData(testData);

        assertNotNull(series.getData());
        assertEquals(testData, series.getData());
    }

    @Test
    @DisplayName("Should configure nightingale series with fill styling")
    void testFillStyleConfiguration()
    {
        AgNightingaleSeriesOptions<?> series = new AgNightingaleSeriesOptions<>()
                .setAngleKey("category")
                .setRadiusKey("value")
                .setFill("#1f77b4")
                .setFillOpacity(0.6);

        assertEquals("#1f77b4", series.getFill());
        assertEquals(0.6, series.getFillOpacity());
    }

    @Test
    @DisplayName("Should configure nightingale series with outline styling")
    void testOutlineStyleConfiguration()
    {
        AgNightingaleSeriesOptions<?> series = new AgNightingaleSeriesOptions<>()
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
    @DisplayName("Should configure nightingale series with corner radius")
    void testCornerRadiusConfiguration()
    {
        AgNightingaleSeriesOptions<?> series = new AgNightingaleSeriesOptions<>()
                .setAngleKey("category")
                .setRadiusKey("value")
                .setCornerRadius(5);

        assertEquals(5, series.getCornerRadius());
    }

    @Test
    @DisplayName("Should configure nightingale series visibility and display options")
    void testVisibilityConfiguration()
    {
        AgNightingaleSeriesOptions<?> series = new AgNightingaleSeriesOptions<>()
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
    @DisplayName("Should handle null values in nightingale series configuration")
    void testNullExclusion()
    {
        AgNightingaleSeriesOptions<?> series = new AgNightingaleSeriesOptions<>()
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
    @DisplayName("Should support complete nightingale series configuration with all properties")
    void testCompleteConfiguration()
    {
        List<?> testData = List.of(new Object());

        AgNightingaleSeriesOptions<?> series = new AgNightingaleSeriesOptions<>()
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
                .setCornerRadius(4)
                .setId("nightingale-1")
                .setCursor("pointer");

        assertEquals("nightingale", series.getType());
        assertEquals("category", series.getAngleKey());
        assertEquals("value", series.getRadiusKey());
        assertEquals("Categories", series.getAngleName());
        assertEquals("Values", series.getRadiusName());
        assertTrue(series.getVisible());
        assertEquals("#1f77b4", series.getFill());
        assertEquals(0.7, series.getFillOpacity());
        assertEquals(4, series.getCornerRadius());
        assertEquals("nightingale-1", series.getId());
    }
}
