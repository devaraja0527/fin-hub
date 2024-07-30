package com.spending.fin.hub.mock;

import org.mockserver.integration.ClientAndServer;
import org.mockserver.matchers.MatchType;
import org.mockserver.model.HttpRequest;


import static com.spending.fin.hub.mock.testdata.FinHubMockServiceTestData.categoriesSuccessResponse;
import static com.spending.fin.hub.mock.testdata.FinHubMockServiceTestData.customerSegmentRequest;
import static com.spending.fin.hub.mock.testdata.FinHubMockServiceTestData.customerSegmentResponse;
import static com.spending.fin.hub.mock.testdata.FinHubMockServiceTestData.errorMessage;
import static com.spending.fin.hub.mock.testdata.FinHubMockServiceTestData.suggestionsSuccessResponse;
import static com.spending.fin.hub.mock.testdata.FinHubMockServiceTestData.userCategoriesCustomerNotFoundRequests;
import static com.spending.fin.hub.mock.testdata.FinHubMockServiceTestData.userCategoriesInvalidRequests;
import static com.spending.fin.hub.mock.testdata.FinHubMockServiceTestData.userCategoriesRequests;
import static com.spending.fin.hub.mock.testdata.FinHubMockServiceTestData.userSuggestionCustomerNotFoundRequest;
import static com.spending.fin.hub.mock.testdata.FinHubMockServiceTestData.userSuggestionInvalidRequests;
import static com.spending.fin.hub.mock.testdata.FinHubMockServiceTestData.userSuggestionSuccessRequest;
import static org.mockserver.integration.ClientAndServer.startClientAndServer;
import static org.mockserver.model.HttpRequest.request;
import static org.mockserver.model.HttpResponse.response;
import static org.mockserver.model.JsonBody.json;
import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.HttpStatus.UNPROCESSABLE_ENTITY;

public class FinHubMockService {


    private static final int MOCK_SERVER_PORT = 9091;

    private static ClientAndServer hackathonMockServer = startClientAndServer(MOCK_SERVER_PORT);

    private static final String USER_CATEGORIES_ENDPOINT = "/insights/v1/user-categories";

    private static final String USER_SUGGESTIONS_ENDPOINT = "/insights/v1/user-suggestions";

    private static final String CUSTOMER_SEGMENT_ENDPOINT =  "/insights/v1.0/customer-segment";


    public void loadMockData() {

        //User Categories
        userCategoriesRequests.stream().forEach(
                request ->
                        mockServerExpectationSTRICT(USER_CATEGORIES_ENDPOINT, request, OK.value(), categoriesSuccessResponse)
        );

        userCategoriesInvalidRequests.stream().forEach(
                request ->
                        mockServerExpectationSTRICT(USER_CATEGORIES_ENDPOINT, request, BAD_REQUEST.value(),
                                errorMessage(BAD_REQUEST.value(), "id Required", BAD_REQUEST.name()))
        );

        userCategoriesCustomerNotFoundRequests.stream().forEach(
                request ->
                        mockServerExpectationSTRICT(USER_CATEGORIES_ENDPOINT, request, UNPROCESSABLE_ENTITY.value(),
                                errorMessage(UNPROCESSABLE_ENTITY.value(), "customer not found", UNPROCESSABLE_ENTITY.name()))
        );


        //User Suggestions
        mockServerExpectationSTRICT(USER_SUGGESTIONS_ENDPOINT, userSuggestionCustomerNotFoundRequest, UNPROCESSABLE_ENTITY.value(),
                errorMessage(UNPROCESSABLE_ENTITY.value(), "customer not found", UNPROCESSABLE_ENTITY.name()));


        userSuggestionInvalidRequests.entrySet().stream().forEach(
                entry -> mockServerExpectationSTRICT(USER_CATEGORIES_ENDPOINT, entry.getValue(), BAD_REQUEST.value(),
                        errorMessage(BAD_REQUEST.value(), entry.getKey(), BAD_REQUEST.name()))
        );

        mockServerExpectationSTRICT(USER_SUGGESTIONS_ENDPOINT, userSuggestionSuccessRequest, OK.value(), suggestionsSuccessResponse);

        //customer Segment
        mockServerExpectationMatching(CUSTOMER_SEGMENT_ENDPOINT, customerSegmentRequest, OK.value(), customerSegmentResponse);

    }


    protected static void mockServerExpectationSTRICT(final String path,
                                           final String body,
                                           final Integer statusCode,
                                           final String responseBody) {

        HttpRequest httpRequest = request().withMethod("POST").withPath(path).withBody(json(body, MatchType.STRICT));
        hackathonMockServer.clear(httpRequest);
        hackathonMockServer.when(httpRequest)
                .respond(response().withStatusCode(statusCode).withBody(json(responseBody)));
    }

    protected static void mockServerExpectationMatching(final String path,
                                                      final String body,
                                                      final Integer statusCode,
                                                      final String responseBody) {

        HttpRequest httpRequest = request().withMethod("POST").withPath(path).withBody(json(body, MatchType.ONLY_MATCHING_FIELDS));
        hackathonMockServer.clear(httpRequest);
        hackathonMockServer.when(httpRequest)
                .respond(response().withStatusCode(statusCode).withBody(json(responseBody)));
    }

}
