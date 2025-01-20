package com.pnm.DGSTool;

import com.netflix.graphql.dgs.DgsQueryExecutor;
import com.pnm.DGSTool.data.ShowsDataFetcher;
import com.pnm.DGSTool.query.Queries;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import com.netflix.graphql.dgs.test.EnableDgsTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(classes = {ShowsDataFetcher.class})
@EnableDgsTest
class ShowsDataFetcherTest {

    @Autowired
    DgsQueryExecutor dgsQueryExecutor;

    Queries queries = new Queries();

    @Test
    void shows() {
        List<String> titles = dgsQueryExecutor.executeAndExtractJsonPath(
                queries.titleQuery,
                "data.shows[*].title");

        assertThat(titles).contains("Ozark");
    }
}