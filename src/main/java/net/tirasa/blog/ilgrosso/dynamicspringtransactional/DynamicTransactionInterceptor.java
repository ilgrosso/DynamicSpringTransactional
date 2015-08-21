/*
 * Copyright (C) 2015 Tirasa
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
package net.tirasa.blog.ilgrosso.dynamicspringtransactional;

import java.lang.reflect.Method;
import org.springframework.transaction.interceptor.DefaultTransactionAttribute;
import org.springframework.transaction.interceptor.TransactionAttribute;
import org.springframework.transaction.interceptor.TransactionAttributeSource;
import org.springframework.transaction.interceptor.TransactionInterceptor;

public class DynamicTransactionInterceptor extends TransactionInterceptor {

    private static final long serialVersionUID = -2640988503291060639L;

    @Override
    public TransactionAttributeSource getTransactionAttributeSource() {
        final TransactionAttributeSource origTxAttrSource = super.getTransactionAttributeSource();

        return new TransactionAttributeSource() {

            @Override
            public TransactionAttribute getTransactionAttribute(final Method method, final Class<?> targetClass) {
                TransactionAttribute txAttr = origTxAttrSource.getTransactionAttribute(method, targetClass);

                if (txAttr instanceof DefaultTransactionAttribute) {
                    ((DefaultTransactionAttribute) txAttr).setQualifier(AuthContextUtils.getDomain());
                }

                return txAttr;
            }
        };
    }

    public static TransactionAttribute currentTransactionAttribute() {
        return currentTransactionInfo().getTransactionAttribute();
    }

}
