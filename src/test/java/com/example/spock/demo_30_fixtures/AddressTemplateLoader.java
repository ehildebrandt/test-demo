package com.example.spock.demo_30_fixtures;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;

public class AddressTemplateLoader implements TemplateLoader {

    @Override
    public void load() {
        Fixture.of(ImmutableAddress.class)
            .addTemplate("valid",
                new Rule(){{
                    add("line1", random("Hauptstr. 15", "Berliner Str. 42"));
                    add("line2", random(String.class, null, "hinten links"));
            }});
    }

}
