package com.cve.reader.jsondb;

import com.cve.reader.jsondb.pojo.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JsonTester {

    private final String simpleTestCase = "{\n" +
            "  \"title\": \"hello World\",\n" +
            "  \"author\": \"steve jobs\"\n" +
            "}";

    private final String timeComplexCase = "{\n" +
            "  \"date\": \"2012-02-16T20:55Z\",\n" +
            "  \"author\": \"steve jobs\"\n" +
            "}";

    private final String listComplexCase = "{\n" +
            "  \"authorName\": \"steve Jobs\",\n" +
            "  \"books\": [\n" +
            "    {\n" +
            "      \"title\": \"title1\",\n" +
            "      \"inPrint\": \"False\",\n" +
            "      \"publishDate\": \"2017-02-16T23:55Z\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"title\": \"title2\",\n" +
            "      \"inPrint\": \"True\",\n" +
            "      \"publishDate\": \"2012-02-16T20:55Z\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"title\": \"title3\",\n" +
            "      \"inPrint\": \"True\",\n" +
            "      \"publishDate\": \"2012-02-16T20:55Z\"\n" +
            "    }\n" +
            "  ]\n" +
            "}";

    private final String nested = "{\n" +
            "  \"impact\": {\n" +
            "    \"baseMetricV2\": {\n" +
            "      \"cvssV2\": {\n" +
            "        \"version\": \"2.0\",\n" +
            "        \"vectorString\": \"AV:N/AC:M/Au:N/C:P/I:P/A:P\",\n" +
            "        \"accessVector\": \"NETWORK\",\n" +
            "        \"accessComplexity\": \"MEDIUM\",\n" +
            "        \"authentication\": \"NONE\",\n" +
            "        \"confidentialityImpact\": \"PARTIAL\",\n" +
            "        \"integrityImpact\": \"PARTIAL\",\n" +
            "        \"availabilityImpact\": \"PARTIAL\",\n" +
            "        \"baseScore\": 6.8\n" +
            "      },\n" +
            "      \"severity\": \"MEDIUM\",\n" +
            "      \"exploitabilityScore\": 8.6,\n" +
            "      \"impactScore\": 6.4,\n" +
            "      \"acInsufInfo\": false,\n" +
            "      \"obtainAllPrivilege\": false,\n" +
            "      \"obtainUserPrivilege\": false,\n" +
            "      \"obtainOtherPrivilege\": false,\n" +
            "      \"userInteractionRequired\": true\n" +
            "    }\n" +
            "  }\n" +
            "}";

    private final String entry1 = "{\n" +
            "    \"cve\" : {\n" +
            "      \"data_type\" : \"CVE\",\n" +
            "      \"data_format\" : \"MITRE\",\n" +
            "      \"data_version\" : \"4.0\",\n" +
            "      \"CVE_data_meta\" : {\n" +
            "        \"ID\" : \"CVE-2011-3016\",\n" +
            "        \"ASSIGNER\" : \"cve@mitre.org\"\n" +
            "      },\n" +
            "      \"problemtype\" : {\n" +
            "        \"problemtype_data\" : [ {\n" +
            "          \"description\" : [ {\n" +
            "            \"lang\" : \"en\",\n" +
            "            \"value\" : \"CWE-416\"\n" +
            "          } ]\n" +
            "        } ]\n" +
            "      },\n" +
            "      \"description\" : {\n" +
            "        \"description_data\" : [ {\n" +
            "          \"lang\" : \"en\",\n" +
            "          \"value\" : \"Use-after-free vulnerability in Google Chrome before 17.0.963.56 allows remote attackers to cause a denial of service or possibly have unspecified other impact via vectors involving counter nodes, related to a \\\"read-after-free\\\" issue.\"\n" +
            "        } ]\n" +
            "      }\n" +
            "    },\n" +
            "    \"configurations\" : {\n" +
            "      \"CVE_data_version\" : \"4.0\",\n" +
            "      \"nodes\" : [ {\n" +
            "        \"operator\" : \"OR\",\n" +
            "        \"cpe_match\" : [ {\n" +
            "          \"vulnerable\" : true,\n" +
            "          \"cpe23Uri\" : \"cpe:2.3:a:google:chrome:*:*:*:*:*:*:*:*\",\n" +
            "          \"versionEndExcluding\" : \"17.0.963.56\"\n" +
            "        } ]\n" +
            "      }, {\n" +
            "        \"operator\" : \"OR\",\n" +
            "        \"cpe_match\" : [ {\n" +
            "          \"vulnerable\" : true,\n" +
            "          \"cpe23Uri\" : \"cpe:2.3:a:apple:itunes:*:*:*:*:*:*:*:*\",\n" +
            "          \"versionEndExcluding\" : \"10.7\"\n" +
            "        }, {\n" +
            "          \"vulnerable\" : true,\n" +
            "          \"cpe23Uri\" : \"cpe:2.3:a:apple:safari:*:*:*:*:*:*:*:*\",\n" +
            "          \"versionEndExcluding\" : \"6.0\"\n" +
            "        }, {\n" +
            "          \"vulnerable\" : true,\n" +
            "          \"cpe23Uri\" : \"cpe:2.3:o:apple:iphone_os:*:*:*:*:*:*:*:*\",\n" +
            "          \"versionEndExcluding\" : \"6.0\"\n" +
            "        } ]\n" +
            "      } ]\n" +
            "    },\n" +
            "    \"impact\" : {\n" +
            "      \"baseMetricV2\" : {\n" +
            "        \"cvssV2\" : {\n" +
            "          \"version\" : \"2.0\",\n" +
            "          \"vectorString\" : \"AV:N/AC:M/Au:N/C:P/I:P/A:P\",\n" +
            "          \"accessVector\" : \"NETWORK\",\n" +
            "          \"accessComplexity\" : \"MEDIUM\",\n" +
            "          \"authentication\" : \"NONE\",\n" +
            "          \"confidentialityImpact\" : \"PARTIAL\",\n" +
            "          \"integrityImpact\" : \"PARTIAL\",\n" +
            "          \"availabilityImpact\" : \"PARTIAL\",\n" +
            "          \"baseScore\" : 6.8\n" +
            "        },\n" +
            "        \"severity\" : \"MEDIUM\",\n" +
            "        \"exploitabilityScore\" : 8.6,\n" +
            "        \"impactScore\" : 6.4,\n" +
            "        \"acInsufInfo\" : false,\n" +
            "        \"obtainAllPrivilege\" : false,\n" +
            "        \"obtainUserPrivilege\" : false,\n" +
            "        \"obtainOtherPrivilege\" : false,\n" +
            "        \"userInteractionRequired\" : true\n" +
            "      }\n" +
            "    },\n" +
            "    \"publishedDate\" : \"2012-02-16T20:55Z\",\n" +
            "    \"lastModifiedDate\" : \"2020-04-16T17:29Z\"\n" +
            "  }";

    @Test
    void simpleTestCase() throws JsonProcessingException {
        JsonNode node = Json.parse(simpleTestCase);
        assertEquals(node.get("title").asText(), "hello World");
    }

    @Test
    void fromJson() throws JsonProcessingException {
        JsonNode node = Json.parse(simpleTestCase);
        Pojo pojo = Json.fromJson(node, Pojo.class);

        assertEquals(pojo.getTitle(), "hello World");
    }

    @Test
    void toJson() {
        Pojo pojo = new Pojo();
        pojo.setTitle("Testing 1234");

        JsonNode node = Json.toJson(pojo);

        assertEquals(node.get("title").asText(), "Testing 1234");
    }

    @Test
    void stringConv() throws JsonProcessingException {
        Pojo pojo = new Pojo();
        pojo.setTitle("Testing 1234");

        JsonNode node = Json.toJson(pojo);
        System.out.println(Json.stringConv(node));
        System.out.println(Json.jsonFormat(node));
    }

    @Test
    void dataFormat() throws JsonProcessingException {
        JsonNode node = Json.parse(timeComplexCase);
        DatePojo pojo = Json.fromJson(node, DatePojo.class);
        System.out.println("DATE : " + pojo.getDate());

    }

    @Test
    void listComplexCase() throws JsonProcessingException {
        JsonNode node = Json.parse(listComplexCase);
        AuthorPojo pojo = Json.fromJson(node, AuthorPojo.class);

        System.out.println("Author : " + pojo.getAuthorName());
        for (BookPojo bp : pojo.getBooks()) {
            System.out.println("Book : " + bp.getTitle());
//            System.out.println("Available : " + bp.getInPrint());
            System.out.println("Date : " + bp.getPublishDate());
        }

    }

    @Test
    void nestedTestCase() throws JsonProcessingException {
        JsonNode node = Json.parse(nested);
        BaseMetricV2POJO pojo = Json.fromJson(node, BaseMetricV2POJO.class);

        System.out.println("severity : " + pojo.getSeverity());

    }

    @Test
    void extractData() throws JsonProcessingException {
        JsonNode node = Json.parse(entry1);
        DatePojo pojo = Json.fromJson(node, DatePojo.class);

        System.out.println("Date : " + pojo.getDate());

    }

}
