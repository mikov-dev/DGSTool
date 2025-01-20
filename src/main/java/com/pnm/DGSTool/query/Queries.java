package com.pnm.DGSTool.query;

import org.intellij.lang.annotations.Language;

public class Queries {
    @Language("GraphQL")
    public String titleQuery = "query MyQuery {\n" +
            "  shows(titleFilter: \"Ozark\") {\n" +
            "    releaseYear\n" +
            "    title\n" +
            "  }\n" +
            "}";
}
