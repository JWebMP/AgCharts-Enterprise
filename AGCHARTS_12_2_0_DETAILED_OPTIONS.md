# AgCharts Enterprise v12.2.0 - Detailed Options & Fields Reference

Complete reference for all available options and fields for each enterprise chart type in version 12.2.0.

## Financial Series Options

### Candlestick Series - `AgCandlestickSeriesOptions`

**Required Fields:**
- `type: 'candlestick'` - Series type identifier
- `xKey: string` - Data key for x-axis (typically dates)
- `openKey: string` - Data key for open values
- `closeKey: string` - Data key for close values
- `highKey: string` - Data key for high values
- `lowKey: string` - Data key for low values

**Optional Display Properties:**
- `id?: string` - Primary identifier (auto-generated if not provided)
- `title?: string` - Legend title
- `visible?: boolean` - Whether series is visible
- `showInLegend?: boolean` - Include in legend
- `showInMiniChart?: boolean` - Include in navigator mini-chart
- `cursor?: string` - CSS cursor on hover

**Naming/Tooltip:**
- `xName?: string` - Display name for x-values
- `yName?: string` - Display name for y-values
- `openName?: string` - Display name for open values
- `closeName?: string` - Display name for close values
- `highName?: string` - Display name for high values
- `lowName?: string` - Display name for low values

**Styling:**
- `item: AgCandlestickSeriesItem` - Item styling configuration
  - `up: { fill, stroke, wick }` - Up candlestick styling
    - `fill: CssColor` - Fill color
    - `stroke: CssColor` - Border color
    - `wick: { strokeWidth, stroke, strokeOpacity }` - Wick styling
  - `down: { fill, stroke, wick }` - Down candlestick styling

**Interaction:**
- `tooltip?: AgSeriesTooltip` - Custom tooltip configuration
- `highlight?: AgMultiSeriesHighlightOptions` - Hover highlight styling
- `itemStyler?: Styler` - Function for per-item styling
- `listeners?: AgSeriesListeners` - Event listeners
- `context?: any` - Custom context object
- `nodeClickRange?: InteractionRange` - Click interaction range

**Data:**
- `data?: TDatum[]` - Series data array

---

### OHLC Series - `AgOhlcSeriesOptions`

**Required Fields:**
- `type: 'ohlc'` - Series type identifier
- `xKey: string` - Data key for x-axis
- `openKey: string` - Data key for open values
- `closeKey: string` - Data key for close values
- `highKey: string` - Data key for high values
- `lowKey: string` - Data key for low values

**Structure:** Nearly identical to Candlestick series but uses vertical line format instead of candles

---

## Range Series Options

### Range Bar Series - `AgRangeBarSeriesOptions`

**Required Fields:**
- `type: 'range-bar'` - Series type identifier
- `xKey: string` - Category key for x-axis
- `yLowKey: string` - Low value key
- `yHighKey: string` - High value key

**Layout:**
- `direction?: 'vertical' | 'horizontal'` - Bar direction (default: vertical)
- `grouped?: boolean` - Group adjacent bars
- `cornerRadius?: PixelSize` - Corner radius for bars

**Naming/Tooltip:**
- `xName?: string` - Display name for x-values
- `yName?: string` - Display name for y-values
- `yLowName?: string` - Display name for low values
- `yHighName?: string` - Display name for high values
- `legendItemName?: string` - Legend item name

**Styling:**
- `fill?: AgColorType` - Bar fill color
- `fillOpacity?: Opacity` - Fill transparency (0-1)
- `stroke?: CssColor` - Border color
- `strokeWidth?: PixelSize` - Border width
- `strokeOpacity?: Opacity` - Border transparency
- `lineDash?: PixelSize[]` - Dash pattern [length, gap]
- `lineDashOffset?: PixelSize` - Dash offset

**Labels:**
- `label?: AgRangeBarSeriesLabelOptions`
  - `enabled?: boolean` - Show labels
  - `padding?: PixelSize` - Label padding
  - `formatter?: (params) => string` - Custom label formatter

**Shadow:**
- `shadow?: AgDropShadowOptions` - Drop shadow configuration

**Styling Functions:**
- `styler?: Styler` - Series-level styling function
- `itemStyler?: Styler` - Per-item styling function

**Highlighting:**
- `highlight?: AgMultiSeriesHighlightOptions` - Hover styling
- `segmentation?: AgSeriesSegmentation` - Segment styling

**Interaction:**
- `tooltip?: AgSeriesTooltip` - Tooltip configuration
- `listeners?: AgSeriesListeners` - Event listeners
- `cursor?: string` - Hover cursor
- `context?: any` - Custom context
- `nodeClickRange?: InteractionRange` - Click range

**Display:**
- `id?: string` - Series identifier
- `visible?: boolean` - Series visibility
- `showInLegend?: boolean` - Legend visibility
- `showInMiniChart?: boolean` - Mini-chart visibility
- `data?: TDatum[]` - Series data

---

### Range Area Series - `AgRangeAreaSeriesOptions`

**Similar to Range Bar with:**
- `type: 'range-area'`
- Area-specific styling options
- Fill and stroke properties for area visualization

---

## Matrix Series Options

### Heatmap Series - `AgHeatmapSeriesOptions`

**Required Fields:**
- `type: 'heatmap'` - Series type identifier
- `xKey: string` - X-axis category key
- `yKey: string` - Y-axis category key
- `colorKey: string` - Numeric key for color mapping

**Color Configuration:**
- `colorRange?: string[]` - Color interpolation array (minimum 2 colors)
  - Example: `['#43a2ca', '#a8ddb5', '#f0f9e8']`

**Naming:**
- `xName?: string` - X-axis display name
- `yName?: string` - Y-axis display name
- `colorName?: string` - Color value display name
- `title?: string` - Series title

**Labels:**
- `label?: AgChartAutoSizedSecondaryLabelOptions`
  - `enabled?: boolean` - Show cell labels
  - `formatter?: (params) => string` - Custom label formatter
- `itemPadding?: PixelSize` - Label padding in cells
- `textAlign?: TextAlign` - Label horizontal alignment
- `verticalAlign?: VerticalAlign` - Label vertical alignment

**Styling:**
- `stroke?: CssColor` - Cell border color
- `strokeWidth?: PixelSize` - Cell border width
- `strokeOpacity?: Opacity` - Border transparency
- `itemStyler?: Styler` - Per-cell styling function

**Interaction:**
- `tooltip?: AgSeriesTooltip` - Tooltip configuration
- `highlight?: AgHighlightOptions` - Hover highlighting
- `listeners?: AgSeriesListeners` - Event listeners
- `cursor?: string` - Hover cursor
- `nodeClickRange?: InteractionRange` - Click range

**Display:**
- `id?: string` - Series identifier
- `visible?: boolean` - Visibility
- `context?: any` - Custom context
- `data?: TDatum[]` - Series data
- `showInMiniChart?: boolean` - Mini-chart visibility

---

## Hierarchical Series Options

### Sankey Series - `AgSankeySeriesOptions`

**Required Fields:**
- `type: 'sankey'` - Series type identifier
- `fromKey: string` - Start node key
- `toKey: string` - End node key
- `sizeKey: string` - Link size/weight key

**Node Layout:**
- `node: AgSankeyNodeOptions`
  - `alignment?: 'left' | 'right' | 'center' | 'justify'` - Horizontal placement
  - `verticalAlignment?: 'top' | 'bottom' | 'center'` - Vertical placement
  - `sort?: 'data' | 'ascending' | 'descending' | 'auto'` - Node sorting
  - `fill?: CssColor` - Node fill color
  - `stroke?: CssColor` - Node border color
  - `strokeWidth?: PixelSize` - Border width

**Label Placement:**
- `label: AgSankeyLabelOptions`
  - `placement?: 'left' | 'right' | 'center'` - Label position
  - `edgePlacement?: 'inside' | 'outside'` - Edge label placement
  - `formatter?: (params) => string` - Custom formatter

**Link Styling:**
- `link: AgSankeyLinkOptions`
  - `fill?: CssColor` - Link fill color
  - `fillOpacity?: Opacity` - Fill transparency
  - `stroke?: CssColor` - Link stroke color
  - `strokeWidth?: PixelSize` - Stroke width
  - `strokeOpacity?: Opacity` - Stroke transparency

**Interaction:**
- `tooltip?: AgSeriesTooltip` - Tooltip configuration
- `listeners?: AgSeriesListeners` - Event listeners
- `cursor?: string` - Hover cursor

**Display:**
- `id?: string` - Series identifier
- `visible?: boolean` - Visibility
- `data?: TDatum[]` - Series data

---

### Sunburst Series - `AgSunburstSeriesOptions`

**Core Fields:**
- `type: 'sunburst'` - Series type identifier
- `labelKey?: string` - Node label key
- `valueKey?: string` - Node size key
- `childrenKey?: string` - Nested children array key

---

### Treemap Series - `AgTreemapSeriesOptions`

**Core Fields:**
- `type: 'treemap'` - Series type identifier
- `labelKey?: string` - Node label key
- `valueKey?: string` - Area sizing key
- `childrenKey?: string` - Nested children array key

---

## Statistical Series Options

### Waterfall Series - `AgWaterfallSeriesOptions`

**Required Fields:**
- `type: 'waterfall'` - Series type identifier
- `xKey: string` - Category key
- `yKey: string` - Value key

**Layout:**
- `direction?: 'vertical' | 'horizontal'` - Bar direction

**Totals/Subtotals:**
- `totals?: WaterfallSeriesTotalMeta[]` - Total row configuration
  - `totalType: 'total' | 'subtotal'` - Row type
  - `index: number` - Position in data
  - `axisLabel?: string` - Display label

**Item Styling:**
- `item: AgWaterfallSeriesItem`
  - `positive: { fill, stroke }` - Positive bar styling
  - `negative: { fill, stroke }` - Negative bar styling
  - `total: { fill, stroke, name }` - Total/subtotal styling

**Connector Lines:**
- `line: AgWaterfallSeriesLineOptions`
  - `enabled?: boolean` - Show connector lines
  - `strokeWidth?: PixelSize` - Line width
  - `stroke?: CssColor` - Line color

**Interaction:**
- `tooltip?: AgSeriesTooltip` - Tooltip configuration
- `listeners?: AgSeriesListeners` - Event listeners

**Display:**
- `id?: string` - Series identifier
- `visible?: boolean` - Visibility
- `showInLegend?: boolean` - Legend visibility
- `showInMiniChart?: boolean` - Mini-chart visibility
- `data?: TDatum[]` - Series data

---

### Box Plot Series - `AgBoxPlotSeriesOptions`

**Required Fields:**
- `type: 'box-plot'` - Series type identifier
- `xKey: string` - Category key
- `minKey: string` - Minimum value key
- `q1Key: string` - First quartile key
- `medianKey: string` - Median value key
- `q3Key: string` - Third quartile key
- `maxKey: string` - Maximum value key

---

### Histogram Series - `AgHistogramSeriesOptions`

**Required Fields:**
- `type: 'histogram'` - Series type identifier
- `xKey: string` - Data key for values
- `yKey?: string` - Optional y-values

**Binning:**
- `binCount?: number` - Number of histogram bins
- `agg?: 'count' | 'sum' | 'mean'` - Aggregation method

---

## Radar Series Options

### Radar Line Series - `AgRadarLineSeriesOptions`

**Required Fields:**
- `type: 'radar-line'` - Series type identifier
- `angleKey: string` - Angular/category key
- `radiusKey: string` - Radial/value key

**Styling:**
- `stroke?: CssColor` - Line color
- `strokeWidth?: PixelSize` - Line width
- `strokeOpacity?: Opacity` - Line transparency

---

### Radar Area Series - `AgRadarAreaSeriesOptions`

**Required Fields:**
- `type: 'radar-area'` - Series type identifier
- `angleKey: string` - Angular key
- `radiusKey: string` - Radial value key

**Styling:**
- `fill?: CssColor` - Area fill color
- `fillOpacity?: Opacity` - Fill transparency
- `stroke?: CssColor` - Border color
- `strokeWidth?: PixelSize` - Border width

---

### Nightingale Series - `AgNightingaleSeriesOptions`

**Core Fields:**
- `type: 'nightingale'` - Series type identifier
- `angleKey: string` - Angular category
- `radiusKey: string` - Radius value
- `sizeKey?: string` - Optional size variation

---

## Gauge Series Options

### Radial Gauge - `AgRadialGaugeOptions`

**Required Fields:**
- `type: 'radial-gauge'` - Gauge type identifier
- `value: number` - Displayed value

**Layout:**
- `container?: HTMLElement` - DOM element for rendering
- `width?: PixelSize` - Chart width
- `height?: PixelSize` - Chart height
- `minWidth?: PixelSize` - Minimum width (default: 300)
- `minHeight?: PixelSize` - Minimum height (default: 300)

**Scale Configuration:**
- `scale: AgRadialGaugeScale`
  - `min: number` - Minimum scale value
  - `max: number` - Maximum scale value
  - `fill?: CssColor` - Scale background fill
  - `label?: { enabled, fontSize, fontWeight, ... }` - Scale labels

**Gauge Geometry:**
- `startAngle?: Degree` - Start angle (degrees, clockwise from top)
- `endAngle?: Degree` - End angle
- `outerRadius?: PixelSize` - Outer radius in pixels
- `innerRadius?: PixelSize` - Inner radius in pixels
- `outerRadiusRatio?: Ratio` - Outer radius as proportion
- `innerRadiusRatio?: Ratio` - Inner radius as proportion

**Bar Configuration:**
- `bar: AgRadialGaugeBarStyle`
  - `enabled?: boolean` - Show bar indicator
  - `fill?: CssColor` - Bar color
  - `fills?: Array<{ color, stop? }>` - Color stops for gradient
  - `fillMode?: 'continuous' | 'discrete'` - Gradient mode

**Needle Configuration:**
- `needle: AgRadialGaugeNeedleStyle`
  - `enabled?: boolean` - Show needle
  - `fill?: CssColor` - Needle color
  - `length?: number` - Needle length

**Labels:**
- `label: AgRadialGaugeLabelOptions`
  - `formatter?: (params) => string` - Value formatter
- `secondaryLabel: AgRadialGaugeSecondaryLabelOptions`
  - `text?: string` - Fixed label text

**Segmentation:**
- `segmentation: AgGaugeSegmentation`
  - `enabled?: boolean` - Enable segments
  - `interval: { step | count | values }` - Segment interval
  - `spacing?: PixelSize` - Space between segments

**Corner Radius:**
- `cornerRadius?: number` - Curved corner amount
- `cornerMode?: 'container' | 'item'` - Apply to ends only or each item

**Targets/Thresholds:**
- `targets?: AgRadialGaugeTarget[]` - Target markers
  - `value: number` - Target position
  - `shape?: 'triangle' | 'circle'` - Marker shape
  - `placement?: 'inside' | 'outside' | 'middle'` - Marker position
  - `text?: string` - Optional label
  - `fill?: CssColor` - Marker color
  - `strokeWidth?: PixelSize` - Marker border
  - `spacing?: PixelSize` - Distance from gauge edge
  - `size?: PixelSize` - Marker size

**Interaction:**
- `tooltip?: AgChartTooltipOptions` - Tooltip configuration
- `contextMenu?: AgContextMenuOptions` - Context menu
- `listeners?: AgBaseChartListeners` - Event listeners
- `highlight?: AgHighlightOptions` - Hover effects

**Theme & Styling:**
- `theme?: AgChartTheme | AgChartThemeName` - Color theme
- `animation?: AgAnimationOptions` - Animation settings

---

### Linear Gauge - `AgLinearGaugeOptions`

**Required Fields:**
- `type: 'linear-gauge'` - Gauge type identifier
- `value: number` - Displayed value

**Orientation:**
- `direction?: 'vertical' | 'horizontal'` - Gauge direction

**Scale:**
- `scale: AgLinearGaugeScale`
  - `min: number` - Minimum value
  - `max: number` - Maximum value

**Dimensions:**
- `thickness?: PixelSize` - Scale thickness
- `thicknessRatio?: Ratio` - Thickness as proportion

**Bar:**
- `bar: AgLinearGaugeBarStyle`
  - `enabled?: boolean` - Show bar
  - `thickness?: PixelSize` - Bar thickness
  - `thicknessRatio?: Ratio` - Bar thickness ratio
  - `fill?: CssColor` - Bar color
  - `fills?: Array<{ color, stop? }>` - Color stops

**Label:**
- `label: AgLinearGaugeLabelOptions`
  - `enabled?: boolean` - Show label
  - `placement?: 'inside-start' | 'inside-end' | 'inside-center' | 'outside-start' | 'outside-end'`
  - `avoidCollisions?: boolean` - Avoid overlapping
  - `formatter?: (params) => string` - Custom formatter

**Segmentation:**
- `segmentation: AgGaugeSegmentation` - (Same as radial)

**Corner Radius:**
- `cornerRadius?: number` - Curved corners
- `cornerMode?: 'container' | 'item'`

**Targets:**
- `targets?: AgLinearGaugeTarget[]` - Threshold markers
  - `placement?: 'before' | 'after' | 'middle'` - Position
  - (Other properties similar to radial)

---

## Advanced Chart Series

### Chord Series - `AgChordSeriesOptions`

**Core Fields:**
- `type: 'chord'` - Series type identifier
- `fromKey: string` - Source node key
- `toKey: string` - Target node key
- `sizeKey?: string` - Link magnitude key

---

### Funnel Series - `AgFunnelSeriesOptions`

**Core Fields:**
- `type: 'funnel'` - Series type identifier
- `xKey?: string` - Category key
- `yKey: string` - Value key (determines width)

---

### Cone Funnel Series - `AgConeFunnelSeriesOptions`

**Core Fields:**
- `type: 'cone-funnel'` - Series type identifier
- Similar structure to Funnel with 3D perspective

---

### Pyramid Series - `AgPyramidSeriesOptions`

**Core Fields:**
- `type: 'pyramid'` - Series type identifier
- `xKey?: string` - Category key
- `yKey: string` - Value key

---

### Radial Column Series - `AgRadialColumnSeriesOptions`

**Core Fields:**
- `type: 'radial-column'` - Series type identifier
- `angleKey: string` - Angular category
- `radiusKey: string` - Radius value

---

### Radial Bar Series - `AgRadialBarSeriesOptions`

**Core Fields:**
- `type: 'radial-bar'` - Series type identifier
- Similar structure to Radial Column

---

## Common Series Properties (Inherited by All)

**Standard Properties:**
- `id?: string` - Series identifier (auto-generated if omitted)
- `visible?: boolean` - Series visibility toggle
- `showInLegend?: boolean` - Include in legend
- `showInMiniChart?: boolean` - Include in navigator
- `data?: TDatum[]` - Series data array
- `cursor?: string` - CSS cursor on hover

**Interaction:**
- `tooltip?: AgSeriesTooltip` - Custom tooltip
- `highlight?: AgMultiSeriesHighlightOptions | AgHighlightOptions` - Hover styling
- `listeners?: AgSeriesListeners` - Event callbacks
- `context?: any` - Custom context for callbacks
- `nodeClickRange?: InteractionRange` - Click sensitivity

**Styling:**
- `styler?: Styler` - Series-level style function
- `itemStyler?: Styler` - Per-item style function

---

## Global Chart Configuration Options

These options apply to `AgChartOptions` and most gauge types:

### Layout
- `theme?: AgChartTheme | AgChartThemeName`
- `width?: PixelSize`
- `height?: PixelSize`
- `minWidth?: PixelSize`
- `minHeight?: PixelSize`
- `padding?: AgChartPaddingOptions`

### Features
- `animation?: AgAnimationOptions` - Animation control
- `zoom?: AgZoomOptions` - Zoom/pan capabilities
- `navigator?: AgNavigatorOptions` - Navigator control
- `contextMenu?: AgContextMenuOptions` - Right-click menus
- `sync?: AgChartSyncOptions` - Multi-chart sync
- `ranges?: AgRangesOptions` - Time range buttons
- `dataSource?: AgDataSourceOptions` - Async data loading

### UI Elements
- `title?: AgChartCaptionOptions`
- `subtitle?: AgChartSubtitleOptions`
- `footnote?: AgChartFooterOptions`
- `tooltip?: AgChartTooltipOptions`
- `legend?: AgChartLegendOptions`
- `gradientLegend?: AgGradientLegendOptions`
- `background?: AgChartBackground`
- `highlight?: AgChartHighlightOptions`

### Data & Interaction
- `data?: TDatum[]` - Chart data
- `keyboard?: AgKeyboardOptions` - Keyboard controls
- `touch?: AgTouchOptions` - Touch interactions

---

## Comparison Summary for Implementation

**Use this to create/update option types:**

| Series Type | Required Keys | Unique Features | Styling Type |
|---|---|---|---|
| Candlestick | xKey, openKey, closeKey, highKey, lowKey | item.up/down styling | Bar styling |
| OHLC | xKey, openKey, closeKey, highKey, lowKey | OHLC-specific rendering | Line styling |
| Range Bar | xKey, yLowKey, yHighKey | direction (v/h) | Fill/stroke |
| Heatmap | xKey, yKey, colorKey | colorRange array | Color interpolation |
| Sankey | fromKey, toKey, sizeKey | node/link layout | Node/link color |
| Waterfall | xKey, yKey | totals array, item types | Positive/negative/total |
| Box Plot | xKey, minKey, q1Key, medianKey, q3Key, maxKey | Statistical | Box styling |
| Radial Gauge | type, value | scale (min/max) | Bar/needle/segment |
| Linear Gauge | type, value | direction | Bar/segment |
| Radar Line | angleKey, radiusKey | Radial layout | Line/stroke |
| Sunburst | labelKey, valueKey, childrenKey | Hierarchical | Segment color |

