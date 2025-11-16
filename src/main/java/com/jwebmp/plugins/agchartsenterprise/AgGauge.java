package com.jwebmp.plugins.agchartsenterprise;

import com.guicedee.client.IGuiceContext;
import com.guicedee.guicedservlets.websockets.options.IGuicedWebSocket;
import com.jwebmp.core.base.ajax.AjaxCall;
import com.jwebmp.core.base.ajax.AjaxResponse;
import com.jwebmp.core.base.angular.client.DynamicData;
import com.jwebmp.core.base.angular.client.annotations.constructors.NgConstructorBody;
import com.jwebmp.core.base.angular.client.annotations.functions.NgAfterViewInit;
import com.jwebmp.core.base.angular.client.annotations.functions.NgOnDestroy;
import com.jwebmp.core.base.angular.client.annotations.references.NgComponentReference;
import com.jwebmp.core.base.angular.client.annotations.references.NgImportModule;
import com.jwebmp.core.base.angular.client.annotations.structures.NgField;
import com.jwebmp.core.base.angular.client.annotations.structures.NgMethod;
import com.jwebmp.core.base.angular.client.services.EventBusService;
import com.jwebmp.core.base.angular.client.services.interfaces.AnnotationUtils;
import com.jwebmp.core.base.angular.client.services.interfaces.INgComponent;
import com.jwebmp.core.base.angular.implementations.WebSocketAbstractCallReceiver;
import com.jwebmp.core.base.html.DivSimple;
import com.jwebmp.plugins.agchartsenterprise.options.gauge.AgRadialGaugeOptions;

import java.util.List;

/**
 * Base AG Gauge component for JWebMP (Enterprise - Radial Gauge).
 * Renders the <ag-gauge> Angular component and binds [options].
 */
@NgComponentReference(EventBusService.class)
@NgComponentReference(DynamicData.class)
@NgImportModule("AgChartsAngularModule")

// Angular glue
@NgField("private gaugeOpts: any; // holds the current gauge options")
@NgField("readonly handlerId : string;")
@NgConstructorBody("this.handlerId = this.generateHandlerId();")
@NgField("private subscriptionOptions?: Subscription;")

// Expose options getter
@NgMethod("gaugeOptions() { return this.gaugeOpts; }")

// visible check
@NgMethod("gaugeConfiguration() { return this.gaugeOpts != null; }")

// Subscribe to EventBus for options updates.
@NgMethod("initializeOptionsListener() {\n" +
        "  const observer = {\n" +
        "    next: (data: any) => this.handleOptionsEvent(data),\n" +
        "    error: (err: any) => console.error('[AgGauge] options listener error:', err),\n" +
        "    complete: () => console.log('[AgGauge] options listener completed'),\n" +
        "  };\n" +
        "  this.subscriptionOptions = this.eventBusService\n" +
        "    .listen(this.listenerName + 'Options', this.handlerId)\n" +
        "    .subscribe(observer);\n" +
        "}")

// Apply options payloads
@NgMethod("handleOptionsEvent(data: any) {\n" +
        "  try {\n" +
        "    const payload = typeof data === 'string' ? JSON.parse(data) : data;\n" +
        "    const options = payload && payload.out && payload.out[0] ? payload.out[0] : payload;\n" +
        "    this.gaugeOpts = options;\n" +
        "  } catch (e) {\n" +
        "    console.error('[AgGauge] Failed to parse options payload', e, data);\n" +
        "  }\n" +
        "}")

@NgMethod("fetchData() {\n" +
        "  this.eventBusService.send(this.listenerName + 'Options', {\n" +
        "    className: this.clazzName,\n" +
        "    listenerName: this.listenerName + 'Options'\n" +
        "  }, this.listenerName + 'Options');\n" +
        "}")

@NgAfterViewInit("this.initializeOptionsListener(); this.fetchData();")
@NgOnDestroy("this.subscriptionOptions?.unsubscribe(); this.eventBusService.unregisterListener(this.listenerName + 'Options', this.handlerId);")
public abstract class AgGauge<J extends AgGauge<J>> extends DivSimple<J> implements INgComponent<J>
{
    public AgGauge() {super();}

    public AgGauge(String id)
    {
        setID(id);
        setTag("ag-gauge");
        addAttribute("[options]", "gaugeOptions()");
        addAttribute("*ngIf", "gaugeConfiguration() && gaugeOptions()");

        addConfiguration(AnnotationUtils.getNgField("readonly listenerName = '" + getID() + "';"));
        addConfiguration(AnnotationUtils.getNgField("readonly clazzName = '" + getClass().getCanonicalName() + "';"));
        registerWebSocketListeners();
    }

    /**
     * Server-side: provide the initial gauge options.
     */
    public abstract AgRadialGaugeOptions<?> getInitialOptions();

    protected String getListenerNameOptions() {return getID() + "Options";}

    protected void registerWebSocketListeners()
    {
        if (!IGuicedWebSocket.isWebSocketReceiverRegistered(getListenerNameOptions()))
        {
            IGuicedWebSocket.addWebSocketMessageReceiver(new InitialOptionsReceiver(getListenerNameOptions(), getClass()));
        }
    }

    @Override
    public List<String> styles()
    {
        List<String> out = INgComponent.super.styles();
        out.add(":host { display: block; position: relative; }");
        return out;
    }

    /**
     * Receives initial options over WebSocket and returns them to the client.
     */
    private static class InitialOptionsReceiver extends WebSocketAbstractCallReceiver<InitialOptionsReceiver>
    {
        private String listenerName;
        private Class<? extends AgGauge> actionClass;

        public InitialOptionsReceiver() {}

        public InitialOptionsReceiver(String listenerName, Class<? extends AgGauge> actionClass)
        {
            this.listenerName = listenerName;
            this.actionClass = actionClass;
        }

        @Override
        public String getMessageDirector() {return listenerName;}

        @Override
        public io.smallrye.mutiny.Uni<AjaxResponse<?>> action(AjaxCall<?> call, AjaxResponse<?> response)
        {
            return io.smallrye.mutiny.Uni.createFrom()
                                         .item(() -> {
                                             try
                                             {
                                                 actionClass = (Class<? extends AgGauge>) Class.forName(call.getClassName());
                                                 Object ln = call.getUnknownFields() != null ? call.getUnknownFields()
                                                                                                   .get("listenerName") : null;
                                                 if (ln != null)
                                                 {
                                                     listenerName = ln.toString();
                                                 }
                                             }
                                             catch (ClassNotFoundException e)
                                             {
                                                 e.printStackTrace();
                                             }

                                             AgRadialGaugeOptions<?> initial = IGuiceContext.get(actionClass)
                                                                                            .getInitialOptions();
                                             if (initial == null)
                                             {
                                                 return null;
                                             }
                                             response.addDataResponse(listenerName, initial);
                                             return response;
                                         });
        }
    }
}
