package com.jwebmp.plugins.agchartsenterprise.options.gauge;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.jwebmp.core.htmlbuilder.javascript.JavaScriptPart;
import com.jwebmp.plugins.agcharts.options.AgChartBackground;
import com.jwebmp.plugins.agcharts.options.AgChartCaptionOptions;
import com.jwebmp.plugins.agcharts.options.locale.AgLocaleOptions;
import com.jwebmp.plugins.agcharts.options.theme.AgChartTheme;
import com.jwebmp.plugins.agcharts.options.theme.AgChartThemeName;
import com.jwebmp.plugins.agcharts.options.tooltip.AgChartTooltipOptions;

import java.util.List;

/**
 * Enterprise: Radial Gauge root options.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AgRadialGaugeOptions<J extends AgRadialGaugeOptions<J>> extends JavaScriptPart<J>
{
    private final String type = "radial-gauge";

    // core
    private Number value; // required

    // theming / container
    private Object theme; // AgChartTheme | AgChartThemeName (string)
    private Object container; // HTMLElement | null (left for runtime)

    // layout
    private Integer width;
    private Integer height;
    private Integer minHeight; // default 300 at runtime
    private Integer minWidth;  // default 300 at runtime
    private Object padding;    // number | {top,right,bottom,left}

    private AgChartBackground<?> background;
    private AgChartCaptionOptions<?> title;
    private AgChartCaptionOptions<?> subtitle;
    private AgChartCaptionOptions<?> footnote;

    private AgChartTooltipOptions<?> tooltip;
    private Object animation; // keep generic
    private Object contextMenu; // keep generic
    private Object context; // user context
    private AgLocaleOptions<?> locale;
    private Object listeners; // base chart listeners - generic

    // gauge specific
    private List<AgRadialGaugeTarget<?>> targets;

    private Integer outerRadius; // px
    private Integer innerRadius; // px
    private Double outerRadiusRatio; // ratio
    private Double innerRadiusRatio; // ratio

    private Integer startAngle; // deg
    private Integer endAngle;   // deg

    private AgGaugeSegmentation<?> segmentation;
    private Integer cornerRadius;
    private AgGaugeCornerMode cornerMode;

    private AgRadialGaugeNeedleStyle<?> needle;
    private AgRadialGaugeScale<?> scale;
    private AgRadialGaugeBarStyle<?> bar;

    private AgRadialGaugeLabelOptions<?> label;
    private AgRadialGaugeSecondaryLabelOptions<?> secondaryLabel;

    private Integer spacing; // px between text and shape edges

    private String cursor;
    private Object highlight; // reuse general highlight model if needed
    private Object nodeClickRange; // InteractionRange

    /**
     * Gets the chart type identifier.
     * <p>
     * Always returns "radial-gauge" for radial gauge charts. This is used internally
     * by AG Charts to identify the chart type for rendering and configuration.
     *
     * @return the chart type, always "radial-gauge"
     */
    public String getType() {return type;}

    /**
     * Gets the current value displayed on the gauge.
     * <p>
     * This is the primary value that the gauge needle points to and represents
     * the main data being visualized. The value should typically fall within
     * the scale's min/max range for optimal display.
     *
     * @return the current gauge value, or null if not set
     */
    public Number getValue() {return value;}

    /**
     * Sets the current value to display on the gauge.
     * <p>
     * This is the primary data value that determines where the gauge needle
     * points. Values outside the scale's min/max range will still be displayed
     * but may extend beyond the visible scale area.
     *
     * @param value the numeric value to display on the gauge
     * @return this instance for method chaining
     */
    public J setValue(Number value)
    {
        this.value = value;
        return (J) this;
    }

    /**
     * Gets the current theme configuration.
     * <p>
     * The theme controls the overall visual appearance of the gauge including
     * colors, fonts, and styling. Can be a theme object, theme name string,
     * or predefined theme constant.
     *
     * @return the theme configuration (AgChartTheme, String, or AgChartThemeName), or null if using default
     */
    public Object getTheme() {return theme;}

    /**
     * Sets a custom theme object for the gauge.
     * <p>
     * Applies a comprehensive theme configuration that defines colors, fonts,
     * spacing, and other visual properties. Custom themes allow complete
     * control over the gauge's appearance.
     *
     * @param theme the custom theme object defining all visual properties
     * @return this instance for method chaining
     */
    public J setTheme(AgChartTheme<?> theme)
    {
        this.theme = theme;
        return (J) this;
    }

    /**
     * Sets a theme using a theme name string.
     * <p>
     * Applies one of the built-in themes by name. Common theme names include
     * "ag-default", "ag-dark", "ag-material", etc. Theme names provide
     * predefined styling configurations.
     *
     * @param themeName the name of a built-in theme (e.g., "ag-default", "ag-dark")
     * @return this instance for method chaining
     */
    public J setTheme(String themeName)
    {
        this.theme = themeName;
        return (J) this;
    }

    /**
     * Sets a theme using a predefined theme constant.
     * <p>
     * Applies one of the predefined theme constants from AgChartThemeName enum.
     * These provide type-safe access to built-in themes with consistent naming
     * and prevent typos in theme names.
     *
     * @param themeName the predefined theme constant (e.g., AgChartThemeName.AG_DEFAULT)
     * @return this instance for method chaining
     */
    public J setTheme(AgChartThemeName themeName)
    {
        this.theme = themeName != null ? themeName.toString() : null;
        return (J) this;
    }

    /**
     * Gets the DOM container element for the gauge.
     * <p>
     * The container is the HTML element where the gauge will be rendered.
     * This is typically set at runtime and may be null during configuration.
     *
     * @return the DOM container element, or null if not set or not applicable
     */
    public Object getContainer() {return container;}

    /**
     * Sets the DOM container element for the gauge.
     * <p>
     * Specifies the HTML element where the gauge should be rendered. This is
     * typically an HTMLElement but kept as Object for flexibility with different
     * environments and frameworks.
     *
     * @param container the DOM element that will contain the gauge
     * @return this instance for method chaining
     */
    public J setContainer(Object container)
    {
        this.container = container;
        return (J) this;
    }

    /**
     * Gets the fixed width of the gauge in pixels.
     * <p>
     * When set, the gauge will be rendered with this exact width regardless
     * of container size. If not set, the gauge will size to fit its container.
     *
     * @return the fixed width in pixels, or null for automatic sizing
     */
    public Integer getWidth() {return width;}

    /**
     * Sets a fixed width for the gauge in pixels.
     * <p>
     * Forces the gauge to render with the specified width, overriding any
     * container-based sizing. Use null to enable automatic width based on
     * the container size.
     *
     * @param width the desired width in pixels, or null for automatic sizing
     * @return this instance for method chaining
     */
    public J setWidth(Integer width)
    {
        this.width = width;
        return (J) this;
    }

    /**
     * Gets the fixed height of the gauge in pixels.
     * <p>
     * When set, the gauge will be rendered with this exact height regardless
     * of container size. If not set, the gauge will size to fit its container.
     *
     * @return the fixed height in pixels, or null for automatic sizing
     */
    public Integer getHeight() {return height;}

    /**
     * Sets a fixed height for the gauge in pixels.
     * <p>
     * Forces the gauge to render with the specified height, overriding any
     * container-based sizing. Use null to enable automatic height based on
     * the container size.
     *
     * @param height the desired height in pixels, or null for automatic sizing
     * @return this instance for method chaining
     */
    public J setHeight(Integer height)
    {
        this.height = height;
        return (J) this;
    }

    /**
     * Gets the minimum height constraint for the gauge.
     * <p>
     * The gauge will never be rendered smaller than this height, even if the
     * container is smaller. Defaults to 300 pixels at runtime if not specified.
     *
     * @return the minimum height in pixels, or null if using default (300px)
     */
    public Integer getMinHeight() {return minHeight;}

    /**
     * Sets the minimum height constraint for the gauge.
     * <p>
     * Ensures the gauge maintains a minimum readable size even in small containers.
     * The gauge will be at least this tall, potentially causing scrolling if the
     * container is smaller.
     *
     * @param minHeight the minimum height in pixels (defaults to 300px if null)
     * @return this instance for method chaining
     */
    public J setMinHeight(Integer minHeight)
    {
        this.minHeight = minHeight;
        return (J) this;
    }

    /**
     * Gets the minimum width constraint for the gauge.
     * <p>
     * The gauge will never be rendered smaller than this width, even if the
     * container is smaller. Defaults to 300 pixels at runtime if not specified.
     *
     * @return the minimum width in pixels, or null if using default (300px)
     */
    public Integer getMinWidth() {return minWidth;}

    /**
     * Sets the minimum width constraint for the gauge.
     * <p>
     * Ensures the gauge maintains a minimum readable size even in small containers.
     * The gauge will be at least this wide, potentially causing scrolling if the
     * container is smaller.
     *
     * @param minWidth the minimum width in pixels (defaults to 300px if null)
     * @return this instance for method chaining
     */
    public J setMinWidth(Integer minWidth)
    {
        this.minWidth = minWidth;
        return (J) this;
    }

    /**
     * Gets the padding configuration around the gauge.
     * <p>
     * Padding creates space between the gauge content and its container edges.
     * Can be a single number for uniform padding or an object with individual
     * top, right, bottom, and left values.
     *
     * @return the padding configuration (Integer for uniform, or Object for individual sides), or null for default
     */
    public Object getPadding() {return padding;}

    /**
     * Sets uniform padding around all sides of the gauge.
     * <p>
     * Applies the same padding value to all four sides (top, right, bottom, left).
     * This creates consistent spacing between the gauge and its container.
     *
     * @param padding the padding value in pixels to apply to all sides
     * @return this instance for method chaining
     */
    public J setPadding(Integer padding)
    {
        this.padding = padding;
        return (J) this;
    }

    /**
     * Sets individual padding values for each side of the gauge.
     * <p>
     * Allows different padding values for each side using an object with
     * properties like {top: 10, right: 20, bottom: 10, left: 20}. Provides
     * fine-grained control over spacing.
     *
     * @param padding an object with padding properties for individual sides
     * @return this instance for method chaining
     */
    public J setPadding(Object padding)
    {
        this.padding = padding;
        return (J) this;
    }

    /**
     * Gets the background configuration for the gauge.
     * <p>
     * The background defines the visual appearance behind the gauge, including
     * colors, gradients, images, and other styling properties that appear
     * behind all other gauge elements.
     *
     * @return the background configuration, or null if using default transparent background
     */
    public AgChartBackground<?> getBackground() {return background;}

    /**
     * Sets the background configuration for the gauge.
     * <p>
     * Configures the visual appearance behind all gauge elements. This can include
     * solid colors, gradients, images, or other styling properties that create
     * the backdrop for the gauge visualization.
     *
     * @param background the background configuration for styling behind gauge elements
     * @return this instance for method chaining
     */
    public J setBackground(AgChartBackground<?> background)
    {
        this.background = background;
        return (J) this;
    }

    /**
     * Gets the main title configuration for the gauge.
     * <p>
     * The title appears prominently above or within the gauge to describe
     * what the gauge represents. Includes text content, positioning, and
     * styling options.
     *
     * @return the title configuration, or null if no title is displayed
     */
    public AgChartCaptionOptions<?> getTitle() {return title;}

    /**
     * Sets the main title for the gauge.
     * <p>
     * Configures the primary title that describes what the gauge represents.
     * The title can be positioned and styled according to the caption options,
     * providing context to viewers about the gauge's purpose.
     *
     * @param title the title configuration including text, positioning, and styling
     * @return this instance for method chaining
     */
    public J setTitle(AgChartCaptionOptions<?> title)
    {
        this.title = title;
        return (J) this;
    }

    /**
     * Gets the subtitle configuration for the gauge.
     * <p>
     * The subtitle provides additional descriptive text below the main title,
     * often used for units, context, or supplementary information about
     * the gauge data.
     *
     * @return the subtitle configuration, or null if no subtitle is displayed
     */
    public AgChartCaptionOptions<?> getSubtitle() {return subtitle;}

    public J setSubtitle(AgChartCaptionOptions<?> subtitle)
    {
        this.subtitle = subtitle;
        return (J) this;
    }

    public AgChartCaptionOptions<?> getFootnote() {return footnote;}

    public J setFootnote(AgChartCaptionOptions<?> footnote)
    {
        this.footnote = footnote;
        return (J) this;
    }

    public AgChartTooltipOptions<?> getTooltip() {return tooltip;}

    public J setTooltip(AgChartTooltipOptions<?> tooltip)
    {
        this.tooltip = tooltip;
        return (J) this;
    }

    public Object getAnimation() {return animation;}

    public J setAnimation(Object animation)
    {
        this.animation = animation;
        return (J) this;
    }

    public Object getContextMenu() {return contextMenu;}

    public J setContextMenu(Object contextMenu)
    {
        this.contextMenu = contextMenu;
        return (J) this;
    }

    public Object getContext() {return context;}

    public J setContext(Object context)
    {
        this.context = context;
        return (J) this;
    }

    public AgLocaleOptions<?> getLocale() {return locale;}

    public J setLocale(AgLocaleOptions<?> locale)
    {
        this.locale = locale;
        return (J) this;
    }

    public Object getListeners() {return listeners;}

    public J setListeners(Object listeners)
    {
        this.listeners = listeners;
        return (J) this;
    }

    public List<AgRadialGaugeTarget<?>> getTargets() {return targets;}

    public J setTargets(List<AgRadialGaugeTarget<?>> targets)
    {
        this.targets = targets;
        return (J) this;
    }

    /**
     * Gets the outer radius of the gauge in pixels.
     * <p>
     * The outer radius defines the size of the gauge's outer edge in absolute pixels.
     * This determines the overall size of the gauge circle. Takes precedence over
     * outerRadiusRatio when both are specified.
     *
     * @return the outer radius in pixels, or null if using ratio-based sizing
     */
    public Integer getOuterRadius() {return outerRadius;}

    /**
     * Sets the outer radius of the gauge in pixels.
     * <p>
     * Defines the absolute size of the gauge's outer edge. This creates a fixed-size
     * gauge regardless of container dimensions. When set, overrides any
     * outerRadiusRatio configuration.
     *
     * @param outerRadius the outer radius in pixels (must be positive)
     * @return this instance for method chaining
     */
    public J setOuterRadius(Integer outerRadius)
    {
        this.outerRadius = outerRadius;
        return (J) this;
    }

    /**
     * Gets the inner radius of the gauge in pixels.
     * <p>
     * The inner radius creates a hollow center in the gauge, forming a ring shape.
     * This is the absolute pixel distance from the center where the gauge ring
     * begins. Takes precedence over innerRadiusRatio when both are specified.
     *
     * @return the inner radius in pixels, or null if using ratio-based sizing or solid gauge
     */
    public Integer getInnerRadius() {return innerRadius;}

    /**
     * Sets the inner radius of the gauge in pixels.
     * <p>
     * Creates a hollow center with the specified pixel radius, forming a ring-shaped
     * gauge. Must be smaller than the outer radius. When set, overrides any
     * innerRadiusRatio configuration.
     *
     * @param innerRadius the inner radius in pixels (must be positive and less than outer radius)
     * @return this instance for method chaining
     */
    public J setInnerRadius(Integer innerRadius)
    {
        this.innerRadius = innerRadius;
        return (J) this;
    }

    /**
     * Gets the outer radius as a ratio of available space.
     * <p>
     * The outer radius ratio determines the gauge size as a fraction (0.0 to 1.0)
     * of the available container space. This creates responsive gauges that scale
     * with their container size.
     *
     * @return the outer radius ratio (0.0 to 1.0), or null if using pixel-based sizing
     */
    public Double getOuterRadiusRatio() {return outerRadiusRatio;}

    /**
     * Sets the outer radius as a ratio of available space.
     * <p>
     * Configures the gauge size as a fraction of the available container space.
     * A value of 0.8 means the gauge will use 80% of the available space.
     * This creates responsive gauges that automatically scale with container size.
     *
     * @param outerRadiusRatio the outer radius ratio (should be between 0.0 and 1.0)
     * @return this instance for method chaining
     */
    public J setOuterRadiusRatio(Double outerRadiusRatio)
    {
        this.outerRadiusRatio = outerRadiusRatio;
        return (J) this;
    }

    /**
     * Gets the inner radius as a ratio of the outer radius.
     * <p>
     * The inner radius ratio determines the size of the hollow center as a fraction
     * (0.0 to 1.0) of the outer radius. This creates responsive ring gauges where
     * the inner hole scales proportionally with the overall gauge size.
     *
     * @return the inner radius ratio (0.0 to 1.0), or null if using pixel-based sizing or solid gauge
     */
    public Double getInnerRadiusRatio() {return innerRadiusRatio;}

    /**
     * Sets the inner radius as a ratio of the outer radius.
     * <p>
     * Creates a hollow ring gauge where the inner radius is a fraction of the outer
     * radius. A value of 0.5 means the inner hole will be half the size of the outer
     * radius. This maintains proportional scaling as the gauge size changes.
     *
     * @param innerRadiusRatio the inner radius ratio (should be between 0.0 and 1.0, less than 1.0)
     * @return this instance for method chaining
     */
    public J setInnerRadiusRatio(Double innerRadiusRatio)
    {
        this.innerRadiusRatio = innerRadiusRatio;
        return (J) this;
    }

    /**
     * Gets the starting angle of the gauge arc in degrees.
     * <p>
     * The start angle determines where the gauge scale begins, measured in degrees
     * from the positive x-axis (3 o'clock position). Positive angles rotate clockwise.
     * Default is typically -90 degrees (12 o'clock position).
     *
     * @return the start angle in degrees, or null if using default (-90 degrees)
     */
    public Integer getStartAngle() {return startAngle;}

    /**
     * Sets the starting angle of the gauge arc in degrees.
     * <p>
     * Defines where the gauge scale begins, measured clockwise from the positive x-axis.
     * Common values: -90 (top), 0 (right), 90 (bottom), 180 (left). The gauge arc
     * will span from this angle to the end angle.
     *
     * @param startAngle the start angle in degrees (typically -180 to 180)
     * @return this instance for method chaining
     */
    public J setStartAngle(Integer startAngle)
    {
        this.startAngle = startAngle;
        return (J) this;
    }

    /**
     * Gets the ending angle of the gauge arc in degrees.
     * <p>
     * The end angle determines where the gauge scale ends, measured in degrees
     * from the positive x-axis (3 o'clock position). Must be greater than start angle
     * for proper arc rendering. Default is typically 90 degrees (6 o'clock position).
     *
     * @return the end angle in degrees, or null if using default (90 degrees)
     */
    public Integer getEndAngle() {return endAngle;}

    /**
     * Sets the ending angle of the gauge arc in degrees.
     * <p>
     * Defines where the gauge scale ends, measured clockwise from the positive x-axis.
     * Must be greater than the start angle to create a valid arc. The total arc span
     * determines how much of a circle the gauge occupies.
     *
     * @param endAngle the end angle in degrees (must be greater than start angle)
     * @return this instance for method chaining
     */
    public J setEndAngle(Integer endAngle)
    {
        this.endAngle = endAngle;
        return (J) this;
    }

    public AgGaugeSegmentation<?> getSegmentation() {return segmentation;}

    public J setSegmentation(AgGaugeSegmentation<?> segmentation)
    {
        this.segmentation = segmentation;
        return (J) this;
    }

    public Integer getCornerRadius() {return cornerRadius;}

    public J setCornerRadius(Integer cornerRadius)
    {
        this.cornerRadius = cornerRadius;
        return (J) this;
    }

    public AgGaugeCornerMode getCornerMode() {return cornerMode;}

    public J setCornerMode(AgGaugeCornerMode cornerMode)
    {
        this.cornerMode = cornerMode;
        return (J) this;
    }

    public AgRadialGaugeNeedleStyle<?> getNeedle() {return needle;}

    public J setNeedle(AgRadialGaugeNeedleStyle<?> needle)
    {
        this.needle = needle;
        return (J) this;
    }

    public AgRadialGaugeScale<?> getScale() {return scale;}

    public J setScale(AgRadialGaugeScale<?> scale)
    {
        this.scale = scale;
        return (J) this;
    }

    public AgRadialGaugeBarStyle<?> getBar() {return bar;}

    public J setBar(AgRadialGaugeBarStyle<?> bar)
    {
        this.bar = bar;
        return (J) this;
    }

    public AgRadialGaugeLabelOptions<?> getLabel() {return label;}

    public J setLabel(AgRadialGaugeLabelOptions<?> label)
    {
        this.label = label;
        return (J) this;
    }

    public AgRadialGaugeSecondaryLabelOptions<?> getSecondaryLabel() {return secondaryLabel;}

    public J setSecondaryLabel(AgRadialGaugeSecondaryLabelOptions<?> secondaryLabel)
    {
        this.secondaryLabel = secondaryLabel;
        return (J) this;
    }

    public Integer getSpacing() {return spacing;}

    public J setSpacing(Integer spacing)
    {
        this.spacing = spacing;
        return (J) this;
    }

    public String getCursor() {return cursor;}

    public J setCursor(String cursor)
    {
        this.cursor = cursor;
        return (J) this;
    }

    public Object getHighlight() {return highlight;}

    public J setHighlight(Object highlight)
    {
        this.highlight = highlight;
        return (J) this;
    }

    public Object getNodeClickRange() {return nodeClickRange;}

    public J setNodeClickRange(Object nodeClickRange)
    {
        this.nodeClickRange = nodeClickRange;
        return (J) this;
    }
}
