package com.ford.auto.support;

import java.text.MessageFormat;

public class PageWithUrlContainsNotFoundException extends InterruptedException{

        public String UrlExcerpt;
        public String ActualPageUrl;

        public PageWithUrlContainsNotFoundException(String UrlExcept, String ActualPageUrl, String message) {
            super("Excerpt:\"" + UrlExcept+ "\", ActualUrl:\""+ ActualPageUrl+"\", Message:\"" + message +"\"");
        }
}
