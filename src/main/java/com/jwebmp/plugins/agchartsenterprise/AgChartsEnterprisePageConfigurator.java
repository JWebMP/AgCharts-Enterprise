package com.jwebmp.plugins.agchartsenterprise;

import com.jwebmp.core.base.angular.client.annotations.typescript.TsDependency;
import com.jwebmp.core.plugins.PluginInformation;
import com.jwebmp.core.plugins.PluginStatus;
import com.jwebmp.core.services.IPage;
import com.jwebmp.core.services.IPageConfigurator;
import lombok.Getter;
import lombok.Setter;

@PluginInformation(
        pluginName = "AG Charts Enterprise",
        pluginUniqueName = "ag-charts-enterprise",
        pluginDescription = "AG Charts Enterprise extension for JWebMP providing advanced chart types and features.",
        pluginVersion = "12.2.0",
        pluginCategories = "charts, graphing, data-viz, enterprise",
        pluginSubtitle = "Enterprise features for AG Charts",
        pluginSourceUrl = "https://www.ag-grid.com/charts/",
        pluginWikiUrl = "https://github.com/JWebMP/JWebMP-AgGrid/wiki",
        pluginGitUrl = "https://github.com/JWebMP/JWebMP",
        pluginIconUrl = "",
        pluginIconImageUrl = "",
        pluginOriginalHomepage = "https://www.ag-grid.com/charts/",
        pluginDownloadUrl = "https://mvnrepository.com/artifact/com.jwebmp.plugins/agcharts-enterprise",
        pluginGroupId = "com.jwebmp.plugins",
        pluginArtifactId = "agcharts-enterprise",
        pluginModuleName = "com.jwebmp.plugins.agchartsenterprise",
        pluginLastUpdatedDate = "2025-09-23",
        pluginStatus = PluginStatus.Released
)

@TsDependency(value = "ag-charts-enterprise", version = "^12.2.0")
@com.jwebmp.core.base.angular.client.annotations.boot.NgBootImportReference(value = "AgChartsEnterpriseModule", reference = "ag-charts-enterprise")
@com.jwebmp.core.base.angular.client.annotations.boot.NgBootImportReference(value = "AgChartsModule", reference = "ag-charts-angular")
public class AgChartsEnterprisePageConfigurator implements IPageConfigurator<AgChartsEnterprisePageConfigurator>
{
    @Getter
    @Setter
    private static String AG_CHARTS_LICENSE_KEY = "";

    @Override
    public IPage<?> configure(IPage<?> page)
    {
        // Angular handles resource loading via dependencies
        return page;
    }

    @Override
    public boolean enabled()
    {
        return true;
    }
}
