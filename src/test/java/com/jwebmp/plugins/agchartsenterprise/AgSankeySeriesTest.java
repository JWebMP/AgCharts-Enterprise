package com.jwebmp.plugins.agchartsenterprise;

import com.jwebmp.plugins.agchartsenterprise.options.series.AgSankeySeriesOptions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for AgSankeySeriesOptions.
 */
class AgSankeySeriesTest
{
    private AgSankeySeriesOptions<?> options;

    @BeforeEach
    void setUp()
    {
        options = new AgSankeySeriesOptions<>();
    }

    @Test
    void testBasicConfiguration()
    {
        assertNotNull(options);
        assertEquals("sankey", options.getType());
    }

    @Test
    void testSourceTargetValueProperties()
    {
        options.setSourceKey("from")
               .setTargetKey("to")
               .setValueKey("amount");

        assertEquals("from", options.getSourceKey());
        assertEquals("to", options.getTargetKey());
        assertEquals("amount", options.getValueKey());
    }

    @Test
    void testDisplayNames()
    {
        options.setSourceName("Source Node")
               .setTargetName("Target Node")
               .setValueName("Flow Value");

        assertEquals("Source Node", options.getSourceName());
        assertEquals("Target Node", options.getTargetName());
        assertEquals("Flow Value", options.getValueName());
    }

    @Test
    void testDataBinding()
    {
        List<?> mockData = List.of();
        options.setData(mockData);
        assertEquals(mockData, options.getData());
    }

    @Test
    void testLinkStyling()
    {
        options.setFill("#FF0000")
               .setFillOpacity(0.8)
               .setStroke("#000000")
               .setStrokeWidth(2)
               .setStrokeOpacity(1.0);

        assertEquals("#FF0000", options.getFill());
        assertEquals(0.8, options.getFillOpacity());
        assertEquals("#000000", options.getStroke());
        assertEquals(2, options.getStrokeWidth());
        assertEquals(1.0, options.getStrokeOpacity());
    }

    @Test
    void testNodeStyling()
    {
        options.setNodeFill("#00FF00")
               .setNodeStroke("#0000FF")
               .setNodeStrokeWidth(1)
               .setNodeOpacity(0.9);

        assertEquals("#00FF00", options.getNodeFill());
        assertEquals("#0000FF", options.getNodeStroke());
        assertEquals(1, options.getNodeStrokeWidth());
        assertEquals(0.9, options.getNodeOpacity());
    }

    @Test
    void testNodePadding()
    {
        options.setNodePaddingTop(10)
               .setNodePaddingRight(20)
               .setNodePaddingBottom(30)
               .setNodePaddingLeft(40);

        assertEquals(10, options.getNodePaddingTop());
        assertEquals(20, options.getNodePaddingRight());
        assertEquals(30, options.getNodePaddingBottom());
        assertEquals(40, options.getNodePaddingLeft());
    }

    @Test
    void testCompleteConfiguration()
    {
        options.setType("sankey")
               .setSourceKey("source")
               .setTargetKey("target")
               .setValueKey("value")
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
               .setStrokeOpacity(0.5)
               .setNodeFill("#2ca02c")
               .setNodeStroke("#1f77b4")
               .setNodeStrokeWidth(2)
               .setNodeOpacity(1.0)
               .setNodePaddingTop(5)
               .setNodePaddingRight(5)
               .setNodePaddingBottom(5)
               .setNodePaddingLeft(5);

        assertEquals("sankey", options.getType());
        assertEquals("source", options.getSourceKey());
        assertEquals("target", options.getTargetKey());
        assertEquals("value", options.getValueKey());
        assertTrue(options.getVisible());
    }
}
