package com.spending.fin.hub.mock.testdata;


import java.util.List;
import java.util.Map;

public class FinHubMockServiceTestData {


    public static final List<String> userCategoriesRequests = List.of("""
              {
                  "data": {
                       "customerId": "1234567890",
                       "period": "2024-04",
                       "customerInfo": {
                            "postCode": "E71AA",
                            "age": 30,
                            "profession": "Software Engineer",
                            "totalIncome": 100000.02,
                            "noOfDependents": 1,
                            "noOfChildren": 1,
                            "highNetworthIndicator": 30,
                            "martialStatus": "Married"
                            }
                       }
              }
            """, """
              {
                  "data": {
                       "customerId": "1234567890",
                       "period": "2024-04",
                       "customerInfo": {
                            "postCode": "E71AA",
                            "age": 30,
                            "profession": "Software Engineer"
                            }
                       }
              }
            """, """
              {
                  "data": {
                       "customerId": "1234567890",
                       "period": "2024-04"
                  }
              }
            """
    );


    public static final List<String> userCategoriesCustomerNotFoundRequests = List.of("""
              {
                  "data": {
                       "customerId": "0123456789",
                       "period": "2024-04",
                       "customerInfo": {
                            "postCode": "E71AA",
                            "age": 30,
                            "profession": "Software Engineer",
                            "totalIncome": 100000.02,
                            "noOfDependents": 1,
                            "noOfChildren": 1,
                            "highNetworthIndicator": 30,
                            "martialStatus": "Married"
                            }
                       }
              }
            """
    );

    public static final List<String> userCategoriesInvalidRequests = List.of("""
                      {
                          "data": {
                               "customerId": "1234567890",
                               "customerInfo": {
                                    "postCode": "E71AA",
                                    "age": 30,
                                    "profession": "Software Engineer",
                                    "totalIncome": 100000.02,
                                    "noOfDependents": 1,
                                    "noOfChildren": 1,
                                    "highNetworthIndicator": 30,
                                    "martialStatus": "Married"
                                    }
                               }
                      }
                    """, """
                      {
                          "data": {
                               "period": "2024-04",
                               "customerInfo": {
                                    "postCode": "E71AA",
                                    "age": 30,
                                    "profession": "Software Engineer",
                                    "totalIncome": 100000.02,
                                    "noOfDependents": 1,
                                    "noOfChildren": 1,
                                    "highNetworthIndicator": 30,
                                    "martialStatus": "Married"
                                    }
                               }
                      }
                    """, """
                      {
                          "data": {
                               "customerId": "1234567890",
                               "period": "2024-04",
                               "customerInfo": {
                                    "postCode": "E71AA",
                                    "age": 30,
                                    "profession": "Software Engineer"
                                    }
                               }
                      }
                    """, """
                      {
                          "data": {
                               "customerId": "1234567890"
                          }
                      }
                    """
            , """
                      {
                          "data": {
                               "period": "2024-04"
                          }
                      }
                    """, """
                      {
                          "data": {
                               "customerId": "1234567890",
                               "period": "2029-04"
                          }
                      }
                    """
    );


    public static final String categoriesSuccessResponse = """
              {
                  "data": {
                        "period": "2024-04",
                        "averageSpend": 500,
                        "categories": [{
                          "categoryId": "category-1",
                           "customerAmount": 500,
                           "clusterAvgAmount": 6000
                           }
                       }
              }    
            """;


    public static String userSuggestionSuccessRequest = """
            {
              "data": {
                "customerId": "1234567890",
                "period": "2024-04",
                "categoryId": "category-1234"
              }
            }
            """;

    public static String userSuggestionCustomerNotFoundRequest = """
            {
              "data": {
                "customerId": "1234567890",
                "period": "2024-04",
                "categoryId": "category-1234"
              }
            }
            """;

    public static Map<String, String> userSuggestionInvalidRequests = Map.of(
            "customerId Required",
            """
              {
              "data": {
                "period": "2024-04",
                "categoryId": "category-1234"
              }
            }
            """,
            "period Required",
            """
              {
              "data": {
                "customerId": "1234567890",
                "categoryId": "category-1234"
              }
            }
            """,
            "categoryId Required",
            """
              {
              "data": {
                "customerId": "1234567890",
                "period": "2024-04"
              }
            }
            """
    );


    public static final String suggestionsSuccessResponse = """
              {
                 "data": {
                   "period": "2024-04",
                   "noOfTransactions": 10,
                   "topMerchant": {
                     "merchantId": "merchant-1",
                     "merchantName": "Tescon",
                     "merchantTotalAmount": 1000.2
                   },
                   "suggestions": [
                     {
                       "url": "https://api.random.com/uri",
                       "description": "Google",
                       "cashbackAmout": 100
                     }
                   ]
                 }
               }    
            """;



    public static final String customerSegmentRequest = """
            {
              "data": {
                   "age": 30 
              }
            }
            """;

    public static final String customerSegmentResponse = """
            {
              "data": {
                "clusterId": "cluster-id-011"
              }
            }
            """;



    public static final String errorMessage(int errorCode, String id, String message) {
        return "{\"error\":\"{ \"code\":  " + errorCode + ",\"id\": " + id + ",\"message\": " + message + "}\"}";
    }

}
