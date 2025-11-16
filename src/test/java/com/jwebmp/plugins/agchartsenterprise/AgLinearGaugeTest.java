package com.jwebmp.plugins.agchartsenterprise;

import com.jwebmp.core.htmlbuilder.javascript.JavaScriptPart;
import com.jwebmp.plugins.agchartsenterprise.options.gauge.*;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class AgLinearGaugeTest {

    private static boolean containsAny(String haystack, String... needles) {
        for (String n : needles) {
            if (haystack.contains(n)) return true;
        }
        return false;
    }

    @Test
    public void testSimpleLinearGauge() {
        AgLinearGaugeOptions<?> gauge = new AgLinearGaugeOptions<>()
                .setValue(80)
                .setScale(new AgLinearGaugeScale<>()
                        .setMin(0)
                        .setMax(100));

        String json = new JavaScriptPart<>().objectAsString(gauge);

        assertTrue(json.contains("\"linear-gauge\""), "Expected type 'linear-gauge' in JSON: " + json);
        assertTrue(containsAny(json, "\"value\":80"), json);
        assertTrue(containsAny(json, "\"min\":0"), json);
        assertTrue(containsAny(json, "\"max\":100"), json);
    }

    @Test
    public void testCustomisedLinearGauge() {
        AgLinearGaugeOptions<?> gauge = new AgLinearGaugeOptions<>()
                .setDirection("horizontal")
                .setThickness(100)
                .setBar(new AgLinearGaugeBarStyle<>()
                        .setThickness(50))
                .setLabel(new AgLinearGaugeLabelOptions<>()
                        .setEnabled(true)
                        .setPlacement("inside-start")
                        .setAvoidCollisions(true))
                .setScale(new AgLinearGaugeScale<>()
                        .setMin(0)
                        .setMax(100)
                        .setFills(Arrays.asList(
                                new AgGaugeColorStop<>().setColor("#00a8ff"),
                                new AgGaugeColorStop<>().setColor("#9c88ff"),
                                new AgGaugeColorStop<>().setColor("#e84118")
                        ))
                        .setFillMode(AgGaugeFillMode.DISCRETE))
                .setSegmentation(new AgGaugeSegmentation<>()
                        .setEnabled(true)
                        .setInterval(new AgGaugeSegmentationInterval<>().setCount(4))
                        .setSpacing(2))
                .setCornerRadius(99)
                .setCornerMode(AgGaugeCornerMode.CONTAINER)
                .setTargets(Collections.singletonList(
                        new AgLinearGaugeTarget<>()
                                .setValue(70)
                                .setText("Average")
                ));

        String json = new JavaScriptPart<>().objectAsString(gauge);

        assertTrue(containsAny(json, "\"direction\":\"horizontal\""), json);
        assertTrue(containsAny(json, "\"thickness\":100"), json);
        assertTrue(containsAny(json, "\"bar\":", "\"bar\""), json);
        assertTrue(containsAny(json, "\"enabled\":true"), json);
        assertTrue(containsAny(json, "\"placement\":\"inside-start\""), json);
        assertTrue(containsAny(json, "\"avoidCollisions\":true", "\"avoid-collisions\":true"), json);
        assertTrue(containsAny(json, "\"count\":4"), json);
        assertTrue(containsAny(json, "\"spacing\":2"), json);
        assertTrue(containsAny(json, "\"cornerRadius\":99", "\"corner-radius\":99"), json);
        assertTrue(json.contains("\"fills\":[{"));
        assertTrue(containsAny(json, "\"fillMode\":\"discrete\"", "\"fill-mode\":\"discrete\""), json);
        assertTrue(containsAny(json, "\"targets\":[{"), json);
    }
}
