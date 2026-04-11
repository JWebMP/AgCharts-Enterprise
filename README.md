# JWebMP AG Charts Enterprise

[![Maven Central](https://img.shields.io/maven-central/v/com.jwebmp.plugins/agcharts-enterprise)](https://central.sonatype.com/artifact/com.jwebmp.plugins/agcharts-enterprise)
[![License](https://img.shields.io/badge/License-Apache%202.0-blue)](https://www.apache.org/licenses/LICENSE-2.0)

![Java 25+](https://img.shields.io/badge/Java-25%2B-green)
![Modular](https://img.shields.io/badge/Modular-JPMS-green)
![Angular](https://img.shields.io/badge/Angular-20-DD0031?logo=angular)
![TypeScript](https://img.shields.io/badge/TypeScript-5-3178C6?logo=typescript)

<!-- Tech icons row -->
![AG Charts Enterprise](https://img.shields.io/badge/AG_Charts_Enterprise-13.1.0-0084FF)
![JWebMP](https://img.shields.io/badge/JWebMP-2.0-0A7)
![License Required](https://img.shields.io/badge/License-Required-red)

Enterprise charting extension for JWebMP adding advanced chart types, specialized visualizations, and financial charts. Extends the community AG Charts plugin with gauges, heatmaps, polar charts, hierarchical visualizations, and financial instruments.

Built on [AG Charts Enterprise 13.1.0](https://charts.ag-grid.com/javascript/license/) · [Angular 21](https://angular.dev/) · [JWebMP AG Charts](../agcharts/) · JPMS module `com.jwebmp.plugins.agchartsenterprise` · Java 25+

**Version: 13.1.0** — Enterprise-only chart types with CRTP fluent API and Angular 21 integration.

## 📦 Installation

```xml
<dependency>
  <groupId>com.jwebmp.plugins</groupId>
  <artifactId>agcharts-enterprise</artifactId>
  <version>2.0.0-RC3</version>
</dependency>
```

<details>
<summary>Gradle (Kotlin DSL)</summary>

```kotlin
implementation("com.jwebmp.plugins:agcharts-enterprise:2.0.0-RC3")
```
</details>

### License Requirement

**⚠️ AG Charts Enterprise requires a commercial license.** This plugin extends AG Charts Community with enterprise-only features.

- **Evaluation**: 30-day trial available from [AG Grid](https://www.ag-grid.com/license-pricing/)
- **Production**: Purchase commercial license for enterprise features
- **Setup**: Configure license key in Java application startup

```java
// Set license key in your application startup
AgChartsEnterprisePageConfigurator.setAG_CHARTS_LICENSE_KEY("YOUR_LICENSE_KEY_HERE");
```

Store license keys securely via environment variables or configuration management (see `.env.example`).

### NPM Dependencies

The plugin automatically includes AG Charts Enterprise dependencies:

```json
{
  "dependencies": {
    "ag-charts-enterprise": "^13.1.0"
  }
}
```

## ✨ Features

### Enterprise Chart Types

- **Financial Charts** — Candlestick, OHLC, Waterfall, Box Plot, Histogram
- **Gauges** — Radial and Linear gauges with segmentation, targets, and scales
- **Polar Charts** — Radial Column, Radial Bar, Nightingale, Radar (Line & Area)
- **Heatmaps** — Color-coded grid visualizations with gradient scales
- **Hierarchical Charts** — Treemap, Sunburst, Sankey, Chord
- **Specialized Visualizations** — Funnel charts, Range Area, Range Bar

### Core Features

- **CRTP Fluent Builders** — Type-safe, self-referencing fluent API for all enterprise options
- **Angular 21 Integration** — Seamless integration via JWebMP component annotations
- **TypeScript Generation** — Automatic type generation from Java models
- **Reactive Data Binding** — Real-time chart updates with Angular observables
- **Server-Side Configuration** — Define charts in Java with client-side rendering
- **Advanced Styling** — Custom colors, gradients, fills, and patterns
- **Interactive Features** — Tooltips, legends, zoom, pan, highlighting
- **JPMS Modular** — Full Java Platform Module System support

## 🚀 Quick Start

### Radial Gauge

```java
@NgComponent
public class DashboardGauge implements INgComponent<DashboardGauge> {

    @Override
    public String render() {
        AgRadialGaugeOptions<DashboardGauge> gauge = new AgRadialGaugeOptions<>(this)
            .setValue(75.0)
            .setScale(new AgRadialGaugeScale<>()
                .setMin(0)
                .setMax(100))
            .setBar(new AgRadialGaugeBarStyle<>()
                .setFill("#4CAF50"))
            .setLabel(new AgRadialGaugeLabelOptions<>()
                .setEnabled(true));

        return """
            <ag-radial-gauge [options]="gaugeOptions">
            </ag-radial-gauge>
            """;
    }
}
```

### Candlestick Chart (Financial)

```java
@NgComponent
public class StockChart implements INgComponent<StockChart> {

    @Override
    public String render() {
        AgFinancialChartOptions<StockChart> options = new AgFinancialChartOptions<>(this)
            .setData(stockPriceData)
            .setSeries(List.of(
                new AgCandlestickSeriesOptions<>()
                    .setXKey("date")
                    .setOpenKey("open")
                    .setHighKey("high")
                    .setLowKey("low")
                    .setCloseKey("close")
            ));

        return """
            <ag-charts-angular [options]="chartOptions">
            </ag-charts-angular>
            """;
    }
}
```

### Heatmap

```java
AgChartOptions<MyComponent> options = new AgChartOptions<>(this)
    .setData(heatmapData)
    .setSeries(List.of(
        new AgHeatmapSeriesOptions<>()
            .setXKey("month")
            .setYKey("department")
            .setColorKey("sales")
    ))
    .setGradientLegend(new AgGradientLegendOptions<>()
        .setEnabled(true));
```

## 📐 Architecture

### Enterprise Chart Types

#### Financial Charts

| Chart Type | Use Case |
|---|---|
| **Candlestick** | OHLC stock prices with body/wick visualization |
| **OHLC** | Open-High-Low-Close financial data |
| **Waterfall** | Sequential value changes (revenue breakdown) |
| **Box Plot** | Statistical distribution (min, Q1, median, Q3, max) |
| **Histogram** | Frequency distribution with binning |

#### Gauges

| Gauge Type | Features |
|---|---|
| **Radial Gauge** | Circular gauge with needle, scale, targets, segmentation |
| **Linear Gauge** | Linear bar gauge with scale and targets |

#### Polar Charts

Radial Column, Radial Bar, Nightingale, Radar Line, Radar Area with specialized polar axes.

#### Hierarchical Visualizations

Treemap, Sunburst, Sankey, Chord, and Funnel charts for complex data relationships.

## 🔧 Configuration

### Gauge with Segmentation

```java
AgRadialGaugeOptions<MyComponent> gauge = new AgRadialGaugeOptions<>(this)
    .setValue(65.0)
    .setSegmentation(new AgGaugeSegmentation<>()
        .setEnabled(true)
        .setColorStops(List.of(
            new AgGaugeColorStop<>().setColor("#d32f2f"),
            new AgGaugeColorStop<>().setColor("#ffa726"),
            new AgGaugeColorStop<>().setColor("#4caf50")
        )));
```

## 🧪 Testing

```bash
# Run tests
mvn clean test -DskipITs=true

# Specific test
mvn test -Dtest=AgChartsEnterpriseTest
```

## 🗺️ Module Graph

```
com.jwebmp.plugins.agchartsenterprise
 ├── com.jwebmp.plugins.agcharts (AG Charts community base)
 ├── com.jwebmp.core (JWebMP core)
 └── com.jwebmp.core.angular (Angular integration)
```

## 📚 Documentation

### Project Documentation

- **Architecture**: `docs/architecture/README.md`

### Related Documentation

- **AG Charts Community**: [`../agcharts/README.md`](../agcharts/README.md)
- **JWebMP Core**: [`../../README.md`](../../README.md)

### External Resources

- [AG Charts Enterprise](https://charts.ag-grid.com/javascript/license/)
- [License Pricing](https://www.ag-grid.com/license-pricing/)

## 🤝 Contributing

- Follow CRTP pattern for enterprise options
- Test with valid enterprise license
- Document licensing requirements

## 📄 License

[Apache 2.0](https://www.apache.org/licenses/LICENSE-2.0)

**Note**: Requires commercial AG Charts Enterprise license for production. See [AG Grid Licensing](https://www.ag-grid.com/license-pricing/).

---

**JWebMP AG Charts Enterprise** — Advanced charting for enterprise Java applications.

Built with ❤️ using Java 25+, AG Charts Enterprise 13.1.0, Angular 21, and JPMS.
