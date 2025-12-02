package com.jwebmp.plugins.agchartsenterprise;

import com.jwebmp.plugins.agchartsenterprise.options.series.AgChordSeriesOptions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for AgChordSeriesOptions.
 */
class AgChordSeriesTest
{
    private AgChordSeriesOptions<?> options;

    @BeforeEach
    void setUp()
    {
        options = new AgChordSeriesOptions<>();
    }

    @Test
    void testBasicConfiguration()
    {
        assertNotNull(options);
        assertEquals("chord", options.getType());
    }

    @Test
    void testSourceTargetValueProperties()
    {
        options.setSourceKey("source")
               .setTargetKey("target")
               .setValueKey("value");

        assertEquals("source", options.getSourceKey());
        assertEquals("target", options.getTargetKey());
        assertEquals("value", options.getValueKey());
    }

    @Test
    void testDisplayNames()
    {
        options.setSourceName("From")
               .setTargetName("To")
               .setValueName("Weight");

        assertEquals("From", options.getSourceName());
        assertEquals("To", options.getTargetName());
        assertEquals("Weight", options.getValueName());
    }

    @Test
    void testDataBinding()
    {
        List<?> mockData = List.of();
        options.setData(mockData);
        assertEquals(mockData, options.getData());
    }

    @Test
    void testRibbonStyling()
    {
        options.setFill("#17becf")
               .setFillOpacity(0.7)
               .setStroke("#000000")
               .setStrokeWidth(1)
               .setStrokeOpacity(0.5);

        assertEquals("#17becf", options.getFill());
        assertEquals(0.7, options.getFillOpacity());
        assertEquals("#000000", options.getStroke());
        assertEquals(1, options.getStrokeWidth());
        assertEquals(0.5, options.getStrokeOpacity());
    }

    @Test
    void testNodeStyling()
    {
        options.setNodeFill("#bcbd22")
               .setNodeStroke("#ff7f0e")
               .setNodeStrokeWidth(2)
               .setNodeOpacity(0.95);

        assertEquals("#bcbd22", options.getNodeFill());
        assertEquals("#ff7f0e", options.getNodeStroke());
        assertEquals(2, options.getNodeStrokeWidth());
        assertEquals(0.95, options.getNodeOpacity());
    }

    @Test
    void testNodePaddingAngle()
    {
        options.setNodePaddingAngle(5);

        assertEquals(5, options.getNodePaddingAngle());
    }

    @Test
    void testCompleteConfiguration()
    {
        options.setType("chord")
               .setSourceKey("from")
               .setTargetKey("to")
               .setValueKey("amount")
               .setSourceName("Source")
               .setTargetName("Target")
               .setValueName("Amount")
               .setVisible(true)
               .setShowInLegend(true)
               .setShowInMiniChart(false)
               .setFill("#1f77b4")
               .setFillOpacity(0.8)
               .setStroke("#333333")
               .setStrokeWidth(1)
               .setStrokeOpacity(0.6)
               .setNodeFill("#2ca02c")
               .setNodeStroke("#d62728")
               .setNodeStrokeWidth(2)
               .setNodeOpacity(1.0)
               .setNodePaddingAngle(3);

        assertEquals("chord", options.getType());
        assertEquals("from", options.getSourceKey());
        assertEquals("to", options.getTargetKey());
        assertEquals("amount", options.getValueKey());
    }
}
