package com.jwebmp.plugins.agchartsenterprise.options.series;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.jwebmp.plugins.agcharts.options.series.AgSeriesBaseOptions;
import com.jwebmp.plugins.agcharts.options.series.AgSeriesListeners;

import java.util.List;

/**
 * Heatmap Series options for AG Charts Enterprise.
 * <p>
 * Maps the Heatmap API: xKey, yKey, colorKey, colorRange and related label/legend options.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AgHeatmapSeriesOptions<J extends AgHeatmapSeriesOptions<J>> extends AgSeriesBaseOptions<J>
{
    // Required keys
    private String xKey;      // category X
    private String yKey;      // category Y
    private String colorKey;  // numeric value for colour scale

    // Display names
    private String xName;
    private String yName;
    private String colorName;

    // Colours
    private List<String> colorRange; // >= 2 colours

    // Identity & linkage
    @JsonProperty("id")
    private String id;  // primary identifier for callbacks
    private Object context; // passed to callbacks

    // Data/visibility/misc
    private List<?> data;
    private Boolean visible;
    private String cursor;
    private Object nodeClickRange; // 'nearest' | 'exact' | number
    private AgSeriesListeners<?> listeners;
    private Boolean showInMiniChart;

    // Layout
    private Integer itemPadding; // Minimum distance between label and cell edges
    private String textAlign;    // left|center|right (string to avoid extra enums)
    private String verticalAlign; // top|middle|bottom

    // Title for series (legend/title contexts)
    private String title;

    // Stroke styling for cell borders
    private String stroke;
    private Integer strokeWidth;
    private Double strokeOpacity;


    public AgHeatmapSeriesOptions()
    {
        setType("heatmap");
    }

    // --- Getters/Setters ---
    public String getxKey() {return xKey;}
    public J setxKey(String xKey) {this.xKey = xKey;return (J) this;}

    public String getyKey() {return yKey;}
    public J setyKey(String yKey) {this.yKey = yKey;return (J) this;}

    public String getColorKey() {return colorKey;}
    public J setColorKey(String colorKey) {this.colorKey = colorKey;return (J) this;}

    public String getxName() {return xName;}
    public J setxName(String xName) {this.xName = xName;return (J) this;}

    public String getyName() {return yName;}
    public J setyName(String yName) {this.yName = yName;return (J) this;}

    public String getColorName() {return colorName;}
    public J setColorName(String colorName) {this.colorName = colorName;return (J) this;}

    public List<String> getColorRange() {return colorRange;}
    public J setColorRange(List<String> colorRange) {this.colorRange = colorRange;return (J) this;}

    public String getId() {return id;}
    public J setId(String id) {this.id = id; setSeriesId(id); return (J) this;}

    public Object getContext() {return context;}
    public J setContext(Object context) {this.context = context;return (J) this;}

    public List<?> getData() {return data;}
    public J setData(List<?> data) {this.data = data;return (J) this;}

    public Boolean getVisible() {return visible;}
    public J setVisible(Boolean visible) {this.visible = visible;return (J) this;}

    public String getCursor() {return cursor;}
    public J setCursor(String cursor) {this.cursor = cursor;return (J) this;}

    public Object getNodeClickRange() {return nodeClickRange;}
    public J setNodeClickRange(String range) {this.nodeClickRange = range;return (J) this;}
    public J setNodeClickRange(Integer pixels) {this.nodeClickRange = pixels;return (J) this;}

    public AgSeriesListeners<?> getListeners() {return listeners;}
    public J setListeners(AgSeriesListeners<?> listeners) {this.listeners = listeners;return (J) this;}

    public Boolean getShowInMiniChart() {return showInMiniChart;}
    public J setShowInMiniChart(Boolean showInMiniChart) {this.showInMiniChart = showInMiniChart;return (J) this;}

    public Integer getItemPadding() {return itemPadding;}
    public J setItemPadding(Integer itemPadding) {this.itemPadding = itemPadding;return (J) this;}

    public String getTextAlign() {return textAlign;}
    public J setTextAlign(String textAlign) {this.textAlign = textAlign;return (J) this;}

    public String getVerticalAlign() {return verticalAlign;}
    public J setVerticalAlign(String verticalAlign) {this.verticalAlign = verticalAlign;return (J) this;}

    public String getTitle() {return title;}
    public J setTitle(String title) {this.title = title;return (J) this;}

    public String getStroke() {return stroke;}
    public J setStroke(String stroke) {this.stroke = stroke;return (J) this;}

    public Integer getStrokeWidth() {return strokeWidth;}
    public J setStrokeWidth(Integer strokeWidth) {this.strokeWidth = strokeWidth;return (J) this;}

    public Double getStrokeOpacity() {return strokeOpacity;}
    public J setStrokeOpacity(Double strokeOpacity) {this.strokeOpacity = strokeOpacity;return (J) this;}
}
