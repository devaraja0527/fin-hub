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
                            "highNetworthIndicator": "NO",
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
                            "highNetworthIndicator": "NO",
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
                                    "highNetworthIndicator": "NO",
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
                                    "highNetworthIndicator": "NO",
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
                        "categories": [{
                          "categoryId": "category:bills",
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
                "categoryId": "category:bills"
              }
            }
            """;

    public static String userSuggestionCustomerNotFoundRequest = """
            {
              "data": {
                "customerId": "1234567890",
                "period": "2024-04",
                "categoryId": "category:bills"
              }
            }
            """;

    public static Map<String, String> userSuggestionInvalidRequests = Map.of(
            "customerId Required",
            """
              {
              "data": {
                "period": "2024-04",
                "categoryId": "category:bills"
              }
            }
            """,
            "period Required",
            """
              {
              "data": {
                "customerId": "1234567890",
                "categoryId": "category:bills"
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
                     "merchantName": "Tesco",
                     "merchantTotalAmount": 1000.2
                   },
                   "suggestions": [
                     {
                       "url": "https://www.natwest.com/current-accounts/existing-customers/tastecard.html",
                       "description": "20%  discount \\\\n Multi Use",
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
