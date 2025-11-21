package com.jwebmp.plugins.agchartsenterprise.options.gauge;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.jwebmp.core.htmlbuilder.javascript.JavaScriptPart;

/**
 * Label options for the radial gauge scale.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AgRadialGaugeScaleLabelOptions<J extends AgRadialGaugeScaleLabelOptions<J>> extends JavaScriptPart<J>
{
    private Boolean enabled;
    private Integer fontSize;
    private String fontFamily;
    private String fontWeight;
    private String color;

    public Boolean getEnabled() {return enabled;}

    public @org.jspecify.annotations.NonNull J setEnabled(Boolean enabled)
    {
        this.enabled = enabled;
        return (J) this;
    }

    public Integer getFontSize() {return fontSize;}

    public @org.jspecify.annotations.NonNull J setFontSize(Integer fontSize)
    {
        this.fontSize = fontSize;
        return (J) this;
    }

    public String getFontFamily() {return fontFamily;}

    public @org.jspecify.annotations.NonNull J setFontFamily(String fontFamily)
    {
        this.fontFamily = fontFamily;
        return (J) this;
    }

    public String getFontWeight() {return fontWeight;}

    public @org.jspecify.annotations.NonNull J setFontWeight(String fontWeight)
    {
        this.fontWeight = fontWeight;
        return (J) this;
    }

    public String getColor() {return color;}

    public @org.jspecify.annotations.NonNull J setColor(String color)
    {
        this.color = color;
        return (J) this;
    }
}
