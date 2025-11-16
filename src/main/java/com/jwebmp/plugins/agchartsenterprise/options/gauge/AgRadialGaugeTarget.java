package com.jwebmp.plugins.agchartsenterprise.options.gauge;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.jwebmp.core.htmlbuilder.javascript.JavaScriptPart;

/**
 * Target marker options for radial gauge.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AgRadialGaugeTarget<J extends AgRadialGaugeTarget<J>> extends JavaScriptPart<J>
{
    private Number value; // position on scale
    private String text;  // optional target label

    private String shape; // marker shape name, e.g., 'triangle', 'circle'
    private AgGaugeTargetPlacement placement; // inside|outside|middle

    private Integer size; // marker size in px
    private Integer spacing; // distance from edge when not middle

    private String fill;
    private String stroke;
    private Integer strokeWidth;

    public Number getValue() {return value;}

    public J setValue(Number value)
    {
        this.value = value;
        return (J) this;
    }

    public String getText() {return text;}

    public J setText(String text)
    {
        this.text = text;
        return (J) this;
    }

    public String getShape() {return shape;}

    public J setShape(String shape)
    {
        this.shape = shape;
        return (J) this;
    }

    public AgGaugeTargetPlacement getPlacement() {return placement;}

    public J setPlacement(AgGaugeTargetPlacement placement)
    {
        this.placement = placement;
        return (J) this;
    }

    public Integer getSize() {return size;}

    public J setSize(Integer size)
    {
        this.size = size;
        return (J) this;
    }

    public Integer getSpacing() {return spacing;}

    public J setSpacing(Integer spacing)
    {
        this.spacing = spacing;
        return (J) this;
    }

    public String getFill() {return fill;}

    public J setFill(String fill)
    {
        this.fill = fill;
        return (J) this;
    }

    public String getStroke() {return stroke;}

    public J setStroke(String stroke)
    {
        this.stroke = stroke;
        return (J) this;
    }

    public Integer getStrokeWidth() {return strokeWidth;}

    public J setStrokeWidth(Integer strokeWidth)
    {
        this.strokeWidth = strokeWidth;
        return (J) this;
    }
}
