package com.jwebmp.plugins.agchartsenterprise;

import com.jwebmp.plugins.agchartsenterprise.options.series.AgSunburstSeriesOptions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for AgSunburstSeriesOptions.
 */
class AgSunburstSeriesTest
{
    private AgSunburstSeriesOptions<?> options;

    @BeforeEach
    void setUp()
    {
        options = new AgSunburstSeriesOptions<>();
    }

    @Test
    void testBasicConfiguration()
    {
        assertNotNull(options);
        assertEquals("sunburst", options.getType());
    }

    @Test
    void testLabelAndValueProperties()
    {
        options.setLabelKey("name")
               .setValueKey("value");

        assertEquals("name", options.getLabelKey());
        assertEquals("value", options.getValueKey());
    }

    @Test
    void testColorProperty()
    {
        options.setColorKey("metric");

        assertEquals("metric", options.getColorKey());
    }

    @Test
    void testDisplayNames()
    {
        options.setLabelName("Label")
               .setValueName("Value")
               .setColorName("Metric");

        assertEquals("Label", options.getLabelName());
        assertEquals("Value", options.getValueName());
        assertEquals("Metric", options.getColorName());
    }

    @Test
    void testDataBinding()
    {
        List<?> mockData = List.of();
        options.setData(mockData);
        assertEquals(mockData, options.getData());
    }

    @Test
    void testSegmentStyling()
    {
        options.setFill("#9467bd")
               .setFillOpacity(0.9)
               .setStroke("#1f77b4")
               .setStrokeWidth(1)
               .setCornerRadius(2);

        assertEquals("#9467bd", options.getFill());
        assertEquals(0.9, options.getFillOpacity());
        assertEquals("#1f77b4", options.getStroke());
        assertEquals(1, options.getStrokeWidth());
        assertEquals(2, options.getCornerRadius());
    }

    @Test
    void testColorScaling()
    {
        options.setColorScale("plasma")
               .setColorDomain(50.0);

        assertEquals("plasma", options.getColorScale());
        assertEquals(50.0, options.getColorDomain());
    }

    @Test
    void testVisibilityProperties()
    {
        options.setVisible(true)
               .setShowInLegend(false)
               .setShowInMiniChart(true);

        assertTrue(options.getVisible());
        assertFalse(options.getShowInLegend());
        assertTrue(options.getShowInMiniChart());
    }

    @Test
    void testCompleteConfiguration()
    {
        options.setType("sunburst")
               .setLabelKey("label")
               .setValueKey("amount")
               .setColorKey("category")
               .setLabelName("Label")
               .setValueName("Amount")
               .setColorName("Category")
               .setVisible(true)
               .setShowInLegend(true)
               .setShowInMiniChart(false)
               .setFill("#e377c2")
               .setFillOpacity(0.85)
               .setStroke("#7f7f7f")
               .setStrokeWidth(2)
               .setCornerRadius(3)
               .setColorScale("inferno")
               .setColorDomain(200.0);

        assertEquals("sunburst", options.getType());
        assertEquals("label", options.getLabelKey());
        assertEquals("amount", options.getValueKey());
        assertEquals("category", options.getColorKey());
    }
}
