/*
 *  Copyright (c) 2024 Fraunhofer Institute for Software and Systems Engineering
 *
 *  This program and the accompanying materials are made available under the
 *  terms of the Apache License, Version 2.0 which is available at
 *  https://www.apache.org/licenses/LICENSE-2.0
 *
 *  SPDX-License-Identifier: Apache-2.0
 *
 *  Contributors:
 *       Fraunhofer Institute for Software and Systems Engineering - initial API and implementation
 *
 */

package org.eclipse.edc.extension.health;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import org.eclipse.edc.spi.monitor.Monitor;


/**
 * Controller to handle health check requests.
 * accessible via http://localhost:19191/api/health when configured in connector-example
 */
@Consumes("application/json")
@Produces("application/json")
@Path("/")
public class HealthApiController {

    private final Monitor monitor;

    public HealthApiController(Monitor monitor) {
        this.monitor = monitor;
    }

    @GET
    @Path("/health")
    public String getHealth() {
        monitor.info("Received a health check request.");
        return "{\"response\": \"I', alive\"}";
    }

}
