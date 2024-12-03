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

package org.eclipse.edc.extension.policy;
import org.eclipse.edc.participant.spi.ParticipantAgentPolicyContext;
import org.eclipse.edc.policy.engine.spi.AtomicConstraintRuleFunction;
import org.eclipse.edc.policy.model.Operator;
import org.eclipse.edc.policy.model.Permission;
import org.eclipse.edc.spi.monitor.Monitor;

import java.util.Arrays;
import java.util.Objects;

import static java.lang.String.format;

public class LocationConstraintFactory {
    
    private final Monitor monitor;
    
    public LocationConstraintFactory(Monitor monitor) {
        this.monitor = monitor;
    }

    public <T extends ParticipantAgentPolicyContext> AtomicConstraintRuleFunction<Permission, T> generateRuleFunction() {
        return (Operator operator, Object rightValue, Permission rule, T context) -> {
            var country = context.participantAgent().getClaims().get("country");
        
            monitor.info(format("ParticipantAgent country claim: %s", country.toString()));
            monitor.info(format("Evaluating constraint: location %s %s", operator, rightValue.toString()));
            
            return switch (operator) {
                case EQ -> Objects.equals(country, rightValue);
                case NEQ -> !Objects.equals(country, rightValue);
                // case IN -> ((Collection<?>) rightValue).contains(country);
                case IN -> Arrays.stream(rightValue.toString().split(",")).map(String::trim).anyMatch(country::equals);
                case IS_NONE_OF -> !Arrays.stream(rightValue.toString().split(",")).map(String::trim).anyMatch(country::equals);
                default -> false;
            };
        };
    }

}
