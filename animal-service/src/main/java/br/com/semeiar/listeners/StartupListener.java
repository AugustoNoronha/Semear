package br.com.semeiar.listeners;

import io.micronaut.context.event.ApplicationEventListener;
import io.micronaut.discovery.event.ServiceReadyEvent;
import jakarta.inject.Singleton;
import java.awt.Desktop;
import java.net.URI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Singleton
public class StartupListener implements ApplicationEventListener<ServiceReadyEvent> {
    private static final Logger LOG = LoggerFactory.getLogger(StartupListener.class);

    @Override
    public void onApplicationEvent(ServiceReadyEvent event) {
        try {
            int port = event.getSource().getPort();
            String swaggerUrl = "http://localhost:" + port + "/swagger-ui";
            LOG.info("Aplicação iniciada! Abrindo Swagger UI em: {}", swaggerUrl);
            
            if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
                Desktop.getDesktop().browse(new URI(swaggerUrl));
            } else {
                Runtime runtime = Runtime.getRuntime();
                String os = System.getProperty("os.name").toLowerCase();
                if (os.contains("win")) {
                    runtime.exec("rundll32 url.dll,FileProtocolHandler " + swaggerUrl);
                } else if (os.contains("mac")) {
                    runtime.exec("open " + swaggerUrl);
                } else if (os.contains("nix") || os.contains("nux")) {
                    runtime.exec("xdg-open " + swaggerUrl);
                }
            }
        } catch (Exception e) {
            LOG.error("Não foi possível abrir o navegador automaticamente.", e);
        }
    }
}
