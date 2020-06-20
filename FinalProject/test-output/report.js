$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("/Users/danishdogra/eclipse-workspace/UrbanLadderPOM/src/main/java/FeaturesCucumber/UrbanLadderComplete.feature");
formatter.feature({
  "line": 1,
  "name": "Getting top five bookshelves and top three chairs",
  "description": "",
  "id": "getting-top-five-bookshelves-and-top-three-chairs",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "line": 2,
  "name": "Getting bookshelves data and study chairs data then saving it in Excel sheeet",
  "description": "",
  "id": "getting-top-five-bookshelves-and-top-three-chairs;getting-bookshelves-data-and-study-chairs-data-then-saving-it-in-excel-sheeet",
  "type": "scenario_outline",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 3,
  "name": "user is on application landing page",
  "keyword": "Given "
});
formatter.step({
  "line": 4,
  "name": "user verifies it is on application landing page",
  "keyword": "Then "
});
formatter.step({
  "line": 5,
  "name": "user enters the \"\u003cusername\u003e\" and \"\u003cpassword\u003e\"",
  "keyword": "Then "
});
formatter.step({
  "line": 6,
  "name": "user verifies sign in is successfull or not",
  "keyword": "Then "
});
formatter.step({
  "line": 7,
  "name": "user open the bookshelves page",
  "keyword": "Then "
});
formatter.step({
  "line": 8,
  "name": "user selects the price range",
  "keyword": "Then "
});
formatter.step({
  "line": 9,
  "name": "user selects the storage type as Open",
  "keyword": "Then "
});
formatter.step({
  "line": 10,
  "name": "user clicks on the top five bookshelves",
  "keyword": "Then "
});
formatter.step({
  "line": 11,
  "name": "user gets the data of top five bookshelves and store it in Excel sheet",
  "keyword": "Then "
});
formatter.step({
  "line": 12,
  "name": "user goes back to the homeoage",
  "keyword": "Then "
});
formatter.step({
  "line": 13,
  "name": "user open the chairs page",
  "keyword": "Then "
});
formatter.step({
  "line": 14,
  "name": "user clicks on the top three chairs",
  "keyword": "Then "
});
formatter.step({
  "line": 15,
  "name": "user gets the data of top three chairs and store it in Excel sheet",
  "keyword": "Then "
});
formatter.examples({
  "line": 18,
  "name": "",
  "description": "",
  "id": "getting-top-five-bookshelves-and-top-three-chairs;getting-bookshelves-data-and-study-chairs-data-then-saving-it-in-excel-sheeet;",
  "rows": [
    {
      "cells": [
        "username",
        "password"
      ],
      "line": 19,
      "id": "getting-top-five-bookshelves-and-top-three-chairs;getting-bookshelves-data-and-study-chairs-data-then-saving-it-in-excel-sheeet;;1"
    },
    {
      "cells": [
        "ddogra90@gmail.com",
        "M@nju_123"
      ],
      "line": 20,
      "id": "getting-top-five-bookshelves-and-top-three-chairs;getting-bookshelves-data-and-study-chairs-data-then-saving-it-in-excel-sheeet;;2"
    },
    {
      "cells": [
        "aayushijain0217@gmail.com",
        "Urban@123"
      ],
      "line": 21,
      "id": "getting-top-five-bookshelves-and-top-three-chairs;getting-bookshelves-data-and-study-chairs-data-then-saving-it-in-excel-sheeet;;3"
    }
  ],
  "keyword": "Examples"
});
formatter.before({
  "duration": 8276295388,
  "status": "passed"
});
formatter.scenario({
  "line": 20,
  "name": "Getting bookshelves data and study chairs data then saving it in Excel sheeet",
  "description": "",
  "id": "getting-top-five-bookshelves-and-top-three-chairs;getting-bookshelves-data-and-study-chairs-data-then-saving-it-in-excel-sheeet;;2",
  "type": "scenario",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 3,
  "name": "user is on application landing page",
  "keyword": "Given "
});
formatter.step({
  "line": 4,
  "name": "user verifies it is on application landing page",
  "keyword": "Then "
});
formatter.step({
  "line": 5,
  "name": "user enters the \"ddogra90@gmail.com\" and \"M@nju_123\"",
  "matchedColumns": [
    0,
    1
  ],
  "keyword": "Then "
});
formatter.step({
  "line": 6,
  "name": "user verifies sign in is successfull or not",
  "keyword": "Then "
});
formatter.step({
  "line": 7,
  "name": "user open the bookshelves page",
  "keyword": "Then "
});
formatter.step({
  "line": 8,
  "name": "user selects the price range",
  "keyword": "Then "
});
formatter.step({
  "line": 9,
  "name": "user selects the storage type as Open",
  "keyword": "Then "
});
formatter.step({
  "line": 10,
  "name": "user clicks on the top five bookshelves",
  "keyword": "Then "
});
formatter.step({
  "line": 11,
  "name": "user gets the data of top five bookshelves and store it in Excel sheet",
  "keyword": "Then "
});
formatter.step({
  "line": 12,
  "name": "user goes back to the homeoage",
  "keyword": "Then "
});
formatter.step({
  "line": 13,
  "name": "user open the chairs page",
  "keyword": "Then "
});
formatter.step({
  "line": 14,
  "name": "user clicks on the top three chairs",
  "keyword": "Then "
});
formatter.step({
  "line": 15,
  "name": "user gets the data of top three chairs and store it in Excel sheet",
  "keyword": "Then "
});
formatter.match({
  "location": "LandingPageSteps.user_is_on_application_landing_page()"
});
formatter.result({
  "duration": 6887601522,
  "status": "passed"
});
formatter.match({
  "location": "LandingPageSteps.user_verifies_it_is_on_application_home_page()"
});
formatter.result({
  "duration": 24139630,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "ddogra90@gmail.com",
      "offset": 17
    },
    {
      "val": "M@nju_123",
      "offset": 42
    }
  ],
  "location": "LandingPageSteps.user_enters_the_and(String,String)"
});
formatter.result({
  "duration": 10210932593,
  "status": "passed"
});
formatter.match({
  "location": "LandingPageSteps.user_verifies_sign_in_is_successfull_or_not()"
});
formatter.result({
  "duration": 8162958,
  "status": "passed"
});
formatter.match({
  "location": "HomePageSteps.user_open_the_bookshelves_page()"
});
formatter.result({
  "duration": 6942910981,
  "status": "passed"
});
formatter.match({
  "location": "BookshelvesSteps.user_selects_the_price_range_of()"
});
formatter.result({
  "duration": 4157563818,
  "status": "passed"
});
formatter.match({
  "location": "BookshelvesSteps.user_selects_the_storage_type_as_Open()"
});
formatter.result({
  "duration": 256219423,
  "status": "passed"
});
formatter.match({
  "location": "BookshelvesSteps.user_clicks_on_the_top_five_bookshelves()"
});
formatter.result({
  "duration": 20847528291,
  "status": "passed"
});
formatter.match({
  "location": "BookshelvesSteps.user_gets_the_data_of_top_five_bookshelves_and_store_it_in_Excel_sheet()"
});
formatter.result({
  "duration": 6222620719,
  "status": "passed"
});
formatter.match({
  "location": "BookshelvesSteps.user_goes_back_to_the_homeoage()"
});
formatter.result({
  "duration": 4847175434,
  "status": "passed"
});
formatter.match({
  "location": "HomePageSteps.user_open_the_chairs_page()"
});
formatter.result({
  "duration": 2000357089,
  "status": "passed"
});
formatter.match({
  "location": "StudyChairsSteps.user_clicks_on_the_top_three_chairs()"
});
formatter.result({
  "duration": 10511824877,
  "status": "passed"
});
formatter.match({
  "location": "StudyChairsSteps.user_gets_the_data_of_top_three_chairs_and_store_it_in_Excel_sheet()"
});
formatter.result({
  "duration": 3556136148,
  "status": "passed"
});
formatter.after({
  "duration": 267890019,
  "status": "passed"
});
formatter.before({
  "duration": 1850670089,
  "status": "passed"
});
formatter.scenario({
  "line": 21,
  "name": "Getting bookshelves data and study chairs data then saving it in Excel sheeet",
  "description": "",
  "id": "getting-top-five-bookshelves-and-top-three-chairs;getting-bookshelves-data-and-study-chairs-data-then-saving-it-in-excel-sheeet;;3",
  "type": "scenario",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 3,
  "name": "user is on application landing page",
  "keyword": "Given "
});
formatter.step({
  "line": 4,
  "name": "user verifies it is on application landing page",
  "keyword": "Then "
});
formatter.step({
  "line": 5,
  "name": "user enters the \"aayushijain0217@gmail.com\" and \"Urban@123\"",
  "matchedColumns": [
    0,
    1
  ],
  "keyword": "Then "
});
formatter.step({
  "line": 6,
  "name": "user verifies sign in is successfull or not",
  "keyword": "Then "
});
formatter.step({
  "line": 7,
  "name": "user open the bookshelves page",
  "keyword": "Then "
});
formatter.step({
  "line": 8,
  "name": "user selects the price range",
  "keyword": "Then "
});
formatter.step({
  "line": 9,
  "name": "user selects the storage type as Open",
  "keyword": "Then "
});
formatter.step({
  "line": 10,
  "name": "user clicks on the top five bookshelves",
  "keyword": "Then "
});
formatter.step({
  "line": 11,
  "name": "user gets the data of top five bookshelves and store it in Excel sheet",
  "keyword": "Then "
});
formatter.step({
  "line": 12,
  "name": "user goes back to the homeoage",
  "keyword": "Then "
});
formatter.step({
  "line": 13,
  "name": "user open the chairs page",
  "keyword": "Then "
});
formatter.step({
  "line": 14,
  "name": "user clicks on the top three chairs",
  "keyword": "Then "
});
formatter.step({
  "line": 15,
  "name": "user gets the data of top three chairs and store it in Excel sheet",
  "keyword": "Then "
});
formatter.match({
  "location": "LandingPageSteps.user_is_on_application_landing_page()"
});
formatter.result({
  "duration": 5285284136,
  "status": "passed"
});
formatter.match({
  "location": "LandingPageSteps.user_verifies_it_is_on_application_home_page()"
});
formatter.result({
  "duration": 8430932,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "aayushijain0217@gmail.com",
      "offset": 17
    },
    {
      "val": "Urban@123",
      "offset": 49
    }
  ],
  "location": "LandingPageSteps.user_enters_the_and(String,String)"
});
formatter.result({
  "duration": 18622894472,
  "status": "passed"
});
formatter.match({
  "location": "LandingPageSteps.user_verifies_sign_in_is_successfull_or_not()"
});
formatter.result({
  "duration": 11158486,
  "status": "passed"
});
formatter.match({
  "location": "HomePageSteps.user_open_the_bookshelves_page()"
});
formatter.result({
  "duration": 5260382192,
  "status": "passed"
});
formatter.match({
  "location": "BookshelvesSteps.user_selects_the_price_range_of()"
});
formatter.result({
  "duration": 4208406959,
  "status": "passed"
});
formatter.match({
  "location": "BookshelvesSteps.user_selects_the_storage_type_as_Open()"
});
formatter.result({
  "duration": 319170515,
  "status": "passed"
});
formatter.match({
  "location": "BookshelvesSteps.user_clicks_on_the_top_five_bookshelves()"
});
formatter.result({
  "duration": 20762617078,
  "status": "passed"
});
formatter.match({
  "location": "BookshelvesSteps.user_gets_the_data_of_top_five_bookshelves_and_store_it_in_Excel_sheet()"
});
formatter.result({
  "duration": 5979156345,
  "status": "passed"
});
formatter.match({
  "location": "BookshelvesSteps.user_goes_back_to_the_homeoage()"
});
formatter.result({
  "duration": 5542553958,
  "status": "passed"
});
formatter.match({
  "location": "HomePageSteps.user_open_the_chairs_page()"
});
formatter.result({
  "duration": 2112304448,
  "status": "passed"
});
formatter.match({
  "location": "StudyChairsSteps.user_clicks_on_the_top_three_chairs()"
});
formatter.result({
  "duration": 10428803276,
  "status": "passed"
});
formatter.match({
  "location": "StudyChairsSteps.user_gets_the_data_of_top_three_chairs_and_store_it_in_Excel_sheet()"
});
formatter.result({
  "duration": 4514737936,
  "status": "passed"
});
formatter.after({
  "duration": 210999182,
  "status": "passed"
});
});