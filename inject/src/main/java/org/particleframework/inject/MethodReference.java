/*
 * Copyright 2017 original authors
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License. 
 */
package org.particleframework.inject;

import org.particleframework.core.annotation.AnnotationSource;
import org.particleframework.core.type.Argument;
import org.particleframework.core.type.ReturnType;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * A reference to a method
 *
 * @author Graeme Rocher
 * @since 1.0
 */
public interface MethodReference extends AnnotationSource {

    /**
     * The required argument types
     */
    Argument[] getArguments();

    /**
     * @return The target method
     */
    Method getTargetMethod();

    /**
     * @return Return the return type
     */
    ReturnType getReturnType();

    /**
     * @return The bean that declares this injection point
     */
    Class<?> getDeclaringType();

    /**
     * @return The name of the method
     */
    String getMethodName();

    /**
     * @return The argument types
     */
    default Class[] getArgumentTypes() {
        return Arrays.stream(getArguments())
                .map(Argument::getType)
                .toArray(Class[]::new);
    }

}