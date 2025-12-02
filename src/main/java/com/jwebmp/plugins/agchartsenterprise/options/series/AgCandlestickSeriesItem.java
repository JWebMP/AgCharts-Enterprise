package com.jwebmp.plugins.agchartsenterprise.options.series;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Styling options for individual candlestick items in the Candlestick Series.
 *
 * <p>
 * Controls the visual appearance of individual candlestick candles,
 * allowing per-item customization of colors, opacity, and stroke properties.
 * </p>
 *
 * @param <J> the CRTP parameter for fluent API chaining
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AgCandlestickSeriesItem<J extends AgCandlestickSeriesItem<J>>
{
    private String fill;           // Candlestick body fill color
    private Double fillOpacity;    // Fill transparency (0..1)
    private String stroke;         // Wick and border stroke color
    private Integer strokeWidth;   // Wick/border stroke width (px)
    private Double strokeOpacity;  // Stroke transparency (0..1)

    /**
     * Gets the fill color for the candlestick body.
     *
     * @return the hex color code or CSS color name, or null for default
     */
    public String getFill()
    {
        return fill;
    }

    /**
     * Sets the fill color for the candlestick body.
     *
     * @param fill the hex color code (e.g., "#FF5733") or CSS color name
     * @return this instance for method chaining
     */
    public @org.jspecify.annotations.NonNull J setFill(String fill)
    {
        this.fill = fill;
        return (J) this;
    }

    /**
     * Gets the fill opacity of the candlestick body.
     *
     * @return the opacity value between 0 (fully transparent) and 1 (fully opaque), or null for default (1)
     */
    public Double getFillOpacity()
    {
        return fillOpacity;
    }

    /**
     * Sets the fill opacity of the candlestick body.
     *
     * @param fillOpacity the opacity value between 0 (fully transparent) and 1 (fully opaque)
     * @return this instance for method chaining
     */
    public @org.jspecify.annotations.NonNull J setFillOpacity(Double fillOpacity)
    {
        this.fillOpacity = fillOpacity;
        return (J) this;
    }

    /**
     * Gets the stroke color for candlestick wicks and borders.
     *
     * @return the hex color code or CSS color name, or null for default
     */
    public String getStroke()
    {
        return stroke;
    }

    /**
     * Sets the stroke color for candlestick wicks and borders.
     *
     * @param stroke the hex color code (e.g., "#333333") or CSS color name
     * @return this instance for method chaining
     */
    public @org.jspecify.annotations.NonNull J setStroke(String stroke)
    {
        this.stroke = stroke;
        return (J) this;
    }

    /**
     * Gets the stroke width for candlestick wicks and borders.
     *
     * @return the stroke width in pixels, or null for default (1)
     */
    public Integer getStrokeWidth()
    {
        return strokeWidth;
    }

    /**
     * Sets the stroke width for candlestick wicks and borders.
     *
     * @param strokeWidth the stroke width in pixels
     * @return this instance for method chaining
     */
    public @org.jspecify.annotations.NonNull J setStrokeWidth(Integer strokeWidth)
    {
        this.strokeWidth = strokeWidth;
        return (J) this;
    }

    /**
     * Gets the stroke opacity for candlestick wicks and borders.
     *
     * @return the opacity value between 0 (fully transparent) and 1 (fully opaque), or null for default (1)
     */
    public Double getStrokeOpacity()
    {
        return strokeOpacity;
    }

    /**
     * Sets the stroke opacity for candlestick wicks and borders.
     *
     * @param strokeOpacity the opacity value between 0 (fully transparent) and 1 (fully opaque)
     * @return this instance for method chaining
     */
    public @org.jspecify.annotations.NonNull J setStrokeOpacity(Double strokeOpacity)
    {
        this.strokeOpacity = strokeOpacity;
        return (J) this;
    }
}
