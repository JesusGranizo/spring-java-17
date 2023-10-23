package dev.jgranizo.inditex.launcher;

import dev.jgranizo.inditex.launcher.error.ErrorType;
import dev.jgranizo.inditex.definition.model.ErrorDefinition;
import dev.jgranizo.inditex.definition.model.PriceRequest;
import dev.jgranizo.inditex.definition.model.PriceResponse;
import org.junit.Test;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

//It's necessary to run the application before running this test
public class InditexTest {

    private String URL = "http://localhost:8080/v1/prices";

    private String CONTENT_TYPE = "application/json";

    @Test
    public void apiRestTestPrice1() throws Exception {

        PriceRequest priceRequest = new PriceRequest();
        PriceResponse priceResponse = new PriceResponse();

        // Test 1: Post en fecha 14-06-2020 10:00:00 para producto 35455 y brand 1
        priceRequest.setBrandId(1);
        priceRequest.setProductId(35455);
        priceRequest.setDate(OffsetDateTime.parse("2020-06-14T10:00:00Z"));

        HttpResponse<String> response = this.post(this.toJson(priceRequest));
        System.out.println(response.body());

        priceResponse.setBrandId(1);
        priceResponse.setProductId(35455);
        priceResponse.setPriceId(1);
        priceResponse.setStartDate(DateTimeFormatter.ISO_OFFSET_DATE_TIME.format(OffsetDateTime.parse("2020-06-14T00:00:00Z")));
        priceResponse.setEndDate(DateTimeFormatter.ISO_OFFSET_DATE_TIME.format(OffsetDateTime.parse("2020-12-31T23:59:59Z")));
        priceResponse.setPrice(35.5);
        priceResponse.setCurrency("EUR");

        assertThat(response.statusCode()).isEqualTo(200);
        assertThat(response.body()).isEqualTo(this.toJson(priceResponse));
    }

    @Test
    public void apiRestTestPrice2() throws Exception {

        PriceRequest priceRequest = new PriceRequest();
        PriceResponse priceResponse = new PriceResponse();

        // Test 2: Post en fecha 14-06-2020 16:00:00 para producto 35455 y brand 1
        priceRequest.setBrandId(1);
        priceRequest.setProductId(35455);
        priceRequest.setDate(OffsetDateTime.parse("2020-06-14T16:00:00Z"));

        HttpResponse<String> response = this.post(this.toJson(priceRequest));
        System.out.println(response.body());

        priceResponse.setBrandId(1);
        priceResponse.setProductId(35455);
        priceResponse.setPriceId(2);
        priceResponse.setStartDate(DateTimeFormatter.ISO_OFFSET_DATE_TIME.format(OffsetDateTime.parse("2020-06-14T15:00:00Z")));
        priceResponse.setEndDate(DateTimeFormatter.ISO_OFFSET_DATE_TIME.format(OffsetDateTime.parse("2020-06-14T18:30:00Z")));
        priceResponse.setPrice(25.45);
        priceResponse.setCurrency("EUR");

        assertThat(response.statusCode()).isEqualTo(200);
        assertThat(response.body()).isEqualTo(this.toJson(priceResponse));
    }

    @Test
    public void apiRestTestPrice3() throws Exception {

        PriceRequest priceRequest = new PriceRequest();
        PriceResponse priceResponse = new PriceResponse();

        // Test 3: Post en fecha 14-06-2020 21:00:00 para producto 35455 y brand 1
        priceRequest.setBrandId(1);
        priceRequest.setProductId(35455);
        priceRequest.setDate(OffsetDateTime.parse("2020-06-14T21:00:00Z"));

        HttpResponse<String> response = this.post(this.toJson(priceRequest));
        System.out.println(response.body());

        priceResponse.setBrandId(1);
        priceResponse.setProductId(35455);
        priceResponse.setPriceId(1);
        priceResponse.setStartDate(DateTimeFormatter.ISO_OFFSET_DATE_TIME.format(OffsetDateTime.parse("2020-06-14T00:00:00Z")));
        priceResponse.setEndDate(DateTimeFormatter.ISO_OFFSET_DATE_TIME.format(OffsetDateTime.parse("2020-12-31T23:59:59Z")));
        priceResponse.setPrice(35.5);
        priceResponse.setCurrency("EUR");

        assertThat(response.statusCode()).isEqualTo(200);
        assertThat(response.body()).isEqualTo(this.toJson(priceResponse));
    }

    @Test
    public void apiRestTestPrice4() throws Exception {

        PriceRequest priceRequest = new PriceRequest();
        PriceResponse priceResponse = new PriceResponse();

        // Test 4: Post en fecha 15-06-2020 10:00:00 para producto 35455 y brand 1
        priceRequest.setBrandId(1);
        priceRequest.setProductId(35455);
        priceRequest.setDate(OffsetDateTime.parse("2020-06-15T10:00:00Z"));

        HttpResponse<String> response = this.post(this.toJson(priceRequest));
        System.out.println(response.body());

        priceResponse.setBrandId(1);
        priceResponse.setProductId(35455);
        priceResponse.setPriceId(3);
        priceResponse.setStartDate(DateTimeFormatter.ISO_OFFSET_DATE_TIME.format(OffsetDateTime.parse("2020-06-15T00:00:00Z")));
        priceResponse.setEndDate(DateTimeFormatter.ISO_OFFSET_DATE_TIME.format(OffsetDateTime.parse("2020-06-15T11:00:00Z")));
        priceResponse.setPrice(30.5);
        priceResponse.setCurrency("EUR");

        assertThat(response.statusCode()).isEqualTo(200);
        assertThat(response.body()).isEqualTo(this.toJson(priceResponse));
    }

    @Test
    public void apiRestTestPrice5() throws Exception {

        PriceRequest priceRequest = new PriceRequest();
        PriceResponse priceResponse = new PriceResponse();

        // Test 5: Post en fecha 16-06-2020 21:00:00 para producto 35455 y brand 1
        priceRequest.setBrandId(1);
        priceRequest.setProductId(35455);
        priceRequest.setDate(OffsetDateTime.parse("2020-06-16T21:00:00Z"));

        HttpResponse<String> response = this.post(this.toJson(priceRequest));
        System.out.println(response.body());

        priceResponse.setBrandId(1);
        priceResponse.setProductId(35455);
        priceResponse.setPriceId(4);
        priceResponse.setStartDate(DateTimeFormatter.ISO_OFFSET_DATE_TIME.format(OffsetDateTime.parse("2020-06-15T16:00:00Z")));
        priceResponse.setEndDate(DateTimeFormatter.ISO_OFFSET_DATE_TIME.format(OffsetDateTime.parse("2020-12-31T23:59:59Z")));
        priceResponse.setPrice(38.95);
        priceResponse.setCurrency("EUR");

        assertThat(response.statusCode()).isEqualTo(200);
        assertThat(response.body()).isEqualTo(this.toJson(priceResponse));
    }

    @Test
    public void apiRestTestError404() throws Exception {

        PriceRequest priceRequest = new PriceRequest();
        ErrorDefinition error = new ErrorDefinition();

        // Test 6: Post a url no existente
        this.URL = "http://localhost:8080/v1/prices2";

        priceRequest.setBrandId(1);
        priceRequest.setProductId(35455);
        priceRequest.setDate(OffsetDateTime.parse("2020-06-16T21:00:00Z"));

        HttpResponse<String> response = this.post(this.toJson(priceRequest));
        System.out.println(response.body());

        error.setCode(ErrorType.NOT_FOUND.getCode());
        error.setMessage("The requested resource was not found.");

        assertThat(response.statusCode()).isEqualTo(ErrorType.NOT_FOUND.getHttpStatus().value());
        assertThat(response.body()).isEqualTo(this.toJson(error));
    }

    @Test
    public void apiRestTestError400() throws Exception {

        PriceRequest priceRequest = new PriceRequest();
        ErrorDefinition error = new ErrorDefinition();

        // Test 7: Post con parametros invalidos
        this.URL = "http://localhost:8080/v1/prices";

        priceRequest.setBrandId(null);
        priceRequest.setProductId(null);
        priceRequest.setDate(OffsetDateTime.parse("2020-06-16T21:00:00Z"));

        HttpResponse<String> response = this.post(this.toJson(priceRequest));
        System.out.println(response.body());

        error.setCode(ErrorType.INVALID_PARAMETERS.getCode());
        error.setMessage("Invalid parameters, brandId, productId and date are required");

        assertThat(response.statusCode()).isEqualTo(ErrorType.INVALID_PARAMETERS.getHttpStatus().value());
        assertThat(response.body()).isEqualTo(this.toJson(error));
    }

    @Test
    public void apiRestTestError415() throws Exception {

        PriceRequest priceRequest = new PriceRequest();
        ErrorDefinition error = new ErrorDefinition();

        // Test 8: Post con Content-Type incorrecto
        this.CONTENT_TYPE = "application/xml";

        priceRequest.setBrandId(1);
        priceRequest.setProductId(35455);
        priceRequest.setDate(OffsetDateTime.parse("2020-06-16T21:00:00Z"));

        HttpResponse<String> response = this.post(this.toJson(priceRequest));
        System.out.println(response.body());

        error.setCode(ErrorType.UNSUPPORTED_MEDIA_TYPE.getCode());
        error.setMessage("Content-Type: " + this.CONTENT_TYPE + " is not supported");

        assertThat(response.statusCode()).isEqualTo(ErrorType.UNSUPPORTED_MEDIA_TYPE.getHttpStatus().value());
        assertThat(response.body()).isEqualTo(this.toJson(error));

    }

    public HttpResponse<String> post(String json) throws Exception {

        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(this.URL))
                .header("Content-Type", this.CONTENT_TYPE)
                .POST(HttpRequest.BodyPublishers.ofString(json))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        return response;
    }

    private String toJson(ErrorDefinition error) {
        return "{" +
                "\"code\":\"" + error.getCode() + "\"," +
                "\"message\":\"" + error.getMessage() + "\"" +
                "}";
    }

    public String toJson(PriceRequest priceRequest) {
        return "{" +
                "\"brandId\":" + priceRequest.getBrandId() + "," +
                "\"productId\":" + priceRequest.getProductId() + "," +
                "\"date\":\"" + DateTimeFormatter.ISO_OFFSET_DATE_TIME.format(priceRequest.getDate()) + "\"" +
                "}";
    }

    public String toJson(PriceResponse priceResponse) {
        return "{" +
                "\"brandId\":" + priceResponse.getBrandId() + "," +
                "\"productId\":" + priceResponse.getProductId() + "," +
                "\"startDate\":\"" + priceResponse.getStartDate() + "\"," +
                "\"endDate\":\"" + priceResponse.getEndDate() + "\"," +
                "\"priceId\":" + priceResponse.getPriceId() + "," +
                "\"price\":" + priceResponse.getPrice() + "," +
                "\"currency\":\"" + priceResponse.getCurrency() + "\"" +
                "}";
    }
}
