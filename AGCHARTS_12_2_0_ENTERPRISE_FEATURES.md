# AgCharts Enterprise v12.2.0 - Features, Options & Fields

This document catalogs all enterprise-exclusive graphs, options, and fields available in AG Charts Enterprise version 12.2.0.

## Enterprise Chart Types (20+ Advanced Chart Types)

### Financial Charts
- **Candlestick** - OHLC candlestick visualization with open, high, low, close data
  - Options: `AgCandlestickSeriesOptions`
- **OHLC** (Open-High-Low-Close) - Alternative financial chart representation
  - Options: `AgOhlcSeriesOptions`
- **Financial Charts Component** - Pre-configured financial chart with built-in features
  - Options: `AgFinancialChartOptions`
  - Includes: Toolbar, Annotations, Trend Lines, Range Buttons, Zoom capabilities

### Range-Based Charts
- **Range Bar** - Bar charts with range (min-max) values
  - Options: `AgRangeBarSeriesOptions`
- **Range Area** - Area charts with range bands
  - Options: `AgRangeAreaSeriesOptions`

### Advanced Visualizations
- **Heatmap** - Color-coded grid for matrix data visualization
  - Options: `AgHeatmapSeriesOptions`
- **Sankey** - Flow diagram showing relationships and volumes
  - Options: `AgSankeySeriesOptions`
- **Chord** - Circular relationship diagram
  - Options: `AgChordSeriesOptions`
- **Sunburst** - Hierarchical radial chart
  - Options: `AgSunburstSeriesOptions`
- **Treemap** - Hierarchical rectangular area chart
  - Options: `AgTreemapSeriesOptions`
- **Funnel** - Funnel chart for sequential stages
  - Options: `AgFunnelSeriesOptions`
- **Cone Funnel** - 3D-style conical funnel
  - Options: `AgConeFunnelSeriesOptions`
- **Pyramid** - Pyramid chart for hierarchical data
  - Options: `AgPyramidSeriesOptions`

### Statistical Charts
- **Waterfall** - Shows incremental changes across categories
  - Options: `AgWaterfallSeriesOptions`
- **Box Plot** - Statistical distribution visualization
  - Options: `AgBoxPlotSeriesOptions`
- **Histogram** - Frequency distribution chart
  - Options: `AgHistogramSeriesOptions`

### Radar Charts
- **Radar Line** - Multi-dimensional line chart on radar axes
  - Options: `AgRadarLineSeriesOptions`
- **Radar Area** - Multi-dimensional area chart on radar axes
  - Options: `AgRadarAreaSeriesOptions`
- **Nightingale** - Radial area chart variant
  - Options: `AgNightingaleSeriesOptions`

### Gauge Charts
- **Radial Gauge** - Circular gauge/speedometer visualization
  - Options: `AgRadialGaugeSeriesOptions`
- **Linear Gauge** - Linear gauge visualization
  - Options: `AgLinearGaugeSeriesOptions`

### Specialized Charts
- **Radial Column** - Columns arranged in circular pattern
  - Options: `AgRadialColumnSeriesOptions`
- **Radial Bar** - Bars arranged in circular pattern
  - Options: `AgRadialBarSeriesOptions`
- **Combination** - Multi-series charts combining different types
  - Options: `AgCombinationSeriesOptions`
- **Map** - Geographic/spatial data visualization
  - Options: `AgMapSeriesOptions`

## Core Enterprise Options

### Animation Configuration
**`AgAnimationOptions`** - Control chart animations
- `enabled` (boolean) - Enable/disable animations
- `duration` (DurationMs) - Total animation duration in milliseconds
  - Controls both initial load and data update animations
  - Three phases for updates: remove, update, then add

### Advanced Interactivity

#### Zoom Options
**`AgZoomOptions`** - Comprehensive zoom functionality
- `enabled` (boolean, default: false) - Enable zoom module
- `enableScrolling` (boolean, default: true) - Mouse wheel/trackpad zoom
- `enablePanning` (boolean, default: true) - Click-drag panning
- `enableSelecting` (boolean, default: false) - Area-selection zoom
- `enableAxisDragging` (boolean, default: true) - Axis drag to zoom
- `enableAxisScrolling` (boolean, default: false) - Axis scroll to zoom
- `enableDoubleClickToReset` (boolean, default: true) - Double-click reset
- `enableTwoFingerZoom` (boolean, default: true) - Touch pinch zoom
- `anchorPointX` (AgZoomAnchorPoint, default: 'end') - X-axis zoom anchor
- `anchorPointY` (AgZoomAnchorPoint, default: 'middle') - Y-axis zoom anchor
- `axes` (AgZoomAxes, default: 'x') - Zoom axes: 'x', 'y', or 'xy'
- `scrollingStep` (Ratio, default: 0.1) - Zoom step per scroll (10%)
- `minVisibleItems` (number, default: 2) - Limit zoom depth
- `panKey` (AgZoomPanKey, default: 'alt') - Modifier key for panning: 'alt', 'ctrl', 'shift', 'meta'
- `keepAspectRatio` (boolean, default: false) - Maintain aspect ratio during selection zoom
- `deceleration` (AgZoomDeceleration, default: 'short') - Pan deceleration rate
- **Zoom Auto-Scaling**
  - `autoScaling.enabled` (boolean, default: true) - Auto-fit y-axis to visible data
- **Zoom Buttons**
  - `buttons.enabled` (boolean, default: true) - Show zoom control buttons
  - `buttons.visible` (string) - Button visibility: 'always', 'zoomed', 'hover'
  - `buttons.buttons[]` - Custom button configuration array
    - `icon` - Button icon name
    - `tooltip` - Hover tooltip text
    - `value` - Button action value
    - `label` - Button label text
    - `section` - Button grouping section

#### Navigator Options
**`AgNavigatorOptions`** - Timeline/range navigation
- `enabled` (boolean) - Enable navigator
- `height` (PixelSize) - Navigator height in pixels
- `cornerRadius` (number) - Corner radius for visual styling
- `spacing` (PixelSize) - Distance from bottom axis
- **Navigator Mask**
  - `mask.fill` - Mask fill color
  - `mask.fillOpacity` - Mask transparency
  - `mask.strokeWidth` - Border width
- **Navigator Handles**
  - `minHandle` / `maxHandle` - Left/right drag handles
    - `fill` - Handle fill color
    - `stroke` - Handle stroke color
    - `width` - Handle width
    - `height` - Handle height
    - `strokeWidth` - Handle border width
    - `gripLineWidth` - Grip line width
    - `gripLineGap` - Gap between grip lines
- **Mini Chart**
  - `miniChart.enabled` (boolean) - Show mini chart overview
  - `miniChart.label` - Mini chart axis labels configuration
    - `fontSize` - Label font size
    - `fontWeight` - Label font weight
  - `miniChart.showInMiniChart` - Per-series mini chart visibility

#### Context Menu Options
**`AgContextMenuOptions`** - Right-click context menus
- `enabled` (boolean, default: true) - Enable context menu
- `items[]` (AgContextMenuItem[]) - Menu items array
  - Built-in string values:
    - `'defaults'` - All default items
    - `'separator'` - Horizontal divider
    - `'toggle-series-visibility'` - For legend items
    - `'toggle-other-series'` - For legend items in multi-series
    - `'zoom-to-cursor'` - With zoom enabled
    - `'pan-to-cursor'` - With zoom enabled
    - `'reset-zoom'` - With zoom enabled
    - `'download'` - Download chart
  - Custom actions with `showOn` conditions:
    - `'always'` - Always shown
    - `'series-area'` - In series plot area
    - `'series-node'` - On data point/node
    - `'legend-item'` - On legend item
  - Sub-menu support via nested `items` property

### Navigator Configuration
**`AgNavigatorOptions`** with State Management
- Save, restore, and programmatically initialize zoom state
- Integration with Chart State API

### Chart Synchronization
**`AgChartSyncOptions`** - Synchronize multiple charts
- Coordinate zoom, pan, and data updates across multiple chart instances

### Range Buttons
**`AgRangesOptions`** - Time range selection buttons
- Pre-configured time period buttons (e.g., 1D, 5D, 1M, 3M, 1Y)
- Commonly used with financial charts

### Data Source Options
**`AgDataSourceOptions`** - Asynchronous data loading
- `getData()` callback for lazy-loading data
- Integration with zoom for progressive data loading
- Parameters: `windowStart`, `windowEnd` for time-windowed data

### Financial Chart Specific Options
**`AgFinancialChartOptions`** - Pre-configured financial charts
- Built-in OHLCV data handling
- Integrated toolbar with chart type selection
- Annotations and trend line management
- Pre-optimized for candlestick, OHLC, and line series

## Enterprise Series Options

All enterprise series types support:
- Standard series properties (xKey, yKey, data, etc.)
- `strokeWidth` - Line/border thickness
- `fillOpacity` - Fill transparency
- `label` - Data labels configuration
- `tooltip` - Custom tooltip formatting
- `highlightStyle` - Highlight styling on hover
- `hideInLegend` - Control legend visibility
- `showInMiniChart` - Mini chart visibility (Navigator)

## Enterprise Axes

### Specialized Axis Types
- **Time/Date Axes** - For financial and time-series charts
- **Log Scale Axes** - For logarithmic visualization
- **Radial Axes** - For gauge and radar charts
- **Category Axes** - For categorical data

### Axis Options (Enterprise)
- `min` / `max` - Axis range control
- `tick.maxSpacing` - Dynamic tick spacing with zoom
- Date formatting for time axes
- Radial positioning for gauge charts

## Enterprise Annotations

**`AgAnnotationsOptions`** - Chart annotations and drawings
- **Trend Lines** - Draw trend lines on financial charts
- **Text Annotations** - Add text labels to charts
- Financial chart toolbar for interactive drawing
- Save/restore annotations via state API

## Enterprise UI Components

### Background Images
- Add branded background images to charts
- Position and opacity control

### Overlays
**`AgChartOverlaysOptions`** - HTML overlay elements
- Custom overlays within chart area
- Integration with chart events

### Advanced Highlighting
**`AgChartHighlightOptions`** - Enhanced highlighting
- Cross-hair cursors on hover
- Multi-series highlighting
- Customizable highlight styling

### Gradient Legend
**`AgGradientLegendOptions`** - Color gradient visualization
- Continuous color legends for heat maps and similar charts
- Range and scale configuration

## Enterprise Keyboard & Touch

### Keyboard Navigation
**`AgKeyboardOptions`** - Advanced keyboard controls
- Navigation between chart elements
- Zoom in/out shortcuts (+ and -)
- Custom key bindings

### Touch Input
**`AgTouchOptions`** - Enhanced touch interactions
- Multi-touch zoom and pan
- Touch-optimized UI elements
- Long-press handling

## Enterprise State Management

### Chart State API
**`AgInitialStateOptions`** - Save and restore chart state
- Zoom level and position
- Navigator position
- Series visibility
- Annotation state
- Serializable value for persistence

## Enterprise Locale & Formatting

**`AgLocaleOptions`** - Advanced localization
- 31+ language support
- Localization engine integration
- Custom number and date formatting

**`FormatterConfiguration`** - Global formatting
- Number formatting for financial values
- Date/time formatting
- Currency formatting

## Enterprise Utilities

### Listeners/Events
**`AgBaseChartListeners`** - Enterprise event handlers
- Advanced event handling for interactions
- Zoom/pan event callbacks
- Context menu event callbacks

## Limitations & Notes

- **Watermark Behavior**: Enterprise features display with watermark if license key not installed
- **Local Testing**: No license key required for local development/testing
- **Production Licensing**: Requires valid commercial license for production use
- **console messages**: Warning messages appear in console without valid license

## Integration Points

All enterprise features integrate with:
- **Angular** via `ag-charts-angular` package
- **TypeScript** type safety via `AgChartOptions` and specialized interfaces
- **Chart State API** for serialization and persistence
- **Events API** for interactive event handling
- **Download API** for chart image export

## Related Documentation

- See parent project `IMPLEMENTATION.md` for Java/JWebMP integration
- Refer to `docs/architecture/` for sequence diagrams and component models
- Check `rules/generative/` for code generation guidelines

