package com.jwebmp.plugins.agchartsenterprise;

import com.jwebmp.core.htmlbuilder.javascript.JavaScriptPart;
import com.jwebmp.plugins.agchartsenterprise.options.gauge.AgRadialGaugeOptions;
import com.jwebmp.plugins.agchartsenterprise.options.gauge.AgRadialGaugeTarget;
import com.jwebmp.plugins.agchartsenterprise.options.gauge.AgRadialGaugeScale;
import com.jwebmp.plugins.agchartsenterprise.options.gauge.AgRadialGaugeBarStyle;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Tests for Radial Gauge options serialization and configuration.
 *
 * Verifies that all Radial Gauge properties serialize correctly to JSON,
 * including scale configuration, styling, targets, and interaction options.
 */
public class AgRadialGaugeTest
{
    @Test
    public void testRadialGaugeBasicConfiguration()
    {
        AgRadialGaugeOptions<?> gauge = new AgRadialGaugeOptions<>()
                .setValue(75)
                .setWidth(400)
                .setHeight(400)
                .setStartAngle(-135)
                .setEndAngle(135);

        String json = new JavaScriptPart<>().objectAsString(gauge);

        assertTrue(json.contains("\"radial-gauge\""), "Expected gauge type 'radial-gauge': " + json);
        assertTrue(json.contains("\"value\":75"), "Expected value 75: " + json);
        assertTrue(json.contains("\"width\":400"), "Expected width 400: " + json);
        assertTrue(json.contains("\"height\":400"), "Expected height 400: " + json);
        assertTrue(json.contains("\"startAngle\":-135") || json.contains("\"start-angle\":-135"), json);
        assertTrue(json.contains("\"endAngle\":135") || json.contains("\"end-angle\":135"), json);
    }

    @Test
    public void testRadialGaugeWithScale()
    {
        AgRadialGaugeScale<?> scale = new AgRadialGaugeScale<>()
                .setMin(0)
                .setMax(100);

        AgRadialGaugeOptions<?> gauge = new AgRadialGaugeOptions<>()
                .setValue(65)
                .setScale(scale);

        String json = new JavaScriptPart<>().objectAsString(gauge);

        assertTrue(json.contains("\"scale\""), "Expected scale configuration: " + json);
        assertTrue(json.contains("\"min\":0") || json.contains("\"minimum\":0"), json);
        assertTrue(json.contains("\"max\":100") || json.contains("\"maximum\":100"), json);
    }

    @Test
    public void testRadialGaugeWithBar()
    {
        AgRadialGaugeBarStyle<?> bar = new AgRadialGaugeBarStyle<>()
                .setEnabled(true)
                .setFill("#4cd137");

        AgRadialGaugeOptions<?> gauge = new AgRadialGaugeOptions<>()
                .setValue(50)
                .setBar(bar);

        String json = new JavaScriptPart<>().objectAsString(gauge);

        assertTrue(json.contains("\"bar\""), "Expected bar configuration: " + json);
        assertTrue(json.contains("\"enabled\":true"), json);
        assertTrue(json.contains("\"fill\":\"#4cd137\""), json);
    }

    @Test
    public void testRadialGaugeWithTargets()
    {
        AgRadialGaugeTarget<?> target1 = new AgRadialGaugeTarget<>()
                .setValue(70)
                .setText("Average");

        AgRadialGaugeTarget<?> target2 = new AgRadialGaugeTarget<>()
                .setValue(90)
                .setText("Maximum");

        AgRadialGaugeOptions<?> gauge = new AgRadialGaugeOptions<>()
                .setValue(65)
                .setTargets(Arrays.asList(target1, target2));

        String json = new JavaScriptPart<>().objectAsString(gauge);

        assertTrue(json.contains("\"targets\""), "Expected targets configuration: " + json);
        assertTrue(json.contains("\"value\":70"), "Expected target value 70: " + json);
        assertTrue(json.contains("\"text\":\"Average\""), "Expected target text Average: " + json);
        assertTrue(json.contains("\"value\":90"), "Expected target value 90: " + json);
        assertTrue(json.contains("\"text\":\"Maximum\""), "Expected target text Maximum: " + json);
    }

    @Test
    public void testRadialGaugeRadiusConfiguration()
    {
        AgRadialGaugeOptions<?> gauge = new AgRadialGaugeOptions<>()
                .setValue(80)
                .setOuterRadius(150)
                .setInnerRadius(75)
                .setOuterRadiusRatio(0.8)
                .setInnerRadiusRatio(0.5);

        String json = new JavaScriptPart<>().objectAsString(gauge);

        assertTrue(json.contains("\"outerRadius\":150") || json.contains("\"outer-radius\":150"), json);
        assertTrue(json.contains("\"innerRadius\":75") || json.contains("\"inner-radius\":75"), json);
        assertTrue(json.contains("\"outerRadiusRatio\":0.8") || json.contains("\"outer-radius-ratio\":0.8"), json);
        assertTrue(json.contains("\"innerRadiusRatio\":0.5") || json.contains("\"inner-radius-ratio\":0.5"), json);
    }

    @Test
    public void testRadialGaugeCompleteConfiguration()
    {
        AgRadialGaugeScale<?> scale = new AgRadialGaugeScale<>()
                .setMin(0)
                .setMax(100);

        AgRadialGaugeBarStyle<?> bar = new AgRadialGaugeBarStyle<>()
                .setEnabled(true)
                .setFill("#2b5c95");

        AgRadialGaugeTarget<?> target = new AgRadialGaugeTarget<>()
                .setValue(75)
                .setText("Target");

        AgRadialGaugeOptions<?> gauge = new AgRadialGaugeOptions<>()
                .setValue(65)
                .setWidth(400)
                .setHeight(400)
                .setStartAngle(-135)
                .setEndAngle(135)
                .setOuterRadius(150)
                .setInnerRadius(75)
                .setCornerRadius(5)
                .setScale(scale)
                .setBar(bar)
                .setTargets(Arrays.asList(target))
                .setCursor("pointer");

        String json = new JavaScriptPart<>().objectAsString(gauge);

        // Verify multiple key properties are present
        assertTrue(json.contains("\"radial-gauge\""), json);
        assertTrue(json.contains("\"value\":65"), json);
        assertTrue(json.contains("\"scale\""), json);
        assertTrue(json.contains("\"bar\""), json);
        assertTrue(json.contains("\"targets\""), json);
        assertTrue(json.contains("\"cursor\":\"pointer\""), json);
        assertTrue(json.contains("\"startAngle\":-135") || json.contains("\"start-angle\":-135"), json);
    }

    @Test
    public void testRadialGaugeNullExclusion()
    {
        // Test that null values are not serialized (JsonInclude.NON_NULL)
        AgRadialGaugeOptions<?> gauge = new AgRadialGaugeOptions<>()
                .setValue(50);
        // Don't set optional fields

        String json = new JavaScriptPart<>().objectAsString(gauge);

        // Should not contain nulls or undefined optional fields
        assertNoNullFields(json);
    }

    @Test
    public void testRadialGaugeMinMaxDimensions()
    {
        AgRadialGaugeOptions<?> gauge = new AgRadialGaugeOptions<>()
                .setValue(50)
                .setMinWidth(200)
                .setMinHeight(200);

        String json = new JavaScriptPart<>().objectAsString(gauge);

        assertTrue(json.contains("\"minWidth\":200") || json.contains("\"min-width\":200"), json);
        assertTrue(json.contains("\"minHeight\":200") || json.contains("\"min-height\":200"), json);
    }

    /**
     * Helper to verify that null values are properly excluded from JSON serialization.
     * This ensures JsonInclude.NON_NULL is working correctly.
     */
    private void assertNoNullFields(String json)
    {
        // Check common patterns that should NOT appear
        assertTrue(!json.contains(":null"), "JSON should not contain null values: " + json);
        assertTrue(!json.contains("undefined"), "JSON should not contain undefined: " + json);
    }
}
