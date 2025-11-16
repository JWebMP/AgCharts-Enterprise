package com.jwebmp.plugins.agchartsenterprise.options.gauge;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonRawValue;
import com.jwebmp.core.htmlbuilder.javascript.JavaScriptPart;

/**
 * Secondary inner label options. Supports either fixed text or a formatter.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AgRadialGaugeSecondaryLabelOptions<J extends AgRadialGaugeSecondaryLabelOptions<J>> extends JavaScriptPart<J>
{
    private String text; // optional fixed text

    private Integer fontSize;
    private String fontFamily;
    private String fontWeight;
    private String color;

    /**
     * Optional formatter: function({ value }) { return string; }
     */
    @JsonRawValue
    private String formatter;

    public String getText() {return text;}

    public J setText(String text)
    {
        this.text = text;
        return (J) this;
    }

    public Integer getFontSize() {return fontSize;}

    public J setFontSize(Integer fontSize)
    {
        this.fontSize = fontSize;
        return (J) this;
    }

    public String getFontFamily() {return fontFamily;}

    public J setFontFamily(String fontFamily)
    {
        this.fontFamily = fontFamily;
        return (J) this;
    }

    public String getFontWeight() {return fontWeight;}

    public J setFontWeight(String fontWeight)
    {
        this.fontWeight = fontWeight;
        return (J) this;
    }

    public String getColor() {return color;}

    public J setColor(String color)
    {
        this.color = color;
        return (J) this;
    }

    public String getFormatter() {return formatter;}

    public J setFormatter(String formatter)
    {
        this.formatter = formatter;
        return (J) this;
    }
}
