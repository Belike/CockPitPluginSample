package org.example;

import org.camunda.bpm.cockpit.Cockpit;
import org.camunda.bpm.cockpit.db.QueryParameters;
import org.camunda.bpm.cockpit.db.QueryService;
import org.camunda.bpm.cockpit.plugin.spi.CockpitPlugin;
import org.camunda.bpm.cockpit.plugin.test.AbstractCockpitPluginTest;
import org.example.db.ProcessInstanceCountDto;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class SamplePluginTest extends AbstractCockpitPluginTest {

    @Test
    public void testPluginDiscovery() {
        CockpitPlugin samplePlugin = Cockpit.getRuntimeDelegate().getPluginRegistry().getPlugin("cockpit-plugin");
        Assert.assertNotNull(samplePlugin);
    }

    @Test
    public void testSampleQuery(){
        QueryService queryService = getQueryService();

        List<ProcessInstanceCountDto> instanceCounts = queryService.executeQuery("org.example.selectProcessInstanceCountsByProcessDefinition"
                ,new QueryParameters<ProcessInstanceCountDto>());

        Assert.assertEquals(0, instanceCounts.size());
    }
}
