/*
 * Logback: the reliable, generic, fast and flexible logging framework.
 * Copyright (C) 1999-2015, QOS.ch. All rights reserved.
 *
 * This program and the accompanying materials are dual-licensed under
 * either the terms of the Eclipse Public License v1.0 as published by
 * the Eclipse Foundation
 *
 *   or (per the licensee's choosing)
 *
 * under the terms of the GNU Lesser General Public License version 2.1
 * as published by the Free Software Foundation.
 */
package io.dropwizard.request.logging;

import ch.qos.logback.access.spi.ServerAdapter;
import org.eclipse.jetty.http.HttpField;
import org.eclipse.jetty.http.HttpFields;
import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.Response;

import java.util.Map;
import java.util.stream.Collectors;

/**
 * A jetty specific implementation of the {@link ServerAdapter} interface.
 *
 * @author S&eacute;bastien Pennec
 * @author Ceki Gulcu
 */
public class JettyServerAdapter implements ServerAdapter {

    Request request;
    Response response;

    public JettyServerAdapter(Request jettyRequest, Response jettyResponse) {
        this.request = jettyRequest;
        this.response = jettyResponse;
    }

    @Override
    public long getContentLength() {
        return response.getContentCount();
    }

    @Override
    public int getStatusCode() {
        return response.getStatus();
    }

    @Override
    public long getRequestTimestamp() {
        return request.getTimeStamp();
    }

    @Override
    public Map<String, String> buildResponseHeaderMap() {
        HttpFields httpFields = response.getHttpFields();
        return httpFields.stream()
                .collect(Collectors.toMap(HttpField::getName, HttpField::getValue));
    }

}
