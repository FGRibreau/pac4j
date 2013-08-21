package org.pac4j.oauth.profile.facebook;

import org.pac4j.core.profile.converter.Converters;
import org.pac4j.oauth.profile.JsonHelper;
import org.pac4j.oauth.profile.JsonObject;

import com.fasterxml.jackson.databind.JsonNode;

/**
 * This class represents a Facebook page.
 *
 * @author Francois-Guillaume Ribreau
 */
public final class FacebookPage extends JsonObject {

    private String name;
    private String accessToken;
    private String category;
    private Long id;

    @Override
    protected void buildFromJson(final JsonNode json) {
        this.id = (Long) JsonHelper.convert(Converters.longConverter, json, "id");
        this.name = (String) JsonHelper.convert(Converters.stringConverter, json, "name");
        this.accessToken = (String) JsonHelper.convert(Converters.stringConverter, json, "access_token");
        this.category = (String) JsonHelper.convert(Converters.stringConverter, json, "category");
    }

    public Object getName() {
        return this.name;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public String getCategory() {
        return category;
    }

    public Long getId() {
        return id;
    }
}
