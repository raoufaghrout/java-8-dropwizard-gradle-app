package com.helloworld.health;

import com.codahale.metrics.health.HealthCheck;

public class TemplateHealthCheck extends HealthCheck {

    private final String template;

    public TemplateHealthCheck(String template) {
        this.template = template;
    }

    @Override
    protected Result check() throws Exception {
        final String saying = String.format(template, "Test");

        if (!saying.contains("Test")) {
            return Result.unhealthy("Template doesn't include a name!");
        }

        return Result.healthy();
    }
}
