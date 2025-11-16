package com.jwebmp.plugins.agchartsenterprise.implementations;

import com.guicedee.guicedinjection.interfaces.IGuiceScanModuleInclusions;

import java.util.Set;

public class AgChartsEnterpriseModuleScanInclusion implements IGuiceScanModuleInclusions<AgChartsEnterpriseModuleScanInclusion>
{
    @Override
    public Set<String> includeModules()
    {
        return Set.of("com.jwebmp.plugins.agchartsenterprise");
    }
}
