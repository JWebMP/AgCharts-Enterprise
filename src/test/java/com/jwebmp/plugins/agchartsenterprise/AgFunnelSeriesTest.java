package com.jwebmp.plugins.agchartsenterprise;

import com.jwebmp.plugins.agchartsenterprise.options.series.AgFunnelSeriesOptions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for AgFunnelSeriesOptions.
 */
class AgFunnelSeriesTest
{
    private AgFunnelSeriesOptions<?> options;

    @BeforeEach
    void setUp()
    {
        options = new AgFunnelSeriesOptions<>();
    }

    @Test
    void testBasicConfiguration()
    {
        assertNotNull(options);
        assertEquals("funnel", options.getType());
    }

    @Test
    void testLabelAndValueProperties()
    {
        options.setLabelKey("stage")
               .setValueKey("count");

        assertEquals("stage", options.getLabelKey());
        assertEquals("count", options.getValueKey());
    }

    @Test
    void testDisplayNames()
    {
        options.setLabelName("Stage")
               .setValueName("Count");

        assertEquals("Stage", options.getLabelName());
        assertEquals("Count", options.getValueName());
    }

    @Test
    void testDataBinding()
    {
        List<?> mockData = List.of();
        options.setData(mockData);
        assertEquals(mockData, options.getData());
    }

    @Test
    void testStageStyling()
    {
        options.setFill("#4472C4")
               .setFillOpacity(0.8)
               .setStroke("#000000")
               .setStrokeWidth(1)
               .setCornerRadius(4);

        assertEquals("#4472C4", options.getFill());
        assertEquals(0.8, options.getFillOpacity());
        assertEquals("#000000", options.getStroke());
        assertEquals(1, options.getStrokeWidth());
        assertEquals(4, options.getCornerRadius());
    }

    @Test
    void testOrientation()
    {
        options.setOrientation("vertical");
        assertEquals("vertical", options.getOrientation());

        options.setOrientation("horizontal");
        assertEquals("horizontal", options.getOrientation());
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
        options.setType("funnel")
               .setLabelKey("stage")
               .setValueKey("value")
               .setLabelName("Stage Name")
               .setValueName("Stage Value")
               .setVisible(true)
               .setShowInLegend(true)
               .setShowInMiniChart(true)
               .setFill("#70AD47")
               .setFillOpacity(0.85)
               .setStroke("#203864")
               .setStrokeWidth(2)
               .setCornerRadius(3)
               .setOrientation("vertical");

        assertEquals("funnel", options.getType());
        assertEquals("stage", options.getLabelKey());
        assertEquals("value", options.getValueKey());
        assertEquals("vertical", options.getOrientation());
    }
}
