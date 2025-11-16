package com.jwebmp.plugins.agchartsenterprise.options.gauge;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.jwebmp.core.htmlbuilder.javascript.JavaScriptPart;

/**
 * Target (threshold) marker options for linear gauge.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AgLinearGaugeTarget<J extends AgLinearGaugeTarget<J>> extends JavaScriptPart<J>
{
    private Number value; // position for the target
    private String text;  // optional label text

    private String shape; // line | triangle | circle etc.
    /** before | after | middle */
    private String placement;

    private Integer size; // px
    private Integer spacing; // px from the gauge edge (ignored for middle)

    private String fill;
    private String stroke;
    private Integer strokeWidth;

    public Number getValue() {return value;}
    public J setValue(Number value) {this.value = value; return (J) this;}

    public String getText() {return text;}
    public J setText(String text) {this.text = text; return (J) this;}

    public String getShape() {return shape;}
    public J setShape(String shape) {this.shape = shape; return (J) this;}

    public String getPlacement() {return placement;}
    public J setPlacement(String placement) {this.placement = placement; return (J) this;}

    public Integer getSize() {return size;}
    public J setSize(Integer size) {this.size = size; return (J) this;}

    public Integer getSpacing() {return spacing;}
    public J setSpacing(Integer spacing) {this.spacing = spacing; return (J) this;}

    public String getFill() {return fill;}
    public J setFill(String fill) {this.fill = fill; return (J) this;}

    public String getStroke() {return stroke;}
    public J setStroke(String stroke) {this.stroke = stroke; return (J) this;}

    public Integer getStrokeWidth() {return strokeWidth;}
    public J setStrokeWidth(Integer strokeWidth) {this.strokeWidth = strokeWidth; return (J) this;}
}
