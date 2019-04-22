package hello;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class GreetingController {


    private String baseURL = "http://services.runescape.com/m=itemdb_oldschool/api/catalogue/detail.json?item=";
    private static final String template = "Requesting item with id , %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/query")
    public Quote quote(@RequestParam(value="itemId", defaultValue="2") int itemId) {
        RestTemplate restTemplate = new RestTemplate();
        List<HttpMessageConverter<?>> messageConverters = new ArrayList<HttpMessageConverter<?>>();
        //Add the Jackson Message converter
        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        // Note: here we are making this converter to process any kind of response,
        // not only application/*json, which is the default behaviour
        converter.setSupportedMediaTypes(Collections.singletonList(MediaType.ALL));
        messageConverters.add(converter);
        restTemplate.setMessageConverters(messageConverters);

        //Coin[] coins = restTemplate.getForObject("https://api.coinmarketcap.com/v1/ticker/", Coin[].class);
        Quote quote = restTemplate.getForObject("http://services.runescape.com/m=itemdb_oldschool/api/catalogue/detail.json?item=2", Quote.class);
        //Quote itemQuote = restTemplate.getForObject(queryURL, Quote.class);
        //System.out.print(itemQuote.getItem().toString());
        return quote;
    }
}
