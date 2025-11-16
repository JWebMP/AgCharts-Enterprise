package com.jwebmp.plugins.agchartsenterprise;

import com.jwebmp.plugins.agcharts.AgChart;
import com.jwebmp.plugins.agcharts.options.AgChartOptions;
import com.jwebmp.plugins.agchartsenterprise.options.axes.AgAngleCategoryAxisOptions;
import com.jwebmp.plugins.agchartsenterprise.options.axes.AgPolarAxisLabelOptions;
import com.jwebmp.plugins.agchartsenterprise.options.axes.AgAxisLabelOrientation;
import com.jwebmp.plugins.agchartsenterprise.options.series.AgRadiusNumberAxisOptions;
import com.jwebmp.plugins.agcharts.options.series.AgBarSeriesLabelOptions;
import com.jwebmp.plugins.agchartsenterprise.options.series.AgRadialColumnSeriesOptions;
import io.smallrye.mutiny.Uni;

import java.util.ArrayList;
import java.util.List;

/**
 * Convenience Radial Column (Circular Column) Chart component.
 * <p>
 * Creates a polar chart configuration with:
 * - Angle Category Axis (optionally configure padding and label orientation)
 * - Radius Number Axis (optionally configure inner radius ratio and position angle)
 * - A single Radial Column series with common stacking/grouping/width controls
 */
public class AgRadialColumnChart<J extends AgRadialColumnChart<J>> extends AgChart<J>
{
    private final String angleKey;
    private final String radiusKey;

    // Optional display names
    private String angleName;
    private String radiusName;
    private String legendItemName;

    // Series behaviour
    private Boolean grouped;
    private Boolean stacked;
    private String stackGroup;
    private Number normalizedTo;
    private Double columnWidthRatio;
    private Double maxColumnWidthRatio;

    // Styling/labels
    private Integer cornerRadius;
    private Double fillOpacity;
    private String stroke;
    private Integer strokeWidth;
    private Double strokeOpacity;
    private List<Integer> lineDash;
    private Integer lineDashOffset;
    private AgBarSeriesLabelOptions<?> label;

    // Interaction + misc
    private Boolean showInLegend;
    private List<?> data;

    // Axis options
    private Double anglePaddingInner;
    private Double angleGroupPaddingInner;
    private AgAxisLabelOrientation angleLabelOrientation; // fixed | parallel | perpendicular

    private Double radiusInnerRadiusRatio;
    private Integer radiusPositionAngle;
    private Integer radiusLabelRotation; // via label options

    public AgRadialColumnChart(String id, String angleKey, String radiusKey)
    {
        super(id);
        this.angleKey = angleKey;
        this.radiusKey = radiusKey;
    }

    // --- Fluent setters ---
    public J setAngleName(String angleName)
    {
        this.angleName = angleName;
        return (J) this;
    }

    public J setRadiusName(String radiusName)
    {
        this.radiusName = radiusName;
        return (J) this;
    }

    public J setLegendItemName(String legendItemName)
    {
        this.legendItemName = legendItemName;
        return (J) this;
    }

    public J setGrouped(Boolean grouped)
    {
        this.grouped = grouped;
        return (J) this;
    }

    public J setStacked(Boolean stacked)
    {
        this.stacked = stacked;
        return (J) this;
    }

    public J setStackGroup(String stackGroup)
    {
        this.stackGroup = stackGroup;
        return (J) this;
    }

    public J setNormalizedTo(Number normalizedTo)
    {
        this.normalizedTo = normalizedTo;
        return (J) this;
    }

    public J setColumnWidthRatio(Double columnWidthRatio)
    {
        this.columnWidthRatio = columnWidthRatio;
        return (J) this;
    }

    public J setMaxColumnWidthRatio(Double maxColumnWidthRatio)
    {
        this.maxColumnWidthRatio = maxColumnWidthRatio;
        return (J) this;
    }

    public J setCornerRadius(Integer cornerRadius)
    {
        this.cornerRadius = cornerRadius;
        return (J) this;
    }

    public J setFillOpacity(Double fillOpacity)
    {
        this.fillOpacity = fillOpacity;
        return (J) this;
    }

    public J setStroke(String stroke)
    {
        this.stroke = stroke;
        return (J) this;
    }

    public J setStrokeWidth(Integer strokeWidth)
    {
        this.strokeWidth = strokeWidth;
        return (J) this;
    }

    public J setStrokeOpacity(Double strokeOpacity)
    {
        this.strokeOpacity = strokeOpacity;
        return (J) this;
    }

    public J setLineDash(List<Integer> lineDash)
    {
        this.lineDash = lineDash;
        return (J) this;
    }

    public J setLineDashOffset(Integer lineDashOffset)
    {
        this.lineDashOffset = lineDashOffset;
        return (J) this;
    }

    public J setLabel(AgBarSeriesLabelOptions<?> label)
    {
        this.label = label;
        return (J) this;
    }

    public J setShowInLegend(Boolean showInLegend)
    {
        this.showInLegend = showInLegend;
        return (J) this;
    }

    public J setData(List<?> data)
    {
        this.data = data;
        return (J) this;
    }

    public J setAnglePaddingInner(Double anglePaddingInner)
    {
        this.anglePaddingInner = anglePaddingInner;
        return (J) this;
    }

    public J setAngleGroupPaddingInner(Double angleGroupPaddingInner)
    {
        this.angleGroupPaddingInner = angleGroupPaddingInner;
        return (J) this;
    }

    public J setAngleLabelOrientation(AgAxisLabelOrientation orientation)
    {
        this.angleLabelOrientation = orientation;
        return (J) this;
    }

    public J setRadiusInnerRadiusRatio(Double radiusInnerRadiusRatio)
    {
        this.radiusInnerRadiusRatio = radiusInnerRadiusRatio;
        return (J) this;
    }

    public J setRadiusPositionAngle(Integer radiusPositionAngle)
    {
        this.radiusPositionAngle = radiusPositionAngle;
        return (J) this;
    }

    public J setRadiusLabelRotation(Integer radiusLabelRotation)
    {
        this.radiusLabelRotation = radiusLabelRotation;
        return (J) this;
    }

    @Override
    public Uni<AgChartOptions<?>> getInitialOptions()
    {
        return Uni.createFrom().item(() -> {
            // Build axes
            AgAngleCategoryAxisOptions<?> angleAxis = new AgAngleCategoryAxisOptions<>();
            if (anglePaddingInner != null)
            {
                angleAxis.setPaddingInner(anglePaddingInner);
            }
            if (angleGroupPaddingInner != null)
            {
                angleAxis.setGroupPaddingInner(angleGroupPaddingInner);
            }
            if (angleLabelOrientation != null)
            {
                AgPolarAxisLabelOptions<?> l = new AgPolarAxisLabelOptions<>().setOrientation(angleLabelOrientation);
                angleAxis.setLabel(l);
            }

            AgRadiusNumberAxisOptions<?> radiusAxis = new AgRadiusNumberAxisOptions<>();
            if (radiusInnerRadiusRatio != null)
            {
                radiusAxis.setInnerRadiusRatio(radiusInnerRadiusRatio);
            }
            if (radiusPositionAngle != null)
            {
                radiusAxis.setPositionAngle(radiusPositionAngle);
            }
            if (radiusLabelRotation != null)
            {
                // Reuse polar label options for rotation setting
                AgPolarAxisLabelOptions<?> l = new AgPolarAxisLabelOptions<>().setRotation(radiusLabelRotation);
                radiusAxis.setLabel(l);
            }

            List<com.jwebmp.plugins.agcharts.options.axes.AgAxisBaseOptions<?>> axes = new ArrayList<>();
            axes.add(angleAxis);
            axes.add(radiusAxis);

            // Build series
            AgRadialColumnSeriesOptions<?> series = new AgRadialColumnSeriesOptions<>()
                    .setAngleKey(angleKey)
                    .setRadiusKey(radiusKey);
            if (angleName != null)
            {
                series.setAngleName(angleName);
            }
            if (radiusName != null)
            {
                series.setRadiusName(radiusName);
            }
            if (legendItemName != null)
            {
                series.setLegendItemName(legendItemName);
            }

            if (grouped != null)
            {
                series.setGrouped(grouped);
            }
            if (stacked != null)
            {
                series.setStacked(stacked);
            }
            if (stackGroup != null)
            {
                series.setStackGroup(stackGroup);
            }
            if (normalizedTo != null)
            {
                series.setNormalizedTo(normalizedTo);
            }
            if (columnWidthRatio != null)
            {
                series.setColumnWidthRatio(columnWidthRatio);
            }
            if (maxColumnWidthRatio != null)
            {
                series.setMaxColumnWidthRatio(maxColumnWidthRatio);
            }

            if (cornerRadius != null)
            {
                series.setCornerRadius(cornerRadius);
            }
            if (fillOpacity != null)
            {
                series.setFillOpacity(fillOpacity);
            }
            if (stroke != null)
            {
                series.setStroke(stroke);
            }
            if (strokeWidth != null)
            {
                series.setStrokeWidth(strokeWidth);
            }
            if (strokeOpacity != null)
            {
                series.setStrokeOpacity(strokeOpacity);
            }
            if (lineDash != null)
            {
                series.setLineDash(lineDash);
            }
            if (lineDashOffset != null)
            {
                series.setLineDashOffset(lineDashOffset);
            }
            if (label != null)
            {
                series.setLabel(label);
            }

            if (showInLegend != null)
            {
                series.setShowInLegend(showInLegend);
            }
            if (data != null)
            {
                series.setData(data);
            }

            return new AgChartOptions<>()
                    .setAxes(axes)
                    .setSeries(java.util.List.of(series));
        });
    }
}
