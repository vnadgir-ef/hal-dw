package com.vnadgir.hal.api;

import javax.ws.rs.core.MediaType;

public class HalMediaType extends MediaType {

    public final static String APPLICATION_HAL_XML = "application/hal+xml";
    public final static String APPLICATION_HAL_XML_UTF8 = "application/hal+xml;charset=utf-8";
    public final static MediaType APPLICATION_HAL_XML_TYPE = new MediaType("application", "hal+xml");

    public final static String APPLICATION_HAL_JSON = "application/hal+json";
    public final static String APPLICATION_HAL_JSON_UTF8 = "application/hal+json;charset=utf-8";
    public final static MediaType APPLICATION_HAL_JSON_TYPE = new MediaType("application", "hal+json");

    public final static String TEXT_HTML_UTF8 = "text/html;charset=utf-8";
}

