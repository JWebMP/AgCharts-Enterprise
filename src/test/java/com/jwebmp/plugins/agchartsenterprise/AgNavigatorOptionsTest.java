package com.jwebmp.plugins.agchartsenterprise;

import com.jwebmp.core.htmlbuilder.javascript.JavaScriptPart;
import com.jwebmp.plugins.agcharts.options.AgChartOptions;
import com.jwebmp.plugins.agcharts.options.navigator.AgNavigatorMiniChartOptions;
import com.jwebmp.plugins.agcharts.options.navigator.AgNavigatorOptions;
import com.jwebmp.plugins.agcharts.options.series.AgSeriesLabelOptions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class AgNavigatorOptionsTest {

    @Test
    public void testNavigatorSerialization() {
        AgSeriesLabelOptions<?> label = new AgSeriesLabelOptions<>()
                .setFontSize(20)
                .setFontWeight("bold");

        AgNavigatorOptions<?> nav = new AgNavigatorOptions<>()
                .setEnabled(true)
                .setHeight(50)
                .setCornerRadius(8)
                .setSpacing(12)
                .setMiniChart(new AgNavigatorMiniChartOptions<>()
                        .setEnabled(true)
                        .setLabel(label));

        AgChartOptions<?> options = new AgChartOptions<>()
                .setNavigator(nav);

        String json = new JavaScriptPart<>().objectAsString(options);

        assertTrue(json.contains("\"navigator\""), json);
        assertTrue(json.contains("\"enabled\":true"), json);
        assertTrue(json.contains("\"height\":50"), json);
        // Mini chart enabled
        assertTrue(json.contains("\"miniChart\""), json);
        assertTrue(json.contains("\"fontWeight\":\"bold\"") || json.contains("\"font-weight\":\"bold\""), json);
    }
}
