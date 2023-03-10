/*
 * Copyright 2023 VMware, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.micrometer.tracing.annotation;

import org.aopalliance.intercept.MethodInvocation;
import org.aspectj.lang.ProceedingJoinPoint;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Method;

class SpanAspectMethodInvocation implements MethodInvocation {

    private final ProceedingJoinPoint pjp;

    private final Method method;

    SpanAspectMethodInvocation(ProceedingJoinPoint pjp, Method method) {
        this.pjp = pjp;
        this.method = method;
    }

    @Override
    public Method getMethod() {
        return method;
    }

    @Override
    public Object[] getArguments() {
        return pjp.getArgs();
    }

    @Override
    public Object proceed() throws Throwable {
        return pjp.proceed();
    }

    @Override
    public Object getThis() {
        return pjp.getThis();
    }

    @Override
    public AccessibleObject getStaticPart() {
        return getMethod();
    }

    ProceedingJoinPoint getPjp() {
        return pjp;
    }

}
