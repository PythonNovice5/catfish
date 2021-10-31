package com.basware.bttf.hooks;

import cucumber.api.Scenario;
import cucumber.api.java.Before;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class TagHooks
{
    List<String> forbiddenTags = Arrays.asList(
        "@productmanager_pricelists",
        "@nondestruct",
        "@navigation",
        "@products",
        "@menu_options_check_jupiter_only",
        "@destruct",
        "@itemTemplate",
        "@documents",
        "@bmecat",
        "@supplierAgreementDirectory",
        "@shopping_lists",
        "@shopping_checkout",
        "@shopping_basket",
        "@my_lists_and_organisation_lists",
        "@marketplace_searching",
        "@item_edit",
        "@item_directory",
        "@item_create",
        "@home",
        "@destructive"
    );

    @Before
    public void beforeTag( Scenario scenario )
    {
        Collection<String> tags = scenario.getSourceTagNames();

        List<String> intersect = tags.stream().filter(forbiddenTags::contains).collect(Collectors.toList());

        if( intersect.size() > 0 )
        {
            String message = String.format("The tag(s):\n\n %s\n\nare not currently supported - exiting.", String.join("\n ", intersect));

            System.out.println("\n-------------------------------------------------------------");
            System.out.println("-------------------------------------------------------------");

            System.out.println(message);

            System.out.println("-------------------------------------------------------------");
            System.out.println("-------------------------------------------------------------\n");
            System.exit(0);
        }
    }
}
