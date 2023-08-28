package org.steveklewis.stevecloak.events;

import org.keycloak.events.Event;
import org.keycloak.events.EventListenerProvider;
import org.keycloak.events.admin.AdminEvent;
import org.keycloak.models.KeycloakSession;

public class OnRegisterEventListenerProvider implements EventListenerProvider {

    KeycloakSession session;
    public OnRegisterEventListenerProvider(KeycloakSession session) {
        this.session = session;
    }

    @Override
    public void onEvent(Event event) {

    }

    @Override
    public void onEvent(AdminEvent adminEvent, boolean b) {

    }
    @Override
    public void close() {

    }
}
