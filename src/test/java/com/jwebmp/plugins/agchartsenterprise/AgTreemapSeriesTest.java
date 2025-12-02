package com.jwebmp.plugins.agchartsenterprise;

import com.jwebmp.plugins.agchartsenterprise.options.series.AgTreemapSeriesOptions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for AgTreemapSeriesOptions.
 */
class AgTreemapSeriesTest
{
    private AgTreemapSeriesOptions<?> options;

    @BeforeEach
    void setUp()
    {
        options = new AgTreemapSeriesOptions<>();
    }

    @Test
    void testBasicConfiguration()
    {
        assertNotNull(options);
        assertEquals("treemap", options.getType());
    }

    @Test
    void testLabelAndValueProperties()
    {
        options.setLabelKey("name")
               .setValueKey("size");

        assertEquals("name", options.getLabelKey());
        assertEquals("size", options.getValueKey());
    }

    @Test
    void testSecondaryLabelAndColorProperties()
    {
        options.setSecondaryLabelKey("category")
               .setColorKey("performance");

        assertEquals("category", options.getSecondaryLabelKey());
        assertEquals("performance", options.getColorKey());
    }

    @Test
    void testDisplayNames()
    {
        options.setLabelName("Name")
               .setSecondaryLabelName("Category")
               .setValueName("Size")
               .setColorName("Performance");

        assertEquals("Name", options.getLabelName());
        assertEquals("Category", options.getSecondaryLabelName());
        assertEquals("Size", options.getValueName());
        assertEquals("Performance", options.getColorName());
    }

    @Test
    void testDataBinding()
    {
        List<?> mockData = List.of();
        options.setData(mockData);
        assertEquals(mockData, options.getData());
    }

    @Test
    void testRectangleStyling()
    {
        options.setFill("#FF6B6B")
               .setFillOpacity(0.85)
               .setStroke("#333333")
               .setStrokeWidth(2)
               .setCornerRadius(4);

        assertEquals("#FF6B6B", options.getFill());
        assertEquals(0.85, options.getFillOpacity());
        assertEquals("#333333", options.getStroke());
        assertEquals(2, options.getStrokeWidth());
        assertEquals(4, options.getCornerRadius());
    }

    @Test
    void testColorScaling()
    {
        options.setColorScale("viridis")
               .setColorDomain(100.0);

        assertEquals("viridis", options.getColorScale());
        assertEquals(100.0, options.getColorDomain());
    }

    @Test
    void testVisibilityProperties()
    {
        options.setVisible(true)
               .setShowInLegend(true)
               .setShowInMiniChart(false);

        assertTrue(options.getVisible());
        assertTrue(options.getShowInLegend());
        assertFalse(options.getShowInMiniChart());
    }

    @Test
    void testCompleteConfiguration()
    {
        options.setType("treemap")
               .setLabelKey("name")
               .setSecondaryLabelKey("category")
               .setValueKey("size")
               .setColorKey("performance")
               .setLabelName("Item")
               .setSecondaryLabelName("Category")
               .setValueName("Size")
               .setColorName("Performance")
               .setVisible(true)
               .setShowInLegend(true)
               .setShowInMiniChart(true)
               .setFill("#3498db")
               .setFillOpacity(0.8)
               .setStroke("#2c3e50")
               .setStrokeWidth(1)
               .setCornerRadius(3)
               .setColorScale("turbo")
               .setColorDomain(100.0);

        assertEquals("treemap", options.getType());
        assertEquals("name", options.getLabelKey());
        assertEquals("category", options.getSecondaryLabelKey());
        assertEquals("size", options.getValueKey());
        assertEquals("performance", options.getColorKey());
    }
}
