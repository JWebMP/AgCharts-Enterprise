package com.jwebmp.plugins.agchartsenterprise;

import com.jwebmp.core.htmlbuilder.javascript.JavaScriptPart;
import com.jwebmp.plugins.agcharts.options.AgChartOptions;
import com.jwebmp.plugins.agchartsenterprise.options.axes.AgAxisLabelOrientation;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Basic serialization tests for AgRadialColumnChart to verify output contains
 * expected axes/series configuration for AG Charts Enterprise radial column.
 */
public class AgRadialColumnChartTest
{

    private static boolean containsAny(String haystack, String... needles)
    {
        String h = haystack.replaceAll("\\s+", "");
        for (String n : needles)
        {
            String nn = n.replaceAll("\\s+", "");
            if (h.contains(nn))
            {
                return true;
            }
        }
        return false;
    }

    @Test
    public void testMinimalOptionsSerialization()
    {
        AgRadialColumnChart<?> chart = new AgRadialColumnChart<>("rc1", "quarter", "software");
        AgChartOptions<?> options = chart.getInitialOptions().await().indefinitely();

        // Use the built-in JSON writer facilities to serialise consistently with the library.
        String json = new JavaScriptPart<>().objectAsString(options);

        // Should include a single series of type radial-column.
        assertTrue(json.contains("\"radial-column\""), "Expected series type 'radial-column' in JSON: " + json);

        // Should include our keys (allow both camelCase and kebab-case depending on mapper configuration).
        assertTrue(containsAny(json, "\"angleKey\":\"quarter\"", "\"angle-key\":\"quarter\""),
                "Expected angle key present in JSON: " + json);
        assertTrue(containsAny(json, "\"radiusKey\":\"software\"", "\"radius-key\":\"software\""),
                "Expected radius key present in JSON: " + json);

        // Should include axes types for angle category and radius number.
        assertTrue(json.contains("\"angle-category\""), "Expected angle-category axis in JSON: " + json);
        assertTrue(json.contains("\"radius-number\""), "Expected radius-number axis in JSON: " + json);
    }

    @Test
    public void testConfiguredOptionsSerialization()
    {
        AgRadialColumnChart<?> chart = new AgRadialColumnChart<>("rc2", "quarter", "hardware")
                .setAnglePaddingInner(0.5)
                .setAngleGroupPaddingInner(0.4)
                .setAngleLabelOrientation(AgAxisLabelOrientation.PARALLEL)
                .setRadiusInnerRadiusRatio(0.2)
                .setRadiusPositionAngle(90)
                .setRadiusLabelRotation(-90)
                .setStacked(true)
                .setGrouped(false)
                .setColumnWidthRatio(0.7)
                .setMaxColumnWidthRatio(0.3)
                .setCornerRadius(6)
                .setStroke("#f00")
                .setStrokeWidth(2)
                .setStrokeOpacity(0.8)
                .setFillOpacity(0.6)
                .setLegendItemName("Hardware");

        AgChartOptions<?> options = chart.getInitialOptions().await().indefinitely();
        String json = new JavaScriptPart<>().objectAsString(options);

        // Axes presence
        assertTrue(json.contains("\"angle-category\""), "Expected angle-category axis in JSON: " + json);
        assertTrue(json.contains("\"radius-number\""), "Expected radius-number axis in JSON: " + json);

        // Angle axis paddings (support both naming strategies)
        assertTrue(containsAny(json, "\"paddingInner\":0.5", "\"padding-inner\":0.5"),
                "Expected angle paddingInner in JSON: " + json);
        assertTrue(containsAny(json, "\"groupPaddingInner\":0.4", "\"group-padding-inner\":0.4"),
                "Expected angle groupPaddingInner in JSON: " + json);

        // Angle label orientation
        assertTrue(containsAny(json, "\"orientation\":\"parallel\""),
                "Expected label orientation 'parallel' in JSON: " + json);

        // Radius axis properties
        assertTrue(containsAny(json, "\"innerRadiusRatio\":0.2", "\"inner-radius-ratio\":0.2"),
                "Expected radius innerRadiusRatio in JSON: " + json);
        assertTrue(containsAny(json, "\"positionAngle\":90", "\"position-angle\":90"),
                "Expected radius positionAngle in JSON: " + json);
        assertTrue(containsAny(json, "\"rotation\":-90"),
                "Expected radius label rotation in JSON: " + json);

        // Series-level configuration checks
        assertTrue(containsAny(json, "\"stacked\":true"), "Expected stacked:true on series in JSON: " + json);
        assertTrue(containsAny(json, "\"grouped\":false"), "Expected grouped:false on series in JSON: " + json);
        assertTrue(containsAny(json, "\"columnWidthRatio\":0.7", "\"column-width-ratio\":0.7"),
                "Expected columnWidthRatio in JSON: " + json);
        assertTrue(containsAny(json, "\"maxColumnWidthRatio\":0.3", "\"max-column-width-ratio\":0.3"),
                "Expected maxColumnWidthRatio in JSON: " + json);
        assertTrue(containsAny(json, "\"cornerRadius\":6", "\"corner-radius\":6"),
                "Expected cornerRadius in JSON: " + json);
        assertTrue(containsAny(json, "\"stroke\":\"#f00\""), "Expected stroke colour in JSON: " + json);
        assertTrue(containsAny(json, "\"strokeWidth\":2", "\"stroke-width\":2"),
                "Expected strokeWidth in JSON: " + json);
        assertTrue(containsAny(json, "\"strokeOpacity\":0.8", "\"stroke-opacity\":0.8"),
                "Expected strokeOpacity in JSON: " + json);
        assertTrue(containsAny(json, "\"fillOpacity\":0.6", "\"fill-opacity\":0.6"),
                "Expected fillOpacity in JSON: " + json);

        // Legend item name should be present
        assertTrue(containsAny(json, "\"legendItemName\":\"Hardware\"", "\"legend-item-name\":\"Hardware\""),
                "Expected legendItemName in JSON: " + json);
    }
}
