package com.example.spock.demo_30_fixtures;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;

public class PersonTemplateLoader implements TemplateLoader {

    @Override
    public void load() {
        Fixture.of(ImmutablePerson.class).addTemplate("valid", new Rule(){{
            add("name", random("Anderson Parra", "Arthur Hirata"));
            add("address", one(ImmutableAddress.class, "valid"));
        }});

        Fixture.of(ImmutablePerson.class).addTemplate("invalid", new Rule(){{
            add("name", random("", "N§me"));
            add("address", one(ImmutableAddress.class, "valid"));
        }});
    }
}
