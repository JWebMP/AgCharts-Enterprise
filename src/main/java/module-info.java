import com.guicedee.guicedinjection.interfaces.IGuiceScanModuleInclusions;
import com.jwebmp.core.services.IPageConfigurator;
import com.jwebmp.plugins.agchartsenterprise.AgChartsEnterprisePageConfigurator;
import com.jwebmp.plugins.agchartsenterprise.implementations.AgChartsEnterpriseModuleScanInclusion;

module com.jwebmp.plugins.agchartsenterprise {
    exports com.jwebmp.plugins.agchartsenterprise;
    exports com.jwebmp.plugins.agchartsenterprise.options.gauge;
    exports com.jwebmp.plugins.agchartsenterprise.options.axes;
    exports com.jwebmp.plugins.agchartsenterprise.options.series;

    requires transitive com.jwebmp.plugins.agcharts;

    requires com.jwebmp.client;
    requires com.jwebmp.core;
    requires com.jwebmp.core.angular;
    requires com.guicedee.guicedinjection;
    requires com.fasterxml.jackson.databind;
    requires static lombok;

    provides IPageConfigurator with AgChartsEnterprisePageConfigurator;
    provides IGuiceScanModuleInclusions with AgChartsEnterpriseModuleScanInclusion;

    opens com.jwebmp.plugins.agchartsenterprise to com.google.guice, com.fasterxml.jackson.databind, com.jwebmp.core;
    opens com.jwebmp.plugins.agchartsenterprise.implementations to com.google.guice;
    opens com.jwebmp.plugins.agchartsenterprise.options.gauge to com.google.guice, com.fasterxml.jackson.databind, com.jwebmp.core;
    opens com.jwebmp.plugins.agchartsenterprise.options.axes to com.google.guice, com.fasterxml.jackson.databind, com.jwebmp.core;
    opens com.jwebmp.plugins.agchartsenterprise.options.series to com.google.guice, com.fasterxml.jackson.databind, com.jwebmp.core;

}