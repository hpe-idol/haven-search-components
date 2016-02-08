/*
 * Copyright 2015 Hewlett-Packard Development Company, L.P.
 * Licensed under the MIT License (the "License"); you may not use this file except in compliance with the License.
 */

package com.hp.autonomy.searchcomponents.hod.beanconfiguration;

import com.hp.autonomy.frontend.configuration.ConfigService;
import com.hp.autonomy.hod.client.api.resource.ResourceIdentifier;
import com.hp.autonomy.hod.client.api.resource.ResourcesService;
import com.hp.autonomy.hod.client.api.textindex.query.content.GetContentService;
import com.hp.autonomy.hod.client.api.textindex.query.parametric.GetParametricValuesService;
import com.hp.autonomy.hod.client.api.textindex.query.search.FindSimilarService;
import com.hp.autonomy.hod.client.api.textindex.query.search.QueryTextIndexService;
import com.hp.autonomy.hod.client.error.HodErrorException;
import com.hp.autonomy.hod.sso.HodAuthentication;
import com.hp.autonomy.searchcomponents.core.authentication.AuthenticationInformationRetriever;
import com.hp.autonomy.searchcomponents.core.databases.DatabasesService;
import com.hp.autonomy.searchcomponents.core.fields.FieldsService;
import com.hp.autonomy.searchcomponents.core.languages.LanguagesService;
import com.hp.autonomy.searchcomponents.core.parametricvalues.ParametricValuesService;
import com.hp.autonomy.searchcomponents.core.search.DocumentsService;
import com.hp.autonomy.searchcomponents.hod.configuration.QueryManipulationCapable;
import com.hp.autonomy.searchcomponents.hod.databases.Database;
import com.hp.autonomy.searchcomponents.hod.databases.HodDatabasesRequest;
import com.hp.autonomy.searchcomponents.hod.databases.HodDatabasesService;
import com.hp.autonomy.searchcomponents.hod.fields.HodFieldsRequest;
import com.hp.autonomy.searchcomponents.hod.languages.HodLanguagesService;
import com.hp.autonomy.searchcomponents.hod.parametricvalues.HodParametricRequest;
import com.hp.autonomy.searchcomponents.hod.parametricvalues.HodParametricValuesService;
import com.hp.autonomy.searchcomponents.hod.search.HodDocumentsService;
import com.hp.autonomy.searchcomponents.hod.search.HodSearchResult;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class DefaultHodConfiguration {
    @Bean
    @ConditionalOnMissingBean(LanguagesService.class)
    public LanguagesService languagesService() {
        return new HodLanguagesService();
    }

    @Bean
    @ConditionalOnMissingBean(DatabasesService.class)
    public DatabasesService<Database, HodDatabasesRequest, HodErrorException> databasesService(final ResourcesService resourcesService, final AuthenticationInformationRetriever<HodAuthentication> authenticationInformationRetriever) {
        return new HodDatabasesService(resourcesService, authenticationInformationRetriever);
    }

    @Bean
    @ConditionalOnMissingBean(DocumentsService.class)
    public DocumentsService<ResourceIdentifier, HodSearchResult, HodErrorException> documentsService(final FindSimilarService<HodSearchResult> findSimilarService, final ConfigService<? extends QueryManipulationCapable> configService, final QueryTextIndexService<HodSearchResult> queryTextIndexService, final GetContentService<HodSearchResult> getContentService, final AuthenticationInformationRetriever<HodAuthentication> authenticationInformationRetriever) {
        return new HodDocumentsService(findSimilarService, configService, queryTextIndexService, getContentService, authenticationInformationRetriever);
    }

    @Bean
    @ConditionalOnMissingBean(ParametricValuesService.class)
    public ParametricValuesService<HodParametricRequest, ResourceIdentifier, HodErrorException> parametricValuesService(final FieldsService<HodFieldsRequest, HodErrorException> fieldsService, final GetParametricValuesService getParametricValuesService, final ConfigService<? extends QueryManipulationCapable> configService, final AuthenticationInformationRetriever<HodAuthentication> authenticationInformationRetriever) {
        return new HodParametricValuesService(fieldsService, getParametricValuesService, configService, authenticationInformationRetriever);
    }
}
