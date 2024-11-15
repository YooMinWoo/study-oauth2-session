package com.example.OAuthSession.dto;

import java.util.Map;

public class GoogleResponse implements OAuth2Response{

    private final Map<String, Object> attribute;

    public GoogleResponse(Map<String, Object> attribute) {
        this.attribute = attribute;
    }

    @Override
    public String getProvider() {
        return "google";
    }

    @Override
    public String getProviderId() {
        return this.attribute.get("sub").toString();
    }

    @Override
    public String getEmail() {
        return this.attribute.get("email").toString();
    }

    @Override
    public String getName() {
        return this.attribute.get("name").toString();
    }
}
