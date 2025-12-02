package com.jwebmp.plugins.agchartsenterprise.implementations;

import com.guicedee.client.services.config.IGuiceScanModuleInclusions;

import java.util.Set;

public class AgChartsEnterpriseModuleScanInclusion implements IGuiceScanModuleInclusions<AgChartsEnterpriseModuleScanInclusion>
{
    @Override
    public Set<String> includeModules()
    {
        return Set.of("com.jwebmp.plugins.agchartsenterprise");
    }
}
