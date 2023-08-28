package org.steveklewis.stevecloak.events;

import org.jboss.logging.Logger;

import org.keycloak.events.Event;
import org.keycloak.events.EventListenerProvider;
import org.keycloak.events.EventType;
import org.keycloak.events.admin.AdminEvent;
import org.keycloak.models.KeycloakSession;
import org.keycloak.models.RealmModel;
import org.keycloak.models.UserModel;

public class OnRegisterEventListenerProvider implements EventListenerProvider {

    private static final Logger log = Logger.getLogger(OnRegisterEventListenerProvider.class);

    KeycloakSession session;
    public OnRegisterEventListenerProvider(KeycloakSession session) {
        this.session = session;
    }

    @Override
    public void onEvent(Event event) {
        if (event.getType().equals(EventType.REGISTER)) {
            log.info("RegisterEvent!");
            RealmModel realm = session.realms().getRealm(event.getRealmId());
            UserModel user = session.users().getUserById(realm, event.getUserId());
            log.info("User found: " + user.getUsername());
        } else {
            log.info("onEvent: " + event.getType().name());
        }
    }

    @Override
    public void onEvent(AdminEvent adminEvent, boolean b) {

    }
    @Override
    public void close() {

    }
}
